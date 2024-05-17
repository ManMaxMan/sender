package com.github.ManMaxMan.sender.service.scheduling;

import com.github.ManMaxMan.sender.service.job.api.IJob;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MessageSenderScheduling {
    private final ScheduledExecutorService executorService;
    private final IJob jobSender;

    public MessageSenderScheduling(int coreSize, long delay, long period,
                                   TimeUnit unit, IJob jobSender) {
        this.executorService = Executors.newScheduledThreadPool(coreSize);
        this.jobSender = jobSender;
        this.executorService.scheduleAtFixedRate(this.jobSender::start, delay, period, unit);
    }
}
