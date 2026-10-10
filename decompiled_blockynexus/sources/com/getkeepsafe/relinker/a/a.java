package com.getkeepsafe.relinker.a;

import com.getkeepsafe.relinker.a.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: Dynamic32Structure.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends c.a {
    public a(f fVar, c.b bVar, long j, int i) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(bVar.f12498a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + ((long) (i * 8));
        this.f12496a = fVar.e(byteBufferAllocate, j2);
        this.f12497b = fVar.e(byteBufferAllocate, j2 + 4);
    }
}
