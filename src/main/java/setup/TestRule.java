package setup;


import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;
import utils.PropertiesFileReader;
import utils.ReportHelper;

import java.util.Properties;

public class TestRule {
    private static WebDriver driver;
    private static Properties runProperties;

    @Before
    public void configuraTeste(Scenario cenario) {
        runProperties = PropertiesFileReader.readPropFile("run");
        driver = DriverHelper.getDriver();
        driver.manage().window().maximize();
        ReportHelper.criarReport(cenario);
    }

    @After
    public void finalizaTeste(Scenario cenario) {
        ReportHelper.logMensagemInfoPrint("Finalizando estância do chromeDriver");
        driver.quit();
        ReportHelper.atualizaReport(cenario);
    }

    public static Properties getRunProperties() {
        return runProperties;
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
