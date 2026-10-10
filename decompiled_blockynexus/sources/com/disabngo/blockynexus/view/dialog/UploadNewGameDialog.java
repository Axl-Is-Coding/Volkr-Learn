package com.disabngo.blockynexus.view.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Qb;
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
import com.sandboxol.center.entity.AppEngineResourceUpdateItem;
import com.sandboxol.center.entity.AppEngineResourceUpdateResult;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.utils.CommonUtils;
import com.sandboxol.center.utils.GameIdRemarkUtils;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.file.entity.DownloadInfo;
import com.sandboxol.file.entity.UnzipInfo;
import com.sandboxol.file.entity.VerifyInfo;
import com.sandboxol.greendao.entity.Game;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class UploadNewGameDialog extends AppCompatActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f11411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f11412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String[] f11413c = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    List<AppEngineResourceUpdateResult> f11414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11416f;
    private String g;
    private Qb h;
    private a i;
    private Game j;
    private String k;
    private boolean l;
    boolean m = false;
    boolean n = false;
    boolean o = false;
    private Observable.a p = new Xa(this);
    public com.sandboxol.file.d.c q = new cb(this);
    public com.sandboxol.file.d.e r = new db(this);

    public class a extends ViewModel {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ObservableField<Integer> f11417a = new ObservableField<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ObservableField<String> f11418b = new ObservableField<>("");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ObservableField<String> f11419c = new ObservableField<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ObservableField<String> f11420d = new ObservableField<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ObservableField<Boolean> f11421e = new ObservableField<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ObservableField<Boolean> f11422f = new ObservableField<>();

        public a() {
        }

        void initData() {
            this.f11420d.set(UploadNewGameDialog.this.getString(R.string.prepare_resources));
            this.f11419c.set(UploadNewGameDialog.this.getString(R.string.prepare_map_resources));
            UploadNewGameDialog.this.k();
            HashMap<String, GameProgressInfo> totalGameProgressInfoMap = DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap();
            if (totalGameProgressInfoMap.get(UploadNewGameDialog.this.k) != null) {
                this.f11418b = totalGameProgressInfoMap.get(UploadNewGameDialog.this.k).getProgressText();
                this.f11417a = totalGameProgressInfoMap.get(UploadNewGameDialog.this.k).getProgressValue();
                this.f11421e = totalGameProgressInfoMap.get(UploadNewGameDialog.this.k).getIsDownload();
                this.f11422f = totalGameProgressInfoMap.get(UploadNewGameDialog.this.k).getIsFinish();
                return;
            }
            totalGameProgressInfoMap.put(UploadNewGameDialog.this.k, new GameProgressInfo());
            GameProgressInfo gameProgressInfo = DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap().get(UploadNewGameDialog.this.k);
            this.f11418b = gameProgressInfo.getProgressText();
            this.f11421e = gameProgressInfo.getIsDownload();
            UploadNewGameDialog.this.h.f().f11421e = gameProgressInfo.getIsDownload();
            UploadNewGameDialog.this.h.f().f11422f = gameProgressInfo.getIsFinish();
            UploadNewGameDialog.this.h.f().f11418b = gameProgressInfo.getProgressText();
            UploadNewGameDialog.this.h.f().f11417a = gameProgressInfo.getProgressValue();
            UploadNewGameDialog.this.h.setVariable(518, UploadNewGameDialog.this.h.f());
            UploadNewGameDialog.this.h.executePendingBindings();
            gameProgressInfo.getIsNewEngine().set(Integer.valueOf(UploadNewGameDialog.this.j.getIsNewEngine()));
            gameProgressInfo.getIsUgc().set(Integer.valueOf(UploadNewGameDialog.this.j.getIsUgc()));
        }
    }

    private void g() {
        io.reactivex.p.timer(2000L, TimeUnit.MILLISECONDS).subscribe(new eb(this));
    }

    private void h() {
        if (this.h.f().f11421e.get().booleanValue()) {
            return;
        }
        if (this.f11415e != null) {
            this.f11414d = (List) new com.google.gson.j().a(this.f11415e, new Ya(this).getType());
        }
        List<AppEngineResourceUpdateItem> listA = a(this.f11414d);
        if (listA == null || listA.size() == 0) {
            com.apkfuns.logutils.c.a("UploadNewGameDialog downloadList").d("downloadList == null || downloadList.size() == 0");
            return;
        }
        List<String> pathType = GameDownloadUtils.getPathType(this.j, this.f11414d);
        DownloadInfo[] downloadInfoArr = new DownloadInfo[listA.size()];
        VerifyInfo[] verifyInfoArr = new VerifyInfo[listA.size()];
        UnzipInfo[] unzipInfoArr = new UnzipInfo[listA.size()];
        int i = 0;
        while (i < listA.size() && listA.get(i) != null && listA.get(i).getUrl() != null) {
            AppEngineResourceUpdateItem appEngineResourceUpdateItem = listA.get(i);
            String url = appEngineResourceUpdateItem.getUrl();
            String strSubstring = appEngineResourceUpdateItem.getUrl().substring(appEngineResourceUpdateItem.getUrl().lastIndexOf("/") + 1);
            String apkOrSoDownloadPath = CommonHelper.getApkOrSoDownloadPath(this);
            String type = appEngineResourceUpdateItem.getType();
            int i2 = i;
            long fileSize = appEngineResourceUpdateItem.getFileSize();
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
            i = i2 + 1;
        }
        com.sandboxol.file.b.a aVar = new com.sandboxol.file.b.a();
        aVar.a(downloadInfoArr);
        com.sandboxol.file.b.c cVar = new com.sandboxol.file.b.c();
        cVar.a(verifyInfoArr);
        GameReqParam gameResVersion = new GameReqParam().setGame(this.j).setCommonResVersion(String.valueOf(f11411a)).setGameResVersion(String.valueOf(f11412b));
        if (this.j.getIsNewEngine() == 0) {
            com.sandboxol.file.b.b bVar = new com.sandboxol.file.b.b();
            bVar.a(unzipInfoArr);
            bVar.a(1);
            DownloadClient downloadClient = DownloadClient.getInstance();
            MergeBuilder silent = new MergeBuilder().setReqParam(gameResVersion).setSilent(this.l);
            aVar.a(this.q);
            MergeBuilder verifyBuilder = silent.setDownloadBuilder(aVar).setVerifyBuilder(cVar);
            bVar.a(this.r);
            downloadClient.process(3, verifyBuilder.setUnzipBuilder(bVar));
            return;
        }
        this.m = this.j.getLatestResVersions().getCresVersion() == EngineEnv.loadCommonResVersion(BaseApplication.getContext(), this.j.getIsNewEngine(), this.j.getIsUgc());
        this.n = this.j.getLatestResVersions().getGresVersion() == SharedUtils.getLong(this, SharedConstant.NEW_ENGINE_COMMON_GAME_VERSION);
        if (CommonUtils.isNewEngineCommonGame(this.j.getGameId())) {
            com.sandboxol.file.b.b bVar2 = new com.sandboxol.file.b.b();
            bVar2.a(unzipInfoArr);
            bVar2.a(1);
            DownloadClient downloadClient2 = DownloadClient.getInstance();
            int isNewEngine = this.j.getIsNewEngine();
            int isUgc = this.j.getIsUgc();
            MergeBuilder reqParam = new MergeBuilder().setReqParam(gameResVersion);
            aVar.a(this.q);
            MergeBuilder verifyBuilder2 = reqParam.setDownloadBuilder(aVar).setVerifyBuilder(cVar);
            bVar2.a(new Za(this));
            downloadClient2.process(isNewEngine, isUgc, 4, verifyBuilder2.setUnzipBuilder(bVar2));
            com.sandboxol.file.b.b bVar3 = new com.sandboxol.file.b.b();
            bVar3.a(unzipInfoArr);
            bVar3.a(1);
            DownloadClient downloadClient3 = DownloadClient.getInstance();
            MergeBuilder reqParam2 = new MergeBuilder().setReqParam(gameResVersion);
            aVar.a(this.q);
            MergeBuilder verifyBuilder3 = reqParam2.setDownloadBuilder(aVar).setVerifyBuilder(cVar);
            bVar3.a(new _a(this));
            downloadClient3.process(2, verifyBuilder3.setUnzipBuilder(bVar3));
            return;
        }
        com.sandboxol.file.b.b bVar4 = new com.sandboxol.file.b.b();
        bVar4.a(unzipInfoArr);
        bVar4.a(1);
        DownloadClient downloadClient4 = DownloadClient.getInstance();
        int isNewEngine2 = this.j.getIsNewEngine();
        int isUgc2 = this.j.getIsUgc();
        MergeBuilder reqParam3 = new MergeBuilder().setReqParam(gameResVersion);
        aVar.a(this.q);
        MergeBuilder verifyBuilder4 = reqParam3.setDownloadBuilder(aVar).setVerifyBuilder(cVar);
        bVar4.a(new ab(this));
        downloadClient4.process(isNewEngine2, isUgc2, 4, verifyBuilder4.setUnzipBuilder(bVar4));
        com.sandboxol.file.b.b bVar5 = new com.sandboxol.file.b.b();
        bVar5.a(unzipInfoArr);
        bVar5.a(1);
        DownloadClient downloadClient5 = DownloadClient.getInstance();
        MergeBuilder reqParam4 = new MergeBuilder().setReqParam(gameResVersion);
        aVar.a(this.q);
        MergeBuilder verifyBuilder5 = reqParam4.setDownloadBuilder(aVar).setVerifyBuilder(cVar);
        bVar5.a(new bb(this));
        downloadClient5.process(3, verifyBuilder5.setUnzipBuilder(bVar5));
    }

    private void i() {
        this.l = true;
        if (this.g != null) {
            this.j = (Game) new com.google.gson.j().a(this.g, Game.class);
            this.l = false;
        }
        this.k = GameIdRemarkUtils.singleGameToHallGame(this.j.getGameId());
        this.j.setGameId(this.k);
    }

    private void j() {
        this.h.f().f11422f.addOnPropertyChangedCallback(this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.h.f7795d.setVisibility(0);
        this.h.f7794c.setVisibility(8);
        this.h.f7793b.setVisibility(0);
        this.h.f7792a.setVisibility(0);
        this.h.f7796e.setText(R.string.downloading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        g();
        if (!isFinishing()) {
            Messenger.getDefault().send(Integer.valueOf(this.f11416f), MessageToken.TOKEN_DOWNLOAD_SUCCESS_ENTER_PARTY);
        }
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.btnCancel) {
            return;
        }
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        a((Activity) this);
        this.f11415e = getIntent().getStringExtra(StringConstant.GAME_UPDATE_RESULTS);
        this.f11416f = getIntent().getIntExtra(StringConstant.UPLOAD_SO_HASH_CODE, 0);
        this.g = getIntent().getStringExtra(StringConstant.GAME_INFO);
        this.h = (Qb) androidx.databinding.e.a(this, R.layout.dialog_new_game_download);
        i();
        this.i = new a();
        this.h.a(this.i);
        this.i.initData();
        this.h.f7792a.setOnClickListener(this);
        h();
        j();
        ReportDataAdapter.onEvent(this, EventConstant.RES_DIALOG_SHOW_TIMES);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.h.f().f11422f.removeOnPropertyChangedCallback(this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void a(Throwable th) {
        ObservableField<Integer> observableField;
        a aVar = this.i;
        if (aVar == null || (observableField = aVar.f11417a) == null || observableField.get().intValue() != 100) {
            return;
        }
        String message = th.getMessage();
        byte b2 = -1;
        switch (message.hashCode()) {
            case -801291069:
                if (message.equals("failed md5 error")) {
                    b2 = 3;
                }
                break;
            case 128883741:
                if (message.equals("failed no memory")) {
                    b2 = 1;
                }
                break;
            case 411102104:
                if (message.equals("failed no file")) {
                    b2 = 0;
                }
                break;
            case 488719725:
                if (message.equals("failed other")) {
                    b2 = 2;
                }
                break;
        }
        int i = R.string.unzip_failed_other;
        if (b2 == 0) {
            i = R.string.unzip_failed_no_file;
        } else if (b2 == 1) {
            i = R.string.memory_not_enough;
        }
        this.h.f().f11419c.set(getString(i));
    }

    private List<AppEngineResourceUpdateItem> a(List<AppEngineResourceUpdateResult> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
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
                    f11412b = appEngineResourceUpdateResult.getResVersion();
                }
            } else {
                f11411a = appEngineResourceUpdateResult.getResVersion();
            }
        }
        return arrayList;
    }

    public static void a(Activity activity) {
        if (androidx.core.content.b.a(activity, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.a(activity, f11413c, 1);
        }
    }
}
