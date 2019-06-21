package cl.hakalab.projectBaseWeb.flow;

import org.junit.BeforeClass;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.hakalab.projectBaseWeb.stageSet.EjemploStageSet;

@SuiteClasses({
	EjemploStageSet.class
})
public class EjemploTest extends BaseFlow{
	private static final Logger LOGGER = LoggerFactory.getLogger(EjemploStageSet.class);
    @BeforeClass
    public static void flag() throws Exception {
    	LOGGER.info("********************************************");
        LOGGER.info("*  Ejecutando flujo de Prueba con cucumber *");
        LOGGER.info("********************************************");
    }
}
