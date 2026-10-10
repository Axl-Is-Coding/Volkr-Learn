package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzvl {
    public static final zzvl zzchs = new zzvl();

    @VisibleForTesting
    protected zzvl() {
    }

    public static zzvg zza(Context context, zzyw zzywVar) {
        Context context2;
        List listUnmodifiableList;
        zzuy zzuyVar;
        String strZza;
        Date birthday = zzywVar.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1L;
        String contentUrl = zzywVar.getContentUrl();
        int gender = zzywVar.getGender();
        Set<String> keywords = zzywVar.getKeywords();
        if (keywords.isEmpty()) {
            context2 = context;
            listUnmodifiableList = null;
        } else {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(keywords));
            context2 = context;
        }
        boolean zIsTestDevice = zzywVar.isTestDevice(context2);
        Location location = zzywVar.getLocation();
        Bundle networkExtrasBundle = zzywVar.getNetworkExtrasBundle(AdMobAdapter.class);
        if (zzywVar.zzqu() != null) {
            zzuyVar = new zzuy(zzywVar.zzqu().getAdString(), zzwm.zzqb().containsKey(zzywVar.zzqu().getQueryInfo()) ? zzwm.zzqb().get(zzywVar.zzqu().getQueryInfo()) : "");
        } else {
            zzuyVar = null;
        }
        boolean manualImpressionsEnabled = zzywVar.getManualImpressionsEnabled();
        String publisherProvidedId = zzywVar.getPublisherProvidedId();
        SearchAdRequest searchAdRequestZzqp = zzywVar.zzqp();
        zzaag zzaagVar = searchAdRequestZzqp != null ? new zzaag(searchAdRequestZzqp) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzwm.zzpt();
            strZza = zzbbg.zza(Thread.currentThread().getStackTrace(), packageName);
        } else {
            strZza = null;
        }
        boolean zIsDesignedForFamilies = zzywVar.isDesignedForFamilies();
        RequestConfiguration requestConfiguration = zzzd.zzqw().getRequestConfiguration();
        return new zzvg(8, time, networkExtrasBundle, gender, listUnmodifiableList, zIsTestDevice, Math.max(zzywVar.zzqs(), requestConfiguration.getTagForChildDirectedTreatment()), manualImpressionsEnabled, publisherProvidedId, zzaagVar, location, contentUrl, zzywVar.zzqr(), zzywVar.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzywVar.zzqt())), zzywVar.zzqo(), strZza, zIsDesignedForFamilies, zzuyVar, Math.max(zzywVar.zzqv(), requestConfiguration.getTagForUnderAgeOfConsent()), (String) Collections.max(Arrays.asList(zzywVar.getMaxAdContentRating(), requestConfiguration.getMaxAdContentRating()), zzvk.zzchr), zzywVar.zzqn());
    }

    static final /* synthetic */ int zzd(String str, String str2) {
        return RequestConfiguration.zzadq.indexOf(str) - RequestConfiguration.zzadq.indexOf(str2);
    }

    public static zzaum zza(Context context, zzyw zzywVar, String str) {
        return new zzaum(zza(context, zzywVar), str);
    }
}
