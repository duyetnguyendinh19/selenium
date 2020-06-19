package com.vn.VNDirect;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterTest {

	public static WebDriver driver;
	public static String url = "https://accounts.vndirect.com.vn/";
	public static final String webDriver = "webdriver.chrome.driver";
	
	public static final String pathDriver = System.getProperty("user.dir")+"\\Tool\\chromedriver.exe";
	public static WebElement webElement;
	public static List<WebElement> lstWebElement;
	public String xPathErrorFullName = "/html/body/div[1]/div/div[2]/div/div/form/div[2]/div/div[1]/div[1]/div/div/span";
	public String xPathErrorPhone = "/html/body/div[1]/div/div[2]/div/div/form/div[2]/div/div[1]/div[2]/div/div/span";
	public String xPathErrorEmail = "/html/body/div[1]/div/div[2]/div/div/form/div[2]/div/div[2]/div/div/div/span";
	public String xPathErrorUserName = "/html/body/div[1]/div/div[2]/div/div/form/div[2]/div/div[3]/div/div/div/span";
	public String xPathErrorPassword = "/html/body/div[1]/div/div[2]/div/div/form/div[2]/div/div[4]/div[1]/div/div/span";
	public String xPathErrorConfirmPassword = "/html/body/div[1]/div/div[2]/div/div/form/div[2]/div/div[4]/div[2]/div/div/span";
	public String xPathCheckBox = "/html/body/div[1]/div/div[2]/div/div/form/div[2]/div/div[5]/label";
	public String xPathButtonAccept = "/html/body/div[1]/div/div[2]/div/div/form/div[2]/div/div[6]/button";
	public String xPathTitle = "/html/body/div[1]/div/div[2]/div/div/form/div[2]/h4";
	String namePhone = "phone";
	String nameFullName = "fullName";
	String nameEmail = "email";
	String nameUserName = "username";
	String namePassword = "password";
	String nameConfirmPassword = "confirmPassword";
	public Account account;
	String emptyError = "Vui lòng không bỏ trống trường này";
	String errorPhone = "Sai định dạng số điện thoại";
	String notMatchPass = "Mật khẩu không trùng nhau";
	String errorEmail = "Vui lòng nhập email đúng định dạng";
	String errorUserName = "Tên đăng nhập phải chứa tối thiểu 6 ký tự";
	String errorPass = "Mật khẩu phải có tối thiểu 8 ký tự và tối đa 32 ký tự";
	String errorLengthEmail = "Email phải có tối thiểu 20 ký tự và tối đa 50 ký tự";
	String errorPhoneEx = "SĐT này đã tồn tại";
	String errorEmailEx = "Email này đã tồn tại";
	
	@BeforeTest()
	public void setUp() {
		System.setProperty(webDriver, pathDriver);
		driver = new ChromeDriver();
		driver.get(url);
		webElement = driver.findElement(By.xpath(xPathCheckBox));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", webElement);
	}
	
	@BeforeMethod
	public void before() {
		account = new Account("Kiều Thị Yến Vy","0854256406","kieuyenvy0512@gmail.com","kieuyenvy612", "Kieuvy123", "Kieuvy123");
		webElement = driver.findElement(By.name(nameFullName));
		webElement.clear();
		webElement = driver.findElement(By.name(namePhone));
		webElement.clear();
		webElement = driver.findElement(By.name(nameEmail));
		webElement.clear();
		webElement = driver.findElement(By.name(nameUserName));
		webElement.clear();
		webElement = driver.findElement(By.name(namePassword));
		webElement.clear();
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.clear();
	}
	
	
//	@Test(testName = "Thành công", description = "Thành công")
//	public void test01() {
//		webElement = driver.findElement(By.name(nameFullName));
//		webElement.sendKeys(account.getFullName());
//		webElement = driver.findElement(By.name(namePhone));
//		webElement.sendKeys(account.getPhone());
//		webElement = driver.findElement(By.name(nameEmail));
//		webElement.sendKeys(account.getEmail());
//		webElement = driver.findElement(By.name(nameUserName));
//		webElement.sendKeys(account.getUserName());
//		webElement = driver.findElement(By.name(namePassword));
//		webElement.sendKeys(account.getPassWord());
//		webElement = driver.findElement(By.name(nameConfirmPassword));
//		webElement.sendKeys(account.getConfirmPassWord());
//		webElement = driver.findElement(By.xpath(xPathButtonAccept));
//		webElement.click();
//	}
	
	@Test(testName = "Bỏ trống họ và tên", description = "Bỏ trống họ và tên")
	public void test02() {
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
	}
	
	@Test(testName = "Bỏ trống họ và tên, số điện thoại", description = "Bỏ trống họ và tên, số điện thoại")
	public void test03() {
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		//webElement = driver.findElement(By.xpath(xPathCheckBox));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", webElement);
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
	}
	
	@Test(testName = "Bỏ trống họ và tên, số điện thoại, email", description = "Bỏ trống họ và tên, số điện thoại, email")
	public void test04() {
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		//webElement = driver.findElement(By.xpath(xPathCheckBox));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", webElement);
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
	}
	
	@Test(testName = "Bỏ trống họ và tên, số điện thoại, email, tên đăng nhập", description = "Bỏ trống họ và tên, số điện thoại, email, tên đăng nhập")
	public void test05() {
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		//webElement = driver.findElement(By.xpath(xPathCheckBox));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", webElement);
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
	}
	
	@Test(testName = "Bỏ trống họ và tên, số điện thoại, email, tên đăng nhập, mật khẩu", description = "Bỏ trống họ và tên, số điện thoại, email, tên đăng nhập, mật khẩu")
	public void test06() {
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		//webElement = driver.findElement(By.xpath(xPathCheckBox));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", webElement);
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
	}
	
	@Test(testName = "Bỏ trống họ và tên, số điện thoại, email, tên đăng nhập, mật khẩu, xác nhận mật khẩu", description = "Bỏ trống họ và tên, số điện thoại, email, tên đăng nhập, mật khẩu, xác nhận mật khẩu")
	public void test07() {
		//webElement = driver.findElement(By.xpath(xPathCheckBox));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", webElement);
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
	}
	
	
	
	@Test(testName = "Bỏ trống điện thoại,email, tên đăng nhập, mật khẩu, xác nhận mật khẩu", description = "Bỏ trống điện thoại,email, tên đăng nhập, mật khẩu, xác nhận mật khẩu")
	public void test08() {
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
	}
	
	@Test(testName = "Bỏ trống email, tên đăng nhập, mật khẩu, xác nhận mật khẩu", description = "Bỏ trống email, tên đăng nhập, mật khẩu, xác nhận mật khẩu")
	public void test09() {
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
	}
	
	@Test(testName = "Bỏ trống tên đăng nhập, mật khẩu, xác nhận mật khẩu", description = "Bỏ trống tên đăng nhập, mật khẩu, xác nhận mật khẩu")
	public void test10() {
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
	}
	
	@Test(testName = "Bỏ trống mật khẩu, xác nhận mật khẩu", description = "Bỏ trống mật khẩu, xác nhận mật khẩu")
	public void test11() {
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
	}
	
	@Test(testName = "Bỏ trống  xác nhận mật khẩu", description = "Bỏ trống  xác nhận mật khẩu")
	public void test12() {
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
	}
	
	@Test(testName = "Mật khẩu không trùng nhau", description = "Mật khẩu không trùng nhau")
	public void test13() {
		account.setConfirmPassWord("1");;
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals("Mật khẩu không trùng nhau", webElement.getText());
	}
	
	@Test(testName = "Mật khẩu phải có tối thiểu 8 ký tự và tối đa 32 ký tự (quá 32), Xác nhận mật khẩu trống", 
			description = "Mật khẩu phải có tối thiểu 8 ký tự và tối đa 32 ký tự(quá 32), Xác nhận mật khẩu trống")
	public void test14() {
		account.setPassWord("Kieuvy1233333333333333333333333333333333333333333333");
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals("Mật khẩu phải có tối thiểu 8 ký tự và tối đa 32 ký tự", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
	}
	
	@Test(testName = "Mật khẩu phải có tối thiểu 8 ký tự và tối đa 32 ký tự (quá 32),Mật khẩu không trùng nhau", 
			description = "Mật khẩu phải có tối thiểu 8 ký tự và tối đa 32 ký tự(quá 32), Mật khẩu không trùng nhau")
	public void test15() {
		account.setPassWord("Kieuvy1233333333333333333333333333333333333333333333");
		account.setConfirmPassWord("1");
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals("Mật khẩu phải có tối thiểu 8 ký tự và tối đa 32 ký tự", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals("Mật khẩu không trùng nhau", webElement.getText());
	}
	
	@Test(testName = "Mật khẩu phải có tối thiểu 8 ký tự và tối đa 32 ký tự (nhỏ hơn 8), Xác nhận mật khẩu trống", 
			description = "Mật khẩu phải có tối thiểu 8 ký tự và tối đa 32 ký tự(nhỏ hơn 8), Xác nhận mật khẩu trống")
	public void test16() {
		account.setPassWord("Kieuvy");
		account.setConfirmPassWord("");
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals("Mật khẩu phải có tối thiểu 8 ký tự và tối đa 32 ký tự", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals("Vui lòng không bỏ trống trường này", webElement.getText());
	}
	
	@Test(testName = "Mật khẩu phải có tối thiểu 8 ký tự và tối đa 32 ký tự (nhỏ hơn 8),Mật khẩu không trùng nhau", 
			description = "Mật khẩu phải có tối thiểu 8 ký tự và tối đa 32 ký tự(nhỏ hơn 8), Mật khẩu không trùng nhau")
	public void test17() {
		account.setPassWord("Kieuvy");
		account.setConfirmPassWord("1");
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals("Mật khẩu phải có tối thiểu 8 ký tự và tối đa 32 ký tự", webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals("Mật khẩu không trùng nhau", webElement.getText());
	}
	
	@Test(testName = "Sai định dạng sđt(9 số)", 
			description = "Sai định dạng sđt(9 số)")
	public void test18() {
		account.setPhone("085425640");
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals("Sai định dạng số điện thoại", webElement.getText());
	}

//	@Test(testName = "Sai định dạng sđt(11 số)", 
//			description = "Sai định dạng sđt(11 số)")
//	public void test19() {
//		account.setPhone("08542564066");
//		webElement = driver.findElement(By.name(nameFullName));
//		webElement.sendKeys(account.getFullName());
//		webElement = driver.findElement(By.name(namePhone));
//		webElement.sendKeys(account.getPhone());
//		webElement = driver.findElement(By.name(nameEmail));
//		webElement.sendKeys(account.getEmail());
//		webElement = driver.findElement(By.name(nameUserName));
//		webElement.sendKeys(account.getUserName());
//		webElement = driver.findElement(By.name(namePassword));
//		webElement.sendKeys(account.getPassWord());
//		webElement = driver.findElement(By.name(nameConfirmPassword));
//		webElement.sendKeys(account.getConfirmPassWord());
//		webElement = driver.findElement(By.xpath(xPathButtonAccept));
//		webElement.click();
//		webElement = driver.findElement(By.xpath(xPathErrorPhone));
//		assertEquals("Sai định dạng số điện thoại", webElement.getText());
//	}
	
	@Test(testName = "Sai định dạng sđt(9 số), để trống họ và tên", 
			description = "Sai định dạng sđt(9 số), để trống họ và tên")
	public void test20() {
		account.setPhone("085425640");
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhone, webElement.getText());
	}
	
//	@Test(testName = "Sai định dạng sđt(11 số), để trống họ và tên", 
//			description = "Sai định dạng sđt(11 số), để trống họ và tên")
//	public void test21() {
//		account.setPhone("08542564066");
//		webElement = driver.findElement(By.name(namePhone));
//		webElement.sendKeys(account.getPhone());
//		webElement = driver.findElement(By.name(nameEmail));
//		webElement.sendKeys(account.getEmail());
//		webElement = driver.findElement(By.name(nameUserName));
//		webElement.sendKeys(account.getUserName());
//		webElement = driver.findElement(By.name(namePassword));
//		webElement.sendKeys(account.getPassWord());
//		webElement = driver.findElement(By.name(nameConfirmPassword));
//		webElement.sendKeys(account.getConfirmPassWord());
//		webElement = driver.findElement(By.xpath(xPathButtonAccept));
//		webElement.click();
//		webElement = driver.findElement(By.xpath(xPathErrorFullName));
//		assertEquals(emptyError, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorPhone));
//		assertEquals(errorPhone, webElement.getText());
//	}
	
	
	@Test(testName = "Sai định dạng sđt(9 số), để trống họ và tên và tên đăng nhập", 
			description = "Sai định dạng sđt(9 số), để trống họ và tên và tên đăng nhập")
	public void test22() {
		account.setPhone("085425640");
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhone, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(emptyError, webElement.getText());
	}
	
//	@Test(testName = "Sai định dạng sđt(11 số), để trống họ và tên và tên đăng nhập", 
//			description = "Sai định dạng sđt(11 số), để trống họ và tên và tên đăng nhập")
//	public void test23() {
//		account.setPhone("08542564066");
//		webElement = driver.findElement(By.name(namePhone));
//		webElement.sendKeys(account.getPhone());
//		webElement = driver.findElement(By.name(nameEmail));
//		webElement.sendKeys(account.getEmail());
//		webElement = driver.findElement(By.name(namePassword));
//		webElement.sendKeys(account.getPassWord());
//		webElement = driver.findElement(By.name(nameConfirmPassword));
//		webElement.sendKeys(account.getConfirmPassWord());
//		webElement = driver.findElement(By.xpath(xPathButtonAccept));
//		webElement.click();
//		webElement = driver.findElement(By.xpath(xPathErrorFullName));
//		assertEquals(emptyError, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorPhone));
//		assertEquals(errorPhone, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorUserName));
//		assertEquals(emptyError, webElement.getText());
//	}
	
	@Test(testName = "Sai định dạng sđt(9 số), để trống họ và tên và tên đăng nhập và email", 
			description = "Sai định dạng sđt(9 số), để trống họ và tên và tên đăng nhập và email")
	public void test24() {
		account.setPhone("085425640");
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhone, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(emptyError, webElement.getText());
	}
	
//	@Test(testName = "Sai định dạng sđt(11 số), để trống họ và tên và tên đăng nhập và email", 
//			description = "Sai định dạng sđt(11 số), để trống họ và tên và tên đăng nhập và email")
//	public void test25() {
//		account.setPhone("08542564066");
//		webElement = driver.findElement(By.name(namePhone));
//		webElement.sendKeys(account.getPhone());
//		webElement = driver.findElement(By.name(namePassword));
//		webElement.sendKeys(account.getPassWord());
//		webElement = driver.findElement(By.name(nameConfirmPassword));
//		webElement.sendKeys(account.getConfirmPassWord());
//		webElement = driver.findElement(By.xpath(xPathButtonAccept));
//		webElement.click();
//		webElement = driver.findElement(By.xpath(xPathErrorFullName));
//		assertEquals(emptyError, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorPhone));
//		assertEquals(errorPhone, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorUserName));
//		assertEquals(emptyError, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorEmail));
//		assertEquals(emptyError, webElement.getText());
//	}
	
//	@Test(testName = "Sai định dạng sđt(11 số), để trống họ và tên và tên đăng nhập và email và mật khẩu", 
//			description = "Sai định dạng sđt(11 số), để trống họ và tên và tên đăng nhập và email và mật khẩu")
//	public void test26() {
//		account.setPhone("08542564066");
//		webElement = driver.findElement(By.name(namePhone));
//		webElement.sendKeys(account.getPhone());
//		webElement = driver.findElement(By.name(nameConfirmPassword));
//		webElement.sendKeys(account.getConfirmPassWord());
//		webElement = driver.findElement(By.xpath(xPathButtonAccept));
//		webElement.click();
//		webElement = driver.findElement(By.xpath(xPathErrorFullName));
//		assertEquals(emptyError, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorPhone));
//		assertEquals(errorPhone, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorUserName));
//		assertEquals(emptyError, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorEmail));
//		assertEquals(emptyError, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorPassword));
//		assertEquals(emptyError, webElement.getText());
//	}
	
	@Test(testName = "Sai định dạng sđt(9 số), để trống họ và tên và tên đăng nhập và email và mật khẩu", 
			description = "Sai định dạng sđt(9 số), để trống họ và tên và tên đăng nhập và email và mật khẩu")
	public void test27() {
		account.setPhone("085425640");
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhone, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals(emptyError, webElement.getText());
	}
	
//	@Test(testName = "Sai định dạng sđt(11 số), để trống họ và tên và tên đăng nhập và email và mật khẩu và xác nhận mật khẩu", 
//			description = "Sai định dạng sđt(11 số), để trống họ và tên và tên đăng nhập và email và mật khẩu và xác nhận mật khẩu")
//	public void test28() {
//		account.setPhone("08542564066");
//		webElement = driver.findElement(By.name(namePhone));
//		webElement.sendKeys(account.getPhone());
//		webElement = driver.findElement(By.xpath(xPathButtonAccept));
//		webElement.click();
//		webElement = driver.findElement(By.xpath(xPathErrorFullName));
//		assertEquals(emptyError, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorPhone));
//		assertEquals(errorPhone, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorUserName));
//		assertEquals(emptyError, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorEmail));
//		assertEquals(emptyError, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorPassword));
//		assertEquals(emptyError, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
//		assertEquals(emptyError, webElement.getText());
//	}
	
	@Test(testName = "Sai định dạng sđt(9 số), để trống họ và tên và tên đăng nhập và email và mật khẩu và xác nhận mật khẩu", 
			description = "Sai định dạng sđt(9 số), để trống họ và tên và tên đăng nhập và email và mật khẩu và xác nhận mật khẩu")
	public void test29() {
		account.setPhone("085425640");
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhone, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals(emptyError, webElement.getText());
	}
	
//	@Test(testName = "Sai định dạng sđt(11 số), để trống họ và tên và tên đăng nhập và email, Mật khẩu không khớp", 
//			description = "Sai định dạng sđt(11 số), để trống họ và tên và tên đăng nhập và email, Mật khẩu không khớp")
//	public void test30() {
//		account.setPhone("08542564066");
//		account.setConfirmPassWord("1");
//		webElement = driver.findElement(By.name(namePhone));
//		webElement.sendKeys(account.getPhone());
//		webElement = driver.findElement(By.name(namePassword));
//		webElement.sendKeys(account.getPassWord());
//		webElement = driver.findElement(By.name(nameConfirmPassword));
//		webElement.sendKeys(account.getConfirmPassWord());
//		webElement = driver.findElement(By.xpath(xPathButtonAccept));
//		webElement.click();
//		webElement = driver.findElement(By.xpath(xPathErrorFullName));
//		assertEquals(emptyError, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorPhone));
//		assertEquals(errorPhone, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorUserName));
//		assertEquals(emptyError, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorEmail));
//		assertEquals(emptyError, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
//		assertEquals(notMatchPass, webElement.getText());
//	}
	
	@Test(testName = "Sai định dạng sđt(9 số), để trống họ và tên và tên đăng nhập và email, Mật khẩu không khớp", 
			description = "Sai định dạng sđt(9 số), để trống họ và tên và tên đăng nhập và email, Mật khẩu không khớp")
	public void test31() {
		account.setPhone("085425640");
		account.setConfirmPassWord("1");
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhone, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals(notMatchPass, webElement.getText());
	}
	
	@Test(testName = "Email sai định dạng", 
			description = "Email sai định dạng")
	public void test32() {
		account.setEmail("kieuyenvy0512@gmail");
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmail, webElement.getText());
	}
	
	@Test(testName = "Email sai định dạng, bỏ trống họ tên", 
			description = "Email sai định dạng, bỏ trống họ tên")
	public void test33() {
		account.setEmail("kieuyenvy0512@gmail");
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmail, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
	}
	
	@Test(testName = "Email sai định dạng, bỏ trống họ tên và số đt", 
			description = "Email sai định dạng, bỏ trống họ tên và số đt")
	public void test34() {
		account.setEmail("kieuyenvy0512@gmail");
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmail, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(emptyError, webElement.getText());
	}
	
	@Test(testName = "Email sai định dạng, bỏ trống họ tên và số đt và tên đăng nhập", 
			description = "Email sai định dạng, bỏ trống họ tên và số đt và tên đăng nhập")
	public void test35() {
		account.setEmail("kieuyenvy0512@gmail");
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmail, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(emptyError, webElement.getText());
	}
	
	@Test(testName = "Email sai định dạng, bỏ trống họ tên và số đt và tên đăng nhập và mật khẩu, mật khẩu không trùng", 
			description = "Email sai định dạng, bỏ trống họ tên và số đt và tên đăng nhập và mật khẩu, mật khẩu không trùng")
	public void test36() {
		account.setEmail("kieuyenvy0512@gmail");
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmail, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals(notMatchPass, webElement.getText());
	}
	
	@Test(testName = "Email sai định dạng, bỏ trống họ tên và số đt và tên đăng nhập , mật khẩu không trùng", 
			description = "Email sai định dạng, bỏ trống họ tên và số đt và tên đăng nhập , mật khẩu không trùng")
	public void test37() {
		account.setEmail("kieuyenvy0512@gmail");
		account.setConfirmPassWord("1");
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmail, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals(notMatchPass, webElement.getText());
	}
	
	@Test(testName = "Tên đăng nhập 5 ký tư", 
			description = "Tên đăng nhập 5 ký tư")
	public void test38() {
		account.setUserName("vy123");
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(errorUserName, webElement.getText());
	}
	
	@Test(testName = "Tên đăng nhập 5 ký tư, bỏ trống họ tên", 
			description = "Tên đăng nhập 5 ký tư, bỏ trống họ tên")
	public void test39() {
		account.setUserName("vy123");
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(errorUserName, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
	}
	
	@Test(testName = "Tên đăng nhập 5 ký tư, bỏ trống họ tên và sđt", 
			description = "Tên đăng nhập 5 ký tư, bỏ trống họ tên và sđt")
	public void test40() {
		account.setUserName("vy123");
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(errorUserName, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(emptyError, webElement.getText());
	}
	
	@Test(testName = "Tên đăng nhập 5 ký tư, bỏ trống họ tên và sđt và email", 
			description = "Tên đăng nhập 5 ký tư, bỏ trống họ tên và sđt và email")
	public void test41() {
		account.setUserName("vy123");
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(errorUserName, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(emptyError, webElement.getText());
	}

	@Test(testName = "Tên đăng nhập 5 ký tư, bỏ trống họ tên và sđt và email và mật khẩu", 
			description = "Tên đăng nhập 5 ký tư, bỏ trống họ tên và sđt và email và mật khẩu")
	public void test42() {
		account.setUserName("vy123");
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(errorUserName, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals(emptyError, webElement.getText());
	}
	
	@Test(testName = "Tên đăng nhập 5 ký tư, bỏ trống họ tên và sđt và email và mật khẩu và xác nhận mật khẩu", 
			description = "Tên đăng nhập 5 ký tư, bỏ trống họ tên và sđt và email và mật khẩu và xác nhận mật khẩu")
	public void test43() {
		account.setUserName("vy123");
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(errorUserName, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals(emptyError, webElement.getText());
	}
	
	@Test(testName = "Tên đăng nhập 5 ký tư, bỏ trống họ tên và email và mật khẩu và xác nhận mật khẩu", 
			description = "Tên đăng nhập 5 ký tư, bỏ trống họ tên và email và mật khẩu và xác nhận mật khẩu")
	public void test44() {
		account.setUserName("vy123");
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(errorUserName, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals(emptyError, webElement.getText());
	}
	
	@Test(testName = "Tên đăng nhập 5 ký tư, bỏ trống mật khẩu và xác nhận mật khẩu", 
			description = "Tên đăng nhập 5 ký tư, bỏ trống mật khẩu và xác nhận mật khẩu")
	public void test45() {
		account.setUserName("vy123");
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals(emptyError, webElement.getText());
	}
	

	@Test(testName = "Tên đăng nhập 5 ký tư và xác nhận mật khẩu không khớp", 
			description = "Tên đăng nhập 5 ký tư và xác nhận mật khẩu không khớp")
	public void test46() {
		account.setUserName("vy123");
		account.setConfirmPassWord("1");
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(errorUserName, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals(notMatchPass, webElement.getText());
	}
	
	@Test(testName = "Tên đăng nhập 5 ký tư và mật khẩu nhập 7 ký tự và xác nhận mật khẩu trống", 
			description = "Tên đăng nhập 5 ký tư và mật khẩu nhập 7 ký tự và xác nhận mật khẩu trống")
	public void test47() {
		account.setUserName("vy123");
		account.setPassWord("Kieuvy");
		account.setConfirmPassWord("");
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(errorUserName, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals(errorPass, webElement.getText());
	}
	
	@Test(testName = "Tên đăng nhập 5 ký tư và mật khẩu nhập 33 ký tự và xác nhận mật khẩu trống", 
			description = "Tên đăng nhập 5 ký tư và mật khẩu nhập 33 ký tự và xác nhận mật khẩu trống")
	public void test48() {
		account.setUserName("vy123");
		account.setPassWord("Kieuvy11111111111111111111111111");
		account.setConfirmPassWord("");
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(errorUserName, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals(emptyError, webElement.getText());
//		webElement = driver.findElement(By.xpath(xPathErrorPassword));
//		assertEquals(errorPass, webElement.getText());
	}
	
	@Test(testName = "Tên đăng nhập 5 ký tư và sđt 9 ký tự", 
			description = "Tên đăng nhập 5 ký tư và sđt 9 ký tự")
	public void test49() {
		account.setUserName("vy123");
		account.setPhone("085425640");;
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(errorUserName, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhone, webElement.getText());
	}
	
	@Test(testName = "Tên đăng nhập 5 ký tư và email sai định dạng", 
			description = "Tên đăng nhập 5 ký tư và email sai định dạng")
	public void test50() {
		account.setUserName("vy123");
		account.setEmail("kieuyenvy0512@gmail");;
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(errorUserName, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmail, webElement.getText());
	}
	
	@Test(testName = "Email 11 ký tự", 
			description = "Email 11 ký tự")
	public void test51() {
		account.setEmail("v@gmail.com");;
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
//		webElement = driver.findElement(By.xpath(xPathButtonAccept));
//		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorLengthEmail, webElement.getText());
	}
	
	@Test(testName = "Email 51 ký tự", 
			description = "Email 51 ký tự")
	public void test52() {
		account.setEmail("vykty6133333333333333333333333333333333333333333332@gmail.com");;
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
//		webElement = driver.findElement(By.xpath(xPathButtonAccept));
//		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorLengthEmail, webElement.getText());
	}
	
	@Test(testName = "SĐT đã tồn tại", 
			description = "SĐT đã tồn tại")
	public void test53() {
		account.setPhone("0123456789");
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhoneEx, webElement.getText());
	}
	
	@Test(testName = "SĐT đã tồn tại và bỏ trống họ tên", 
			description = "SĐT đã tồn tại và bỏ trống họ tên")
	public void test54() {
		account.setPhone("0123456789");
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhoneEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
	}
	
	@Test(testName = "SĐT đã tồn tại và bỏ trống họ tên, email", 
			description = "SĐT đã tồn tại và bỏ trống họ tên, email")
	public void test55() {
		account.setPhone("0123456789");
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhoneEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(emptyError, webElement.getText());
	}
	
	@Test(testName = "SĐT đã tồn tại và bỏ trống họ tên, email, tên đăng nhập", 
			description = "SĐT đã tồn tại và bỏ trống họ tên, email, tên đăng nhập")
	public void test56() {
		account.setPhone("0123456789");
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhoneEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(emptyError, webElement.getText());
	}
	
	@Test(testName = "Email đã tồn tại và bỏ trống họ tên", 
			description = "Email đã tồn tại và bỏ trống họ tên")
	public void test57() {
		account.setEmail("abc@gmail.com");
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmailEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
	}
	
	@Test(testName = "Email đã tồn tại và bỏ trống họ tên,SĐT", 
			description = "Email đã tồn tại và bỏ trống họ tên,SĐT")
	public void test58() {
		account.setEmail("abc@gmail.com");
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmailEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(emptyError, webElement.getText());
	}
	
	@Test(testName = "Email đã tồn tại và bỏ trống họ tên,SĐT,tên đăng nhập", 
			description = "Email đã tồn tại và bỏ trống họ tên,SĐT,tên đăng nhập")
	public void test59() {
		account.setEmail("abc@gmail.com");
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmailEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(emptyError, webElement.getText());
	}
	
	
	@Test(testName = "SĐT và Email đã tồn tại", 
			description = "SĐT và Email đã tồn tại")
	public void test60() {
		account.setPhone("0123456789");
		account.setEmail("abc@gmail.com");
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhoneEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmailEx, webElement.getText());
	}
	
	@Test(testName = "SĐT và Email đã tồn tại, bỏ trống họ tên", 
			description = "SĐT và Email đã tồn tại, bỏ trống họ tên")
	public void test61() {
		account.setPhone("0123456789");
		account.setEmail("abc@gmail.com");
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhoneEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmailEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
	}
	
	@Test(testName = "SĐT và Email đã tồn tại, bỏ trống tên đăng nhập", 
			description = "SĐT và Email đã tồn tại, bỏ trống tên đăng nhập")
	public void test62() {
		account.setPhone("0123456789");
		account.setEmail("abc@gmail.com");
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhoneEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmailEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(emptyError, webElement.getText());
	}
	
	@Test(testName = "SĐT và Email đã tồn tại, bỏ trống tên đăng nhập và họ tên", 
			description = "SĐT và Email đã tồn tại, bỏ trống tên đăng nhập và họ tên")
	public void test63() {
		account.setPhone("0123456789");
		account.setEmail("abc@gmail.com");
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhoneEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmailEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
	}
	
	@Test(testName = "SĐT và Email đã tồn tại, bỏ trống tên đăng nhập và họ tên và mật khẩu và xác nhận mật khẩu", 
			description = "SĐT và Email đã tồn tại, bỏ trống tên đăng nhập và họ tên và mật khẩu và xác nhận mật khẩu")
	public void test64() {
		account.setPhone("0123456789");
		account.setEmail("abc@gmail.com");
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhoneEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmailEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals(emptyError, webElement.getText());
	}
	
	@Test(testName = "SĐT và Email đã tồn tại, họ tên trống, xác nhận mật khẩu không khớp", 
			description = "SĐT và Email đã tồn tại, họ tên trống, xác nhận mật khẩu không khớp")
	public void test65() {
		account.setPhone("0123456789");
		account.setEmail("abc@gmail.com");
		account.setConfirmPassWord("1");
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhoneEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmailEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals(notMatchPass, webElement.getText());
	}
	
	@Test(testName = "SĐT và Email đã tồn tại, tên đăng nhập trên trống, xác nhận mật khẩu trống, mật khẩu trống", 
			description = "SĐT và Email đã tồn tại, tên đăng nhập trống, xác nhận mật khẩu trống, mật khẩu trống")
	public void test66() {
		account.setPhone("0123456789");
		account.setEmail("abc@gmail.com");
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhoneEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmailEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorUserName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals(emptyError, webElement.getText());
	}
	
	@Test(testName = "SĐT và Email đã tồn tại, họ tên trống, xác nhận mật khẩu không khớp", 
			description = "SĐT và Email đã tồn tại, họ tên trống, xác nhận mật khẩu không khớp")
	public void test67() {
		account.setPhone("0123456789");
		account.setEmail("abc@gmail.com");
		account.setConfirmPassWord("Kieuvy1");
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhoneEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmailEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorFullName));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals(notMatchPass, webElement.getText());
	}
	
	@Test(testName = "SĐT và Email đã tồn tại, xác nhận mật khẩu trống, mật khẩu trống", 
			description = "SĐT và Email đã tồn tại, xác nhận mật khẩu trống, mật khẩu trống")
	public void test68() {
		account.setPhone("0123456789");
		account.setEmail("abc@gmail.com");
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhoneEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmailEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals(emptyError, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals(emptyError, webElement.getText());
	}
	
	@Test(testName = "SĐT và Email đã tồn tại, xác nhận mật khẩu không khớp", 
			description = "SĐT và Email đã tồn tại, xác nhận mật khẩu không khớp")
	public void test69() {
		account.setPhone("0123456789");
		account.setEmail("abc@gmail.com");
		account.setConfirmPassWord("Kieuvy1");
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhoneEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmailEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorConfirmPassword));
		assertEquals(notMatchPass, webElement.getText());
	}
	
	@Test(testName = "SĐT và Email đã tồn tại, mật khẩu 7 ký tự", 
			description = "SĐT và Email đã tồn tại, mật khẩu 7 ký tự")
	public void test70() {
		account.setPhone("0123456789");
		account.setEmail("abc@gmail.com");
		account.setConfirmPassWord("Kieuvy1");
		account.setPassWord("Kieuvy1");
		webElement = driver.findElement(By.name(namePhone));
		webElement.sendKeys(account.getPhone());
		webElement = driver.findElement(By.name(nameEmail));
		webElement.sendKeys(account.getEmail());
		webElement = driver.findElement(By.name(nameUserName));
		webElement.sendKeys(account.getUserName());
		webElement = driver.findElement(By.name(nameFullName));
		webElement.sendKeys(account.getFullName());
		webElement = driver.findElement(By.name(namePassword));
		webElement.sendKeys(account.getPassWord());
		webElement = driver.findElement(By.name(nameConfirmPassword));
		webElement.sendKeys(account.getConfirmPassWord());
		webElement = driver.findElement(By.xpath(xPathButtonAccept));
		webElement.click();
		webElement = driver.findElement(By.xpath(xPathErrorPhone));
		assertEquals(errorPhoneEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorEmail));
		assertEquals(errorEmailEx, webElement.getText());
		webElement = driver.findElement(By.xpath(xPathErrorPassword));
		assertEquals(errorPass, webElement.getText());
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
	
	
	class Account {
		private String fullName;
		private String phone;
		private String email;
		private String userName;
		private String passWord;
		private String confirmPassWord;
		
		public Account(String fullName, String phone, String email, String userName, String passWord,
				String confirmPassWord) {
			super();
			this.fullName = fullName;
			this.phone = phone;
			this.email = email;
			this.userName = userName;
			this.passWord = passWord;
			this.confirmPassWord = confirmPassWord;
		}
		
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassWord() {
			return passWord;
		}
		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}
		public String getConfirmPassWord() {
			return confirmPassWord;
		}
		public void setConfirmPassWord(String confirmPassWord) {
			this.confirmPassWord = confirmPassWord;
		}
		
		
	}
	
}
