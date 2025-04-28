package com.example.demo.limiter;

import com.example.demo.exception.LimitExceededException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
@RequiredArgsConstructor
public class LimitAspect {

    private final RequestStore store;

    @Before("@annotation(com.example.demo.limiter.RequestLimit)")
    public void checkLimit() {
        if (!store.isRequestAllowed()) {
            throw new LimitExceededException("Too many requests");
        }
        store.saveRequest();
    }
}