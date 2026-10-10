package com.google.android.ads.mediationtestsuite.utils.logging;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AdUnitsViewEvent implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewType f12678a;

    public enum ViewType {
        FAILING("failing_ad_units"),
        WORKING("working_ad_units"),
        SEARCH("search_ad_units");

        final String name;

        ViewType(String str) {
            this.name = str;
        }
    }

    public AdUnitsViewEvent(ViewType viewType) {
        this.f12678a = viewType;
    }

    @Override // com.google.android.ads.mediationtestsuite.utils.logging.b
    public String getEventType() {
        return "ad_units_view";
    }

    @Override // com.google.android.ads.mediationtestsuite.utils.logging.b
    public Map<String, String> getParameters() {
        HashMap map = new HashMap();
        map.put("view_type", this.f12678a.name);
        return map;
    }
}
