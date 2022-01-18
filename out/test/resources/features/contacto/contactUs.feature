Feature: mensaje de contacto
  yo como cliente
  deseo acceder a la opcion contactenos
  para enviar un mensaje al sitio web

  Background:
    Given el cliente esta ubicado en la pagina de inicio
    When el cliente navegue a la seccion del formulario

  Scenario: envio del mensaje de reccepcion exitosa
    And el cliente ingrese la informacion correctamente y presione el boton enviar
    Then el cliente visualizara una alerta exitosa que emite la pagina

  Scenario: envio del mensaje de reccepcion fallido
    And el cliente ingrese la informacion incompleta y presione el boton de envio
    Then el cliente visualizara una alerta fallida por falta de email

