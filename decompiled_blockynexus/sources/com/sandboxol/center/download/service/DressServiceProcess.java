package com.sandboxol.center.download.service;

import android.os.RemoteException;
import com.google.gson.j;
import com.sandboxol.center.download.entity.DownloadInfoCenter;
import com.sandboxol.center.download.entity.DressProgressInfo;
import com.sandboxol.center.download.entity.MergeBuilder;
import com.sandboxol.center.download.utils.GameDownloadUtils;
import com.sandboxol.file.b.b;
import com.sandboxol.file.c.d;
import com.sandboxol.file.d.c;
import com.sandboxol.file.d.e;
import com.sandboxol.file.d.g;
import com.sandboxol.file.e.i;
import com.sandboxol.file.entity.Progress;
import com.sandboxol.file.g.f;

/* JADX INFO: loaded from: classes3.dex */
public class DressServiceProcess extends BaseServiceProcess {
    @Override // com.sandboxol.center.download.service.BaseServiceProcess, com.sandboxol.center.download.interfaces.IServiceProcess
    public void process(final String str, final IDownloadListener iDownloadListener, final IVerifyListener iVerifyListener, final IUnzipListener iUnzipListener) {
        final DressProgressInfo dressProgressInfo = DownloadInfoCenter.getInstance().getDressProgressInfo();
        final MergeBuilder mergeBuilder = (MergeBuilder) new j().a(str, MergeBuilder.class);
        if (mergeBuilder == null || mergeBuilder.getDownloadBuilder() == null || mergeBuilder.getVerifyBuilder() == null || mergeBuilder.getUnzipBuilder() == null || mergeBuilder.getDownloadBuilder().e() == null || mergeBuilder.getDownloadBuilder().e().length == 0) {
            return;
        }
        GameDownloadUtils.switchUrl(this.retryDownloadTimes, mergeBuilder.getDownloadBuilder().e());
        com.sandboxol.file.b.a downloadBuilder = mergeBuilder.getDownloadBuilder();
        downloadBuilder.a(new c() { // from class: com.sandboxol.center.download.service.DressServiceProcess.3
            @Override // com.sandboxol.file.d.c
            public void onComplete(Progress progress) {
                DressServiceProcess dressServiceProcess = DressServiceProcess.this;
                MergeBuilder mergeBuilder2 = mergeBuilder;
                dressServiceProcess.downloadOnComplete(1, progress, mergeBuilder2, mergeBuilder2.getDownloadBuilder().e(), mergeBuilder.getVerifyBuilder().b(), iDownloadListener);
            }

            @Override // com.sandboxol.file.d.c
            public void onError(Throwable th) {
                DressServiceProcess.this.downloadOnError(1, th, str, iDownloadListener, iVerifyListener, iUnzipListener, dressProgressInfo, mergeBuilder);
            }

            @Override // com.sandboxol.file.d.c
            public void onNext(Progress progress) {
                DressServiceProcess dressServiceProcess = DressServiceProcess.this;
                dressServiceProcess.downloadOnNext(dressServiceProcess.context, progress, dressProgressInfo, iDownloadListener);
            }

            @Override // com.sandboxol.file.d.c
            public void onSubscribe(Throwable th) {
                DressServiceProcess.this.downloadOnSubscribe(mergeBuilder.getDownloadBuilder().e(), th);
            }
        });
        d dVar = new d(downloadBuilder);
        com.sandboxol.file.b.c verifyBuilder = mergeBuilder.getVerifyBuilder();
        verifyBuilder.a(new g() { // from class: com.sandboxol.center.download.service.DressServiceProcess.2
            @Override // com.sandboxol.file.d.g
            public void error(Throwable th) {
                DressServiceProcess.this.verifyOnError(1, th, dressProgressInfo, iVerifyListener, str, iDownloadListener, iUnzipListener, mergeBuilder);
            }

            @Override // com.sandboxol.file.d.g
            public void success() {
                DressServiceProcess dressServiceProcess = DressServiceProcess.this;
                dressServiceProcess.verifyOnSuccess(1, dressServiceProcess.context, mergeBuilder, iVerifyListener);
            }
        });
        dVar.a(new f(verifyBuilder));
        b unzipBuilder = mergeBuilder.getUnzipBuilder();
        unzipBuilder.a(new e() { // from class: com.sandboxol.center.download.service.DressServiceProcess.1
            @Override // com.sandboxol.file.d.e
            public void error(Throwable th) {
                DressServiceProcess.this.unzipOnError(1, th, dressProgressInfo, str, iDownloadListener, iVerifyListener, iUnzipListener, mergeBuilder);
            }

            @Override // com.sandboxol.file.d.e
            public void progress(Progress progress) {
                IUnzipListener iUnzipListener2 = iUnzipListener;
                if (iUnzipListener2 != null) {
                    try {
                        iUnzipListener2.onNext(progress);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }

            @Override // com.sandboxol.file.d.e
            public void success() {
                DressServiceProcess dressServiceProcess = DressServiceProcess.this;
                dressServiceProcess.unzipOnSuccess(1, dressServiceProcess.context, mergeBuilder, dressProgressInfo, iUnzipListener);
            }
        });
        dVar.a(new i(unzipBuilder));
        this.baseFileHandler = dVar;
        this.baseFileHandler.d();
    }
}
