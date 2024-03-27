import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import org.openqa.selenium.devtools.v121.network.Network;
import org.openqa.selenium.devtools.v121.network.model.ConnectionType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkSpeed {

	public static void main(String[] args) {
		// whenever we see inconsistency test execution of our results
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(
				Network.emulateNetworkConditions(false, 3000, 20000, 10000, Optional.of(ConnectionType.ETHERNET)));
		devTools.addListener(Network.loadingFailed(), loadingFailed ->{
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());
		});
		// long startTime = System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		// long endTime = System.currentTimeMillis();
		// System.out.println(endTime - startTime);
		driver.close();

	}

}
