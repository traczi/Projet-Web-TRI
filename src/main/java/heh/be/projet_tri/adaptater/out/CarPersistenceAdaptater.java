package heh.be.projet_tri.adaptater.out;

import java.util.List;

import heh.be.projet_tri.model.Car;
import heh.be.projet_tri.ports.in.CarListUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CarPersistenceAdaptater implements CarListUseCase {


    private final CarRepository carRepository;
    private List<Car> cars;
    private final CarMapper carMapper;
    @Override
    public List<Car> getCarList() {

        List<CarJpaEntity> carEntity = carRepository.findAll();
        return carMapper.mapTodomainEntity(carEntity);
    }

}