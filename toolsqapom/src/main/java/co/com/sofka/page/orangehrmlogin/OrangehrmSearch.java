package co.com.sofka.page.orangehrmlogin;


import co.com.sofka.model.orangehrmlogin.OrangehrmLoginModel;
import co.com.sofka.model.orangehrmlogin.OrangehrmSearchModel;
import co.com.sofka.page.common.CommonActionsOnPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class OrangehrmSearch extends CommonActionsOnPages {
    private static final Logger LOGGER = Logger.getLogger(OrangehrmLoginSearch.class);
    private OrangehrmSearchModel orangehrmSearchModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    private final By adminMenu = By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b");
    private final By searchEmployeeName = By.id("searchSystemUser_employeeName_empName");
    private final By btnSearch = By.id("searchBtn");

    private final By assertionSearch = By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[4]");


    public void busquedaUsuariosEmployeeName()throws IOException {
        try{
            scrollTo(adminMenu);
            withExplicitWaitClickOn(adminMenu);

            scrollTo(searchEmployeeName);
            withExplicitWaitClear(searchEmployeeName);
            withExplicitWaitTypeInto(searchEmployeeName,orangehrmSearchModel.getEmployeeName().getValue());

            withExplicitWaitTypeInto(searchEmployeeName, Keys.TAB);

            scrollTo(btnSearch);
            withExplicitWaitClickOn(btnSearch);

        } catch (Exception exception){
            LOGGER.warn(exception.getMessage());
        }
    }

    public OrangehrmSearch(WebDriver driver,OrangehrmSearchModel orangehrmSearchModel,int secondsForExplicitWait){
        super(driver, secondsForExplicitWait);
        if(orangehrmSearchModel == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);
        this.orangehrmSearchModel=orangehrmSearchModel;
    }

    public String getAssertionSearch(){
        return getText(assertionSearch).trim();
    }

}
