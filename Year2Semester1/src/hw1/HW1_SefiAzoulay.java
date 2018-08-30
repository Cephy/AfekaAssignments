package hw1;
/*Sefi azoulay 303139141*/

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.*;

public class HW1_SefiAzoulay {

	private static Scanner scan = new Scanner(System.in);
	private static final int NAME_SIZE = 20;
	private static final int STR_SIZE = ((Character.SIZE * NAME_SIZE) / 8);
	private static final int WEIRD_OFFSET = 6;

	public static void main(String[] args) throws IOException {
		boolean ifWorkDetails = false;
		ArrayList<Worker<?>> workers;
		String name1, name2;

		System.out.println("If you like a detailed version of the array please press 1");
		if (scan.nextInt() == 1) {
			ifWorkDetails = true;
		}
		workers = fillArray(ifWorkDetails);
		Print(workers);
		saveNames(workers);
		saveWorkers(workers, ifWorkDetails);
		System.out.println("Please enter the first serial number");
		name1 = findName(scan.nextInt());
		System.out.println("name1 = " + name1);
		System.out.println("Please enter the second serial number");
		name2 = findName(scan.nextInt());
		System.out.println("name2 = " + name2);
		System.out.println("\nFile content: ");
		printWorkers(ifWorkDetails);
		compareSalaries(name1, name2, ifWorkDetails);
		System.out.println("\nFile contect after comparing salaries: ");
		printWorkers(ifWorkDetails);

	}

	public static ArrayList<Worker<?>> fillArray(boolean ifWorkDetails) { // Filles
																			// the
																			// array
																			// with
																			// data
		final int NUMBER_OF_WORKERS = 6;
		ArrayList<Worker<?>> workers = new ArrayList<Worker<?>>();
		String[] names = { "Elvis", "Samba", "Bamba", "Bisli", "Kinder Bueno", "Elvis"};
		String[] depName = { "Software Engineering", "Mechanical Engineering", "Industrial and Medical Engineering",
				"Electrical Engineering", "Electrical Engineering", "Software Engineering" };
		String[] depHead = { "boss1", "boss2", "boss3", "boss4", "boss4", "boss1"};
		int[] salary = { 1000, 2000, 3000, 4000, 1000,9999 };

		for (int counter = 0; counter < NUMBER_OF_WORKERS; counter++) {
			if (ifWorkDetails) {
				Department tempDep = new Department(depName[counter], depHead[counter]);
				Worker<Department> tempWrk = new Worker<Department>(names[counter], tempDep, salary[counter]);
				workers.add(tempWrk);
			} else {
				Worker<String> tempWrk = new Worker<String>(names[counter], depName[counter], salary[counter]);
				workers.add(tempWrk);
			}
		}

		return workers;
	}

	public static void Print(ArrayList<Worker<?>> workers) { // Prints the array
																// itself
		for (Worker<?> tmp : workers) {
			System.out.printf("%s\n" ,tmp);
		}
	}

	public static void saveNames(ArrayList<Worker<?>> workers) throws IOException { // Save
																					// names
																					// on
																					// "names"
																					// file
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("names.bin")));
		for (Worker<?> temp : workers) {
			FixedLengthStringIO.writeFixedLengthString(temp.getName(), NAME_SIZE, out);
		}
		out.close();
	}

	public static void saveWorkers(ArrayList<Worker<?>> workers, boolean ifWorkDetails) throws IOException { // Save
																												// workers
																												// on
																												// "workers"
																												// file
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("workers.bin")));
		for (Worker<?> temp : workers) {
			out.writeUTF(temp.getName());
			if (ifWorkDetails) {
				Department tempDep = (Department) (temp.getDep());
				out.writeUTF(tempDep.getDepName());
				out.writeUTF(tempDep.getDepHead());
			} else {
				out.writeUTF((String) (temp.getDep()));
			}
			out.writeInt(temp.getsalary());
		}
		out.close();
	}

	public static String findName(int location) throws IOException { // finds a
																		// name
																		// in
																		// "names"
																		// file
		RandomAccessFile temp = new RandomAccessFile("names.bin", "rw");
		String tempStr;
		try {
			if (location > (temp.length() - WEIRD_OFFSET) / STR_SIZE) {
				temp.close();
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException ex) {
			System.out.println("Location out of bound");
			return null;
		}
		temp.seek(WEIRD_OFFSET + (STR_SIZE * (location - 1)));
		tempStr = FixedLengthStringIO.readFixedLengthString(NAME_SIZE, temp);
		temp.close();
		return tempStr; // Fix end of file
	}

	public static void compareSalaries(String name1, String name2, boolean ifWorkDetails) throws IOException { // compare
																												// 2
																												// saleries
																												// using
																												// 2
																												// "names"
		RandomAccessFile temp = new RandomAccessFile("workers.bin", "rw");
		String workerName;
		int salary, salary1 = 0, salary2 = 0;
		long location1 = 0, location2 = 0, tempLocation;
		try {
			temp.seek(WEIRD_OFFSET);
			do {
				tempLocation = temp.getFilePointer();
				workerName = temp.readUTF();
				temp.readUTF();
				if (ifWorkDetails) {
					temp.readUTF();
				}
				salary = temp.readInt();
				if (workerName.equals(name1)) {
					salary1 = salary;
					location1 = tempLocation;
				}
				if (workerName.equals(name2)) {
					salary2 = salary;
					location2 = tempLocation;
				}
			} while (temp.length() > temp.getFilePointer());
		} catch (EOFException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		if (salary1 > salary2) {
			temp.seek(location1);
			temp.writeUTF(name1.toUpperCase());
		}
		if (salary2 > salary1) {
			temp.seek(location2);
			temp.writeUTF(name2.toUpperCase());
		}
		temp.close();
	}

	public static void printWorkers(boolean ifWorkDetails) throws IOException { // Print
																				// workers
																				// from
																				// the
																				// file
		System.out.println("");
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("workers.bin")));
		String workerName, depName, depHead;
		Worker<?> wrk;
		Department dep;
		int salary, counter = 0;
		try {
			do {
				counter++;
				workerName = in.readUTF();
				depName = in.readUTF();
				if (ifWorkDetails) {
					depHead = in.readUTF();
					dep = new Department(depName, depHead);
					salary = in.readInt();
					wrk = new Worker<Department>(workerName, dep, salary);
					System.out.println(counter + ":" + wrk);
				} else {
					salary = in.readInt();
					wrk = new Worker<String>(workerName, depName, salary);
					System.out.println(counter + ":" + wrk);
				}
			} while (in.available() > 0);
		} catch (EOFException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		in.close();
	}
	
}
