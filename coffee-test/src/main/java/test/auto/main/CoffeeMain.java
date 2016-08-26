package test.auto.main;

import java.io.IOException;

import handy.files.*;

public class CoffeeMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataFile dataFile = null;
		try {
			dataFile = new ExcelFile("D:\\Book4.xlsx");
			//((ExcelFile)dataFile).getAllSheetNames();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hello world");
		try {
			((ExcelFile)dataFile).getAllSheetNames();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dataFile.closeStreams();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
