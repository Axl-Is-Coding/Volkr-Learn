package com.google.android.ads.mediationtestsuite.utils.logging;

import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.ads.mediationtestsuite.dataobjects.NetworkConfig;
import com.google.android.ads.mediationtestsuite.dataobjects.TestResult;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class RequestEvent implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NetworkConfig f12679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Origin f12680b;

    public enum Origin {
        BATCH_REQUEST("batch_test_ad_unit"),
        AD_SOURCE("test_individual_ad_source");

        final String name;

        Origin(String str) {
            this.name = str;
        }
    }

    public RequestEvent(NetworkConfig networkConfig, Origin origin) {
        this.f12679a = networkConfig;
        this.f12680b = origin;
    }

    @Override // com.google.android.ads.mediationtestsuite.utils.logging.b
    public String getEventType() {
        return ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID;
    }

    @Override // com.google.android.ads.mediationtestsuite.utils.logging.b
    public Map<String, String> getParameters() {
        HashMap map = new HashMap();
        if (this.f12679a.getAdUnitId() != null) {
            map.put("ad_unit", this.f12679a.getAdUnitId().getId());
        }
        map.put("format", this.f12679a.getAdapter().getFormat().getFormatString());
        map.put("adapter_class", this.f12679a.getAdapter().getClassName());
        if (this.f12679a.getLabel() != null) {
            map.put("adapter_name", this.f12679a.getLabel());
        }
        if (this.f12679a.getLastTestResult() == TestResult.SUCCESS) {
            map.put("request_result", "success");
        } else if (this.f12679a.getLastTestResult() == TestResult.UNTESTED) {
            map.put("request_result", "incomplete");
        } else {
            map.put("request_result", "failed");
            map.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, Integer.toString(this.f12679a.getLastTestResult().getErrorCode()));
        }
        map.put("origin_screen", this.f12680b.name);
        return map;
    }
}
