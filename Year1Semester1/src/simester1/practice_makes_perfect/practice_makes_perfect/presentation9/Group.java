package simester1.practice_makes_perfect.practice_makes_perfect.presentation9;

public class Group {

	private Person[] personsArray;
	
	public void setPersonsArray (Person[] personsArray){
		this.personsArray = personsArray;
	}
	public Person[] getPersonsArray(){
		return personsArray;
	}
	
	public void sortLowtoHigh(){		
		for(int sortLimit=personsArray.length-1 ; sortLimit>0 ; sortLimit--){
			for (int location=0 ; location<sortLimit ; location++){
				if (personsArray[location].getWeight()>personsArray[location+1].getWeight()){
					swapPersonWeight(personsArray, location);
				}
			}
		}
	}
	public void sortHighToLow(){		
		for(int sortLimit=personsArray.length-1 ; sortLimit>0 ; sortLimit--){
			for (int location=0 ; location<sortLimit ; location++){
				if (personsArray[location].getWeight()<personsArray[location+1].getWeight()){
					swapPersonWeight(personsArray, location);
				}
			}
		}
	}
	public void print(){
		for(int i=0 ; i<personsArray.length ; i++){
			personsArray[i].showPerson();
		}
	}
	private void swapPersonWeight(Person[] personsArray,int location){
		int temp = personsArray[location].getWeight();
		personsArray[location].setWeight(personsArray[location+1].getWeight());
		personsArray[location+1].setWeight(temp);
	}
}
