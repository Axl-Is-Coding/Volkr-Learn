package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaex extends NativeContentAd {
    private final NativeAd.AdChoicesInfo zzddv;
    private final zzaew zzddw;
    private final zzaef zzddx;
    private final List<NativeAd.Image> zzddt = new ArrayList();
    private final VideoController zzcjt = new VideoController();

    public zzaex(zzaew zzaewVar) {
        zzaee zzaeeVarZzso;
        zzaee zzaegVar;
        IBinder iBinder;
        this.zzddw = zzaewVar;
        zzadx zzadxVar = null;
        try {
            List images = this.zzddw.getImages();
            if (images != null) {
                for (Object obj : images) {
                    if (!(obj instanceof IBinder) || (iBinder = (IBinder) obj) == null) {
                        zzaegVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        zzaegVar = iInterfaceQueryLocalInterface instanceof zzaee ? (zzaee) iInterfaceQueryLocalInterface : new zzaeg(iBinder);
                    }
                    if (zzaegVar != null) {
                        this.zzddt.add(new zzaef(zzaegVar));
                    }
                }
            }
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
        try {
            zzaeeVarZzso = this.zzddw.zzso();
        } catch (RemoteException e3) {
            zzbbq.zzc("", e3);
        }
        zzaef zzaefVar = zzaeeVarZzso != null ? new zzaef(zzaeeVarZzso) : null;
        this.zzddx = zzaefVar;
        try {
            if (this.zzddw.zzsm() != null) {
                zzadxVar = new zzadx(this.zzddw.zzsm());
            }
        } catch (RemoteException e4) {
            zzbbq.zzc("", e4);
        }
        this.zzddv = zzadxVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.formats.NativeAd
    /* JADX INFO: renamed from: zzsk, reason: merged with bridge method [inline-methods] */
    public final IObjectWrapper zzjs() {
        try {
            return this.zzddw.zzsk();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final void destroy() {
        try {
            this.zzddw.destroy();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzddv;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getAdvertiser() {
        try {
            return this.zzddw.getAdvertiser();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getBody() {
        try {
            return this.zzddw.getBody();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getCallToAction() {
        try {
            return this.zzddw.getCallToAction();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final Bundle getExtras() {
        try {
            return this.zzddw.getExtras();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getHeadline() {
        try {
            return this.zzddw.getHeadline();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final List<NativeAd.Image> getImages() {
        return this.zzddt;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final NativeAd.Image getLogo() {
        return this.zzddx;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.zzddw.getMediationAdapterClassName();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final VideoController getVideoController() {
        try {
            if (this.zzddw.getVideoController() != null) {
                this.zzcjt.zza(this.zzddw.getVideoController());
            }
        } catch (RemoteException e2) {
            zzbbq.zzc("Exception occurred while getting video controller", e2);
        }
        return this.zzcjt;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.zzddw.performClick(bundle);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzddw.recordImpression(bundle);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzddw.reportTouchEvent(bundle);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }
}
