package com.sandboxol.gamedetail.c.a.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import androidx.databinding.ObservableField;
import androidx.fragment.app.FragmentActivity;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.download.client.DownloadClient;
import com.sandboxol.center.download.entity.DownloadInfoCenter;
import com.sandboxol.center.download.entity.GameProgressInfo;
import com.sandboxol.center.download.entity.GameReqParam;
import com.sandboxol.center.download.entity.MergeBuilder;
import com.sandboxol.center.download.utils.GameDownloadUtils;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AppEngineResourceUpdateItem;
import com.sandboxol.center.entity.AppEngineResourceUpdateResult;
import com.sandboxol.center.router.manager.AdsManager;
import com.sandboxol.center.router.manager.DialogManager;
import com.sandboxol.center.router.manager.DownloadManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.utils.CommonUtils;
import com.sandboxol.center.utils.MultiProcessSharedUtils;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.FirebaseUtils;
import com.sandboxol.common.utils.RxPermissions2;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.file.entity.DownloadInfo;
import com.sandboxol.file.entity.UnzipInfo;
import com.sandboxol.file.entity.VerifyInfo;
import com.sandboxol.gamedetail.R;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.messager.MessagerClient;
import com.tendcloud.tenddata.ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: GameDetailEnterGameLogic.java */
/* JADX INFO: loaded from: classes3.dex */
public class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f17920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ba f17921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private wa f17922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Z f17923d;
    private Game g;
    private List<AppEngineResourceUpdateResult> h;
    private ObservableField<Boolean> j;
    private ObservableField<Boolean> k;
    private ObservableField<String> l;
    private WeakReference<Activity> m;
    private com.sandboxol.gamedetail.a.o n;
    private ObservableField<Boolean> o;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f17924e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f17925f = 0;
    private ObservableField<Boolean> i = new ObservableField<>(false);
    private boolean p = true;
    boolean q = false;
    boolean r = false;
    boolean s = false;
    boolean t = false;

    public M(Context context, Game game, ba baVar, wa waVar) {
        this.f17920a = context;
        this.g = game;
        this.f17921b = baVar;
        this.f17922c = waVar;
        this.f17923d = new Z(context);
    }

    public void b() {
    }

    public void b(ObservableField<Boolean> observableField) {
        this.k = observableField;
    }

    public void c(ObservableField<Boolean> observableField) {
        this.o = observableField;
    }

    public void d(ObservableField<String> observableField) {
        this.l = observableField;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        List<AppEngineResourceUpdateResult> list = this.h;
        boolean z = false;
        if (list != null && list.size() != 0) {
            for (AppEngineResourceUpdateResult appEngineResourceUpdateResult : this.h) {
                if (appEngineResourceUpdateResult.isNeedUpdate()) {
                    z = true;
                }
                if ("GAME".equals(appEngineResourceUpdateResult.getResourceType())) {
                    this.t = true;
                    if (!appEngineResourceUpdateResult.isNeedUpdate()) {
                        this.s = true;
                    }
                }
            }
        }
        if (!this.t) {
            this.s = true;
        }
        return z;
    }

    public void a(ObservableField<Boolean> observableField) {
        this.j = observableField;
    }

    void b(Game game, List<AppEngineResourceUpdateResult> list) {
        this.g = game;
        this.h = list;
        this.p = true;
        DownloadManager.checkClothesResource(this.f17920a);
        a(false);
    }

    void c(Game game, List<AppEngineResourceUpdateResult> list) {
        this.g = game;
        this.h = list;
        DownloadManager.checkClothesResource(this.f17920a);
        a(true);
    }

    public void a(WeakReference<Activity> weakReference) {
        this.m = weakReference;
    }

    public void a(com.sandboxol.gamedetail.a.o oVar) {
        this.n = oVar;
    }

    void a(Game game, List<AppEngineResourceUpdateResult> list) {
        this.g = game;
        this.h = list;
        this.p = false;
        DownloadManager.checkClothesResource(this.f17920a);
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        io.reactivex.p.timer(2000L, TimeUnit.MILLISECONDS).subscribe(new L(this));
        if (this.i.get().booleanValue()) {
            new LoadingDialog(this.f17920a).show();
            Z z = this.f17923d;
            String str = AccountCenter.newInstance().nickName.get() + this.f17920a.getString(R.string.gamedetail_party_somebody);
            Game game = this.g;
            z.a(str, game, this.f17923d.a(game, game.getGameId()));
            return;
        }
        if (this.f17921b.f()) {
            return;
        }
        a();
    }

    @SuppressLint({"CheckResult"})
    void a(final boolean z) {
        this.i.set(Boolean.valueOf(z));
        if (z) {
            ReportDataAdapter.onEvent(this.f17920a, EventConstant.CLICK_PARTY, this.g.getGameId());
            com.apkfuns.logutils.c.a(ab.u).d("onEvent being called! eventEvent: 点击创建派对");
        } else {
            ReportDataAdapter.onEvent(this.f17920a, "click_enter_game");
            ReportDataAdapter.onEvent(this.f17920a, "click_enter_game_" + this.g.getGameId());
            FirebaseUtils.onEvent(this.f17920a, "click_enter_game");
        }
        new RxPermissions2((FragmentActivity) this.f17920a).request("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE").subscribe(new io.reactivex.b.g() { // from class: com.sandboxol.gamedetail.c.a.a.d
            @Override // io.reactivex.b.g
            public final void accept(Object obj) throws Exception {
                this.f17974a.a(z, (Boolean) obj);
            }
        }, new io.reactivex.b.g() { // from class: com.sandboxol.gamedetail.c.a.a.e
            @Override // io.reactivex.b.g
            public final void accept(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
    }

    public /* synthetic */ void a(boolean z, Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            com.apkfuns.logutils.c.a("DressDownload&Unzip").d("Check Permission");
            if (AccountCenter.newInstance().userId.get().longValue() == 0) {
                Context context = this.f17920a;
                AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.gamedetail_game_detail_visitor_info_fail));
                return;
            }
            Game game = this.g;
            if (game == null || game.getGameId() == null) {
                return;
            }
            if (this.g.getIsPay() == 1) {
                this.f17922c.b(this.g);
                ReportDataAdapter.onEvent(this.f17920a, EventConstant.CLICK_BUY_GAME);
                ReportDataAdapter.onEvent(this.f17920a, "click_buy_game_" + this.g.getGameId());
                return;
            }
            com.sandboxol.greendao.c.U.newInstance().a(this.g.getGameId(), new F(this, z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Game game) {
        M m = this;
        com.apkfuns.logutils.c.a("DressDownload&Unzip").d("****Game Download****");
        com.apkfuns.logutils.c.a("DressDownload&Unzip").d("--------------------------------------------------");
        com.apkfuns.logutils.c.a("DressDownload&Unzip").d("Start game downloading");
        SandboxReportManager.onEvent(ReportEvent.NEW_GAME_DOWNLOAD_RESOURCE_BASE + game.getGameId(), ReportEventType.NEW_USER_BEHAVIOR, "app");
        SandboxReportManager.onEvent(ReportEvent.NEW_GAME_DOWNLOAD_RESOURCE_BASE + game.getGameId(), game.getGameId() + ReportEventType.GAME_INTER_BASE, game.getGameId());
        HashMap<String, GameProgressInfo> totalGameProgressInfoMap = DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap();
        if (totalGameProgressInfoMap.get(game.getGameId()) == null) {
            totalGameProgressInfoMap.put(game.getGameId(), new GameProgressInfo());
            GameProgressInfo gameProgressInfo = DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap().get(game.getGameId());
            m.k = gameProgressInfo.getIsFinish();
            m.l = gameProgressInfo.getProgressText();
            m.j = gameProgressInfo.getIsDownload();
            m.n.f().y = gameProgressInfo.getIsDownload();
            m.n.f().z = gameProgressInfo.getProgressText();
            m.n.f().A = gameProgressInfo.getProgressValue();
            m.n.f().E = gameProgressInfo.getIsFinish();
            com.sandboxol.gamedetail.a.o oVar = m.n;
            oVar.setVariable(com.sandboxol.gamedetail.a.h, oVar.f());
            m.n.executePendingBindings();
            gameProgressInfo.getIsNewEngine().set(Integer.valueOf(game.getIsNewEngine()));
            gameProgressInfo.getIsUgc().set(Integer.valueOf(game.getIsUgc()));
        }
        m.k.set(false);
        m.l.set(m.f17920a.getString(R.string.base_prepare_resources));
        int i = 1;
        m.j.set(true);
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        Messenger.getDefault().send(game.getGameId(), MessageToken.TOKEN_DOWNLOAD_RES);
        List<AppEngineResourceUpdateResult> list = m.h;
        if (list == null || list.size() == 0) {
            return;
        }
        List<AppEngineResourceUpdateItem> listA = m.a(m.h);
        if (listA.size() == 0) {
            return;
        }
        List<String> pathType = GameDownloadUtils.getPathType(m.g, m.h);
        DownloadInfo[] downloadInfoArr = new DownloadInfo[listA.size()];
        VerifyInfo[] verifyInfoArr = new VerifyInfo[listA.size()];
        UnzipInfo[] unzipInfoArr = new UnzipInfo[listA.size()];
        if (pathType.size() != listA.size()) {
            return;
        }
        int i2 = 0;
        while (i2 < listA.size() && listA.get(i2) != null && listA.get(i2).getUrl() != null) {
            AppEngineResourceUpdateItem appEngineResourceUpdateItem = listA.get(i2);
            String url = appEngineResourceUpdateItem.getUrl();
            String strSubstring = appEngineResourceUpdateItem.getUrl().substring(appEngineResourceUpdateItem.getUrl().lastIndexOf("/") + i);
            String apkOrSoDownloadPath = CommonHelper.getApkOrSoDownloadPath(m.f17920a);
            String type = appEngineResourceUpdateItem.getType();
            long fileSize = appEngineResourceUpdateItem.getFileSize();
            List<AppEngineResourceUpdateItem> list2 = listA;
            DownloadInfo downloadInfo = new DownloadInfo();
            downloadInfo.setUrl(url);
            downloadInfo.setSaveName(strSubstring);
            downloadInfo.setSavePath(apkOrSoDownloadPath);
            downloadInfo.setAutoStart(true);
            downloadInfo.setT(type);
            downloadInfo.setSize(fileSize);
            downloadInfo.setCdns(appEngineResourceUpdateItem.getCdns());
            downloadInfoArr[i2] = downloadInfo;
            VerifyInfo verifyInfo = new VerifyInfo();
            verifyInfo.setUrl(url);
            verifyInfo.setCode(appEngineResourceUpdateItem.getHash());
            verifyInfo.setFileDir(apkOrSoDownloadPath + "/");
            verifyInfo.setFileName(strSubstring);
            verifyInfo.setT(type);
            verifyInfoArr[i2] = verifyInfo;
            UnzipInfo unzipInfo = new UnzipInfo();
            unzipInfo.setUrl(url);
            unzipInfo.setZipName(strSubstring);
            unzipInfo.setResultDir(pathType.get(i2));
            unzipInfo.setT(type);
            unzipInfo.setFileSize(fileSize);
            unzipInfoArr[i2] = unzipInfo;
            i2++;
            i = 1;
            m = this;
            listA = list2;
        }
        com.sandboxol.file.b.a aVar = new com.sandboxol.file.b.a();
        aVar.a(downloadInfoArr);
        com.sandboxol.file.b.c cVar = new com.sandboxol.file.b.c();
        cVar.a(verifyInfoArr);
        GameReqParam gameResVersion = new GameReqParam().setGame(game).setCommonResVersion(String.valueOf(this.f17924e)).setGameResVersion(String.valueOf(this.f17925f));
        if (game.getIsNewEngine() == 0) {
            com.sandboxol.file.b.b bVar = new com.sandboxol.file.b.b();
            bVar.a(unzipInfoArr);
            bVar.a(1);
            DownloadClient downloadClient = DownloadClient.getInstance();
            MergeBuilder verifyBuilder = new MergeBuilder().setReqParam(gameResVersion).setDownloadBuilder(aVar).setVerifyBuilder(cVar);
            bVar.a(new G(this));
            downloadClient.process(3, verifyBuilder.setUnzipBuilder(bVar));
            return;
        }
        this.q = game.getLatestResVersions().getCresVersion() == EngineEnv.loadCommonResVersion(this.f17920a, game.getIsNewEngine(), game.getIsUgc());
        this.r = game.getLatestResVersions().getGresVersion() == SharedUtils.getLong(this.f17920a, SharedConstant.NEW_ENGINE_COMMON_GAME_VERSION);
        if (CommonUtils.isNewEngineCommonGame(game.getGameId())) {
            com.sandboxol.file.b.b bVar2 = new com.sandboxol.file.b.b();
            bVar2.a(unzipInfoArr);
            bVar2.a(1);
            DownloadClient downloadClient2 = DownloadClient.getInstance();
            int isNewEngine = game.getIsNewEngine();
            int isUgc = game.getIsUgc();
            MergeBuilder verifyBuilder2 = new MergeBuilder().setReqParam(gameResVersion).setDownloadBuilder(aVar).setVerifyBuilder(cVar);
            bVar2.a(new H(this, game));
            downloadClient2.process(isNewEngine, isUgc, 4, verifyBuilder2.setUnzipBuilder(bVar2));
            com.sandboxol.file.b.b bVar3 = new com.sandboxol.file.b.b();
            bVar3.a(unzipInfoArr);
            bVar3.a(1);
            DownloadClient downloadClient3 = DownloadClient.getInstance();
            MergeBuilder verifyBuilder3 = new MergeBuilder().setReqParam(gameResVersion).setDownloadBuilder(aVar).setVerifyBuilder(cVar);
            bVar3.a(new I(this, game));
            downloadClient3.process(2, verifyBuilder3.setUnzipBuilder(bVar3));
            return;
        }
        com.sandboxol.file.b.b bVar4 = new com.sandboxol.file.b.b();
        bVar4.a(unzipInfoArr);
        bVar4.a(1);
        DownloadClient downloadClient4 = DownloadClient.getInstance();
        int isNewEngine2 = game.getIsNewEngine();
        int isUgc2 = game.getIsUgc();
        MergeBuilder verifyBuilder4 = new MergeBuilder().setReqParam(gameResVersion).setDownloadBuilder(aVar).setVerifyBuilder(cVar);
        bVar4.a(new J(this, game));
        downloadClient4.process(isNewEngine2, isUgc2, 4, verifyBuilder4.setUnzipBuilder(bVar4));
        com.sandboxol.file.b.b bVar5 = new com.sandboxol.file.b.b();
        bVar5.a(unzipInfoArr);
        bVar5.a(1);
        DownloadClient downloadClient5 = DownloadClient.getInstance();
        MergeBuilder verifyBuilder5 = new MergeBuilder().setReqParam(gameResVersion).setDownloadBuilder(aVar).setVerifyBuilder(cVar);
        bVar5.a(new K(this));
        downloadClient5.process(3, verifyBuilder5.setUnzipBuilder(bVar5));
    }

    void a() {
        Game game;
        if (this.m.get() == null || this.m.get().isFinishing() || (game = this.g) == null || game.getGameId() == null) {
            return;
        }
        String gameId = this.g.getGameId();
        if (this.p && gameId.equals(StringConstant.BED_WAR_HALL_GAME_ID)) {
            ReportDataAdapter.onEvent(this.f17920a, EventConstant.BEDWAR_ENTER_TIME);
            gameId = "g1008";
        } else if (gameId.equals("g1008")) {
            ReportDataAdapter.onEvent(this.f17920a, EventConstant.BEDWAR_ENTER_HALL_TIME);
        }
        if (this.p && gameId.equals(StringConstant.LUCKY_BLOCK_HALL_GAME_ID)) {
            gameId = StringConstant.LUCKY_BLOCK_GAME_ID;
        } else {
            gameId.equals(StringConstant.LUCKY_BLOCK_GAME_ID);
        }
        MultiProcessSharedUtils.putBoolean(this.f17920a, "is.show.ads", AdsManager.isVideoLoaded());
        DialogManager.enterMiniGameDialog(this.f17920a, gameId, this.g);
        ReportDataAdapter.onEvent(this.f17920a, EventConstant.CLICK_QUICKACCESS);
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
                    this.f17925f = appEngineResourceUpdateResult.getResVersion();
                }
            } else {
                this.f17924e = appEngineResourceUpdateResult.getResVersion();
            }
        }
        return arrayList;
    }
}
