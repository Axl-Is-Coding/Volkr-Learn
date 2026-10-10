package com.google.common.base;

/* JADX INFO: compiled from: Joiner.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f13745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ h f13746c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    g(h hVar, h hVar2, String str) {
        super(hVar2, null);
        this.f13746c = hVar;
        this.f13745b = str;
    }

    @Override // com.google.common.base.h
    CharSequence a(Object obj) {
        return obj == null ? this.f13745b : this.f13746c.a(obj);
    }

    @Override // com.google.common.base.h
    public h b(String str) {
        throw new UnsupportedOperationException("already specified useForNull");
    }
}
