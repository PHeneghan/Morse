package ie.gmit.dip;

/**
 * Runner 
 * @author Pearse
 *
 *The Runner class is used once.
 *It contains all the information required to
 *fill the nodes f the binary tree.
 *
 */
public class Runner {

	private static FromMorse fM = new FromMorse();
	
	
	public void runner(){  // Insertion into binary tree O(log(n))
		fM.addNode("-","T");
		fM.addNode(".","E");
		fM.addNode("--","M");
		fM.addNode("-.","N");
		fM.addNode("---","O");
		fM.addNode("--.","G");
		fM.addNode("-----","0");
		fM.addNode("----.","9");
		fM.addNode("---.",".");
		fM.addNode("---..","8");
		fM.addNode("--.-","Q");
		fM.addNode("--..","Z");
		fM.addNode("--...","7");
		fM.addNode("-.-","K");
		fM.addNode("-..","D");
		fM.addNode("-.--","Y");
		fM.addNode("-.-.","C");
		fM.addNode("-..-","X");
		fM.addNode("-...","B");
		fM.addNode("-....","6");
		fM.addNode(".-","A");
		fM.addNode("..","I");
		fM.addNode(".--","W");
		fM.addNode(".-.","R");
		fM.addNode(".---","J");
		fM.addNode(".--.","P");
		fM.addNode(".----","1");
		fM.addNode(".-..","L");
		fM.addNode("..-","U");
		fM.addNode("...","S");
		fM.addNode("..-.","F");
		fM.addNode("..---","2");
		fM.addNode("...-","V");
		fM.addNode("...--","3");
		fM.addNode("....","H");
		fM.addNode("....-","4");
		fM.addNode(".....","5");
		
	}

	
	
	
	
}
