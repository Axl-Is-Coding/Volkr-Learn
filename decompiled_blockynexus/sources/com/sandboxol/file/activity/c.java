package com.sandboxol.file.activity;

import android.util.Log;
import com.sandboxol.file.entity.Progress;

/* JADX INFO: compiled from: DownloadActivity.java */
/* JADX INFO: loaded from: classes3.dex */
class c implements com.sandboxol.file.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DownloadActivity f17545a;

    c(DownloadActivity downloadActivity) {
        this.f17545a = downloadActivity;
    }

    @Override // com.sandboxol.file.d.c
    public void onComplete(Progress progress) {
        Log.d("testDownload", "onComplete");
    }

    @Override // com.sandboxol.file.d.c
    public void onError(Throwable th) {
        Log.d("testDownload", "onError");
    }

    @Override // com.sandboxol.file.d.c
    public void onNext(Progress progress) {
        Log.d("testDownload Progress", progress.downloadSizeStr());
    }

    @Override // com.sandboxol.file.d.c
    public /* synthetic */ void onSubscribe(Throwable th) {
        com.sandboxol.file.d.b.a(this, th);
    }
}
