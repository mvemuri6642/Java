/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.ration_management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/**
 *
 * @author Manohar Vemuri
 */
public class addAccount {
    public static void main(String args[]){
        new addAccount_();
    }
    
}



class addAccount_ extends JFrame{
    JTextField idText;
    JTextField nameText;
    JTextField aadhaarText;
    JTextField phText;
    JTextField divText;
    JTextField dnoText;
    JTextField vilText;
    JTextField mandalText;
    public addAccount_(){
        
        
        
        JPanel p1=new JPanel();
        
        JLabel viewLabel=new JLabel("New Account");
        viewLabel.setBounds(350,25,200,30);
        viewLabel.setFont(new Font("Courier",Font.BOLD,25));
        
        
        
        
        JLabel idLabel=new JLabel("Ration ID");
        idLabel.setBounds(100,100,150,25);
        
        idText=new JTextField();
        idText.setBounds(200,100,150,25);
        
        JLabel nameLabel=new JLabel("Name");
        nameLabel.setBounds(100,150,150,25);
        
        nameText=new JTextField();
        nameText.setBounds(200,150,150,25);
        /*
        nameText.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                nameText.setText("");
            }
            public void focusLost(FocusEvent e){
                nameText.setText("Head of the Family");
                
            }
        });
*/
        nameText.setToolTipText("Head of Family");
        
        
        
        JLabel aadhaarLabel=new JLabel("Aadhaar");
        aadhaarLabel.setBounds(100,200,150,25);
        
        aadhaarText=new JTextField();
        aadhaarText.setBounds(200,200,150,25);
        aadhaarText.setToolTipText("Family Head Aadhaar");
        
        
        JLabel phLabel=new JLabel("Contact no");
        phLabel.setBounds(100,250,150,25);
        
        phText=new JTextField();
        phText.setBounds(200,250,150,25);
        
        
        
        
        JLabel dnoLabel=new JLabel("Door no");
        dnoLabel.setBounds(450,100,150,25);
        
        dnoText=new JTextField();
        dnoText.setBounds(550,100,150,25);
        
        
        JLabel divLabel=new JLabel("Division no");
        divLabel.setBounds(450,150,150,25);
        
        divText=new JTextField();
        divText.setBounds(550,150,150,25);
        divText.setEditable(false);
        
        JLabel vilLabel=new JLabel("Village");
        vilLabel.setBounds(450,150,150,25);
        
        vilText=new JTextField();
        vilText.setBounds(550,150,150,25);
        
        
        JLabel mandalLabel=new JLabel("Mandal");
        mandalLabel.setBounds(450,200,150,25);
        
        mandalText=new JTextField();
        mandalText.setBounds(550,200,150,25);
        
        
        
        
        JButton back=new JButton("Back");
        back.setBounds(200,350,75,25);
        
        
        JButton add=new JButton("Add");
        add.setBounds(625,350,75,25);
        
        
        JButton logout=new JButton("Logout");
        logout.setBounds(1050,25,75,25);
        
        
        
        
        add.addActionListener(e->{
            try{
                    System.out.println(nameText.getText());
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
                    Statement stmt=con.createStatement();
                    String st="insert into account(name,aadhaar,contact,door_no,village,mandal,division,status)values"
                            + "('"+nameText.getText()+"','"+aadhaarText.getText()+"','"+phText.getText()+"','"+dnoText.getText()+"','"+vilText.getText()+"',"
                            + "'"+mandalText.getText()+"','"+login.d+"','N')";
                    stmt.executeUpdate(st);
                    JOptionPane.showMessageDialog(null, "Added Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Success");
                    idText.setText("");
                    nameText.setText("");
                    aadhaarText.setText("");
                    phText.setText("");
                    divText.setText("");
                    dnoText.setText("");
                    vilText.setText("");
                    mandalText.setText("");
                }
                catch(Exception e2){
                    System.out.println(e2);
                }
        });
        
        back.addActionListener(e->{
            new officer_();
            dispose();
        });
        
        logout.addActionListener(e->{
            new login();
            dispose();
        });
        
        
        
        
        
        p1.add(viewLabel);
        p1.add(idLabel);
        p1.add(idText);
        p1.add(nameLabel);
        p1.add(nameText);
        p1.add(aadhaarLabel);
        p1.add(aadhaarText);
        p1.add(phLabel);
        p1.add(phText);
        p1.add(dnoLabel);
        p1.add(dnoText);
        p1.add(vilLabel);
        p1.add(vilText);
        p1.add(mandalLabel);
        p1.add(mandalText);
        p1.add(add);
        p1.add(back);
        p1.add(logout);
        add(p1);
        p1.setLayout(null);
        setVisible(true);
        setSize(1200,750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}