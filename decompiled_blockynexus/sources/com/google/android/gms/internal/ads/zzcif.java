package com.google.android.gms.internal.ads;

import a.a.i;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcif extends zzaez {
    private final Context zzaai;
    private final zzcei zzfxu;
    private zzcdx zzgaw;
    private zzcfe zzgee;

    public zzcif(Context context, zzcei zzceiVar, zzcfe zzcfeVar, zzcdx zzcdxVar) {
        this.zzaai = context;
        this.zzfxu = zzceiVar;
        this.zzgee = zzcfeVar;
        this.zzgaw = zzcdxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final void destroy() {
        zzcdx zzcdxVar = this.zzgaw;
        if (zzcdxVar != null) {
            zzcdxVar.destroy();
        }
        this.zzgaw = null;
        this.zzgee = null;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final List<String> getAvailableAssetNames() {
        i<String, zzadq> iVarZzami = this.zzfxu.zzami();
        i<String, String> iVarZzamk = this.zzfxu.zzamk();
        String[] strArr = new String[iVarZzami.size() + iVarZzamk.size()];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < iVarZzami.size()) {
            strArr[i3] = iVarZzami.b(i2);
            i2++;
            i3++;
        }
        while (i < iVarZzamk.size()) {
            strArr[i3] = iVarZzamk.b(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final String getCustomTemplateId() {
        return this.zzfxu.getCustomTemplateId();
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final zzyo getVideoController() {
        return this.zzfxu.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final void performClick(String str) {
        zzcdx zzcdxVar = this.zzgaw;
        if (zzcdxVar != null) {
            zzcdxVar.zzfz(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final void recordImpression() {
        zzcdx zzcdxVar = this.zzgaw;
        if (zzcdxVar != null) {
            zzcdxVar.zzalp();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final String zzcx(String str) {
        return this.zzfxu.zzamk().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final zzaee zzcy(String str) {
        return this.zzfxu.zzami().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final boolean zzp(IObjectWrapper iObjectWrapper) {
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof ViewGroup)) {
            return false;
        }
        zzcfe zzcfeVar = this.zzgee;
        if (!(zzcfeVar != null && zzcfeVar.zza((ViewGroup) objUnwrap))) {
            return false;
        }
        this.zzfxu.zzamf().zza(new zzcii(this));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final void zzq(IObjectWrapper iObjectWrapper) {
        zzcdx zzcdxVar;
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof View) || this.zzfxu.zzamh() == null || (zzcdxVar = this.zzgaw) == null) {
            return;
        }
        zzcdxVar.zzaa((View) objUnwrap);
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final IObjectWrapper zzsk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final IObjectWrapper zzsp() {
        return ObjectWrapper.wrap(this.zzaai);
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final boolean zzsq() {
        zzcdx zzcdxVar = this.zzgaw;
        return (zzcdxVar == null || zzcdxVar.zzalw()) && this.zzfxu.zzamg() != null && this.zzfxu.zzamf() == null;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final boolean zzsr() {
        IObjectWrapper iObjectWrapperZzamh = this.zzfxu.zzamh();
        if (iObjectWrapperZzamh != null) {
            com.google.android.gms.ads.internal.zzp.zzlg().zzab(iObjectWrapperZzamh);
            return true;
        }
        zzbbq.zzfe("Trying to start OMID session before creation.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final void zzss() {
        String strZzamj = this.zzfxu.zzamj();
        if ("Google".equals(strZzamj)) {
            zzbbq.zzfe("Illegal argument specified for omid partner name.");
            return;
        }
        zzcdx zzcdxVar = this.zzgaw;
        if (zzcdxVar != null) {
            zzcdxVar.zzi(strZzamj, false);
        }
    }
}
