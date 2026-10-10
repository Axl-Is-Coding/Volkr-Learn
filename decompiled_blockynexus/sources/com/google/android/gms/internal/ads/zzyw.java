package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzyw {
    private final int zzadm;
    private final int zzadn;
    private final String zzado;
    private final boolean zzbny;
    private final int zzchc;
    private final String zzchf;
    private final String zzchh;
    private final Bundle zzchj;
    private final String zzchl;
    private final boolean zzchn;
    private final List<String> zzchp;
    private final Bundle zzcjm;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzcjn;
    private final SearchAdRequest zzcjo;
    private final Set<String> zzcjp;
    private final Set<String> zzcjq;
    private final AdInfo zzcjr;
    private final Date zzmx;
    private final Set<String> zzmz;
    private final Location zznb;

    public zzyw(zzyz zzyzVar) {
        this(zzyzVar, null);
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zzmx;
    }

    public final String getContentUrl() {
        return this.zzchh;
    }

    public final Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzcjm.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle getCustomTargeting() {
        return this.zzchj;
    }

    @Deprecated
    public final int getGender() {
        return this.zzchc;
    }

    public final Set<String> getKeywords() {
        return this.zzmz;
    }

    public final Location getLocation() {
        return this.zznb;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbny;
    }

    public final String getMaxAdContentRating() {
        return this.zzado;
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (T) this.zzcjn.get(cls);
    }

    public final Bundle getNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls) {
        return this.zzcjm.getBundle(cls.getName());
    }

    public final String getPublisherProvidedId() {
        return this.zzchf;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzchn;
    }

    public final boolean isTestDevice(Context context) {
        RequestConfiguration requestConfiguration = zzzd.zzqw().getRequestConfiguration();
        zzwm.zzpt();
        String strZzbn = zzbbg.zzbn(context);
        return this.zzcjp.contains(strZzbn) || requestConfiguration.getTestDeviceIds().contains(strZzbn);
    }

    public final List<String> zzqn() {
        return new ArrayList(this.zzchp);
    }

    public final String zzqo() {
        return this.zzchl;
    }

    public final SearchAdRequest zzqp() {
        return this.zzcjo;
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzqq() {
        return this.zzcjn;
    }

    public final Bundle zzqr() {
        return this.zzcjm;
    }

    public final int zzqs() {
        return this.zzadm;
    }

    public final Set<String> zzqt() {
        return this.zzcjq;
    }

    public final AdInfo zzqu() {
        return this.zzcjr;
    }

    public final int zzqv() {
        return this.zzadn;
    }

    public zzyw(zzyz zzyzVar, SearchAdRequest searchAdRequest) {
        this.zzmx = zzyzVar.zzmx;
        this.zzchh = zzyzVar.zzchh;
        this.zzchp = zzyzVar.zzchp;
        this.zzchc = zzyzVar.zzchc;
        this.zzmz = Collections.unmodifiableSet(zzyzVar.zzcjz);
        this.zznb = zzyzVar.zznb;
        this.zzbny = zzyzVar.zzbny;
        this.zzcjm = zzyzVar.zzcjm;
        this.zzcjn = Collections.unmodifiableMap(zzyzVar.zzcka);
        this.zzchf = zzyzVar.zzchf;
        this.zzchl = zzyzVar.zzchl;
        this.zzcjo = searchAdRequest;
        this.zzadm = zzyzVar.zzadm;
        this.zzcjp = Collections.unmodifiableSet(zzyzVar.zzckb);
        this.zzchj = zzyzVar.zzchj;
        this.zzcjq = Collections.unmodifiableSet(zzyzVar.zzckc);
        this.zzchn = zzyzVar.zzchn;
        this.zzcjr = zzyzVar.zzcjr;
        this.zzadn = zzyzVar.zzadn;
        this.zzado = zzyzVar.zzado;
    }
}
