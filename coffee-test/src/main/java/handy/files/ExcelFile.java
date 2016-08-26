package handy.files;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PushbackInputStream;

import org.apache.poi.EmptyFileException;
import org.apache.poi.OldFileFormatException;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelFile extends DataFile {
	
	private POIFSFileSystem fileSystem = null;
	private Workbook workBook = null;
	private Sheet[] sheets = null;
	//private XSSFWorkbook workBookl = null;
	
	public void setFileSystem(POIFSFileSystem fileSystem) throws Exception,OldFileFormatException,EmptyFileException {
		this.fileSystem = fileSystem;
	}

	public POIFSFileSystem getFileSystem() throws Exception {
		return fileSystem;
	}

	public void setWorkBook(Workbook workBook) throws Exception {
		this.workBook = workBook;
	}

	public Workbook getWorkBook() throws Exception {
		return workBook;
	}

	public ExcelFile(String filePath) throws Exception,OldFileFormatException,EmptyFileException {
		
		super(filePath);
		//setFileSystem(new POIFSFileSystem(getFis()));
		if(!getFis().markSupported()) {
			//setFis(new PushbackInputStream(getFis(),8));
			InputStream pins = new PushbackInputStream(getFis(),8);
			setFis(pins);			
		}
		
		if(POIFSFileSystem.hasPOIFSHeader(getFis())) {
			setWorkBook(new HSSFWorkbook(getFis()));
		}
		
		if(POIXMLDocument.hasOOXMLHeader(getFis())) {
			setWorkBook(new XSSFWorkbook(OPCPackage.open(getFis())));
		}
		
		if(null == getWorkBook()) {
			throw new IllegalArgumentException("Your excel version is Not support ! I am sorry !");
		}
		setSheets(getWorkBook());
			
	}

	public void setSheets(Workbook wb) throws Exception {
		if(null == wb) {
			throw new Exception("Excel Work Book is NULL !");
		}
		int sheetCnt = wb.getNumberOfSheets();
		for(int i = 0; i < sheetCnt; i++) {
			this.sheets[i] = workBook.getSheetAt(i);
		}
	}

	public Sheet[] getSheets() {
		return sheets;
	}

	public String[] getAllSheetNames() throws Exception {
		
		if(null == sheets || sheets.length < 1) {
			throw new Exception("Excel sheets not Valid !");
		}
		int sheetCnt = sheets.length;
		String[] sheetNames = null;
		if(sheetCnt > 0) {
			sheetNames = new String[sheetCnt];
		}
		
		for(int i = 0; i < sheetCnt; i++) {
			sheetNames[i] = sheets[i].getSheetName();
			//sheets[i].getCellComment(1, 2);
			//int totalPhyRows = sheets[i].getPhysicalNumberOfRows();
			//int lastRowNum = sheets[i].getLastRowNum();
			//System.out.println("Physical Row Number: " + totalPhyRows);
			//System.out.println("last Row Number: " + lastRowNum);
			System.out.println("get sheet name: " + sheetNames[i]);
			//HSSFRow row = sheets[i].getRow(0);
			
		}
				
		return sheetNames;
	}
	
	public void InitDataFile(String filePath) {
		// TODO Auto-generated method stub
		
	}

}
