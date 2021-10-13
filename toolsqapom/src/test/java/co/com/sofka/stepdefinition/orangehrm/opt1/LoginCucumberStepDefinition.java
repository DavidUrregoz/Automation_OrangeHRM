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

    @Then("el sistema deberá ingresar exitosamente a la pagina de index.php\\/dashboard")
    public void el_sistema_deberá_ingresar_exitosamente_a_la_pagina_de_index_php_dashboard() {

    }

    @When("el empleado administrativo ingresa un User y Password incorrectos o  incompletos y presiona el boton de login")
    public void el_empleado_administrativo_ingresa_un_user_y_password_incorrectos_o_incompletos_y_presiona_el_boton_de_login() {
        try {
            dataFailConfiguration1();
            orangehrmLogin = new OrangehrmLogin(driver,orangehrmLoginModel);
            orangehrmLogin.llenarLogin();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }


    @Then("el sistema deberá retornar un mensaje en pantalla Invalid credentials")
    public void el_sistema_deberá_retornar_un_mensaje_en_pantalla_invalid_credentials() {

    }


    private void dataCorrectConfiguration(){
        orangehrmLoginModel = new OrangehrmLoginModel();
        orangehrmLoginModel.setUser("Admin");
        orangehrmLoginModel.setPassword("admin123");
        orangehrmLoginModel.setEmployeeName(EmployeeName.NAME3);
    }
    private void dataFailConfiguration1(){
        orangehrmLoginModel = new OrangehrmLoginModel();
        orangehrmLoginModel.setUser("123213");
        orangehrmLoginModel.setPassword("ad33123");
        orangehrmLoginModel.setEmployeeName(EmployeeName.NAME3);
    }
    private void dataFailConfiguration2(){
        orangehrmLoginModel = new OrangehrmLoginModel();
        orangehrmLoginModel.setUser("");
        orangehrmLoginModel.setPassword("admin123");
        orangehrmLoginModel.setEmployeeName(EmployeeName.NAME3);
    }

    private void dataFailConfiguration3(){
        orangehrmLoginModel = new OrangehrmLoginModel();
        orangehrmLoginModel.setUser("Admin");
        orangehrmLoginModel.setPassword("");
        orangehrmLoginModel.setEmployeeName(EmployeeName.NAME3);
    }

    private void expected(){

    }
}
