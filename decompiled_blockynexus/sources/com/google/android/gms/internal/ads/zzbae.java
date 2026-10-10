package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbae {
    public final int count;
    public final String name;
    private final double zzecj;
    private final double zzeck;
    public final double zzecl;

    public zzbae(String str, double d2, double d3, double d4, int i) {
        this.name = str;
        this.zzeck = d2;
        this.zzecj = d3;
        this.zzecl = d4;
        this.count = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbae)) {
            return false;
        }
        zzbae zzbaeVar = (zzbae) obj;
        return Objects.equal(this.name, zzbaeVar.name) && this.zzecj == zzbaeVar.zzecj && this.zzeck == zzbaeVar.zzeck && this.count == zzbaeVar.count && Double.compare(this.zzecl, zzbaeVar.zzecl) == 0;
    }

    public final int hashCode() {
        return Objects.hashCode(this.name, Double.valueOf(this.zzecj), Double.valueOf(this.zzeck), Double.valueOf(this.zzecl), Integer.valueOf(this.count));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("name", this.name).add("minBound", Double.valueOf(this.zzeck)).add("maxBound", Double.valueOf(this.zzecj)).add("percent", Double.valueOf(this.zzecl)).add("count", Integer.valueOf(this.count)).toString();
    }
}
