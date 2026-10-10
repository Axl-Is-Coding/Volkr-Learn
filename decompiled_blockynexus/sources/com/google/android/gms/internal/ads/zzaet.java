package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaet extends NativeAppInstallAd {
    private final zzaes zzdds;
    private final zzaef zzddu;
    private final NativeAd.AdChoicesInfo zzddv;
    private final List<NativeAd.Image> zzddt = new ArrayList();
    private final VideoController zzcjt = new VideoController();

    public zzaet(zzaes zzaesVar) {
        zzaee zzaeeVarZzsl;
        zzaee zzaegVar;
        IBinder iBinder;
        this.zzdds = zzaesVar;
        zzadx zzadxVar = null;
        try {
            List images = this.zzdds.getImages();
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
            zzaeeVarZzsl = this.zzdds.zzsl();
        } catch (RemoteException e3) {
            zzbbq.zzc("", e3);
        }
        zzaef zzaefVar = zzaeeVarZzsl != null ? new zzaef(zzaeeVarZzsl) : null;
        this.zzddu = zzaefVar;
        try {
            if (this.zzdds.zzsm() != null) {
                zzadxVar = new zzadx(this.zzdds.zzsm());
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
            return this.zzdds.zzsk();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final void destroy() {
        try {
            this.zzdds.destroy();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzddv;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getBody() {
        try {
            return this.zzdds.getBody();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getCallToAction() {
        try {
            return this.zzdds.getCallToAction();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final Bundle getExtras() {
        try {
            return this.zzdds.getExtras();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getHeadline() {
        try {
            return this.zzdds.getHeadline();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final NativeAd.Image getIcon() {
        return this.zzddu;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final List<NativeAd.Image> getImages() {
        return this.zzddt;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.zzdds.getMediationAdapterClassName();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getPrice() {
        try {
            return this.zzdds.getPrice();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final Double getStarRating() {
        try {
            double starRating = this.zzdds.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getStore() {
        try {
            return this.zzdds.getStore();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final VideoController getVideoController() {
        try {
            if (this.zzdds.getVideoController() != null) {
                this.zzcjt.zza(this.zzdds.getVideoController());
            }
        } catch (RemoteException e2) {
            zzbbq.zzc("Exception occurred while getting video controller", e2);
        }
        return this.zzcjt;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.zzdds.performClick(bundle);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzdds.recordImpression(bundle);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzdds.reportTouchEvent(bundle);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }
}
