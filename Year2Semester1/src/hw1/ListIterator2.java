package hw1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ListIterator2 {

	private int objectSize, stringSize;
	private boolean ifWorkDetails;
	private RandomAccessFile rand;

	public ListIterator2(String fileName, int objectSize, int stringSize, boolean ifWorkDetails)
			throws FileNotFoundException {
		this.objectSize = objectSize;
		this.stringSize = stringSize;
		this.ifWorkDetails = ifWorkDetails;
		rand = new RandomAccessFile(fileName, "rw");
	}

	public boolean hasNext() throws IOException {
		long location = rand.getFilePointer() + objectSize;
		long endFile = rand.length();

		if (location < endFile) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasPrevious() throws IOException {
		long location = rand.getFilePointer();
		if (location > 0) {
			return true;
		} else {
			return false;
		}
	}

	public Worker<?> next() throws IOException {
		String workerName, depName, depHead;
		Worker<?> wrk;
		Department dep;
		int salary;

		workerName = FixedLengthStringIO.readFixedLengthString(stringSize, rand);
		depName = FixedLengthStringIO.readFixedLengthString(stringSize, rand);
		if (ifWorkDetails) {
			depHead = FixedLengthStringIO.readFixedLengthString(stringSize, rand);
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

	public Worker<?> previous() throws IOException {
		String workerName, depName, depHead;
		Worker<?> wrk;
		Department dep;
		int salary;

		rand.seek((long) (rand.getFilePointer() - objectSize));

		workerName = FixedLengthStringIO.readFixedLengthString(stringSize, rand);
		depName = FixedLengthStringIO.readFixedLengthString(stringSize, rand);
		if (ifWorkDetails) {
			depHead = FixedLengthStringIO.readFixedLengthString(stringSize, rand);
			dep = new Department(depName, depHead);
			salary = rand.readInt();
			wrk = new Worker<Department>(workerName, dep, salary);
			rand.seek((long) (rand.getFilePointer() - objectSize));
			return wrk;
		} else {
			salary = rand.readInt();
			wrk = new Worker<String>(workerName, depName, salary);
			rand.seek((long) (rand.getFilePointer() - objectSize));
			return wrk;
		}
	}

	public int nextIndext() throws IOException {
		return (int) (rand.getFilePointer() / objectSize);
	}

	public int previousIndex() throws IOException {
		return (int) ((rand.getFilePointer() / objectSize) - 1);
	}

	public void remove() throws IOException { // to fill

		Worker<?> wrk;
		int listLength = (int) (rand.length() / objectSize);

		for (int location = (int) (rand.getFilePointer() / objectSize); location < listLength; location++) {
			wrk = next();
			addInLocation(wrk, location - 1);
		}
		rand.setLength(rand.length() - objectSize);

	}

	public void add(Worker<?> worker) throws IOException {

		Worker<?> thisTempWorker, nextTempWorker;

		thisTempWorker = worker;

		for (int location = (int) (rand.getFilePointer() / objectSize); location < (int) (rand.length()
				/ objectSize); location++) {
			nextTempWorker = next();
			addInLocation(thisTempWorker, location);
			thisTempWorker = nextTempWorker;
		}
	}

	public void addInLocation(Worker<?> tempWorker, int location) throws IOException {

		rand.seek(location * objectSize);

		FixedLengthStringIO.writeFixedLengthString(tempWorker.getName(), stringSize, rand);
		if (ifWorkDetails) {
			Department tempDep = (Department) (tempWorker.getDep());
			FixedLengthStringIO.writeFixedLengthString(tempDep.getDepName(), stringSize, rand);
			FixedLengthStringIO.writeFixedLengthString(tempDep.getDepHead(), stringSize, rand);
		} else {
			FixedLengthStringIO.writeFixedLengthString((String) (tempWorker.getDep()), stringSize, rand);
		}
		rand.writeInt(tempWorker.getsalary());
	}

}
