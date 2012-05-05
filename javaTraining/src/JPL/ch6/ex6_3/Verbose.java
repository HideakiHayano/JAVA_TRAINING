package JPL.ch6.ex6_3;

public interface Verbose {
	enum MessageLevel{
		SILENT, TURSE, NORMAL, VERBOSE;
	}
	
	void setVerbosity(MessageLevel level);
	MessageLevel getVerbosity();
	
}
