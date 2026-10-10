package com.google.common.base;

import com.google.common.base.r;

/* JADX INFO: compiled from: Splitter.java */
/* JADX INFO: loaded from: classes2.dex */
class q implements r.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f13757a;

    q(c cVar) {
        this.f13757a = cVar;
    }

    @Override // com.google.common.base.r.b
    public r.a a(r rVar, CharSequence charSequence) {
        return new p(this, rVar, charSequence);
    }
}
