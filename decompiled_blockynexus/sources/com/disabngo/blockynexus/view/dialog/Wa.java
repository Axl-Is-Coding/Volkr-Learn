package com.disabngo.blockynexus.view.dialog;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.disabngo.blockynexus.utils.breakpoint.DownloadService;

/* JADX INFO: compiled from: UploadApkDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class Wa implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UploadApkDialog f11438a;

    Wa(UploadApkDialog uploadApkDialog) {
        this.f11438a = uploadApkDialog;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f11438a.h = (DownloadService.a) iBinder;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
