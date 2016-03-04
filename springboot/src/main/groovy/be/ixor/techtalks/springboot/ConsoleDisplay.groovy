package be.ixor.techtalks.springboot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

@Component
class ConsoleDisplay implements Display {
    @Autowired
    ParkingService parkingService

    @Override
    void setParkingState(ParkingState state) {
        println "new state for console display: $state"
    }

    @PostConstruct
    void register() {
        parkingService.registerDisplay(this)
    }
}
