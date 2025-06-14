package org.tamama.config;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
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
public class SpringBatchConfiguration {

    @Bean
    public Job simpleJob1(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
        return new JobBuilder("simpleJob", jobRepository)
                .start(simpleStep1(jobRepository, platformTransactionManager))
                    .on(ExitStatus.FAILED.getExitCode()) // Fail한 경우
                    .to(simpleStep1Failed(jobRepository, platformTransactionManager)) // failedTasklet으로 이동하여 실행
                    .on("*") // failedTasklet의 결과와 상관없이
                    .end() // 종료
                .from(simpleStep1(jobRepository, platformTransactionManager)) // simpleStep1으로부터
                    .on("*") // 앞서 설정한 Fail 제외하고
                    .to(simpleStep2(jobRepository, platformTransactionManager))
                    .on("*")  // simpleStep2 결과와 상관없이
                    .end() // 종료
                .end()
                .build();
    }

    @Bean
    public Step simpleStep1(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("simpleStep2", jobRepository)
                .tasklet(test1Tasklet(), platformTransactionManager)
                .build();
    }

    @Bean
    public Step simpleStep2(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("simpleStep2", jobRepository)
                .tasklet(test2Tasklet(), platformTransactionManager)
                .build();
    }

    @Bean
    public Step simpleStep1Failed(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("simpleStep1Failed", jobRepository)
                .tasklet(failedTasklet(), platformTransactionManager)
                .build();
    }

    @Bean
    public Tasklet test1Tasklet() {
        return ((contribution, chunkContext) -> {
            System.out.println("[SpringBatchConfiguration] test1 tasklet");
            return RepeatStatus.FINISHED;
        });
    }

    @Bean
    public Tasklet test2Tasklet() {
        return ((contribution, chunkContext) -> {
            System.out.println("[SpringBatchConfiguration] test2 tasklet");
            return RepeatStatus.FINISHED;
        });
    }

    @Bean
    public Tasklet failedTasklet() {
        return ((contribution, chunkContext) -> {
            System.out.println("[SpringBatchConfiguration] failed Tasklet");
            return RepeatStatus.FINISHED;
        });
    }




}
