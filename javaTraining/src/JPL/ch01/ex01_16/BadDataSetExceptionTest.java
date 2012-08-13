package JPL.ch1.ex1_16;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;

public class BadDataSetExceptionTest extends TestCase{

	@Test
	public void test() {
		
		String dataSetName = "dataSetName";
		IOException ioException = new IOException();
		
		BadDataSetException badDataSetException = new BadDataSetException(dataSetName, ioException);
		
		assertEquals(dataSetName, badDataSetException.getDataSetName());
		assertEquals(ioException, badDataSetException.getIOException());
	}

}
