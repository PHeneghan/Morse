package ie.gmit.dip;

public interface Node {
	public void setValue(String value);
	public String getValue();
	public Node getLeft();
	public void setLeft(Node left);
	public Node getRight();
	public void setRight(Node right);
}
