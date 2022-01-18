Feature: ingreso a la plataforma
  yo como cliente
  deseo ingresar como usuario
  para poder realizar compras en el sitio web

  Background:
    Given el cliente esta ubicado en el sitio web
    When el cliente navegue a la seccion del formulario de SIGN IN

  Scenario: ingreso al sitio web de usuario nuevo
    And el cliente crea una cuenta y presiona el boton CREATE A ACCOUNT
    Then el cliente ingresa correctamente a la pagina web

  Scenario: ingreso al sitio web de usuario ya creado
    And el cliente ingresa la informacion de la cuenta y presiona el boton SIGN IN
    Then el cliente ingresa exitosamente a la pagina web