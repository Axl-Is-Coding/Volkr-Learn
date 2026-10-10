package org.apache.commons.compress.a;

import java.io.DataInput;
import java.io.IOException;

/* JADX INFO: compiled from: ByteUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {
    public static long a(DataInput dataInput, int i) throws IOException {
        a(i);
        long unsignedByte = 0;
        for (int i2 = 0; i2 < i; i2++) {
            unsignedByte |= ((long) dataInput.readUnsignedByte()) << (i2 * 8);
        }
        return unsignedByte;
    }

    private static final void a(int i) {
        if (i > 8) {
            throw new IllegalArgumentException("can't read more than eight bytes into a long value");
        }
    }
}
