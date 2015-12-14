package ie.gmit.dip;

import java.io.*;

/**
 * ToMorse
 * @author Pearse
 *
 *ToMorse Class contains all methods required to convert strings of text to Morse Code.
 *
 */

public class ToMorse {

	private static String[][] alphabet = {// the array is small and simple. Time saved in searching a binary tree not worth the time it would take to create an evenly distributed tree.
		{"A",".-/"},
		{"B","-.../"},
		{"C","-.-./"},
		{"D","-../"},
		{"E","./"},
		{"F","..-./"},
		{"G","--/"},
		{"H","..../"},
		{"I","../"},
		{"J",".---/"},
		{"K","-.-/"},
		{"L",".-../"},
		{"M","--/"},
		{"N","-./"},
		{"O","---/"},
		{"P",".--./"},
		{"Q","--.-/"},
		{"R",".-./"},
		{"S",".../"},
		{"T","-/"},
		{"U","..-/"},
		{"V","...-/"},
		{"W",".--/"},
		{"X","-..-/"},
		{"Y","-.--/"},
		{"Z","--../"},
		{".","---./"},
		{"1",".----/"},
		{"2","..---/"},
		{"3","...--/"},
		{"4","....-/"},
		{"5","...../"},
		{"6","-..../"},
		{"7","--.../"},
		{"8","---../"},
		{"9","----./"},
		{"0","-----/"},
		
	};
	/**
	 * 
	 * @param msg A string of plain text is taken in
	 * @return A encoded string of the original message is returned
	 * 
	 */
	
	public String codeMorse(String msg) {
		StringBuffer buffer = new StringBuffer();
		String msgUpper = msg.toUpperCase();
		String letter = "";
		for(int i=0; i < msgUpper.length(); i++ ){
			letter = msgUpper.substring(i, i+1);
			if(letter.equals(" ")){
				buffer = buffer.append(' ');
			}else{
				for(int row=0; row<alphabet.length; row ++ ){// Searching Array O(n)
					if(letter.equals(alphabet[row][0])){
						buffer = buffer.append(alphabet[row][1]);//Access Array O(1)
						break;
					}
				}
			}
		}
		return buffer.toString();
	}
	/**
	 * This method is used convert a file to a string which can then be encoded
	 * The code is saved to a file and also returned to the call location as a string
	 * @param name file location and name
	 * @return Returns an encoded string
	 * @throws Exception if a file is not found
	 */
	public String encodeFile(String name) throws Exception{
		BufferedReader in = null;
		StringBuffer buffer = new StringBuffer();
		File message = new File(name);
		File temp = new File("Encoded"+message.getName());
		PrintWriter fw = new PrintWriter(temp);
		in = new BufferedReader(new InputStreamReader(new FileInputStream(message)));
		String line = null;

		
		while((line = in.readLine()) !=null){
			String ucaseLine = line.toUpperCase();
			buffer.append(ucaseLine);
		}
		String msg = codeMorse(buffer.toString()); 
		System.out.println(msg);

		fw.println(msg);
		fw.close();
		in.close();
		return msg;
	}

}
