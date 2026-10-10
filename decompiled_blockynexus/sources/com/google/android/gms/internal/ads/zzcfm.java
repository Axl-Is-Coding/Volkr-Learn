package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.view.View;
import fi.iki.elonen.NanoHTTPD;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcfm {
    private final zzceq zzfyt;
    private final zzcil zzgbo;
    private final zzcjt zzgbx;
    private final zzbnd zzgby;

    public zzcfm(zzcjt zzcjtVar, zzcil zzcilVar, zzbnd zzbndVar, zzceq zzceqVar) {
        this.zzgbx = zzcjtVar;
        this.zzgbo = zzcilVar;
        this.zzgby = zzbndVar;
        this.zzfyt = zzceqVar;
    }

    final /* synthetic */ void zza(zzbgj zzbgjVar, Map map) {
        zzbbq.zzfd("Hiding native ads overlay.");
        zzbgjVar.getView().setVisibility(8);
        this.zzgby.zzbf(false);
    }

    public final View zzanl() throws zzbgv {
        zzbgj zzbgjVarZzc = this.zzgbx.zzc(zzvn.zzpk());
        zzbgjVarZzc.getView().setVisibility(8);
        zzbgjVarZzc.zza("/sendMessageToSdk", new zzahq(this) { // from class: com.google.android.gms.internal.ads.zzcfl
            private final zzcfm zzgbw;

            {
                this.zzgbw = this;
            }

            @Override // com.google.android.gms.internal.ads.zzahq
            public final void zza(Object obj, Map map) {
                this.zzgbw.zzd((zzbgj) obj, map);
            }
        });
        zzbgjVarZzc.zza("/adMuted", new zzahq(this) { // from class: com.google.android.gms.internal.ads.zzcfo
            private final zzcfm zzgbw;

            {
                this.zzgbw = this;
            }

            @Override // com.google.android.gms.internal.ads.zzahq
            public final void zza(Object obj, Map map) {
                this.zzgbw.zzc((zzbgj) obj, map);
            }
        });
        this.zzgbo.zza(new WeakReference(zzbgjVarZzc), "/loadHtml", new zzahq(this) { // from class: com.google.android.gms.internal.ads.zzcfn
            private final zzcfm zzgbw;

            {
                this.zzgbw = this;
            }

            @Override // com.google.android.gms.internal.ads.zzahq
            public final void zza(Object obj, final Map map) {
                final zzcfm zzcfmVar = this.zzgbw;
                zzbgj zzbgjVar = (zzbgj) obj;
                zzbgjVar.zzabw().zza(new zzbhu(zzcfmVar, map) { // from class: com.google.android.gms.internal.ads.zzcfs
                    private final Map zzeei;
                    private final zzcfm zzgbw;

                    {
                        this.zzgbw = zzcfmVar;
                        this.zzeei = map;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbhu
                    public final void zzai(boolean z) {
                        this.zzgbw.zza(this.zzeei, z);
                    }
                });
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzbgjVar.loadData(str, NanoHTTPD.MIME_HTML, "UTF-8");
                } else {
                    zzbgjVar.loadDataWithBaseURL(str2, str, NanoHTTPD.MIME_HTML, "UTF-8", null);
                }
            }
        });
        this.zzgbo.zza(new WeakReference(zzbgjVarZzc), "/showOverlay", new zzahq(this) { // from class: com.google.android.gms.internal.ads.zzcfq
            private final zzcfm zzgbw;

            {
                this.zzgbw = this;
            }

            @Override // com.google.android.gms.internal.ads.zzahq
            public final void zza(Object obj, Map map) {
                this.zzgbw.zzb((zzbgj) obj, map);
            }
        });
        this.zzgbo.zza(new WeakReference(zzbgjVarZzc), "/hideOverlay", new zzahq(this) { // from class: com.google.android.gms.internal.ads.zzcfp
            private final zzcfm zzgbw;

            {
                this.zzgbw = this;
            }

            @Override // com.google.android.gms.internal.ads.zzahq
            public final void zza(Object obj, Map map) {
                this.zzgbw.zza((zzbgj) obj, map);
            }
        });
        return zzbgjVarZzc.getView();
    }

    final /* synthetic */ void zzb(zzbgj zzbgjVar, Map map) {
        zzbbq.zzfd("Showing native ads overlay.");
        zzbgjVar.getView().setVisibility(0);
        this.zzgby.zzbf(true);
    }

    final /* synthetic */ void zzc(zzbgj zzbgjVar, Map map) {
        this.zzfyt.zzalq();
    }

    final /* synthetic */ void zzd(zzbgj zzbgjVar, Map map) {
        this.zzgbo.zza("sendMessageToNativeJs", (Map<String, ?>) map);
    }

    final /* synthetic */ void zza(Map map, boolean z) {
        HashMap map2 = new HashMap();
        map2.put("messageType", "htmlLoaded");
        map2.put("id", (String) map.get("id"));
        this.zzgbo.zza("sendMessageToNativeJs", map2);
    }
}
