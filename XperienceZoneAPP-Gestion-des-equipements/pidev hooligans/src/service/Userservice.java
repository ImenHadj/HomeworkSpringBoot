/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interface.CrudInterface;
import classes.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.MYDB;

/**
 *
 * @author ASUS
 */

    public class Userservice implements CrudInterface<User> {
    private Connection con;

    public Userservice() {
        con = MYDB.getinstance().getCon();
    }

    @Override
    public User readById(int id) {
        User user = null;
        String query = "SELECT * FROM utilisateur WHERE id_user = ?";
        
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                user = new User();
                user.setId_user(rs.getInt("id_user"));
                user.setUsername(rs.getString("nom_user"));
                user.setMail(rs.getString("email_user"));
                // Vous pouvez ajouter d'autres attributs de l'utilisateur ici.
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return user;
    }

    @Override
    public void ajout(User p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(User p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    void getId_user() {
        
    }

    @Override
    public ArrayList<User> chercher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public ArrayList<User> afficher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> sortBy(String nom_column, String Asc_Dsc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
