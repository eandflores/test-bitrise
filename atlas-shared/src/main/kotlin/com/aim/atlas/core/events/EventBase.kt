package com.aim.atlas.core.events

open class EventBase {
    private var originService : String
    private var eventType : EventType

    constructor(originService : String, eventType : EventType) {
        this.originService = originService
        this.eventType = eventType
    }
}