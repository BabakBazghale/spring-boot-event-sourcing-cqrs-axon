package com.bob.projects.eventsourcingcqrsaxon.command.controller;

import com.bob.projects.eventsourcingcqrsaxon.command.dto.CryptoFreezeDTO;
import com.bob.projects.eventsourcingcqrsaxon.command.dto.CryptoReceiveDTO;
import com.bob.projects.eventsourcingcqrsaxon.command.dto.CryptoTransferDTO;
import com.bob.projects.eventsourcingcqrsaxon.command.dto.WalletCreationDTO;
import com.bob.projects.eventsourcingcqrsaxon.command.service.WalletCommandService;
import io.swagger.annotations.Api;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "wallet")
@Api(value = "WALLET COMMANDS")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class WalletCommandController {

    final WalletCommandService walletCommandService;


    @PostMapping("creation")
    public CompletableFuture<String> createWallet(@RequestBody WalletCreationDTO walletCreationDTO) {
        return walletCommandService.createWallet(walletCreationDTO);
    }

    @PostMapping(value = "receive/{address}")
    public CompletableFuture<String> receiveCrypto(@PathVariable(value = "address") String address,
                                                   @RequestBody CryptoReceiveDTO cryptoTransferDTO) {
        return walletCommandService.receiveCrypto(address, cryptoTransferDTO);
    }

    @PostMapping(value = "transfer/{address}")
    public CompletableFuture<String> transferCrypto(@PathVariable(value = "address") String address,
                                                    @RequestBody CryptoTransferDTO cryptoTransferDTO) {
        return walletCommandService.transferCrypto(address, cryptoTransferDTO);
    }

    @PostMapping(value = "freeze/{address}")
    public CompletableFuture<String> freezeCrypto(@PathVariable(value = "address") String address,
                                                  @RequestBody CryptoFreezeDTO cryptoFreezeDTO) {
        return walletCommandService.freezeCrypto(address, cryptoFreezeDTO);
    }

}
