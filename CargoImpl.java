// Samuel Kent (22704037)
import java.util.Arrays;



/**
 * An implementation of the Cargo problem from the 2022 CITS2200 Project
 */
public class CargoImpl implements Cargo {
  /**
   * {@inheritdoc}
   */
	
	
	
  public int[] departureMasses(int stops, Query[] queries) {
    
	 
	 int[] cargo_arr = new int[stops];
	 int[] total_cargo = new int[queries.length];
	 
	 
	 //Arrays.fill(cargo_arr, 0); //initialise array to all 0's initially 
	 
	 
	 for (int i = 0; i < queries.length; i++) {
		 
		 	int collect = queries[i].collect;
		 	int deliver = queries[i].deliver;
		 	int cargoMass = queries[i].cargoMass;
		 	
		 
	 if (cargoMass > 0) {
			 
		 for (int j = collect; j < deliver; j++) {
			 
			 cargo_arr[j] = cargo_arr[j] + cargoMass; 
			 
		 }
			 
			 total_cargo[i] = cargo_arr[collect];
			
		 }
		 
		 else if(cargoMass < 0 ) {
			 
			 for (int j = collect; j < deliver; j++) {
				 
				 cargo_arr[j] = cargo_arr[j] + cargoMass; 
				 
			 }
			 
			 total_cargo[i] = cargo_arr[collect];
			 
		 }
		 
		 else {
			 
			 total_cargo[i] = cargo_arr[collect];
			 
		 }
		 
	 }
	 
	 	  
	 return total_cargo;
  }
  
}