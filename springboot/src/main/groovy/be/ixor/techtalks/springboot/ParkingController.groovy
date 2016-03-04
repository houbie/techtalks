package be.ixor.techtalks.springboot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class ParkingController {
    @Autowired
    ParkingService parkingService

    @RequestMapping("/")
    public String greeting(
            @RequestParam(value = "parkingState", required = false) ParkingState parkingState, Model model) {
        if (parkingState) {
            parkingService.parkingState = parkingState
        }
        model.addAttribute('parkingState', parkingService.parkingState);
        model.addAttribute('displays', parkingService.displays);
        return 'parking';
    }
}
