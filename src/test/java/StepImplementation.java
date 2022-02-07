import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class StepImplementation extends BaseTest {

    Logger logger = LogManager.getLogger(Loggers.class);

    @Step("<text>")
    public void logger(String text){

        logger.info(text);

    }
    @Step("<time> saniye kadar bekle")
    public void waitForseconds(int time) throws InterruptedException {

        Thread.sleep(time * 1000);

    }
    @Step("<id> id elemente tıkla")
    public void clickByid(String id){

        try {
            appiumDriver.findElement(By.id(id)).click();
        }
        catch (Exception e){
            logger.error("Hata= "+ e);
        }

    }
    @Step("<xpath> xpath elemente tıkla")
    public void clickByXpath(String xpath){

        try {
            appiumDriver.findElement(By.xpath(xpath)).click();
        }
        catch (Exception e){
            logger.error("Hata= "+ e);
        }

    }
    @Step("<xpath> xpath elementlerten rastgele bir tane seç")
    public void randomSelect(String xpath){

        try {
            Random rand = new Random();
            List<MobileElement> products = appiumDriver.findElements(By.xpath(xpath));
            appiumDriver.findElements(By.xpath(xpath)).get(rand.nextInt(products.size())).click();
        }
        catch (Exception e){
            logger.error("Hata= "+ e);
        }

    }
    @Step("<id> id elementi bul ve <text> değerini yaz")
    public void sendkeysByid(String id,String text){

        try {
            appiumDriver.findElement(By.id(id)).sendKeys(text);
        }
        catch (Exception e){
            logger.error("Hata= "+ e);
        }

    }
    @Step("<xpath> xpath elementi bul ve <text> değerini yaz")
    public void sendKeysByXpath(String xpath, String text) {

        try {
            appiumDriver.findElement(By.xpath(xpath)).sendKeys(text);
        }
        catch (Exception e){
            logger.error("Hata= "+ e);
        }

    }
    @Step("<id> id elementi bul ve <text> alanını kontrol et")
    public void textAreacontrolById(String id, String text) {

        try {
            Assert.assertTrue("Element text değerini içermiyor",appiumDriver.findElement(By.id(id)).getText().contains(text));
        }
        catch (Exception e){
            logger.error("Hata= "+ e);
        }

    }
    @Step("<xpath> xpath elementi bul ve <text> alanını kontrol et")
    public void textAreacontrolByXpath(String xpath, String text) {

        try {
            Assert.assertTrue("Element text değerini içermiyor",appiumDriver.findElement(By.xpath(xpath)).getText().contains(text));
        }
        catch (Exception e){
            logger.error("Hata= "+ e);
        }

    }
    @Step("Sayfayı sayfa boyunca aşağı kaydır")
    public void scrollDown(){

        try {
            final int pressTime = 200;
            int edgeBorder = 10;
            PointOption pointOptionStart, pointOptionEnd;
            Dimension dims = appiumDriver.manage().window().getSize();
            pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
            pointOptionEnd = PointOption.point(dims.width/2, edgeBorder);
            new TouchAction(appiumDriver)
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(pressTime)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        }
        catch (Exception e){
            logger.error("Hata= "+ e);
        }

    }
    @Step("Sayfayı aşağıya kaydır")
    public void scrollDownSmall(){

        try {
            final int pressTime = 200;
            int edgeBorder = 400;
            PointOption pointOptionStart, pointOptionEnd;
            Dimension dims = appiumDriver.manage().window().getSize();
            pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
            pointOptionEnd = PointOption.point(dims.width/2, edgeBorder);
            new TouchAction(appiumDriver)
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(pressTime)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        }
        catch (Exception e){
            logger.error("Hata= "+ e);
        }

    }

}
