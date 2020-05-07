package Research.Myprojects;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.lang.instrument.Instrumentation;
import Research.Myprojects.transactions.*;

import com.google.common.collect.Multimap;

public class ABlock {
	
	public int    index;
	public int    nonce;
	public long   timeStamp;
	public String hash;
	public String previousHash;
	public String merkleRoot;
	public int    NumberOfTrans;
	public List<HashMap<String, String>> transactions;
	
	
	//Block Constructor.  
		public ABlock(String previousHash,int index ) {
			this.index = index+1;
			this.previousHash = previousHash;
			this.timeStamp = new Date().getTime();
			this.transactions=  Research.Myprojects.transactions.addTransactions();
			this.merkleRoot = Research.Myprojects.transactions.merk();
			this.hash =  calculateHash(); 
			this.NumberOfTrans= Research.Myprojects.transactions.trans.size();
			
			
			
			
		}
		
		//genesis block constructor
		public ABlock() {
			
			this.previousHash="0";
			this.timeStamp = new Date().getTime();
			this.hash = calculateGenHash();
			
		}
		//method to calculate hash

		public String calculateHash() {
			String calculatedhash = SHA256helper.hash(
					previousHash+
					nonce +
					transactions +
					NumberOfTrans +
					merkleRoot
					);
			return calculatedhash;
		}
		
		
		
		//this is for genesis hash where we have no transactions
		
		public String calculateGenHash() {
			String genesisHash = SHA256helper.hash(previousHash +
					"0");
			return genesisHash;
			
		}
		
         public void mineBlock(int difficulty) {
			
			
			String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
			while(!hash.substring( 0, difficulty).equals(target)) {
				nonce ++;
				hash = calculateHash();
			}
			System.out.println("Block Mined!!! : " + hash);
		}

		
		
		

}
