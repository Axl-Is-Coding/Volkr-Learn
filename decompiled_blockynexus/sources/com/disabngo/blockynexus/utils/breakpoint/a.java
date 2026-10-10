package com.disabngo.blockynexus.utils.breakpoint;

/* JADX INFO: compiled from: DownloadListener.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a {
    void onCanceled();

    void onFailed();

    void onPaused();

    void onProgress(int i);

    void onSuccess();
}
