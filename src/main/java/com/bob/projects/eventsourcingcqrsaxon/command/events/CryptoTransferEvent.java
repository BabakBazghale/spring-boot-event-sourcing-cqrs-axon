package com.bob.projects.eventsourcingcqrsaxon.command.events;

import com.bob.projects.eventsourcingcqrsaxon.command.events.base.BaseEvent;

public class CryptoTransferEvent extends BaseEvent<String> {

    public final double transferAmount;

    public final String token;

    public final String blockchainNetwork;

    public CryptoTransferEvent(String id, double transferAmount, String token,String blockchainNetwork) {
        super(id);
        this.transferAmount = transferAmount;
        this.token = token;
        this.blockchainNetwork = blockchainNetwork;
    }
}
