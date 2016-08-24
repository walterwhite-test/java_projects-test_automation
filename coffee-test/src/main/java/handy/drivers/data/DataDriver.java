package handy.drivers.data;

import handy.data.Data;
import handy.files.*;

public abstract class DataDriver {

	private DataFile file;
	
	public abstract Data InitDataFrmFile(String filePath);
	
	public abstract Data InitDataFrmStr(String str);
	

	public DataFile getFile() {
		return file;
	}

	public void setFile(DataFile file) {
		this.file = file;
	}
	
	private void InitDataFile(DataFile file, String filePath) {
		if(null != file) {
			file.InitDataFile(filePath);
		}
	}
	private void InitDataFile(String filePath) {
		this.file.InitDataFile(filePath);
	}
	
	
	
}
