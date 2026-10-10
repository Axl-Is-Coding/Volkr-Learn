package com.getkeepsafe.relinker.a;

import com.getkeepsafe.relinker.a.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: Program32Header.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends c.AbstractC0098c {
    public g(f fVar, c.b bVar, long j) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(bVar.f12498a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = bVar.f12500c + (j * ((long) bVar.f12502e));
        this.f12504a = fVar.e(byteBufferAllocate, j2);
        this.f12505b = fVar.e(byteBufferAllocate, 4 + j2);
        this.f12506c = fVar.e(byteBufferAllocate, 8 + j2);
        this.f12507d = fVar.e(byteBufferAllocate, j2 + 20);
    }
}
