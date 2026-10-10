package com.google.android.ads.mediationtestsuite.activities;

import android.widget.CompoundButton;

/* JADX INFO: compiled from: HomeActivity.java */
/* JADX INFO: loaded from: classes.dex */
class k implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ androidx.appcompat.app.j f12648a;

    k(l lVar, androidx.appcompat.app.j jVar) {
        this.f12648a = jVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f12648a.b(-1).setEnabled(z);
    }
}
