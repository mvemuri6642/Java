/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.print.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.print.PrinterException;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author Manohar Vemuri
 */
public class Seller_Login {

    public static void main(String[] args) {
        new Seller_Login_();
    }

}

class Seller_Login_ extends JFrame {

    JTextField prodnameText;
    JTextField qtyText;
    DefaultTableModel tbmodel;
    JTextArea bill;
    String val;
    int i=1;
    int totalAmount=0;

    public Seller_Login_() {
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        JLabel billLabel = new JLabel("Billing Point");
        billLabel.setBounds(500, 20, 1000, 55);
        billLabel.setFont(new Font("Courier", Font.BOLD, 20));

        JLabel prodnameLabel = new JLabel("Product Name");
        prodnameLabel.setBounds(200, 100, 100, 25);
        

        prodnameText = new JTextField();
        prodnameText.setBounds(300, 100, 150, 25);

        JLabel qtyLabel = new JLabel("Quantity");
        qtyLabel.setBounds(200, 150, 100, 25);

        qtyText = new JTextField();
        qtyText.setBounds(300, 150, 150, 25);

        JButton add = new JButton("ADD");
        add.setBounds(215, 250, 100, 25);

        JButton clear = new JButton("CLEAR");
        clear.setBounds(332, 250, 100, 25);

        JLabel prodListLabel = new JLabel("Product List");
        prodListLabel.setBounds(775, 95, 80, 20);
        prodListLabel.setFont(new Font("Courier",Font.BOLD,12));
        
        JComboBox catBox=new JComboBox();
        //catBox.setSelectedIndex(0);
        catBox.setBounds(575,145,150,25);
        
        
        JButton Filterbutton=new JButton("FILTER");
        Filterbutton.setBounds(750,145,150,25);
        
        JButton refresBbutton=new JButton("REFRESH");
        refresBbutton.setBounds(925,145,150,25);
        
        
        
        tbmodel=new DefaultTableModel();
        JTable tb=new JTable(tbmodel);
        tb.setCellSelectionEnabled(true);
        tb.setPreferredScrollableViewportSize(new Dimension(850,200));
        tbmodel.addColumn("PID");
        tbmodel.addColumn("Name");
        tbmodel.addColumn("Quantity");
        tbmodel.addColumn("Price");
        tbmodel.addColumn("Category");
        JScrollPane sp=new JScrollPane(tb);
        sp.setBounds(575,200,500,200);
        
        
        bill=new JTextArea();
        bill.setBounds(575,420,500,200);
        String deftextArea="S.No\tProduct\t\tPrice\tQuantity\tTotal";
        
        bill.setText(deftextArea);
        
        
        
        JLabel amount=new JLabel("Rs:");
        amount.setBounds(980, 615, 100, 50);
        amount.setFont(new Font("Courier",Font.BOLD,15));
        
        
        JButton print1=new JButton("Print");
        print1.setBounds(775,660,100,25);
        
        
        JButton logout=new JButton("Logout");
        logout.setBounds(1065,20,100,25);
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
            Statement stmt=con.createStatement();
            String query="select Category_Name from Categories_Data order by Category_Name asc";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                String name=rs.getString("Category_Name");
                catBox.addItem(name);
            }
        }
        catch(Exception ex){
            System.out.println();
        }
        String defquery="select prodID,prodName,prodQTY,prodPrice,Category_Name from Product_Data";
        RefreshTB(defquery);
        
        Filterbutton.addActionListener(e->{
            
            String filterquery="select prodID,prodName,prodQTY,prodPrice,Category_Name from Product_Data where Category_Name='"+catBox.getSelectedItem()+"'";
            
            RefreshTB(filterquery);
        });
        
        refresBbutton.addActionListener(e->{
            RefreshTB(defquery);
            catBox.setSelectedIndex(0);
        });
        
        
        add.addActionListener(e->{
            int m=Integer.valueOf(qtyText.getText());
            String addupdate="update Product_Data set prodQTY=prodQTY-'"+m+"' where prodName='"+prodnameText.getText()+"'";
            SqlExecute(addupdate);
            try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
            Statement stmt=con.createStatement();
            String query="select prodPrice from Product_Data where prodName='"+prodnameText.getText()+"'";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                int pr=rs.getInt("prodPrice");
                int qt=Integer.valueOf(qtyText.getText());
                int total=pr*qt;
                totalAmount+=total;
                bill.append("\n"+i+"\t"+prodnameText.getText()+"\t\t"+pr+"\t"+qt+"\t"+total);
                //bill.append("\n"+i+"\t"+prodnameText.getText()+"\t\t"+pr+"\t"+qt+"\t"+total+"\n\n\n\t\t\t\t            RS:");
                amount.setText(String.valueOf("Rs:"+totalAmount+"/-"));
                }
            
            }
            
            catch(Exception ex){
            System.out.println(ex);
            }
            
            
            //int cost=Integer.valueOf(Sqlquery(query));
            //bill.append("\n"+i+"\t"+prodnameText.getText()+"\t\t"+cost+"\tQuantity\tTotal");
            i+=1;
            RefreshTB(defquery);
            clrText();
        });
        
        tb.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                int i=tb.getSelectedRow();
                TableModel model=tb.getModel();
                prodnameText.setText(model.getValueAt(i, 1).toString());
                //qtyText.setText(model.getValueAt(i,2).toString());
                
            }
        });
        
        
        
        clear.addActionListener(e->{
            clrText();
        });
        
        

        print1.addActionListener(e->{
            bill.append("\n\n\t\t\t\t\t\n\n\n\t\t\tTotal Amount:     "+amount.getText());
            try{
                bill.print();
                
                
            }
            catch(PrinterException ex){
                System.out.println(ex);
            }
        });
        logout.addActionListener(e->{
            new login();
            dispose();
        });
        
        
        
        
        
        

        p1.add(billLabel);
        p1.add(prodnameLabel);
        p1.add(prodnameText);
        p1.add(qtyLabel);
        p1.add(qtyText);
        p1.add(add);
        p1.add(clear);
        p1.add(prodListLabel);
        p1.add(catBox);
        p1.add(Filterbutton);
        p1.add(refresBbutton);
        p1.add(sp);
        p1.add(bill);
        p1.add(amount);
        p1.add(print1);
        p1.add(logout);
        add(p1);
        setVisible(true);
        setResizable(false);
        setSize(1200, 750);
        setTitle("Seller");
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    
    
    public String Sqlquery(String query){
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
            Statement stmt=con.createStatement();
            
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                val= String.valueOf(rs);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return val;
    }
    
    
    public void RefreshTB(String query){
        tbmodel.setRowCount(0);
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
            Statement stmt=con.createStatement();
            
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                String pid=String.valueOf(rs.getInt("prodID"));
                String pname=String.valueOf(rs.getString("prodName"));
                String qty=String.valueOf(rs.getInt("prodQTY"));
                String price=String.valueOf(rs.getInt("prodPrice"));
                String cat=String.valueOf(rs.getString("Category_Name"));
                String tbdata[]={pid,pname,qty,price,cat};
                tbmodel.addRow(tbdata);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void SqlExecute(String query){
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
            Statement stmt=con.createStatement();
            
            stmt.executeUpdate(query);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
    }
    public void clrText(){
        prodnameText.setText("");
        qtyText.setText("");
    }
}
