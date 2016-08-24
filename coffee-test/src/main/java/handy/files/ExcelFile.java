package handy.files;

import org.apache.poi.EmptyFileException;
import org.apache.poi.OldFileFormatException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;



public class ExcelFile extends DataFile {
	
	private POIFSFileSystem fileSystem = null;
	private Workbook workBook = null;
	private HSSFSheet[] sheets = null;
	//private XSSFWorkbook workBookl = null;
	
	public void setFileSystem(POIFSFileSystem fileSystem) throws Exception,OldFileFormatException,EmptyFileException {
		this.fileSystem = fileSystem;
	}

	public POIFSFileSystem getFileSystem() throws Exception {
		return fileSystem;
	}

	public void setWorkBook(HSSFWorkbook workBook) throws Exception {
		this.workBook = workBook;
	}

	public Workbook getWorkBook() throws Exception {
		return workBook;
	}

	public ExcelFile(String filePath) throws Exception,OldFileFormatException,EmptyFileException {
		
		super(filePath);
		setFileSystem(new POIFSFileSystem(getFis()));
		setWorkBook(new HSSFWorkbook(getFileSystem()));
		
	}

	public void setSheets(HSSFWorkbook wb) throws Exception {
		if(null == workBook) {
			throw new Exception("Excel Work Book is NULL !");
		}
		int sheetCnt = workBook.getNumberOfSheets();
		for(int i = 0; i < sheetCnt; i++) {
			this.sheets[i] = (HSSFSheet) workBook.getSheetAt(i);
		}
	}

	public HSSFSheet[] getSheets() {
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
			sheets[i].getCellComment(1, 2);
			int totalPhyRows = sheets[i].getPhysicalNumberOfRows();
			int lastRowNum = sheets[i].getLastRowNum();
			//System.out.println("Physical Row Number: " + totalPhyRows);
			//System.out.println("last Row Number: " + lastRowNum);
			
			//HSSFRow row = sheets[i].getRow(0);
			
		}
				
		return sheetNames;
	}
	
	public void InitDataFile(String filePath) {
		// TODO Auto-generated method stub
		
	}

}
