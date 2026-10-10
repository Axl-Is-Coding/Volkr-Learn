package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;

/* JADX INFO: compiled from: FlowableCreate.java */
/* JADX INFO: loaded from: classes5.dex */
/* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f21904a = new int[BackpressureStrategy.values().length];

    static {
        try {
            f21904a[BackpressureStrategy.MISSING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f21904a[BackpressureStrategy.ERROR.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f21904a[BackpressureStrategy.DROP.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f21904a[BackpressureStrategy.LATEST.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
