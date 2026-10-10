package io.grpc.internal;

import java.util.HashSet;

/* JADX INFO: loaded from: classes5.dex */
abstract class InUseStateAggregator<T> {
    private final HashSet<T> inUseObjects = new HashSet<>();

    InUseStateAggregator() {
    }

    abstract Object getLock();

    abstract void handleInUse();

    abstract void handleNotInUse();

    final boolean isInUse() {
        boolean z;
        synchronized (getLock()) {
            z = !this.inUseObjects.isEmpty();
        }
        return z;
    }

    final void updateObjectInUse(T t, boolean z) {
        synchronized (getLock()) {
            int size = this.inUseObjects.size();
            if (z) {
                this.inUseObjects.add(t);
                if (size == 0) {
                    handleInUse();
                }
            } else if (this.inUseObjects.remove(t) && size == 1) {
                handleNotInUse();
            }
        }
    }
}
