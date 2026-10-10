package com.sandboxol.common.utils.luban;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public interface OnCompressListener {
    void onError(Throwable th);

    void onStart();

    void onSuccess(File file);
}
