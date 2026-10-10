package com.sandboxol.center.download.interfaces;

import android.os.RemoteException;
import com.sandboxol.center.download.entity.MergeBuilder;

/* JADX INFO: loaded from: classes3.dex */
public interface IClientProcess {
    void process(int i, int i2, MergeBuilder mergeBuilder, com.sandboxol.center.download.service.IDownload iDownload) throws RemoteException;

    void process(MergeBuilder mergeBuilder, com.sandboxol.center.download.service.IDownload iDownload) throws RemoteException;
}
