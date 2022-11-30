package heh.be.projet_tri.adaptater.out;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "cars")
public class CarJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_car")
    private Long idCar;

    @Column(name = "marque")
    private String marque;

    @Column(name = "model")
    private String model;

    @Column(name = "annee")
    private Integer annee;

}