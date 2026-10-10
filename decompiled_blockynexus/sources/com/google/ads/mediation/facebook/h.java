package com.google.ads.mediation.facebook;

import android.content.Context;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;
import java.util.ArrayList;

/* JADX INFO: compiled from: FacebookInitializer.java */
/* JADX INFO: loaded from: classes.dex */
class h implements AudienceNetworkAds.InitListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static h f12606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12607b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f12608c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList<a> f12609d = new ArrayList<>();

    /* JADX INFO: compiled from: FacebookInitializer.java */
    interface a {
        void a();

        void a(String str);
    }

    private h() {
    }

    static h a() {
        if (f12606a == null) {
            f12606a = new h();
        }
        return f12606a;
    }

    @Override // com.facebook.ads.AudienceNetworkAds.InitListener
    public void onInitialized(AudienceNetworkAds.InitResult initResult) {
        this.f12607b = false;
        this.f12608c = initResult.isSuccess();
        for (a aVar : this.f12609d) {
            if (initResult.isSuccess()) {
                aVar.a();
            } else {
                aVar.a(initResult.getMessage());
            }
        }
        this.f12609d.clear();
    }

    void a(Context context, String str, a aVar) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        a().a(context, arrayList, aVar);
    }

    void a(Context context, ArrayList<String> arrayList, a aVar) {
        if (this.f12607b) {
            this.f12609d.add(aVar);
            return;
        }
        if (this.f12608c) {
            aVar.a();
            return;
        }
        this.f12607b = true;
        a().f12609d.add(aVar);
        AudienceNetworkAds.buildInitSettings(context).withMediationService("ADMOB_" + MobileAds.getVersionString()).withPlacementIds(arrayList).withInitListener(this).initialize();
    }
}
