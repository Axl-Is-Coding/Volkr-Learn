package com.sandboxol.file.activity;

import android.util.Log;
import com.sandboxol.file.d.g;

/* JADX INFO: compiled from: DownloadActivity.java */
/* JADX INFO: loaded from: classes3.dex */
class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DownloadActivity f17544a;

    b(DownloadActivity downloadActivity) {
        this.f17544a = downloadActivity;
    }

    @Override // com.sandboxol.file.d.g
    public void error(Throwable th) {
        Log.d("VerifyHandler", "error");
    }

    @Override // com.sandboxol.file.d.g
    public void success() {
        Log.d("VerifyHandler", "success");
    }
}
