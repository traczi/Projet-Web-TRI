package heh.be.projet_tri.adaptater.in;
import heh.be.projet_tri.domain.model.Car;
import heh.be.projet_tri.ports.in.CarListUseCase;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import heh.be.projet_tri.domain.port.in.CarPortIn;

import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequiredArgsConstructor
public class CarController {
    @Getter
    private final CarPortIn carPortIn;
    @Getter
    @Setter
    private List<Car> carsList;


    @GetMapping("/")
    public String getCarList(Model model){
        setCarsList(getCarPortIn().getCarList());
        List<Long>longs = new ArrayList<>();
        for(Car pr:getCarsList()){
            longs.add(pr.getId());
        }
        Collections.sort(longs);
        getCarsList().clear();
        for(Long id:longs){
            Car newPr = carPortIn.selectId(id);
            getCarsList().add(newPr);
        }
        model.addAttribute("cars",getCarsList());
        return "carList";
    }
    @GetMapping("/addCar")
    public String addCar(){
        return "addCar";
    }
    @PostMapping("/addCarForm")
    @ResponseBody
    public RedirectView addView(@ModelAttribute("addCar") Car car) throws Exception{
        Car car1 = new Car(Long.parseLong(car.getId().toString()),car.getMarque(),car.getModel(),car.getAnnee());
        System.out.println(car1.getId());
        carPortIn.addCar(car1);
        return new RedirectView("/");
    }
    @DeleteMapping("/deleteCar")
    @ResponseBody
    public RedirectView deleteView(@ModelAttribute("deleteCar") Long id){
        carPortIn.deleteCar(id);
        return new RedirectView("/");
    }
}