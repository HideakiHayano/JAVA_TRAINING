package ch20.ex20_11;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class FileFilterBySuffix implements FilenameFilter{

	public static void main(String[] args) {
		FileFilterBySuffix fbs = new FileFilterBySuffix();
		//Input the directory under which you check the file name.
		File dir = new File("JPL/ch20/ex20_11");
		//Input the suffix which is included in the file name you'd like to show.
		fbs.showFiles(dir, "java");
	}
	
	/**
	 * Show all file names including the suffix which exist under the directory. 
	 * @param dir
	 * @param suffix
	 */
	public void showFiles(File dir, String suffix){
		String[] files = dir.list();
		for(String file : files){
			if(this.accept(file, suffix)){
				System.out.println("file: " + file);
			}
		}
	}
	
	private boolean accept(String file, String suffix) {
		String str = (String) file.subSequence(file.length()-suffix.length(), file.length());
		if(str.equals(suffix))
			return true;
		else
			return false;
	}

	public boolean accept(File dir, String suffix) {
			return false;
	}

}
