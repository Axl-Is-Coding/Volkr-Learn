package com.ironsource.sdk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FeaturesManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile H f15153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, ?> f15154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<String> f15155c = new ArrayList<String>() { // from class: com.ironsource.sdk.controller.FeaturesManager$1
        {
            add("webviewperad-v1");
            add("noPackagesInstallationPolling");
        }
    };

    private H() {
        if (f15153a != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
        this.f15154b = new HashMap();
    }

    public static H b() {
        if (f15153a == null) {
            synchronized (H.class) {
                if (f15153a == null) {
                    f15153a = new H();
                }
            }
        }
        return f15153a;
    }

    public int a() {
        Integer num = 0;
        try {
            if (this.f15154b.containsKey("debugMode")) {
                num = (Integer) this.f15154b.get("debugMode");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    ArrayList<String> c() {
        return new ArrayList<>(this.f15155c);
    }
}
