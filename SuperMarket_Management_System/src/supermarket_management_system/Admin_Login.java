/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author Manohar Vemuri
 */
public class Admin_Login {
    public static void main(String[] args){
        new Admin_Login_();
    }
    
}
class Admin_Login_ extends JFrame{
    int id;
    
    JTabbedPane tp;
    JButton refreshButton;
    DefaultTableModel tbmodel;
    JTextField prodidText;
    JTextField nameText;
    JTextField qtyText;
    JTextField priceText;
    JTextField catText;
    
    
    
    
    JTextField catoidText;
    JTextField catoText;
    JTextArea descText;
    JButton refreshButtoncat;
    DefaultTableModel tbmodel1;
    
    
    
    JTextField sellnameText;
    JPasswordField sellpassText;
    JTextField sellemailText;
    JTextField idText;
    JComboBox gender;
    JButton sellrefreshButton;
    DefaultTableModel tbmodel2;
    
    
    
    public Admin_Login_(){
        tp=new JTabbedPane(JTabbedPane.LEFT);
        JPanel prod=new JPanel();
        JPanel sellers=new JPanel();
        JPanel cato=new JPanel();
        
        /*Product List JLabel*/
        JLabel prodLabel=new JLabel("Manage Products");
        prodLabel.setBounds(450, 20, 1000, 55);
        prodLabel.setFont(new Font("Courier", Font.BOLD,20));
        
        /*TextFields*/
        JLabel prodidLabel=new JLabel("Product ID");
        prodidLabel.setBounds(200,100,100,25);
        
        prodidText=new JTextField();
        prodidText.setBounds(300, 100, 150, 25);
        
        JLabel qtyLabel=new JLabel("Quantity");
        qtyLabel.setBounds(550, 100, 100, 25);
        
        qtyText=new JTextField();
        qtyText.setBounds(650, 100, 150, 25);
        
        JLabel nameLabel=new JLabel("Name");
        nameLabel.setBounds(200,150,100,25);
        
        nameText=new JTextField();
        nameText.setBounds(300,150,150,25);
        
        JLabel priceLabel=new JLabel("Price");
        priceLabel.setBounds(550,150,100,25);
        
        priceText=new JTextField();
        priceText.setBounds(650,150,150,25);
        
        JLabel catLabel=new JLabel("Catagory");
        catLabel.setBounds(200,200,100,25);
        
        catText=new JTextField();
        catText.setBounds(300,200,150,25);
        
        
        /*JButtons*/
        
        
        
        JButton add=new JButton("ADD");
        add.setBounds(207,250,100,25);
        
        JButton edit=new JButton("EDIT");
        edit.setBounds(327,250,100,25);
        
        JButton delete=new JButton("DELETE");
        delete.setBounds(447,250,100,25);
        
        JButton clr=new JButton("CLEAR");
        clr.setBounds(567,250,100,25);
        
        
        refreshButton=new JButton("REFRESH");
        refreshButton.setBounds(687, 250, 100, 25);
        
        
        
        
        //Table Data
        tbmodel=new DefaultTableModel();
        JTable prodTable=new JTable(tbmodel);
        prodTable.setCellSelectionEnabled(true);
        prodTable.setPreferredScrollableViewportSize(new Dimension(850,100));
        tbmodel.addColumn("Product ID");
        tbmodel.addColumn("Product Name");
        tbmodel.addColumn("Quantity");
        tbmodel.addColumn("Price");
        tbmodel.addColumn("Catagory");
        JScrollPane sp=new JScrollPane(prodTable);
        sp.setBounds(200, 300, 600, 350);
        
        prodTable.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                int i=prodTable.getSelectedRow();
                TableModel model=prodTable.getModel();
                nameText.setText(model.getValueAt(i, 1).toString()); 
                qtyText.setText(model.getValueAt(i, 2).toString());
                priceText.setText(model.getValueAt(i, 3).toString());
                catText.setText(model.getValueAt(i, 4).toString());
                
            }
        });
        
        
        //Logout Button
        JButton logout=new JButton("Logout");
        logout.setBounds(925,20,100,25);
        
        
        prod.add(prodLabel);
        prod.add(prodidLabel);
        prod.add(prodidText);
        prod.add(qtyLabel);
        prod.add(qtyText);
        prod.add(nameLabel);
        prod.add(nameText);
        prod.add(priceLabel);
        prod.add(priceText);
        prod.add(catLabel);
        prod.add(catText);
        prod.add(logout);
        
        //add Buttons
        
        
        prod.add(add);
        prod.add(edit);
        prod.add(delete);
        prod.add(clr);
        prod.add(refreshButton);
        
        //add table
        prod.add(sp);
        
        refresh(); // default table
        idTextField();//for prodid 
        
        
        
        
        //add Button
        add.addActionListener(e->{
            tbmodel.setRowCount(0);
            try{
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
                Statement stmt=con.createStatement();
                String query="insert into Product_Data(prodName,prodQTY,prodPrice,Category_Name) values('"+nameText.getText()+"',"
                        + "'"+qtyText.getText()+"','"+priceText.getText()+"','"+catText.getText()+"')";
                stmt.executeUpdate(query);
                refresh();
                stmt.close();
                con.close();
                clrText(1);
                
            }
            catch(Exception ex1){
                System.out.println("Error while adding"+ex1);
            }
        });
        
        
        
        //edit button
        prodTable.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                int i=prodTable.getSelectedRow();
                TableModel model=prodTable.getModel();
                prodidText.setText(model.getValueAt(i, 0).toString());
                nameText.setText(model.getValueAt(i, 1).toString()); 
                qtyText.setText(model.getValueAt(i, 2).toString());
                priceText.setText(model.getValueAt(i, 3).toString());
                catText.setText(model.getValueAt(i, 4).toString());
                
            }
        });
        edit.addActionListener(e->{
            tbmodel.setRowCount(0);
            try{
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
                Statement stmt=con.createStatement();
                String query="update Product_Data set prodName='"+nameText.getText()+"',prodQTY='"+qtyText.getText()+"',prodPrice='"+priceText.getText()+"',Category_Name='"+catText.getText()+"' "
                        + "where prodID="+prodidText.getText()+"";
                stmt.executeUpdate(query);
                refresh();
                clrText(1);
                
                
                stmt.close();
                con.close();
                
            }
            catch(Exception ex2){
                System.out.println(ex2);
                
            }
        });
        
        
        
        
        delete.addActionListener(e->{
            String query="delete from Product_Data where prodID='"+prodidText.getText()+"' && prodName='"+nameText.getText()+"'";
            SqlExecute(query);
            refresh();
            clrText(1);
            
        });
        
        
        clr.addActionListener(e->{
            clrText(1);
        });
        
        logout.addActionListener(e->{
            dispose();
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //refreshButton
        refreshButton.addActionListener(e->{
            tbmodel.setRowCount(0);
            refresh();
            
            /*
            try{
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
                Statement stmt=con.createStatement();
                String query="select * from Product_Data";
                
                ResultSet rs=stmt.executeQuery(query);
                while(rs.next()){
                    String pid=String.valueOf(rs.getInt("prodId"));
                    String pname=String.valueOf(rs.getString("prodName"));
                    String pqty=String.valueOf(rs.getInt("prodQty"));
                    String price=String.valueOf(rs.getInt("prodPrice"));
                    String catname=String.valueOf(rs.getString("Category_Name"));
                    String tbdata[]={pid,pname,pqty,price,catname};
                    tbmodel.addRow(tbdata);
                }
                stmt.close();
                con.close();
            }
            catch(Exception ex2){
                System.out.println("Refresh Error"+ex2);
            }*/
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /* Categories Data*/
        
        JLabel catoLabel=new JLabel("Manage Categories");
        catoLabel.setBounds(450, 20, 1000, 55);
        catoLabel.setFont(new Font("Courier", Font.BOLD,20));
        
        
        JLabel catoidLabel=new JLabel("Category ID");
        catoidLabel.setBounds(200,100,100,25);
        
        catoidText=new JTextField();
        catoidText.setBounds(300, 100, 150, 25);
        
        JLabel catonameLabel=new JLabel("Category Name");
        catonameLabel.setBounds(550, 100, 100, 25);
        
        catoText=new JTextField();
        catoText.setBounds(650, 100, 150, 25);
        
        
        
        JLabel descLabel=new JLabel("Description");
        descLabel.setBounds(200,150,100,25);
        
        descText=new JTextArea();
        descText.setBounds(300,150,200,40);
        
        
        
        JButton addcat=new JButton("ADD");
        addcat.setBounds(207,250,100,25);
        
        JButton editcat=new JButton("EDIT");
        editcat.setBounds(327,250,100,25);
        
        JButton deletecat=new JButton("DELETE");
        deletecat.setBounds(447,250,100,25);
        
        
        JButton clrcat=new JButton("CLEAR");
        clrcat.setBounds(567,250,100,25);
        
        
        refreshButtoncat=new JButton("REFRESH");
        refreshButtoncat.setBounds(687, 250, 100, 25);
        
        
        //Logout Button
        JButton logoutcat=new JButton("Logout");
        logoutcat.setBounds(925,20,100,25);
        
        
        tbmodel1=new DefaultTableModel();
        JTable catoTable=new JTable(tbmodel1);
        catoTable.setCellSelectionEnabled(true);
        catoTable.setPreferredScrollableViewportSize(new Dimension(850,100));
        tbmodel1.addColumn("Category ID");
        tbmodel1.addColumn("Category Name");
        tbmodel1.addColumn("Description");
        
        JScrollPane sp1=new JScrollPane(catoTable);
        sp1.setBounds(200, 300, 600, 350);
        cato.add(sp1);
        
      
        
        
        
        //category tab adding elements
        cato.add(catoLabel);
        cato.add(catoidLabel);
        cato.add(catoidText);
        cato.add(catonameLabel);
        cato.add(catoText);
        cato.add(descLabel);
        cato.add(descText);
        cato.add(addcat);
        cato.add(editcat);
        cato.add(deletecat);
        cato.add(clrcat);
        cato.add(refreshButtoncat);
        cato.add(logoutcat);
        
        refreshCat();
        catidTextField();
        
        
        
        addcat.addActionListener(e->{
            if(catoText.getText()!=""&&catoidText.getText()!=""){
                String query="insert into Categories_Data(Category_Name,Catagory_Desc)values"
                    + "('"+catoText.getText()+"','"+descText.getText()+"')";
                SqlExecute(query);
                refreshCat();
                clrText(2);
                
            }
            
        });
     
        
        
        
        catoTable.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                int i=catoTable.getSelectedRow();
                TableModel model1=catoTable.getModel();
                catoidText.setText(model1.getValueAt(i, 0).toString());
                catoText.setText(model1.getValueAt(i, 1).toString());
                descText.setText(model1.getValueAt(i,2).toString());
            }
        });
        
        
        editcat.addActionListener(e->{
            tbmodel1.setRowCount(0);
            String query="update Categories_Data set CatID='"+catoidText.getText()+"',Category_Name='"+catoText.getText()+"',"
                    + "Catagory_Desc='"+descText.getText()+"' where catID='"+catoidText.getText()+"'";
            
            SqlExecute(query);
            refreshCat();
            clrText(2);
            catidTextField();
        });
        
        
        deletecat.addActionListener(e->{
            tbmodel1.setRowCount(0);
            String query="delete from Categories_Data where catID='"+catoidText.getText()+"'";
            SqlExecute(query);
            refreshCat();
            clrText(2);
            catidTextField();
        });
        
        clrcat.addActionListener(e->{
            clrText(2);
            catidTextField();
        });
        
        refreshButtoncat.addActionListener(e->{
            refreshCat();
        });
        
        logoutcat.addActionListener(e->{
            dispose();
        });
        
        
        
        
        
        
        
        
        
        
        
        //Sellers Data
        
        
        
        
        
        
        JLabel sellLabel=new JLabel("Sellers");
        sellLabel.setBounds(450, 20, 1000, 55);
        sellLabel.setFont(new Font("Courier", Font.BOLD,20));
        
        /*TextFields*/
        JLabel sellidLabel=new JLabel("Name");
        sellidLabel.setBounds(200,100,100,25);
        
        sellnameText=new JTextField();
        sellnameText.setBounds(300, 100, 150, 25);
        
        JLabel passLabel=new JLabel("Password");
        passLabel.setBounds(550, 100, 100, 25);
        
        sellpassText=new JPasswordField();
        sellpassText.setBounds(650, 100, 150, 25);
        
        
        JLabel sellemailLabel=new JLabel("Email");
        sellemailLabel.setBounds(200,150,100,25);
        
        sellemailText=new JTextField();
        sellemailText.setBounds(300,150,300,25);
        
        
        JLabel genderLabel=new JLabel("Gender");
        genderLabel.setBounds(200,200,100,25);
        
        
        String combodata[]={"Male","Female"};
        gender=new JComboBox(combodata);
        gender.setSelectedIndex(0);
        gender.setBounds(300,200,150,25);
        
        
        JLabel idLabel=new JLabel("ID");
        idLabel.setBounds(500,200,50,25);
        
        idText=new JTextField();
        idText.setBounds(525,200,100,25);
        
        JButton addsell=new JButton("ADD");
        addsell.setBounds(207,250,100,25);
        
        JButton editsell=new JButton("EDIT");
        editsell.setBounds(327,250,100,25);
        
        JButton deletesell=new JButton("DELETE");
        deletesell.setBounds(447,250,100,25);
        
        JButton clrsell=new JButton("CLEAR");
        clrsell.setBounds(567,250,100,25);
        
        JButton logoutsell=new JButton("Logout");
        logoutsell.setBounds(925,20,100,25);
        
        sellrefreshButton=new JButton("REFRESH");
        sellrefreshButton.setBounds(687, 250, 100, 25);
        
        
        
        tbmodel2=new DefaultTableModel();
        JTable sellerTable=new JTable(tbmodel2);
        sellerTable.setPreferredScrollableViewportSize(new Dimension(850,100));
        sellerTable.setCellSelectionEnabled(true);
        tbmodel2.addColumn("ID");
        tbmodel2.addColumn("Name");
        tbmodel2.addColumn("Email");
        tbmodel2.addColumn("Password");
        tbmodel2.addColumn("Gender");
        
        JScrollPane sp3=new JScrollPane(sellerTable);
        sp3.setBounds(200, 300, 600, 350);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        sellers.add(sellLabel);
        sellers.add(sellidLabel);
        sellers.add(sellnameText);
        sellers.add(passLabel);
        sellers.add(sellpassText);
        sellers.add(sellemailLabel);
        sellers.add(sellemailText);
        sellers.add(gender);
        sellers.add(genderLabel);
        //sellers.add(idLabel);
        //sellers.add(idText);
        sellers.add(addsell);
        sellers.add(editsell);
        sellers.add(deletesell);
        sellers.add(logoutsell);
        sellers.add(clrsell);
        sellers.add(sellrefreshButton);
        sellers.add(sp3);
        
        
        refreshsell();
        
        addsell.addActionListener(e->{
            if(sellnameText.getText()!=""){
                //String genderSelection=gender.getSelectedItem().toString();
                String query="insert into SuperMarket_Credentials(Name,Email,Password,Gender,Type)values("
                        + "'"+sellnameText.getText()+"','"+sellemailText.getText()+"','"+sellpassText.getText()+"','"+gender.getSelectedItem().toString()+"','Seller')";
                SqlExecute(query);
                refreshsell();
                
            }
            else{
                System.out.println("fail");
            }
        });
        
        sellrefreshButton.addActionListener(e->{
            refreshsell();
        });
        
        
        sellerTable.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                int i=sellerTable.getSelectedRow();
                TableModel model2=sellerTable.getModel();
                idText.setText(model2.getValueAt(i, 0).toString());
                sellnameText.setText(model2.getValueAt(i, 1).toString());
                sellemailText.setText(model2.getValueAt(i, 2).toString());
                sellpassText.setText(model2.getValueAt(i, 3).toString());
                gender.setSelectedItem(model2.getValueAt(i, 4));
            }
        });
        editsell.addActionListener(e->{
            tbmodel2.setRowCount(0);
            String query="update SuperMarket_Credentials set Name='"+sellnameText.getText()+"',Email='"+sellemailText.getText()+"'"
                    + ",Password='"+sellpassText.getText()+"',gender='"+gender.getSelectedItem()+"' "
                    + "where ID='"+idText.getText()+"'";
            System.out.println(id);
            SqlExecute(query);
            refreshsell();
            clrText(3);
            
            
        });
        
        
        
        
        
        deletesell.addActionListener(e->{
            String query="delete from SuperMarket_Credentials where ID='"+idText.getText()+"'";
            SqlExecute(query);
            refreshsell();
            clrText(3);
        });
        
        
        clrsell.addActionListener(e->{
            clrText(3);
        });
        
        sellrefreshButton.addActionListener(e->{
            refreshsell();
        });
        
        
        sellrefreshButton.addActionListener(e->{
            refreshsell();
        });
        
        
        logoutsell.addActionListener(e->{
            dispose();
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        tp.addTab("Products",prod);
        tp.addTab("Catagories",cato);
        tp.addTab("Sellers", sellers);
        tp.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(tp);
        prod.setLayout(null);
        cato.setLayout(null);
        sellers.setLayout(null);
        setSize(1200,750);
        setVisible(true);
        setTitle("Admin");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    
    /////Main class End
    
    
    
    
    public void refresh(){
        tbmodel.setRowCount(0);
        clrText(1);
        try{
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
                Statement stmt=con.createStatement();
                String query="select * from Product_Data";
                
                ResultSet rs=stmt.executeQuery(query);
                while(rs.next()){
                    String pid=String.valueOf(rs.getInt("prodId"));
                    String pname=String.valueOf(rs.getString("prodName"));
                    String pqty=String.valueOf(rs.getInt("prodQty"));
                    String price=String.valueOf(rs.getInt("prodPrice"));
                    String catname=String.valueOf(rs.getString("Category_Name"));
                    String tbdata[]={pid,pname,pqty,price,catname};
                    tbmodel.addRow(tbdata);
                }
                idTextField();
                stmt.close();
                con.close();
            }
            catch(Exception ex2){
                System.out.println("Refresh Error"+ex2);
            }
    }
    public void idTextField(){
        try{
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
                Statement stmt=con.createStatement();
                //String query="SELECT prodID FROM Product_Data ORDER BY prodID DESC LIMIT 1;";
                
                ResultSet rs=stmt.executeQuery("SELECT prodID FROM Product_Data ORDER BY prodID DESC LIMIT 1;");
                
                while(rs.next()){
                    //int val=Integer.parseInt(rs.getString(1))+1;
                    //prodidText.setText(String.valueOf(val));
                    prodidText.setText(String.valueOf(Integer.parseInt(rs.getString(1))+1));
                }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
    }
    
    public void clrText(int i){
        if(i==1){
            nameText.setText("");
            qtyText.setText("");
            priceText.setText("");
            catText.setText("");
            idTextField();
        }
        else if(i==2){
            catoidText.setText("");
            catoText.setText("");
            descText.setText("");
            catidTextField();
            
        }
        else{
            sellnameText.setText("");
            sellemailText.setText("");
            sellpassText.setText("");
            gender.setSelectedIndex(0);
            
            
        }
        
        
    }
    
    
    
    public void SqlExecute(String query){
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
            Statement stmt=con.createStatement();
            stmt.executeUpdate(query);
        }
        catch(Exception ex3){
            System.out.println(ex3);
        }
    }
    public void refreshCat(){
        tbmodel1.setRowCount(0);
        clrText(2);
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
            Statement stmt=con.createStatement();
            String query="select * from Categories_Data";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                String pid=String.valueOf(rs.getInt("CatID"));
                String catname=String.valueOf(rs.getString("Category_Name"));
                String desc=String.valueOf(rs.getString("Catagory_Desc"));
                String tbdata[]={pid,catname,desc};
                tbmodel1.addRow(tbdata);
                
            }
            
            stmt.close();
            con.close();
        }
        catch(Exception ex){
            
        }
    }
    public void catidTextField(){
        try{
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
                Statement stmt=con.createStatement();
                //String query="SELECT prodID FROM Product_Data ORDER BY prodID DESC LIMIT 1;";
                
                ResultSet rs=stmt.executeQuery("SELECT catID FROM Categories_Data ORDER BY catID DESC LIMIT 1;");
                
                while(rs.next()){
                    //int val=Integer.parseInt(rs.getString(1))+1;
                    //prodidText.setText(String.valueOf(val));
                    catoidText.setText(String.valueOf(Integer.parseInt(rs.getString(1))+1));
                }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
    }
    
    
    
    
    
    
    public void refreshsell(){
        clrText(3);
        tbmodel2.setRowCount(0);
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
            Statement stmt=con.createStatement();
            String query="select * from SuperMarket_Credentials";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                String sid=String.valueOf(rs.getInt("ID"));
                String name=String.valueOf(rs.getString("Name"));
                String email=String.valueOf(rs.getString("Email"));
                String pass=String.valueOf(rs.getString("Password"));
                String gender=String.valueOf(rs.getString("Gender"));
                String tbdata[]={sid,name,email,pass,gender};
                tbmodel2.addRow(tbdata);
                
            }
            
            stmt.close();
            con.close();
        }
        catch(Exception ex){
            System.out.println(ex);
            
        }
    }
}
