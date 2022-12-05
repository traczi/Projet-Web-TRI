package heh.be.projet_tri.adaptater.controller;
import heh.be.projet_tri.domain.model.Car;
import heh.be.projet_tri.domain.model.NumberLong;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import heh.be.projet_tri.domain.port.in.CarPortIn;

import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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


    //Affichage des voitures

    @GetMapping("/")
    public String getCarList(Model model){
        setCarsList(getCarPortIn().getCarList());
        List<Long>longs = new ArrayList<>();
        for(Car cr:getCarsList()){
            longs.add(cr.getId());
        }
        Collections.sort(longs);
        getCarsList().clear();
        for(Long id:longs){
            Car newCr = carPortIn.selectId(id);
            getCarsList().add(newCr);
        }
        model.addAttribute("cars",getCarsList());
        return "carList";
    }

    
    //Affichage pour ajouter les voitures

    @GetMapping("/addCar")
    public String addCar(){
        return "addCar";
    }


    //Affichage pour modifier les voitures

    @GetMapping("/updateCar")
    public String updateCar(@CookieValue(value = "id", defaultValue = "0") String id , Model model){
        List<Car> cars = carPortIn.getCarList();
        List<Long> longs =new ArrayList<>();
        Car car = cars.get(0);
        for (Car cr :cars){
            if(cr.getId() !=Long.parseLong(id)){
                longs.add(cr.getId());
                System.out.println(id);
            }
            if (cr.getId().equals(Long.parseLong(id))){
                car= new Car(cr.getId(), cr.getMarque(), cr.getModel(), cr.getAnnee());
            }
        }
        Collections.sort(longs);
        model.addAttribute("Car",car);
        model.addAttribute("listNumber", longs);
        model.addAttribute("id", id);
        return "updateCarView";
    }


    //Méthode pour ajouter une voiture

    @PostMapping("/addCarForm")
    @ResponseBody
    public RedirectView addView(@ModelAttribute("addCar") Car car) throws Exception{
        Car car1 = new Car(Long.parseLong(car.getId().toString()),car.getMarque(),car.getModel(),car.getAnnee());
        carPortIn.addCar(car1);
        return new RedirectView("/");
    }


    //Méthode pour supprimer une voiture

    @PostMapping("/deleteCarForm")
    public RedirectView deleteCar(@ModelAttribute("carList") Car car){
        carPortIn.deleteCar(car.getId());
        return new RedirectView("/");
    }


    //SelectedId

    @PostMapping("/selectedId")
    @ResponseBody
    public RedirectView selectedId(@ModelAttribute("selectedId") NumberLong number, HttpServletResponse response) throws Exception{
        Cookie cookie = new Cookie("id", number.getNumber().toString());
        cookie.setSecure(true);
        response.addCookie(cookie);
        return new RedirectView ("/updateCar");
    }


    //Méthode pour modifier une voiture
    @PostMapping("/updateCarForm")
    @ResponseBody
    public RedirectView updateCarView(@ModelAttribute("carList") Car car, HttpServletResponse response) throws Exception{
        Car car1 = new Car(Long.parseLong(car.getId().toString()),car.getMarque(),car.getModel(),car.getAnnee());
        carPortIn.updateCar(car1);
        return new RedirectView("/updateCar");
    }
}