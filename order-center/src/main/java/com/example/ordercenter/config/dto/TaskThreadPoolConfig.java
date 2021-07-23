package com.example.ordercenter.config.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 封装application.yaml task.pool 配置的属性
 */
@Data
@Component
@ConfigurationProperties("task.pool")
public class TaskThreadPoolConfig {

    /**
     * 核心线程数
     */
    private int corePoolSize;
    /**
     * 最大线程数
     */
    private int maxPoolSize;
    /**
     * 线程空闲时间
     */
    private int keepAliveSeconds;
    /**
     * 任务队列容量（阻塞队列）
     */
    private int queueCapacity;

}
