package handy.files;

//import java.io.BufferedOutputStream;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.FileReader;
//import java.io.FileWriter;
import java.io.InputStream;
//import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.poi.EmptyFileException;
import org.apache.poi.OldFileFormatException;


public abstract class DataFile {
	
	private InputStream fis = null;
	private OutputStream fos = null;
	private File file = null;
	private InputStream bis = null;
	
	//private InputStreamReader isr = null;
	//private BufferedReader br = null;
	//private FileReader fr = null;
	
	//private FileWriter fw = null;
	//private BufferedOutputStream bufferedOut = null;
	//private BufferedWriter bw = null;
	
	public DataFile(String filePath) throws IllegalArgumentException,Exception {
		
		if(filePath.equals("") || null == filePath) {
			throw new IllegalArgumentException("no file Path or file path invalid !");
		}
		//setFile(filePath);
		setFis(filePath);
		//setBis(new BufferedInputStream(getFis()));
		//setFos(filePath);
		
	}
	
	public void setFile(String filePath) throws Exception {
		this.file = new File(filePath);
	}

	public File getFile() {
		return file;
	}

	public void setFos(String filePath) throws Exception {	
		this.fos = new FileOutputStream(filePath);
	}

	protected OutputStream getFos() {
		return fos;
	}

	public void setFis(String filePath) throws Exception,OldFileFormatException,EmptyFileException {		
		this.fis = new FileInputStream(filePath);
	}
	
	public void setFis(InputStream is) {		
		this.fis = is;
	}

	protected InputStream getFis() {
		return fis;
	}
		
	public void closeStreams() throws IOException {
		if(null != fis) {
			fis.close();
		}
		if(null != fos) {
			fis.close();
		}
		if(null != bis) {
			bis.close();
		}
	}
	
	
	public abstract void InitDataFile(String filePath);

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}
	
	

}
