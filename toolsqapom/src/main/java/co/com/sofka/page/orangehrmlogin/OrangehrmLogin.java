package co.com.sofka.page.orangehrmlogin;

import co.com.sofka.model.orangehrmlogin.OrangehrmLoginModel;
import co.com.sofka.page.common.CommonActionsOnPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class OrangehrmLogin  extends CommonActionsOnPages{
    private static final Logger LOGGER = Logger.getLogger(OrangehrmLogin.class);
    private OrangehrmLoginModel orangeLoginModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";


    private final By user = By.id("txtUsername");
    private final By password = By.id("txtPassword");
    private final By btnLogin = By.id("btnLogin");

    private final By adminMenu = By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b");
    private final By searchEmployeeName = By.id("searchSystemUser_employeeName_empName");

    //For Assertions test case.
    private final By assertionLoginFail = By.id("spanMessage");
    private final By assertionLoginExitoso = By.id("welcome");



    public OrangehrmLogin(WebDriver driver,OrangehrmLoginModel orangeLogin) {
        super(driver);
        this.orangeLoginModel = orangeLogin;
    }

    public OrangehrmLogin(WebDriver driver,OrangehrmLoginModel orangeLogin,int secondsForExplicitWait) {
        super(driver, secondsForExplicitWait);
        if(orangeLogin == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);
        this.orangeLoginModel= orangeLogin;
    }

    public void llenarLogin() throws IOException {
        try{
            scrollTo(user);
            withExplicitWaitClear(user);
            withExplicitWaitTypeInto(user,orangeLoginModel.getUser());

            scrollTo(password);
            withExplicitWaitClear(password);
            withExplicitWaitTypeInto(password,orangeLoginModel.getPassword());

            scrollTo(btnLogin);
            withExplicitWaitClickOn(btnLogin);
        }
        catch (Exception exception){
            LOGGER.warn(exception.getMessage());
        }
    }

    public void busquedaUsuariosEmployeeName(){
        try{
            scrollTo(user);
            withExplicitWaitClear(user);
            withExplicitWaitTypeInto(user,orangeLoginModel.getUser());

            scrollTo(password);
            withExplicitWaitClear(password);
            withExplicitWaitTypeInto(password,orangeLoginModel.getPassword());

            scrollTo(btnLogin);
            withExplicitWaitClickOn(btnLogin);

            scrollTo(adminMenu);
            withExplicitWaitClickOn(adminMenu);

            scrollTo(searchEmployeeName);
            withExplicitWaitClear(searchEmployeeName);
            withExplicitWaitTypeInto(searchEmployeeName,orangeLoginModel.getEmployeeName().getValue());


        } catch (Exception exception){
            LOGGER.warn(exception.getMessage());
        }
    }


    public String getAssertionLoginExitoso() {
        return getText(assertionLoginExitoso).trim();
    }

    public String getAssertionLoginFail() {
        return getText(assertionLoginFail).trim();
    }
}
