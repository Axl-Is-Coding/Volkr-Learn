package com.google.firebase.crashlytics.internal.send;

import com.google.android.datatransport.d;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class DataTransportCrashlyticsReportSender$$Lambda$2 implements d {
    private static final DataTransportCrashlyticsReportSender$$Lambda$2 instance = new DataTransportCrashlyticsReportSender$$Lambda$2();

    private DataTransportCrashlyticsReportSender$$Lambda$2() {
    }

    @Override // com.google.android.datatransport.d
    public Object apply(Object obj) {
        return DataTransportCrashlyticsReportSender.lambda$static$0((CrashlyticsReport) obj);
    }
}
