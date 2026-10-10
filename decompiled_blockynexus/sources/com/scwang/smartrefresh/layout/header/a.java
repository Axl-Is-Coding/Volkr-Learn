package com.scwang.smartrefresh.layout.header;

import com.scwang.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: compiled from: BezierRadarHeader.java */
/* JADX INFO: loaded from: classes4.dex */
/* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f19167a = new int[RefreshState.values().length];

    static {
        try {
            f19167a[RefreshState.None.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f19167a[RefreshState.PullDownToRefresh.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
