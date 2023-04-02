package com.bob.projects.eventsourcingcqrsaxon.command.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class WalletCreationDTO {

    boolean isMemoRequired;

    String token;

    String blockchainNetwork;
}
