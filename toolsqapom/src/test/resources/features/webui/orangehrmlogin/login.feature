
Feature: Como Empleado admistrativo
  necesito autenticarme en la plataforma de OrangeHRM
  con el fin gestionar y los datos de usuarios allí alojados.

  Scenario: Login exitoso

    Given que el empleado administrativo se encuentra en la pagina web de OrangeHRM  en el formulario de inicio login
    When el empleado administrativo ingresa un User y Password correctos y presiona el boton de login
    Then el sistema deberá ingresar exitosamente a la pagina de index.php/dashboard


