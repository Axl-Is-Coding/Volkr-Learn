package com.google.android.material.bottomappbar;

import android.view.View;
import androidx.core.view.J;
import com.google.android.material.internal.v;

/* JADX INFO: compiled from: BottomAppBar.java */
/* JADX INFO: loaded from: classes2.dex */
class c implements v.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BottomAppBar f13175a;

    c(BottomAppBar bottomAppBar) {
        this.f13175a = bottomAppBar;
    }

    @Override // com.google.android.material.internal.v.a
    public J a(View view, J j, v.b bVar) {
        this.f13175a.bottomInset = j.b();
        bVar.f13492d += j.b();
        bVar.a(view);
        return j;
    }
}
