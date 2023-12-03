package esprit.tn.projetspring1.LoggingAspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
        @Before("execution(* esprit.tn.projetspring1.Service.Blocservice.*(..))")
        public void logMethodEntry(JoinPoint joinPoint) {
            String name = joinPoint.getSignature().getName();
            log.info("In method " + name + " : ");
        }

    @AfterReturning(value = "execution(* esprit.tn.projetspring1.Service.Blocservice.*(..))")
    public void logMethodEntryAR(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }
    @AfterThrowing(value = "execution(* esprit.tn.projetspring1.Service.Blocservice.*(..))")
    public void logMethodEntryAT(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }@After(value = "execution(* esprit.tn.projetspring1.Service.Blocservice.*(..))")
    public void logMethodEntryAfter(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }

}

