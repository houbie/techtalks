package be.ixor.techtalks.springboot.display

import be.ixor.techtalks.springboot.Display
import be.ixor.techtalks.springboot.ParkingService
import be.ixor.techtalks.springboot.ParkingState
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

@Component
class LEDDisplay implements Display {
    @Autowired
    ParkingService parkingService

    @Override
    void setParkingState(ParkingState state) {
        println "new state for LEDDisplay: $state"
    }

    @PostConstruct
    void register() {
        parkingService.registerDisplay(this)
    }
}
