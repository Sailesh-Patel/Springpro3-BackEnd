package com.LBG.jalal.propertyTest;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
@Sql(scripts = { "classpath:estate-schema.sql",
		"classpath:estate-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class PropertyTest {

	private RemoteWebDriver driver;

	@LocalServerPort
	private int port;

	@BeforeEach
	void init() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test
	@Order(1)
	void testGetSeller() {
		this.driver.get("http://localhost:3000");
		WebElement propertyButton = this.driver
				.findElement(By.cssSelector("#root > div > div > header > nav > div.App-nav > a:nth-child(4)"));
		propertyButton.click();

		WebElement resultAddress = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/p/p[1]"));
		Assertions.assertEquals("Address: 123 Fake Street", resultAddress.getText());

		WebElement resultLocation = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/p/p[2]"));
		Assertions.assertEquals("Location: Fake City", resultLocation.getText());

		WebElement resultPrice = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/p/p[3]"));
		Assertions.assertEquals("Price: £ 120000", resultPrice.getText());

		WebElement resultPropertyType = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/p/p[4]"));
		Assertions.assertEquals("Type of Property: Detached", resultPropertyType.getText());

		WebElement resultBedrooms = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/p/p[5]"));
		Assertions.assertEquals("No. of Bedrooms: 2", resultBedrooms.getText());

		WebElement resultBathrooms = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/p/p[6]"));
		Assertions.assertEquals("No. of Bathrooms:1", resultBathrooms.getText());

		WebElement resultGarden = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/p/p[7]"));
		Assertions.assertEquals("Garden Yes", resultGarden.getText());

		WebElement resultStatus = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/p/p[8]"));
		Assertions.assertEquals("Status: For Sale", resultStatus.getText());
	}

	@Test
	@Order(2)
	void testCreateProperty() throws InterruptedException {
		this.driver.get("http://localhost:3000");
		WebElement propertyButton = this.driver
				.findElement(By.cssSelector("#root > div > div > header > nav > div.App-nav > a:nth-child(4)"));
		propertyButton.click();

		String propertyAddress = "742 Evergreen Terrace";
		WebElement address = this.driver.findElement(By.xpath("/html/body/div/div/div/div/form[1]/input[1]"));
		address.sendKeys(propertyAddress);

		String propertyLocation = "Springfield";
		WebElement location = this.driver.findElement(By.xpath("/html/body/div/div/div/div/form[1]/input[2]"));
		location.sendKeys(propertyLocation);

		String propertyPrice = "150000";
		WebElement price = this.driver.findElement(By.xpath("/html/body/div/div/div/div/form[1]/input[3]"));
		price.sendKeys(propertyPrice);

		WebElement typeSelect = this.driver.findElement(By.xpath("/html/body/div/div/div/div/form[1]/select"));
		typeSelect.click();

		WebElement typeOption = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/form[1]/select/option[2]"));
		typeOption.click();

		String propertyBedrooms = "4";
		WebElement bedrooms = this.driver.findElement(By.xpath("/html/body/div/div/div/div/form[1]/input[4]"));
		bedrooms.sendKeys(propertyBedrooms);

		String propertyBathrooms = "2";
		WebElement bathrooms = this.driver.findElement(By.xpath("/html/body/div/div/div/div/form[1]/input[5]"));
		bathrooms.sendKeys(propertyBathrooms);

		WebElement gardenSelect = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/form[1]/div[1]/div/select"));
		gardenSelect.click();

		WebElement gardenOption = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/form[1]/div[1]/div/select/option[2]"));
		gardenOption.click();

		String propertyImage = "https://upload.wikimedia.org/wikipedia/en/c/ca/742_Evergreen_Terrace.png";
		WebElement image = this.driver.findElement(By.xpath("/html/body/div/div/div/div/form[1]/input[6]"));
		image.sendKeys(propertyImage);

		WebElement submit = this.driver.findElement(By.xpath("/html/body/div/div/div/div/form[1]/div[3]/button"));
		submit.click();

		Thread.sleep(1000);

		WebElement sellerButton = this.driver
				.findElement(By.cssSelector("#root > div > div > header > nav > div.App-nav > a:nth-child(3)"));
		sellerButton.click();

		Thread.sleep(1000);

		WebElement propertyButton2 = this.driver
				.findElement(By.cssSelector("#root > div > div > header > nav > div.App-nav > a:nth-child(4)"));
		propertyButton2.click();

		WebElement cardScroll = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/p/p[1]"));
		this.driver.executeScript("arguments[0].scrollIntoView(true);", cardScroll);

		Thread.sleep(1000);

		WebElement resultAddress = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/p/p[1]"));
		Assertions.assertEquals("Address: 742 Evergreen Terrace", resultAddress.getText());

		WebElement resultLocation = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/p/p[2]"));
		Assertions.assertEquals("Location: Springfield", resultLocation.getText());

		WebElement resultPrice = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/p/p[3]"));
		Assertions.assertEquals("Price: £ 150000", resultPrice.getText());

		WebElement resultPropertyType = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/p/p[4]"));
		Assertions.assertEquals("Type of Property: Detached", resultPropertyType.getText());

		WebElement resultBedrooms = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/p/p[5]"));
		Assertions.assertEquals("No. of Bedrooms: 4", resultBedrooms.getText());

		WebElement resultBathrooms = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/p/p[6]"));
		Assertions.assertEquals("No. of Bathrooms:2", resultBathrooms.getText());

		WebElement resultGarden = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/p/p[7]"));
		Assertions.assertEquals("Garden Yes", resultGarden.getText());

		WebElement resultStatus = this.driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/p/p[8]"));
		Assertions.assertEquals("Status: For Sale", resultStatus.getText());
	}
}
