package rx;

import rx.internal.util.SubscriptionList;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Subscriber<T> implements Observer<T>, Subscription {
    private static final long NOT_SET = Long.MIN_VALUE;
    private Producer producer;
    private long requested;
    private final Subscriber<?> subscriber;
    private final SubscriptionList subscriptions;

    protected Subscriber() {
        this(null, false);
    }

    private void addToRequested(long j) {
        long j2 = this.requested;
        if (j2 == NOT_SET) {
            this.requested = j;
            return;
        }
        long j3 = j2 + j;
        if (j3 < 0) {
            this.requested = Long.MAX_VALUE;
        } else {
            this.requested = j3;
        }
    }

    public final void add(Subscription subscription) {
        this.subscriptions.add(subscription);
    }

    @Override // rx.Subscription
    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public void onStart() {
    }

    protected final void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("number requested cannot be negative: " + j);
        }
        synchronized (this) {
            if (this.producer == null) {
                addToRequested(j);
            } else {
                this.producer.request(j);
            }
        }
    }

    public void setProducer(Producer producer) {
        long j;
        boolean z;
        synchronized (this) {
            j = this.requested;
            this.producer = producer;
            z = this.subscriber != null && j == NOT_SET;
        }
        if (z) {
            this.subscriber.setProducer(this.producer);
        } else if (j == NOT_SET) {
            this.producer.request(Long.MAX_VALUE);
        } else {
            this.producer.request(j);
        }
    }

    @Override // rx.Subscription
    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    protected Subscriber(Subscriber<?> subscriber) {
        this(subscriber, true);
    }

    protected Subscriber(Subscriber<?> subscriber, boolean z) {
        this.requested = NOT_SET;
        this.subscriber = subscriber;
        this.subscriptions = (!z || subscriber == null) ? new SubscriptionList() : subscriber.subscriptions;
    }
}
