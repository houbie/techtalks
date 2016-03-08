package be.ixor.techtalks.springboot.display

import be.ixor.techtalks.springboot.Display
import be.ixor.techtalks.springboot.ParkingState
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

import static be.ixor.techtalks.springboot.ParkingState.FREE
import static be.ixor.techtalks.springboot.ParkingState.FULL

@Component
@Slf4j
class LEDDisplay implements Display {
    @Override
    void setParkingState(ParkingState state) {
        println "new state for LEDDisplay: $state"
        toggleLEDs(state)
    }

    void toggleLEDs(ParkingState state) {
        execute("echo ${state == FULL ? 0 : 1} > /sys/class/gpio/gpio408/value")
        execute("echo ${state == FREE ? 0 : 1} > /sys/class/gpio/gpio415/value")
    }

    @PostConstruct
    void initGPIO() {
        log.info('initGPIO')
        execute('echo 408 > /sys/class/gpio/export')
        execute('echo out > /sys/class/gpio/gpio408/direction')
        execute('echo 415 > /sys/class/gpio/export')
        execute('echo out > /sys/class/gpio/gpio415/direction')
        execute("echo 1 > /sys/class/gpio/gpio408/value")
        execute("echo 0 > /sys/class/gpio/gpio415/value")
    }

    private String execute(String command) {
        new ProcessBuilder().command(['bash', '-c', command]).start().text
    }
}
