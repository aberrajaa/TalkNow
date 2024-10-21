package fr.mightycode.cpoo.server.dto;


import fr.mightycode.cpoo.server.model.Message;
import fr.mightycode.cpoo.server.service.RouterService;

import java.util.UUID;

public record MessageDTO(UUID id, long timestamp, String from, String to, String type, String body) {

  // Build a message DTO from a router message
  public MessageDTO(RouterService.Message message) {
    this(message.id(), message.timestamp(), message.from(), message.to(), message.type(), message.body());
  }

  // Build a message DTO from a model message
  public MessageDTO(Message message) {
    this(message.getId(), message.getTimestamp(), message.getFrom(), message.getTo(), message.getType(), message.getBody());
  }
}
