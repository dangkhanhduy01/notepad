/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.gui;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.*;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author ADMIN
 */
public class JNotepad extends JFrame {
    private JMenuBar menuBar;
    private  JMenu mFile,mEdit,mFormat,mView,mHelp;
    private  JMenuItem itemNew,itemOpen,itemSave,itemSaveAs,itemPageSetup,itemPrint,itemExit;
    private   JTextArea txtEditor;
    public JNotepad(String title)
    {
        super (title);
        createMenu();
        createGUI();
        processEvent();
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public void createMenu(){
        menuBar = new JMenuBar();
        menuBar.add(mFile = new JMenu("File"));
         menuBar.add(mEdit = new JMenu("Edit"));
          menuBar.add(mFormat = new JMenu("Fomat"));
           menuBar.add(mView = new JMenu("View"));
            menuBar.add(mHelp = new JMenu("Help"));
            
         mFile.add(itemNew = new JMenuItem("New"));
         mFile.add(itemOpen = new JMenuItem("Open..."));
         mFile.add(itemSave = new JMenuItem("Save"));
         mFile.add(itemSaveAs = new JMenuItem("SaveAs"));
         mFile.add(itemPageSetup = new JMenuItem("Page Setup..."));
         mFile.add(itemPrint = new JMenuItem("Print"));
          mFile.addSeparator();
          mFile.add(itemExit = new JMenuItem("Exit"));
          
         itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,KeyEvent.CTRL_DOWN_MASK));
           itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
             itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
               itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
                 itemSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
                   itemPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,KeyEvent.CTRL_DOWN_MASK));
        setJMenuBar(menuBar);
    }

    private void createGUI() {
        txtEditor = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(txtEditor);
        add(scrollPane);
        txtEditor.setLineWrap(true);
         txtEditor.setFont((new Font("Arial", Font.PLAIN,20)));
    }

    private void processEvent() {
//itemOpen.addActionListener(new ActionListener());
//@override
//public void actionPerformed(ActionEvent e) {
        //saveFile();
    }
    }
    

