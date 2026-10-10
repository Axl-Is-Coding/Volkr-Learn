package com.google.common.io;

import com.google.common.base.m;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: ByteStreams.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f13975a = new byte[8192];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final OutputStream f13976b = new a();

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        m.a(inputStream);
        m.a(outputStream);
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += (long) i;
        }
    }
}
