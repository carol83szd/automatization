package demo.qa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Elements {
	WebDriver driver;
	WebElement elemButton, textBox, checkBox, radioButton, webTablets, buttons, links, brokenLinks, upAndDown,dynamicP;
	List<WebElement> iconButtons;
	
	@BeforeTest
	public void begin() {
		ChromeOptions chrome = new ChromeOptions();
		driver = new ChromeDriver(chrome);
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		iconButtons = driver.findElements(By.xpath("//div[@class='card-up']"));
		elemButton = iconButtons.get(0);
		elemButton.click();
	}
	@DataProvider(name ="dataTextBox")
	public Object[][] data(){
		return new Object[][] {
			{"Alice Johnson","alice@example.com,123", " ddddd","Main St,Apt 1"},
			{"Bob Smith","bob_smith@", "Elm St","Suite 200"},
			{"Carol White","carol.white@example.co","789 Oak St","Floor 3"},
			{"Daniel Brown","daniel.brownexample.com","101 Maple Ave","dddddd"},
			{"Eva Green","eva@green","202 Pine St","Unit 5A"},
			{"Grace Lewis","grace.lewis@example.org","dddd","ddd"}
		};
		
	}
	
	
	@Test(dataProvider = "dataTextBox")
	public void testTextBox(String name, String email, String address1, String address2) throws InterruptedException {
		Thread.sleep(2000);
		textBox = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']"));
		textBox.click();
		Thread.sleep(2000);
		WebElement nameBox, emailBox,address1Box, address2Box, summit;
		nameBox = driver.findElement(By.xpath("//input[@id='userName']"));
		emailBox = driver.findElement(By.xpath("//input[@id='userEmail']"));
		address1Box = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
		address2Box = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
		summit = driver.findElement(By.xpath("//button[@id='submit']"));
		nameBox.clear();
		nameBox.sendKeys(name);
		emailBox.clear();
		emailBox.sendKeys(email);
		address1Box.clear();
		address1Box.sendKeys(address1);
		address2Box.clear();
		address2Box.sendKeys(address2);
		summit.click();
		Thread.sleep(2000);
	}
	
	@Test 
	public void testCheckBox() throws InterruptedException {
		Thread.sleep(2000);
		checkBox = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']"));
		checkBox.click();
		WebElement expand;
		List<WebElement> expand2;
		expand = driver.findElement(By.cssSelector(".rct-icon.rct-icon-expand-close"));
		expand.click();
		Thread.sleep(2000);
		expand2 = driver.findElements(By.cssSelector(".rct-icon.rct-icon-expand-close"));
		int i=0;
		while(i < expand2.size()) {
			expand2.get(i).click();
			Thread.sleep(1000);
			i++;
		}
		List <WebElement> checkBoxes = driver.findElements(By.xpath("//span[@class='rct-title']"));
		for(int a=0;a< 4; a++) {
		int number = (int) (Math.random() * checkBoxes.size());
		checkBoxes.get(number).click();
		Thread.sleep(1000);
		}
	}
	
	@Test
	public void testRadioButtons() throws InterruptedException {
		Thread.sleep(2000);
		radioButton = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-2']"));
		radioButton.click();
		List<WebElement> radio = driver.findElements(By.xpath("//label[@class='custom-control-label']"));
		
		int i =0;
		while(i < radio.size()) {
			radio.get(i).click();
			Thread.sleep(1000);
			radio.clear();
			i++;
			Thread.sleep(1000);
		}
	}
	
	@DataProvider (name ="dpWebTablets")
	public Object[][] dpTablets(){
		return new Object[][] {
			
			    {"John", "Smith", 34, "john.smith@example.com", 45000, "Finance"},
			    {"Emma", "Johnson", 29, "emma.johnson@example.com", 39000, "Marketing"},
			    {"James", "Brown", 42, "james.brown@example.com", 52000, "Human Resources"},
			    {"Olivia", "Jones", 26, "olivia.jones@example.com", 41000, "Sales"},
			    {"Michael", "Taylor", 38, "michael.taylor@example.com", 48000, "Operations"},
			    {"Sophia", "Lee", 31, "sophia.lee@example.com", 44000, "Technology"},
			    {"David", "Walker", 45, "david.walker@example.com", 55000, "Finance"},
			    {"Isabella", "Hall", 28, "isabella.hall@example.com", 39000, "Marketing"},
			    {"Daniel", "Allen", 37, "daniel.allen@example.com", 47000, "Human Resources"},
			    {"Mia", "Young", 33, "mia.young@example.com", 43000, "Sales"},
			    {"Christopher", "Harris", 40, "christopher.harris@example.com", 51000, "Operations"},
			    {"Charlotte", "Clark", 25, "charlotte.clark@example.com", 40000, "Technology"},
			    {"Matthew", "Lewis", 36, "matthew.lewis@example.com", 46000, "Finance"},
			    {"Amelia", "Robinson", 27, "amelia.robinson@example.com", 39000, "Marketing"}
			};
	}
	@Test(dataProvider = "dpWebTablets")
	public void testWebTabletsAdd(String userName, String userLastName, int userAge, String userEm, int userSalary, String userDepartment) throws InterruptedException {
		Thread.sleep(2000);
		webTablets = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']"));
		webTablets.click();
		Thread.sleep(2000);
		WebElement addNew = driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
		addNew.click();
		WebElement firstName = driver.findElement(By.xpath("//div//input[@id='firstName']"));
		WebElement lastName = driver.findElement(By.xpath("//div//input[@id='lastName']"));
		WebElement age = driver.findElement(By.xpath("//div//input[@id='age']"));
		WebElement email = driver.findElement(By.xpath("//div//input[@id='userEmail']"));
		WebElement salary = driver.findElement(By.xpath("//div//input[@id='salary']"));
		WebElement department = driver.findElement(By.xpath("//div//input[@id='department']"));
		WebElement btnSummit = driver.findElement(By.xpath("//div//button[@id='submit']"));
		firstName.clear();
		firstName.sendKeys(userName);
		lastName.clear();
		lastName.sendKeys(userLastName);
		age.clear();
		age.sendKeys(userAge+"");
		email.clear();
		email.sendKeys(userEm);
		salary.clear();
		salary.sendKeys(userSalary+"");
		department.clear();
		department.sendKeys(userDepartment);
		btnSummit.click();
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void after() {
		driver.close();
		
	}
	

}
