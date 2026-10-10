package com.google.android.material.bottomnavigation;

import android.view.View;
import androidx.core.view.J;
import com.google.android.material.internal.v;

/* JADX INFO: compiled from: BottomNavigationView.java */
/* JADX INFO: loaded from: classes2.dex */
class e implements v.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BottomNavigationView f13203a;

    e(BottomNavigationView bottomNavigationView) {
        this.f13203a = bottomNavigationView;
    }

    @Override // com.google.android.material.internal.v.a
    public J a(View view, J j, v.b bVar) {
        bVar.f13492d += j.b();
        bVar.a(view);
        return j;
    }
}
