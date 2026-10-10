package com.google.firebase.crashlytics.internal.send;

import android.content.Context;
import com.google.android.datatransport.b;
import com.google.android.datatransport.c;
import com.google.android.datatransport.cct.a;
import com.google.android.datatransport.d;
import com.google.android.datatransport.e;
import com.google.android.datatransport.runtime.u;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public class DataTransportCrashlyticsReportSender {
    private static final String CRASHLYTICS_TRANSPORT_NAME = "FIREBASE_CRASHLYTICS_REPORT";
    private final e<CrashlyticsReport> transport;
    private final d<CrashlyticsReport, byte[]> transportTransform;
    private static final CrashlyticsReportJsonTransform TRANSFORM = new CrashlyticsReportJsonTransform();
    private static final String CRASHLYTICS_ENDPOINT = mergeStrings("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");
    private static final String CRASHLYTICS_API_KEY = mergeStrings("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");
    private static final d<CrashlyticsReport, byte[]> DEFAULT_TRANSFORM = DataTransportCrashlyticsReportSender$$Lambda$2.instance;

    DataTransportCrashlyticsReportSender(e<CrashlyticsReport> eVar, d<CrashlyticsReport, byte[]> dVar) {
        this.transport = eVar;
        this.transportTransform = dVar;
    }

    public static DataTransportCrashlyticsReportSender create(Context context) {
        u.a(context);
        return new DataTransportCrashlyticsReportSender(u.a().a(new a(CRASHLYTICS_ENDPOINT, CRASHLYTICS_API_KEY)).a(CRASHLYTICS_TRANSPORT_NAME, CrashlyticsReport.class, b.a("json"), DEFAULT_TRANSFORM), DEFAULT_TRANSFORM);
    }

    static /* synthetic */ void lambda$sendReport$1(TaskCompletionSource taskCompletionSource, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, Exception exc) {
        if (exc != null) {
            taskCompletionSource.trySetException(exc);
        } else {
            taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
        }
    }

    static /* synthetic */ byte[] lambda$static$0(CrashlyticsReport crashlyticsReport) {
        return TRANSFORM.reportToJson(crashlyticsReport).getBytes(Charset.forName("UTF-8"));
    }

    private static String mergeStrings(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str.length() + str2.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    public Task<CrashlyticsReportWithSessionId> sendReport(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        CrashlyticsReport report = crashlyticsReportWithSessionId.getReport();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.transport.a(c.a(report), DataTransportCrashlyticsReportSender$$Lambda$1.lambdaFactory$(taskCompletionSource, crashlyticsReportWithSessionId));
        return taskCompletionSource.getTask();
    }
}
