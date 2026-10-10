package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzmt {
    private final zzjx zzarj;
    private final zzjv[] zzben;
    private zzjv zzbeo;

    public zzmt(zzjv[] zzjvVarArr, zzjx zzjxVar) {
        this.zzben = zzjvVarArr;
        this.zzarj = zzjxVar;
    }

    public final void release() {
        zzjv zzjvVar = this.zzbeo;
        if (zzjvVar != null) {
            zzjvVar.release();
            this.zzbeo = null;
        }
    }

    public final zzjv zza(zzjy zzjyVar, Uri uri) throws InterruptedException, IOException {
        zzjv zzjvVar = this.zzbeo;
        if (zzjvVar != null) {
            return zzjvVar;
        }
        zzjv[] zzjvVarArr = this.zzben;
        int length = zzjvVarArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zzjv zzjvVar2 = zzjvVarArr[i];
            try {
                if (zzjvVar2.zza(zzjyVar)) {
                    this.zzbeo = zzjvVar2;
                    break;
                }
            } catch (EOFException unused) {
            } finally {
                zzjyVar.zzgq();
            }
            i++;
        }
        zzjv zzjvVar3 = this.zzbeo;
        if (zzjvVar3 != null) {
            zzjvVar3.zza(this.zzarj);
            return this.zzbeo;
        }
        String strZza = zzpq.zza(this.zzben);
        StringBuilder sb = new StringBuilder(String.valueOf(strZza).length() + 58);
        sb.append("None of the available extractors (");
        sb.append(strZza);
        sb.append(") could read the stream.");
        throw new zzns(sb.toString(), uri);
    }
}
