// Samuel Kent (22704037)

/**
 * An implementation of the Fines problem from the 2022 CITS2200 Project
 */
public class FinesImpl implements Fines {
  /**
   * {@inheritdoc}
   */
  public long countFines(int[] priorities) {
    
		
	  long fines_count = 0;
	  
    		
		int n = priorities.length; 
		
		for (int j = 1; j < n; j++) {
			int key = priorities[j]; 
			int i = j - 1;
			
		while (i >= 0 && priorities[i] < key) {
			
			priorities[i+1] = priorities[i];
			i = i - 1;
			fines_count++;
			
		}
		
		priorities[i + 1] = key;
		
		
		}
		
		
	
	  
	  
	  
    return fines_count;
  }
  
  
  
}