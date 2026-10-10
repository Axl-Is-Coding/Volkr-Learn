package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdcb implements zzdgu<Bundle> {
    private final String zzacy;
    private final zzvn zzbpf;
    private final float zzbsa;
    private final boolean zzchv;
    private final int zzdoc;
    private final int zzdod;
    private final String zzgvg;
    private final String zzgvh;
    private final boolean zzgvi;

    public zzdcb(zzvn zzvnVar, String str, boolean z, String str2, float f2, int i, int i2, String str3, boolean z2) {
        Preconditions.checkNotNull(zzvnVar, "the adSize must not be null");
        this.zzbpf = zzvnVar;
        this.zzacy = str;
        this.zzchv = z;
        this.zzgvg = str2;
        this.zzbsa = f2;
        this.zzdoc = i;
        this.zzdod = i2;
        this.zzgvh = str3;
        this.zzgvi = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdot.zza(bundle2, "smart_w", MessengerShareContentUtility.WEBVIEW_RATIO_FULL, this.zzbpf.width == -1);
        zzdot.zza(bundle2, "smart_h", "auto", this.zzbpf.height == -2);
        zzdot.zza(bundle2, "ene", (Boolean) true, this.zzbpf.zzchw);
        zzdot.zza(bundle2, "rafmt", "102", this.zzbpf.zzchz);
        zzdot.zza(bundle2, "rafmt", "103", this.zzbpf.zzcia);
        zzdot.zza(bundle2, "inline_adaptive_slot", (Boolean) true, this.zzgvi);
        zzdot.zza(bundle2, "format", this.zzacy);
        zzdot.zza(bundle2, "fluid", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.zzchv);
        zzdot.zza(bundle2, "sz", this.zzgvg, !TextUtils.isEmpty(r0));
        bundle2.putFloat("u_sd", this.zzbsa);
        bundle2.putInt("sw", this.zzdoc);
        bundle2.putInt("sh", this.zzdod);
        String str = this.zzgvh;
        zzdot.zza(bundle2, "sc", str, true ^ TextUtils.isEmpty(str));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        zzvn[] zzvnVarArr = this.zzbpf.zzchu;
        if (zzvnVarArr == null) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.zzbpf.height);
            bundle3.putInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.zzbpf.width);
            bundle3.putBoolean("is_fluid_height", this.zzbpf.zzchv);
            arrayList.add(bundle3);
        } else {
            for (zzvn zzvnVar : zzvnVarArr) {
                Bundle bundle4 = new Bundle();
                bundle4.putBoolean("is_fluid_height", zzvnVar.zzchv);
                bundle4.putInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, zzvnVar.height);
                bundle4.putInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, zzvnVar.width);
                arrayList.add(bundle4);
            }
        }
        bundle2.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
