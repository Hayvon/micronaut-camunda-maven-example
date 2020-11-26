package com.example;

import io.micronaut.context.annotation.Replaces;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named("runtimeErrorDelegate")
public class RuntimeErrorDelegateJpa implements JavaDelegate {

    private final BookRepository bookRepository;

    public RuntimeErrorDelegateJpa(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void execute(DelegateExecution execution) {
        bookRepository.save(new Book());
        throw new RuntimeException("RuntimeErrorDelegate throws RuntimeException");
    }
}
