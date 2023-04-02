package com.bob.projects.eventsourcingcqrsaxon.command;

import com.bob.projects.eventsourcingcqrsaxon.command.base.BaseCommand;

public class CryptoReceiveCommand extends BaseCommand<String> {

    public final double receivedAmount;

    public final String token;

    public final String blockchainNetwork;

    public CryptoReceiveCommand(String id, double receivedAmount, String token, String blockchainNetwork) {
        super(id);
        this.receivedAmount = receivedAmount;
        this.token = token;
        this.blockchainNetwork = blockchainNetwork;
    }
}
