package com.google.android.ads.mediationtestsuite.activities;

import androidx.appcompat.widget.SearchView;

/* JADX INFO: compiled from: AdUnitsSearchActivity.java */
/* JADX INFO: loaded from: classes.dex */
class i implements SearchView.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdUnitsSearchActivity f12646a;

    i(AdUnitsSearchActivity adUnitsSearchActivity) {
        this.f12646a = adUnitsSearchActivity;
    }

    @Override // androidx.appcompat.widget.SearchView.c
    public boolean onQueryTextChange(String str) {
        this.f12646a.f12627a.a(str);
        return false;
    }

    @Override // androidx.appcompat.widget.SearchView.c
    public boolean onQueryTextSubmit(String str) {
        this.f12646a.f12627a.a(str);
        return false;
    }
}
