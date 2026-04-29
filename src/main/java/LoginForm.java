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

public class LoginForm extends JFrame implements ActionListener {

    JTextField emailField;
    JPasswordField passwordField;
    JButton loginBtn;

    public LoginForm() {
        setTitle("Login");
        setSize(300, 200);
        setLayout(new GridLayout(3,2));

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        loginBtn = new JButton("Login");
        add(loginBtn);

        loginBtn.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/projectdb",
                "root",
                "root123"
            );

            String query = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if(rs.next()) {

    String role = rs.getString("role");

    if(role.equals("admin")) {
        new AdminDashboard();
    } else {
        new StudentDashboard();
    }

    dispose(); // close login window

} else {
    JOptionPane.showMessageDialog(this, "Invalid Credentials");
}

        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
