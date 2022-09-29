package poppin.org;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public static WebDriver driver;
	public static Actions a;
	
	//1
		public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}

		//2
	public static void winMax() {
		driver.manage().window().maximize();
		}
	
	//3
		public static void loadUrl(String url) {
		driver.get(url);
	}
	
		//4
	public static void printTitle() {
		String title=driver.getTitle();
	System.out.println(title);	
	}
	
	//5
	public static void printCurrentUrl() {
		String url=driver.getCurrentUrl();
	System.out.println(url);
	}
	
	//6
	public static void fill(WebElement ele, String value) {
		//WebElementRef.sendKeys("");
		ele.sendKeys(value);
	}
	
	//7
	public static void btnClick(WebElement ele) {
		ele.click();
	}
	
	//8
	public static void closeBrowser() {
		driver.close();
	}
	
	
	
	//9
	public static void rightClick(WebElement ele) {
		a =new Actions(driver);
		a.contextClick(ele).perform();
	}
	
	//10
	public static void dClick(WebElement ele) {
		a =new Actions(driver);
		a.doubleClick(ele).perform();
	}
	
	
	public  static String getData(int rowNumber, int cellNumber,String sheetName ,String filePath) throws IOException {
		//File location
		
	File f = new File(filePath);
	//File f = new File("C:\\Users\\user\\eclipse-workspace\\Clone Maven Configuration\\GITAug-17\\Excel\\SampleExcel.xlsx");
		//read the value from excel
		FileInputStream fin = new FileInputStream(f);
		
		//type of workbook
		Workbook w = new XSSFWorkbook(fin);
		
		//to get the sheet 
		Sheet s = w.getSheet(sheetName);
		
		Row row = s.getRow(rowNumber);

		Cell cell = row.getCell(cellNumber);
		
		int cellType = cell.getCellType();
		
		String value="";
		
		if (cellType==1) {
		value = cell.getStringCellValue();
		}

		else if (DateUtil.isCellDateFormatted(cell)) {
			
			Date d = cell.getDateCellValue();
			
			SimpleDateFormat sim = new SimpleDateFormat("dd, MMMM, yyyy");
			value = sim.format(d);
			System.out.println(value);
		}
		else {
			double d = cell.getNumericCellValue();
			
			//decimal t long, long to  string
			
			long l= (long)d;
			
			value = String.valueOf(l);
		}
			return value;

			
}
}
