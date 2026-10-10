package com.google.android.gms.common.api;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    public abstract void onFailure(Status status);

    @Override // com.google.android.gms.common.api.ResultCallback
    @KeepForSdk
    public final void onResult(R r) {
        Status status = r.getStatus();
        if (status.isSuccess()) {
            onSuccess(r);
            return;
        }
        onFailure(status);
        if (r instanceof Releasable) {
            try {
                ((Releasable) r).release();
            } catch (RuntimeException e2) {
                String strValueOf = String.valueOf(r);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(strValueOf);
                Log.w("ResultCallbacks", sb.toString(), e2);
            }
        }
    }

    public abstract void onSuccess(R r);
}
