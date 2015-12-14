package ie.gmit.dip;

/**
 * MorseNode 
 * @author Pearse
 *
 *Class MorseNode implements Node interface
 *Contains all required methods to create the nodes
 *of the binary tree used in this application.
 *
 */
public class MorseNode implements Node {

	private String value;
	private Node left;
	private Node right;
	
	public MorseNode() {
		value = null;
		left = null;
		right = null;
	}
	
	
	@Override
	public void setValue(String value) {
		this.value=value;
		
	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public Node getLeft() {
		return this.left;
	}

	@Override
	public void setLeft(Node left) {
		this.left = left;
		
	}

	@Override
	public Node getRight() {
		return this.right;
	}

	@Override
	public void setRight(Node right) {
		this.right = right;
		
	}
	
}

