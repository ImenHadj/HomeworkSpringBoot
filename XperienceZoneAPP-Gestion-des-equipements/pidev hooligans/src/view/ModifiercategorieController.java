/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import classes.Categorie;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.CategorieService;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifiercategorieController implements Initializable {

    @FXML
    private TextField modifnom;
    @FXML
    private TextField modifdesc;
    @FXML
    
    private ChoiceBox<String> modifierchoix;
private Categorie selectedCategorie;

    public void initializeData(Categorie categorie) {
    System.out.println("initializeData called with category: " + categorie);
    selectedCategorie = categorie;
    if (categorie != null) {
        // Remplissez les champs de formulaire ici
        modifnom.setText(categorie.getNom_categorie());
        modifdesc.setText(categorie.getDescription_categorie());
        modifierchoix.setValue(categorie.getType_categorie());
    }
}


    
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         modifierchoix.getItems().addAll("Choix 1", "Choix 2", "Choix 3");
    }    

    @FXML
    private void Modifiercat(ActionEvent event) throws SQLException  {
        if (selectedCategorie != null) {
        // Récupérez les valeurs modifiées à partir des champs de formulaire
        String nouveauNom = modifnom.getText();
        String nouvelleDescription = modifdesc.getText();
        String nouveauType = modifierchoix.getValue();

        // Mettez à jour les propriétés de selectedCategorie
        selectedCategorie.setNom_categorie(nouveauNom);
        selectedCategorie.setDescription_categorie(nouvelleDescription);
        selectedCategorie.setType_categorie(nouveauType);

        // Appelez votre service pour mettre à jour la catégorie dans la base de données
        CategorieService categorieService = new CategorieService();
        categorieService.modifier(selectedCategorie); // Gérez l'exception correctement, par exemple, affichez un message d'erreur

        // Fermez la fenêtre de modification
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}

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

   



    

