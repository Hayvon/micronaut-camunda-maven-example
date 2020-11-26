package com.example;

import info.novatec.micronaut.camunda.bpm.feature.DefaultJobExecutorCustomizer;
import info.novatec.micronaut.camunda.bpm.feature.JobExecutorCustomizer;
import io.micronaut.context.annotation.Replaces;
import org.camunda.bpm.engine.impl.jobexecutor.JobExecutor;

import javax.annotation.Nonnull;
import javax.inject.Singleton;

@Singleton
@Replaces(DefaultJobExecutorCustomizer.class)
public class CustomizedJobExecutor implements JobExecutorCustomizer {

    @Override
    public void customize(@Nonnull JobExecutor jobExecutor) {
        jobExecutor.setWaitTimeInMillis(300);
    }
}
