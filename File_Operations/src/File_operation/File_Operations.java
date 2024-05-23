package File_operation;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class File_Operations {

	static ArrayList<String> arr = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		File file = new File("/home/dell/Desktop/ds/FileDemo.java");
		file.createNewFile();

		FileWriter fileWriter = new FileWriter("/home/dell/Desktop/ds/FileDemo.java");
		fileWriter.write(
				"package File_operation; \n public class FileDemo { \n  public static void main(String[] args) { \n int a = 10; \n int b = 20; \n System.out.println(a+b); \n } \n } ");
		fileWriter.close();

		FileReader fileReader = new FileReader("/home/dell/Desktop/ds/FileDemo.java");
		Scanner sc = new Scanner(fileReader);
		while (sc.hasNextLine()) {
			arr.add(sc.nextLine());
		}
		fileReader.close();

		File file1 = new File("/home/dell/Desktop/SM/File_Operations/src/File_operation/FileDemo.java");
		file1.createNewFile();

		FileWriter fr = new FileWriter("/home/dell/Desktop/SM/File_Operations/src/File_operation/FileDemo.java");
		for (String e : arr) {
			fr.write(e);
		}
		System.out.println("task completed");
		fr.close();

	}
}
