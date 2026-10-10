package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.google.protobuf.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ByteString.java */
/* JADX INFO: loaded from: classes2.dex */
class C2300f implements ByteString.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14346a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ByteString f14348c;

    C2300f(ByteString byteString) {
        this.f14348c = byteString;
        this.f14347b = this.f14348c.size();
    }

    public byte a() {
        try {
            ByteString byteString = this.f14348c;
            int i = this.f14346a;
            this.f14346a = i + 1;
            return byteString.byteAt(i);
        } catch (IndexOutOfBoundsException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f14346a < this.f14347b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Byte next() {
        return Byte.valueOf(a());
    }
}
