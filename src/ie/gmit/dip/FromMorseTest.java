package ie.gmit.dip;

import static org.junit.Assert.*;

import org.junit.*;

public class FromMorseTest {
	private FromMorse m =null;
		
	@Test
	public void goodFile() throws Exception{
		m.decodeFile("C:/Workspace/Morse/text.txt");
	}

	@Test(expected=Exception.class)
	public void badFile() throws Exception{
		m.decodeFile("C:/Workspace/Morse/textr.txt");
	}
	
}
