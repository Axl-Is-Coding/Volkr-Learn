package com.google.android.ads.mediationtestsuite.dataobjects;

import com.google.android.ads.mediationtestsuite.utils.m;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.a.c;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes.dex */
public class AdUnitResponse implements Cloneable {

    @c("ad_unit_id")
    private String adUnitId;

    @c(FirebaseAnalytics.Param.AD_UNIT_NAME)
    private String adUnitName;
    private AdFormat format;

    @c("mediation_config")
    private MediationConfig mediationConfig;

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public String getAdUnitName() {
        return this.adUnitName;
    }

    public AdFormat getFormat() {
        return this.format;
    }

    public MediationConfig getMediationConfig() {
        return this.mediationConfig;
    }

    public void setAdUnitId(String str) {
        this.adUnitId = str;
    }

    public void setFormat(AdFormat adFormat) {
        this.format = adFormat;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AdUnitResponse m59clone() {
        j jVarA = m.a();
        return (AdUnitResponse) jVarA.a(jVarA.b(this), new TypeToken<AdUnitResponse>(this) { // from class: com.google.android.ads.mediationtestsuite.dataobjects.AdUnitResponse.1
        }.getType());
    }
}
