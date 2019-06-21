package cl.hakalab.projectBaseWeb.stageSet;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = {
				  "@busquedaDeDatoEnGoogle"
				+ ",@busquedaDeDatosEnGoogle"
		},plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/EjemploPrueba.html"})
public class EjemploStageSet extends StageSet{
	

}
