/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interface.CrudInterface;
import classes.Produit;
import classes.User;
import classes.panier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MYDB;

/**
 *
 * @author ASUS
 */
public class PanierService implements CrudInterface<panier> {
        Connection con;
        Statement ste;

   public PanierService() {
       con = MYDB.getinstance().getCon(); 
    
    
   }

    /**
     *
     * @param panier
     * @param produit
     */
   
   

   

   

    
 

  public void ajout(panier P, Produit p, User u) {
    try {
        // Utilisez une requête SQL pour obtenir le prix du produit à partir de la table "Produit"
        String prixProduitQuery = "SELECT prix_prod FROM Produit WHERE id_prod = ?";
        PreparedStatement prixProduitStatement = con.prepareStatement(prixProduitQuery);
        prixProduitStatement.setInt(1, p.getId_prod());
        ResultSet prixProduitResult = prixProduitStatement.executeQuery();

        double prixProduit = 0.0;

        // Vérifiez si le résultat de la requête contient un prix
        if (prixProduitResult.next()) {
            prixProduit = prixProduitResult.getDouble("prix_prod");
        } else {
            System.out.println("Le produit avec l'ID spécifié n'existe pas.");
            return; // Sortez de la méthode si le produit n'existe pas
        }

        // Calculez le total en multipliant le prix du produit par la quantité du panier
        double total = prixProduit * P.getQuantite_panier();

        // Insérez les données dans la table "panier"
        String req = "INSERT INTO panier (id_user, total, id_prod, quantite_panier) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(req);
        ps.setInt(1, u.getId_user());
        ps.setDouble(2, total);
        ps.setInt(3, p.getId_prod());
        ps.setInt(4, P.getQuantite_panier());
        ps.executeUpdate();

        System.out.println("Panier ajouté avec succès !");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }}
     @Override
    public void supprimer(int id) {
 
         try {
             String req = "Delete FROM `panier` WHERE id_panier ='"+id+"';" ;

             Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
              st.executeUpdate(req);
              System.out.println("Panier  supprimé avec succes");
          } catch (SQLException ex) {
          }}
    
  public double totalmontantPanier(int id_user) {
    Double somme = 0.0;
    try {
        String sql = "SELECT SUM(total) AS total FROM panier WHERE id_user = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id_user);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            somme = rs.getDouble("total");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return somme;}

   
    /*public void afficher(int id_user) {
    try {
        // Sélectionnez les produits du panier de l'utilisateur par son ID
        String selectPanierQuery = "SELECT P.id_prod, P.nom_prod, P.prix_prod, P.description_prod, P.quantite, P.image " +
                                   "FROM panier AS PA " +
                                   "INNER JOIN produit AS P ON PA.id_prod = P.id_prod " +
                                   "WHERE PA.id_user = ?";
        
        PreparedStatement preparedStatement = con.prepareStatement(selectPanierQuery);
        preparedStatement.setInt(1, id_user);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        
        if (!resultSet.isBeforeFirst()) {
            System.out.println("Le panier de l'utilisateur est vide.");
        } else {
            System.out.println("Contenu du panier pour l'utilisateur avec ID " + id_user + ":");
            while (resultSet.next()) {
                int idProduit = resultSet.getInt("id_prod");
                String nomProduit = resultSet.getString("nom_prod");
                double prixProduit = resultSet.getDouble("prix_prod");
                String descriptionProduit = resultSet.getString("description_prod");
                int quantite = resultSet.getInt("quantite");
                String image = resultSet.getString("image");
                
                // Affichez les détails du produit
                System.out.println("ID du produit : " + idProduit);
                System.out.println("Nom du produit : " + nomProduit);
                System.out.println("Prix du produit : " + prixProduit);
                System.out.println("Description du produit : " + descriptionProduit);
                System.out.println("Quantité : " + quantite);
                System.out.println("Image : " + image);
                System.out.println("------------------------------");
            }
        }
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la récupération du panier : " + ex.getMessage());
    }*/
  public void afficher(int idUtilisateur) {
    try {
        // Sélectionnez le panier de l'utilisateur par son ID
        String selectPanierQuery = "SELECT * FROM panier WHERE id_user = ?";
        PreparedStatement preparedStatement = con.prepareStatement(selectPanierQuery);
        preparedStatement.setInt(1, idUtilisateur);
        ResultSet panierResultSet = preparedStatement.executeQuery();

        if (!panierResultSet.isBeforeFirst()) {
            System.out.println("Le panier de l'utilisateur est vide.");
        } else {
            while (panierResultSet.next()) {
                int idProduitDansPanier = panierResultSet.getInt("id_prod");
                int quantitePanier = panierResultSet.getInt("quantite_panier");
                double totalPanier = panierResultSet.getDouble("total");
                
                // Vous pouvez récupérer d'autres informations du panier si nécessaire
                
                // Maintenant, sélectionnez le nom du produit en utilisant l'ID du produit
                String selectProduitQuery = "SELECT nom_prod FROM Produit WHERE id_prod = ?";
                PreparedStatement produitStatement = con.prepareStatement(selectProduitQuery);
                produitStatement.setInt(1, idProduitDansPanier);
                ResultSet produitResultSet = produitStatement.executeQuery();

                if (produitResultSet.next()) {
                    String nomProduit = produitResultSet.getString("nom_prod");
                    
                    // Affichez le nom du produit et d'autres informations du panier si nécessaire
                    System.out.println("Nom du produit : " + nomProduit);
                    System.out.println("Quantité dans le panier : " + quantitePanier);
                    System.out.println("Total du panier : " + totalPanier);
                    System.out.println();
                }
            }
        }
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la récupération du panier : " + ex.getMessage());
   }}




   





  






   

    @Override
    public void ajout(panier p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public void modifier(panier p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<panier> afficher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public panier readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<panier> chercher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<panier> sortBy(String nom_column, String Asc_Dsc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }}

       
    
    
 


    
  




    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
   
  
   




     
   
    /*@Override
    public panier readById(int id) {
        panier p = new panier();
         Userservice us =new Userservice() ;
        try {
            
       String req="SELECT * FROM panier WHERE `id_panier`='"+id+"'";
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(req);
            rs.beforeFirst();
            rs.next();
            
                p.setId_panier(rs.getInt(1));
                p.setUtilisateur(us.readById(rs.getInt(2)));           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return  p;
    }
    

    }
   
   

   
    
    }
*/
  