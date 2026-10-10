package com.getkeepsafe.relinker.a;

import com.getkeepsafe.relinker.a.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: Elf32Header.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends c.b {
    private final f j;

    public d(boolean z, f fVar) throws IOException {
        this.f12498a = z;
        this.j = fVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f12499b = fVar.b(byteBufferAllocate, 16L);
        this.f12500c = fVar.e(byteBufferAllocate, 28L);
        this.f12501d = fVar.e(byteBufferAllocate, 32L);
        this.f12502e = fVar.b(byteBufferAllocate, 42L);
        this.f12503f = fVar.b(byteBufferAllocate, 44L);
        this.g = fVar.b(byteBufferAllocate, 46L);
        this.h = fVar.b(byteBufferAllocate, 48L);
        this.i = fVar.b(byteBufferAllocate, 50L);
    }

    @Override // com.getkeepsafe.relinker.a.c.b
    public c.d a(int i) throws IOException {
        return new i(this.j, this, i);
    }

    @Override // com.getkeepsafe.relinker.a.c.b
    public c.AbstractC0098c a(long j) throws IOException {
        return new g(this.j, this, j);
    }

    @Override // com.getkeepsafe.relinker.a.c.b
    public c.a a(long j, int i) throws IOException {
        return new a(this.j, this, j, i);
    }
}
