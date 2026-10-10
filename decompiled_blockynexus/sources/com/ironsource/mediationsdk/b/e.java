package com.ironsource.mediationsdk.b;

import java.util.Comparator;

/* JADX INFO: compiled from: BaseEventsManager.java */
/* JADX INFO: loaded from: classes2.dex */
class e implements Comparator<b.f.b.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f14779a;

    e(f fVar) {
        this.f14779a = fVar;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(b.f.b.b bVar, b.f.b.b bVar2) {
        return bVar.d() >= bVar2.d() ? 1 : -1;
    }
}
