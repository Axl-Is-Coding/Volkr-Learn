package io.rong.imlib.filetransfer;

/* JADX INFO: loaded from: classes5.dex */
public interface RequestCallBack {
    void onCanceled(Object obj);

    void onComplete(String str);

    void onError(int i);

    void onProgress(int i);
}
