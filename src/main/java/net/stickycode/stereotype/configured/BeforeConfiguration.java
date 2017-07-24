package net.stickycode.stereotype.configured;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A lifecycle for after configuration is applies
 * 
 * Methods annotated with @BeforeConfiguration will be executed before any configuration is injected and any
 * beans annotated with @PreConfigured are called.
 *
 * In most DI systems, a context refresh, or event of some kind occurs after the beans are wired. By creating a
 * separate wiring stage, it is impossible for beans to set some things up until configuration is also complete. At
 * times, this may extend to an orchestration layer that needs to know all of the underlying infrastructure is (a) wired
 * and (b) configured (such as setting up servlets or web service proxies).
 *
 * The cycle is:
 * <ul>
 * <li>context is refresh by DI system</li>
 * <li>all beans expecting configuration get @PreConfigured run (if annotated)</li>
 * <li>all beans are injected</li>
 * <li>all beans expecting configuration get @PostConfigured run (if annotated)</li>
 * <li>all beans expecting fully configured eosystem configuration annotated with @CompleteConfigured are run</li>
 * </ul>
 */
@Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BeforeConfiguration {
}
