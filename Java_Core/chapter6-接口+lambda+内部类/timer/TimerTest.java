package timer;

import java.awt.Toolkit;
import java.awt.event.*;
import java.time.*;
import javax.swing.*;

import javax.swing.JOptionPane;

public class TimerTest {
    public static void main(String[]args){
        var listener=new TimePrinter();
        var timer=new Timer(1000,listener);
        timer.start();

        JOptionPane.showMessageDialog(null, "Quit Program?");

        System.exit(0);
    }
}

class TimePrinter implements ActionListener{
    public void actionPerformed(ActionEvent event){
        System.out.println("At thr tone , the time is "+ Instant.ofEpochMilli(event.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }
}