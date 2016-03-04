package be.ixor.techtalks.springboot.display

import be.ixor.techtalks.springboot.Display
import be.ixor.techtalks.springboot.ParkingState
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.stereotype.Component
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry

@Component
class WebSocketDisplay implements Display {
    private SimpMessagingTemplate template;

    @Autowired
    WebSocketDisplay(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Override
    void setParkingState(ParkingState parkingState) {
        println "new state for FreeFullDisplay: $parkingState"
        template.convertAndSend('/topic/parkingStatus', [status: parkingState])
    }
}

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker('/topic')
        config.applicationDestinationPrefixes = '/app'
    }

    @Override
    void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint('/ws').withSockJS()
    }
}
