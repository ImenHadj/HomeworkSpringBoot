package entity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "Etudiant")
public class Etudiant  {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
     Long idEtudiant; // Clé primaire
     String nomEt;
     String prenomEt;
     Long cin;
    String ecole;
    @Temporal(TemporalType.DATE)
     Date dateNaissance;

    public Etudiant(String nomEt) {
        this.nomEt = nomEt;
    }

    public Etudiant() {

    }
}

