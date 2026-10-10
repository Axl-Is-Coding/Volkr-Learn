package com.disabngo.blockynexus.view.dialog;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.disabngo.blockynexus.utils.breakpoint.DownloadService;

/* JADX INFO: compiled from: UploadSoDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class fb implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UploadSoDialog f11563a;

    fb(UploadSoDialog uploadSoDialog) {
        this.f11563a = uploadSoDialog;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f11563a.f11427e = (DownloadService.a) iBinder;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
