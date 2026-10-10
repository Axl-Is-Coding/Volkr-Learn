package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractIterator<T> extends Fa<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private State f13776a = State.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f13777b;

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
        this.f13776a = State.FAILED;
        this.f13777b = a();
        if (this.f13776a == State.DONE) {
            return false;
        }
        this.f13776a = State.READY;
        return true;
    }

    protected abstract T a();

    protected final T b() {
        this.f13776a = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        com.google.common.base.m.b(this.f13776a != State.FAILED);
        int i = C2241b.f13927a[this.f13776a.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            return c();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f13776a = State.NOT_READY;
        T t = this.f13777b;
        this.f13777b = null;
        return t;
    }
}
