package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzemd implements Iterator<zzeiw> {
    private final ArrayDeque<zzemc> zzimu;
    private zzeiw zzimv;

    private zzemd(zzeip zzeipVar) {
        if (!(zzeipVar instanceof zzemc)) {
            this.zzimu = null;
            this.zzimv = (zzeiw) zzeipVar;
        } else {
            zzemc zzemcVar = (zzemc) zzeipVar;
            this.zzimu = new ArrayDeque<>(zzemcVar.zzbej());
            this.zzimu.push(zzemcVar);
            this.zzimv = zzak(zzemcVar.zzimq);
        }
    }

    private final zzeiw zzak(zzeip zzeipVar) {
        while (zzeipVar instanceof zzemc) {
            zzemc zzemcVar = (zzemc) zzeipVar;
            this.zzimu.push(zzemcVar);
            zzeipVar = zzemcVar.zzimq;
        }
        return (zzeiw) zzeipVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzimv != null;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ zzeiw next() {
        zzeiw zzeiwVarZzak;
        zzeiw zzeiwVar = this.zzimv;
        if (zzeiwVar == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque<zzemc> arrayDeque = this.zzimu;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                zzeiwVarZzak = null;
                break;
            }
            zzeiwVarZzak = zzak(this.zzimu.pop().zzimr);
        } while (zzeiwVarZzak.isEmpty());
        this.zzimv = zzeiwVarZzak;
        return zzeiwVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ zzemd(zzeip zzeipVar, zzemb zzembVar) {
        this(zzeipVar);
    }
}
