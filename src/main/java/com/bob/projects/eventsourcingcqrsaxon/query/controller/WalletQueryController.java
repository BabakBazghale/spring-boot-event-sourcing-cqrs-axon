package com.bob.projects.eventsourcingcqrsaxon.query.controller;

import com.bob.projects.eventsourcingcqrsaxon.query.entity.TrustWallet;
import com.bob.projects.eventsourcingcqrsaxon.query.service.WalletQueryService;
import io.swagger.annotations.Api;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "wallet")
@Api(value = "WALLET QUERIES")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class WalletQueryController {

    final WalletQueryService walletQueryService;

    @GetMapping("{address}")
    public TrustWallet getTrustWallet(@PathVariable(value = "address") String address) {
        return walletQueryService.getTrustWallet(address);
    }

    @GetMapping("{address}/events")
    public List<Object> listEventsBasedOnWalletAddress(@PathVariable(value = "address") String address) {
        return walletQueryService.listEventsBasedOnWalletAddress(address);
    }

}
