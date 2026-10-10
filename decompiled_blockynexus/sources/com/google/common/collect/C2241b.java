package com.google.common.collect;

import com.google.common.collect.AbstractIterator;

/* JADX INFO: renamed from: com.google.common.collect.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbstractIterator.java */
/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class C2241b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f13927a = new int[AbstractIterator.State.values().length];

    static {
        try {
            f13927a[AbstractIterator.State.DONE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f13927a[AbstractIterator.State.READY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
