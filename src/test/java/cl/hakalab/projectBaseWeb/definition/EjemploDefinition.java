package cl.hakalab.projectBaseWeb.definition;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Keys;

import cl.hakalab.projectBaseWeb.flow.BaseFlow;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EjemploDefinition {
	
	
	@Given("^Ingreso a la pagina de google\"([^\"]*)\"$")
	public void ingreso_a_la_pagina_de_google(String url) throws Throwable {
		BaseFlow.driver.manage().deleteAllCookies();
	    BaseFlow.driver.get(url);
	}

	@When("^Ingreso texto para realizar busqueda\"([^\"]*)\"$")
	public void ingreso_texto_para_realizar_busqueda(String texto) throws Throwable {
		Thread.sleep(1000);
	   BaseFlow.pageModel.getTxtBusqueda().sendKeys(texto);
	}
	
	@When("^Doy Click en la primera sugerencia de busqueda$")
	public void doy_Click_en_la_primera_sugerencia_de_busqueda() throws Throwable {
		Thread.sleep(1000);
		BaseFlow.pageModel.getTxtBusqueda().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		BaseFlow.pageModel.getTxtBusqueda().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@Then("^Valido los resultados obtenidos$")
	public void valido_los_resultados_obtenidos() throws Throwable {
		Thread.sleep(2000);
		assertTrue("Error no se han encontrado resultados para la busqueda realizada",BaseFlow.pageModel.getListResultados().size()>0);
	}

}
