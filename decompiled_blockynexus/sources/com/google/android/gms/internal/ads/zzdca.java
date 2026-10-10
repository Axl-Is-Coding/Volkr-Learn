package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdca implements zzdgx<zzdcb> {
    private final zzayb zzbpw;
    private final zzdok zzfsk;
    private final zzdgx<zzdha> zzgvf;
    private final Context zzvr;

    public zzdca(zzddp<zzdha> zzddpVar, zzdok zzdokVar, Context context, zzayb zzaybVar) {
        this.zzgvf = zzddpVar;
        this.zzfsk = zzdokVar;
        this.zzvr = context;
        this.zzbpw = zzaybVar;
    }

    final /* synthetic */ zzdcb zza(zzdha zzdhaVar) {
        String str;
        boolean z;
        String strZzxq;
        float f2;
        int i;
        int i2;
        int i3;
        DisplayMetrics displayMetrics;
        zzvn zzvnVar = this.zzfsk.zzbpf;
        zzvn[] zzvnVarArr = zzvnVar.zzchu;
        if (zzvnVarArr != null) {
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (zzvn zzvnVar2 : zzvnVarArr) {
                if (!zzvnVar2.zzchv && !z2) {
                    str = zzvnVar2.zzacy;
                    z2 = true;
                }
                if (zzvnVar2.zzchv && !z3) {
                    z3 = true;
                    z = true;
                }
                if (z2 && z3) {
                    break;
                }
            }
        } else {
            str = zzvnVar.zzacy;
            z = zzvnVar.zzchv;
        }
        Resources resources = this.zzvr.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            strZzxq = null;
            f2 = WheelView.DividerConfig.FILL;
            i = 0;
            i2 = 0;
        } else {
            float f3 = displayMetrics.density;
            int i4 = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
            strZzxq = this.zzbpw.zzwt().zzxq();
            i = i4;
            f2 = f3;
        }
        StringBuilder sb = new StringBuilder();
        zzvn[] zzvnVarArr2 = zzvnVar.zzchu;
        if (zzvnVarArr2 != null) {
            boolean z4 = false;
            for (zzvn zzvnVar3 : zzvnVarArr2) {
                if (zzvnVar3.zzchv) {
                    z4 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    sb.append((zzvnVar3.width != -1 || f2 == WheelView.DividerConfig.FILL) ? zzvnVar3.width : (int) (zzvnVar3.widthPixels / f2));
                    sb.append("x");
                    sb.append((zzvnVar3.height != -2 || f2 == WheelView.DividerConfig.FILL) ? zzvnVar3.height : (int) (zzvnVar3.heightPixels / f2));
                }
            }
            if (z4) {
                if (sb.length() != 0) {
                    i3 = 0;
                    sb.insert(0, "|");
                } else {
                    i3 = 0;
                }
                sb.insert(i3, "320x50");
            }
        }
        return new zzdcb(zzvnVar, str, z, sb.toString(), f2, i, i2, strZzxq, this.zzfsk.zzgvi);
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdcb> zzarj() {
        return zzdyq.zzb(this.zzgvf.zzarj(), new zzdvu(this) { // from class: com.google.android.gms.internal.ads.zzdcd
            private final zzdca zzgvk;

            {
                this.zzgvk = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdvu
            public final Object apply(Object obj) {
                return this.zzgvk.zza((zzdha) obj);
            }
        }, zzbbz.zzeeu);
    }
}
