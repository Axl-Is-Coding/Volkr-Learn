package com.google.firebase.crashlytics.internal.settings.model;

/* JADX INFO: loaded from: classes2.dex */
public interface Settings {
    int getCacheDuration();

    long getExpiresAtMillis();

    FeaturesSettingsData getFeaturesData();

    SessionSettingsData getSessionData();

    int getSettingsVersion();

    boolean isExpired(long j);
}
