package com.google.firebase.crashlytics.internal.send;

import com.google.android.datatransport.g;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class DataTransportCrashlyticsReportSender$$Lambda$1 implements g {
    private final TaskCompletionSource arg$1;
    private final CrashlyticsReportWithSessionId arg$2;

    private DataTransportCrashlyticsReportSender$$Lambda$1(TaskCompletionSource taskCompletionSource, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        this.arg$1 = taskCompletionSource;
        this.arg$2 = crashlyticsReportWithSessionId;
    }

    public static g lambdaFactory$(TaskCompletionSource taskCompletionSource, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        return new DataTransportCrashlyticsReportSender$$Lambda$1(taskCompletionSource, crashlyticsReportWithSessionId);
    }

    @Override // com.google.android.datatransport.g
    public void onSchedule(Exception exc) {
        DataTransportCrashlyticsReportSender.lambda$sendReport$1(this.arg$1, this.arg$2, exc);
    }
}
