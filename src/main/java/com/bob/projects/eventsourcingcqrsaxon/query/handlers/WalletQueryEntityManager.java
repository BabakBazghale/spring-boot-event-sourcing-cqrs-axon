package com.bob.projects.eventsourcingcqrsaxon.query.handlers;

import com.bob.projects.eventsourcingcqrsaxon.command.aggregate.WalletAggregate;
import com.bob.projects.eventsourcingcqrsaxon.query.entity.TrustWallet;
import com.bob.projects.eventsourcingcqrsaxon.query.repository.WalletRepository;
import com.bob.projects.eventsourcingcqrsaxon.command.events.base.BaseEvent;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WalletQueryEntityManager {

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    @Qualifier("walletAggregateEventSourcingRepository")
    EventSourcingRepository<WalletAggregate> walletAggregateEventSourcingRepository;

    @EventSourcingHandler
    void on(BaseEvent event) {
        saveWallet(buildTrustWallet(getWalletFromBaseEvent(event)));
    }


    private WalletAggregate getWalletFromBaseEvent(BaseEvent event) {
        return walletAggregateEventSourcingRepository.load(event.id.toString()).getWrappedAggregate().getAggregateRoot();
    }

    private TrustWallet findExistingOrCreateTrustWallet(String id) {
        return walletRepository.findById(id).orElse(new TrustWallet());
    }

    private TrustWallet buildTrustWallet(WalletAggregate walletAggregate) {
        TrustWallet trustWallet = findExistingOrCreateTrustWallet(walletAggregate.getId());
        trustWallet.setId(walletAggregate.getId());
        trustWallet.setToken(walletAggregate.getToken());
        trustWallet.setBlockchainNetwork(walletAggregate.getBlockchainNetwork());
        trustWallet.setFreeBalance(walletAggregate.getFreeBalance());
        trustWallet.setFreezeBalance(walletAggregate.getFreezeBalance());
        trustWallet.setTotalBalance(walletAggregate.getTotalBalance());
        trustWallet.setStatus(walletAggregate.getStatus());
        trustWallet.setMemoRequired(walletAggregate.isMemoRequired());
        return trustWallet;
    }

    private void saveWallet(TrustWallet trustWallet) {
        walletRepository.save(trustWallet);
    }
}
