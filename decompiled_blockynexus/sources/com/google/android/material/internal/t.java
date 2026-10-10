package com.google.android.material.internal;

import android.view.View;
import androidx.core.view.J;
import com.google.android.material.internal.v;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class t implements androidx.core.view.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ v.a f13487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ v.b f13488b;

    t(v.a aVar, v.b bVar) {
        this.f13487a = aVar;
        this.f13488b = bVar;
    }

    @Override // androidx.core.view.r
    public J a(View view, J j) {
        return this.f13487a.a(view, j, new v.b(this.f13488b));
    }
}
