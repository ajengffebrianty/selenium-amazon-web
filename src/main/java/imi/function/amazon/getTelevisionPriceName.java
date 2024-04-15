package imi.function.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class getTelevisionPriceName {
	WebDriver driver;

	public getTelevisionPriceName() {
		this.driver = driver;
	}

	public List<Television> listOfTelevision(List<WebElement> productList) {
		List<Television> product = new ArrayList<Television>();
		if (!productList.isEmpty()) {
			for (WebElement inputElement : productList) {
				Television tv = new Television();
				if (!inputElement
						.findElements(By.xpath(".//span[@class='a-size-base-plus a-color-base a-text-normal']"))
						.isEmpty()) {
					String name = inputElement
							.findElement(By.xpath(".//span[@class='a-size-base-plus a-color-base a-text-normal']"))
							.getText();
					tv.setName(name);
				}
				if (!inputElement.findElements(By.xpath(".//span[@class='a-price-whole']")).isEmpty()) {
					String price = inputElement.findElement(By.xpath(".//span[@class='a-price-symbol']")).getText()
							+ inputElement.findElement(By.xpath(".//span[@class='a-price-whole']")).getText() + "."
							+ inputElement.findElement(By.xpath(".//span[@class='a-price-fraction']")).getText();
					tv.setPrice(price);
				} else {
					tv.setPrice("Price not found");
				}
				product.add(tv);
			}
		}
		return product;
	}
}
