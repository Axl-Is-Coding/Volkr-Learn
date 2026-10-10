package com.bytedance.sdk.a.b;

import java.io.IOException;

/* JADX INFO: compiled from: RequestBody.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class z {
    public static z a(u uVar, byte[] bArr) {
        return a(uVar, bArr, 0, bArr.length);
    }

    public abstract u a();

    public abstract void a(com.bytedance.sdk.a.a.d dVar) throws IOException;

    public long b() throws IOException {
        return -1L;
    }

    public static z a(final u uVar, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        com.bytedance.sdk.a.b.a.c.a(bArr.length, i, i2);
        return new z() { // from class: com.bytedance.sdk.a.b.z.1
            @Override // com.bytedance.sdk.a.b.z
            public u a() {
                return uVar;
            }

            @Override // com.bytedance.sdk.a.b.z
            public long b() {
                return i2;
            }

            @Override // com.bytedance.sdk.a.b.z
            public void a(com.bytedance.sdk.a.a.d dVar) throws IOException {
                dVar.c(bArr, i, i2);
            }
        };
    }
}
