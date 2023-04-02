package com.bob.projects.eventsourcingcqrsaxon.query.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrustWallet implements Serializable {

    @Id
    String id;

    double freeBalance;

    double freezeBalance;

    double totalBalance;

    boolean isMemoRequired;

    String token;

    String blockchainNetwork;

    String status;
}
