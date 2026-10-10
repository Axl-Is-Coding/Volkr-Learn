package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzzd {
    private static zzzd zzckj;
    private zzxs zzckk;
    private RewardedVideoAd zzckm;
    private InitializationStatus zzcko;
    private final Object lock = new Object();
    private boolean zzckl = false;
    private boolean zzzh = false;
    private RequestConfiguration zzckn = new RequestConfiguration.Builder().build();
    private ArrayList<OnInitializationCompleteListener> zzcki = new ArrayList<>();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    class zza extends zzaiw {
        private zza() {
        }

        @Override // com.google.android.gms.internal.ads.zzait
        public final void zze(List<zzaiq> list) throws RemoteException {
            int i = 0;
            zzzd.zza(zzzd.this, false);
            zzzd.zzb(zzzd.this, true);
            InitializationStatus initializationStatusZza = zzzd.zza(zzzd.this, list);
            ArrayList arrayList = zzzd.zzqw().zzcki;
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((OnInitializationCompleteListener) obj).onInitializationComplete(initializationStatusZza);
            }
            zzzd.zzqw().zzcki.clear();
        }

        /* synthetic */ zza(zzzd zzzdVar, zzzg zzzgVar) {
            this();
        }
    }

    private zzzd() {
    }

    static /* synthetic */ boolean zzb(zzzd zzzdVar, boolean z) {
        zzzdVar.zzzh = true;
        return true;
    }

    private static InitializationStatus zzd(List<zzaiq> list) {
        HashMap map = new HashMap();
        for (zzaiq zzaiqVar : list) {
            map.put(zzaiqVar.zzdfz, new zzaiy(zzaiqVar.zzdga ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY, zzaiqVar.description, zzaiqVar.zzdgb));
        }
        return new zzaix(map);
    }

    private final void zzg(Context context) {
        if (this.zzckk == null) {
            this.zzckk = new zzwj(zzwm.zzpu(), context).zzd(context, false);
        }
    }

    public static zzzd zzqw() {
        zzzd zzzdVar;
        synchronized (zzzd.class) {
            if (zzckj == null) {
                zzckj = new zzzd();
            }
            zzzdVar = zzckj;
        }
        return zzzdVar;
    }

    public final void disableMediationAdapterInitialization(Context context) {
        synchronized (this.lock) {
            zzg(context);
            try {
                this.zzckk.zzqj();
            } catch (RemoteException unused) {
                zzbbq.zzfc("Unable to disable mediation adapter initialization.");
            }
        }
    }

    public final InitializationStatus getInitializationStatus() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzckk != null, "MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                if (this.zzcko != null) {
                    return this.zzcko;
                }
                return zzd(this.zzckk.zzqi());
            } catch (RemoteException unused) {
                zzbbq.zzfc("Unable to get Initialization status.");
                return null;
            }
        }
    }

    public final RequestConfiguration getRequestConfiguration() {
        return this.zzckn;
    }

    public final RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        synchronized (this.lock) {
            if (this.zzckm != null) {
                return this.zzckm;
            }
            this.zzckm = new zzauo(context, new zzwk(zzwm.zzpu(), context, new zzanc()).zzd(context, false));
            return this.zzckm;
        }
    }

    public final String getVersionString() {
        String strZzhi;
        synchronized (this.lock) {
            Preconditions.checkState(this.zzckk != null, "MobileAds.initialize() must be called prior to getting version string.");
            try {
                strZzhi = zzdwf.zzhi(this.zzckk.getVersionString());
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to get version string.", e2);
                return "";
            }
        }
        return strZzhi;
    }

    public final void openDebugMenu(Context context, String str) {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzckk != null, "MobileAds.initialize() must be called prior to opening debug menu.");
            try {
                this.zzckk.zzb(ObjectWrapper.wrap(context), str);
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to open debug menu.", e2);
            }
        }
    }

    public final void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        synchronized (this.lock) {
            try {
                this.zzckk.zzci(cls.getCanonicalName());
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to register RtbAdapter", e2);
            }
        }
    }

    public final void setAppMuted(boolean z) {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzckk != null, "MobileAds.initialize() must be called prior to setting app muted state.");
            try {
                this.zzckk.setAppMuted(z);
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to set app mute state.", e2);
            }
        }
    }

    public final void setAppVolume(float f2) {
        boolean z = true;
        Preconditions.checkArgument(WheelView.DividerConfig.FILL <= f2 && f2 <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        synchronized (this.lock) {
            if (this.zzckk == null) {
                z = false;
            }
            Preconditions.checkState(z, "MobileAds.initialize() must be called prior to setting the app volume.");
            try {
                this.zzckk.setAppVolume(f2);
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to set app volume.", e2);
            }
        }
    }

    public final void setRequestConfiguration(RequestConfiguration requestConfiguration) {
        Preconditions.checkArgument(requestConfiguration != null, "Null passed to setRequestConfiguration.");
        synchronized (this.lock) {
            RequestConfiguration requestConfiguration2 = this.zzckn;
            this.zzckn = requestConfiguration;
            if (this.zzckk == null) {
                return;
            }
            if (requestConfiguration2.getTagForChildDirectedTreatment() != requestConfiguration.getTagForChildDirectedTreatment() || requestConfiguration2.getTagForUnderAgeOfConsent() != requestConfiguration.getTagForUnderAgeOfConsent()) {
                zza(requestConfiguration);
            }
        }
    }

    public final void zza(final Context context, String str, final OnInitializationCompleteListener onInitializationCompleteListener) {
        synchronized (this.lock) {
            if (this.zzckl) {
                if (onInitializationCompleteListener != null) {
                    zzqw().zzcki.add(onInitializationCompleteListener);
                }
                return;
            }
            if (this.zzzh) {
                if (onInitializationCompleteListener != null) {
                    onInitializationCompleteListener.onInitializationComplete(getInitializationStatus());
                }
                return;
            }
            this.zzckl = true;
            if (onInitializationCompleteListener != null) {
                zzqw().zzcki.add(onInitializationCompleteListener);
            }
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            }
            try {
                zzamt.zztr().zzd(context, str);
                zzg(context);
                if (onInitializationCompleteListener != null) {
                    this.zzckk.zza(new zza(this, null));
                }
                this.zzckk.zza(new zzanc());
                this.zzckk.initialize();
                this.zzckk.zza(str, ObjectWrapper.wrap(new Runnable(this, context) { // from class: com.google.android.gms.internal.ads.zzzc
                    private final zzzd zzckg;
                    private final Context zzckh;

                    {
                        this.zzckg = this;
                        this.zzckh = context;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzckg.getRewardedVideoAdInstance(this.zzckh);
                    }
                }));
                if (this.zzckn.getTagForChildDirectedTreatment() != -1 || this.zzckn.getTagForUnderAgeOfConsent() != -1) {
                    zza(this.zzckn);
                }
                zzabb.initialize(context);
                if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcuq)).booleanValue() && !getVersionString().endsWith("0")) {
                    zzbbq.zzfc("Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.");
                    this.zzcko = new InitializationStatus(this) { // from class: com.google.android.gms.internal.ads.zzze
                        private final zzzd zzckg;

                        {
                            this.zzckg = this;
                        }

                        @Override // com.google.android.gms.ads.initialization.InitializationStatus
                        public final Map getAdapterStatusMap() {
                            zzzd zzzdVar = this.zzckg;
                            HashMap map = new HashMap();
                            map.put("com.google.android.gms.ads.MobileAds", new zzzg(zzzdVar));
                            return map;
                        }
                    };
                    if (onInitializationCompleteListener != null) {
                        zzbbg.zzaah.post(new Runnable(this, onInitializationCompleteListener) { // from class: com.google.android.gms.internal.ads.zzzf
                            private final zzzd zzckg;
                            private final OnInitializationCompleteListener zzckp;

                            {
                                this.zzckg = this;
                                this.zzckp = onInitializationCompleteListener;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zzckg.zza(this.zzckp);
                            }
                        });
                    }
                }
            } catch (RemoteException e2) {
                zzbbq.zzd("MobileAdsSettingManager initialization failed", e2);
            }
        }
    }

    public final float zzqg() {
        synchronized (this.lock) {
            float fZzqg = 1.0f;
            if (this.zzckk == null) {
                return 1.0f;
            }
            try {
                fZzqg = this.zzckk.zzqg();
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to get app volume.", e2);
            }
            return fZzqg;
        }
    }

    public final boolean zzqh() {
        synchronized (this.lock) {
            boolean zZzqh = false;
            if (this.zzckk == null) {
                return false;
            }
            try {
                zZzqh = this.zzckk.zzqh();
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to get app mute state.", e2);
            }
            return zZzqh;
        }
    }

    private final void zza(RequestConfiguration requestConfiguration) {
        try {
            this.zzckk.zza(new zzaae(requestConfiguration));
        } catch (RemoteException e2) {
            zzbbq.zzc("Unable to set request configuration parcel.", e2);
        }
    }

    final /* synthetic */ void zza(OnInitializationCompleteListener onInitializationCompleteListener) {
        onInitializationCompleteListener.onInitializationComplete(this.zzcko);
    }

    static /* synthetic */ boolean zza(zzzd zzzdVar, boolean z) {
        zzzdVar.zzckl = false;
        return false;
    }

    static /* synthetic */ InitializationStatus zza(zzzd zzzdVar, List list) {
        return zzd(list);
    }
}
