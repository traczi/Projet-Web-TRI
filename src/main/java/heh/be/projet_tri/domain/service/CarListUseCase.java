package heh.be.projet_tri.domain.service;

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


    //Méthode pour récupérer la liste des voitures

    @Override
    public List<Car> getCarList(){
        return getCarPortOut().getCarList();
    }


    //Méthode pour ajouter une voiture

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


    //Méthode pour modifier une voiture

    @Override
    public void updateCar(Car car){
        carPortOut.updateCar(car);
    }


    //Méthode pour supprimer une voiture

    @Override
    public void deleteCar(Long id){
        carPortOut.deleteCar(id);
    }


    //SelectedId

    @Override
    public Car selectId(Long id) {
        return carPortOut.selectId(id);
    }
}
