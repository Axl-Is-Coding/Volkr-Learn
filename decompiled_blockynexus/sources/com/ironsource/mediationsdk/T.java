package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.utils.CappingManager;

/* JADX INFO: compiled from: IronSourceObject.java */
/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f14728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f14729b = new int[CappingManager.ECappingStatus.values().length];

    static {
        try {
            f14729b[CappingManager.ECappingStatus.CAPPED_PER_DELIVERY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f14729b[CappingManager.ECappingStatus.CAPPED_PER_COUNT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f14729b[CappingManager.ECappingStatus.CAPPED_PER_PACE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f14729b[CappingManager.ECappingStatus.NOT_CAPPED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        f14728a = new int[IronSource.AD_UNIT.values().length];
        try {
            f14728a[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f14728a[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f14728a[IronSource.AD_UNIT.OFFERWALL.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f14728a[IronSource.AD_UNIT.BANNER.ordinal()] = 4;
        } catch (NoSuchFieldError unused8) {
        }
    }
}
