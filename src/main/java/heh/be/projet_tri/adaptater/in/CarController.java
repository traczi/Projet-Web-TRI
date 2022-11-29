package heh.be.projet_tri.adaptater.in;
import heh.be.projet_tri.model.Car;
import heh.be.projet_tri.ports.in.CarListUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CarController {

    private final CarListUseCase carListUseCase;
    private List<Car> cars;

    @GetMapping("/")
    public String carList(Model model){
        cars = carListUseCase.getCarList();
        model.addAttribute("cars",cars);
        return "carList";
    }
}