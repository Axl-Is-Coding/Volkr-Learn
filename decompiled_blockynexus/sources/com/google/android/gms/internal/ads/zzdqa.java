package com.google.android.gms.internal.ads;

import java.util.LinkedList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdqa {
    private final int maxEntries;
    private final int zzhhb;
    private final LinkedList<zzdqk<?>> zzhha = new LinkedList<>();
    private final zzdqx zzhhc = new zzdqx();

    public zzdqa(int i, int i2) {
        this.maxEntries = i;
        this.zzhhb = i2;
    }

    private final void zzaue() {
        while (!this.zzhha.isEmpty()) {
            if (!(com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis() - this.zzhha.getFirst().zzhis >= ((long) this.zzhhb))) {
                return;
            }
            this.zzhhc.zzauw();
            this.zzhha.remove();
        }
    }

    public final long getCreationTimeMillis() {
        return this.zzhhc.getCreationTimeMillis();
    }

    public final int size() {
        zzaue();
        return this.zzhha.size();
    }

    public final zzdqk<?> zzatz() {
        this.zzhhc.zzauu();
        zzaue();
        if (this.zzhha.isEmpty()) {
            return null;
        }
        zzdqk<?> zzdqkVarRemove = this.zzhha.remove();
        if (zzdqkVarRemove != null) {
            this.zzhhc.zzauv();
        }
        return zzdqkVarRemove;
    }

    public final long zzaua() {
        return this.zzhhc.zzaua();
    }

    public final int zzaub() {
        return this.zzhhc.zzaub();
    }

    public final String zzauc() {
        return this.zzhhc.zzaum();
    }

    public final zzdra zzaud() {
        return this.zzhhc.zzaux();
    }

    public final boolean zzb(zzdqk<?> zzdqkVar) {
        this.zzhhc.zzauu();
        zzaue();
        if (this.zzhha.size() == this.maxEntries) {
            return false;
        }
        this.zzhha.add(zzdqkVar);
        return true;
    }
}
