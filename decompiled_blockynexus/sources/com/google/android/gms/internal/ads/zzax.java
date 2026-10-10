package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzax {
    long zzcm;
    final String zzcn;
    final String zzr;
    final long zzs;
    final long zzt;
    final long zzu;
    final long zzv;
    final List<zzu> zzx;

    private zzax(String str, String str2, long j, long j2, long j3, long j4, List<zzu> list) {
        this.zzcn = str;
        this.zzr = "".equals(str2) ? null : str2;
        this.zzs = j;
        this.zzt = j2;
        this.zzu = j3;
        this.zzv = j4;
        this.zzx = list;
    }

    static zzax zzc(zzba zzbaVar) throws IOException {
        if (zzav.zzb((InputStream) zzbaVar) == 538247942) {
            return new zzax(zzav.zza(zzbaVar), zzav.zza(zzbaVar), zzav.zzc(zzbaVar), zzav.zzc(zzbaVar), zzav.zzc(zzbaVar), zzav.zzc(zzbaVar), zzav.zzb(zzbaVar));
        }
        throw new IOException();
    }

    final boolean zza(OutputStream outputStream) {
        try {
            zzav.zza(outputStream, 538247942);
            zzav.zza(outputStream, this.zzcn);
            zzav.zza(outputStream, this.zzr == null ? "" : this.zzr);
            zzav.zza(outputStream, this.zzs);
            zzav.zza(outputStream, this.zzt);
            zzav.zza(outputStream, this.zzu);
            zzav.zza(outputStream, this.zzv);
            List<zzu> list = this.zzx;
            if (list != null) {
                zzav.zza(outputStream, list.size());
                for (zzu zzuVar : list) {
                    zzav.zza(outputStream, zzuVar.getName());
                    zzav.zza(outputStream, zzuVar.getValue());
                }
            } else {
                zzav.zza(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e2) {
            zzaq.d("%s", e2.toString());
            return false;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    zzax(String str, zzn zznVar) {
        String str2 = zznVar.zzr;
        long j = zznVar.zzs;
        long j2 = zznVar.zzt;
        long j3 = zznVar.zzu;
        long j4 = zznVar.zzv;
        List arrayList = zznVar.zzx;
        if (arrayList == null) {
            Map<String, String> map = zznVar.zzw;
            arrayList = new ArrayList(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new zzu(entry.getKey(), entry.getValue()));
            }
        }
        this(str, str2, j, j2, j3, j4, arrayList);
    }
}
