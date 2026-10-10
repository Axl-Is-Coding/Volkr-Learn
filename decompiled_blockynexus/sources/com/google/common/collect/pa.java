package com.google.common.collect;

import com.google.common.collect.oa;

/* JADX INFO: compiled from: Multisets.java */
/* JADX INFO: loaded from: classes2.dex */
class pa extends Ordering<oa.a<?>> {
    pa() {
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(oa.a<?> aVar, oa.a<?> aVar2) {
        return b.c.b.b.a.a(aVar2.getCount(), aVar.getCount());
    }
}
