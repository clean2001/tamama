package org.tamama.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class JobConfiguration {
    @Bean
    public Job job(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
        return new JobBuilder("job", jobRepository)
                .start(step1(jobRepository, platformTransactionManager))
                .next(step2(jobRepository, platformTransactionManager))
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("step1", jobRepository)
                .tasklet(tasklet1(), platformTransactionManager)
                .build();
    }


    @Bean
    public Step step2(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("step2", jobRepository)
                .tasklet(tasklet2(), platformTransactionManager)
                .build();
    }


    @Bean
    public Tasklet tasklet1() {
        return ((contribution, chunkContext) -> {
            System.out.println("[JobConfiguration] tasklet1");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            // JobParameters 접근
            JobParameters jobParameters = contribution.getStepExecution().getJobExecution().getJobParameters();
            System.out.println(jobParameters.getString("name"));
            return RepeatStatus.FINISHED;
        });
    }

    @Bean
    public Tasklet tasklet2() {
        return ((contribution, chunkContext) -> {
            System.out.println("[JobConfiguration] tasklet2");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            return RepeatStatus.FINISHED;
        });
    }


}
