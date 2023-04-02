package com.bob.projects.eventsourcingcqrsaxon.command.aggregate;

import com.bob.projects.eventsourcingcqrsaxon.command.CryptoFreezeCommand;
import com.bob.projects.eventsourcingcqrsaxon.command.WalletCreationCommand;
import com.bob.projects.eventsourcingcqrsaxon.command.CryptoReceiveCommand;
import com.bob.projects.eventsourcingcqrsaxon.command.CryptoTransferCommand;
import com.bob.projects.eventsourcingcqrsaxon.command.enumeration.Status;
import com.bob.projects.eventsourcingcqrsaxon.command.events.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WalletAggregate {

    @AggregateIdentifier
    String id;

    double freeBalance;

    double freezeBalance;

    double totalBalance;

    boolean isMemoRequired;

    String token;

    String blockchainNetwork;

    String status;

    @CommandHandler
    public WalletAggregate(WalletCreationCommand walletCreationCommand) {
        AggregateLifecycle.apply(new WalletCreationEvent(walletCreationCommand.id, walletCreationCommand.isMemoRequired,
                walletCreationCommand.token, walletCreationCommand.blockchainNetwork));
    }

    @EventSourcingHandler
    protected void on(WalletCreationEvent walletCreationEvent) {
        this.id = walletCreationEvent.id;
        this.isMemoRequired = walletCreationEvent.isMemoRequired;
        this.token = walletCreationEvent.token;
        this.blockchainNetwork = walletCreationEvent.blockchainNetwork;
        this.status = Status.ACTIVATED.name();
        AggregateLifecycle.apply(new WalletActivateEvent(this.id, Status.ACTIVATED));
    }

    @EventSourcingHandler
    protected void on(WalletActivateEvent walletActivateEvent) {
        this.status = String.valueOf(walletActivateEvent.status);
    }

    @CommandHandler
    protected void on(CryptoReceiveCommand cryptoReceiveCommand) {
        AggregateLifecycle.apply(new CryptoReceiveEvent(cryptoReceiveCommand.id, cryptoReceiveCommand.receivedAmount,
                cryptoReceiveCommand.token, cryptoReceiveCommand.blockchainNetwork));
    }

    @EventSourcingHandler
    protected void on(CryptoReceiveEvent cryptoReceiveEvent) {
        this.totalBalance += cryptoReceiveEvent.receivedAmount;
        this.freeBalance += cryptoReceiveEvent.receivedAmount;
    }

    @CommandHandler
    protected void on(CryptoTransferCommand cryptoTransferCommand) {
        AggregateLifecycle.apply(new CryptoTransferEvent(cryptoTransferCommand.id, cryptoTransferCommand.transferAmount,
                cryptoTransferCommand.token, cryptoTransferCommand.blockchainNetwork));
    }

    @EventSourcingHandler
    protected void on(CryptoTransferEvent cryptoTransferEvent) {
        this.totalBalance -= cryptoTransferEvent.transferAmount;
        this.freeBalance -= cryptoTransferEvent.transferAmount;
    }

    @CommandHandler
    protected void on(CryptoFreezeCommand cryptoFreezeCommand) {
        AggregateLifecycle.apply(new CryptoFreezeEvent(cryptoFreezeCommand.id, cryptoFreezeCommand.freezeAmount,
                cryptoFreezeCommand.token, cryptoFreezeCommand.blockchainNetwork));
    }

    @EventSourcingHandler
    protected void on(CryptoFreezeEvent cryptoFreezeEvent) {
        this.freeBalance -= cryptoFreezeEvent.freezeAmount;
        this.freezeBalance += cryptoFreezeEvent.freezeAmount;
    }

}
