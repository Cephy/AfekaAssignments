package simester2.practive.HW1_SefiAzoulay;

public class PreferredCustomer extends Customer{
	
	private int discount;
	
	public PreferredCustomer (int id, String name, int amountPurchases, int discount){
		super(id, name, amountPurchases);
		this.discount = discount;
	}
	
	public void setDiscount(int discount){
		this.discount = discount;
	}
	
	public int getDiscount (){
		return discount;
	}
	
	@Override
	public String toString (){
		return String.format("%-24s %-16s %-20s", super.toString(),"(discount: " + discount + "%)",(getClass().getSimpleName().equals("GoldCustomer") ? "GoldCustomer":"PreferredCustomer"));
	}
	
	@Override
	public boolean equals (Object obj){
		if(obj.getClass().equals(getClass())){			
			PreferredCustomer tmp = (PreferredCustomer)obj;
			if(super.equals(obj) && tmp.getDiscount() == getDiscount()){
				return true;
			}			
		}		
		return  false;
	}
}
