package heh.be.projet_tri.domain.port.in;

import java.util.List;

import heh.be.projet_tri.domain.model.Car;

public interface CarPortIn {
    public List<Car> getCarList();
    public void addCar(Car car);
    public void deleteCar(Long id);
    void updateCar(Car car);

    Car selectId(Long id);
}
