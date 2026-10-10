package io.rong.imkit.manager;

import android.net.Uri;

/* JADX INFO: loaded from: classes5.dex */
public interface IAudioPlayListener {
    void onComplete(Uri uri);

    void onStart(Uri uri);

    void onStop(Uri uri);
}
