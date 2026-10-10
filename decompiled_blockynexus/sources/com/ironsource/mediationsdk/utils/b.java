package com.ironsource.mediationsdk.utils;

import com.ironsource.mediationsdk.model.PlacementCappingType;

/* JADX INFO: compiled from: CappingManager.java */
/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f15019a = new int[PlacementCappingType.values().length];

    static {
        try {
            f15019a[PlacementCappingType.PER_DAY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f15019a[PlacementCappingType.PER_HOUR.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
