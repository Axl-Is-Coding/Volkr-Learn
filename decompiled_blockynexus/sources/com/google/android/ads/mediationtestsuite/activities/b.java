package com.google.android.ads.mediationtestsuite.activities;

import androidx.appcompat.widget.SearchView;

/* JADX INFO: compiled from: AdUnitDetailActivity.java */
/* JADX INFO: loaded from: classes.dex */
class b implements SearchView.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdUnitDetailActivity f12638a;

    b(AdUnitDetailActivity adUnitDetailActivity) {
        this.f12638a = adUnitDetailActivity;
    }

    @Override // androidx.appcompat.widget.SearchView.c
    public boolean onQueryTextChange(String str) {
        this.f12638a.g.getFilter().filter(str);
        return false;
    }

    @Override // androidx.appcompat.widget.SearchView.c
    public boolean onQueryTextSubmit(String str) {
        this.f12638a.g.getFilter().filter(str);
        return false;
    }
}
