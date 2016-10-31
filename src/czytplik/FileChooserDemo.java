/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

package czytplik;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FileChooserDemo extends JPanel
                             implements ActionListener {
    static private final String newline = "\n";
    JButton openButton, saveButton, analizeButton, modifyButton;
    JTextArea log;
    JFileChooser fc;
    static File file;

    public FileChooserDemo() {
        super(new BorderLayout());

        log = new JTextArea(20,25);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        //Create a file chooser
        fc = new JFileChooser();
        openButton = new JButton("Open a File...",
                                 createImageIcon("/images/open2.gif"));
        openButton.addActionListener(this);
        
        analizeButton = new JButton("Analyse a File...",
                				createImageIcon("/images/analyse.png"));
        analizeButton.addActionListener(this);
        
        modifyButton = new JButton("Modify a File...",
								createImageIcon("/images/modify.png"));
        modifyButton.addActionListener(this);

        saveButton = new JButton("Save a File...",
                                 createImageIcon("/images/save.gif"));
        saveButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(openButton);
        buttonPanel.add(analizeButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(saveButton);

        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }
    
    public static File getFile() {
    	return file;
    }

    public void actionPerformed(ActionEvent e) {

        //Handle open button action.
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(FileChooserDemo.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
                //This is where a real application would open the file.
                log.append("File opened: " + file.getName() + "." + newline);
            } else {
                log.append("Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
        }
        
      //Handle analize button action.
        else if (e.getSource() == analizeButton) {
                //This is where a real application would open the file.
        		if (file == null) { 
        			log.append("No file. Open a file first!");
        		} else {
                //AnalizujPlik ap = new AnalizujPlik(FileChooserDemo.getFile());
        		Czytaj cz = null;
				try {
					cz = new Czytaj(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					log.append("Error happened!");
				}
                log.append("Analysing the file..." + newline);
                log.append("In the file there are: " + newline);
                log.append(cz.ileLinii() + " lines" + newline);
                log.append(cz.ileSlow() + " words" + newline);
                log.append(cz.ileLiter() + " chars" + newline);
        		}
                log.setCaretPosition(log.getDocument().getLength());
        }
        
      //Handle modify button action.
//        else if (e.getSource() == modifyButton) {
//                //This is where a real application would open the file.
//        		if (file == null) { 
//        			log.append("No file. Open a file first!");
//        		} else {
//                mp = new ModyfikujPlik(file);
//                mp.modFile();
//                log.append("Your file has been modified.");
//        		}
//                log.setCaretPosition(log.getDocument().getLength());
//        }
        
        //Handle save button action.
        else if (e.getSource() == saveButton) {
            int returnVal = fc.showSaveDialog(FileChooserDemo.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File newf = fc.getSelectedFile();
                //mp.saveMod(newf);
                log.append("File saved: " + newf.getName() + "." + newline);
            } else {
                log.append("Save command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
        }
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = FileChooserDemo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


    static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Ula's Small File Mananager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new FileChooserDemo());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


}
