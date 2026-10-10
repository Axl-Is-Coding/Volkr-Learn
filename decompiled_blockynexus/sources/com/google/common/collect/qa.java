package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.oa;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: compiled from: Multisets.java */
/* JADX INFO: loaded from: classes2.dex */
class qa<E> extends Ea<oa.a<E>, E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Multisets.b f13962b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    qa(Multisets.b bVar, Iterator it) {
        super(it);
        this.f13962b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.Ea
    public E a(oa.a<E> aVar) {
        return aVar.getElement();
    }
}
