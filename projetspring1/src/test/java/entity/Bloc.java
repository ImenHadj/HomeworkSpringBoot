package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "Bloc")
public class Bloc {
    @Id

     Long idBloc;
    String nomBloc;
    Long capaciteBloc;
}
