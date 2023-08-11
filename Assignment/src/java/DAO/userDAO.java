/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DBContext.DBContext;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.userAccount;
/**
 *
 * @author ACER
 */
public class userDAO extends DBContext{
    public void insertUser(String username, String password, String email, Date dob,int phonenumber, String gender,int tid){
        try{
            if(connection != null){
                String sql = "Insert into User_Account (Username,Password,Email,DOB,Phonenumber,gender,TID) values (?,?,?,?,?,?,?)";
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, username);
                st.setString(2, password);
                st.setString(3, email);
                st.setDate(4, dob);
                st.setInt(5, phonenumber);
                st.setString(6, gender);
                st.setInt(7, tid);
                int row = st.executeUpdate();                
                st.close();
                connection.close();
        }
    }catch (Exception e){
            System.out.println(e.getMessage());
    }
    }
    public userAccount getAccount(String username, String password) {        
        try {
            String sql = "Select * from User_Account where Username = '" + username + "' and Password='" + password + "'";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                userAccount account = new userAccount();
                account.setUsername(rs.getString(1));
                account.setPassword(rs.getString(2));
                rs.close();
                st.close();
                connection.close();
                return account;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}