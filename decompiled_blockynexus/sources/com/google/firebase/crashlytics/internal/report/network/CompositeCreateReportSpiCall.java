package com.google.firebase.crashlytics.internal.report.network;

import com.google.firebase.crashlytics.internal.report.model.CreateReportRequest;
import com.google.firebase.crashlytics.internal.report.model.Report;

/* JADX INFO: loaded from: classes2.dex */
public class CompositeCreateReportSpiCall implements CreateReportSpiCall {
    private final DefaultCreateReportSpiCall javaReportSpiCall;
    private final NativeCreateReportSpiCall nativeReportSpiCall;

    /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.report.network.CompositeCreateReportSpiCall$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$crashlytics$internal$report$model$Report$Type = new int[Report.Type.values().length];

        static {
            try {
                $SwitchMap$com$google$firebase$crashlytics$internal$report$model$Report$Type[Report.Type.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$internal$report$model$Report$Type[Report.Type.NATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public CompositeCreateReportSpiCall(DefaultCreateReportSpiCall defaultCreateReportSpiCall, NativeCreateReportSpiCall nativeCreateReportSpiCall) {
        this.javaReportSpiCall = defaultCreateReportSpiCall;
        this.nativeReportSpiCall = nativeCreateReportSpiCall;
    }

    @Override // com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall
    public boolean invoke(CreateReportRequest createReportRequest, boolean z) {
        int i = AnonymousClass1.$SwitchMap$com$google$firebase$crashlytics$internal$report$model$Report$Type[createReportRequest.report.getType().ordinal()];
        if (i == 1) {
            this.javaReportSpiCall.invoke(createReportRequest, z);
            return true;
        }
        if (i != 2) {
            return false;
        }
        this.nativeReportSpiCall.invoke(createReportRequest, z);
        return true;
    }
}
