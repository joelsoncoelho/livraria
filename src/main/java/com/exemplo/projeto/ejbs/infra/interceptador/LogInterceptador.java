package com.exemplo.projeto.ejbs.infra.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {

	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {

		long millis = System.currentTimeMillis();

		// chamar do metódo do dao??
		Object object = context.proceed();

		String nomeMetodo = context.getMethod().getName();
		String nomeClasse = context.getTarget().getClass().getSimpleName();
		
        System.out.printf("===================================================================================================================\n");
        System.out.println("[INFO] " + nomeClasse + "-> " + nomeMetodo);
        
        System.out.println("[INFO] Tempo gasto no acesso ao BD: " + (System.currentTimeMillis() - millis) + " milisegundos");        
        System.out.printf("===================================================================================================================\n");

		return object;
	}
}