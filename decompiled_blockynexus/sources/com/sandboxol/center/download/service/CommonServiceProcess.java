package com.sandboxol.center.download.service;

import android.os.RemoteException;
import com.google.gson.j;
import com.sandboxol.center.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.download.entity.CommonProgressInfo;
import com.sandboxol.center.download.entity.MergeBuilder;
import com.sandboxol.center.download.utils.GameDownloadUtils;
import com.sandboxol.center.download.utils.ProcessUtils;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.utils.ReportUtils;
import com.sandboxol.file.b.b;
import com.sandboxol.file.c.d;
import com.sandboxol.file.d.c;
import com.sandboxol.file.d.e;
import com.sandboxol.file.d.g;
import com.sandboxol.file.e.i;
import com.sandboxol.file.entity.DownloadInfo;
import com.sandboxol.file.entity.Progress;
import com.sandboxol.file.entity.UnzipInfo;
import com.sandboxol.file.entity.VerifyInfo;
import com.sandboxol.file.g.f;

/* JADX INFO: loaded from: classes3.dex */
public class CommonServiceProcess extends BaseServiceProcess {
    private final long ERROR_RES_VERSION = 0;

    @Override // com.sandboxol.center.download.service.BaseServiceProcess, com.sandboxol.center.download.interfaces.IServiceProcess
    public void process(final int i, final int i2, final String str, final IDownloadListener iDownloadListener, final IVerifyListener iVerifyListener, final IUnzipListener iUnzipListener) throws RemoteException {
        final CommonProgressInfo downloadCommonInfo = EngineEnv.getDownloadCommonInfo(i, i2);
        downloadCommonInfo.getIsDownload().set(true);
        downloadCommonInfo.getIsError().set(false);
        downloadCommonInfo.getProgressText().set(this.context.getString(R.string.base_prepare_resources));
        final MergeBuilder mergeBuilder = (MergeBuilder) new j().a(str, MergeBuilder.class);
        if (mergeBuilder == null || mergeBuilder.getDownloadBuilder() == null || mergeBuilder.getVerifyBuilder() == null || mergeBuilder.getUnzipBuilder() == null) {
            return;
        }
        final DownloadInfo[] downloadInfoArrFilterDownloadInfo = ProcessUtils.filterDownloadInfo(mergeBuilder, false);
        final VerifyInfo[] verifyInfoArrFilterVerifyInfo = ProcessUtils.filterVerifyInfo(mergeBuilder, false);
        UnzipInfo[] unzipInfoArrFilterUnzipInfo = ProcessUtils.filterUnzipInfo(mergeBuilder, false);
        if (downloadInfoArrFilterDownloadInfo != null && downloadInfoArrFilterDownloadInfo.length == 0) {
            downloadCommonInfo.getProgressValue().set(100);
            downloadCommonInfo.getIsFinish().set(true);
            downloadCommonInfo.getIsDownload().set(false);
            return;
        }
        ReportUtils.resDownloadReport(4, this.context, EventConstant.DOWNLOAD_GAME_START, "", mergeBuilder.isSilent());
        final long j = (mergeBuilder.getReqParam() == null || mergeBuilder.getReqParam().getCommonResVersion() == null) ? 0L : Long.parseLong(mergeBuilder.getReqParam().getCommonResVersion());
        GameDownloadUtils.switchUrl(this.retryDownloadTimes, downloadInfoArrFilterDownloadInfo);
        com.sandboxol.file.b.a downloadBuilder = mergeBuilder.getDownloadBuilder();
        downloadBuilder.a(downloadInfoArrFilterDownloadInfo);
        downloadBuilder.a(new c() { // from class: com.sandboxol.center.download.service.CommonServiceProcess.3
            @Override // com.sandboxol.file.d.c
            public void onComplete(Progress progress) {
                CommonServiceProcess.this.downloadOnComplete(4, progress, mergeBuilder, downloadInfoArrFilterDownloadInfo, verifyInfoArrFilterVerifyInfo, iDownloadListener);
            }

            @Override // com.sandboxol.file.d.c
            public void onError(Throwable th) {
                CommonServiceProcess.this.downloadOnError(4, th, str, iDownloadListener, iVerifyListener, iUnzipListener, downloadCommonInfo, mergeBuilder, i, i2, true, null);
            }

            @Override // com.sandboxol.file.d.c
            public void onNext(Progress progress) {
                CommonServiceProcess commonServiceProcess = CommonServiceProcess.this;
                commonServiceProcess.downloadOnNext(commonServiceProcess.context, progress, downloadCommonInfo, iDownloadListener);
            }

            @Override // com.sandboxol.file.d.c
            public void onSubscribe(Throwable th) {
                CommonServiceProcess.this.downloadOnSubscribe(downloadInfoArrFilterDownloadInfo, th);
            }
        });
        d dVar = new d(downloadBuilder);
        com.sandboxol.file.b.c verifyBuilder = mergeBuilder.getVerifyBuilder();
        verifyBuilder.a(verifyInfoArrFilterVerifyInfo);
        verifyBuilder.a(new g() { // from class: com.sandboxol.center.download.service.CommonServiceProcess.2
            @Override // com.sandboxol.file.d.g
            public void error(Throwable th) {
                CommonServiceProcess.this.verifyOnError(4, th, downloadCommonInfo, iVerifyListener, str, iDownloadListener, iUnzipListener, mergeBuilder, i, i2, true);
            }

            @Override // com.sandboxol.file.d.g
            public void success() {
                CommonServiceProcess commonServiceProcess = CommonServiceProcess.this;
                commonServiceProcess.verifyOnSuccess(4, commonServiceProcess.context, mergeBuilder, iVerifyListener);
            }
        });
        dVar.a(new f(verifyBuilder));
        b unzipBuilder = mergeBuilder.getUnzipBuilder();
        unzipBuilder.a(unzipInfoArrFilterUnzipInfo);
        unzipBuilder.a(new e() { // from class: com.sandboxol.center.download.service.CommonServiceProcess.1
            @Override // com.sandboxol.file.d.e
            public void error(Throwable th) {
                CommonServiceProcess.this.unzipOnError(4, th, downloadCommonInfo, str, iDownloadListener, iVerifyListener, iUnzipListener, mergeBuilder, i, i2, true);
            }

            @Override // com.sandboxol.file.d.e
            public void progress(Progress progress) {
                CommonServiceProcess commonServiceProcess = CommonServiceProcess.this;
                commonServiceProcess.unzipOnProgress(commonServiceProcess.context, progress, downloadCommonInfo, iUnzipListener);
            }

            @Override // com.sandboxol.file.d.e
            public void success() {
                EngineEnv.storeCommonResVersion(CommonServiceProcess.this.context, i, i2, j);
                CommonServiceProcess commonServiceProcess = CommonServiceProcess.this;
                commonServiceProcess.unzipOnSuccess(4, commonServiceProcess.context, mergeBuilder, downloadCommonInfo, iUnzipListener);
            }
        });
        dVar.a(new i(unzipBuilder));
        this.baseFileHandler = dVar;
        this.baseFileHandler.d();
    }
}
