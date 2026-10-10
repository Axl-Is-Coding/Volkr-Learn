package com.sandboxol.center.download.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.apkfuns.logutils.c;
import com.sandboxol.center.download.service.IDownload;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadService extends Service {
    private IDownload.Stub iDownload = new IDownload.Stub() { // from class: com.sandboxol.center.download.service.DownloadService.1
        @Override // com.sandboxol.center.download.service.IDownload
        public void process(int i, String str, IDownloadListener iDownloadListener, IVerifyListener iVerifyListener, IUnzipListener iUnzipListener) throws RemoteException {
            ServiceProcess.getServiceProcess(i).process(str, iDownloadListener, iVerifyListener, iUnzipListener);
            c.a("builderJson").d(str);
        }

        @Override // com.sandboxol.center.download.service.IDownload
        public void processOnGame(int i, int i2, int i3, String str, IDownloadListener iDownloadListener, IVerifyListener iVerifyListener, IUnzipListener iUnzipListener) throws RemoteException {
            ServiceProcess.getServiceProcess(i3).process(i, i2, str, iDownloadListener, iVerifyListener, iUnzipListener);
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.iDownload;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
