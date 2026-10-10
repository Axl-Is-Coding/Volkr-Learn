package com.google.android.material.snackbar;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.C0313a;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes2.dex */
class l extends C0313a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f13602d;

    l(BaseTransientBottomBar baseTransientBottomBar) {
        this.f13602d = baseTransientBottomBar;
    }

    @Override // androidx.core.view.C0313a
    public void a(View view, androidx.core.view.accessibility.b bVar) {
        super.a(view, bVar);
        bVar.a(1048576);
        bVar.g(true);
    }

    @Override // androidx.core.view.C0313a
    public boolean a(View view, int i, Bundle bundle) {
        if (i == 1048576) {
            this.f13602d.d();
            return true;
        }
        return super.a(view, i, bundle);
    }
}
