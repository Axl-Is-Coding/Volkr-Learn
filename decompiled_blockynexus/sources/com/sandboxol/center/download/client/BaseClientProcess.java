package com.sandboxol.center.download.client;

import android.os.RemoteException;
import com.google.gson.j;
import com.sandboxol.center.download.entity.MergeBuilder;
import com.sandboxol.center.download.interfaces.IClientProcess;
import com.sandboxol.center.download.service.IDownload;
import com.sandboxol.center.download.service.IDownloadListener;
import com.sandboxol.center.download.service.IUnzipListener;
import com.sandboxol.center.download.service.IVerifyListener;
import com.sandboxol.file.entity.Progress;

/* JADX INFO: loaded from: classes3.dex */
public class BaseClientProcess implements IClientProcess {
    private int downloadResType;

    private BaseClientProcess() {
    }

    @Override // com.sandboxol.center.download.interfaces.IClientProcess
    public /* synthetic */ void process(int i, int i2, MergeBuilder mergeBuilder, IDownload iDownload) throws RemoteException {
        com.sandboxol.center.download.interfaces.a.a(this, i, i2, mergeBuilder, iDownload);
    }

    @Override // com.sandboxol.center.download.interfaces.IClientProcess
    public void process(final MergeBuilder mergeBuilder, IDownload iDownload) throws RemoteException {
        iDownload.process(this.downloadResType, new j().a(mergeBuilder), new IDownloadListener.Stub() { // from class: com.sandboxol.center.download.client.BaseClientProcess.1
            @Override // com.sandboxol.center.download.service.IDownloadListener
            public void onComplete(Progress progress) {
                MergeBuilder mergeBuilder2 = mergeBuilder;
                if (mergeBuilder2 == null || mergeBuilder2.getDownloadBuilder() == null || mergeBuilder.getDownloadBuilder().c() == null) {
                    return;
                }
                mergeBuilder.getDownloadBuilder().c().onComplete(progress);
            }

            @Override // com.sandboxol.center.download.service.IDownloadListener
            public void onError(String str) {
                MergeBuilder mergeBuilder2 = mergeBuilder;
                if (mergeBuilder2 == null || mergeBuilder2.getDownloadBuilder() == null || mergeBuilder.getDownloadBuilder().c() == null) {
                    return;
                }
                mergeBuilder.getDownloadBuilder().c().onError(new Throwable(str));
            }

            @Override // com.sandboxol.center.download.service.IDownloadListener
            public void onNext(Progress progress) {
                MergeBuilder mergeBuilder2 = mergeBuilder;
                if (mergeBuilder2 == null || mergeBuilder2.getDownloadBuilder() == null || mergeBuilder.getDownloadBuilder().c() == null) {
                    return;
                }
                mergeBuilder.getDownloadBuilder().c().onNext(progress);
            }
        }, new IVerifyListener.Stub() { // from class: com.sandboxol.center.download.client.BaseClientProcess.2
            @Override // com.sandboxol.center.download.service.IVerifyListener
            public void onComplete(Progress progress) {
                MergeBuilder mergeBuilder2 = mergeBuilder;
                if (mergeBuilder2 == null || mergeBuilder2.getVerifyBuilder() == null || mergeBuilder.getVerifyBuilder().c() == null) {
                    return;
                }
                mergeBuilder.getVerifyBuilder().c().success();
            }

            @Override // com.sandboxol.center.download.service.IVerifyListener
            public void onError(String str) {
                MergeBuilder mergeBuilder2 = mergeBuilder;
                if (mergeBuilder2 == null || mergeBuilder2.getVerifyBuilder() == null || mergeBuilder.getVerifyBuilder().c() == null) {
                    return;
                }
                mergeBuilder.getVerifyBuilder().c().error(new Throwable(str));
            }

            @Override // com.sandboxol.center.download.service.IVerifyListener
            public void onNext(Progress progress) {
            }
        }, new IUnzipListener.Stub() { // from class: com.sandboxol.center.download.client.BaseClientProcess.3
            @Override // com.sandboxol.center.download.service.IUnzipListener
            public void onComplete(Progress progress) {
                MergeBuilder mergeBuilder2 = mergeBuilder;
                if (mergeBuilder2 == null || mergeBuilder2.getUnzipBuilder() == null || mergeBuilder.getUnzipBuilder().d() == null) {
                    return;
                }
                mergeBuilder.getUnzipBuilder().d().success();
            }

            @Override // com.sandboxol.center.download.service.IUnzipListener
            public void onError(String str) {
                MergeBuilder mergeBuilder2 = mergeBuilder;
                if (mergeBuilder2 == null || mergeBuilder2.getUnzipBuilder() == null || mergeBuilder.getUnzipBuilder().d() == null) {
                    return;
                }
                mergeBuilder.getUnzipBuilder().d().error(new Throwable(str));
            }

            @Override // com.sandboxol.center.download.service.IUnzipListener
            public void onNext(Progress progress) {
                MergeBuilder mergeBuilder2 = mergeBuilder;
                if (mergeBuilder2 == null || mergeBuilder2.getUnzipBuilder() == null || mergeBuilder.getUnzipBuilder().d() == null) {
                    return;
                }
                mergeBuilder.getUnzipBuilder().d().progress(progress);
            }
        });
    }

    public BaseClientProcess(int i) {
        this.downloadResType = i;
    }
}
