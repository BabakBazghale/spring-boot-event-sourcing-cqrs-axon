package com.bob.projects.eventsourcingcqrsaxon.command.service;

import com.bob.projects.eventsourcingcqrsaxon.command.dto.CryptoFreezeDTO;
import com.bob.projects.eventsourcingcqrsaxon.command.dto.WalletCreationDTO;
import com.bob.projects.eventsourcingcqrsaxon.command.dto.CryptoReceiveDTO;
import com.bob.projects.eventsourcingcqrsaxon.command.dto.CryptoTransferDTO;

import java.util.concurrent.CompletableFuture;

public interface WalletCommandService {

    CompletableFuture<String> createWallet(WalletCreationDTO walletCreationDTO);

    CompletableFuture<String> receiveCrypto(String walletAddress, CryptoReceiveDTO cryptoReceiveDTO);

    CompletableFuture<String> transferCrypto(String walletAddress, CryptoTransferDTO cryptoTransferDTO);

    CompletableFuture<String> freezeCrypto(String walletAddress, CryptoFreezeDTO cryptoFreezeDTO);
}
