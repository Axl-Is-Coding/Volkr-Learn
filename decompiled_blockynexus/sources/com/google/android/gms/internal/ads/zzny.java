package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzny {
    public final int viewportHeight;
    public final int viewportWidth;
    public final String zzbhc;
    public final String zzbhd;
    public final boolean zzbhe;
    public final boolean zzbhf;
    public final int zzbhg;
    public final int zzbhh;
    public final int zzbhi;
    public final boolean zzbhj;
    public final boolean zzbhk;
    public final boolean zzbhl;

    public zzny() {
        this(null, null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzny.class == obj.getClass()) {
            zzny zznyVar = (zzny) obj;
            if (this.zzbhf == zznyVar.zzbhf && this.zzbhg == zznyVar.zzbhg && this.zzbhh == zznyVar.zzbhh && this.zzbhj == zznyVar.zzbhj && this.zzbhk == zznyVar.zzbhk && this.zzbhl == zznyVar.zzbhl && this.viewportWidth == zznyVar.viewportWidth && this.viewportHeight == zznyVar.viewportHeight && this.zzbhi == zznyVar.zzbhi && TextUtils.equals(null, null) && TextUtils.equals(null, null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = null;
        return (((((((((((((((((((str.hashCode() * 31) + str.hashCode()) * 31 * 31) + (this.zzbhf ? 1 : 0)) * 31) + this.zzbhg) * 31) + this.zzbhh) * 31) + this.zzbhi) * 31) + (this.zzbhj ? 1 : 0)) * 31) + (this.zzbhk ? 1 : 0)) * 31) + (this.zzbhl ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight;
    }

    private zzny(String str, String str2, boolean z, boolean z2, int i, int i2, int i3, boolean z3, boolean z4, int i4, int i5, boolean z5) {
        this.zzbhc = null;
        this.zzbhd = null;
        this.zzbhe = false;
        this.zzbhf = true;
        this.zzbhg = Integer.MAX_VALUE;
        this.zzbhh = Integer.MAX_VALUE;
        this.zzbhi = Integer.MAX_VALUE;
        this.zzbhj = true;
        this.zzbhk = true;
        this.viewportWidth = Integer.MAX_VALUE;
        this.viewportHeight = Integer.MAX_VALUE;
        this.zzbhl = true;
    }
}
