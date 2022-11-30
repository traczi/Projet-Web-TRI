package heh.be.projet_tri.adaptater.out;

import java.util.List;

import heh.be.projet_tri.domain.model.Car;
import heh.be.projet_tri.domain.port.out.CarPortOut;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CarPersistenceAdaptater implements CarPortOut {


    private final CarRepository carRepository;
    private List<Car> cars;
    private final CarMapper carMapper;
    @Override
    public List<Car> getCarList() {

        List<CarJpaEntity> carJpaEntityList = carRepository.findAll();
        return carMapper.CarMapJpaToDomain(carJpaEntityList);
    }
    @Override
    public List<Car> getCarListById(List<Integer> list) {
        return null;
    }
    @Override
    public void addCar(Car car) {
        carRepository.save(carMapper.CarMapDomainToJpa(car));
    }

    @Override
    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }

    @Override
    public Car selectId(Long id) {
        CarJpaEntity carJpaEntity= carRepository.findById(id).get();
        if(carJpaEntity.equals(null)){
            return null;
        }else{
            return carMapper.CarMapJpaToDomain(carJpaEntity);
        }
    }
}