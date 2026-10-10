package com.google.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractIterator<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private State f13729a = State.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f13730b;

    /* JADX INFO: Access modifiers changed from: private */
    enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected AbstractIterator() {
    }

    private boolean c() {
        this.f13729a = State.FAILED;
        this.f13730b = a();
        if (this.f13729a == State.DONE) {
            return false;
        }
        this.f13729a = State.READY;
        return true;
    }

    protected abstract T a();

    protected final T b() {
        this.f13729a = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        m.b(this.f13729a != State.FAILED);
        int i = a.f13732a[this.f13729a.ordinal()];
        if (i == 1) {
            return true;
        }
        if (i != 2) {
            return c();
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f13729a = State.NOT_READY;
        T t = this.f13730b;
        this.f13730b = null;
        return t;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
