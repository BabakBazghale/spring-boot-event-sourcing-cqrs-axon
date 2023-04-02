package com.bob.projects.eventsourcingcqrsaxon.command.service;

import com.bob.projects.eventsourcingcqrsaxon.command.CryptoFreezeCommand;
import com.bob.projects.eventsourcingcqrsaxon.command.CryptoReceiveCommand;
import com.bob.projects.eventsourcingcqrsaxon.command.CryptoTransferCommand;
import com.bob.projects.eventsourcingcqrsaxon.command.WalletCreationCommand;
import com.bob.projects.eventsourcingcqrsaxon.command.dto.CryptoFreezeDTO;
import com.bob.projects.eventsourcingcqrsaxon.command.dto.WalletCreationDTO;
import com.bob.projects.eventsourcingcqrsaxon.command.dto.CryptoReceiveDTO;
import com.bob.projects.eventsourcingcqrsaxon.command.dto.CryptoTransferDTO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class WalletCommandServiceImpl implements WalletCommandService {

    final CommandGateway commandGateway;

    @Override
    public CompletableFuture<String> createWallet(WalletCreationDTO walletCreationDTO) {
        return commandGateway.send(new WalletCreationCommand(UUID.randomUUID().toString(), walletCreationDTO.isMemoRequired(), walletCreationDTO.getToken(),
                walletCreationDTO.getBlockchainNetwork()));
    }

    @Override
    public CompletableFuture<String> receiveCrypto(String walletAddress, CryptoReceiveDTO cryptoTransferDTO) {
        return commandGateway.send(new CryptoReceiveCommand(walletAddress, cryptoTransferDTO.getReceivedAmount(), cryptoTransferDTO.getToken(),
                cryptoTransferDTO.getBlockchainNetwork()));
    }

    @Override
    public CompletableFuture<String> transferCrypto(String walletAddress, CryptoTransferDTO cryptoTransferDTO) {
        return commandGateway.send(new CryptoTransferCommand(walletAddress, cryptoTransferDTO.getTransferAmount(), cryptoTransferDTO.getToken(),
                cryptoTransferDTO.getBlockchainNetwork()));
    }
    @Override
    public CompletableFuture<String> freezeCrypto(String walletAddress, CryptoFreezeDTO cryptoFreezeDTO) {
        return commandGateway.send(new CryptoFreezeCommand(walletAddress, cryptoFreezeDTO.getFreezeAmount(), cryptoFreezeDTO.getToken(),
                cryptoFreezeDTO.getBlockchainNetwork()));
    }
}
