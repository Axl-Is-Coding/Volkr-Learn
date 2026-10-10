package com.google.android.material.l;

import com.google.android.material.l.n;

/* JADX INFO: compiled from: MaterialShapeDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
class h implements n.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ float f13513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ i f13514b;

    h(i iVar, float f2) {
        this.f13514b = iVar;
        this.f13513a = f2;
    }

    @Override // com.google.android.material.l.n.b
    public c a(c cVar) {
        return cVar instanceof k ? cVar : new b(this.f13513a, cVar);
    }
}
