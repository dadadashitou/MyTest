package com.test.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
// @PropertySource是找的target目录下classes目录下的文件，resources目录下的文件编译后会生成在classes目录
@PropertySource(value = {"classpath:application.properties"}, ignoreResourceNotFound=false, encoding="UTF-8")
@Slf4j
public class ExecutorConfig {

    @Value("${async.executor.thread.core_pool_size}")
    private int corePoolSize;
    @Value("${async.executor.thread.max_pool_size}")
    private int maxPoolSize;
    @Value("${async.executor.thread.queue_capacity}")
    private int queueCapacity;
    @Value("${async.executor.thread.name.prefix}")
    private String namePrefix;
    @Value("${async.executor.thread.keep_alive_seconds}")
    private int keepAliveSeconds;

    //当一个任务被提交到线程池时，首先查看线程池的核心线程是否都在执行任务。如果没有，则选择一条线程执行任务。
    //如果都在执行任务，查看任务队列是否已满。如果不满，则将任务存储在任务队列中。核心线程执行完自己的任务后，会再处理任务队列中的任务。
    //如果任务队列已满，查看线程池（最大线程数控制）是否已满。如果不满，则创建一条线程去执行任务。如果满了，就按照策略处理无法执行的任务。
    @Bean(name = "asyncTaskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        log.info("启动");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(corePoolSize);
        // 最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        // 任务队列大小
        executor.setQueueCapacity(queueCapacity);
        // 线程前缀名
        executor.setThreadNamePrefix(namePrefix);
        // 线程的空闲时间
        executor.setKeepAliveSeconds(keepAliveSeconds);
        // 拒绝策略
        /*
        CallerRunsPolicy()：交由调用方线程运行，比如 main 线程。
        AbortPolicy()：直接抛出异常。
        DiscardPolicy()：直接丢弃。
        DiscardOldestPolicy()：丢弃队列中最老的任务。
        **/
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 线程初始化
        executor.initialize();
        return executor;
    }
}