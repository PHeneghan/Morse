package ie.gmit.dip.gui;

import ie.gmit.dip.FromMorse;
import ie.gmit.dip.Runner;
import ie.gmit.dip.ToMorse;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * MorseWindow
 * @author Pearse
 * MorseWindow class contains the JFrame method and the Main method
 */

public class MorseWindow {
	private JFrame frame;
	private static FromMorse fM = new FromMorse();
	private static ToMorse tM = new ToMorse();
	private static Runner run = new Runner();
	private String name = "";
	private String coded = "";
	private String message = "";
	private long t2;
	
	public MorseWindow(){
		//Create a window for the application
		frame = new JFrame();
		frame.setTitle("H.Dip 2015 - Morse Encoder/Decoder");
		frame.setSize(550, 500);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());
		
		
		//The morse pad will and button will be added to a panel
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        topPanel.setBorder(new javax.swing.border.TitledBorder("Enter Morse Code"));
        topPanel.setPreferredSize(new java.awt.Dimension(500, 100));
        topPanel.setMaximumSize(new java.awt.Dimension(500, 100));
        topPanel.setMinimumSize(new java.awt.Dimension(500, 100));
        
        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	System.out.println("Start recording");
            	message = "";         // Allows new Morse Code to begin 
            	setMessage(message);
			}
        });
        
        topPanel.add(btnStart);
        
        /**
         * Where Morse Code inputed by the user is handled
         * Right click '.' left '-'
         * Between 1 and 3 seconds gap between clicks for new letter
         * Gap of greater than 3seconds between clicks for space.
         */
        JPanel morsePanel = new JPanel();
        morsePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.SoftBevelBorder.RAISED));
        morsePanel.setBackground(Color.LIGHT_GRAY);
        morsePanel.setPreferredSize(new java.awt.Dimension(250, 50));
        morsePanel.setMaximumSize(new java.awt.Dimension(250, 50));
        morsePanel.setMinimumSize(new java.awt.Dimension(250, 50));
        morsePanel.addMouseListener(new MouseAdapter() {
        	public void mousePressed( MouseEvent e ) {  
        		StringBuffer buffer = new StringBuffer();
        		long t1 = System.currentTimeMillis();
        		System.out.println(t1);
    			t2 = getT2();
    			System.out.println(t2);
    			long t3 = t1-t2;
    			System.out.println(t3);
    			setT2(t1);
        		message = getMessage();
        		buffer.append(message);
        		if(1000<=t3 && t3<3000){
        			buffer = buffer.append('/');
        		}else if(t3>=3000){
        			buffer = buffer.append("/ ");
        		}
        		if (e.isMetaDown() ) {  
                    System.out.println( "Right Click" );
                    buffer = buffer.append('-');
                }else{
                	System.out.println( "Normal Click" );
                	buffer = buffer.append('.');
                }
        		message = buffer.toString();
        		setMessage(message);
    		
        		
        		        		
            }  
		});
        // Sends the inputed Morse code from the bar to be decoded.
        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	System.out.println("Decoding");
            	String msg = getMessage().substring(2) + "/";
            	System.out.println(msg);
            	coded = msg + "\n" + fM.decode(msg);
            	setCoded(coded);
			}
        });
        
        topPanel.add(morsePanel);
        topPanel.add(btnSend);
        frame.getContentPane().add(topPanel); //Add the morse panel to the window
        
        
        //The file panel will contain the file chooser
        JPanel filePanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        filePanel.setBorder(new javax.swing.border.TitledBorder("Select File to Encode"));
        filePanel.setPreferredSize(new java.awt.Dimension(500, 100));
        filePanel.setMaximumSize(new java.awt.Dimension(500, 100));
        filePanel.setMinimumSize(new java.awt.Dimension(500, 100));
        
        final JTextField txtFileName =  new JTextField(20);
		txtFileName.setPreferredSize(new java.awt.Dimension(100, 30));
		txtFileName.setMaximumSize(new java.awt.Dimension(100, 30));
		txtFileName.setMargin(new java.awt.Insets(2, 2, 2, 2));
		txtFileName.setMinimumSize(new java.awt.Dimension(100, 30));
		
		JButton btnChooseFile = new JButton("Browse...");
		btnChooseFile.setToolTipText("Select File to Encode");
        btnChooseFile.setPreferredSize(new java.awt.Dimension(75, 30));
        btnChooseFile.setMaximumSize(new java.awt.Dimension(975, 30));
        btnChooseFile.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnChooseFile.setMinimumSize(new java.awt.Dimension(75, 30));
		btnChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
        		JFileChooser fc = new JFileChooser("./");
        		int returnVal = fc.showOpenDialog(frame);
            	if (returnVal == JFileChooser.APPROVE_OPTION) {
                	File file = fc.getSelectedFile().getAbsoluteFile();
                	String name = file.getAbsolutePath(); 
                	txtFileName.setText(name);
                	System.out.println("You selected the following file: " + name);
                	setName(name);
            	}
			}
        });
		
		JButton btnDecodeFile = new JButton("Decode"); //File can be decyphered
		btnDecodeFile.setToolTipText("Decode Selected File");
		btnDecodeFile.setPreferredSize(new java.awt.Dimension(75, 30));
		btnDecodeFile.setMaximumSize(new java.awt.Dimension(75, 30));
		btnDecodeFile.setMargin(new java.awt.Insets(2, 2, 2, 2));
		btnDecodeFile.setMinimumSize(new java.awt.Dimension(75, 30));
		btnDecodeFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	System.out.println("Decode.....");
            	try {
					coded = getCoded();
            		coded = fM.decodeFile(name);
					setCoded(coded);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
			}
        });
		
		JButton btnEncodeFile = new JButton("Encode");// A file can be Converted into Morse code
		btnEncodeFile.setToolTipText("Encode Selected File");
		btnEncodeFile.setPreferredSize(new java.awt.Dimension(75, 30));
		btnEncodeFile.setMaximumSize(new java.awt.Dimension(75, 30));
		btnEncodeFile.setMargin(new java.awt.Insets(2, 2, 2, 2));
		btnEncodeFile.setMinimumSize(new java.awt.Dimension(75, 30));
		btnEncodeFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	System.out.println("Encode.....");
            	try {
            		coded = getCoded();
            		coded = tM.encodeFile(name);
					setCoded(coded);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
			}
        });
		
        filePanel.add(txtFileName);
        filePanel.add(btnChooseFile);
        filePanel.add(btnEncodeFile);
        filePanel.add(btnDecodeFile);
        frame.getContentPane().add(filePanel); //Add the panel to the window
        
        
        //A separate panel for the programme output
        JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        middlePanel.setPreferredSize(new java.awt.Dimension(500, 300));
        middlePanel.setMaximumSize(new java.awt.Dimension(500, 300));
        middlePanel.setMinimumSize(new java.awt.Dimension(500, 300));

        /**
         * JTextArea has being set up to be used for multiple purposes 
         * 1. Can be used to take notes
         * 2. Displays the last message encoded/ decoded my clicking "Update"
         * 3. Can convert plain texts typed into it by clicking "Encode"
         */
        final JTextArea notes = new JTextArea();
        notes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.SoftBevelBorder.LOWERED));
		notes.append("THIS IS LONDON CALLING. COME IN TOBRUK.");
		notes.setPreferredSize(new java.awt.Dimension(480, 200));
		notes.setMinimumSize(new java.awt.Dimension(480, 200));
		notes.setMaximumSize(new java.awt.Dimension(480, 200));
		frame.getContentPane().add(notes);
		
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setPreferredSize(new java.awt.Dimension(500, 50));
        bottomPanel.setMaximumSize(new java.awt.Dimension(500, 50));
        bottomPanel.setMinimumSize(new java.awt.Dimension(500, 50));
        
        
        JButton btnCode = new JButton("Encode");
        btnCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	coded = tM.codeMorse(notes.getText());
            	notes.setText(coded);
			}
        });
        
        //Create and add Clear and Quit buttons
        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	notes.setText(coded);
			}
        });
        
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	notes.setText("");
			}
        });
        
        JButton btnQuit = new JButton("Quit");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	System.exit(0);
			}
        });
        bottomPanel.add(btnCode);
        bottomPanel.add(btnUpdate);
        bottomPanel.add(btnClear);
        bottomPanel.add(btnQuit);
        frame.getContentPane().add(bottomPanel);       
		frame.setVisible(true);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoded() {
		return coded;
	}

	public void setCoded(String coded) {
		this.coded = coded;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getT2() {
		return t2;
	}

	public void setT2(long t2) {
		this.t2 = t2;
	}
	
	public static void main(String[] args) {
		new MorseWindow();
		run.runner();
	}
	
}