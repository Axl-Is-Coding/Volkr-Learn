package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcdx extends zzbqo {
    private final zzbbx zzbpe;
    private final zzeg zzeom;
    private final Executor zzfoc;
    private final zzcep zzfqc;
    private final zzawp zzfrn;
    private final zzczn zzfvj;
    private final zzcei zzfxu;
    private final zzceq zzfyt;
    private final zzcfe zzfyu;
    private final zzcem zzfyv;
    private final zzeos<zzcid> zzfyw;
    private final zzeos<zzcib> zzfyx;
    private final zzeos<zzcik> zzfyy;
    private final zzeos<zzchx> zzfyz;
    private final zzeos<zzcif> zzfza;
    private zzcgc zzfzb;
    private boolean zzfzc;
    private boolean zzfzd;
    private final zzced zzfze;
    private final Context zzvr;

    public zzcdx(zzbqn zzbqnVar, Executor executor, zzcei zzceiVar, zzceq zzceqVar, zzcfe zzcfeVar, zzcem zzcemVar, zzcep zzcepVar, zzeos<zzcid> zzeosVar, zzeos<zzcib> zzeosVar2, zzeos<zzcik> zzeosVar3, zzeos<zzchx> zzeosVar4, zzeos<zzcif> zzeosVar5, zzawp zzawpVar, zzeg zzegVar, zzbbx zzbbxVar, Context context, zzced zzcedVar, zzczn zzcznVar) {
        super(zzbqnVar);
        this.zzfzd = false;
        this.zzfoc = executor;
        this.zzfxu = zzceiVar;
        this.zzfyt = zzceqVar;
        this.zzfyu = zzcfeVar;
        this.zzfyv = zzcemVar;
        this.zzfqc = zzcepVar;
        this.zzfyw = zzeosVar;
        this.zzfyx = zzeosVar2;
        this.zzfyy = zzeosVar3;
        this.zzfyz = zzeosVar4;
        this.zzfza = zzeosVar5;
        this.zzfrn = zzawpVar;
        this.zzeom = zzegVar;
        this.zzbpe = zzbbxVar;
        this.zzvr = context;
        this.zzfze = zzcedVar;
        this.zzfvj = zzcznVar;
    }

    public static boolean zzz(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), null);
    }

    public final synchronized void cancelUnconfirmedClick() {
        this.zzfyt.cancelUnconfirmedClick();
    }

    @Override // com.google.android.gms.internal.ads.zzbqo
    public final synchronized void destroy() {
        this.zzfoc.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcec
            private final zzcdx zzfzg;

            {
                this.zzfzg = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfzg.zzaly();
            }
        });
        super.destroy();
    }

    public final synchronized boolean isCustomClickGestureEnabled() {
        return this.zzfyt.isCustomClickGestureEnabled();
    }

    public final synchronized void recordCustomClickGesture() {
        if (this.zzfzb == null) {
            zzbbq.zzef("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            final boolean z = this.zzfzb instanceof zzcez;
            this.zzfoc.execute(new Runnable(this, z) { // from class: com.google.android.gms.internal.ads.zzceb
                private final boolean zzeha;
                private final zzcdx zzfzg;

                {
                    this.zzfzg = this;
                    this.zzeha = z;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzfzg.zzbj(this.zzeha);
                }
            });
        }
    }

    public final synchronized void setClickConfirmingView(View view) {
        this.zzfyt.setClickConfirmingView(view);
    }

    public final synchronized void zza(zzcgc zzcgcVar) {
        zzdw zzdwVarZzca;
        this.zzfzb = zzcgcVar;
        this.zzfyu.zza(zzcgcVar);
        this.zzfyt.zza(zzcgcVar.zzahx(), zzcgcVar.zzand(), zzcgcVar.zzane(), zzcgcVar, zzcgcVar);
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcqx)).booleanValue() && (zzdwVarZzca = this.zzeom.zzca()) != null) {
            zzdwVarZzca.zzb(zzcgcVar.zzahx());
        }
        if (zzcgcVar.zzanb() != null) {
            zzcgcVar.zzanb().zza(this.zzfrn);
        }
    }

    public final void zzaa(View view) {
        IObjectWrapper iObjectWrapperZzamh = this.zzfxu.zzamh();
        boolean z = this.zzfxu.zzamg() != null;
        if (!this.zzfyv.zzalw() || iObjectWrapperZzamh == null || !z || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzp.zzlg().zza(iObjectWrapperZzamh, view);
    }

    public final void zzab(View view) {
        IObjectWrapper iObjectWrapperZzamh = this.zzfxu.zzamh();
        if (!this.zzfyv.zzalw() || iObjectWrapperZzamh == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzp.zzlg().zzb(iObjectWrapperZzamh, view);
    }

    @Override // com.google.android.gms.internal.ads.zzbqo
    public final void zzaih() {
        this.zzfoc.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcea
            private final zzcdx zzfzg;

            {
                this.zzfzg = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfzg.zzalz();
            }
        });
        if (this.zzfxu.zzama() != 7) {
            Executor executor = this.zzfoc;
            zzceq zzceqVar = this.zzfyt;
            zzceqVar.getClass();
            executor.execute(zzcdz.zza(zzceqVar));
        }
        super.zzaih();
    }

    public final synchronized void zzalp() {
        if (this.zzfzc) {
            return;
        }
        this.zzfyt.zzalp();
    }

    public final boolean zzalv() {
        return this.zzfyv.zzamn();
    }

    public final boolean zzalw() {
        return this.zzfyv.zzalw();
    }

    public final zzced zzalx() {
        return this.zzfze;
    }

    final /* synthetic */ void zzaly() {
        this.zzfyt.destroy();
        this.zzfxu.destroy();
    }

    final /* synthetic */ void zzalz() {
        try {
            int iZzama = this.zzfxu.zzama();
            if (iZzama == 1) {
                if (this.zzfqc.zzamp() != null) {
                    zzi("Google", true);
                    this.zzfqc.zzamp().zza(this.zzfyw.get());
                    return;
                }
                return;
            }
            if (iZzama == 2) {
                if (this.zzfqc.zzamq() != null) {
                    zzi("Google", true);
                    this.zzfqc.zzamq().zza(this.zzfyx.get());
                    return;
                }
                return;
            }
            if (iZzama == 3) {
                if (this.zzfqc.zzgd(this.zzfxu.getCustomTemplateId()) != null) {
                    if (this.zzfxu.zzamf() != null) {
                        zzi("Google", true);
                    }
                    this.zzfqc.zzgd(this.zzfxu.getCustomTemplateId()).zza(this.zzfza.get());
                    return;
                }
                return;
            }
            if (iZzama == 6) {
                if (this.zzfqc.zzamr() != null) {
                    zzi("Google", true);
                    this.zzfqc.zzamr().zza(this.zzfyy.get());
                    return;
                }
                return;
            }
            if (iZzama != 7) {
                zzbbq.zzfc("Wrong native template id!");
            } else if (this.zzfqc.zzamt() != null) {
                this.zzfqc.zzamt().zza(this.zzfyz.get());
            }
        } catch (RemoteException e2) {
            zzbbq.zzc("RemoteException when notifyAdLoad is called", e2);
        }
    }

    public final synchronized void zzb(zzcgc zzcgcVar) {
        this.zzfyt.zza(zzcgcVar.zzahx(), zzcgcVar.zzanc());
        if (zzcgcVar.zzana() != null) {
            zzcgcVar.zzana().setClickable(false);
            zzcgcVar.zzana().removeAllViews();
        }
        if (zzcgcVar.zzanb() != null) {
            zzcgcVar.zzanb().zzb(this.zzfrn);
        }
        this.zzfzb = null;
    }

    final /* synthetic */ void zzbj(boolean z) {
        this.zzfyt.zza(this.zzfzb.zzahx(), this.zzfzb.zzanc(), this.zzfzb.zzand(), z);
    }

    public final synchronized void zzfz(String str) {
        this.zzfyt.zzfz(str);
    }

    public final synchronized void zzg(Bundle bundle) {
        this.zzfyt.zzg(bundle);
    }

    public final synchronized void zzh(Bundle bundle) {
        this.zzfyt.zzh(bundle);
    }

    public final synchronized boolean zzi(Bundle bundle) {
        if (this.zzfzc) {
            return true;
        }
        boolean zZzi = this.zzfyt.zzi(bundle);
        this.zzfzc = zZzi;
        return zZzi;
    }

    public final synchronized void zzsv() {
        this.zzfyt.zzsv();
    }

    public final void zzi(String str, boolean z) {
        String str2;
        if (this.zzfyv.zzalw()) {
            zzbgj zzbgjVarZzamg = this.zzfxu.zzamg();
            zzbgj zzbgjVarZzamf = this.zzfxu.zzamf();
            if (zzbgjVarZzamg == null && zzbgjVarZzamf == null) {
                return;
            }
            boolean z2 = zzbgjVarZzamg != null;
            boolean z3 = zzbgjVarZzamf != null;
            String str3 = null;
            if (z2) {
                str2 = str3;
            } else if (z3) {
                str3 = "javascript";
                zzbgjVarZzamg = zzbgjVarZzamf;
                str2 = str3;
            } else {
                zzbgjVarZzamg = null;
                str2 = null;
            }
            if (zzbgjVarZzamg.getWebView() != null && com.google.android.gms.ads.internal.zzp.zzlg().zzp(this.zzvr)) {
                zzbbx zzbbxVar = this.zzbpe;
                int i = zzbbxVar.zzeel;
                int i2 = zzbbxVar.zzeem;
                StringBuilder sb = new StringBuilder(23);
                sb.append(i);
                sb.append(Consts.DOT);
                sb.append(i2);
                IObjectWrapper iObjectWrapperZza = com.google.android.gms.ads.internal.zzp.zzlg().zza(sb.toString(), zzbgjVarZzamg.getWebView(), "", "javascript", str2, str);
                if (iObjectWrapperZza == null) {
                    return;
                }
                this.zzfxu.zzas(iObjectWrapperZza);
                zzbgjVarZzamg.zzap(iObjectWrapperZza);
                if (z3) {
                    View view = zzbgjVarZzamf.getView();
                    if (view != null) {
                        com.google.android.gms.ads.internal.zzp.zzlg().zza(iObjectWrapperZza, view);
                    }
                    this.zzfzd = true;
                }
                if (z) {
                    com.google.android.gms.ads.internal.zzp.zzlg().zzab(iObjectWrapperZza);
                }
            }
        }
    }

    public final synchronized void zzb(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (this.zzfzc) {
            return;
        }
        if (z) {
            this.zzfyu.zzd(this.zzfzb);
            this.zzfyt.zzb(view, map, map2);
            this.zzfzc = true;
            return;
        }
        if (!z) {
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcsh)).booleanValue() && map != null) {
                Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    View view2 = it.next().getValue().get();
                    if (view2 != null && zzz(view2)) {
                        this.zzfyu.zzd(this.zzfzb);
                        this.zzfyt.zzb(view, map, map2);
                        this.zzfzc = true;
                        return;
                    }
                }
            }
        }
    }

    public final synchronized void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        this.zzfyu.zzc(this.zzfzb);
        this.zzfyt.zza(view, view2, map, map2, z);
        if (this.zzfzd) {
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcsa)).booleanValue() && this.zzfxu.zzamf() != null) {
                this.zzfxu.zzamf().zza("onSdkAdUserInteractionClick", new HashMap());
            }
        }
    }

    public final synchronized void zza(View view, MotionEvent motionEvent, View view2) {
        this.zzfyt.zza(view, motionEvent, view2);
    }

    public final synchronized JSONObject zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return this.zzfyt.zza(view, map, map2);
    }

    public final synchronized void zza(zzafz zzafzVar) {
        this.zzfyt.zza(zzafzVar);
    }

    public final synchronized void zza(zzyd zzydVar) {
        this.zzfyt.zza(zzydVar);
    }

    public final synchronized void zza(zzxz zzxzVar) {
        this.zzfyt.zza(zzxzVar);
    }

    public final synchronized void zza(zzyi zzyiVar) {
        this.zzfvj.zzb(zzyiVar);
    }
}
