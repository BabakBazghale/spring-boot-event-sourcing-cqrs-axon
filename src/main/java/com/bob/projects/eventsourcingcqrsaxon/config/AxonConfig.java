package com.bob.projects.eventsourcingcqrsaxon.config;

import com.bob.projects.eventsourcingcqrsaxon.command.aggregate.WalletAggregate;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

    @Bean
    EventSourcingRepository<WalletAggregate> walletAggregateEventSourcingRepository(EventStore eventStore) {
        return EventSourcingRepository.builder(WalletAggregate.class).eventStore(eventStore).build();
    }
}
