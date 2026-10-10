package com.ironsource.sdk.ISNAdView;

import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: ViewVisibilityParameters.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15106b = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15107c = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Boolean> f15105a = new HashMap<String, Boolean>() { // from class: com.ironsource.sdk.ISNAdView.ViewVisibilityParameters$1
        {
            put("isVisible", Boolean.valueOf(this.this$0.f15106b == 0));
            put("isWindowVisible", Boolean.valueOf(this.this$0.f15107c == 0));
            put("isShown", false);
            put("isViewVisible", false);
        }
    };

    k() {
    }

    void a(String str, int i, boolean z) {
        if (this.f15105a.containsKey(str)) {
            this.f15105a.put(str, Boolean.valueOf(i == 0));
        }
        this.f15105a.put("isShown", Boolean.valueOf(z));
        this.f15105a.put("isViewVisible", Boolean.valueOf((this.f15105a.get("isWindowVisible").booleanValue() || this.f15105a.get("isVisible").booleanValue()) && this.f15105a.get("isShown").booleanValue()));
    }

    public JSONObject a() {
        return new JSONObject(this.f15105a);
    }
}
