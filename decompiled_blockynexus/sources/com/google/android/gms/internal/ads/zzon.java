package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzon {
    public final int flags;
    public final long position;
    public final Uri uri;
    public final byte[] zzbic;
    public final long zzbid;
    public final String zzcn;
    public final long zzcp;

    public zzon(Uri uri) {
        this(uri, 0);
    }

    public final boolean isFlagSet(int i) {
        return (this.flags & 1) == 1;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.uri);
        String string = Arrays.toString(this.zzbic);
        long j = this.zzbid;
        long j2 = this.position;
        long j3 = this.zzcp;
        String str = this.zzcn;
        int i = this.flags;
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 93 + String.valueOf(string).length() + String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(string);
        sb.append(", ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(str);
        sb.append(", ");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }

    private zzon(Uri uri, int i) {
        this(uri, 0L, -1L, null, 0);
    }

    public zzon(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
    }

    private zzon(Uri uri, long j, long j2, String str, int i) {
        this(uri, 0L, 0L, -1L, null, 0);
    }

    private zzon(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    public zzon(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        boolean z = true;
        zzoz.checkArgument(j >= 0);
        zzoz.checkArgument(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        zzoz.checkArgument(z);
        this.uri = uri;
        this.zzbic = bArr;
        this.zzbid = j;
        this.position = j2;
        this.zzcp = j3;
        this.zzcn = str;
        this.flags = i;
    }
}
