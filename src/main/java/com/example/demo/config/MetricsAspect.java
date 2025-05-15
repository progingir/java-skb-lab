package com.example.demo.config;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class MetricsAspect {

    private final MeterRegistry meterRegistry;

    @Around("execution(* com.example.demo.PurchaseController.*(..))")
    public Object trackMetrics(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        meterRegistry.counter("app.requests.total").increment();
        meterRegistry.counter("app.requests." + methodName).increment();
        return meterRegistry.timer("app.timer." + methodName).record(() -> {
            try {
                return joinPoint.proceed();
            } catch (Throwable t) {
                throw new RuntimeException(t);
            }
        });
    }
}
