package com.bob.projects.eventsourcingcqrsaxon.command.events;

import com.bob.projects.eventsourcingcqrsaxon.command.enumeration.Status;
import com.bob.projects.eventsourcingcqrsaxon.command.events.base.BaseEvent;

public class CryptoFreezeEvent extends BaseEvent<String> {

    public final double freezeAmount;

    public final String token;

    public final String blockchainNetwork;

    public CryptoFreezeEvent(String id, double freezeAmount, String token,String blockchainNetwork) {
        super(id);
        this.freezeAmount = freezeAmount;
        this.token = token;
        this.blockchainNetwork = blockchainNetwork;
    }
}
