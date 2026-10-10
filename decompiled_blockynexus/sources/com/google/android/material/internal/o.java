package com.google.android.material.internal;

import android.graphics.Typeface;
import com.google.android.material.internal.p;

/* JADX INFO: compiled from: TextDrawableHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class o extends com.google.android.material.i.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f13474a;

    o(p pVar) {
        this.f13474a = pVar;
    }

    @Override // com.google.android.material.i.h
    public void a(Typeface typeface, boolean z) {
        if (z) {
            return;
        }
        this.f13474a.f13478d = true;
        p.a aVar = (p.a) this.f13474a.f13479e.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.google.android.material.i.h
    public void a(int i) {
        this.f13474a.f13478d = true;
        p.a aVar = (p.a) this.f13474a.f13479e.get();
        if (aVar != null) {
            aVar.a();
        }
    }
}
