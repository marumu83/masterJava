package com.viewnext.Siraku.configuration;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.viewnext.Siraku.model.Comercial;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Aspect
public class LogAspectConfig {
	
	private Logger log = LoggerFactory.getLogger(LogAspectConfig.class);
	
	@Before(value = "execution(* com.viewnext.Siraku.servicesImpl.*.*(..))")
	public void servicesLogger(JoinPoint joinpoint) {
		String clase = joinpoint.getTarget().getClass().getSimpleName();
		String signature = joinpoint.getSignature().getName();
		Object[] args = joinpoint.getArgs();
		log.info("Log de la capa de controladores: Clase: " + clase + ", Metodo: "
				+ signature + "\nArgumentos:\n");
		Arrays.stream(args).forEach(obj -> {
			if (obj != null) {
				System.out.println("- " + obj.toString() + "\n");
			}else {
				System.out.println("- No existente");
			}
		});
	}
	
	@Before(value = "execution(* com.viewnext.Siraku.controller.*.*(..))")
	public void controllerLogger(JoinPoint joinpoint) {
		String clase = joinpoint.getTarget().getClass().getSimpleName();
		String signature = joinpoint.getSignature().getName();
		Object[] args = joinpoint.getArgs();
		log.info("Log de la capa de controladores: Clase: " + clase + ", Metodo: "
				+ signature + "\nArgumentos:\n");
		Arrays.stream(args).forEach(obj -> {
			if (obj != null) {
				System.out.println("- " + obj.toString() + "\n");
			}else {
				System.out.println("- No existente");
			}
		});
	}
	
}
