package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaqv {

    @VisibleForTesting
    private zzdsy zzdoh;
    private static final Object lock = new Object();

    @VisibleForTesting
    private static boolean zzzh = false;

    @VisibleForTesting
    private static boolean zzdog = false;

    @VisibleForTesting
    private final void zzq(Context context) {
        synchronized (lock) {
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcuc)).booleanValue() && !zzdog) {
                try {
                    zzdog = true;
                    this.zzdoh = (zzdsy) zzbbt.zza(context, "com.google.android.gms.ads.omid.DynamiteOmid", zzaqx.zzbxx);
                } catch (zzbbv e2) {
                    zzbbq.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final String getVersion(Context context) {
        if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcuc)).booleanValue()) {
            return null;
        }
        try {
            zzq(context);
            String strValueOf = String.valueOf(this.zzdoh.getVersion());
            return strValueOf.length() != 0 ? "a.".concat(strValueOf) : new String("a.");
        } catch (RemoteException | NullPointerException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4) {
        return zza(str, webView, str2, str3, str4, "Google");
    }

    public final void zzab(IObjectWrapper iObjectWrapper) {
        synchronized (lock) {
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcuc)).booleanValue() && zzzh) {
                try {
                    this.zzdoh.zzab(iObjectWrapper);
                } catch (RemoteException | NullPointerException e2) {
                    zzbbq.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final void zzac(IObjectWrapper iObjectWrapper) {
        synchronized (lock) {
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcuc)).booleanValue() && zzzh) {
                try {
                    this.zzdoh.zzac(iObjectWrapper);
                } catch (RemoteException | NullPointerException e2) {
                    zzbbq.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, View view) {
        synchronized (lock) {
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcuc)).booleanValue() && zzzh) {
                try {
                    this.zzdoh.zzd(iObjectWrapper, ObjectWrapper.wrap(view));
                } catch (RemoteException | NullPointerException e2) {
                    zzbbq.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final boolean zzp(Context context) {
        synchronized (lock) {
            if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcuc)).booleanValue()) {
                return false;
            }
            if (zzzh) {
                return true;
            }
            try {
                zzq(context);
                boolean zZzau = this.zzdoh.zzau(ObjectWrapper.wrap(context));
                zzzh = zZzau;
                return zZzau;
            } catch (RemoteException e2) {
                e = e2;
                zzbbq.zze("#007 Could not call remote method.", e);
                return false;
            } catch (NullPointerException e3) {
                e = e3;
                zzbbq.zze("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4, String str5) {
        synchronized (lock) {
            try {
                try {
                    if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcuc)).booleanValue() && zzzh) {
                        try {
                            return this.zzdoh.zza(str, ObjectWrapper.wrap(webView), str2, str3, str4, str5);
                        } catch (RemoteException | NullPointerException e2) {
                            zzbbq.zze("#007 Could not call remote method.", e2);
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, View view) {
        synchronized (lock) {
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcuc)).booleanValue() && zzzh) {
                try {
                    this.zzdoh.zzc(iObjectWrapper, ObjectWrapper.wrap(view));
                } catch (RemoteException | NullPointerException e2) {
                    zzbbq.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }
}
