package cl.hakalab.projectBaseWeb.stageSet;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cl.hakalab.projectBaseWeb.dataProvider.ConfigFileReader;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cl/hakalab/projectBaseWeb/definition"
)
public class StageSet {
	@AfterClass
	public static void setUpFinal() throws Exception{
//		Reporter.setTestRunnerOutput(log);
//		Reporter.addStepLog(message);
//		Reporter.addScenarioLog(message);
		System.out.println("Creando Reporte HTML");
		Reporter.loadXMLConfig(ConfigFileReader.getInstance().getReportConfigPath());
	}
}
