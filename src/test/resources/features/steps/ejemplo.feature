Feature: Busqueda en google
  Como visitante
  Yo quiero realizar una busqueda en la pagina de google
  Para acceder a la informacion correspondiente

  Background: 
    Given Ingreso a la pagina de google"https://www.google.com"

  @busquedaDeDatoEnGoogle
  Scenario: busqueda de un texto en google
    When Ingreso texto para realizar busqueda"Quality Assurance"
    And Doy Click en la primera sugerencia de busqueda
    Then Valido los resultados obtenidos

  @busquedaDeDatosEnGoogle
  Scenario Outline: busqueda de un texto en google
    When Ingreso texto para realizar busqueda<texto>
    And Doy Click en la primera sugerencia de busqueda
    Then Valido los resultados obtenidos

    Examples: 
      | texto             |
      | "que es BDD"      |
      | "Que es cucumber" |
