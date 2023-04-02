package com.bob.projects.eventsourcingcqrsaxon.command.events;

import com.bob.projects.eventsourcingcqrsaxon.command.enumeration.Status;
import com.bob.projects.eventsourcingcqrsaxon.command.events.base.BaseEvent;

public class WalletBlockEvent extends BaseEvent<String> {

    public final Status status;

    public WalletBlockEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}
