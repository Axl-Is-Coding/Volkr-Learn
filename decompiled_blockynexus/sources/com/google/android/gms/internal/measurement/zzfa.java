package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfa<E> extends zzej<E> {
    private final zzfb<E> zza;

    zzfa(zzfb<E> zzfbVar, int i) {
        super(zzfbVar.size(), i);
        this.zza = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzej
    protected final E zza(int i) {
        return this.zza.get(i);
    }
}
