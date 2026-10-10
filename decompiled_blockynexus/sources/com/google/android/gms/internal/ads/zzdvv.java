package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdvv {
    private final String className;
    private final zzdvy zzhoy;
    private zzdvy zzhoz;
    private boolean zzhpa;

    private zzdvv(String str) {
        this.zzhoy = new zzdvy();
        this.zzhoz = this.zzhoy;
        this.zzhpa = false;
        zzdwd.checkNotNull(str);
        this.className = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.className);
        sb.append('{');
        zzdvy zzdvyVar = this.zzhoy.zzhpb;
        String str = "";
        while (zzdvyVar != null) {
            Object obj = zzdvyVar.value;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String strDeepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
            }
            zzdvyVar = zzdvyVar.zzhpb;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzdvv zzy(Object obj) {
        zzdvy zzdvyVar = new zzdvy();
        this.zzhoz.zzhpb = zzdvyVar;
        this.zzhoz = zzdvyVar;
        zzdvyVar.value = obj;
        return this;
    }
}
