package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzauo implements RewardedVideoAd {
    private final zzaud zzdvx;
    private String zzdvz;
    private String zzdwa;
    private final Context zzvr;
    private final Object lock = new Object();
    private final zzaun zzdvy = new zzaun(null);

    public zzauo(Context context, zzaud zzaudVar) {
        this.zzdvx = zzaudVar == null ? new zzaaa() : zzaudVar;
        this.zzvr = context.getApplicationContext();
    }

    private final void zza(String str, zzyw zzywVar) {
        synchronized (this.lock) {
            if (this.zzdvx == null) {
                return;
            }
            try {
                this.zzdvx.zza(zzvl.zza(this.zzvr, zzywVar, str));
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void destroy() {
        destroy(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final Bundle getAdMetadata() {
        synchronized (this.lock) {
            if (this.zzdvx != null) {
                try {
                    return this.zzdvx.getAdMetadata();
                } catch (RemoteException e2) {
                    zzbbq.zze("#007 Could not call remote method.", e2);
                }
            }
            return new Bundle();
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getCustomData() {
        String str;
        synchronized (this.lock) {
            str = this.zzdwa;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getMediationAdapterClassName() {
        try {
            if (this.zzdvx != null) {
                return this.zzdvx.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final ResponseInfo getResponseInfo() {
        zzyn zzynVarZzki = null;
        try {
            if (this.zzdvx != null) {
                zzynVarZzki = this.zzdvx.zzki();
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
        return ResponseInfo.zza(zzynVarZzki);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.lock) {
            rewardedVideoAdListener = this.zzdvy.getRewardedVideoAdListener();
        }
        return rewardedVideoAdListener;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getUserId() {
        String str;
        synchronized (this.lock) {
            str = this.zzdvz;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final boolean isLoaded() {
        synchronized (this.lock) {
            if (this.zzdvx == null) {
                return false;
            }
            try {
                return this.zzdvx.isLoaded();
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
                return false;
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void loadAd(String str, AdRequest adRequest) {
        zza(str, adRequest.zzdr());
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void pause() {
        pause(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void resume() {
        resume(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        synchronized (this.lock) {
            if (this.zzdvx != null) {
                try {
                    this.zzdvx.zza(new zzvh(adMetadataListener));
                } catch (RemoteException e2) {
                    zzbbq.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setCustomData(String str) {
        synchronized (this.lock) {
            if (this.zzdvx != null) {
                try {
                    this.zzdvx.setCustomData(str);
                    this.zzdwa = str;
                } catch (RemoteException e2) {
                    zzbbq.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setImmersiveMode(boolean z) {
        synchronized (this.lock) {
            if (this.zzdvx != null) {
                try {
                    this.zzdvx.setImmersiveMode(z);
                } catch (RemoteException e2) {
                    zzbbq.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.lock) {
            this.zzdvy.setRewardedVideoAdListener(rewardedVideoAdListener);
            if (this.zzdvx != null) {
                try {
                    this.zzdvx.zza(this.zzdvy);
                } catch (RemoteException e2) {
                    zzbbq.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setUserId(String str) {
        synchronized (this.lock) {
            this.zzdvz = str;
            if (this.zzdvx != null) {
                try {
                    this.zzdvx.setUserId(str);
                } catch (RemoteException e2) {
                    zzbbq.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void show() {
        synchronized (this.lock) {
            if (this.zzdvx == null) {
                return;
            }
            try {
                this.zzdvx.show();
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void destroy(Context context) {
        synchronized (this.lock) {
            this.zzdvy.setRewardedVideoAdListener(null);
            if (this.zzdvx == null) {
                return;
            }
            try {
                this.zzdvx.zzl(ObjectWrapper.wrap(context));
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void loadAd(String str, PublisherAdRequest publisherAdRequest) {
        zza(str, publisherAdRequest.zzdr());
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void pause(Context context) {
        synchronized (this.lock) {
            if (this.zzdvx == null) {
                return;
            }
            try {
                this.zzdvx.zzj(ObjectWrapper.wrap(context));
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void resume(Context context) {
        synchronized (this.lock) {
            if (this.zzdvx == null) {
                return;
            }
            try {
                this.zzdvx.zzk(ObjectWrapper.wrap(context));
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }
}
