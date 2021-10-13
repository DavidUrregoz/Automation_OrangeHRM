package co.com.sofka.stepdefinition.orangehrm.opt1;

import co.com.sofka.model.orangehrmlogin.OrangehrmLoginModel;
import co.com.sofka.page.orangehrmlogin.OrangehrmLogin;
import co.com.sofka.stepdefinition.setup.WebUI;
import co.com.sofka.util.EmployeeName;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class LoginCucumberStepDefinition extends WebUI {
    private static final Logger LOGGER = Logger.getLogger(LoginCucumberStepDefinition.class);
    private OrangehrmLoginModel orangehrmLoginModel;
    private OrangehrmLogin orangehrmLogin;

    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";


    @Given("que el empleado administrativo se encuentra en la pagina web de OrangeHRM  en el formulario de inicio login")
    public void que_el_empleado_administrativo_se_encuentra_en_la_pagina_web_de_orange_hrm_en_el_formulario_de_inicio_login() {
        try{
            generalSetUp();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("el empleado administrativo ingresa un User y Password correctos y presiona el boton de login")
    public void el_empleado_administrativo_ingresa_un_user_y_password_correctos_y_presiona_el_boton_de_login() {
        try {
            dataCorrectConfiguration();
            orangehrmLogin = new OrangehrmLogin(driver,orangehrmLoginModel,TEN_SECONDS.getValue());
            orangehrmLogin.llenarLogin();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("el sistema debera ingresar exitosamente a la pagina de index.php\\/dashboard")
    public void elSistemaDeberaIngresarExitosamenteALaPaginaDeIndexPhpDashboard() {
        try {
            Assertions.assertEquals(
                    expected(),
                    orangehrmLogin.getAssertionLoginExitoso(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("el empleado administrativo ingresa un User y Password incorrectos y presiona el boton de login")
    public void el_empleado_administrativo_ingresa_un_user_y_password_incorrectos_y_presiona_el_boton_de_login() {
        try {
            dataFailConfiguration1();
            orangehrmLogin = new OrangehrmLogin(driver,orangehrmLoginModel,TEN_SECONDS.getValue());
            orangehrmLogin.llenarLogin();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }


    @Then("el sistema debera retornar un mensaje en pantalla Invalid credentials")
    public void el_sistema_debera_retornar_un_mensaje_en_pantalla_invalid_credentials() {
        try {
            Assertions.assertEquals(
                    expected1(),
                    orangehrmLogin.getAssertionLoginFail(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("el empleado administrativo no ingresa un User  pero si un Password  y presiona el boton de login")
    public void el_empleado_administrativo_no_ingresa_un_user_pero_si_un_password_y_presiona_el_boton_de_login() {
        try {
            dataFailConfiguration2();
            orangehrmLogin = new OrangehrmLogin(driver,orangehrmLoginModel,TEN_SECONDS.getValue());
            orangehrmLogin.llenarLogin();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("el sistema debera retornar un mensaje en pantalla Username cannot be empty")
    public void el_sistema_debera_retornar_un_mensaje_en_pantalla_username_cannot_be_empty() {
        try {
            Assertions.assertEquals(
                    expected2(),
                    orangehrmLogin.getAssertionLoginFail(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("el empleado administrativo ingresa un User pero no un Password  y presiona el boton de login")
    public void el_empleado_administrativo_ingresa_un_user_pero_no_un_password_y_presiona_el_boton_de_login() {
        try {
            dataFailConfiguration3();
            orangehrmLogin = new OrangehrmLogin(driver,orangehrmLoginModel,TEN_SECONDS.getValue());
            orangehrmLogin.llenarLogin();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("el sistema debera retornar un mensaje en pantalla Password cannot be empty")
    public void el_sistema_debera_retornar_un_mensaje_en_pantalla_password_cannot_be_empty() {
        try {
            Assertions.assertEquals(
                    expected3(),
                    orangehrmLogin.getAssertionLoginFail(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("el empleado administrativo no ingresa un User ni un Password  y presiona el boton de login")
    public void el_empleado_administrativo_no_ingresa_un_user_ni_un_password_y_presiona_el_boton_de_login() {
        try {
            dataFailConfiguration4();
            orangehrmLogin = new OrangehrmLogin(driver,orangehrmLoginModel,TEN_SECONDS.getValue());
            orangehrmLogin.llenarLogin();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("el sistema debera retornar una alerta en pantalla Username cannot be empty")
    public void el_sistema_debera_retornar_una_alerta_en_pantalla_username_cannot_be_empty() {
        try {
            Assertions.assertEquals(
                    expected2(),
                    orangehrmLogin.getAssertionLoginFail(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }


    private void dataCorrectConfiguration(){
        orangehrmLoginModel = new OrangehrmLoginModel();
        orangehrmLoginModel.setUser("Admin3");
        orangehrmLoginModel.setPassword("admin123");
    }
    private void dataFailConfiguration1(){
        orangehrmLoginModel = new OrangehrmLoginModel();
        orangehrmLoginModel.setUser("123213");
        orangehrmLoginModel.setPassword("ad33123");
    }
    private void dataFailConfiguration2(){
        orangehrmLoginModel = new OrangehrmLoginModel();
        orangehrmLoginModel.setUser("");
        orangehrmLoginModel.setPassword("admin123");
    }

    private void dataFailConfiguration3(){
        orangehrmLoginModel = new OrangehrmLoginModel();
        orangehrmLoginModel.setUser("Admin");
        orangehrmLoginModel.setPassword("");
    }

    private void dataFailConfiguration4(){
        orangehrmLoginModel = new OrangehrmLoginModel();
        orangehrmLoginModel.setUser("");
        orangehrmLoginModel.setPassword("");
    }

    //orangehrmLoginModel.setEmployeeName(EmployeeName.NAME3);
    private String expected(){
        String mensaje="Welcome Paul";
        return mensaje;
    }
    private String expected1(){
        String mensaje="Invalid credentials";
        return mensaje;
    }

    private String expected2(){
        String mensaje="Username cannot be empty";
        return mensaje;
    }

    private String expected3(){
        String mensaje="Password cannot be empty";
        return mensaje;
    }


}
