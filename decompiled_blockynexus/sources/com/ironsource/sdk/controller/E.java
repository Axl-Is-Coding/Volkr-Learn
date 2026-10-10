package com.ironsource.sdk.controller;

import android.text.TextUtils;
import com.ironsource.sdk.data.SSAEnums$ProductType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: DemandSourceManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, com.ironsource.sdk.data.d> f15138a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, com.ironsource.sdk.data.d> f15139b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, com.ironsource.sdk.data.d> f15140c = new LinkedHashMap();

    private Map<String, com.ironsource.sdk.data.d> b(SSAEnums$ProductType sSAEnums$ProductType) {
        if (sSAEnums$ProductType.name().equalsIgnoreCase(SSAEnums$ProductType.RewardedVideo.name())) {
            return this.f15138a;
        }
        if (sSAEnums$ProductType.name().equalsIgnoreCase(SSAEnums$ProductType.Interstitial.name())) {
            return this.f15139b;
        }
        if (sSAEnums$ProductType.name().equalsIgnoreCase(SSAEnums$ProductType.Banner.name())) {
            return this.f15140c;
        }
        return null;
    }

    public Collection<com.ironsource.sdk.data.d> a(SSAEnums$ProductType sSAEnums$ProductType) {
        Map<String, com.ironsource.sdk.data.d> mapB = b(sSAEnums$ProductType);
        return mapB != null ? mapB.values() : new ArrayList();
    }

    public com.ironsource.sdk.data.d a(SSAEnums$ProductType sSAEnums$ProductType, String str) {
        Map<String, com.ironsource.sdk.data.d> mapB;
        if (TextUtils.isEmpty(str) || (mapB = b(sSAEnums$ProductType)) == null) {
            return null;
        }
        return mapB.get(str);
    }

    private void a(SSAEnums$ProductType sSAEnums$ProductType, String str, com.ironsource.sdk.data.d dVar) {
        Map<String, com.ironsource.sdk.data.d> mapB;
        if (TextUtils.isEmpty(str) || dVar == null || (mapB = b(sSAEnums$ProductType)) == null) {
            return;
        }
        mapB.put(str, dVar);
    }

    public com.ironsource.sdk.data.d a(SSAEnums$ProductType sSAEnums$ProductType, b.f.d.b bVar) {
        String strC = bVar.c();
        com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(strC, bVar.d(), bVar.a(), bVar.b());
        a(sSAEnums$ProductType, strC, dVar);
        return dVar;
    }

    public com.ironsource.sdk.data.d a(SSAEnums$ProductType sSAEnums$ProductType, String str, Map<String, String> map, b.f.d.g.a aVar) {
        com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str, str, map, aVar);
        a(sSAEnums$ProductType, str, dVar);
        return dVar;
    }
}
