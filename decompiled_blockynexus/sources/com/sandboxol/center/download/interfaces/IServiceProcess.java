package com.sandboxol.center.download.interfaces;

import android.os.RemoteException;
import com.sandboxol.center.download.service.IDownloadListener;
import com.sandboxol.center.download.service.IUnzipListener;
import com.sandboxol.center.download.service.IVerifyListener;

/* JADX INFO: loaded from: classes3.dex */
public interface IServiceProcess {
    void process(int i, int i2, String str, IDownloadListener iDownloadListener, IVerifyListener iVerifyListener, IUnzipListener iUnzipListener) throws RemoteException;

    void process(String str, IDownloadListener iDownloadListener, IVerifyListener iVerifyListener, IUnzipListener iUnzipListener) throws RemoteException;
}
