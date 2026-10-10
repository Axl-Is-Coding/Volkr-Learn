package com.google.android.ads.mediationtestsuite.utils.logging;

import com.google.android.ads.mediationtestsuite.dataobjects.NetworkConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: ShowAdEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NetworkConfig f12681a;

    public f(NetworkConfig networkConfig) {
        this.f12681a = networkConfig;
    }

    @Override // com.google.android.ads.mediationtestsuite.utils.logging.b
    public String getEventType() {
        return "show_ad";
    }

    @Override // com.google.android.ads.mediationtestsuite.utils.logging.b
    public Map<String, String> getParameters() {
        HashMap map = new HashMap();
        if (this.f12681a.getAdUnitId() != null) {
            map.put("ad_unit", this.f12681a.getAdUnitId().getId());
        }
        map.put("format", this.f12681a.getAdapter().getFormat().getFormatString());
        map.put("adapter_class", this.f12681a.getAdapter().getClassName());
        if (this.f12681a.getLabel() != null) {
            map.put("adapter_name", this.f12681a.getLabel());
        }
        return map;
    }
}
