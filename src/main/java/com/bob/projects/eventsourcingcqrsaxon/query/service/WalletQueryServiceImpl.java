package com.bob.projects.eventsourcingcqrsaxon.query.service;

import com.bob.projects.eventsourcingcqrsaxon.query.entity.TrustWallet;
import com.bob.projects.eventsourcingcqrsaxon.query.repository.WalletRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class WalletQueryServiceImpl implements WalletQueryService {

    final EventStore eventStore;

    final WalletRepository walletRepository;

    @Override
    public List<Object> listEventsBasedOnWalletAddress(String walletAddress) {
        return eventStore.readEvents(walletAddress).asStream().map(Message::getPayload).collect(Collectors.toList());
    }

    @Override
    public TrustWallet getTrustWallet(String walletAddress) {
        return walletRepository.findById(walletAddress).orElse(null);
    }
}
