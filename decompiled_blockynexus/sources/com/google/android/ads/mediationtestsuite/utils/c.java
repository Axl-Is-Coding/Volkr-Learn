package com.google.android.ads.mediationtestsuite.utils;

import android.os.Bundle;
import android.util.Log;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.ads.mediationtestsuite.MediationTestSuite;
import com.google.android.ads.mediationtestsuite.dataobjects.AdFormat;
import com.google.android.ads.mediationtestsuite.dataobjects.AdUnit;
import com.google.android.ads.mediationtestsuite.dataobjects.NetworkConfig;
import com.google.android.gms.ads.AdRequest;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdRequestUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    /* JADX WARN: Multi-variable type inference failed */
    public static AdRequest a(Map<String, String> map, NetworkConfig networkConfig) {
        AdRequest.Builder builder = new AdRequest.Builder();
        if (!networkConfig.getAdapter().getClassName().equals(AdUnit.GOOGLE_ADAPTER_CLASS)) {
            String strB = b(map, networkConfig);
            Bundle bundle = new Bundle();
            bundle.putString("_ad", strB);
            bundle.putBoolean("_mts", true);
            builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        }
        AdRequest testRequest = MediationTestSuite.getTestRequest();
        if (testRequest != null) {
            try {
                Class<?> cls = Class.forName(networkConfig.getAdapter().getClassName());
                Bundle networkExtrasBundle = testRequest.getNetworkExtrasBundle(cls);
                if (networkExtrasBundle != null) {
                    builder.addNetworkExtrasBundle(cls, networkExtrasBundle);
                }
            } catch (ClassCastException unused) {
                String strValueOf = String.valueOf(networkConfig.getAdapter().getClassName());
                Log.e("gma_test", strValueOf.length() != 0 ? "Adapter class not a mediation adapter: ".concat(strValueOf) : new String("Adapter class not a mediation adapter: "));
            } catch (ClassNotFoundException unused2) {
                String strValueOf2 = String.valueOf(networkConfig.getAdapter().getClassName());
                Log.e("gma_test", strValueOf2.length() != 0 ? "Class not found for adapter class".concat(strValueOf2) : new String("Class not found for adapter class"));
            }
            if (testRequest.getKeywords() != null) {
                Iterator<String> it = testRequest.getKeywords().iterator();
                while (it.hasNext()) {
                    builder.addKeyword(it.next());
                }
            }
            if (testRequest.getLocation() != null) {
                builder.setLocation(testRequest.getLocation());
            }
            if (testRequest.getContentUrl() != null) {
                builder.setContentUrl(testRequest.getContentUrl());
            }
        }
        Iterator<String> it2 = MediationTestSuite.getTestDevices().iterator();
        while (it2.hasNext()) {
            builder.addTestDevice(it2.next());
        }
        return builder.build();
    }

    private static String b(Map<String, String> map, NetworkConfig networkConfig) {
        String className;
        JSONObject jSONObject = new JSONObject(map);
        if (networkConfig.getAdapter().getNetwork() != null) {
            className = networkConfig.getAdapter().getClassName();
        } else {
            try {
                jSONObject.put("class_name", networkConfig.getAdapter().getClassName());
            } catch (JSONException e2) {
                Log.e("gma_test", e2.getLocalizedMessage());
            }
            className = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        }
        return "{\"mediation\":true,\"ad_json\":{\"ad_type\":\"banner\",\"qdata\":\"x\",\"ad_networks\":[{\"adapters\":[\"***ADAPTER_CLASS_NAME***\"],\"id\":\"garbage\",\"imp_urls\":[\"http://google.com\"],\"data\":***SERVER_PARAMS***}],\"settings\":{\"click_urls\":[\"@gw_adnetid@\"],\"imp_urls\":[],\"nofill_urls\":[\"http://google.com\"],\"refresh\":\"60\"}}}".replace("***ADAPTER_CLASS_NAME***", className).replace("***SERVER_PARAMS***", jSONObject.toString());
    }

    public static String a(AdFormat adFormat) {
        int i = b.f12669a[adFormat.ordinal()];
        if (i == 1) {
            return "ca-app-pub-3940256099942544/6300978111";
        }
        if (i == 2) {
            return "ca-app-pub-3940256099942544/1033173712";
        }
        if (i == 3) {
            return "ca-app-pub-3940256099942544/5224354917";
        }
        if (i == 4) {
            return "ca-app-pub-3940256099942544/2247696110";
        }
        Log.w("gma_test", "Unknown format requested, no available AdMob ad unit ID.");
        return "";
    }
}
