package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbtp;
import com.google.android.gms.internal.ads.zzbys;
import com.google.android.gms.internal.ads.zzdbd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdaq extends zzaxk {
    private static final List<String> zzguf = new ArrayList(Arrays.asList("/aclk", "/pcs/click"));
    private static final List<String> zzgug = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com"));
    private static final List<String> zzguh = new ArrayList(Arrays.asList("/pagead/adview", "/pcs/view", "/pagead/conversion"));
    private static final List<String> zzgui = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"));
    private zzbbx zzbot;
    private final ScheduledExecutorService zzfmv;
    private zzeg zzfna;
    private Point zzfye = new Point();
    private Point zzfyf = new Point();
    private final zzdzb zzgcz;
    private zzdoz<zzcil> zzgpl;
    private zzbix zzguj;
    private zzasa zzguk;
    private Context zzvr;

    public zzdaq(zzbix zzbixVar, Context context, zzeg zzegVar, zzbbx zzbbxVar, zzdoz<zzcil> zzdozVar, zzdzb zzdzbVar, ScheduledExecutorService scheduledExecutorService) {
        this.zzguj = zzbixVar;
        this.zzvr = context;
        this.zzfna = zzegVar;
        this.zzbot = zzbbxVar;
        this.zzgpl = zzdozVar;
        this.zzgcz = zzdzbVar;
        this.zzfmv = scheduledExecutorService;
    }

    private final boolean zzarf() {
        Map<String, WeakReference<View>> map;
        zzasa zzasaVar = this.zzguk;
        return (zzasaVar == null || (map = zzasaVar.zzdqc) == null || map.isEmpty()) ? false : true;
    }

    static /* synthetic */ Uri zzc(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? zza(uri, "nas", str) : uri;
    }

    private final zzdzc<String> zzgr(final String str) {
        final zzcil[] zzcilVarArr = new zzcil[1];
        zzdzc zzdzcVarZzb = zzdyq.zzb(this.zzgpl.zzatt(), new zzdya(this, zzcilVarArr, str) { // from class: com.google.android.gms.internal.ads.zzdax
            private final String zzdjk;
            private final zzdaq zzguc;
            private final zzcil[] zzgul;

            {
                this.zzguc = this;
                this.zzgul = zzcilVarArr;
                this.zzdjk = str;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzguc.zza(this.zzgul, this.zzdjk, (zzcil) obj);
            }
        }, this.zzgcz);
        zzdzcVarZzb.addListener(new Runnable(this, zzcilVarArr) { // from class: com.google.android.gms.internal.ads.zzdba
            private final zzdaq zzguc;
            private final zzcil[] zzgul;

            {
                this.zzguc = this;
                this.zzgul = zzcilVarArr;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzguc.zza(this.zzgul);
            }
        }, this.zzgcz);
        return zzdyl.zzg(zzdzcVarZzb).zza(((Integer) zzwm.zzpx().zzd(zzabb.zzcxq)).intValue(), TimeUnit.MILLISECONDS, this.zzfmv).zza(zzdav.zzdwz, this.zzgcz).zza(Exception.class, zzday.zzdwz, this.zzgcz);
    }

    private static boolean zzk(Uri uri) {
        return zza(uri, zzguh, zzgui);
    }

    @Override // com.google.android.gms.internal.ads.zzaxl
    public final void zza(IObjectWrapper iObjectWrapper, zzaxr zzaxrVar, zzaxg zzaxgVar) {
        this.zzvr = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        Context context = this.zzvr;
        String str = zzaxrVar.zzbuu;
        String str2 = zzaxrVar.zzbrb;
        zzvn zzvnVar = zzaxrVar.zzdye;
        zzvg zzvgVarZzpj = zzaxrVar.zzdyf;
        zzdan zzdanVarZzadx = this.zzguj.zzadx();
        zzbtp.zza zzaVarZzce = new zzbtp.zza().zzce(context);
        zzdom zzdomVar = new zzdom();
        if (str == null) {
            str = "adUnitId";
        }
        zzdom zzdomVarZzgt = zzdomVar.zzgt(str);
        if (zzvgVarZzpj == null) {
            zzvgVarZzpj = new zzvj().zzpj();
        }
        zzdom zzdomVarZzh = zzdomVarZzgt.zzh(zzvgVarZzpj);
        if (zzvnVar == null) {
            zzvnVar = new zzvn();
        }
        zzdyq.zza(zzdanVarZzadx.zzg(zzaVarZzce.zza(zzdomVarZzh.zze(zzvnVar).zzatn()).zzajv()).zza(new zzdbd(new zzdbd.zza().zzgs(str2))).zzg(new zzbys.zza().zzakr()).zzagt().zzags(), new zzdaz(this, zzaxgVar), this.zzguj.zzadi());
    }

    @Override // com.google.android.gms.internal.ads.zzaxl
    public final void zzan(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcxp)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzasa zzasaVar = this.zzguk;
            this.zzfye = zzbau.zza(motionEvent, zzasaVar == null ? null : zzasaVar.zzaat);
            if (motionEvent.getAction() == 0) {
                this.zzfyf = this.zzfye;
            }
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            Point point = this.zzfye;
            motionEventObtain.setLocation(point.x, point.y);
            this.zzfna.zza(motionEventObtain);
            motionEventObtain.recycle();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxl
    public final IObjectWrapper zzao(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaxl
    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaxl
    public final void zzb(List<Uri> list, final IObjectWrapper iObjectWrapper, zzart zzartVar) {
        try {
            if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcxp)).booleanValue()) {
                zzartVar.onError("The updating URL feature is not enabled.");
                return;
            }
            if (list.size() != 1) {
                zzartVar.onError("There should be only 1 click URL.");
                return;
            }
            final Uri uri = list.get(0);
            if (zza(uri, zzguf, zzgug)) {
                zzdzc zzdzcVarSubmit = this.zzgcz.submit(new Callable(this, uri, iObjectWrapper) { // from class: com.google.android.gms.internal.ads.zzdar
                    private final Uri zzebh;
                    private final zzdaq zzguc;
                    private final IObjectWrapper zzgue;

                    {
                        this.zzguc = this;
                        this.zzebh = uri;
                        this.zzgue = iObjectWrapper;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zzguc.zzb(this.zzebh, this.zzgue);
                    }
                });
                if (zzarf()) {
                    zzdzcVarSubmit = zzdyq.zzb(zzdzcVarSubmit, new zzdya(this) { // from class: com.google.android.gms.internal.ads.zzdau
                        private final zzdaq zzguc;

                        {
                            this.zzguc = this;
                        }

                        @Override // com.google.android.gms.internal.ads.zzdya
                        public final zzdzc zzf(Object obj) {
                            return this.zzguc.zzl((Uri) obj);
                        }
                    }, this.zzgcz);
                } else {
                    zzbbq.zzfd("Asset view map is empty.");
                }
                zzdyq.zza(zzdzcVarSubmit, new zzdbb(this, zzartVar), this.zzguj.zzadi());
                return;
            }
            String strValueOf = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 18);
            sb.append("Not a Google URL: ");
            sb.append(strValueOf);
            zzbbq.zzfe(sb.toString());
            zzartVar.onSuccess(list);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    final /* synthetic */ zzdzc zzl(final Uri uri) throws Exception {
        return zzdyq.zzb(zzgr("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzdvu(this, uri) { // from class: com.google.android.gms.internal.ads.zzdaw
            private final Uri zzebh;
            private final zzdaq zzguc;

            {
                this.zzguc = this;
                this.zzebh = uri;
            }

            @Override // com.google.android.gms.internal.ads.zzdvu
            public final Object apply(Object obj) {
                return zzdaq.zzc(this.zzebh, (String) obj);
            }
        }, this.zzgcz);
    }

    final /* synthetic */ zzdzc zzb(final ArrayList arrayList) throws Exception {
        return zzdyq.zzb(zzgr("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzdvu(this, arrayList) { // from class: com.google.android.gms.internal.ads.zzdat
            private final zzdaq zzguc;
            private final List zzgud;

            {
                this.zzguc = this;
                this.zzgud = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzdvu
            public final Object apply(Object obj) {
                return zzdaq.zza(this.zzgud, (String) obj);
            }
        }, this.zzgcz);
    }

    @Override // com.google.android.gms.internal.ads.zzaxl
    public final void zza(zzasa zzasaVar) {
        this.zzguk = zzasaVar;
        this.zzgpl.zzed(1);
    }

    @Override // com.google.android.gms.internal.ads.zzaxl
    public final void zza(final List<Uri> list, final IObjectWrapper iObjectWrapper, zzart zzartVar) {
        if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcxp)).booleanValue()) {
            try {
                zzartVar.onError("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e2) {
                zzbbq.zzc("", e2);
                return;
            }
        }
        zzdzc zzdzcVarSubmit = this.zzgcz.submit(new Callable(this, list, iObjectWrapper) { // from class: com.google.android.gms.internal.ads.zzdap
            private final zzdaq zzguc;
            private final List zzgud;
            private final IObjectWrapper zzgue;

            {
                this.zzguc = this;
                this.zzgud = list;
                this.zzgue = iObjectWrapper;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzguc.zza(this.zzgud, this.zzgue);
            }
        });
        if (zzarf()) {
            zzdzcVarSubmit = zzdyq.zzb(zzdzcVarSubmit, new zzdya(this) { // from class: com.google.android.gms.internal.ads.zzdas
                private final zzdaq zzguc;

                {
                    this.zzguc = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdya
                public final zzdzc zzf(Object obj) {
                    return this.zzguc.zzb((ArrayList) obj);
                }
            }, this.zzgcz);
        } else {
            zzbbq.zzfd("Asset view map is empty.");
        }
        zzdyq.zza(zzdzcVarSubmit, new zzdbc(this, zzartVar), this.zzguj.zzadi());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Uri zzb(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        try {
            uri = this.zzfna.zza(uri, this.zzvr, (View) ObjectWrapper.unwrap(iObjectWrapper), null);
        } catch (zzef e2) {
            zzbbq.zzd("", e2);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    private static boolean zza(Uri uri, List<String> list, List<String> list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (host != null && path != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (path.contains(it.next())) {
                    Iterator<String> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (host.endsWith(it2.next())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static Uri zza(Uri uri, String str, String str2) {
        String string = uri.toString();
        int iIndexOf = string.indexOf("&adurl=");
        if (iIndexOf == -1) {
            iIndexOf = string.indexOf("?adurl=");
        }
        if (iIndexOf != -1) {
            int i = iIndexOf + 1;
            return Uri.parse(string.substring(0, i) + str + "=" + str2 + "&" + string.substring(i));
        }
        return uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    final /* synthetic */ void zza(zzcil[] zzcilVarArr) {
        if (zzcilVarArr[0] != null) {
            this.zzgpl.zzd(zzdyq.zzaf(zzcilVarArr[0]));
        }
    }

    final /* synthetic */ zzdzc zza(zzcil[] zzcilVarArr, String str, zzcil zzcilVar) throws Exception {
        zzcilVarArr[0] = zzcilVar;
        Context context = this.zzvr;
        zzasa zzasaVar = this.zzguk;
        Map<String, WeakReference<View>> map = zzasaVar.zzdqc;
        JSONObject jSONObjectZza = zzbau.zza(context, map, map, zzasaVar.zzaat);
        JSONObject jSONObjectZza2 = zzbau.zza(this.zzvr, this.zzguk.zzaat);
        JSONObject jSONObjectZzt = zzbau.zzt(this.zzguk.zzaat);
        JSONObject jSONObjectZzb = zzbau.zzb(this.zzvr, this.zzguk.zzaat);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", jSONObjectZza);
        jSONObject.put("ad_view_signal", jSONObjectZza2);
        jSONObject.put("scroll_view_signal", jSONObjectZzt);
        jSONObject.put("lock_screen_signal", jSONObjectZzb);
        if (str == "google.afma.nativeAds.getPublisherCustomRenderedClickSignals") {
            jSONObject.put("click_signal", zzbau.zza((String) null, this.zzvr, this.zzfyf, this.zzfye));
        }
        return zzcilVar.zzc(str, jSONObject);
    }

    static final /* synthetic */ String zza(Exception exc) {
        zzbbq.zzc("", exc);
        return null;
    }

    static /* synthetic */ ArrayList zza(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (zzk(uri) && !TextUtils.isEmpty(str)) {
                arrayList.add(zza(uri, "nas", str));
            } else {
                arrayList.add(uri);
            }
        }
        return arrayList;
    }

    final /* synthetic */ ArrayList zza(List list, IObjectWrapper iObjectWrapper) throws Exception {
        String strZza = this.zzfna.zzca() != null ? this.zzfna.zzca().zza(this.zzvr, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null) : "";
        if (!TextUtils.isEmpty(strZza)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                if (!zzk(uri)) {
                    String strValueOf = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 18);
                    sb.append("Not a Google URL: ");
                    sb.append(strValueOf);
                    zzbbq.zzfe(sb.toString());
                    arrayList.add(uri);
                } else {
                    arrayList.add(zza(uri, "ms", strZza));
                }
            }
            if (arrayList.isEmpty()) {
                throw new Exception("Empty impression URLs result.");
            }
            return arrayList;
        }
        throw new Exception("Failed to get view signals.");
    }
}
