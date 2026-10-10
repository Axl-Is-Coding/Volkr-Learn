package com.google.common.collect;

import com.google.common.collect.Multisets;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: renamed from: com.google.common.collect.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbstractMapBasedMultiset.java */
/* JADX INFO: loaded from: classes2.dex */
class C2249f<E> extends Multisets.a<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map.Entry f13938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2251g f13939b;

    C2249f(C2251g c2251g, Map.Entry entry) {
        this.f13939b = c2251g;
        this.f13938a = entry;
    }

    @Override // com.google.common.collect.oa.a
    public int getCount() {
        Count count;
        Count count2 = (Count) this.f13938a.getValue();
        if ((count2 == null || count2.get() == 0) && (count = (Count) this.f13939b.f13943c.backingMap.get(getElement())) != null) {
            return count.get();
        }
        if (count2 == null) {
            return 0;
        }
        return count2.get();
    }

    @Override // com.google.common.collect.oa.a
    public E getElement() {
        return (E) this.f13938a.getKey();
    }
}
