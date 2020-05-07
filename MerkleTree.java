package Research.Myprojects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Research.Myprojects.*;

public class MerkleTree {
	
private Object[] transactions;
	
	static int level =0;
	//constructor 
	public MerkleTree(Object[] transactions) {
		this.transactions=transactions;
	}
	
	public Object[] getMerkleRoot(){
		return construct(this.transactions);
	}
	
	private Object[] construct(Object[] transactions){

		if(transactions.length == 1) {
			return transactions;
		}
		
		List<String> updatedList = new ArrayList<>();
		
		for(int i=0; i<transactions.length-1; i+=2 ) {
			
			updatedList.add(mergeHash(transactions[i], transactions[i+1]));
		}
		
		if(transactions.length % 2 == 1) {
			//System.out.println("Odd number : Merging transaction "+ (transactions.size()-1) + " with "+ 
			//(transactions.size()-1));
			updatedList.add(mergeHash(transactions[transactions.length-1], 
									  transactions[transactions.length-1]));
		}
		level++;
		return construct(updatedList.toArray());
	}
	
	private String mergeHash(Object h1, Object h2) {
		String merger = h1.toString()+h2.toString();
		return SHA256helper.hash(merger);
	}
}
