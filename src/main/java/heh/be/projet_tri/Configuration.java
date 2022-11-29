package heh.be.projet_tri;

import heh.be.projet_tri.adaptater.out.CarMapper;
import heh.be.projet_tri.adaptater.out.CarPersistenceAdaptater;
import heh.be.projet_tri.adaptater.out.CarRepository;
import heh.be.projet_tri.ports.in.CarListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories
public class Configuration {
    @Autowired
    private CarRepository carRepository;

    private final CarMapper carMapper = new CarMapper();

    @Bean
    CarListUseCase getCarListUseCase(){
        return new CarPersistenceAdaptater(carRepository,carMapper);
    }
}
