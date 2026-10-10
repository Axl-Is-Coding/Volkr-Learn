package com.google.android.ads.mediationtestsuite.utils;

import com.google.android.ads.mediationtestsuite.dataobjects.AdFormat;

/* JADX INFO: compiled from: AdRequestUtil.java */
/* JADX INFO: loaded from: classes.dex */
/* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f12669a = new int[AdFormat.values().length];

    static {
        try {
            f12669a[AdFormat.BANNER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f12669a[AdFormat.INTERSTITIAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f12669a[AdFormat.REWARDED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f12669a[AdFormat.NATIVE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
