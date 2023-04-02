package com.bob.projects.eventsourcingcqrsaxon.command.events.base;

public class BaseEvent<T> {

    public final T id;

    public BaseEvent(T id) {
        this.id = id;
    }
}
