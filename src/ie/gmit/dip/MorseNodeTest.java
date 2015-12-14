package ie.gmit.dip;

import static org.junit.Assert.*;

import org.junit.*;

public class MorseNodeTest {
private MorseNode mN=null;
	
	@Before
	public void setUpFixture(){
		mN= new MorseNode();
	}
	
	@After
	public void tearDownFixture(){
		mN=null;
	}
	
	public void goodSetValue(){
		mN.setValue("string");
	}
	
	public void goodRightValue(){
		mN.setRight(mN);
	}
	
	public void goodLeftValue(){
		mN.setLeft(mN);
	}

}
