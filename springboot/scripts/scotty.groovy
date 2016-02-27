@Grab("org.grails:gorm-hibernate4-spring-boot:1.1.0.RELEASE")
@Grab("com.h2database:h2:1.4.191")
import grails.persistence.*
import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import java.time.LocalDate

import static org.springframework.web.bind.annotation.RequestMethod.*

@Entity
class Reservation {
    String beamer
    LocalDate start
    LocalDate end
}

@RestController
class ReservationController {

    @RequestMapping(value = "/reservations", method = GET)
    String list() {
        def json = new JsonBuilder()
        json(Reservation.list()) {
            id(it.id)
            beamer(it.beamer)
            start(it.start.toString())
            end(it.end.toString())
        }
        json.toString()
    }

    @RequestMapping(value = '/reservations', method = POST)
    ResponseEntity create(@RequestBody String body) {
        def json = new JsonSlurper().parseText(body)
        Reservation.withTransaction {
            def success = new Reservation(
                    beamer: json.beamer,
                    start: LocalDate.parse(json.start),
                    end: LocalDate.parse(json.end)
            ).save()
            return new ResponseEntity(success ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST)
        }
    }

    @RequestMapping(value = '/reservations/{id}', method = POST)
    ResponseEntity update(@RequestBody String body, @PathVariable long id) {
        def json = new JsonSlurper().parseText(body)
        Reservation.withTransaction {
            def reservation = Reservation.get(id)
            reservation.beamer = json.beamer
            reservation.start = LocalDate.parse(json.start)
            reservation.end = LocalDate.parse(json.end)
            def success = reservation.save()
            return new ResponseEntity(success ? HttpStatus.OK : HttpStatus.BAD_REQUEST)
        }
    }

    @RequestMapping(value = '/reservations/{id}', method = DELETE)
    ResponseEntity delete(@PathVariable long id) {
        Reservation.withTransaction {
            Reservation.get(id)?.delete()
            return new ResponseEntity(HttpStatus.NO_CONTENT)
        }
    }
}

//curl -H "Content-Type: application/json" -X POST -d '{"beamer":"KIRK", "start":"2016-02-03", "end":"2016-02-10"}' http://localhost:8080/reservations
//curl -H "Accept: application/json" http://localhost:8080/reservations
//curl -H "Content-Type: application/json" -X POST -d '{"beamer":"SPOCK", "start":"2016-02-03", "end":"2016-02-10"}' http://localhost:8080/reservations/1
//curl -H "Content-Type: application/json" -X DELETE http://localhost:8080/reservations/1