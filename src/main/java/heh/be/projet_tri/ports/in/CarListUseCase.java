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
        carPortOut.addCar(car);
    }
}
