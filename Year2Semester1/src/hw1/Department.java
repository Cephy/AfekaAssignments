package hw1;

public class Department implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String depName;
	private String depHead;

	public Department(String depName, String depHead) {
		this.depName = depName;
		this.depHead = depHead;
	}

	/*------------Set------------*/
	public void setDepName(String depName) {
		this.depName = depName;
	}

	public void setDepHead(String depHead) {
		this.depHead = depHead;
	}

	/*------------Get------------*/
	public String getDepName() {
		return depName;
	}

	public String getDepHead() {
		return depHead;
	}

	/*------------Other------------*/
	public String toString() {
		return String.format("%-35s  %-10s", depName, depHead);
	}
}
