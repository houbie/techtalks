package be.ixor.techtalks.springboot.display

import be.ixor.techtalks.springboot.Display
import be.ixor.techtalks.springboot.ParkingState
import org.springframework.stereotype.Component

@Component
class FreeFullDisplay implements Display {
    @Override
    void setParkingState(ParkingState state) {
        println "new state for FreeFullDisplay: $state"
    }
}
