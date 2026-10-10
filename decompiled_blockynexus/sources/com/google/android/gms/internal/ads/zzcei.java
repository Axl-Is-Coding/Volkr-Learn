package com.google.android.gms.internal.ads;

import a.a.i;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.unity3d.services.purchasing.core.TransactionErrorDetailsUtilities;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcei {
    private Bundle extras;
    private zzadw zzddo;
    private List<?> zzerh;
    private double zzerk;
    private float zzerw;
    private IObjectWrapper zzfrd;
    private int zzfzr;
    private zzyo zzfzs;
    private View zzfzt;
    private zzzk zzfzu;
    private zzbgj zzfzv;
    private zzbgj zzfzw;
    private View zzfzx;
    private IObjectWrapper zzfzy;
    private zzaee zzfzz;
    private zzaee zzgaa;
    private String zzgab;
    private String zzgae;
    private i<String, zzadq> zzgac = new i<>();
    private i<String, String> zzgad = new i<>();
    private List<zzzk> zzdec = Collections.emptyList();

    private final synchronized void setMediaContentAspectRatio(float f2) {
        this.zzerw = f2;
    }

    private static <T> T zzat(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return (T) ObjectWrapper.unwrap(iObjectWrapper);
    }

    private final synchronized String zzgc(String str) {
        return this.zzgad.get(str);
    }

    public final synchronized void destroy() {
        if (this.zzfzv != null) {
            this.zzfzv.destroy();
            this.zzfzv = null;
        }
        if (this.zzfzw != null) {
            this.zzfzw.destroy();
            this.zzfzw = null;
        }
        this.zzfrd = null;
        this.zzgac.clear();
        this.zzgad.clear();
        this.zzfzs = null;
        this.zzddo = null;
        this.zzfzt = null;
        this.zzerh = null;
        this.extras = null;
        this.zzfzx = null;
        this.zzfzy = null;
        this.zzfzz = null;
        this.zzgaa = null;
        this.zzgab = null;
    }

    public final synchronized String getAdvertiser() {
        return zzgc("advertiser");
    }

    public final synchronized String getBody() {
        return zzgc("body");
    }

    public final synchronized String getCallToAction() {
        return zzgc("call_to_action");
    }

    public final synchronized String getCustomTemplateId() {
        return this.zzgab;
    }

    public final synchronized Bundle getExtras() {
        if (this.extras == null) {
            this.extras = new Bundle();
        }
        return this.extras;
    }

    public final synchronized String getHeadline() {
        return zzgc("headline");
    }

    public final synchronized List<?> getImages() {
        return this.zzerh;
    }

    public final synchronized float getMediaContentAspectRatio() {
        return this.zzerw;
    }

    public final synchronized List<zzzk> getMuteThisAdReasons() {
        return this.zzdec;
    }

    public final synchronized String getPrice() {
        return zzgc("price");
    }

    public final synchronized double getStarRating() {
        return this.zzerk;
    }

    public final synchronized String getStore() {
        return zzgc(TransactionErrorDetailsUtilities.STORE);
    }

    public final synchronized zzyo getVideoController() {
        return this.zzfzs;
    }

    public final synchronized void setImages(List<zzadq> list) {
        this.zzerh = list;
    }

    public final synchronized void setStarRating(double d2) {
        this.zzerk = d2;
    }

    public final synchronized void zza(zzadw zzadwVar) {
        this.zzddo = zzadwVar;
    }

    public final synchronized void zzac(View view) {
        this.zzfzx = view;
    }

    public final synchronized int zzama() {
        return this.zzfzr;
    }

    public final synchronized View zzamb() {
        return this.zzfzt;
    }

    public final zzaee zzamc() {
        List<?> list = this.zzerh;
        if (list != null && list.size() != 0) {
            Object obj = this.zzerh.get(0);
            if (obj instanceof IBinder) {
                return zzaed.zzo((IBinder) obj);
            }
        }
        return null;
    }

    public final synchronized zzzk zzamd() {
        return this.zzfzu;
    }

    public final synchronized View zzame() {
        return this.zzfzx;
    }

    public final synchronized zzbgj zzamf() {
        return this.zzfzv;
    }

    public final synchronized zzbgj zzamg() {
        return this.zzfzw;
    }

    public final synchronized IObjectWrapper zzamh() {
        return this.zzfrd;
    }

    public final synchronized i<String, zzadq> zzami() {
        return this.zzgac;
    }

    public final synchronized String zzamj() {
        return this.zzgae;
    }

    public final synchronized i<String, String> zzamk() {
        return this.zzgad;
    }

    public final synchronized void zzas(IObjectWrapper iObjectWrapper) {
        this.zzfrd = iObjectWrapper;
    }

    public final synchronized void zzb(zzyo zzyoVar) {
        this.zzfzs = zzyoVar;
    }

    public final synchronized void zzdy(int i) {
        this.zzfzr = i;
    }

    public final synchronized void zzga(String str) {
        this.zzgab = str;
    }

    public final synchronized void zzgb(String str) {
        this.zzgae = str;
    }

    public final synchronized void zzh(List<zzzk> list) {
        this.zzdec = list;
    }

    public final synchronized void zzi(zzbgj zzbgjVar) {
        this.zzfzv = zzbgjVar;
    }

    public final synchronized void zzj(zzbgj zzbgjVar) {
        this.zzfzw = zzbgjVar;
    }

    public final synchronized void zzn(String str, String str2) {
        if (str2 == null) {
            this.zzgad.remove(str);
        } else {
            this.zzgad.put(str, str2);
        }
    }

    public final synchronized zzaee zzsl() {
        return this.zzfzz;
    }

    public final synchronized zzadw zzsm() {
        return this.zzddo;
    }

    public final synchronized IObjectWrapper zzsn() {
        return this.zzfzy;
    }

    public final synchronized zzaee zzso() {
        return this.zzgaa;
    }

    public final synchronized void zza(zzzk zzzkVar) {
        this.zzfzu = zzzkVar;
    }

    public final synchronized void zzb(zzaee zzaeeVar) {
        this.zzgaa = zzaeeVar;
    }

    public static zzcei zzb(zzanu zzanuVar) {
        try {
            return zza(zza(zzanuVar.getVideoController(), zzanuVar), zzanuVar.zzsm(), (View) zzat(zzanuVar.zzue()), zzanuVar.getHeadline(), zzanuVar.getImages(), zzanuVar.getBody(), zzanuVar.getExtras(), zzanuVar.getCallToAction(), (View) zzat(zzanuVar.zzuf()), zzanuVar.zzsn(), zzanuVar.getStore(), zzanuVar.getPrice(), zzanuVar.getStarRating(), zzanuVar.zzsl(), zzanuVar.getAdvertiser(), zzanuVar.getMediaContentAspectRatio());
        } catch (RemoteException e2) {
            zzbbq.zzd("Failed to get native ad assets from unified ad mapper", e2);
            return null;
        }
    }

    public final synchronized void zza(zzaee zzaeeVar) {
        this.zzfzz = zzaeeVar;
    }

    public final synchronized void zza(String str, zzadq zzadqVar) {
        if (zzadqVar == null) {
            this.zzgac.remove(str);
        } else {
            this.zzgac.put(str, zzadqVar);
        }
    }

    public static zzcei zza(zzanp zzanpVar) {
        try {
            zzcef zzcefVarZza = zza(zzanpVar.getVideoController(), (zzanu) null);
            zzadw zzadwVarZzsm = zzanpVar.zzsm();
            View view = (View) zzat(zzanpVar.zzue());
            String headline = zzanpVar.getHeadline();
            List<?> images = zzanpVar.getImages();
            String body = zzanpVar.getBody();
            Bundle extras = zzanpVar.getExtras();
            String callToAction = zzanpVar.getCallToAction();
            View view2 = (View) zzat(zzanpVar.zzuf());
            IObjectWrapper iObjectWrapperZzsn = zzanpVar.zzsn();
            String advertiser = zzanpVar.getAdvertiser();
            zzaee zzaeeVarZzso = zzanpVar.zzso();
            zzcei zzceiVar = new zzcei();
            zzceiVar.zzfzr = 1;
            zzceiVar.zzfzs = zzcefVarZza;
            zzceiVar.zzddo = zzadwVarZzsm;
            zzceiVar.zzfzt = view;
            zzceiVar.zzn("headline", headline);
            zzceiVar.zzerh = images;
            zzceiVar.zzn("body", body);
            zzceiVar.extras = extras;
            zzceiVar.zzn("call_to_action", callToAction);
            zzceiVar.zzfzx = view2;
            zzceiVar.zzfzy = iObjectWrapperZzsn;
            zzceiVar.zzn("advertiser", advertiser);
            zzceiVar.zzgaa = zzaeeVarZzso;
            return zzceiVar;
        } catch (RemoteException e2) {
            zzbbq.zzd("Failed to get native ad from content ad mapper", e2);
            return null;
        }
    }

    public static zzcei zzb(zzano zzanoVar) {
        try {
            return zza(zza(zzanoVar.getVideoController(), (zzanu) null), zzanoVar.zzsm(), (View) zzat(zzanoVar.zzue()), zzanoVar.getHeadline(), zzanoVar.getImages(), zzanoVar.getBody(), zzanoVar.getExtras(), zzanoVar.getCallToAction(), (View) zzat(zzanoVar.zzuf()), zzanoVar.zzsn(), zzanoVar.getStore(), zzanoVar.getPrice(), zzanoVar.getStarRating(), zzanoVar.zzsl(), null, WheelView.DividerConfig.FILL);
        } catch (RemoteException e2) {
            zzbbq.zzd("Failed to get native ad assets from app install ad mapper", e2);
            return null;
        }
    }

    public static zzcei zza(zzano zzanoVar) {
        try {
            zzcef zzcefVarZza = zza(zzanoVar.getVideoController(), (zzanu) null);
            zzadw zzadwVarZzsm = zzanoVar.zzsm();
            View view = (View) zzat(zzanoVar.zzue());
            String headline = zzanoVar.getHeadline();
            List<?> images = zzanoVar.getImages();
            String body = zzanoVar.getBody();
            Bundle extras = zzanoVar.getExtras();
            String callToAction = zzanoVar.getCallToAction();
            View view2 = (View) zzat(zzanoVar.zzuf());
            IObjectWrapper iObjectWrapperZzsn = zzanoVar.zzsn();
            String store = zzanoVar.getStore();
            String price = zzanoVar.getPrice();
            double starRating = zzanoVar.getStarRating();
            zzaee zzaeeVarZzsl = zzanoVar.zzsl();
            zzcei zzceiVar = new zzcei();
            zzceiVar.zzfzr = 2;
            zzceiVar.zzfzs = zzcefVarZza;
            zzceiVar.zzddo = zzadwVarZzsm;
            zzceiVar.zzfzt = view;
            zzceiVar.zzn("headline", headline);
            zzceiVar.zzerh = images;
            zzceiVar.zzn("body", body);
            zzceiVar.extras = extras;
            zzceiVar.zzn("call_to_action", callToAction);
            zzceiVar.zzfzx = view2;
            zzceiVar.zzfzy = iObjectWrapperZzsn;
            zzceiVar.zzn(TransactionErrorDetailsUtilities.STORE, store);
            zzceiVar.zzn("price", price);
            zzceiVar.zzerk = starRating;
            zzceiVar.zzfzz = zzaeeVarZzsl;
            return zzceiVar;
        } catch (RemoteException e2) {
            zzbbq.zzd("Failed to get native ad from app install ad mapper", e2);
            return null;
        }
    }

    public static zzcei zzb(zzanp zzanpVar) {
        try {
            return zza(zza(zzanpVar.getVideoController(), (zzanu) null), zzanpVar.zzsm(), (View) zzat(zzanpVar.zzue()), zzanpVar.getHeadline(), zzanpVar.getImages(), zzanpVar.getBody(), zzanpVar.getExtras(), zzanpVar.getCallToAction(), (View) zzat(zzanpVar.zzuf()), zzanpVar.zzsn(), null, null, -1.0d, zzanpVar.zzso(), zzanpVar.getAdvertiser(), WheelView.DividerConfig.FILL);
        } catch (RemoteException e2) {
            zzbbq.zzd("Failed to get native ad assets from content ad mapper", e2);
            return null;
        }
    }

    private static zzcei zza(zzyo zzyoVar, zzadw zzadwVar, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d2, zzaee zzaeeVar, String str6, float f2) {
        zzcei zzceiVar = new zzcei();
        zzceiVar.zzfzr = 6;
        zzceiVar.zzfzs = zzyoVar;
        zzceiVar.zzddo = zzadwVar;
        zzceiVar.zzfzt = view;
        zzceiVar.zzn("headline", str);
        zzceiVar.zzerh = list;
        zzceiVar.zzn("body", str2);
        zzceiVar.extras = bundle;
        zzceiVar.zzn("call_to_action", str3);
        zzceiVar.zzfzx = view2;
        zzceiVar.zzfzy = iObjectWrapper;
        zzceiVar.zzn(TransactionErrorDetailsUtilities.STORE, str4);
        zzceiVar.zzn("price", str5);
        zzceiVar.zzerk = d2;
        zzceiVar.zzfzz = zzaeeVar;
        zzceiVar.zzn("advertiser", str6);
        zzceiVar.setMediaContentAspectRatio(f2);
        return zzceiVar;
    }

    private static zzcef zza(zzyo zzyoVar, zzanu zzanuVar) {
        if (zzyoVar == null) {
            return null;
        }
        return new zzcef(zzyoVar, zzanuVar);
    }
}
