package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdql implements zzdqj {
    private final String zzcn;

    public zzdql(String str) {
        this.zzcn = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdqj
    public final boolean equals(Object obj) {
        if (obj instanceof zzdql) {
            return this.zzcn.equals(((zzdql) obj).zzcn);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdqj
    public final int hashCode() {
        return this.zzcn.hashCode();
    }

    public final String toString() {
        return this.zzcn;
    }
}
