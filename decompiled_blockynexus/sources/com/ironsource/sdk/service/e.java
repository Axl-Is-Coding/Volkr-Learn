package com.ironsource.sdk.service;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PackagesInstallationService.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15411a = "e";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ArrayList<String> f15412b = new ArrayList<String>() { // from class: com.ironsource.sdk.service.PackagesInstallationService$1
        {
            add("com.google.market");
            add("com.android.vending");
        }
    };

    public static boolean a(Context context) {
        JSONObject jSONObjectB = b(context);
        Iterator<String> itKeys = jSONObjectB.keys();
        while (itKeys.hasNext()) {
            JSONObject jSONObjectOptJSONObject = jSONObjectB.optJSONObject(itKeys.next());
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optBoolean("isInstalled")) {
                return true;
            }
        }
        return false;
    }

    private static JSONObject b(Context context) {
        return a(context, f15412b);
    }

    private static ArrayList<String> c(Context context) {
        List<ApplicationInfo> listH = com.ironsource.environment.b.h(context);
        ArrayList<String> arrayList = new ArrayList<>();
        for (ApplicationInfo applicationInfo : listH) {
            if (applicationInfo != null) {
                arrayList.add(applicationInfo.packageName.toLowerCase());
            }
        }
        return arrayList;
    }

    private static JSONObject a(Context context, ArrayList<String> arrayList) {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList<String> arrayListC = c(context);
            for (String str : arrayList) {
                jSONObject.put(str, a(arrayListC.contains(str.trim().toLowerCase())));
            }
        } catch (Exception e2) {
            b.f.d.a.a aVar = new b.f.d.a.a();
            aVar.a("callfailreason", e2.getMessage());
            aVar.a("generalmessage", arrayList.toString());
            b.f.d.a.e.a(b.f.d.a.g.m, aVar.a());
            com.ironsource.sdk.utils.f.a(f15411a, "Error while extracting packages installation data");
        }
        return jSONObject;
    }

    private static JSONObject a(boolean z) throws JSONException {
        return new d(z);
    }
}
