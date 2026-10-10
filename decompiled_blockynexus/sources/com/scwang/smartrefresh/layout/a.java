package com.scwang.smartrefresh.layout;

import com.scwang.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: compiled from: SmartRefreshLayout.java */
/* JADX INFO: loaded from: classes4.dex */
/* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f19131a = new int[RefreshState.values().length];

    static {
        try {
            f19131a[RefreshState.None.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f19131a[RefreshState.PullDownToRefresh.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f19131a[RefreshState.PullUpToLoad.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f19131a[RefreshState.PullDownCanceled.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f19131a[RefreshState.PullUpCanceled.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f19131a[RefreshState.ReleaseToRefresh.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f19131a[RefreshState.ReleaseToLoad.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f19131a[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f19131a[RefreshState.RefreshReleased.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f19131a[RefreshState.LoadReleased.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f19131a[RefreshState.Refreshing.ordinal()] = 11;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f19131a[RefreshState.Loading.ordinal()] = 12;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f19131a[RefreshState.RefreshFinish.ordinal()] = 13;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f19131a[RefreshState.LoadFinish.ordinal()] = 14;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            f19131a[RefreshState.TwoLevelReleased.ordinal()] = 15;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            f19131a[RefreshState.TwoLevelFinish.ordinal()] = 16;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            f19131a[RefreshState.TwoLevel.ordinal()] = 17;
        } catch (NoSuchFieldError unused17) {
        }
    }
}
