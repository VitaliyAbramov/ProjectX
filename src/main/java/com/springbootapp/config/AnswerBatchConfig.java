package com.springbootapp.config;

import com.springbootapp.entity.postgres.Answer;
import com.springbootapp.entity.postgres.DataEntity;
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
public class AnswerBatchConfig {

    private DataSource dataSource;
    private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    public AnswerBatchConfig(DataSource dataSource,
                            JobBuilderFactory jobBuilderFactory,
                            StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.dataSource = dataSource;
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public FlatFileItemReader<Answer> answerReader() {
        FlatFileItemReader<Answer> reader = new FlatFileItemReader<>();
//        reader.setLinesToSkip(1);
        reader.setResource(new ClassPathResource("csv/answers.csv"));
        reader.setLineMapper(new DefaultLineMapper() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("id", "answer");
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Answer>() {{
                setTargetType(Answer.class);
            }});
        }
        });
        return reader;
    }

    @Bean
    public ItemProcessor<Answer, Answer> answerProcessor() {
        return answer -> answer;
    }

    @Bean
    public JdbcBatchItemWriter<Answer> answerWriter() {
        JdbcBatchItemWriter<Answer> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO answer (answer_id, answer) VALUES (:id, :answer)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public Step answerStep() {
        return stepBuilderFactory.get("answerStep")
                .<Answer, Answer>chunk(2000)
                .reader(answerReader())
                .processor(answerProcessor())
                .writer(answerWriter())
                .build();
    }

    @Bean
    public Job importAnswerJob() {
        return jobBuilderFactory.get("importAnswerJob")
                .incrementer(new RunIdIncrementer())
                .flow(answerStep())
                .end()
                .build();
    }
}
