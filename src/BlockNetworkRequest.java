import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.network.Network;

import com.google.common.collect.ImmutableList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlockNetworkRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
		
		//long startTime = System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.linkText("selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		//long endTime = System.currentTimeMillis();
		//System.out.println(endTime - startTime);		
		
		
		
	}

}
