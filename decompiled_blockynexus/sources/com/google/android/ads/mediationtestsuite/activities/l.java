package com.google.android.ads.mediationtestsuite.activities;

import android.content.DialogInterface;
import android.widget.CheckBox;

/* JADX INFO: compiled from: HomeActivity.java */
/* JADX INFO: loaded from: classes.dex */
class l implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CheckBox f12649a;

    l(HomeActivity homeActivity, CheckBox checkBox) {
        this.f12649a = checkBox;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        androidx.appcompat.app.j jVar = (androidx.appcompat.app.j) dialogInterface;
        jVar.b(-1).setEnabled(false);
        this.f12649a.setOnCheckedChangeListener(new k(this, jVar));
    }
}
