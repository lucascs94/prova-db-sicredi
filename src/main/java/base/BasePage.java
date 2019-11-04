package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.TestRule;
import utils.ReportHelper;

public class BasePage {
    protected static WebDriver driver;
    private WebDriverWait wait;

    protected BasePage() {
        driver = TestRule.getDriver();
        wait = new WebDriverWait(driver, 15);
    }

    protected void esperaElemento(WebElement elem) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(elem));
        } catch (Exception e) {
            ReportHelper.logMensagemErroPrint("Elemento não encontrado!");
        }
    }

    protected void preencheCampo(WebElement elem, String valor) {
        esperaElemento(elem);
        elem.sendKeys(valor);
    }

    protected void pressionaBotao(WebElement elem) {
        esperaElemento(elem);
        elem.click();
    }

    protected boolean validaExibicaoElemento(WebElement elem) {
        esperaElemento(elem);
        return elem.isDisplayed();
    }
}
