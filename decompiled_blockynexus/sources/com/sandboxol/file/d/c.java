package com.sandboxol.file.d;

import com.sandboxol.file.entity.Progress;

/* JADX INFO: compiled from: OnDownloadListener.java */
/* JADX INFO: loaded from: classes3.dex */
public interface c extends a {
    void onComplete(Progress progress);

    void onError(Throwable th);

    void onNext(Progress progress);

    void onSubscribe(Throwable th);
}
