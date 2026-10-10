package com.google.android.ads.mediationtestsuite.viewmodels;

import com.google.android.ads.mediationtestsuite.viewmodels.ListItemViewModel;

/* JADX INFO: compiled from: HeaderViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements ListItemViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12706b;

    public f(int i, int i2) {
        this.f12705a = i;
        this.f12706b = i2;
    }

    public int a() {
        return this.f12705a;
    }

    public int b() {
        return this.f12706b;
    }

    @Override // com.google.android.ads.mediationtestsuite.viewmodels.ListItemViewModel
    public ListItemViewModel.ViewType getViewType() {
        return ListItemViewModel.ViewType.HEADER;
    }
}
