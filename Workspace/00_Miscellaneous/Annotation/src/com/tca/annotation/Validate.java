package com.tca.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Validate {

	public boolean required() default false;
	
	public int maxLen() default 255;
	
	public int minLen() default 10;
}
