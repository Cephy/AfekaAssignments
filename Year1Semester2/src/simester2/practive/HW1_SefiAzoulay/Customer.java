package simester2.practive.HW1_SefiAzoulay;

public class Customer {
	
	private int amountPurchases;
	private int id;
	private String name;
	
	public Customer (int id, String name, int amountPurchases){
		this.amountPurchases = amountPurchases;
		this.id = id;
		this.name = name;
	}
	
	public void setAmountPurchases (int amountPurchases){
		this.amountPurchases = amountPurchases;
	}
	
	public int getAmountPurchases (){
		return amountPurchases;
	}
	
	//Don't think there should be a set command for I.D - because it is a unique number that should not be changed
	/*public void setId (int id){
		this.id = id;
	}*/
	
	public int getId (){
		return id;
	}
	
	public void setName (String name){
		this.name = name;
	}
	
	public String getName (){
		return name;
	}
	
	@Override
	public String toString(){
		return String.format("%-3d - %-10s %10d", id,name,amountPurchases);
	}
	
	@Override
	public boolean equals (Object obj){
		if (obj.getClass().equals(getClass())){
			Customer tmp = (Customer)obj;
			if(tmp.getId() == this.id || (tmp.getName().equals(this.name) && tmp.amountPurchases == this.amountPurchases)){
				return true;
			}
		}				
		return false;
	}
}
