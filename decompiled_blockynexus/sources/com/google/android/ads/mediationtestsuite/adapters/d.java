package com.google.android.ads.mediationtestsuite.adapters;

import com.google.android.ads.mediationtestsuite.viewmodels.ListItemViewModel;

/* JADX INFO: compiled from: ItemsListRecyclerViewAdapter.java */
/* JADX INFO: loaded from: classes.dex */
/* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f12657a = new int[ListItemViewModel.ViewType.values().length];

    static {
        try {
            f12657a[ListItemViewModel.ViewType.AD_LOAD.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f12657a[ListItemViewModel.ViewType.DETAIL_ITEM.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f12657a[ListItemViewModel.ViewType.HEADER.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f12657a[ListItemViewModel.ViewType.INFO_LABEL.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
