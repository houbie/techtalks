package be.ixor.techtalks.springboot

import org.springframework.stereotype.Service

import static be.ixor.techtalks.springboot.ParkingState.FREE

@Service
class ParkingService {
    Set<Display> displays = []
    ParkingState parkingState = FREE

    void registerDisplay(Display display) {
        displays << display
    }

    void setParkingState(ParkingState parkingState) {
        this.parkingState = parkingState
        displays.each { it.parkingState = parkingState }
    }
}

enum ParkingState {
    FREE, FULL
}