package hw1;
/*Sefi azoulay 303139141*/

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class HW2_SefiAzoulay {

	private static final int STRING_SIZE = 35;
	private static final int smallNumOfStringInWorker = 2;
	private static final int bigNumOfStringInWorker = 3;
	private static final int numOfIntegerInWorker = 1;
	private static int workerSize;
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Worker<?>> workers;
		boolean ifWorkDetails = false;
		String fileName = "WorkerHw2.bin";

		TreeMap<Integer, Worker<?>> workerMap = new TreeMap<Integer, Worker<?>>();

		System.out.println("If you like a detailed version of the array please press 1");
		if (scan.nextInt() == 1) {
			ifWorkDetails = true;
		}
		calculateWorkerSize(ifWorkDetails); // Function that calculates
											// Worker<?> size.
		workers = fillArray(ifWorkDetails); // fill ArrayList with workers
		/* ~~~~~ Question 3 ~~~~~ */
		workerMap = creatMap(workers);
		System.out.println("\n~~~~~ Question 4 ~~~~~*\n");
		printMapBackWard(workerMap);
		/* ~~~~~ Question 5 ~~~~~ */
		saveMapToFile(workerMap, ifWorkDetails, fileName);
		System.out.println("\n~~~~~ Question 6 ~~~~~*\n");
		readFile(ifWorkDetails, fileName);
		/* ~~~~~ Question 7 ~~~~~ */
		sortInFile(ifWorkDetails, fileName);
		System.out.println("\n~~~~~ Question 7 ~~~~~*\n");
		readFile(ifWorkDetails, fileName);
		System.out.println("~~~~ check iter ~~~~");
		checkIterator(fileName, ifWorkDetails);

	}

	/* ~~~~Question 1-2~~~~ */
	public static ArrayList<Worker<?>> fillArray(boolean ifWorkDetails) { // Filles
		// the
		// array
		// with
		// data
		final int NUMBER_OF_WORKERS = 6;
		ArrayList<Worker<?>> workers = new ArrayList<Worker<?>>();
		String[] names = { "Elvis", "Samba", "Bamba", "Bisli", "Kinder Bueno", "Elvis" };
		String[] depName = { "Software Engineering", "Mechanical Engineering", "Industrial and Medical Engineering",
				"Electrical Engineering", "Electrical Engineering", "Software Engineering" };
		String[] depHead = { "boss1", "boss2", "boss3", "boss4", "boss4", "boss1" };
		int[] salary = { 1000, 2000, 3000, 4000, 1000, 9999 };

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

	/* ~~~~Question 3~~~~ */
	public static TreeMap<Integer, Worker<?>> creatMap(ArrayList<Worker<?>> workerArryList) {
		TreeSet<Worker<?>> workerSetTemp = new TreeSet<Worker<?>>(new WorkerComparator());
		TreeMap<Integer, Worker<?>> workerMap = new TreeMap<Integer, Worker<?>>();

		for (int counter = 0; counter < workerArryList.size(); counter++) {
			workerSetTemp.add(workerArryList.get(counter));
		}

		Iterator<Worker<?>> iter = workerSetTemp.iterator();

		for (int counter = 0; iter.hasNext(); counter++) {
			workerMap.put((counter + 1), iter.next());
		}

		return workerMap;
	}

	/* ~~~~Question 4~~~~ */
	public static void printMapBackWard(TreeMap<Integer, Worker<?>> workerMap) {
		ListIterator<Entry<Integer, Worker<?>>> keyListIterator = null;
		ArrayList<Entry<Integer, Worker<?>>> entryList = new ArrayList<Entry<Integer, Worker<?>>>();
		Map.Entry<Integer, Worker<?>> temp;

		for (Map.Entry<Integer, Worker<?>> tempEntry : workerMap.entrySet()) {
			entryList.add(tempEntry.getKey() - 1, tempEntry);
		}

		keyListIterator = entryList.listIterator(entryList.size());

		while (keyListIterator.hasPrevious()) {
			temp = keyListIterator.previous();
			System.out.printf("%d: %s\n", temp.getKey(), temp.getValue().toString());
		}
	}

	/* ~~~~Question 5~~~~ */
	public static void saveMapToFile(TreeMap<Integer, Worker<?>> workerMap, boolean ifWorkDetails, String fileName)
			throws IOException { // Save

		RandomAccessFile out = new RandomAccessFile(fileName, "rw");

		for (Map.Entry<Integer, Worker<?>> tempEntry : workerMap.entrySet()) {
			Worker<?> tempWorker = tempEntry.getValue();
			FixedLengthStringIO.writeFixedLengthString(tempWorker.getName(), STRING_SIZE, out);
			if (ifWorkDetails) {
				Department tempDep = (Department) (tempWorker.getDep());
				FixedLengthStringIO.writeFixedLengthString(tempDep.getDepName(), STRING_SIZE, out);
				FixedLengthStringIO.writeFixedLengthString(tempDep.getDepHead(), STRING_SIZE, out);
			} else {
				FixedLengthStringIO.writeFixedLengthString((String) (tempWorker.getDep()), STRING_SIZE, out);
			}
			out.writeInt(tempWorker.getsalary());
		}
		out.close();
	}

	/* ~~~~Question 6~~~~ */
	public static void readFile(boolean ifWorkDetails, String fileName) throws IOException { // Print

		System.out.println("");
		RandomAccessFile in = new RandomAccessFile(fileName, "rw");
		String workerName, depName, depHead;
		Worker<?> wrk;
		Department dep;
		int salary, counter = 0;

		try {
			do {
				counter++;
				workerName = FixedLengthStringIO.readFixedLengthString(STRING_SIZE, in);
				depName = FixedLengthStringIO.readFixedLengthString(STRING_SIZE, in);
				if (ifWorkDetails) {
					depHead = FixedLengthStringIO.readFixedLengthString(STRING_SIZE, in);
					dep = new Department(depName, depHead);
					salary = in.readInt();
					wrk = new Worker<Department>(workerName, dep, salary);
					System.out.println(counter + ":" + wrk);
				} else {
					salary = in.readInt();
					wrk = new Worker<String>(workerName, depName, salary);
					System.out.println(counter + ":" + wrk);
				}
			} while (counter < 6);
		} catch (EOFException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		in.close();
	}

	/* ~~~~Question 7~~~~ */
	public static void sortInFile(boolean ifWorkDetails, String fileName) throws IOException {
		RandomAccessFile rand = new RandomAccessFile(fileName, "rw");

		int salary1, salary2;
		Worker<?> tempWorker1 = null, tempWorker2 = null;

		int numOfWorkers = (int) (rand.length() / workerSize);
		int salaryLocationOffset = (workerSize - (Integer.SIZE / 8));

		for (int endRunCounter = numOfWorkers; endRunCounter > 0; endRunCounter--) {
			for (int counter = 0; counter < endRunCounter - 1; counter++) {
				rand.seek((long) ((workerSize * counter) + salaryLocationOffset));
				salary1 = rand.readInt();
				rand.seek((long) ((workerSize * (counter + 1)) + salaryLocationOffset));
				salary2 = rand.readInt();
				if (salary1 > salary2) {
					tempWorker1 = loadWorker(ifWorkDetails, rand, counter);
					tempWorker2 = loadWorker(ifWorkDetails, rand, counter + 1);
					saveWorker(ifWorkDetails, rand, counter, tempWorker2);
					saveWorker(ifWorkDetails, rand, counter + 1, tempWorker1);
				}
			}
		}
		rand.close();
	}

	/* ~~~~Question 10~~~~ */
	public static void checkIterator(String fileName, boolean ifWorkDetails) throws IOException {

		ListIterator2 listIter = new ListIterator2(fileName, workerSize, STRING_SIZE, ifWorkDetails);

		Worker<?> tempWorker;

		System.out.println("~~~~Runing forword~~~~");
		while (listIter.hasNext()) {
			tempWorker = listIter.next();
			System.out.println(tempWorker);
		}

		System.out.println("~~~~Runing backword~~~~");
		while (listIter.hasPrevious()) {
			tempWorker = listIter.previous();
			System.out.println(tempWorker);
		}

	}

	/* ~~~~support functions~~~~ */
	public static void calculateWorkerSize(boolean ifWorkDetails) {
		if (ifWorkDetails) {
			workerSize = ((((Character.SIZE * STRING_SIZE) * bigNumOfStringInWorker)
					+ (Integer.SIZE * numOfIntegerInWorker)) / 8);
		} else {
			workerSize = ((((Character.SIZE * STRING_SIZE) * smallNumOfStringInWorker)
					+ (Integer.SIZE * numOfIntegerInWorker)) / 8);
		}
	}

	public static Worker<?> loadWorker(boolean ifWorkDetails, RandomAccessFile rand, int location) throws IOException {
		String workerName, depName, depHead;
		Worker<?> wrk;
		Department dep;
		int salary;

		rand.seek((long) location * workerSize);
		workerName = FixedLengthStringIO.readFixedLengthString(STRING_SIZE, rand);
		;
		depName = FixedLengthStringIO.readFixedLengthString(STRING_SIZE, rand);
		if (ifWorkDetails) {
			depHead = FixedLengthStringIO.readFixedLengthString(STRING_SIZE, rand);
			dep = new Department(depName, depHead);
			salary = rand.readInt();
			wrk = new Worker<Department>(workerName, dep, salary);
			return wrk;
		} else {
			salary = rand.readInt();
			wrk = new Worker<String>(workerName, depName, salary);
			return wrk;
		}
	}

	public static void saveWorker(boolean ifWorkDetails, RandomAccessFile rand, int location, Worker<?> tempWorker)
			throws IOException {

		rand.seek((long) location * workerSize);

		FixedLengthStringIO.writeFixedLengthString(tempWorker.getName(), STRING_SIZE, rand);
		if (ifWorkDetails) {
			Department tempDep = (Department) (tempWorker.getDep());
			FixedLengthStringIO.writeFixedLengthString(tempDep.getDepName(), STRING_SIZE, rand);
			FixedLengthStringIO.writeFixedLengthString(tempDep.getDepHead(), STRING_SIZE, rand);
		} else {
			FixedLengthStringIO.writeFixedLengthString((String) (tempWorker.getDep()), STRING_SIZE, rand);
		}
		rand.writeInt(tempWorker.getsalary());
	}
}
