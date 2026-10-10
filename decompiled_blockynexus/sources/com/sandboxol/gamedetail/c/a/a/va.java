package com.sandboxol.gamedetail.c.a.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.download.client.DownloadClient;
import com.sandboxol.center.download.entity.DownloadInfoCenter;
import com.sandboxol.center.download.entity.GameProgressInfo;
import com.sandboxol.center.download.entity.GameReqParam;
import com.sandboxol.center.download.entity.MergeBuilder;
import com.sandboxol.center.download.utils.GameDownloadUtils;
import com.sandboxol.center.entity.AppEngineResourceUpdateItem;
import com.sandboxol.center.entity.AppEngineResourceUpdateResult;
import com.sandboxol.center.router.manager.DialogManager;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.module_application.BaseModuleApp;
import com.sandboxol.center.utils.CommonUtils;
import com.sandboxol.center.utils.GameIdRemarkUtils;
import com.sandboxol.center.utils.GameResVersionManager;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.file.entity.DownloadInfo;
import com.sandboxol.file.entity.UnzipInfo;
import com.sandboxol.file.entity.VerifyInfo;
import com.sandboxol.gamedetail.R;
import com.sandboxol.greendao.entity.Game;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: GameResDownloadManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class va {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Z f18041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f18042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f18043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ObservableField<Boolean> f18044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ObservableField<Boolean> f18045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18046f = 0;
    private long g = 0;
    private long h = 0;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = true;

    /* JADX INFO: compiled from: GameResDownloadManager.java */
    public interface a {
        void a(boolean z);
    }

    public va(Context context, ObservableField<Boolean> observableField, ObservableField<Boolean> observableField2, a aVar) {
        this.f18042b = context;
        this.f18044d = observableField;
        this.f18045e = observableField2;
        this.f18041a = new Z(context);
        this.f18043c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Game game) {
        ObservableField<Boolean> observableField;
        if (game == null || game.getGameId() == null || (observableField = this.f18044d) == null || observableField.get().booleanValue()) {
            return;
        }
        DialogManager.enterMiniGameDialog(this.f18042b, GameIdRemarkUtils.hallGameToSingleGame(game.getGameId()), game, true);
    }

    private void e(Game game) {
        HashMap<String, GameProgressInfo> totalGameProgressInfoMap = DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap();
        if (totalGameProgressInfoMap.get(game.getGameId()) == null) {
            totalGameProgressInfoMap.put(game.getGameId(), new GameProgressInfo());
        }
        GameProgressInfo gameProgressInfo = DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap().get(game.getGameId());
        gameProgressInfo.getIsFinish().set(false);
        gameProgressInfo.getProgressText().set(this.f18042b.getString(R.string.base_prepare_resources));
        gameProgressInfo.getIsDownload().set(true);
        gameProgressInfo.getIsNewEngine().set(Integer.valueOf(game.getIsNewEngine()));
        gameProgressInfo.getIsUgc().set(Integer.valueOf(game.getIsUgc()));
        Messenger.getDefault().send(game.getGameId(), MessageToken.TOKEN_DOWNLOAD_RES);
        this.f18045e.set(false);
        a aVar = this.f18043c;
        if (aVar != null) {
            aVar.a(true);
        }
        ReportDataAdapter.onEvent(this.f18042b, EventConstant.CLICK_RECSTART_DOWN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Game game) {
        if (game.getIsNewEngine() != 0 && BaseModuleApp.getBaseModuleApp().getMetaDataIsPackNewEngineRes()) {
            d(game);
            a aVar = this.f18043c;
            if (aVar != null) {
                aVar.a(true);
                return;
            }
            return;
        }
        long engineVersion = EngineEnv.getEngineVersion(game.getIsNewEngine(), game.getIsUgc());
        String engineType = EngineEnv.getEngineType(game.getIsNewEngine(), game.getIsUgc());
        String gameId = game.getGameId();
        this.f18041a.a(engineVersion, GameResVersionManager.getOldGameResVersion(game, gameId), gameId, engineType, game.getGameUgcType(), new na(this, game));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(List<AppEngineResourceUpdateResult> list) {
        Iterator<AppEngineResourceUpdateResult> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().isNeedUpdate()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Game game) {
        io.reactivex.p.timer(2000L, TimeUnit.MILLISECONDS).subscribe(new la(this, game));
        ReportDataAdapter.onEvent(this.f18042b, EventConstant.CLICK_RECSTART_DOWN_SUC);
    }

    public void a(Game game) {
        a aVar;
        if (TextUtils.isEmpty(game.getGameId()) && (aVar = this.f18043c) != null) {
            aVar.a(false);
        } else {
            com.sandboxol.greendao.c.U.newInstance().a(game.getGameId(), new ma(this, game));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Game game, List<AppEngineResourceUpdateResult> list) {
        va vaVar = this;
        List<AppEngineResourceUpdateItem> listA = vaVar.a(list);
        if (listA.size() == 0) {
            a aVar = vaVar.f18043c;
            if (aVar != null) {
                aVar.a(false);
                return;
            }
            return;
        }
        e(game);
        List<String> pathType = GameDownloadUtils.getPathType(game, list);
        DownloadInfo[] downloadInfoArr = new DownloadInfo[listA.size()];
        VerifyInfo[] verifyInfoArr = new VerifyInfo[listA.size()];
        UnzipInfo[] unzipInfoArr = new UnzipInfo[listA.size()];
        int i = 0;
        while (i < listA.size() && listA.get(i) != null && listA.get(i).getUrl() != null) {
            AppEngineResourceUpdateItem appEngineResourceUpdateItem = listA.get(i);
            String url = appEngineResourceUpdateItem.getUrl();
            String strSubstring = appEngineResourceUpdateItem.getUrl().substring(appEngineResourceUpdateItem.getUrl().lastIndexOf("/") + 1);
            String apkOrSoDownloadPath = CommonHelper.getApkOrSoDownloadPath(vaVar.f18042b);
            String type = appEngineResourceUpdateItem.getType();
            DownloadInfo downloadInfo = new DownloadInfo();
            downloadInfo.setUrl(url);
            downloadInfo.setSaveName(strSubstring);
            downloadInfo.setSavePath(apkOrSoDownloadPath);
            downloadInfo.setAutoStart(true);
            downloadInfo.setT(type);
            downloadInfo.setSize(appEngineResourceUpdateItem.getFileSize());
            downloadInfo.setCdns(appEngineResourceUpdateItem.getCdns());
            downloadInfoArr[i] = downloadInfo;
            VerifyInfo verifyInfo = new VerifyInfo();
            verifyInfo.setUrl(url);
            verifyInfo.setCode(appEngineResourceUpdateItem.getHash());
            verifyInfo.setFileDir(apkOrSoDownloadPath + "/");
            verifyInfo.setFileName(strSubstring);
            verifyInfo.setT(type);
            verifyInfoArr[i] = verifyInfo;
            UnzipInfo unzipInfo = new UnzipInfo();
            unzipInfo.setUrl(url);
            unzipInfo.setZipName(strSubstring);
            unzipInfo.setResultDir(pathType.get(i));
            unzipInfo.setT(type);
            unzipInfoArr[i] = unzipInfo;
            i++;
            vaVar = this;
        }
        com.sandboxol.file.b.a aVar2 = new com.sandboxol.file.b.a();
        aVar2.a(downloadInfoArr);
        com.sandboxol.file.b.c cVar = new com.sandboxol.file.b.c();
        cVar.a(verifyInfoArr);
        GameReqParam gameResVersion = new GameReqParam().setGame(game).setCommonResVersion(String.valueOf(this.g)).setGameResVersion(String.valueOf(this.h));
        if (game.getIsNewEngine() == 0) {
            com.sandboxol.file.b.b bVar = new com.sandboxol.file.b.b();
            bVar.a(unzipInfoArr);
            bVar.a(1);
            DownloadClient downloadClient = DownloadClient.getInstance();
            MergeBuilder reqParam = new MergeBuilder().setReqParam(gameResVersion);
            aVar2.a(new qa(this, game));
            MergeBuilder downloadBuilder = reqParam.setDownloadBuilder(aVar2);
            cVar.a(new pa(this, game));
            MergeBuilder verifyBuilder = downloadBuilder.setVerifyBuilder(cVar);
            bVar.a(new oa(this, game));
            downloadClient.process(3, verifyBuilder.setUnzipBuilder(bVar));
            return;
        }
        this.i = game.getLatestResVersions().getCresVersion() == EngineEnv.loadCommonResVersion(this.f18042b, game.getIsNewEngine(), game.getIsUgc());
        this.j = game.getLatestResVersions().getGresVersion() == SharedUtils.getLong(this.f18042b, SharedConstant.NEW_ENGINE_COMMON_GAME_VERSION);
        if (CommonUtils.isNewEngineCommonGame(game.getGameId())) {
            com.sandboxol.file.b.b bVar2 = new com.sandboxol.file.b.b();
            bVar2.a(unzipInfoArr);
            bVar2.a(1);
            DownloadClient downloadClient2 = DownloadClient.getInstance();
            int isNewEngine = game.getIsNewEngine();
            int isUgc = game.getIsUgc();
            MergeBuilder reqParam2 = new MergeBuilder().setReqParam(gameResVersion);
            aVar2.a(new ta(this, game));
            MergeBuilder downloadBuilder2 = reqParam2.setDownloadBuilder(aVar2);
            cVar.a(new sa(this, game));
            MergeBuilder verifyBuilder2 = downloadBuilder2.setVerifyBuilder(cVar);
            bVar2.a(new ra(this, game));
            downloadClient2.process(isNewEngine, isUgc, 4, verifyBuilder2.setUnzipBuilder(bVar2));
            com.sandboxol.file.b.b bVar3 = new com.sandboxol.file.b.b();
            bVar3.a(unzipInfoArr);
            bVar3.a(1);
            DownloadClient downloadClient3 = DownloadClient.getInstance();
            MergeBuilder reqParam3 = new MergeBuilder().setReqParam(gameResVersion);
            aVar2.a(new ea(this, game));
            MergeBuilder downloadBuilder3 = reqParam3.setDownloadBuilder(aVar2);
            cVar.a(new da(this, game));
            MergeBuilder verifyBuilder3 = downloadBuilder3.setVerifyBuilder(cVar);
            bVar3.a(new ua(this, game));
            downloadClient3.process(2, verifyBuilder3.setUnzipBuilder(bVar3));
            return;
        }
        com.sandboxol.file.b.b bVar4 = new com.sandboxol.file.b.b();
        bVar4.a(unzipInfoArr);
        bVar4.a(1);
        DownloadClient downloadClient4 = DownloadClient.getInstance();
        int isNewEngine2 = game.getIsNewEngine();
        int isUgc2 = game.getIsUgc();
        MergeBuilder reqParam4 = new MergeBuilder().setReqParam(gameResVersion);
        aVar2.a(new ha(this, game));
        MergeBuilder downloadBuilder4 = reqParam4.setDownloadBuilder(aVar2);
        cVar.a(new ga(this, game));
        MergeBuilder verifyBuilder4 = downloadBuilder4.setVerifyBuilder(cVar);
        bVar4.a(new fa(this, game));
        downloadClient4.process(isNewEngine2, isUgc2, 4, verifyBuilder4.setUnzipBuilder(bVar4));
        com.sandboxol.file.b.b bVar5 = new com.sandboxol.file.b.b();
        bVar5.a(unzipInfoArr);
        bVar5.a(1);
        DownloadClient downloadClient5 = DownloadClient.getInstance();
        MergeBuilder reqParam5 = new MergeBuilder().setReqParam(gameResVersion);
        aVar2.a(new ka(this, game));
        MergeBuilder downloadBuilder5 = reqParam5.setDownloadBuilder(aVar2);
        cVar.a(new ja(this, game));
        MergeBuilder verifyBuilder5 = downloadBuilder5.setVerifyBuilder(cVar);
        bVar5.a(new ia(this, game));
        downloadClient5.process(3, verifyBuilder5.setUnzipBuilder(bVar5));
    }

    private List<AppEngineResourceUpdateItem> a(List<AppEngineResourceUpdateResult> list) {
        ArrayList arrayList = new ArrayList();
        for (AppEngineResourceUpdateResult appEngineResourceUpdateResult : list) {
            if (appEngineResourceUpdateResult.getUpdates() != null && appEngineResourceUpdateResult.getUpdates().size() != 0) {
                for (AppEngineResourceUpdateItem appEngineResourceUpdateItem : appEngineResourceUpdateResult.getUpdates()) {
                    if ("ENGINE_COMMON_V2".equals(appEngineResourceUpdateResult.getResourceType())) {
                        appEngineResourceUpdateItem.setType("COMMON");
                    } else if ("ENGINE_COMMON_V3".equals(appEngineResourceUpdateResult.getResourceType())) {
                        appEngineResourceUpdateItem.setType("COMMON");
                    } else if ("GAME".equals(appEngineResourceUpdateResult.getResourceType())) {
                        appEngineResourceUpdateItem.setType("GAME");
                    }
                }
                arrayList.addAll(appEngineResourceUpdateResult.getUpdates());
            }
            if (!"ENGINE_COMMON_V1".equals(appEngineResourceUpdateResult.getResourceType()) && !"ENGINE_COMMON_V2".equals(appEngineResourceUpdateResult.getResourceType()) && !"ENGINE_COMMON_V3".equals(appEngineResourceUpdateResult.getResourceType())) {
                if ("GAME".equals(appEngineResourceUpdateResult.getResourceType())) {
                    this.h = appEngineResourceUpdateResult.getResVersion();
                }
            } else {
                this.g = appEngineResourceUpdateResult.getResVersion();
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        GameProgressInfo gameProgressInfo = DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap().get(str);
        if (gameProgressInfo == null || !gameProgressInfo.getIsError().get().booleanValue()) {
            return;
        }
        ReportDataAdapter.onEvent(this.f18042b, EventConstant.CLICK_RECSTART_DOWN_FAIL);
    }
}
