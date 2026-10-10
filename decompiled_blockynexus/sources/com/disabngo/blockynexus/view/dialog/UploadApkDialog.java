package com.disabngo.blockynexus.view.dialog;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0565eb;
import com.disabngo.blockynexus.entity.DownloadProgress;
import com.disabngo.blockynexus.utils.breakpoint.DownloadService;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.SharedUtils;
import java.io.File;
import java.io.IOException;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public class UploadApkDialog extends AppCompatActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String[] f11399a = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AbstractC0565eb f11404f;
    private a g;
    private DownloadService.a h;
    private ServiceConnection i = new Wa(this);

    private void i() {
        bindService(new Intent(this, (Class<?>) DownloadService.class), this.i, 1);
        if (androidx.core.content.b.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.a(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
    }

    private void j() {
        String apkOrSoDownloadPath = CommonHelper.getApkOrSoDownloadPath(this);
        String str = this.f11400b;
        File file = new File(apkOrSoDownloadPath, str.substring(str.lastIndexOf("/")));
        if (file.isFile()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            if (Build.VERSION.SDK_INT >= 24) {
                Uri uriForFile = FileProvider.getUriForFile(this, "com.disabngo.blockynexus.FileProvider", file);
                intent.addFlags(1);
                intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
            } else {
                a(file);
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                intent.setFlags(268435456);
            }
            getApplicationContext().startActivity(intent);
            ReportDataAdapter.onEvent(this, EventConstant.DOWNLOAD_SUCCESS, String.valueOf(Build.VERSION.SDK_INT));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f11404f.h.setVisibility(0);
        this.f11404f.g.setVisibility(8);
        this.f11404f.f8293f.setVisibility(0);
        this.f11404f.f8292e.setVisibility(8);
        this.f11404f.f8289b.setVisibility(8);
        this.f11404f.f8291d.setVisibility(8);
        this.f11404f.f8290c.setVisibility(8);
        this.f11404f.f8288a.setVisibility(0);
        ReportDataAdapter.onEvent(this, EventConstant.DOWNLOAD_WIN);
    }

    private void l() {
        this.f11404f.h.setVisibility(8);
        this.f11404f.g.setVisibility(0);
        this.f11404f.f8293f.setVisibility(8);
        this.f11404f.f8292e.setVisibility(0);
        if (this.f11401c) {
            this.f11404f.f8289b.setVisibility(8);
        } else {
            this.f11404f.f8289b.setVisibility(0);
        }
        this.f11404f.f8291d.setVisibility(8);
        this.f11404f.f8288a.setVisibility(8);
        this.f11404f.f8290c.setVisibility(8);
    }

    public void g() {
        this.f11404f.h.setVisibility(8);
        this.f11404f.g.setVisibility(0);
        this.f11404f.f8293f.setVisibility(8);
        this.f11404f.f8292e.setVisibility(8);
        this.f11404f.f8289b.setVisibility(8);
        this.f11404f.f8291d.setVisibility(0);
        this.f11404f.f8288a.setVisibility(8);
        this.f11404f.f8290c.setVisibility(8);
        this.f11404f.g.setText(R.string.update_so_failed_text);
        ReportDataAdapter.onEvent(this, EventConstant.APK_DOWNLOAD_FAILED);
    }

    public void h() {
        this.f11404f.h.setVisibility(8);
        this.f11404f.g.setVisibility(0);
        this.f11404f.f8293f.setVisibility(8);
        this.f11404f.f8292e.setVisibility(8);
        this.f11404f.f8289b.setVisibility(8);
        this.f11404f.f8291d.setVisibility(8);
        this.f11404f.f8288a.setVisibility(8);
        this.f11404f.f8290c.setVisibility(0);
        this.f11404f.g.setText(R.string.update_so_success);
        ReportDataAdapter.onEvent(this, EventConstant.APK_DOWNLOAD_SUC);
        j();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCancel /* 2131296463 */:
                DownloadService.a aVar = this.h;
                if (aVar != null) {
                    aVar.a();
                    l();
                }
                break;
            case R.id.btnClose /* 2131296464 */:
                finish();
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_IS_NEED_UPDATE);
                break;
            case R.id.btnInstall /* 2131296469 */:
                j();
                ReportDataAdapter.onEvent(this, EventConstant.CLICK_INSTALL);
                break;
            case R.id.btnRestart /* 2131296472 */:
                DownloadService.a aVar2 = this.h;
                if (aVar2 != null) {
                    aVar2.a(this.f11400b, null);
                    this.g.f11406b.set(getString(R.string.upload_so_progress_text, new Object[]{"0", "0"}));
                    k();
                }
                break;
            case R.id.btnUpload /* 2131296479 */:
                DownloadService.a aVar3 = this.h;
                if (aVar3 != null) {
                    aVar3.a(this.f11400b, null);
                    this.g.f11406b.set(getString(R.string.upload_so_progress_text, new Object[]{"0", "0"}));
                    k();
                }
                SharedUtils.putInt(this, SharedConstant.SAVE_CDN_DOWNLOAD_APP_VERSION, BaseApplication.getApp().getMetaDataAppVersion());
                ReportDataAdapter.onEvent(this, EventConstant.CLICK_DOWNLOAD_APK);
                break;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        a((Activity) this);
        this.f11400b = getIntent().getStringExtra(StringConstant.UPLOAD_SO_URL);
        this.f11401c = getIntent().getBooleanExtra(StringConstant.IS_FORCE_UPDATE, false);
        this.f11402d = getIntent().getStringExtra(StringConstant.UPLOAD_DETAILS);
        this.f11403e = getIntent().getStringExtra(StringConstant.UPLOAD_PIC_URL);
        this.f11404f = (AbstractC0565eb) androidx.databinding.e.a(this, R.layout.dialog_app_upload_apk);
        this.g = new a();
        this.f11404f.a(this.g);
        this.f11404f.f8288a.setOnClickListener(this);
        this.f11404f.f8289b.setOnClickListener(this);
        this.f11404f.f8292e.setOnClickListener(this);
        this.f11404f.f8291d.setOnClickListener(this);
        this.f11404f.f8290c.setOnClickListener(this);
        i();
        ReportDataAdapter.onEvent(this, EventConstant.UPDATE_WIN_COM);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unbindService(this.i);
        Messenger.getDefault().unregister(this);
    }

    public class a extends ViewModel {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ObservableField<Integer> f11405a = new ObservableField<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ObservableField<String> f11406b = new ObservableField<>("");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ObservableField<String> f11407c = new ObservableField<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ObservableField<Boolean> f11408d = new ObservableField<>(false);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ObservableField<Boolean> f11409e = new ObservableField<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ObservableField<String> f11410f = new ObservableField<>();

        public a() {
            initMessenger();
            this.f11407c.set(UploadApkDialog.this.f11402d);
            this.f11408d.set(Boolean.valueOf(UploadApkDialog.this.f11401c));
            if (UploadApkDialog.this.f11403e == null || "".equals(UploadApkDialog.this.f11403e)) {
                return;
            }
            this.f11410f.set(UploadApkDialog.this.f11403e);
            this.f11409e.set(true);
        }

        private String c(long j) {
            String str;
            double dA = a(j);
            if (j < 1024) {
                str = String.valueOf(dA) + "B";
            } else if (j < 1048576) {
                str = String.valueOf(dA) + "K";
            } else {
                str = String.valueOf(dA) + "M";
            }
            return String.valueOf(str);
        }

        private void initMessenger() {
            Messenger.getDefault().register(this, MessageToken.TOKEN_SO_DOWNLOAD_PROGRESS, DownloadProgress.class, new Action1() { // from class: com.disabngo.blockynexus.view.dialog.ha
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    this.f11595a.a((DownloadProgress) obj);
                }
            });
            Messenger messenger = Messenger.getDefault();
            final UploadApkDialog uploadApkDialog = UploadApkDialog.this;
            messenger.register(this, MessageToken.TOKEN_SO_DOWNLOAD_SUCCESS, new Action0() { // from class: com.disabngo.blockynexus.view.dialog.ka
                @Override // rx.functions.Action0
                public final void call() {
                    uploadApkDialog.h();
                }
            });
            Messenger messenger2 = Messenger.getDefault();
            final UploadApkDialog uploadApkDialog2 = UploadApkDialog.this;
            messenger2.register(this, MessageToken.TOKEN_SO_DOWNLOAD_FAILED, new Action0() { // from class: com.disabngo.blockynexus.view.dialog.na
                @Override // rx.functions.Action0
                public final void call() {
                    uploadApkDialog2.g();
                }
            });
        }

        public /* synthetic */ void a(DownloadProgress downloadProgress) {
            UploadApkDialog.this.k();
            a(downloadProgress.getProgress(), downloadProgress.getTotalSize(), downloadProgress.getCurrentSize());
        }

        private void a(int i, long j, long j2) {
            this.f11405a.set(Integer.valueOf(i));
            this.f11406b.set(UploadApkDialog.this.getString(R.string.upload_so_progress_text, new Object[]{c(j2), c(j)}));
        }

        private double a(long j) {
            double d2;
            if (j < 1024) {
                return 0.0d;
            }
            if (j >= 1024 && j < 1048576) {
                d2 = (j * 10) / 1024;
                Double.isNaN(d2);
            } else {
                if (j < 1048576) {
                    return 0.0d;
                }
                d2 = (j * 10) / 1048576;
                Double.isNaN(d2);
            }
            return d2 / 10.0d;
        }
    }

    public static void a(Activity activity) {
        if (androidx.core.content.b.a(activity, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.a(activity, f11399a, 1);
        }
    }

    private void a(File file) {
        try {
            new ProcessBuilder("chmod", "777", file.getPath()).start();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
