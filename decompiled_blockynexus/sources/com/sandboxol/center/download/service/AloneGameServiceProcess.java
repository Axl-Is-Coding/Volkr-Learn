package com.sandboxol.center.download.service;

import android.os.RemoteException;
import com.google.gson.j;
import com.sandboxol.center.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.download.entity.DownloadInfoCenter;
import com.sandboxol.center.download.entity.GameProgressInfo;
import com.sandboxol.center.download.entity.MergeBuilder;
import com.sandboxol.center.download.utils.GameDownloadUtils;
import com.sandboxol.center.download.utils.ProcessUtils;
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
import com.sandboxol.greendao.c.U;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.ResourceLatestVersionData;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class AloneGameServiceProcess extends BaseServiceProcess {
    private final long ERROR_RES_VERSION = 0;

    @Override // com.sandboxol.center.download.service.BaseServiceProcess, com.sandboxol.center.download.interfaces.IServiceProcess
    public void process(final String str, final IDownloadListener iDownloadListener, final IVerifyListener iVerifyListener, final IUnzipListener iUnzipListener) throws RemoteException {
        HashMap<String, GameProgressInfo> gameProgressInfoMap = DownloadInfoCenter.getInstance().getGameProgressInfoMap();
        HashMap<String, GameProgressInfo> totalGameProgressInfoMap = DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap();
        final MergeBuilder mergeBuilder = (MergeBuilder) new j().a(str, MergeBuilder.class);
        if (mergeBuilder == null || mergeBuilder.getDownloadBuilder() == null || mergeBuilder.getVerifyBuilder() == null || mergeBuilder.getUnzipBuilder() == null) {
            return;
        }
        final Game game = mergeBuilder.getReqParam() != null ? mergeBuilder.getReqParam().getGame() : null;
        if (game == null) {
            return;
        }
        final GameProgressInfo gameProgressInfo = gameProgressInfoMap.get(game.getGameId()) != null ? gameProgressInfoMap.get(game.getGameId()) : new GameProgressInfo();
        gameProgressInfo.getIsDownload().set(true);
        gameProgressInfo.getIsError().set(false);
        gameProgressInfo.getProgressText().set(this.context.getString(R.string.base_prepare_resources));
        gameProgressInfoMap.put(game.getGameId(), gameProgressInfo);
        if (totalGameProgressInfoMap.get(game.getGameId()) == null) {
            totalGameProgressInfoMap.put(game.getGameId(), new GameProgressInfo());
            GameProgressInfo gameProgressInfo2 = totalGameProgressInfoMap.get(game.getGameId());
            gameProgressInfo2.getIsNewEngine().set(Integer.valueOf(game.getIsNewEngine()));
            gameProgressInfo2.getIsUgc().set(Integer.valueOf(game.getIsUgc()));
        }
        final DownloadInfo[] downloadInfoArrFilterDownloadInfo = ProcessUtils.filterDownloadInfo(mergeBuilder, true);
        final VerifyInfo[] verifyInfoArrFilterVerifyInfo = ProcessUtils.filterVerifyInfo(mergeBuilder, true);
        UnzipInfo[] unzipInfoArrFilterUnzipInfo = ProcessUtils.filterUnzipInfo(mergeBuilder, true);
        if (downloadInfoArrFilterDownloadInfo != null && downloadInfoArrFilterDownloadInfo.length == 0) {
            gameProgressInfo.getProgressValue().set(100);
            gameProgressInfo.getIsFinish().set(true);
            gameProgressInfo.getIsDownload().set(false);
            return;
        }
        GameDownloadUtils.switchUrl(this.retryDownloadTimes, downloadInfoArrFilterDownloadInfo);
        ReportUtils.resDownloadReport(3, this.context, EventConstant.DOWNLOAD_GAME_START, game.getGameId(), mergeBuilder.isSilent());
        final long j = (mergeBuilder.getReqParam() == null || mergeBuilder.getReqParam().getGameResVersion() == null) ? 0L : Long.parseLong(mergeBuilder.getReqParam().getGameResVersion());
        com.sandboxol.file.b.a downloadBuilder = mergeBuilder.getDownloadBuilder();
        downloadBuilder.a(downloadInfoArrFilterDownloadInfo);
        downloadBuilder.a(new c() { // from class: com.sandboxol.center.download.service.AloneGameServiceProcess.3
            @Override // com.sandboxol.file.d.c
            public void onComplete(Progress progress) {
                AloneGameServiceProcess.this.downloadOnComplete(3, progress, mergeBuilder, downloadInfoArrFilterDownloadInfo, verifyInfoArrFilterVerifyInfo, iDownloadListener);
            }

            @Override // com.sandboxol.file.d.c
            public void onError(Throwable th) {
                AloneGameServiceProcess.this.downloadOnError(3, th, str, iDownloadListener, iVerifyListener, iUnzipListener, gameProgressInfo, mergeBuilder);
            }

            @Override // com.sandboxol.file.d.c
            public void onNext(Progress progress) {
                AloneGameServiceProcess aloneGameServiceProcess = AloneGameServiceProcess.this;
                aloneGameServiceProcess.downloadOnNext(aloneGameServiceProcess.context, progress, gameProgressInfo, iDownloadListener);
            }

            @Override // com.sandboxol.file.d.c
            public void onSubscribe(Throwable th) {
                AloneGameServiceProcess.this.downloadOnSubscribe(downloadInfoArrFilterDownloadInfo, th);
            }
        });
        d dVar = new d(downloadBuilder);
        com.sandboxol.file.b.c verifyBuilder = mergeBuilder.getVerifyBuilder();
        verifyBuilder.a(verifyInfoArrFilterVerifyInfo);
        verifyBuilder.a(new g() { // from class: com.sandboxol.center.download.service.AloneGameServiceProcess.2
            @Override // com.sandboxol.file.d.g
            public void error(Throwable th) {
                AloneGameServiceProcess.this.verifyOnError(3, th, gameProgressInfo, iVerifyListener, str, iDownloadListener, iUnzipListener, mergeBuilder);
            }

            @Override // com.sandboxol.file.d.g
            public void success() {
                AloneGameServiceProcess aloneGameServiceProcess = AloneGameServiceProcess.this;
                aloneGameServiceProcess.verifyOnSuccess(3, aloneGameServiceProcess.context, mergeBuilder, iVerifyListener);
            }
        });
        dVar.a(new f(verifyBuilder));
        b unzipBuilder = mergeBuilder.getUnzipBuilder();
        unzipBuilder.a(unzipInfoArrFilterUnzipInfo);
        unzipBuilder.a(new e() { // from class: com.sandboxol.center.download.service.AloneGameServiceProcess.1
            @Override // com.sandboxol.file.d.e
            public void error(Throwable th) {
                AloneGameServiceProcess.this.unzipOnError(3, th, gameProgressInfo, str, iDownloadListener, iVerifyListener, iUnzipListener, mergeBuilder);
            }

            @Override // com.sandboxol.file.d.e
            public void progress(Progress progress) {
                AloneGameServiceProcess aloneGameServiceProcess = AloneGameServiceProcess.this;
                aloneGameServiceProcess.unzipOnProgress(aloneGameServiceProcess.context, progress, gameProgressInfo, iUnzipListener);
            }

            @Override // com.sandboxol.file.d.e
            public void success() {
                if (!mergeBuilder.isSilent()) {
                    if (game.getLatestResVersions() != null) {
                        game.getLatestResVersions().setGresVersion(j);
                    } else {
                        ResourceLatestVersionData resourceLatestVersionData = new ResourceLatestVersionData();
                        resourceLatestVersionData.setGresVersion(j);
                        game.setLatestResVersions(resourceLatestVersionData);
                    }
                    U.newInstance().a(game);
                }
                AloneGameServiceProcess aloneGameServiceProcess = AloneGameServiceProcess.this;
                aloneGameServiceProcess.unzipOnSuccess(3, aloneGameServiceProcess.context, mergeBuilder, gameProgressInfo, iUnzipListener);
            }
        });
        dVar.a(new i(unzipBuilder));
        this.baseFileHandler = dVar;
        this.baseFileHandler.d();
    }
}
