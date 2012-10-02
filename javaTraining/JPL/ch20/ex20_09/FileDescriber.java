package ch20.ex20_09;

import java.io.File;

public class FileDescriber {
	/**
	 *Show all file attributes under the directory designated by path name.
	 * @param pathName
	 */
	public static void showFileAttributes(File pathName){
		File[] fileList = pathName.listFiles();
		int i = 1;
		for(File file : fileList){
			System.out.println("file" + i);
			System.out.println("name: " + file.getName());
			System.out.println("length: " + file.length());
			System.out.println("lastModified: " + file.lastModified());
			System.out.println("canRead: " + file.canRead());
			System.out.println("canWrite: " + file.canWrite());
			System.out.println();
			i++;
		}
	}
	
	/**
	 *Show all file attributes under the directories designated by multiple path names.
	 * @param pathName
	 */
	public static void showFileAttributes(File[] pathName){
		for(int j = 0; j < pathName.length; j++){
			File[] fileList = pathName[j].listFiles();
			int i = 1;
			for(File file : fileList){
				System.out.println("file" + i);
				System.out.println("name: " + file.getName());
				System.out.println("length: " + file.length());
				System.out.println("lastModified: " + file.lastModified());
				System.out.println("canRead: " + file.canRead());
				System.out.println("canWrite: " + file.canWrite());
				System.out.println();
				i++;
			}
		}
	}
	
	public static void main(String[] args) {
		File file = new File(".");
		FileDescriber.showFileAttributes(file);
	}

}
