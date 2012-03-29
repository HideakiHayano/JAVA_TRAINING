package JPL.ch1.ex1_16;

import java.io.IOException;

public class BadDataSetException {
	
	private String dataSetName;
	private IOException ioException;
	
	public BadDataSetException(String dataSetName, IOException ioException){
		
		this.dataSetName = dataSetName;
		this.ioException = ioException;
		
	}
	
	public String getDataSetName(){
		return dataSetName;
	}
	
	public IOException getIOException(){
		return ioException;
	}
	
}
