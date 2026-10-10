package com.sandboxol.file.activity;

import android.util.Log;
import com.sandboxol.file.d.e;
import com.sandboxol.file.entity.Progress;

/* JADX INFO: compiled from: DownloadActivity.java */
/* JADX INFO: loaded from: classes3.dex */
class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DownloadActivity f17543a;

    a(DownloadActivity downloadActivity) {
        this.f17543a = downloadActivity;
    }

    @Override // com.sandboxol.file.d.e
    public void error(Throwable th) {
        Log.d("UnzipHandler", "error");
    }

    @Override // com.sandboxol.file.d.e
    public void progress(Progress progress) {
        if (progress.getTotalSize().longValue() != 0) {
            Log.d("UnzipHandler", (progress.getDownloadSize().longValue() / progress.getTotalSize().longValue()) + "");
        }
    }

    @Override // com.sandboxol.file.d.e
    public void success() {
        Log.d("UnzipHandler", "success");
    }
}
