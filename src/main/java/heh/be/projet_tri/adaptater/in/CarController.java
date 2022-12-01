package heh.be.projet_tri.adaptater.in;
import heh.be.projet_tri.domain.model.Car;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import heh.be.projet_tri.domain.port.in.CarPortIn;

import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    @GetMapping("/updateCar")
    public String updateCar(){
        return "updateCar";
    }
    @PostMapping("/addCarForm")
    @ResponseBody
    public RedirectView addView(@ModelAttribute("addCar") Car car) throws Exception{
        Car car1 = new Car(Long.parseLong(car.getId().toString()),car.getMarque(),car.getModel(),car.getAnnee());
        carPortIn.addCar(car1);
        return new RedirectView("/");
    }
    @PostMapping("/deleteCarForm")
    public RedirectView deleteCar(@ModelAttribute("carList") Car car){
        carPortIn.deleteCar(car.getId());
        return new RedirectView("/");
    }
    @PostMapping("/updateCarForm")
    public RedirectView updateCarView(@ModelAttribute("carList") Car car){
        Car car1 = new Car(Long.parseLong(car.getId().toString()),car.getMarque(),car.getModel(),car.getAnnee());
        carPortIn.updateCar(car1);
        return new RedirectView("/");
    }
}