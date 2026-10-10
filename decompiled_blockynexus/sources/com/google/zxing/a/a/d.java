package com.google.zxing.a.a;

import java.util.Comparator;

/* JADX INFO: compiled from: HighLevelEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
class d implements Comparator<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f14401a;

    d(e eVar) {
        this.f14401a = eVar;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(g gVar, g gVar2) {
        return gVar.b() - gVar2.b();
    }
}
