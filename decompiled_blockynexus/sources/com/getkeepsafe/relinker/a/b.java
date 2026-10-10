package com.getkeepsafe.relinker.a;

import com.getkeepsafe.relinker.a.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: Dynamic64Structure.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends c.a {
    public b(f fVar, c.b bVar, long j, int i) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(bVar.f12498a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + ((long) (i * 16));
        this.f12496a = fVar.c(byteBufferAllocate, j2);
        this.f12497b = fVar.c(byteBufferAllocate, j2 + 8);
    }
}
