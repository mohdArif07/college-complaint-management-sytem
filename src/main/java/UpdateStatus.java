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

public class UpdateStatus extends JFrame implements ActionListener {

    JTextField idField;
    JComboBox<String> statusBox;
    JButton updateBtn;

    public UpdateStatus() {
        setTitle("Update Complaint Status");
        setSize(300, 200);
        setLayout(new GridLayout(3,2));

        add(new JLabel("Complaint ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Status:"));
        String statuses[] = {"Pending", "In Progress", "Resolved"};
        statusBox = new JComboBox<>(statuses);
        add(statusBox);

        updateBtn = new JButton("Update");
        add(updateBtn);

        updateBtn.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        int id = Integer.parseInt(idField.getText());
        String status = (String) statusBox.getSelectedItem();

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/projectdb",
                "root",
                "root123"
            );

            String query = "UPDATE complaints SET status=? WHERE complaint_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, status);
            pst.setInt(2, id);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Status Updated");

        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new UpdateStatus();
    }
}