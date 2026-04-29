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

public class StudentDashboard extends JFrame implements ActionListener {

    JButton addBtn, viewBtn;

    public StudentDashboard() {
        setTitle("Student Dashboard");
        setSize(300, 200);
        setLayout(new GridLayout(2,1));

        addBtn = new JButton("Add Complaint");
        viewBtn = new JButton("View My Complaints");

        add(addBtn);
        add(viewBtn);

        addBtn.addActionListener(this);
        viewBtn.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addBtn) {
            new ComplaintForm();
        }

        if(e.getSource() == viewBtn) {
            new ViewComplaints();
        }
    }
}
