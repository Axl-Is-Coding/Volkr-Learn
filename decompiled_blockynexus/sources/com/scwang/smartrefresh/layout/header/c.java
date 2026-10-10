package com.scwang.smartrefresh.layout.header;

import com.scwang.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: compiled from: TwoLevelHeader.java */
/* JADX INFO: loaded from: classes4.dex */
/* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f19169a = new int[RefreshState.values().length];

    static {
        try {
            f19169a[RefreshState.TwoLevelReleased.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f19169a[RefreshState.TwoLevel.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f19169a[RefreshState.TwoLevelFinish.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f19169a[RefreshState.PullDownToRefresh.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
