package heh.be.projet_tri.adaptater.out;

import heh.be.projet_tri.model.Car;

import java.util.ArrayList;
import java.util.List;


public class CarMapper {

    List<Car> mapTodomainEntity(List<CarJpaEntity> cars){
        List<Car> carsList = new ArrayList<>();

        for (CarJpaEntity carJpaEntity: cars) {
            carsList.add(new Car(CarJpaEntity.getMarque(),CarJpaEntity.getModel(),CarJpaEntity.getAnnee()));
        }
        return carsList;
    }
}
