package com.disabngo.blockynexus.view.fragment.partyhall;

import io.grpc.Status;

/* JADX INFO: compiled from: PartyHallModel.java */
/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f11888a = new int[Status.Code.values().length];

    static {
        try {
            f11888a[Status.Code.CANCELLED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f11888a[Status.Code.UNAVAILABLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f11888a[Status.Code.UNKNOWN.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
