package com.getkeepsafe.relinker.a;

import com.getkeepsafe.relinker.a.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: Elf64Header.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends c.b {
    private final f j;

    public e(boolean z, f fVar) throws IOException {
        this.f12498a = z;
        this.j = fVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f12499b = fVar.b(byteBufferAllocate, 16L);
        this.f12500c = fVar.c(byteBufferAllocate, 32L);
        this.f12501d = fVar.c(byteBufferAllocate, 40L);
        this.f12502e = fVar.b(byteBufferAllocate, 54L);
        this.f12503f = fVar.b(byteBufferAllocate, 56L);
        this.g = fVar.b(byteBufferAllocate, 58L);
        this.h = fVar.b(byteBufferAllocate, 60L);
        this.i = fVar.b(byteBufferAllocate, 62L);
    }

    @Override // com.getkeepsafe.relinker.a.c.b
    public c.d a(int i) throws IOException {
        return new j(this.j, this, i);
    }

    @Override // com.getkeepsafe.relinker.a.c.b
    public c.AbstractC0098c a(long j) throws IOException {
        return new h(this.j, this, j);
    }

    @Override // com.getkeepsafe.relinker.a.c.b
    public c.a a(long j, int i) throws IOException {
        return new b(this.j, this, j, i);
    }
}
