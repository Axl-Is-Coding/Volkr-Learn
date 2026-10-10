package com.google.common.collect;

import com.google.common.collect.Ordering;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: Ordering.java */
/* JADX INFO: loaded from: classes2.dex */
class sa implements com.google.common.base.f<Object, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicInteger f13965a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ordering.a f13966b;

    sa(Ordering.a aVar) {
        this.f13966b = aVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.common.base.f
    public Integer apply(Object obj) {
        return Integer.valueOf(this.f13965a.getAndIncrement());
    }
}
