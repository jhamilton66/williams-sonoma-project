package com.sqa.jh;

import org.testng.*;
import org.testng.annotations.*;

import com.sqa.jh.data.*;

public class DataHelperTest {
	@DataProvider(name = "textData")
	public Object[][] getData() {
		Object[][] data;
		data = DataHelper.getTextFileData("src/main/resources/", "data.csv", TextFormat.CSV, true, Integer.TYPE,
				Boolean.TYPE);
		DisplayHelper.multArray(data);
		return data;
	}

	@Test(dataProvider = "textData")
	public void textReadingFile(int number, boolean isPrime) {
		System.out.println("Number " + number + ", is Prime? (" + isPrime + ")");
		boolean actualResult = isPrime(number);
		Assert.assertEquals(actualResult, isPrime, "Number is not prime base on data set.");

	}

	/**
	 * @param number
	 * @return
	 */
	private boolean isPrime(int number) {
		boolean isPrime = true;
		for (int i = 2; i <= number / 2; i++) {
			if (number % i != 0) {
				isPrime = false;
			}
		}
		return isPrime;
	}
}
