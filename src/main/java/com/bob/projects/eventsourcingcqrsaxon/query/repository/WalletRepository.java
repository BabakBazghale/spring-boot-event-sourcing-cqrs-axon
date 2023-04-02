package com.bob.projects.eventsourcingcqrsaxon.query.repository;

import com.bob.projects.eventsourcingcqrsaxon.query.entity.TrustWallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<TrustWallet, String> {
}
