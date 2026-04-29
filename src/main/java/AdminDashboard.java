/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author arifs
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame implements ActionListener {

    JButton viewBtn, updateBtn;

    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setSize(300, 200);
        setLayout(new GridLayout(2,1));

        viewBtn = new JButton("View Complaints");
        updateBtn = new JButton("Update Status");

        add(viewBtn);
        add(updateBtn);

        viewBtn.addActionListener(this);
        updateBtn.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == viewBtn) {
            new ViewComplaints();
        }

        if(e.getSource() == updateBtn) {
            new UpdateStatus();
        }
    }
}
