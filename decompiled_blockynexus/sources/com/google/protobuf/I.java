package com.google.protobuf;

import com.google.protobuf.J;

/* JADX INFO: compiled from: TextFormatEscaper.java */
/* JADX INFO: loaded from: classes2.dex */
class I implements J.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ByteString f14313a;

    I(ByteString byteString) {
        this.f14313a = byteString;
    }

    @Override // com.google.protobuf.J.a
    public byte a(int i) {
        return this.f14313a.byteAt(i);
    }

    @Override // com.google.protobuf.J.a
    public int size() {
        return this.f14313a.size();
    }
}
