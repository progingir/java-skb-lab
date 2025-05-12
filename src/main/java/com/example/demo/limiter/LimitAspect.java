package com.example.demo.limiter;

import com.example.demo.exception.LimitExceededException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class LimitAspect {

    private final RequestStore store;

    @Before("@annotation(com.example.demo.limiter.RequestLimit) && within(@org.springframework.web.bind.annotation.RestController *)")
    public void checkLimit(JoinPoint joinPoint) {
        String key = joinPoint.getSignature().toString();
        if (!store.isRequestAllowed(key)) {
            throw new LimitExceededException("Too many requests");
        }
        store.saveRequest(key);
    }
}