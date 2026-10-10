package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdpa {
    private final zzang zzhfs;

    public zzdpa(zzang zzangVar) {
        this.zzhfs = zzangVar;
    }

    public final void destroy() throws zzdos {
        try {
            this.zzhfs.destroy();
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final zzyo getVideoController() throws zzdos {
        try {
            return this.zzhfs.getVideoController();
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final View getView() throws zzdos {
        try {
            return (View) ObjectWrapper.unwrap(this.zzhfs.zzts());
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final boolean isInitialized() throws zzdos {
        try {
            return this.zzhfs.isInitialized();
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final void onContextChanged(Context context) throws zzdos {
        try {
            this.zzhfs.zzs(ObjectWrapper.wrap(context));
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final void pause() throws zzdos {
        try {
            this.zzhfs.pause();
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final void resume() throws zzdos {
        try {
            this.zzhfs.resume();
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final void setImmersiveMode(boolean z) throws zzdos {
        try {
            this.zzhfs.setImmersiveMode(z);
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final void showInterstitial() throws zzdos {
        try {
            this.zzhfs.showInterstitial();
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final void showVideo() throws zzdos {
        try {
            this.zzhfs.showVideo();
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final void zza(Context context, zzvn zzvnVar, zzvg zzvgVar, String str, zzanh zzanhVar) throws zzdos {
        try {
            this.zzhfs.zza(ObjectWrapper.wrap(context), zzvnVar, zzvgVar, str, zzanhVar);
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final void zzb(Context context, zzvg zzvgVar, String str, zzanh zzanhVar) throws zzdos {
        try {
            this.zzhfs.zzb(ObjectWrapper.wrap(context), zzvgVar, str, zzanhVar);
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final void zzc(Context context, zzvg zzvgVar, String str, zzanh zzanhVar) throws zzdos {
        try {
            this.zzhfs.zzc(ObjectWrapper.wrap(context), zzvgVar, str, zzanhVar);
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final void zzci(Context context) throws zzdos {
        try {
            this.zzhfs.zzt(ObjectWrapper.wrap(context));
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final zzano zztt() throws zzdos {
        try {
            return this.zzhfs.zztt();
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final zzanp zztu() throws zzdos {
        try {
            return this.zzhfs.zztu();
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final boolean zztx() throws zzdos {
        try {
            return this.zzhfs.zztx();
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final zzanu zztz() throws zzdos {
        try {
            return this.zzhfs.zztz();
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final zzapv zzua() throws zzdos {
        try {
            return this.zzhfs.zzua();
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final zzapv zzub() throws zzdos {
        try {
            return this.zzhfs.zzub();
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final void zza(Context context, zzvg zzvgVar, String str, zzanh zzanhVar) throws zzdos {
        try {
            this.zzhfs.zza(ObjectWrapper.wrap(context), zzvgVar, str, zzanhVar);
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final void zza(Context context, zzvn zzvnVar, zzvg zzvgVar, String str, String str2, zzanh zzanhVar) throws zzdos {
        try {
            this.zzhfs.zza(ObjectWrapper.wrap(context), zzvnVar, zzvgVar, str, str2, zzanhVar);
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final void zza(Context context, zzvg zzvgVar, String str, String str2, zzanh zzanhVar) throws zzdos {
        try {
            this.zzhfs.zza(ObjectWrapper.wrap(context), zzvgVar, str, str2, zzanhVar);
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final void zza(Context context, zzvg zzvgVar, String str, zzaur zzaurVar, String str2) throws zzdos {
        try {
            this.zzhfs.zza(ObjectWrapper.wrap(context), zzvgVar, (String) null, zzaurVar, str2);
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final void zza(zzvg zzvgVar, String str) throws zzdos {
        try {
            this.zzhfs.zza(zzvgVar, str);
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final void zza(Context context, zzvg zzvgVar, String str, String str2, zzanh zzanhVar, zzadu zzaduVar, List<String> list) throws zzdos {
        try {
            this.zzhfs.zza(ObjectWrapper.wrap(context), zzvgVar, str, str2, zzanhVar, zzaduVar, list);
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final void zza(Context context, zzaur zzaurVar, List<String> list) throws zzdos {
        try {
            this.zzhfs.zza(ObjectWrapper.wrap(context), zzaurVar, list);
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }

    public final void zza(Context context, zzais zzaisVar, List<zzaja> list) throws zzdos {
        try {
            this.zzhfs.zza(ObjectWrapper.wrap(context), zzaisVar, list);
        } catch (Throwable th) {
            throw new zzdos(th);
        }
    }
}
