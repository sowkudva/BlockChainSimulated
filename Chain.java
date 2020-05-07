package Research.Myprojects;
import com.google.common.collect.Multimap;
import com.google.gson.GsonBuilder;
import Research.Myprojects.App;
import java.util.ArrayList;
import java.util.HashMap;
import Research.Myprojects.transactions;
public class Chain {
	
	//This code is for PoW consensus
	
	
	private static long startTime = System.nanoTime();
	public static ArrayList<ABlock> blockchain = new ArrayList<ABlock>();
	public static int difficulty = 1;

	public static void main(String[] args) {	
		//add our blocks to the blockchain ArrayList:
		
		
		
		System.out.println("Creating and Mining Genesis block... ");
		ABlock genesis = new ABlock();
		blockchain.add(genesis);
		System.out.println("Genesis block added... ");
		
		
	   
		
		System.out.println("Trying to Mine block 1... ");
		ABlock block1 = new ABlock(genesis.hash, 0);
		
		
		System.out.println("Selecting miners ");
		
		selectMiner.miner();
		
		blockchain.add(block1);
		blockchain.get(1).mineBlock(difficulty);
		
		
		
		
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);
	}

}
