import java.util.Optional;
import java.util.function.Predicate;
import java.net.URI;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.network.Network;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Predicate<URI> uriPredicate =  uri -> uri.getHost().contains("httpbin.org");
		// cast driver to has authentication class
		((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("foo", "bar"));
		driver.get("http://httpbin.org/basic-auth/foo/bar");		
		
	}

}
