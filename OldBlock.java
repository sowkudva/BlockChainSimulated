package Research.Myprojects;

import java.util.Date;

public class OldBlock {
	
	public int index;
	public long   timeStamp;
	public String hash;
	public String previousHash;
	public String merkleRoot;
	
	public int nonce;
	
	
	//Block Constructor.  
		public OldBlock(String previousHash ) {
			this.index++;
			this.previousHash = previousHash;
			this.timeStamp = new Date().getTime();
			//this.merkleRoot = transactions.merk();
			this.hash = calculateHash(); 
			//Making sure we do this after we set the other values.
		}
		
		public OldBlock() {
			
			this.previousHash="0";
			this.timeStamp = new Date().getTime();
			this.hash = calculateGenHash();
			
		}
		//method to calculate hash

		public String calculateHash() {
			String calculatedhash = SHA256helper.hash(previousHash +
					Long.toString(timeStamp) +
					Integer.toString(nonce) + 
					merkleRoot);
			return calculatedhash;
		}
		
		//this is for genesis hash where we have no transactions
		
		public String calculateGenHash() {
			String genesisHash = SHA256helper.hash(previousHash +
					Long.toString(timeStamp) +
					Integer.toString(nonce)+"0"
					);
			return genesisHash;
			
		}
		
		
		//Increases nonce value until hash target is reached.
		
		public void mineBlock(int difficulty) {
			
			
			String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
			while(!hash.substring( 0, difficulty).equals(target)) {
				nonce ++;
				hash = calculateHash();
			}
			System.out.println("Block Mined!!! : " + hash);
		}

}
