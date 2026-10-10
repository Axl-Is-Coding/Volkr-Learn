package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.alibaba.android.arouter.utils.Consts;
import com.google.ads.AdRequest$ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.c;
import com.google.ads.mediation.d;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaoi<NETWORK_EXTRAS extends d, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, c {
    private final zzanh zzdlq;

    public zzaoi(zzanh zzanhVar) {
        this.zzdlq = zzanhVar;
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbq.zzef("Adapter called onClick.");
        zzwm.zzpt();
        if (!zzbbg.zzyn()) {
            zzbbq.zze("#008 Must be called on the main UI thread.", null);
            zzbbg.zzaah.post(new zzaoh(this));
        } else {
            try {
                this.zzdlq.onAdClicked();
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbq.zzef("Adapter called onDismissScreen.");
        zzwm.zzpt();
        if (!zzbbg.zzyn()) {
            zzbbq.zzfe("#008 Must be called on the main UI thread.");
            zzbbg.zzaah.post(new zzaom(this));
        } else {
            try {
                this.zzdlq.onAdClosed();
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, AdRequest$ErrorCode adRequest$ErrorCode) {
        String strValueOf = String.valueOf(adRequest$ErrorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error. ");
        sb.append(strValueOf);
        zzbbq.zzef(sb.toString());
        zzwm.zzpt();
        if (!zzbbg.zzyn()) {
            zzbbq.zze("#008 Must be called on the main UI thread.", null);
            zzbbg.zzaah.post(new zzaol(this, adRequest$ErrorCode));
        } else {
            try {
                this.zzdlq.onAdFailedToLoad(zzaou.zza(adRequest$ErrorCode));
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbq.zzef("Adapter called onLeaveApplication.");
        zzwm.zzpt();
        if (!zzbbg.zzyn()) {
            zzbbq.zze("#008 Must be called on the main UI thread.", null);
            zzbbg.zzaah.post(new zzaoo(this));
        } else {
            try {
                this.zzdlq.onAdLeftApplication();
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbq.zzef("Adapter called onPresentScreen.");
        zzwm.zzpt();
        if (!zzbbg.zzyn()) {
            zzbbq.zze("#008 Must be called on the main UI thread.", null);
            zzbbg.zzaah.post(new zzaon(this));
        } else {
            try {
                this.zzdlq.onAdOpened();
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbq.zzef("Adapter called onReceivedAd.");
        zzwm.zzpt();
        if (!zzbbg.zzyn()) {
            zzbbq.zze("#008 Must be called on the main UI thread.", null);
            zzbbg.zzaah.post(new zzaoq(this));
        } else {
            try {
                this.zzdlq.onAdLoaded();
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbbq.zzef("Adapter called onDismissScreen.");
        zzwm.zzpt();
        if (!zzbbg.zzyn()) {
            zzbbq.zze("#008 Must be called on the main UI thread.", null);
            zzbbg.zzaah.post(new zzaop(this));
        } else {
            try {
                this.zzdlq.onAdClosed();
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.ads.mediation.c
    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, AdRequest$ErrorCode adRequest$ErrorCode) {
        String strValueOf = String.valueOf(adRequest$ErrorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error ");
        sb.append(strValueOf);
        sb.append(Consts.DOT);
        zzbbq.zzef(sb.toString());
        zzwm.zzpt();
        if (!zzbbg.zzyn()) {
            zzbbq.zze("#008 Must be called on the main UI thread.", null);
            zzbbg.zzaah.post(new zzaos(this, adRequest$ErrorCode));
        } else {
            try {
                this.zzdlq.onAdFailedToLoad(zzaou.zza(adRequest$ErrorCode));
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbbq.zzef("Adapter called onLeaveApplication.");
        zzwm.zzpt();
        if (!zzbbg.zzyn()) {
            zzbbq.zze("#008 Must be called on the main UI thread.", null);
            zzbbg.zzaah.post(new zzaor(this));
        } else {
            try {
                this.zzdlq.onAdLeftApplication();
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbbq.zzef("Adapter called onPresentScreen.");
        zzwm.zzpt();
        if (!zzbbg.zzyn()) {
            zzbbq.zze("#008 Must be called on the main UI thread.", null);
            zzbbg.zzaah.post(new zzaok(this));
        } else {
            try {
                this.zzdlq.onAdOpened();
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbbq.zzef("Adapter called onReceivedAd.");
        zzwm.zzpt();
        if (!zzbbg.zzyn()) {
            zzbbq.zze("#008 Must be called on the main UI thread.", null);
            zzbbg.zzaah.post(new zzaoj(this));
        } else {
            try {
                this.zzdlq.onAdLoaded();
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }
}
