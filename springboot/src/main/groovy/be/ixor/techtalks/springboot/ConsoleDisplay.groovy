package be.ixor.techtalks.springboot

import org.springframework.stereotype.Component

@Component
class ConsoleDisplay implements Display {
    @Override
    void setParkingState(ParkingState state) {
        println "new state for console display: $state"
    }
}
