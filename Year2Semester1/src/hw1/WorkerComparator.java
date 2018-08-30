package hw1;
import java.util.Comparator;

public class WorkerComparator implements Comparator<Worker<?>> {

	@Override
	public int compare(Worker<?> o1, Worker<?> o2) {

		if (o1.getName().compareTo(o2.getName()) == 0) {
			return 1;
		}

		return (o1.getName().compareTo(o2.getName()));
	}

}
