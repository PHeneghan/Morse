package ie.gmit.dip;

import java.io.*;
/**
 * FromMorse
 * @author Pearse
 *
 *A class for discyphering the Morse code
 *
 */
public class FromMorse {

	private static Node root = new MorseNode();
	
	/**
	 * The addNode method is only called upon by the Runner class
	 * It adds the node to the binary tree
	 * @param key The key is both the Morse Code of the letter and the instructions to the location of where the node is stored.
	 * @param letter The corresponding letter to the '.' and '-'
	 */
	
	public void addNode(String key, String letter) {
		Node current = root;
		char [] keyArray = key.toCharArray();
		
		for (int i = 0; i < key.length(); i++) {// Searching binary tree O(log(n))
			if (keyArray[i] == '-') {
                if (current.getLeft() == null) {
                   	 current.setLeft(new MorseNode());
                     current = current.getLeft();
                } else {
                	 current = current.getLeft();   
                }
            } else {
                if (current.getRight() != null) {
                    current = current.getRight();
                } else {
                    current.setRight(new MorseNode());
                    current = current.getRight();
                }
            }
			
		}
		current.setValue(letter);
	}
	
	/**
	 * Searches the tree to decode the message
	 * @param str The message read in as a string
	 * @return The decoded message returned as a string
	 */
	
	public String decode(String str) {
		char [] strArray = str.toCharArray();
        StringBuffer buffer = new StringBuffer();
        Node current = root;
         
        for (int i = 0; i < str.length(); i++) {    // Looping over string O(n)
            if (strArray[i]=='-') {					// Searching binary tree O(log(n))
                if (current.getLeft() != null) {
                    current = current.getLeft();
                } else {
                    current.setLeft(new MorseNode());
                    current = current.getLeft();
                }
            } else if (strArray[i]=='.') {
                if (current.getRight() != null) {
                    current = current.getRight();
                } else {
                    current.setRight(new MorseNode());
                    current = current.getRight();
                }
            } else if(strArray[i]=='/'){
                if(current.getValue() != null){
                	buffer = buffer.append(current.getValue());
                }else{
                	buffer = buffer.append('~');
                }
                current = root;
            } else if(strArray[i]==' '){
                buffer = buffer.append(' ');
                current = root;
            }else{
            	 buffer = buffer.append('~');
                 current = root;
            }
        }
        return buffer.toString();
    }
	
	/**
	 * This method is used convert a file to a string which can then be decoded
	 * The code is saved to a file and also returned to the call location as a string
	 * @param name file location and name
	 * @return Returns an decoded string
	 * @throws Exception if a file is not found
	 */
	
	public String decodeFile(String name) throws Exception{
		BufferedReader in = null;
		StringBuffer buffer = new StringBuffer();
		File message = new File(name);
		File temp = new File("Decoded"+message.getName());
		PrintWriter fw = new PrintWriter(temp);
		in = new BufferedReader(new InputStreamReader(new FileInputStream(message)));
				String line = null;

		
		while((line = in.readLine()) !=null){
			String ucaseLine = line.toUpperCase();
			buffer.append(ucaseLine);
		}
		String msg = decode(buffer.toString()); 
		System.out.println(msg);
		fw.println(msg);
		fw.close();
		in.close();
		return msg;
	}

}
