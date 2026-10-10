package com.google.android.material.snackbar;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes2.dex */
class q implements SwipeDismissBehavior.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f13607a;

    q(BaseTransientBottomBar baseTransientBottomBar) {
        this.f13607a = baseTransientBottomBar;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior.a
    public void a(View view) {
        view.setVisibility(8);
        this.f13607a.a(0);
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior.a
    public void a(int i) {
        if (i == 0) {
            v.a().e(this.f13607a.v);
        } else if (i == 1 || i == 2) {
            v.a().d(this.f13607a.v);
        }
    }
}
