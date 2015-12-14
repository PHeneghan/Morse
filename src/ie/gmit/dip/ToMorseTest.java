package ie.gmit.dip;

import static org.junit.Assert.*;

import org.junit.*;

public class ToMorseTest {
	private ToMorse m =null;
	
	@Test
	public void goodFile() throws Exception{
		String i = m.encodeFile("C:/Workspace/Morse/text.txt");
	}

	@Test(expected=Exception.class)
	public void badFile() throws Exception{
		String i = m.encodeFile("C:/Workspace/Morse/textr.txt");
	}
	
	@Test
	public void goodString(){
		String i =m.codeMorse("Hi");
	}

	@Test
	public void badString(){
		String i =m.codeMorse(".../---/...");
	}
}
