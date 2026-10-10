package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public interface LifecycleFragment {
    @KeepForSdk
    void addCallback(String str, LifecycleCallback lifecycleCallback);

    @KeepForSdk
    <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls);

    @KeepForSdk
    Activity getLifecycleActivity();

    @KeepForSdk
    boolean isCreated();

    @KeepForSdk
    boolean isStarted();

    @KeepForSdk
    void startActivityForResult(Intent intent, int i);
}
