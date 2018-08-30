package simester2.practive.HW1_SefiAzoulay;

public class GoldCustomer extends PreferredCustomer{
	
	public GoldCustomer(int id, String name , int amountPurchases, int discount){
		super(id, name, amountPurchases, discount);
	}
	
	public String toString (){
		return super.toString(); 
	}
	
	@Override
	public boolean equals (Object obj){
		if(obj.getClass().equals(getClass())){			
			GoldCustomer tmp = (GoldCustomer)obj;
			if(super.equals(obj) && tmp.getDiscount() == getDiscount()){
				return true;
			}			
		}		
		return  false;
	}
}
