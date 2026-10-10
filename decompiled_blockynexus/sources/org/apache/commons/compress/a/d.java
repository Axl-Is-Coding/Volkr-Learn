package org.apache.commons.compress.a;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: IOUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f23513a = new byte[4096];

    public static long a(InputStream inputStream, long j) throws IOException {
        int iA;
        long j2 = j;
        while (j2 > 0) {
            long jSkip = inputStream.skip(j2);
            if (jSkip == 0) {
                break;
            }
            j2 -= jSkip;
        }
        while (j2 > 0 && (iA = a(inputStream, f23513a, 0, (int) Math.min(j2, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM))) >= 1) {
            j2 -= (long) iA;
        }
        return j - j2;
    }

    public static int a(InputStream inputStream, byte[] bArr) throws IOException {
        return a(inputStream, bArr, 0, bArr.length);
    }

    public static int a(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        if (i2 < 0 || i < 0 || i2 + i > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = 0;
        while (i3 != i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }
}
