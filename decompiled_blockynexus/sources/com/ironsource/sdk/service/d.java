package com.ironsource.sdk.service;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PackagesInstallationService.java */
/* JADX INFO: loaded from: classes2.dex */
class d extends JSONObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f15410a;

    d(boolean z) throws JSONException {
        this.f15410a = z;
        put("isInstalled", this.f15410a);
    }
}
