package Research.Myprojects;

import java.util.Arrays;

public class selectMiner {
	
	
	
	public static void miner() {
		
		
		
		String[] Alice = {"1","2"};
		String[] Bob = {"3","4","5","6"};
		String[] Charlie = {"7","8","9","10","11","12","13", "14"};
		String[] Dean = {"15","16","17","18","19"};
		
		int miner = (int) (Math.round(Math.random()*(19)));
		
		boolean result = Arrays.stream(Alice).anyMatch(Integer.toString(miner)::equals);
		
	
	if(result)
		System.out.println("Alice is selected as miner");
		else if(Arrays.stream(Bob).anyMatch(Integer.toString(miner)::equals))
			System.out.println("Bob is selected as miner");
		else if(Arrays.stream(Charlie).anyMatch(Integer.toString(miner)::equals))
			System.out.println("Charlie is selected as miner");
		
		else
			System.out.println("Dean is selected as miner");
	  
		
}
}