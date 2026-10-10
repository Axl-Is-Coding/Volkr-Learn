package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzchx extends zzajd implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzadn {
    private zzyo zzfzs;
    private View zzfzx;
    private zzcdx zzgaw;
    private boolean zzepb = false;
    private boolean zzgeb = false;

    public zzchx(zzcdx zzcdxVar, zzcei zzceiVar) {
        this.zzfzx = zzceiVar.zzame();
        this.zzfzs = zzceiVar.getVideoController();
        this.zzgaw = zzcdxVar;
        if (zzceiVar.zzamf() != null) {
            zzceiVar.zzamf().zza(this);
        }
    }

    private final void zzanp() {
        View view = this.zzfzx;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.zzfzx);
        }
    }

    private final void zzanq() {
        View view;
        zzcdx zzcdxVar = this.zzgaw;
        if (zzcdxVar == null || (view = this.zzfzx) == null) {
            return;
        }
        zzcdxVar.zzb(view, Collections.emptyMap(), Collections.emptyMap(), zzcdx.zzz(this.zzfzx));
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzanp();
        zzcdx zzcdxVar = this.zzgaw;
        if (zzcdxVar != null) {
            zzcdxVar.destroy();
        }
        this.zzgaw = null;
        this.zzfzx = null;
        this.zzfzs = null;
        this.zzepb = true;
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final zzyo getVideoController() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzepb) {
            return this.zzfzs;
        }
        zzbbq.zzfc("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzanq();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzanq();
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zza(IObjectWrapper iObjectWrapper, zzajf zzajfVar) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzepb) {
            zzbbq.zzfc("Instream ad can not be shown after destroy().");
            zza(zzajfVar, 2);
            return;
        }
        if (this.zzfzx == null || this.zzfzs == null) {
            String str = this.zzfzx == null ? "can not get video view." : "can not get video controller.";
            zzbbq.zzfc(str.length() != 0 ? "Instream internal error: ".concat(str) : new String("Instream internal error: "));
            zza(zzajfVar, 0);
            return;
        }
        if (this.zzgeb) {
            zzbbq.zzfc("Instream ad should not be used again.");
            zza(zzajfVar, 1);
            return;
        }
        this.zzgeb = true;
        zzanp();
        ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zzfzx, new ViewGroup.LayoutParams(-1, -1));
        com.google.android.gms.ads.internal.zzp.zzlo();
        zzbco.zza(this.zzfzx, (ViewTreeObserver.OnGlobalLayoutListener) this);
        com.google.android.gms.ads.internal.zzp.zzlo();
        zzbco.zza(this.zzfzx, (ViewTreeObserver.OnScrollChangedListener) this);
        zzanq();
        try {
            zzajfVar.zztc();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    final /* synthetic */ void zzanr() {
        try {
            destroy();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zza(iObjectWrapper, new zzchz(this));
    }

    @Override // com.google.android.gms.internal.ads.zzadn
    public final void zzsf() {
        zzayu.zzeba.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcia
            private final zzchx zzgec;

            {
                this.zzgec = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgec.zzanr();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final zzadz zzsw() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzepb) {
            zzbbq.zzfc("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzcdx zzcdxVar = this.zzgaw;
        if (zzcdxVar == null || zzcdxVar.zzalx() == null) {
            return null;
        }
        return this.zzgaw.zzalx().zzsw();
    }

    private static void zza(zzajf zzajfVar, int i) {
        try {
            zzajfVar.zzdc(i);
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }
}
