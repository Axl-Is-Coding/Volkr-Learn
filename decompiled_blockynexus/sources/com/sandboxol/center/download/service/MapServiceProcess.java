package com.sandboxol.center.download.service;

import com.google.gson.j;
import com.sandboxol.center.download.entity.DownloadInfoCenter;
import com.sandboxol.center.download.entity.MapProgressInfo;
import com.sandboxol.center.download.entity.MergeBuilder;
import com.sandboxol.center.download.interfaces.Action;
import com.sandboxol.center.download.utils.GameDownloadUtils;
import com.sandboxol.center.entity.DownloadAnalyseData;
import com.sandboxol.center.utils.ReportUtils;
import com.sandboxol.file.c.d;
import com.sandboxol.file.d.c;
import com.sandboxol.file.entity.DownloadInfo;
import com.sandboxol.file.entity.Progress;

/* JADX INFO: loaded from: classes3.dex */
public class MapServiceProcess extends BaseServiceProcess {
    private Action action;
    private long downloadEndTime;
    private long downloadStartTime;
    private long duration;

    /* JADX INFO: renamed from: com.sandboxol.center.download.service.MapServiceProcess$1, reason: invalid class name */
    class AnonymousClass1 implements c {
        final /* synthetic */ String val$builderJson;
        final /* synthetic */ DownloadInfo[] val$downloadInfos;
        final /* synthetic */ IDownloadListener val$downloadListener;
        final /* synthetic */ MapProgressInfo val$mapProgressInfo;
        final /* synthetic */ MergeBuilder val$mergeBuilder;
        final /* synthetic */ IUnzipListener val$unzipListener;
        final /* synthetic */ IVerifyListener val$verifyListener;

        AnonymousClass1(DownloadInfo[] downloadInfoArr, MergeBuilder mergeBuilder, MapProgressInfo mapProgressInfo, IDownloadListener iDownloadListener, String str, IVerifyListener iVerifyListener, IUnzipListener iUnzipListener) {
            this.val$downloadInfos = downloadInfoArr;
            this.val$mergeBuilder = mergeBuilder;
            this.val$mapProgressInfo = mapProgressInfo;
            this.val$downloadListener = iDownloadListener;
            this.val$builderJson = str;
            this.val$verifyListener = iVerifyListener;
            this.val$unzipListener = iUnzipListener;
        }

        public /* synthetic */ void a(IDownloadListener iDownloadListener, MergeBuilder mergeBuilder) {
            if (iDownloadListener != null) {
                MapServiceProcess.this.downloadEndTime = System.currentTimeMillis();
                MapServiceProcess.this.duration += MapServiceProcess.this.downloadEndTime - MapServiceProcess.this.downloadStartTime;
                GameDownloadUtils.writeMapDownloadTime(mergeBuilder.getReqParam().getGame(), MapServiceProcess.this.duration);
            }
        }

        @Override // com.sandboxol.file.d.c
        public void onComplete(Progress progress) {
            MapServiceProcess mapServiceProcess = MapServiceProcess.this;
            MergeBuilder mergeBuilder = this.val$mergeBuilder;
            mapServiceProcess.downloadOnComplete(5, progress, mergeBuilder, mergeBuilder.getDownloadBuilder().e(), null, this.val$downloadListener);
            MapServiceProcess.this.downloadEndTime = System.currentTimeMillis();
            MapServiceProcess.this.duration += MapServiceProcess.this.downloadEndTime - MapServiceProcess.this.downloadStartTime;
            ReportUtils.cdnDownloadMapNumReport(new DownloadAnalyseData(1, this.val$mergeBuilder.getReqParam().getGame().getGameId()));
            ReportUtils.cdnDownloadMapTimeReport(new DownloadAnalyseData(this.val$mergeBuilder.getReqParam().getGame().getGameId(), (int) (MapServiceProcess.this.duration / 1000)));
            GameDownloadUtils.writeMapDownloadTime(this.val$mergeBuilder.getReqParam().getGame(), 0L);
        }

        @Override // com.sandboxol.file.d.c
        public void onError(Throwable th) {
            if (MapServiceProcess.this.action == null) {
                MapServiceProcess mapServiceProcess = MapServiceProcess.this;
                final IDownloadListener iDownloadListener = this.val$downloadListener;
                final MergeBuilder mergeBuilder = this.val$mergeBuilder;
                mapServiceProcess.action = new Action() { // from class: com.sandboxol.center.download.service.a
                    @Override // com.sandboxol.center.download.interfaces.Action
                    public final void call() {
                        this.f16321a.a(iDownloadListener, mergeBuilder);
                    }
                };
            }
            MapServiceProcess mapServiceProcess2 = MapServiceProcess.this;
            mapServiceProcess2.mapDownloadOnError(th, this.val$builderJson, this.val$downloadListener, this.val$verifyListener, this.val$unzipListener, this.val$mapProgressInfo, this.val$mergeBuilder, mapServiceProcess2.action);
        }

        @Override // com.sandboxol.file.d.c
        public void onNext(Progress progress) {
            MapServiceProcess mapServiceProcess = MapServiceProcess.this;
            mapServiceProcess.downloadOnNext(mapServiceProcess.context, progress, this.val$mapProgressInfo, this.val$downloadListener);
        }

        @Override // com.sandboxol.file.d.c
        public void onSubscribe(Throwable th) {
            MapServiceProcess.this.downloadOnSubscribe(this.val$downloadInfos, th);
            ReportUtils.cdnDownloadMapNumReport(new DownloadAnalyseData(0, this.val$mergeBuilder.getReqParam().getGame().getGameId()));
            if (MapServiceProcess.this.retryDownloadTimes.get().intValue() == 0) {
                MapServiceProcess.this.duration = GameDownloadUtils.getMapDownloadTime(this.val$mergeBuilder.getReqParam().getGame());
                MapServiceProcess.this.downloadStartTime = System.currentTimeMillis();
            }
        }
    }

    @Override // com.sandboxol.center.download.service.BaseServiceProcess, com.sandboxol.center.download.interfaces.IServiceProcess
    public void process(String str, IDownloadListener iDownloadListener, IVerifyListener iVerifyListener, IUnzipListener iUnzipListener) {
        MapProgressInfo mapProgressInfo = DownloadInfoCenter.getInstance().getMapProgressInfo();
        MergeBuilder mergeBuilder = (MergeBuilder) new j().a(str, MergeBuilder.class);
        if (mergeBuilder == null || mergeBuilder.getDownloadBuilder() == null || mergeBuilder.getDownloadBuilder().e() == null || mergeBuilder.getDownloadBuilder().e().length == 0 || mergeBuilder.getReqParam() == null || mergeBuilder.getReqParam().getGame() == null) {
            return;
        }
        DownloadInfo[] downloadInfoArrE = mergeBuilder.getDownloadBuilder().e();
        GameDownloadUtils.switchUrl(this.retryDownloadTimes, downloadInfoArrE);
        com.sandboxol.file.b.a downloadBuilder = mergeBuilder.getDownloadBuilder();
        downloadBuilder.a(new AnonymousClass1(downloadInfoArrE, mergeBuilder, mapProgressInfo, iDownloadListener, str, iVerifyListener, iUnzipListener));
        this.baseFileHandler = new d(downloadBuilder);
        this.baseFileHandler.d();
    }
}
