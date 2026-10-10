package com.scwang.smartrefresh.layout.header;

import com.scwang.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: compiled from: ClassicsHeader.java */
/* JADX INFO: loaded from: classes4.dex */
/* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f19168a = new int[RefreshState.values().length];

    static {
        try {
            f19168a[RefreshState.None.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f19168a[RefreshState.PullDownToRefresh.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f19168a[RefreshState.Refreshing.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f19168a[RefreshState.RefreshReleased.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f19168a[RefreshState.ReleaseToRefresh.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f19168a[RefreshState.ReleaseToTwoLevel.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f19168a[RefreshState.Loading.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
