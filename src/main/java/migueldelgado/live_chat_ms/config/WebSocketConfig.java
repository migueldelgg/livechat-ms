package migueldelgado.live_chat_ms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        /*As mensagens enviadas pelo cliente com prefixo /app serão tratadas
        por controladores no servidor. */
        registry.setApplicationDestinationPrefixes("/app");

        /*O servidor, ao processar essas mensagens, pode publicar em tópicos
        com o prefixo /topics, que serão enviados aos assinantes conectados.*/
        registry.enableSimpleBroker("/topics");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /*O servidor é configurado para aceitar conexões
        WebSocket no endpoint /livechat-websocket.*/
        registry.addEndpoint("/livechat-websocket");
    }
}
