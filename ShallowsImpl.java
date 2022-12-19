// Samuel Kent (22704037)


import CITS2200.Graph;
import CITS2200.Path;
import java.util.*;
import java.io.*;



/**
 * An implementation of the Shallows problem from the 2022 CITS2200 Project
 */
public class ShallowsImpl implements Shallows {
  /**
   * {@inheritdoc}
   * use Dijkstra (no negative weights) to solve shortest path for O(P^2) or O(P L) for a weighted directed graph
   * use a Max heap (priority queue ) for O(P + LlogP ), due to not wanting to find shortest path but wanting to find longest path (deepest)
   * use a java.util DT 
   */ 
  public int[] maximumDraughts(int ports, Lane[] lanes, int origin) {
	  
	  int n_lanes = lanes.length; 
	  
	  
	  
	   
/**
	   
	  }
 * @param <depth>
	  
	  
 * @param <LaneEdge>
**/		
	
	  	
	
	  class Node{ 
		   int u;
		   int weight;
		  
		  public Node(int u, int weight) {
			  this.u = u;
			  this.weight = weight;
			  
		  }
 
		  
	  }
	  

	  
	  
	  class DepthsComparator implements Comparator<Node> {

		//low key value is high priority
		public int compare(Node l1, Node l2) {
			if (l1.weight < l2.weight) {
				return 1;
			}
			else if (l1.weight > l2.weight) {
				return -1;
			}
				
					return 0;
		}
		  
	  }

  

	  
	  int[] seen = new int[ports];
	  int key[] = new int[ports]; //stores distance of each vertex from source vertex
	  
	  Arrays.fill(key, 0);	  
	  Arrays.fill(seen, 0);
	  
	  PriorityQueue<Node> pq = new PriorityQueue<Node>(new DepthsComparator());
	  
	  pq.add(new Node(origin, Integer.MAX_VALUE)); //add source node and make weight infinity
	  
	
	  int[] min_lanes = new int[ports]; 
	  
	  Arrays.fill(min_lanes, 0);
	  min_lanes[origin] = Integer.MAX_VALUE;
	
	  int vertex;
	  
	  
	while ( !pq.isEmpty() ) {
		
		 vertex = pq.remove().u;
	
		if (seen[vertex] != 0) {
			
			continue;
			
		}	
		seen[vertex] = 1;
		
		
	  for (int i = 0; i < n_lanes; i++) {
		  
		  int depart = lanes[i].depart;
		  int arrive = lanes[i].arrive;
		  int depth = lanes[i].depth;
	  
		  
		if ( depart == vertex && seen[arrive] != 1) {
			  				
				  
		if ( key[arrive] < key[vertex] + depth || key[i] == 0) {
							

				key[arrive] = depth + key[vertex];
	
				
				min_lanes[arrive] = depth;

				
				if (depth > min_lanes[depart]) {
					
					min_lanes[arrive] = min_lanes[depart];					
					
				}
				

				pq.add(new Node(arrive, key[arrive]));
					
				  
			  }
	  
		  }
  
		  
	  }
	  
	}


	  
	return min_lanes;
	
  }
  
	}

  
  



