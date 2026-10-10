package com.disabngo.blockynexus.e.b.r;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.q.C0905f;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.download.utils.ProgressUtils;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.c.U;
import com.sandboxol.greendao.c.fa;
import java.io.File;
import rx.functions.Action0;

/* JADX INFO: compiled from: DiskSpaceViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class v extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10122a;
    public long i;
    public long j;
    public long k;
    public long l;
    public ObservableField<Boolean> m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10123b = 1048576;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Integer> f10124c = new ObservableField<>(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Integer> f10125d = new ObservableField<>(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Integer> f10126e = new ObservableField<>(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<String> f10127f = new ObservableField<>("");
    public ObservableField<String> g = new ObservableField<>("");
    public ObservableField<String> h = new ObservableField<>("");
    public ObservableField<Boolean> n = new ObservableField<>(true);
    public ObservableField<Boolean> o = new ObservableField<>(true);
    public ObservableField<Boolean> p = new ObservableField<>(true);
    public ObservableField<Boolean> q = new ObservableField<>(true);
    public ObservableField<Boolean> r = new ObservableField<>(false);
    public ObservableField<String> s = new ObservableField<>("");
    public ReplyCommand t = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.r.j
        @Override // rx.functions.Action0
        public final void call() {
            this.f10109a.j();
        }
    });
    public ReplyCommand u = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.r.g
        @Override // rx.functions.Action0
        public final void call() {
            this.f10106a.i();
        }
    });
    public ReplyCommand v = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.r.i
        @Override // rx.functions.Action0
        public final void call() {
            this.f10108a.E();
        }
    });

    public v(Context context, ObservableField<Boolean> observableField) {
        this.f10122a = context;
        this.m = observableField;
        u();
        initData();
        initMessenger();
        ReportDataAdapter.onEvent(context, EventConstant.CLEAN_PHONE_PAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        this.f10126e.set(Integer.valueOf((int) ((this.k + this.i) / 1048576)));
        this.g.set(ProgressUtils.formatSize(Long.valueOf(this.k + this.i)));
        this.h.set(ProgressUtils.formatSize(Long.valueOf(this.j)));
        this.n.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        Context context = this.f10122a;
        TemplateUtils.startTemplate(context, C0905f.class, context.getString(R.string.app_disk_space_management));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        ReportDataAdapter.onEvent(this.f10122a, EventConstant.CLEAN_ALL_CLICK);
        new TwoButtonDialog(this.f10122a).setDetailText(R.string.app_disk_clean_tip).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.r.c
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f10102a.h();
            }
        }).show();
        ReportDataAdapter.onEvent(this.f10122a, EventConstant.CLEAN_RESTART_WIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        this.n.set(true);
        k();
        m();
        l();
        p();
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_DISK_SPACE, new Action0() { // from class: com.disabngo.blockynexus.e.b.r.f
            @Override // rx.functions.Action0
            public final void call() {
                this.f10105a.initData();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ReportDataAdapter.onEvent(this.f10122a, EventConstant.CLEAN_CACHE);
        io.reactivex.p.create(new io.reactivex.s() { // from class: com.disabngo.blockynexus.e.b.r.a
            @Override // io.reactivex.s
            public final void a(io.reactivex.r rVar) throws Exception {
                this.f10100a.a(rVar);
            }
        }).subscribeOn(io.reactivex.f.b.b()).observeOn(io.reactivex.android.b.b.a()).subscribe(new t(this));
    }

    private void k() {
        io.reactivex.p.create(new io.reactivex.s() { // from class: com.disabngo.blockynexus.e.b.r.d
            @Override // io.reactivex.s
            public final void a(io.reactivex.r rVar) throws Exception {
                this.f10103a.b(rVar);
            }
        }).subscribeOn(io.reactivex.f.b.b()).observeOn(io.reactivex.android.b.b.a()).subscribe(new p(this));
    }

    private void l() {
        io.reactivex.p.create(new io.reactivex.s() { // from class: com.disabngo.blockynexus.e.b.r.b
            @Override // io.reactivex.s
            public final void a(io.reactivex.r rVar) throws Exception {
                this.f10101a.c(rVar);
            }
        }).subscribeOn(io.reactivex.f.b.b()).observeOn(io.reactivex.android.b.b.a()).subscribe(new q(this));
    }

    private void m() {
        fa.newInstance().a(new s(this, new ObservableField(0L)));
    }

    private void p() {
        io.reactivex.p.create(new io.reactivex.s() { // from class: com.disabngo.blockynexus.e.b.r.e
            @Override // io.reactivex.s
            public final void a(io.reactivex.r rVar) throws Exception {
                this.f10104a.d(rVar);
            }
        }).subscribeOn(io.reactivex.f.b.b()).observeOn(io.reactivex.android.b.b.a()).subscribe(new o(this));
    }

    private void u() {
        this.o.addOnPropertyChangedCallback(new l(this));
        this.p.addOnPropertyChangedCallback(new m(this));
        this.q.addOnPropertyChangedCallback(new n(this));
    }

    public /* synthetic */ void c(io.reactivex.r rVar) throws Exception {
        this.q.set(true);
        String sDCardPath = EngineEnv.getEngine(0, 0).getSDCardPath();
        String sDCardPath2 = EngineEnv.getEngine(1, 0).getSDCardPath();
        String sDCardPath3 = EngineEnv.getEngine(1, 1).getSDCardPath();
        File file = new File(sDCardPath);
        File file2 = new File(sDCardPath2);
        File file3 = new File(sDCardPath3);
        long jB = file.exists() ? 0 + com.disabngo.blockynexus.d.m.b(file) : 0L;
        if (file2.exists()) {
            jB += com.disabngo.blockynexus.d.m.b(file2);
        }
        if (file3.exists()) {
            jB += com.disabngo.blockynexus.d.m.b(file3);
        }
        rVar.onNext(Long.valueOf(jB));
    }

    public /* synthetic */ void d(io.reactivex.r rVar) throws Exception {
        File cacheDir = this.f10122a.getCacheDir();
        if (cacheDir != null && cacheDir.exists()) {
            long jB = com.disabngo.blockynexus.d.m.b(cacheDir);
            this.f10127f.set(ProgressUtils.formatSize(Long.valueOf(jB)));
            this.l = jB;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockCountLong = statFs.getBlockCountLong();
            long availableBlocksLong = statFs.getAvailableBlocksLong();
            long blockSizeLong = statFs.getBlockSizeLong();
            long j = blockCountLong * blockSizeLong;
            long j2 = j - (availableBlocksLong * blockSizeLong);
            this.f10124c.set(Integer.valueOf((int) (j / 1048576)));
            this.f10125d.set(Integer.valueOf((int) (j2 / 1048576)));
            this.s.set(ProgressUtils.formatSize(Long.valueOf(j2)) + "/" + ProgressUtils.formatSize(Long.valueOf(j)));
        } else {
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSize = statFs2.getBlockSize();
            long blockCount = ((long) statFs2.getBlockCount()) * blockSize;
            long availableBlocks = blockCount - (((long) statFs2.getAvailableBlocks()) * blockSize);
            this.f10124c.set(Integer.valueOf((int) (blockCount / 1048576)));
            this.f10125d.set(Integer.valueOf((int) (availableBlocks / 1048576)));
            this.s.set(ProgressUtils.formatSize(Long.valueOf(availableBlocks)) + "/" + ProgressUtils.formatSize(Long.valueOf(blockCount)));
        }
        rVar.onComplete();
    }

    public /* synthetic */ void e(io.reactivex.r rVar) throws Exception {
        this.m.set(true);
        String sDCardPath = EngineEnv.getEngine(0, 0).getSDCardPath();
        String sDCardPath2 = EngineEnv.getEngine(1, 0).getSDCardPath();
        String sDCardPath3 = EngineEnv.getEngine(1, 1).getSDCardPath();
        File file = new File(sDCardPath);
        File file2 = new File(sDCardPath2);
        File file3 = new File(sDCardPath3);
        if (file.exists()) {
            com.disabngo.blockynexus.d.m.a(file);
        }
        if (file2.exists()) {
            com.disabngo.blockynexus.d.m.a(file2);
        }
        if (file3.exists()) {
            com.disabngo.blockynexus.d.m.a(file3);
        }
        f();
        rVar.onComplete();
    }

    public void f() {
        String[] list;
        File cacheDir = this.f10122a.getCacheDir();
        String resRootPath = EngineEnv.getEngine(0, 0).getResRootPath();
        if (resRootPath.endsWith("/")) {
            resRootPath = resRootPath.substring(0, resRootPath.length() - 1);
        }
        String apkOrSoDownloadPath = CommonHelper.getApkOrSoDownloadPath(this.f10122a);
        if (cacheDir == null || !cacheDir.exists() || TextUtils.isEmpty(cacheDir.getParent())) {
            return;
        }
        File file = new File(cacheDir.getParent());
        if (file.exists() && (list = file.list()) != null && list.length > 0) {
            fa.newInstance().a();
            U.newInstance().b();
            SharedUtils.putLong(this.f10122a, SharedConstant.NEW_ENGINE_COMMON_GAME_VERSION, 0L);
            EngineEnv.storeCommonResVersion(this.f10122a, 1, 0, 0L);
            EngineEnv.storeCommonResVersion(this.f10122a, 1, 1, 0L);
            SharedPreferences.Editor editorEdit = this.f10122a.getApplicationContext().getSharedPreferences("data", 0).edit();
            editorEdit.putLong(SharedConstant.CLOTHES_RES_VERSION_CODE, 0L);
            editorEdit.putInt(SharedConstant.SENSITIVE_WORD_VERSION, 0);
            editorEdit.commit();
            com.sandboxol.decorate.manager.o.a().a(this.f10122a);
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    File file2 = new File(file, str);
                    if (file2.exists() && (file2.getPath().equals(apkOrSoDownloadPath) || file2.getPath().startsWith(resRootPath))) {
                        com.disabngo.blockynexus.d.m.a(file2);
                    }
                }
            }
        }
    }

    public /* synthetic */ void h() {
        ReportDataAdapter.onEvent(this.f10122a, EventConstant.CLEAN_RESTART_WIN_COMFIRM);
        io.reactivex.p.create(new io.reactivex.s() { // from class: com.disabngo.blockynexus.e.b.r.h
            @Override // io.reactivex.s
            public final void a(io.reactivex.r rVar) throws Exception {
                this.f10107a.e(rVar);
            }
        }).subscribeOn(io.reactivex.f.b.b()).observeOn(io.reactivex.android.b.b.a()).subscribe(new u(this));
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    public /* synthetic */ void a(io.reactivex.r rVar) throws Exception {
        this.r.set(true);
        File cacheDir = this.f10122a.getCacheDir();
        if (cacheDir != null && cacheDir.exists()) {
            com.disabngo.blockynexus.d.m.a(cacheDir);
        }
        rVar.onNext(0L);
    }

    public /* synthetic */ void b(io.reactivex.r rVar) throws Exception {
        this.o.set(true);
        String parent = this.f10122a.getCacheDir().getParent();
        long jB = 0;
        if (parent != null) {
            File file = new File(parent);
            if (file.exists()) {
                jB = 0 + com.disabngo.blockynexus.d.m.b(file);
            }
        }
        rVar.onNext(Long.valueOf(jB));
    }
}
