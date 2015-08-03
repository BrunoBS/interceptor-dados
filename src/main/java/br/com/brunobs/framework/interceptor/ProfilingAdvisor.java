package br.com.brunobs.framework.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.brunobs.framework.annotations.ExecuteFetch;

@Component
public class ProfilingAdvisor extends AbstractPointcutAdvisor {

	private static final long serialVersionUID = 1L;

	private final StaticMethodMatcherPointcut pointcut = new StaticMethodMatcherPointcut() {
		public boolean matches(Method method, Class<?> targetClass) {
			return method.isAnnotationPresent(ExecuteFetch.class);
		}
	};

	@Autowired
	private ProfilingMethodInterceptor interceptor;

	public Pointcut getPointcut() {
		return this.pointcut;
	}

	public Advice getAdvice() {
		return this.interceptor;
	}
}
