package com.munvo.enrichment.model;

public class EnrichedCall {

    private Call call;
    private Subscriber subscriber;

    public EnrichedCall(Call call, Subscriber subscriber) {
        this.call = call;
        this.subscriber = subscriber;
    }

    public Call getCall() {
        return call;
    }

    public void setCall(Call call) {
        this.call = call;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public String toString() {
        return call.toString() + " => " + subscriber.toString();
    }
}
