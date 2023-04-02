package com.bob.projects.eventsourcingcqrsaxon.command.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class CryptoReceiveDTO {

    double receivedAmount;

    String token;

    String blockchainNetwork;

}
