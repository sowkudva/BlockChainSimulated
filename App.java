package Research.Myprojects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.google.common.collect.ArrayListMultimap; 
import com.google.common.collect.Multimap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class App 



{
	private static long startTime = System.nanoTime();
	
	public static ArrayList<String> blacklist(HashMap<String,Double> aggragted) {
		
		double threshold= 0.4 ;
		
		ArrayList<String> blacknodes = new ArrayList<>();
		
		
		        // array to store keys of the HashMap
				String[] key = new String[aggragted.size()];

				// array to store values of the HashMap
				Double[] values = new Double[aggragted.size()];
						
						//aggragted.values().toArray(new Double[0]);

				int i = 0;

				for (Map.Entry<String, Double> entry : aggragted.entrySet()) {
					key[i] = entry.getKey();
					values[i++] = entry.getValue();
				}

				for (i = 0; i < aggragted.size(); i++) {
					if(values[i] < threshold) {
						blacknodes.add(key[i]);
					}
				}
				
				System.out.println("Blacklisted nodes ");
				for(String s : blacknodes ) {
					System.out.print(s+", ");
				}
				System.out.println("");
				
				return blacknodes;
	}
	
	public static Multimap<String, Double> populateMap(ArrayList<String> vid, ArrayList<Double> ratings) {
		final Multimap<String, Double> cars = ArrayListMultimap.create();
	   
		for(int i=0; i<vid.size(); i++) {
			cars.put(vid.get(i), ratings.get(i));
		}
		
		return cars;

	}
	
	public static HashMap<String, Double> aggRatings(Multimap<String, Double> cars) {
		
		 double count=0.0;
		 double avg=0.0;
		 HashMap<String, Double> agg = new HashMap<>();
		
		for(String carName : cars.keySet()) {
			
			
	    	Collection<Double> ratings = cars.get(carName);
		    
	    	//System.out.println(ratings);
	    	for(double r : ratings ) {
	    		count += r;
	    	}
	    	
	    	avg= count/ratings.size();
	    	/*System.out.println("For car id "+carName+" Average rating is "+avg);*/
	    	
	    	
	    	agg.put(carName, avg);
	    	count=0.0; 
	    }
		
		return agg;
		
	}
	
	public static  ArrayList<String>  createNodeLists(int n) {
		
		String csvFile = "/Users/sk/Downloads/trust"+n+".csv";
        String line = "";
        String cvsSplitBy = " ";
        ArrayList<String> vids= new ArrayList<>();
      

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] lines = line.split(cvsSplitBy);

                //System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");
                vids.add(lines[2]);
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		
        return vids;
        //System.out.println(ratings);
		
	}
	
    public static  ArrayList<Double>  createRatingsLists(int n) {
		
		String csvFile = "/Users/sk/Downloads/trust"+n+".csv";
        String line = "";
        String cvsSplitBy = " ";
        
        ArrayList<Double> ratings= new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] lines = line.split(cvsSplitBy);
                ratings.add(Double.parseDouble(lines[5]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		
        return ratings;
        
		
	}
	
    
    

    /*public static void main(final String[] args) {
		
	  
		ArrayList<String> vids = createNodeLists();
		ArrayList<Double> ratings= createRatingsLists();
		Multimap<String, Double> cars= populateMap(vids, ratings);
		HashMap<String,Double> aggregated = new HashMap<>();
		
		
		aggregated= aggRatings(cars);
		
		blacklist(aggregated);
		
		long endTime = System.nanoTime();
		long Took= (endTime - startTime); 
		//1 mili second = 1000000 nano seconds
		double elapsedTimeInSecond = (double) Took / 1_000_000;

        System.out.println(elapsedTimeInSecond + " mili seconds");
        
	   
	    
	}*/
}
