package com.google.common.base;

import com.google.common.base.r;

/* JADX INFO: compiled from: Splitter.java */
/* JADX INFO: loaded from: classes2.dex */
class p extends r.a {
    final /* synthetic */ q h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    p(q qVar, r rVar, CharSequence charSequence) {
        super(rVar, charSequence);
        this.h = qVar;
    }

    @Override // com.google.common.base.r.a
    int a(int i) {
        return i + 1;
    }

    @Override // com.google.common.base.r.a
    int b(int i) {
        return this.h.f13757a.a(this.f13762c, i);
    }
}
