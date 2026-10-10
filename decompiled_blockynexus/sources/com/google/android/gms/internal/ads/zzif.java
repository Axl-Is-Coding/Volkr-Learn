package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public final class zzif {
    private static final zzif zzaiz = new zzif(new int[]{2}, 2);
    private final int[] zzaja;
    private final int zzajb;

    private zzif(int[] iArr, int i) {
        this.zzaja = Arrays.copyOf(iArr, iArr.length);
        Arrays.sort(this.zzaja);
        this.zzajb = 2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzif)) {
            return false;
        }
        zzif zzifVar = (zzif) obj;
        return Arrays.equals(this.zzaja, zzifVar.zzaja) && this.zzajb == zzifVar.zzajb;
    }

    public final int hashCode() {
        return this.zzajb + (Arrays.hashCode(this.zzaja) * 31);
    }

    public final String toString() {
        int i = this.zzajb;
        String string = Arrays.toString(this.zzaja);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }

    public final boolean zzw(int i) {
        return Arrays.binarySearch(this.zzaja, i) >= 0;
    }
}
