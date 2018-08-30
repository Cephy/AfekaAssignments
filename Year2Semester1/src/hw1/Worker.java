package hw1;

public class Worker<E> implements Comparable<Worker<?>>, java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private E dep;
	private int salary;

	public Worker(String name, E dep, int salary) {
		this.name = name;
		this.dep = dep;
		this.salary = salary;
	}

	/*------------Get------------*/
	public String getName() {
		return name;
	}

	public E getDep() {
		return dep;
	}

	public int getsalary() {
		return salary;
	}

	/*------------Set------------*/
	public void setName(String name) {
		this.name = name;
	}

	public void setDep(E dep) {
		this.dep = dep;
	}

	public void setsalary(int salary) {
		this.salary = salary;
	}

	/*------------Other------------*/
	public String toString() {
		return String.format("%-20s %-40s %-10d", name, dep, salary);
	}

	@Override
	public int compareTo(Worker<?> other) {

		return getName().compareTo(other.getName());
	}
}
