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
import java.sql.*;

public class ComplaintForm extends JFrame implements ActionListener {

    JTextField titleField;
    JTextArea descriptionArea;
    JComboBox<String> categoryBox;
    JButton submitBtn;

    public ComplaintForm() {
        setTitle("Submit Complaint");
        setSize(400, 300);
        setLayout(new GridLayout(5,2));

        add(new JLabel("Title:"));
        titleField = new JTextField();
        add(titleField);

        add(new JLabel("Description:"));
        descriptionArea = new JTextArea();
        add(descriptionArea);

        add(new JLabel("Category:"));
        String categories[] = {"Hostel", "Faculty", "Infrastructure", "Exam"};
        categoryBox = new JComboBox<>(categories);
        add(categoryBox);

        submitBtn = new JButton("Submit");
        add(submitBtn);

        submitBtn.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String title = titleField.getText();
        String desc = descriptionArea.getText();
        String category = (String) categoryBox.getSelectedItem();

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/projectdb",
                "root",
                "root123"
            );

            String query = "INSERT INTO complaints (user_id, title, description, category, status) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, 1); // admin user id (temporary)
            pst.setString(2, title);
            pst.setString(3, desc);
            pst.setString(4, category);
            pst.setString(5, "Pending");

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Complaint Submitted");

        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new ComplaintForm();
    }
}
