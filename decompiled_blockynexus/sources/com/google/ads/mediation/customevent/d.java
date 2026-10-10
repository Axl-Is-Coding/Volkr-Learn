package com.google.ads.mediation.customevent;

import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.plus.PlusShare;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends MediationServerParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @MediationServerParameters.a(name = PlusShare.KEY_CALL_TO_ACTION_LABEL, required = true)
    public String f12564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @MediationServerParameters.a(name = "class_name", required = true)
    public String f12565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @MediationServerParameters.a(name = MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD, required = false)
    public String f12566c = null;
}
