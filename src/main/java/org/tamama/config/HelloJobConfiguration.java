//package org.tamama.config;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.PlatformTransactionManager;
//
//@Configuration
//public class HelloJobConfiguration {
//
//    @Bean
//    public Job simpleJob1(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//        return new JobBuilder("simpleJob", jobRepository)
//                .start(simpleStep1(jobRepository, platformTransactionManager))
//                .next(simpleStep2(jobRepository, platformTransactionManager))
//                .build();
//    }
//
//    @Bean
//    public Step simpleStep1(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//        return new StepBuilder("simpleStep1", jobRepository)
//                .tasklet(test1Tasklet(), platformTransactionManager)
//                .build();
//    }
//
//    @Bean
//    public Step simpleStep2(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//        return new StepBuilder("simpleStep2", jobRepository)
//                .tasklet(test2Tasklet(), platformTransactionManager)
//                .build();
//    }
//
//    @Bean
//    public Tasklet test1Tasklet() {
//        return ((contribution, chunkContext) -> {
//            System.out.println("test tasklet");
//            return RepeatStatus.FINISHED;
//        });
//    }
//
//    @Bean
//    public Tasklet test2Tasklet() {
//        return ((contribution, chunkContext) -> {
//            System.out.println("test tasklet");
//            return RepeatStatus.FINISHED;
//        });
//    }
//}
