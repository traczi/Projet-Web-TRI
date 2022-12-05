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


    //Méthode pour récupérer la liste des voitures

    @Override
    public List<Car> getCarList() {

        List<CarJpaEntity> carJpaEntityList = carRepository.findAll();
        return carMapper.CarMapJpaToDomain(carJpaEntityList);
    }


    //Méthode pour récupérer la liste des voitures pa rapport à l'id

    @Override
    public List<Car> getCarListById(List<Integer> list) {
        return null;
    }


    //Méthode pour ajouter une voiture

    @Override
    public void addCar(Car car) {
        carRepository.save(carMapper.CarMapDomainToJpa(car));
    }


    //Méthode pour modifier une voiture

    @Override
    public void updateCar(Car car){
        CarJpaEntity carJpaEntity = carRepository.findById(car.getId()).get();
        if(carJpaEntity.equals(null)){
            
        }
        else{
            carJpaEntity.setIdCar(car.getId());
            carJpaEntity.setMarque(car.getMarque());
            carJpaEntity.setModel(car.getModel());
            carJpaEntity.setAnnee(car.getAnnee());

            carRepository.save(carJpaEntity);
        }
    }


    //Méthode pour supprimer une voiture

    @Override
    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }


    //Selected id
    
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