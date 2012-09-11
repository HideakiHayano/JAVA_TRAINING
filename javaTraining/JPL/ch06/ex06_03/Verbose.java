package ch06.ex06_03;

public interface Verbose {
	enum MessageLevel{
		SILENT, TURSE, NORMAL, VERBOSE;
	}
	
	void setVerbosity(MessageLevel level);
	MessageLevel getVerbosity();
	
}
