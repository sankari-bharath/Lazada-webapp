package com.lazada;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Utilities.XLUtils;
import pageObject.BaseClass;
import pageObject.login_pageObject;

public class TC01_LoginPage extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws IOException, InterruptedException {
		login_pageObject lg = new login_pageObject(driver);
		// driver.switchTo().frame(0);
		Thread.sleep(3000);
		lg.userid(user);
		logger.info("Username has been entered");
		Thread.sleep(3000);
		lg.password(pwd);
		logger.info("password has been entered");
		lg.loginn();
		Thread.sleep(5000);
		logger.info("Successffuly loggedin");
		// driver.switchTo().defaultContent();

	}

	@DataProvider(name = "LoginData")
	public Object[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/main/java/TestData/logindata.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j); // 1 0

			}
		}

		return logindata;

	}

}
