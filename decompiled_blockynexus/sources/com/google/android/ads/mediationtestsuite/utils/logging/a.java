package com.google.android.ads.mediationtestsuite.utils.logging;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: LaunchEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {
    @Override // com.google.android.ads.mediationtestsuite.utils.logging.b
    public String getEventType() {
        return "launch";
    }

    @Override // com.google.android.ads.mediationtestsuite.utils.logging.b
    public Map<String, String> getParameters() {
        return new HashMap();
    }
}
