package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;

/* JADX INFO: loaded from: classes2.dex */
public enum DataTransportState {
    NONE,
    JAVA_ONLY,
    ALL;

    static final int REPORT_UPLOAD_VARIANT_DATATRANSPORT = 2;
    static final int REPORT_UPLOAD_VARIANT_LEGACY = 1;

    static DataTransportState getState(boolean z, boolean z2) {
        return !z ? NONE : !z2 ? JAVA_ONLY : ALL;
    }

    static DataTransportState getState(AppSettingsData appSettingsData) {
        return getState(appSettingsData.reportUploadVariant == 2, appSettingsData.nativeReportUploadVariant == 2);
    }
}
