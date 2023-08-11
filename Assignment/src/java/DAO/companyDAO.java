/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBContext.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.companyAccount;

/**
 *
 * @author ACER
 */
public class companyDAO extends DBContext{
    public companyAccount getAccount(String username, String password) {        
        try {
            String sql = "Select * from Company_Account where Name = '" + username + "' and Password='" + password + "'";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                companyAccount account = new companyAccount();
                account.setName(rs.getString(1));
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
    public void insertCompany(String name, String password, String email, int tel, int cpid){
        try{
            if(connection != null){
                String sql = "Insert into Company_Account (Name,Password,Email,Tel,CPID) values (?,?,?,?,?)";
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, name);
                st.setString(2, password);
                st.setString(3, email);
                st.setInt(4, tel);
                st.setInt(5, cpid);
                int row = st.executeUpdate();                
                st.close();
                connection.close();
        }
    }catch (Exception e){
            System.out.println(e.getMessage());
    }
    }
}
