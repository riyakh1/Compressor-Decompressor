package GUI;

import Comp_Decomp.Compressor;
import Comp_Decomp.Decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {

    JButton compressButton;
    JButton decompressButton;

    AppFrame(){

        this.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        compressButton = new JButton("Select files to compress");
        compressButton.setBounds(79, 100, 200, 30);
        compressButton.addActionListener(this);

        decompressButton = new JButton("Select files to decompress");
        decompressButton.setBounds(30, 150, 200, 30);
        decompressButton.addActionListener(this);

        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(400, 400);
        this.getContentPane().setBackground(Color.darkGray);
        this.setVisible(true);
    }

//    private void setDefaultCLoseOperation(int exitOnClose) {
//    }

//    private void setDefaultCLoseOperation(int exitOnClose) {
//    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==compressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Compressor.method(file);
                }

                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }

        if(e.getSource()==decompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Decompressor.method(file);
                }

                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
    }
}