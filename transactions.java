package Research.Myprojects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class transactions {
	
	public static ArrayList<HashMap<String,String>> trans = new ArrayList<>();
	
	public static ArrayList<HashMap<String,String>> addTransactions() {
		
		HashMap<String,String> mMap = new HashMap();
		mMap.put("From","Alice");
		mMap.put("To","Bob");
		mMap.put("amount","10");
		trans.add(mMap); 
		
		mMap = new HashMap(); // create a new one!
		mMap.put("From","Bill");
		mMap.put("to","Bob");
		mMap.put("amount","20");
		trans.add(mMap); 
		
		
		mMap = new HashMap(); // create a new one!
		mMap.put("From","Bob");
		mMap.put("to","Bill");
		mMap.put("amount","200");
		trans.add(mMap); 
	
			
		return trans;
			
		}

    public static void clear() {
    	
    	trans.clear();
    	
    }
	
	public static String merk() {
		MerkleTree merkleTree = new MerkleTree(trans.toArray());
		System.out.println("number of transactions is "+ trans.size());
		System.out.println("Merkle Root : "+ merkleTree.getMerkleRoot()[0]);
		
		return merkleTree.getMerkleRoot()[0].toString();
	} 

}
