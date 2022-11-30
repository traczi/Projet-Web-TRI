package heh.be.projet_tri.domain.port.out;

import java.util.List;

import heh.be.projet_tri.domain.model.Car;

public interface CarPortOut {
    public List<Car> getCarList();

    public List<Car> getCarListById(List<Integer> list);

    public void addCar(Car car);
    public void deleteCar(Long id);

    public Car selectId(Long id);
}
