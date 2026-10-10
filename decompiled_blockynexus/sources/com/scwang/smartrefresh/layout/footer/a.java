package com.scwang.smartrefresh.layout.footer;

import com.scwang.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: compiled from: ClassicsFooter.java */
/* JADX INFO: loaded from: classes4.dex */
/* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f19158a = new int[RefreshState.values().length];

    static {
        try {
            f19158a[RefreshState.None.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f19158a[RefreshState.PullUpToLoad.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f19158a[RefreshState.Loading.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f19158a[RefreshState.LoadReleased.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f19158a[RefreshState.ReleaseToLoad.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f19158a[RefreshState.Refreshing.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
