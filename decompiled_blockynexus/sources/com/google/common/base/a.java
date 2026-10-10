package com.google.common.base;

import com.google.common.base.AbstractIterator;

/* JADX INFO: compiled from: AbstractIterator.java */
/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f13732a = new int[AbstractIterator.State.values().length];

    static {
        try {
            f13732a[AbstractIterator.State.READY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f13732a[AbstractIterator.State.DONE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
