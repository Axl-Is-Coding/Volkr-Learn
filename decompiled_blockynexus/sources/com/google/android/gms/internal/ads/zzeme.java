package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeme {
    private final ArrayDeque<zzeip> zzimw;

    private zzeme() {
        this.zzimw = new ArrayDeque<>();
    }

    private final void zzal(zzeip zzeipVar) {
        zzemb zzembVar;
        while (!zzeipVar.zzbek()) {
            if (!(zzeipVar instanceof zzemc)) {
                String strValueOf = String.valueOf(zzeipVar.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(strValueOf);
                throw new IllegalArgumentException(sb.toString());
            }
            zzemc zzemcVar = (zzemc) zzeipVar;
            zzal(zzemcVar.zzimq);
            zzeipVar = zzemcVar.zzimr;
        }
        int iZzhn = zzhn(zzeipVar.size());
        int iZzhm = zzemc.zzhm(iZzhn + 1);
        if (this.zzimw.isEmpty() || this.zzimw.peek().size() >= iZzhm) {
            this.zzimw.push(zzeipVar);
            return;
        }
        int iZzhm2 = zzemc.zzhm(iZzhn);
        zzeip zzeipVarPop = this.zzimw.pop();
        while (true) {
            zzembVar = null;
            if (this.zzimw.isEmpty() || this.zzimw.peek().size() >= iZzhm2) {
                break;
            } else {
                zzeipVarPop = new zzemc(this.zzimw.pop(), zzeipVarPop, zzembVar);
            }
        }
        zzemc zzemcVar2 = new zzemc(zzeipVarPop, zzeipVar, zzembVar);
        while (!this.zzimw.isEmpty()) {
            if (this.zzimw.peek().size() >= zzemc.zzhm(zzhn(zzemcVar2.size()) + 1)) {
                break;
            } else {
                zzemcVar2 = new zzemc(this.zzimw.pop(), zzemcVar2, zzembVar);
            }
        }
        this.zzimw.push(zzemcVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzeip zzc(zzeip zzeipVar, zzeip zzeipVar2) {
        zzal(zzeipVar);
        zzal(zzeipVar2);
        zzeip zzeipVarPop = this.zzimw.pop();
        while (!this.zzimw.isEmpty()) {
            zzeipVarPop = new zzemc(this.zzimw.pop(), zzeipVarPop, null);
        }
        return zzeipVarPop;
    }

    private static int zzhn(int i) {
        int iBinarySearch = Arrays.binarySearch(zzemc.zzimo, i);
        return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
    }

    /* synthetic */ zzeme(zzemb zzembVar) {
        this();
    }
}
