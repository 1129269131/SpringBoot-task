package com.tjh.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 任务-定时任务
 */
@Service
public class ScheduleService {

    /**
     * 准备工作：
     *  1、@EnableScheduling //SpringBoot04TaskApplication中开启基于注解的定时任务
     *  2、@Scheduled(cron = "0 * * * * MON-FRI") //使用@Scheduled注解和cron表达式指定执行间隔
     *  3、运行项目
     * cron表达式：
     *  second （秒）, minute （分）, hour （时）, day of month （日）, month （月）, day of week（周几）
     * 例子：0 * * * * MON-FRI
     *  【0 0/5 14,18 * * ?】 每天14点整，和18点整，每隔5分钟执行一次
     *  【0 15 10 ? * 1-6】 每个月的周一至周六10:15分执行一次
     *  【0 0 2 ? * 6L】每个月的最后一个周六凌晨2点执行一次
     *  【0 0 2 LW * ?】每个月的最后一个工作日凌晨2点执行一次
     *  【0 0 2-4 ? * 1#1】每个月的第一个周一凌晨2点到4点期间，每个整点都执行一次；
     *
     */
    //@Scheduled(cron = "0 * * * * MON-FRI")
    //@Scheduled(cron = "0,1,2,3,4 * * * * MON-SAT") // , 枚举
    //@Scheduled(cron = "0-4 * * * * MON-SAT") // - 区间
    @Scheduled(cron = "0/4 * * * * MON-SAT") // 每4秒执行一次
    public void hello() {
        System.out.println("hello ...");
    }
}
