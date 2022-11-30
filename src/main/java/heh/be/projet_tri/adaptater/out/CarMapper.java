package heh.be.projet_tri.adaptater.out;

import java.util.ArrayList;
import java.util.List;

import heh.be.projet_tri.domain.model.Car;


public class CarMapper {

    List<Car> CarMapJpaToDomain(List<CarJpaEntity> cars){
        List<Car> carsList = new ArrayList<>();

        for (CarJpaEntity carJpaEntity: cars) {
            carsList.add(new Car(carJpaEntity.getIdCar(), carJpaEntity.getMarque(), carJpaEntity.getModel(), carJpaEntity.getAnnee()));
        }
        return carsList;
    }

    public CarJpaEntity CarMapDomainToJpa(Car car){
        return new CarJpaEntity(car.getId(), car.getMarque(), car.getModel(), car.getAnnee());
    }
    public Car CarMapJpaToDomain(CarJpaEntity carJpaEntity){
        return new Car(carJpaEntity.getIdCar(), carJpaEntity.getMarque(), carJpaEntity.getModel(), carJpaEntity.getAnnee());
    }
}
