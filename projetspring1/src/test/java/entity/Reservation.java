package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table( name = "Reservation")
public class Reservation {
    @Id
    String idReservation;
    Date anneeUniversitaire;
    Boolean estValide;

}
