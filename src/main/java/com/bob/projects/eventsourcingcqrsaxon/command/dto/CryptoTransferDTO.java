package com.bob.projects.eventsourcingcqrsaxon.command.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class CryptoTransferDTO {

    double transferAmount;

    String token;

    String blockchainNetwork;
}
