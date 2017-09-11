package br.com.spring.jaxws.jms.service;

import org.codehaus.groovy.control.CompilerConfiguration;

import br.com.spring.jaxws.jms.pojo.QueueAbstractWrapper;
import br.com.spring.jaxws.jms.pojo.QueueGroovyScript;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

public class GroovyService {
	
	public static void runUserExit(QueueAbstractWrapper message, String script) {
		Class<QueueGroovyScript> parsedScript = getGroovyClassLoader().parseClass(script);
		QueueGroovyScript newInstance;
		try {
			newInstance = parsedScript.newInstance();
			newInstance.execute(message);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static GroovyClassLoader getGroovyClassLoader() {
		return new GroovyClassLoader(Thread.currentThread().getContextClassLoader());
	}
}
