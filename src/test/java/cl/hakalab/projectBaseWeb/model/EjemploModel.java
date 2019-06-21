package cl.hakalab.projectBaseWeb.model;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EjemploModel {

	@FindBy(how = How.NAME, using = "q") 
	private WebElement txtBusqueda;
	
	@FindBy(how = How.XPATH, using = "//h3[(@class='LC20lb')]") 
	private List<WebElement> listResultados;


	public WebElement getTxtBusqueda() {
		return txtBusqueda;
	}

	public void setTxtBusqueda(WebElement txtBusqueda) {
		this.txtBusqueda = txtBusqueda;
	}

	public List<WebElement> getListResultados() {
		return listResultados;
	}

	public void setListResultados(List<WebElement> listResultados) {
		this.listResultados = listResultados;
	}
}
