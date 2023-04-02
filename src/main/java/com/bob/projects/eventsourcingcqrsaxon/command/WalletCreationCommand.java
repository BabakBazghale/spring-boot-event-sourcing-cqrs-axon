package com.bob.projects.eventsourcingcqrsaxon.command;

import com.bob.projects.eventsourcingcqrsaxon.command.base.BaseCommand;

public class WalletCreationCommand extends BaseCommand<String> {

    public final boolean isMemoRequired;

    public final String token;

    public final String blockchainNetwork;

    public WalletCreationCommand(String id, boolean isMemoRequired, String token, String blockchainNetwork) {
        super(id);
        this.isMemoRequired = isMemoRequired;
        this.token = token;
        this.blockchainNetwork = blockchainNetwork;
    }
}
