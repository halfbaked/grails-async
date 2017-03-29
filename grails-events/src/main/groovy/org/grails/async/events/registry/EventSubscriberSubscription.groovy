package org.grails.async.events.registry

import grails.async.events.Event
import grails.async.events.subscriber.Subscriber
import grails.async.events.trigger.EventTrigger
import grails.async.events.subscriber.Subscription
import groovy.transform.CompileStatic
import org.grails.async.events.EventSubscriberTrigger

/**
 * An event subscription for an {@link Subscriber}
 *
 * @author Graeme Rocher
 * @since 3.3
 */
@CompileStatic
class EventSubscriberSubscription extends AbstractSubscription {
    final Subscriber subscriber

    EventSubscriberSubscription(CharSequence eventKey, Map<CharSequence, Collection<Subscription>> subscriptions, Subscriber subscriber) {
        super(eventKey, subscriptions)
        this.subscriber = subscriber
    }

    @Override
    EventTrigger buildTrigger(Event event) {
        return new EventSubscriberTrigger(event, subscriber)
    }

    @Override
    EventTrigger buildTrigger(Event event, Closure reply) {
        return new EventSubscriberTrigger(event, subscriber)
    }
}
