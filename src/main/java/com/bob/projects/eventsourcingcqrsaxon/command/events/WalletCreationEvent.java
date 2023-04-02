package com.bob.projects.eventsourcingcqrsaxon.command.events;

import com.bob.projects.eventsourcingcqrsaxon.command.events.base.BaseEvent;

public class WalletCreationEvent extends BaseEvent<String> {

    public final boolean isMemoRequired;

    public final String token;

    public final String blockchainNetwork;

    public WalletCreationEvent(String id, boolean isMemoRequired, String token, String blockchainNetwork) {
        super(id);
        this.isMemoRequired = isMemoRequired;
        this.token = token;
        this.blockchainNetwork = blockchainNetwork;
    }
}
