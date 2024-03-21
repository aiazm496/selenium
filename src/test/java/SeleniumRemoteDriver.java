import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumRemoteDriver {

    public static WebDriver getDriver(String browserName) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setPlatform(Platform.LINUX);
        if(browserName.equalsIgnoreCase("chrome")){
            dc.setBrowserName(Browser.CHROME.browserName());
        }
        else if(browserName.equalsIgnoreCase("edge")){
            dc.setBrowserName(Browser.EDGE.browserName());
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            dc.setBrowserName(Browser.FIREFOX.browserName());
        }else {
            dc.setBrowserName(Browser.CHROME.browserName());
        }
        return new RemoteWebDriver(new URL("http://localhost:4444"),dc);
    }

}
