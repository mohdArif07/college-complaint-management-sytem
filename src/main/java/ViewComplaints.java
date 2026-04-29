/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author arifs
 */
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class ViewComplaints extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewComplaints() {
        setTitle("All Complaints");
        setSize(600, 400);

        model = new DefaultTableModel();
        table = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Title");
        model.addColumn("Description");
        model.addColumn("Category");
        model.addColumn("Status");

        add(new JScrollPane(table));

        loadData();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void loadData() {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/projectdb",
                "root",
                "root123"
            );

            String query = "SELECT * FROM complaints";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("complaint_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("category"),
                    rs.getString("status")
                });
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new ViewComplaints();
    }
}
