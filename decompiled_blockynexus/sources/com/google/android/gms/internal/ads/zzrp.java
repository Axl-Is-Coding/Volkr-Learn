package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzrp {
    private final int zzbua;
    private final zzrq zzbuc = new zzrt();
    private final int zzbtz = 6;
    private final int zzbub = 0;

    public zzrp(int i) {
        this.zzbua = i;
    }

    @VisibleForTesting
    private final String zzbt(String str) {
        String[] strArrSplit = str.split(UMCustomLogInfoBuilder.LINE_SEP);
        if (strArrSplit.length == 0) {
            return "";
        }
        zzrr zzrrVar = new zzrr();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzbua, new zzrs(this));
        for (String str2 : strArrSplit) {
            String[] strArrZze = zzru.zze(str2, false);
            if (strArrZze.length != 0) {
                zzrv.zza(strArrZze, this.zzbua, this.zzbtz, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzrrVar.write(this.zzbuc.zzbu(((zzry) it.next()).zzbuj));
            } catch (IOException e2) {
                zzbbq.zzc("Error while writing hash to byteStream", e2);
            }
        }
        return zzrrVar.toString();
    }

    public final String zza(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            String str = arrayList.get(i);
            i++;
            sb.append(str.toLowerCase(Locale.US));
            sb.append('\n');
        }
        return zzbt(sb.toString());
    }
}
