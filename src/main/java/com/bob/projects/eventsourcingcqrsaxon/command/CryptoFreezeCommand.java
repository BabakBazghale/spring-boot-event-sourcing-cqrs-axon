package com.bob.projects.eventsourcingcqrsaxon.command;

import com.bob.projects.eventsourcingcqrsaxon.command.base.BaseCommand;

public class CryptoFreezeCommand extends BaseCommand<String> {
    public final double freezeAmount;

    public final String token;

    public final String blockchainNetwork;

    public CryptoFreezeCommand(String id, double freezeAmount, String token,String blockchainNetwork) {
        super(id);
        this.freezeAmount = freezeAmount;
        this.token = token;
        this.blockchainNetwork = blockchainNetwork;
    }
}
