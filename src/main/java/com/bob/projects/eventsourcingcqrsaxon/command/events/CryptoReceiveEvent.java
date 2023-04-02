package com.bob.projects.eventsourcingcqrsaxon.command.events;

import com.bob.projects.eventsourcingcqrsaxon.command.events.base.BaseEvent;

public class CryptoReceiveEvent extends BaseEvent<String> {

    public final double receivedAmount;

    public final String token;

    public final String blockchainNetwork;

    public CryptoReceiveEvent(String id, double receivedAmount, String token, String blockchainNetwork) {
        super(id);
        this.receivedAmount = receivedAmount;
        this.token = token;
        this.blockchainNetwork = blockchainNetwork;
    }
}
