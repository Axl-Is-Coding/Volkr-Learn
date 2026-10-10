package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzagf extends UnifiedNativeAd {
    private final zzaef zzddu;
    private final NativeAd.AdChoicesInfo zzddv;
    private final zzage zzdeb;
    private final List<NativeAd.Image> zzddt = new ArrayList();
    private final VideoController zzcjt = new VideoController();
    private final List<MuteThisAdReason> zzdec = new ArrayList();

    public zzagf(zzage zzageVar) {
        zzaee zzaeeVarZzsl;
        zzaee zzaegVar;
        IBinder iBinder;
        this.zzdeb = zzageVar;
        zzadx zzadxVar = null;
        try {
            List images = this.zzdeb.getImages();
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
            List muteThisAdReasons = this.zzdeb.getMuteThisAdReasons();
            if (muteThisAdReasons != null) {
                for (Object obj2 : muteThisAdReasons) {
                    zzyd zzydVarZzg = obj2 instanceof IBinder ? zzyc.zzg((IBinder) obj2) : null;
                    if (zzydVarZzg != null) {
                        this.zzdec.add(new zzye(zzydVarZzg));
                    }
                }
            }
        } catch (RemoteException e3) {
            zzbbq.zzc("", e3);
        }
        try {
            zzaeeVarZzsl = this.zzdeb.zzsl();
        } catch (RemoteException e4) {
            zzbbq.zzc("", e4);
        }
        zzaef zzaefVar = zzaeeVarZzsl != null ? new zzaef(zzaeeVarZzsl) : null;
        this.zzddu = zzaefVar;
        try {
            if (this.zzdeb.zzsm() != null) {
                zzadxVar = new zzadx(this.zzdeb.zzsm());
            }
        } catch (RemoteException e5) {
            zzbbq.zzc("", e5);
        }
        this.zzddv = zzadxVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    /* JADX INFO: renamed from: zzsk, reason: merged with bridge method [inline-methods] */
    public final IObjectWrapper zzjs() {
        try {
            return this.zzdeb.zzsk();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void cancelUnconfirmedClick() {
        try {
            this.zzdeb.cancelUnconfirmedClick();
        } catch (RemoteException e2) {
            zzbbq.zzc("Failed to cancelUnconfirmedClick", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void destroy() {
        try {
            this.zzdeb.destroy();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void enableCustomClickGesture() {
        try {
            this.zzdeb.zzsv();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzddv;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getAdvertiser() {
        try {
            return this.zzdeb.getAdvertiser();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getBody() {
        try {
            return this.zzdeb.getBody();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getCallToAction() {
        try {
            return this.zzdeb.getCallToAction();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Bundle getExtras() {
        try {
            Bundle extras = this.zzdeb.getExtras();
            if (extras != null) {
                return extras;
            }
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getHeadline() {
        try {
            return this.zzdeb.getHeadline();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.Image getIcon() {
        return this.zzddu;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<NativeAd.Image> getImages() {
        return this.zzddt;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final MediaContent getMediaContent() {
        try {
            if (this.zzdeb.zzsw() != null) {
                return new zzzm(this.zzdeb.zzsw());
            }
            return null;
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getMediationAdapterClassName() {
        try {
            return this.zzdeb.getMediationAdapterClassName();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zzdec;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getPrice() {
        try {
            return this.zzdeb.getPrice();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final ResponseInfo getResponseInfo() {
        zzyn zzynVarZzki;
        try {
            zzynVarZzki = this.zzdeb.zzki();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            zzynVarZzki = null;
        }
        return ResponseInfo.zza(zzynVarZzki);
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Double getStarRating() {
        try {
            double starRating = this.zzdeb.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getStore() {
        try {
            return this.zzdeb.getStore();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final VideoController getVideoController() {
        try {
            if (this.zzdeb.getVideoController() != null) {
                this.zzcjt.zza(this.zzdeb.getVideoController());
            }
        } catch (RemoteException e2) {
            zzbbq.zzc("Exception occurred while getting video controller", e2);
        }
        return this.zzcjt;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean isCustomClickGestureEnabled() {
        try {
            return this.zzdeb.isCustomClickGestureEnabled();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zzdeb.isCustomMuteThisAdEnabled();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (!isCustomMuteThisAdEnabled()) {
                zzbbq.zzfc("Ad is not custom mute enabled");
                return;
            }
            if (muteThisAdReason == null) {
                this.zzdeb.zza((zzyd) null);
            } else if (muteThisAdReason instanceof zzye) {
                this.zzdeb.zza(((zzye) muteThisAdReason).zzql());
            } else {
                zzbbq.zzfc("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
            }
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.zzdeb.performClick(bundle);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void recordCustomClickGesture() {
        try {
            this.zzdeb.recordCustomClickGesture();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzdeb.recordImpression(bundle);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzdeb.reportTouchEvent(bundle);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zzdeb.zza(new zzya(muteThisAdListener));
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzdeb.zza(new zzaab(onPaidEventListener));
        } catch (RemoteException e2) {
            zzbbq.zzc("Failed to setOnPaidEventListener", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zzdeb.zza(new zzagr(unconfirmedClickListener));
        } catch (RemoteException e2) {
            zzbbq.zzc("Failed to setUnconfirmedClickListener", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Object zzjx() {
        try {
            IObjectWrapper iObjectWrapperZzsn = this.zzdeb.zzsn();
            if (iObjectWrapperZzsn != null) {
                return ObjectWrapper.unwrap(iObjectWrapperZzsn);
            }
            return null;
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }
}
