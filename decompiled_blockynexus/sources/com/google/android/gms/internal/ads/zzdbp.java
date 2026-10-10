package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdbp implements zzdgu<Bundle> {
    private final zzvn zzbpf;
    private final List<Parcelable> zzgva;
    private final Context zzvr;

    public zzdbp(Context context, zzvn zzvnVar, List<Parcelable> list) {
        this.zzvr = context;
        this.zzbpf = zzvnVar;
        this.zzgva = list;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (zzacy.zzdbw.get().booleanValue()) {
            Bundle bundle3 = new Bundle();
            com.google.android.gms.ads.internal.zzp.zzkr();
            bundle3.putString("activity", zzayu.zzau(this.zzvr));
            Bundle bundle4 = new Bundle();
            bundle4.putInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.zzbpf.width);
            bundle4.putInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.zzbpf.height);
            bundle3.putBundle("size", bundle4);
            if (this.zzgva.size() > 0) {
                List<Parcelable> list = this.zzgva;
                bundle3.putParcelableArray("parents", (Parcelable[]) list.toArray(new Parcelable[list.size()]));
            }
            bundle2.putBundle("view_hierarchy", bundle3);
        }
    }
}
