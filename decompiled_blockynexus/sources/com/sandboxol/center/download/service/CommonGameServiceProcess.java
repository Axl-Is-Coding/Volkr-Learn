package com.sandboxol.center.download.service;

import android.os.RemoteException;
import com.google.gson.j;
import com.sandboxol.center.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.download.entity.CommonGameProgressInfo;
import com.sandboxol.center.download.entity.DownloadInfoCenter;
import com.sandboxol.center.download.entity.GameProgressInfo;
import com.sandboxol.center.download.entity.MergeBuilder;
import com.sandboxol.center.download.utils.GameDownloadUtils;
import com.sandboxol.center.download.utils.ProcessUtils;
import com.sandboxol.center.utils.ReportUtils;
import com.sandboxol.common.utils.SharedUtils;
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
import com.sandboxol.greendao.c.U;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.ResourceLatestVersionData;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class CommonGameServiceProcess extends BaseServiceProcess {
    private final long ERROR_RES_VERSION = 0;

    @Override // com.sandboxol.center.download.service.BaseServiceProcess, com.sandboxol.center.download.interfaces.IServiceProcess
    public void process(final String str, final IDownloadListener iDownloadListener, final IVerifyListener iVerifyListener, final IUnzipListener iUnzipListener) throws RemoteException {
        final CommonGameProgressInfo commonGameProgressInfo = DownloadInfoCenter.getInstance().getCommonGameProgressInfo();
        commonGameProgressInfo.getIsDownload().set(true);
        commonGameProgressInfo.getIsError().set(false);
        commonGameProgressInfo.getProgressText().set(this.context.getString(R.string.base_prepare_resources));
        HashMap<String, GameProgressInfo> totalGameProgressInfoMap = DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap();
        final MergeBuilder mergeBuilder = (MergeBuilder) new j().a(str, MergeBuilder.class);
        if (mergeBuilder == null || mergeBuilder.getDownloadBuilder() == null || mergeBuilder.getVerifyBuilder() == null || mergeBuilder.getUnzipBuilder() == null) {
            return;
        }
        final Game game = mergeBuilder.getReqParam() != null ? mergeBuilder.getReqParam().getGame() : null;
        if (!mergeBuilder.isSilent()) {
            if (game == null) {
                return;
            }
            if (totalGameProgressInfoMap.get(game.getGameId()) == null) {
                totalGameProgressInfoMap.put(game.getGameId(), new GameProgressInfo());
                GameProgressInfo gameProgressInfo = totalGameProgressInfoMap.get(game.getGameId());
                gameProgressInfo.getIsNewEngine().set(Integer.valueOf(game.getIsNewEngine()));
                gameProgressInfo.getIsUgc().set(Integer.valueOf(game.getIsUgc()));
            }
        }
        final DownloadInfo[] downloadInfoArrFilterDownloadInfo = ProcessUtils.filterDownloadInfo(mergeBuilder, true);
        final VerifyInfo[] verifyInfoArrFilterVerifyInfo = ProcessUtils.filterVerifyInfo(mergeBuilder, true);
        UnzipInfo[] unzipInfoArrFilterUnzipInfo = ProcessUtils.filterUnzipInfo(mergeBuilder, true);
        if (downloadInfoArrFilterDownloadInfo != null && downloadInfoArrFilterDownloadInfo.length == 0) {
            commonGameProgressInfo.getProgressValue().set(100);
            commonGameProgressInfo.getIsFinish().set(true);
            commonGameProgressInfo.getIsDownload().set(false);
            return;
        }
        ReportUtils.resDownloadReport(2, this.context, EventConstant.DOWNLOAD_GAME_START, "", mergeBuilder.isSilent());
        final long j = (mergeBuilder.getReqParam() == null || mergeBuilder.getReqParam().getCommonResVersion() == null) ? 0L : Long.parseLong(mergeBuilder.getReqParam().getGameResVersion());
        GameDownloadUtils.switchUrl(this.retryDownloadTimes, downloadInfoArrFilterDownloadInfo);
        com.sandboxol.file.b.a downloadBuilder = mergeBuilder.getDownloadBuilder();
        downloadBuilder.a(downloadInfoArrFilterDownloadInfo);
        downloadBuilder.a(new c() { // from class: com.sandboxol.center.download.service.CommonGameServiceProcess.3
            @Override // com.sandboxol.file.d.c
            public void onComplete(Progress progress) {
                CommonGameServiceProcess.this.downloadOnComplete(2, progress, mergeBuilder, downloadInfoArrFilterDownloadInfo, verifyInfoArrFilterVerifyInfo, iDownloadListener);
            }

            @Override // com.sandboxol.file.d.c
            public void onError(Throwable th) {
                CommonGameServiceProcess.this.downloadOnError(2, th, str, iDownloadListener, iVerifyListener, iUnzipListener, commonGameProgressInfo, mergeBuilder);
            }

            @Override // com.sandboxol.file.d.c
            public void onNext(Progress progress) {
                CommonGameServiceProcess commonGameServiceProcess = CommonGameServiceProcess.this;
                commonGameServiceProcess.downloadOnNext(commonGameServiceProcess.context, progress, commonGameProgressInfo, iDownloadListener);
            }

            @Override // com.sandboxol.file.d.c
            public void onSubscribe(Throwable th) {
                CommonGameServiceProcess.this.downloadOnSubscribe(downloadInfoArrFilterDownloadInfo, th);
            }
        });
        d dVar = new d(downloadBuilder);
        com.sandboxol.file.b.c verifyBuilder = mergeBuilder.getVerifyBuilder();
        verifyBuilder.a(verifyInfoArrFilterVerifyInfo);
        verifyBuilder.a(new g() { // from class: com.sandboxol.center.download.service.CommonGameServiceProcess.2
            @Override // com.sandboxol.file.d.g
            public void error(Throwable th) {
                CommonGameServiceProcess.this.verifyOnError(2, th, commonGameProgressInfo, iVerifyListener, str, iDownloadListener, iUnzipListener, mergeBuilder);
            }

            @Override // com.sandboxol.file.d.g
            public void success() {
                CommonGameServiceProcess commonGameServiceProcess = CommonGameServiceProcess.this;
                commonGameServiceProcess.verifyOnSuccess(2, commonGameServiceProcess.context, mergeBuilder, iVerifyListener);
            }
        });
        dVar.a(new f(verifyBuilder));
        b unzipBuilder = mergeBuilder.getUnzipBuilder();
        unzipBuilder.a(unzipInfoArrFilterUnzipInfo);
        unzipBuilder.a(new e() { // from class: com.sandboxol.center.download.service.CommonGameServiceProcess.1
            @Override // com.sandboxol.file.d.e
            public void error(Throwable th) {
                CommonGameServiceProcess.this.unzipOnError(2, th, commonGameProgressInfo, str, iDownloadListener, iVerifyListener, iUnzipListener, mergeBuilder);
            }

            @Override // com.sandboxol.file.d.e
            public void progress(Progress progress) {
                CommonGameServiceProcess commonGameServiceProcess = CommonGameServiceProcess.this;
                commonGameServiceProcess.unzipOnProgress(commonGameServiceProcess.context, progress, commonGameProgressInfo, iUnzipListener);
            }

            @Override // com.sandboxol.file.d.e
            public void success() {
                long gresVersion;
                if (!mergeBuilder.isSilent()) {
                    Game game2 = game;
                    if (game2 != null) {
                        if (game2.getLatestResVersions() != null) {
                            game.getLatestResVersions().setGresVersion(j);
                        } else {
                            ResourceLatestVersionData resourceLatestVersionData = new ResourceLatestVersionData();
                            resourceLatestVersionData.setGresVersion(j);
                            game.setLatestResVersions(resourceLatestVersionData);
                        }
                    }
                    U.newInstance().a(game);
                }
                String gameResVersion = mergeBuilder.getReqParam().getGameResVersion() != null ? mergeBuilder.getReqParam().getGameResVersion() : "0";
                if (mergeBuilder.isSilent()) {
                    gresVersion = Long.parseLong(gameResVersion);
                } else {
                    Game game3 = game;
                    gresVersion = game3 != null ? game3.getLatestResVersions().getGresVersion() : 0L;
                }
                SharedUtils.putLong(CommonGameServiceProcess.this.context, SharedConstant.NEW_ENGINE_COMMON_GAME_VERSION, gresVersion);
                CommonGameServiceProcess commonGameServiceProcess = CommonGameServiceProcess.this;
                commonGameServiceProcess.unzipOnSuccess(2, commonGameServiceProcess.context, mergeBuilder, commonGameProgressInfo, iUnzipListener);
            }
        });
        dVar.a(new i(unzipBuilder));
        this.baseFileHandler = dVar;
        this.baseFileHandler.d();
    }
}
