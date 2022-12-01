package heh.be.projet_tri.ports.in;

import java.util.List;

import heh.be.projet_tri.domain.model.Car;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import heh.be.projet_tri.domain.port.out.*;
import heh.be.projet_tri.domain.port.in.*;

@RequiredArgsConstructor
public class CarListUseCase implements CarPortIn {
    @Getter
    private final CarPortOut carPortOut;

    @Override
    public List<Car> getCarList(){
        return getCarPortOut().getCarList();
    }


    @Override
    public void addCar(Car car) {

        List<Car> cars = carPortOut.getCarList();
        boolean bool = true;
        for(Car pr : cars){
            if(pr.getMarque().equals(car.getMarque())){
                bool=false;
            }
        }
        if(bool){
            carPortOut.addCar(car);
        }
    }

    @Override
    public void updateCar(Car car){
        carPortOut.updateCar(car);
    }

    @Override
    public void deleteCar(Long id){
        carPortOut.deleteCar(id);
    }

    @Override
    public Car selectId(Long id) {
        return carPortOut.selectId(id);
    }
}
