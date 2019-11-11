package com.springbootapp.config;

import com.springbootapp.entity.postgres.Answer;
import com.springbootapp.entity.postgres.DataEntity;
import com.springbootapp.entity.postgres.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Slf4j
@Configuration
@EnableBatchProcessing
public class UserBatchConfig {
    private DataSource dataSource;
    private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    public UserBatchConfig(DataSource dataSource,
                            JobBuilderFactory jobBuilderFactory,
                            StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.dataSource = dataSource;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public FlatFileItemReader<User> userReader() {
        FlatFileItemReader<User> reader = new FlatFileItemReader<>();
//        reader.setLinesToSkip(1);
        reader.setResource(new ClassPathResource("csv/users.csv"));
        reader.setLineMapper(new DefaultLineMapper() {{
                setLineTokenizer(new DelimitedLineTokenizer() {{
                    setNames("id", "firstName", "lastName", "birthday", "email", "phone", "country", "city", "address", "login", "password");
                }});
                setFieldSetMapper(new BeanWrapperFieldSetMapper<User>() {{
                    setTargetType(User.class);
                }});
            }
        });
        return reader;
    }

    @Bean
    public ItemProcessor<User, User> userProcessor() {
        return user -> user;
    }

    @Bean
    public JdbcBatchItemWriter<User> userWriter() {
        JdbcBatchItemWriter<User> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO test_user " +
                "(user_id, firstname, lastname, birthday, email, phone, country, city, address, login, password) " +
                "VALUES (:id, :firstName, :lastName, :birthday, :email, :phone, :country, :city, :address, :login, :password)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public Step userStep() {
        return stepBuilderFactory.get("userStep")
                .<User, User>chunk(2000)
                .reader(userReader())
                .processor(userProcessor())
                .writer(userWriter())
                .build();
    }

    @Bean
    public Job importUserJob() {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .flow(userStep())
                .end()
                .build();
    }
}
