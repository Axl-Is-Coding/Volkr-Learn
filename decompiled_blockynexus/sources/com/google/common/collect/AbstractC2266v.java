package com.google.common.collect;

/* JADX INFO: renamed from: com.google.common.collect.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ForwardingObject.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2266v {
    protected AbstractC2266v() {
    }

    protected abstract Object delegate();

    public String toString() {
        return delegate().toString();
    }
}
