package test.auto.main;

import handy.files.*;

public class CoffeeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			DataFile dataFile = new ExcelFile("D:\\Book4.xlsx");
			((ExcelFile)dataFile).getAllSheetNames();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hello world");

	}

}
