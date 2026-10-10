package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CrashlyticsReportWithSessionId {
    public static CrashlyticsReportWithSessionId create(CrashlyticsReport crashlyticsReport, String str) {
        return new AutoValue_CrashlyticsReportWithSessionId(crashlyticsReport, str);
    }

    public abstract CrashlyticsReport getReport();

    public abstract String getSessionId();
}
