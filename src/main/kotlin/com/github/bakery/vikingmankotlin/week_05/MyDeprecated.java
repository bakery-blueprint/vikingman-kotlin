package com.github.bakery.vikingmankotlin.week_05;

import kotlin.DeprecationLevel;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
public @interface MyDeprecated {
    String message();
    ReplaceWith replaceWith() default @ReplaceWith(expression = "");
    DeprecationLevel level() default DeprecationLevel.WARNING;
}
