package com.scwang.smartrefresh.layout.c;

import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: compiled from: DesignUtil.java */
/* JADX INFO: loaded from: classes4.dex */
class a implements AppBarLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.scwang.smartrefresh.layout.b.a f19136a;

    a(com.scwang.smartrefresh.layout.b.a aVar) {
        this.f19136a = aVar;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.a
    public void a(AppBarLayout appBarLayout, int i) {
        this.f19136a.a(i >= 0, appBarLayout.getTotalScrollRange() + i <= 0);
    }
}
