package heh.be.projet_tri.adaptater.out;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "cars")
public class CarJpaEntity {
    public CarJpaEntity(){

    }
    public CarJpaEntity(Long id, String marque, String model, Integer annee){
        this.idCar = id;
        this.marque = marque;
        this.model = model;
        this.annee = annee;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car")
    private Long idCar;

    @Column(name = "marque")
    private String marque;

    @Column(name = "model")
    private String model;

    @Column(name = "annee")
    private Integer annee;

}