package com.bob.projects.eventsourcingcqrsaxon.query.service;

import com.bob.projects.eventsourcingcqrsaxon.query.entity.TrustWallet;

import java.util.List;

public interface WalletQueryService {
    List<Object> listEventsBasedOnWalletAddress(String walletAddress);

    TrustWallet getTrustWallet(String walletAddress);
}
