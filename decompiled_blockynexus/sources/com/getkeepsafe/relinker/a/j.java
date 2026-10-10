package com.getkeepsafe.relinker.a;

import com.getkeepsafe.relinker.a.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: Section64Header.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends c.d {
    public j(f fVar, c.b bVar, int i) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(bVar.f12498a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f12508a = fVar.e(byteBufferAllocate, bVar.f12501d + ((long) (i * bVar.g)) + 44);
    }
}
