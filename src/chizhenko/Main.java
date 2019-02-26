package chizhenko;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {

		int[][] myArray = new int[5][10];
		File arrText = new File("arr.txt");
		
		for (int i = 0; i < myArray.length; i++) {
			for (int j = 0; j < myArray[i].length; j++) {
				myArray[i][j] = (int) (Math.random() * Math.pow(10, i+1));
			}
		}
		
		System.out.println(fromArrayToString(myArray));
		
		saveToFile(arrText, fromArrayToString(myArray));
		
	}
	
	public static void saveToFile(File pFile, String pText) {

		try (PrintWriter pw = new PrintWriter(pFile)) {
			pw.println(pText);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}

	}
	
	public static String fromArrayToString(int[][] pArray) {
		StringBuilder sb = new StringBuilder();
		for (int[] rows : pArray) {
			for (int column : rows) {
			sb.append(String.format("%-7s", "" + column));	
			}
			sb.append(System.lineSeparator());
		}
		
		return sb.toString();
	}

}
