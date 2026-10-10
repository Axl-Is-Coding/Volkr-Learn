package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdbo implements zzdgx<zzdbp> {
    private final zzdok zzfsk;
    private final zzdzb zzguy;
    private final View zzguz;
    private final Context zzvr;

    public zzdbo(zzdzb zzdzbVar, Context context, zzdok zzdokVar, ViewGroup viewGroup) {
        this.zzguy = zzdzbVar;
        this.zzvr = context;
        this.zzfsk = zzdokVar;
        this.zzguz = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdbp> zzarj() {
        return this.zzguy.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdbr
            private final zzdbo zzgvc;

            {
                this.zzgvc = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgvc.zzark();
            }
        });
    }

    final /* synthetic */ zzdbp zzark() throws Exception {
        Context context = this.zzvr;
        zzvn zzvnVar = this.zzfsk.zzbpf;
        ArrayList arrayList = new ArrayList();
        View view = this.zzguz;
        while (view != null) {
            Object parent = view.getParent();
            if (parent == null) {
                break;
            }
            int iIndexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", iIndexOfChild);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzdbp(context, zzvnVar, arrayList);
    }
}
