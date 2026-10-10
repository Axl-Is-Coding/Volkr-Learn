package com.sandboxol.file.d;

import com.sandboxol.file.entity.Progress;

/* JADX INFO: compiled from: OnUnzipListener.java */
/* JADX INFO: loaded from: classes3.dex */
public interface e extends a {
    void error(Throwable th);

    void progress(Progress progress);

    void success();
}
