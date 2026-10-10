package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcjv {
    private final zzawl zzbog;
    private final zzeg zzeom;
    private final Executor zzfoc;
    private final zzbvh zzfsg;
    private final zzbwa zzfwy;
    private final zzbuc zzfxw;
    private final zzbmu zzfxx;
    private final zzcae zzfxz;
    private final zzbvv zzges;
    private final zzbyf zzget;
    private final com.google.android.gms.ads.internal.zza zzgfi;
    private final zzbvb zzgfj;
    private final zzbxu zzgfk;

    public zzcjv(zzbuc zzbucVar, zzbvh zzbvhVar, zzbvv zzbvvVar, zzbwa zzbwaVar, zzbyf zzbyfVar, Executor executor, zzcae zzcaeVar, zzbmu zzbmuVar, com.google.android.gms.ads.internal.zza zzaVar, zzbvb zzbvbVar, zzawl zzawlVar, zzeg zzegVar, zzbxu zzbxuVar) {
        this.zzfxw = zzbucVar;
        this.zzfsg = zzbvhVar;
        this.zzges = zzbvvVar;
        this.zzfwy = zzbwaVar;
        this.zzget = zzbyfVar;
        this.zzfoc = executor;
        this.zzfxz = zzcaeVar;
        this.zzfxx = zzbmuVar;
        this.zzgfi = zzaVar;
        this.zzgfj = zzbvbVar;
        this.zzbog = zzawlVar;
        this.zzeom = zzegVar;
        this.zzgfk = zzbxuVar;
    }

    public static zzdzc<?> zza(zzbgj zzbgjVar, String str, String str2) {
        final zzbcg zzbcgVar = new zzbcg();
        zzbgjVar.zzabw().zza(new zzbhu(zzbcgVar) { // from class: com.google.android.gms.internal.ads.zzckg
            private final zzbcg zzbvu;

            {
                this.zzbvu = zzbcgVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbhu
            public final void zzai(boolean z) {
                zzbcg zzbcgVar2 = this.zzbvu;
                if (z) {
                    zzbcgVar2.set(null);
                } else {
                    zzbcgVar2.setException(new Exception("Ad Web View failed to load."));
                }
            }
        });
        zzbgjVar.zzb(str, str2, null);
        return zzbcgVar;
    }

    final /* synthetic */ void zzae(View view) {
        this.zzgfi.recordClick();
        zzawl zzawlVar = this.zzbog;
        if (zzawlVar != null) {
            zzawlVar.zzvs();
        }
    }

    final /* synthetic */ void zzaoa() {
        this.zzfsg.onAdLeftApplication();
    }

    final /* synthetic */ void zzaob() {
        this.zzfxw.onAdClicked();
    }

    public final void zzb(final zzbgj zzbgjVar, boolean z) {
        zzdw zzdwVarZzca;
        zzbgjVar.zzabw().zza(new zzux(this) { // from class: com.google.android.gms.internal.ads.zzcjy
            private final zzcjv zzgfm;

            {
                this.zzgfm = this;
            }

            @Override // com.google.android.gms.internal.ads.zzux
            public final void onAdClicked() {
                this.zzgfm.zzaob();
            }
        }, this.zzges, this.zzfwy, new zzagv(this) { // from class: com.google.android.gms.internal.ads.zzcjx
            private final zzcjv zzgfm;

            {
                this.zzgfm = this;
            }

            @Override // com.google.android.gms.internal.ads.zzagv
            public final void onAppEvent(String str, String str2) {
                this.zzgfm.zzp(str, str2);
            }
        }, new com.google.android.gms.ads.internal.overlay.zzv(this) { // from class: com.google.android.gms.internal.ads.zzcka
            private final zzcjv zzgfm;

            {
                this.zzgfm = this;
            }

            @Override // com.google.android.gms.ads.internal.overlay.zzv
            public final void zzvd() {
                this.zzgfm.zzaoa();
            }
        }, z, null, this.zzgfi, new zzckf(this), this.zzbog);
        zzbgjVar.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.google.android.gms.internal.ads.zzcjz
            private final zzcjv zzgfm;

            {
                this.zzgfm = this;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.zzgfm.zza(view, motionEvent);
            }
        });
        zzbgjVar.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.gms.internal.ads.zzckc
            private final zzcjv zzgfm;

            {
                this.zzgfm = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.zzgfm.zzae(view);
            }
        });
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcqx)).booleanValue() && (zzdwVarZzca = this.zzeom.zzca()) != null) {
            zzdwVarZzca.zzb(zzbgjVar.getView());
        }
        this.zzfxz.zza(zzbgjVar, this.zzfoc);
        this.zzfxz.zza(new zzqu(zzbgjVar) { // from class: com.google.android.gms.internal.ads.zzckb
            private final zzbgj zzeqk;

            {
                this.zzeqk = zzbgjVar;
            }

            @Override // com.google.android.gms.internal.ads.zzqu
            public final void zza(zzqr zzqrVar) {
                zzbhv zzbhvVarZzabw = this.zzeqk.zzabw();
                Rect rect = zzqrVar.zzbru;
                zzbhvVarZzabw.zza(rect.left, rect.top, false);
            }
        }, this.zzfoc);
        this.zzfxz.zzv(zzbgjVar.getView());
        zzbgjVar.zza("/trackActiveViewUnit", new zzahq(this, zzbgjVar) { // from class: com.google.android.gms.internal.ads.zzcke
            private final zzbgj zzgci;
            private final zzcjv zzgfm;

            {
                this.zzgfm = this;
                this.zzgci = zzbgjVar;
            }

            @Override // com.google.android.gms.internal.ads.zzahq
            public final void zza(Object obj, Map map) {
                this.zzgfm.zza(this.zzgci, (zzbgj) obj, map);
            }
        });
        this.zzfxx.zzo(zzbgjVar);
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcoh)).booleanValue()) {
            return;
        }
        zzbvb zzbvbVar = this.zzgfj;
        zzbgjVar.getClass();
        zzbvbVar.zza(zzckd.zzn(zzbgjVar), this.zzfoc);
    }

    final /* synthetic */ void zzp(String str, String str2) {
        this.zzget.onAppEvent(str, str2);
    }

    final /* synthetic */ void zza(zzbgj zzbgjVar, zzbgj zzbgjVar2, Map map) {
        this.zzfxx.zzf(zzbgjVar);
    }

    final /* synthetic */ boolean zza(View view, MotionEvent motionEvent) {
        this.zzgfi.recordClick();
        zzawl zzawlVar = this.zzbog;
        if (zzawlVar == null) {
            return false;
        }
        zzawlVar.zzvs();
        return false;
    }
}
