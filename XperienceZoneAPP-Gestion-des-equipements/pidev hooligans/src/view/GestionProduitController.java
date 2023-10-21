/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import classes.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.CategorieService;
import service.Produitservice;
import util.MYDB;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class GestionProduitController implements Initializable {

    @FXML
    private Button actualiser;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
     @FXML
    private Button chercher;
      @FXML
    private TextField  chercher_prod;
    @FXML
    private TableView<Produit> tableview;
    @FXML
    private TableColumn<Produit, Integer> idprod_col;
    @FXML
    private TableColumn<Produit, String> nomprod_col;
    @FXML
    private TableColumn<Produit, String> prixprod_col;
    @FXML
    private TableColumn<Produit, String> desprod_col;
    @FXML
    private TableColumn<Produit, Integer> quantiteprod_col;
    @FXML
    private TableColumn<Produit, String> imageprod_col;
    @FXML
    private TableColumn<Produit, Integer> idcateg_col;
    
     public GestionProduitController() {
        Connection con = MYDB.getinstance().getCon();
    }
    
 //public static int id_modif ;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
 
  @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialisation
      afficher();
    }
    @FXML
private void afficheraction(ActionEvent event)throws SQLException{
    afficher();
}
    
    @FXML   
private void afficher() {
    
    Produitservice produitService = new Produitservice();
    List<Produit> produits = produitService.affihcer();
    ObservableList<Produit> produitList = FXCollections.observableArrayList(produits);
    idprod_col.setCellValueFactory(new PropertyValueFactory<>("id_prod"));
    nomprod_col.setCellValueFactory(new PropertyValueFactory<>("nom_prod"));
    prixprod_col.setCellValueFactory(new PropertyValueFactory<>("prix_prod"));
    desprod_col.setCellValueFactory(new PropertyValueFactory<>("description"));
    quantiteprod_col.setCellValueFactory(new PropertyValueFactory<>("quantite produit"));
    imageprod_col.setCellValueFactory(new PropertyValueFactory<>("image"));
    idcateg_col.setCellValueFactory(new PropertyValueFactory<>("id categorie"));
    tableview.setItems(produitList);
}
      



    @FXML
    private void ajouterproduit(ActionEvent event) {
        try {
            Parent page1 = FXMLLoader.load(getClass().getResource("Ajouterproduit.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }}
    @FXML
private void supprimerLigne(ActionEvent event) {
    Produit produitSelectionne = tableview.getSelectionModel().getSelectedItem();

    if (produitSelectionne != null) {
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Confirmation de suppression");
        confirmation.setHeaderText("Êtes-vous sûr de vouloir supprimer cette ligne ?");
        confirmation.setContentText("Cliquez sur OK pour confirmer.");

        Optional<ButtonType> resultat = confirmation.showAndWait();
        if (resultat.isPresent() && resultat.get() == ButtonType.OK) {
            // L'utilisateur a confirmé la suppression
            // Supprimez d'abord la ligne de la base de données
            Produitservice produitservice = new Produitservice();
            produitservice.supprimer(produitSelectionne.getId_prod());

            // Ensuite, supprimez la ligne de la TableView
            tableview.getItems().remove(produitSelectionne);
        }
    } else {
        // Aucune ligne sélectionnée, affichez un message d'erreur ou informez l'utilisateur.
        Alert erreur = new Alert(Alert.AlertType.ERROR);
        erreur.setTitle("Aucune sélection");
        erreur.setHeaderText("Aucune ligne n'a été sélectionnée");
        erreur.setContentText("Veuillez sélectionner une ligne à supprimer.");
        erreur.showAndWait();
    }
}
@FXML
private void modifierProduit(ActionEvent event) throws SQLException {
    Produit produitSelectionne = tableview.getSelectionModel().getSelectedItem();

    if (produitSelectionne != null) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifier produit.fxml"));
            Parent root = loader.load();
            ModifierProduitController modifierController = loader.getController();
            modifierController.initializeData(produitSelectionne);

            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    } else {
        // Aucune ligne sélectionnée, affichez un message d'erreur ou informez l'utilisateur.
        showErrorAlert("Aucune ligne n'a été sélectionnée pour la modification.");
    }
}

    private void showErrorAlert(String aucune_ligne_na_été_sélectionnée_pour_la_) {
        
    }
    

@FXML
private void chercherProduits(ActionEvent event) throws SQLException {
    String colonne = "nom_prod";
    String valeur = chercher_prod.getText(); // La valeur saisie par l'utilisateur

    Produitservice produitService = new Produitservice();
    List<Produit> produitsCherches = produitService.chercher(colonne, valeur);

    ObservableList<Produit> produitsCherchesList = FXCollections.observableArrayList(produitsCherches);
    tableview.setItems(produitsCherchesList);}


   
@FXML
    private void Retour(ActionEvent event) {
    
    try {
    Parent root = FXMLLoader.load(getClass().getResource("Gestion categorie.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();} catch (IOException ex) {
            Logger.getLogger(GestionProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }}}







