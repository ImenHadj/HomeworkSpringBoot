/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.management.relation.Role;

/**
 *
 * @author ASUS
 */
public class User {
 private int id_user;
 private String username;
  private String mail;
  private String mdp;        
 private String image;
 private int  age;
 private String sexe;
 private Role role;

    public User(int id_user, String username, String mail, String mdp, String image, int age, String sexe, Role role) {
        this.id_user = id_user;
        this.username = username;
        this.mail = mail;
        this.mdp = mdp;
        this.image = image;
        this.age = age;
        this.sexe = sexe;
        this.role = role;}
        
        public User(int id_user, String username, String mail) {
        this.id_user = id_user;
        this.username = username;
        this.mail = mail;
    

    }

    public User() {
        
    }

   

    public User(String utilisateur_de_test, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
   
 
    
}

