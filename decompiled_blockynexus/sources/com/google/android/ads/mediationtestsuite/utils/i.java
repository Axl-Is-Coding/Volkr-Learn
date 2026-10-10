package com.google.android.ads.mediationtestsuite.utils;

import com.android.volley.m;
import com.google.android.ads.mediationtestsuite.dataobjects.AdUnit;
import com.google.android.ads.mediationtestsuite.dataobjects.ConfigResponse;
import com.google.android.ads.mediationtestsuite.dataobjects.DataStore;
import com.google.android.ads.mediationtestsuite.dataobjects.NetworkAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: MediationConfigClient.java */
/* JADX INFO: loaded from: classes.dex */
class i implements m.b<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f12675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f12676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ m.b f12677c;

    i(Map map, Map map2, m.b bVar) {
        this.f12675a = map;
        this.f12676b = map2;
        this.f12677c = bVar;
    }

    @Override // com.android.volley.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResponse(JSONObject jSONObject) {
        List<AdUnit> listA = m.a(jSONObject, (Map<String, Map<String, NetworkAdapter>>) this.f12675a);
        m.a(DataStore.getContext(), new ArrayList(this.f12676b.values()), listA);
        this.f12677c.onResponse(new ConfigResponse(listA, new ArrayList(this.f12676b.values())));
    }
}
