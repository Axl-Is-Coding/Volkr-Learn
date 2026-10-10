package com.google.android.material.internal;

import android.view.View;
import androidx.core.view.C0313a;

/* JADX INFO: compiled from: NavigationMenuItemView.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends C0313a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ NavigationMenuItemView f13465d;

    h(NavigationMenuItemView navigationMenuItemView) {
        this.f13465d = navigationMenuItemView;
    }

    @Override // androidx.core.view.C0313a
    public void a(View view, androidx.core.view.accessibility.b bVar) {
        super.a(view, bVar);
        bVar.c(this.f13465d.checkable);
    }
}
