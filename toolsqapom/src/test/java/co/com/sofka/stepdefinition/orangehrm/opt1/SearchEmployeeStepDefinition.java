package co.com.sofka.stepdefinition.orangehrm.opt1;

import co.com.sofka.model.orangehrmlogin.OrangehrmLoginModel;
import co.com.sofka.model.orangehrmlogin.OrangehrmSearchModel;
import co.com.sofka.page.orangehrmlogin.OrangehrmLoginSearch;
import co.com.sofka.page.orangehrmlogin.OrangehrmSearch;
import co.com.sofka.stepdefinition.setup.WebUI;
import co.com.sofka.util.EmployeeName;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.util.Seconds.TEN_SECONDS;


public class SearchEmployeeStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(LoginCucumberStepDefinition.class);
    private OrangehrmLoginModel orangehrmLoginModel;
    private OrangehrmLoginSearch orangehrmLogin;
    private OrangehrmSearchModel orangehrmSearchModel;
    private OrangehrmSearch orangehrmSearch;

    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";

    @Given("que el empleado administrativo se encuentra correctamente autenticado en la aplicacion de orangeHRM")
    public void que_el_empleado_administrativo_se_encuentra_correctamente_autenticado_en_la_aplicacion_de_orange_hrm() {
        try{
            generalSetUp();
            dataCorrectConfigurationLogin();
            orangehrmLogin = new OrangehrmLoginSearch(driver,orangehrmLoginModel,TEN_SECONDS.getValue());
            orangehrmLogin.llenarLogin();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }


    @When("el empleado proceda a hacer una busqueda en la sesion de Admin  por medio del Employee name")
    public void el_empleado_proceda_a_hacer_una_busqueda_en_la_sesion_de_admin_por_medio_del_employee_name() {
        try {
            dataCorrectConfigurationSearc();
            orangehrmSearch=new OrangehrmSearch(driver,orangehrmSearchModel,TEN_SECONDS.getValue());
            orangehrmSearch.busquedaUsuariosEmployeeName();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }


    @Then("el sistema debe retornar una lista con la informacion filtrada.")
    public void el_sistema_debe_retornar_una_lista_con_la_informacion_filtrada() {
        try {
            Assertions.assertEquals(
                    expected(),
                    orangehrmSearch.getAssertionSearch(),
                    ASSERTION_EXCEPTION_MESSAGE
            );

            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    private void dataCorrectConfigurationLogin(){
        orangehrmLoginModel = new OrangehrmLoginModel();
        orangehrmLoginModel.setUser("Admin");
        orangehrmLoginModel.setPassword("admin123");
    }

    private void dataCorrectConfigurationSearc(){
        orangehrmSearchModel = new OrangehrmSearchModel();
        orangehrmSearchModel.setEmployeeName(EmployeeName.NAME7);
    }


    private String expected(){
        return orangehrmSearchModel.getEmployeeName().getValue();
    }

}
