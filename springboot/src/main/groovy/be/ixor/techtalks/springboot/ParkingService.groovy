package be.ixor.techtalks.springboot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static be.ixor.techtalks.springboot.ParkingState.FREE

@Service
class ParkingService {
    @Autowired
    List<Display> displays = []

    ParkingState parkingState = FREE

    void setParkingState(ParkingState parkingState) {
        this.parkingState = parkingState
        displays.each { it.parkingState = parkingState }
    }
}

enum ParkingState {
    FREE, FULL
}