package es.home.almacen.bbdd.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import es.home.almacen.bbdd.exception.AlmJpaRepoException;

@Aspect
@Component
public class ExceptionAspect {

	/** The log. */
	private static Logger LOGGER = Logger.getLogger(ExceptionAspect.class);
	
	@Pointcut("@annotation(es.home.almacen.bbdd.annotation.ExceptionControl)")
	protected void exceptionControl() {}
	
	/**
	 * Advice en los metodos anotados con @ExcepcionControl.
	 *
	 * @param joinpoint ProceedingJoinPoint
	 * @return Object
	 * @throws Throwable the throwable
	 */
	@Around("exceptionControl()")
	public Object catchException(ProceedingJoinPoint joinpoint) throws Throwable {
		Object exit = null;
		try {
			exit = joinpoint.proceed();
		} catch (Exception except) {
			LOGGER.error("Excepcion capturada en el advice: "+except.getMessage(), except);
			throw  new AlmJpaRepoException(except);
		}
		return exit;
	}
	

}
