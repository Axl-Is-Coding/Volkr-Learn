package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class LifecycleActivity {
    private final Object zza;

    public LifecycleActivity(Activity activity) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        this.zza = activity;
    }

    @KeepForSdk
    public Activity asActivity() {
        return (Activity) this.zza;
    }

    @KeepForSdk
    public FragmentActivity asFragmentActivity() {
        return (FragmentActivity) this.zza;
    }

    @KeepForSdk
    public Object asObject() {
        return this.zza;
    }

    @KeepForSdk
    public boolean isChimera() {
        return false;
    }

    @KeepForSdk
    public boolean isSupport() {
        return this.zza instanceof FragmentActivity;
    }

    public final boolean zza() {
        return this.zza instanceof Activity;
    }

    @KeepForSdk
    public LifecycleActivity(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }
}
