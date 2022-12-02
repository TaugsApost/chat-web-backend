package br.com.taugs.chat.websocket.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import br.com.taugs.chat.websocket.handler.ChatWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {

  private final static String CHAT_ENDPOINT = "";

  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
    webSocketHandlerRegistry.addHandler(getChatWebSocketHandler(), CHAT_ENDPOINT)
        .setAllowedOrigins("*");
  }

  @Bean
  public WebSocketHandler getChatWebSocketHandler() {
    return new ChatWebSocketHandler();
  }
}
