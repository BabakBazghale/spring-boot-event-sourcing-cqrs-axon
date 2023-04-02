package com.bob.projects.eventsourcingcqrsaxon.command;

import com.bob.projects.eventsourcingcqrsaxon.command.base.BaseCommand;

public class CryptoTransferCommand extends BaseCommand<String> {

   public final double transferAmount;

    public final String token;

    public final String blockchainNetwork;

    public CryptoTransferCommand(String id, double transferAmount, String token,String blockchainNetwork) {
        super(id);
        this.transferAmount = transferAmount;
        this.token = token;
        this.blockchainNetwork = blockchainNetwork;
    }
}
