package com.disabngo.blockynexus.view.dialog;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0587gb;
import com.disabngo.blockynexus.entity.DownloadProgress;
import com.disabngo.blockynexus.utils.breakpoint.DownloadService;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public class UploadSoDialog extends AppCompatActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AbstractC0587gb f11425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f11426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private DownloadService.a f11427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ServiceConnection f11428f = new fb(this);

    private void i() {
        bindService(new Intent(this, (Class<?>) DownloadService.class), this.f11428f, 1);
        if (androidx.core.content.b.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.a(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f11425c.h.setVisibility(0);
        this.f11425c.g.setVisibility(8);
        this.f11425c.f8362f.setVisibility(0);
        this.f11425c.f8360d.setVisibility(8);
        this.f11425c.f8358b.setVisibility(8);
        this.f11425c.f8359c.setVisibility(8);
        this.f11425c.f8357a.setVisibility(0);
    }

    private void k() {
        this.f11425c.h.setVisibility(0);
        this.f11425c.g.setVisibility(0);
        this.f11425c.f8362f.setVisibility(8);
        this.f11425c.f8360d.setVisibility(0);
        this.f11425c.f8358b.setVisibility(0);
        this.f11425c.f8359c.setVisibility(8);
        this.f11425c.f8357a.setVisibility(8);
        this.f11426d.f11430b.set(getString(R.string.update_so_text_tip));
        this.f11425c.g.setText(R.string.txt_resource_update_content);
    }

    public void g() {
        this.f11425c.h.setVisibility(8);
        this.f11425c.g.setVisibility(0);
        this.f11425c.f8362f.setVisibility(8);
        this.f11425c.f8360d.setVisibility(8);
        this.f11425c.f8358b.setVisibility(8);
        this.f11425c.f8359c.setVisibility(8);
        this.f11425c.f8357a.setVisibility(8);
        this.f11425c.g.setText(R.string.update_so_failed_text);
        ReportDataAdapter.onEvent(this, EventConstant.SO_UPDATE_FAILED);
    }

    public void h() {
        this.f11425c.h.setVisibility(8);
        this.f11425c.g.setVisibility(0);
        this.f11425c.f8362f.setVisibility(8);
        this.f11425c.f8360d.setVisibility(8);
        this.f11425c.f8358b.setVisibility(8);
        this.f11425c.f8359c.setVisibility(0);
        this.f11425c.f8357a.setVisibility(8);
        this.f11425c.g.setText(R.string.update_so_success_text);
        ReportDataAdapter.onEvent(this, EventConstant.SO_UPDATE_SUC);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        switch (view.getId()) {
            case R.id.btnCancel /* 2131296463 */:
                DownloadService.a aVar = this.f11427e;
                if (aVar != null) {
                    aVar.a();
                    k();
                }
                break;
            case R.id.btnClose /* 2131296464 */:
                Process.killProcess(Process.myPid());
                break;
            case R.id.btnRestart /* 2131296472 */:
                Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.addFlags(268435456);
                    startActivity(launchIntentForPackage);
                    Process.killProcess(Process.myPid());
                }
                ReportDataAdapter.onEvent(this, EventConstant.CLICK_RESTART);
                break;
            case R.id.btnUpload /* 2131296479 */:
                DownloadService.a aVar2 = this.f11427e;
                if (aVar2 != null) {
                    aVar2.a(this.f11423a, this.f11424b);
                    this.f11426d.f11430b.set(getString(R.string.upload_so_progress_text, new Object[]{"0", "0"}));
                    j();
                }
                ReportDataAdapter.onEvent(this, EventConstant.CLICK_UPDATE_SO);
                break;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11425c = (AbstractC0587gb) androidx.databinding.e.a(this, R.layout.dialog_app_upload_so);
        this.f11426d = new a();
        this.f11425c.a(this.f11426d);
        this.f11425c.f8357a.setOnClickListener(this);
        this.f11425c.f8358b.setOnClickListener(this);
        this.f11425c.f8360d.setOnClickListener(this);
        this.f11425c.f8359c.setOnClickListener(this);
        this.f11423a = getIntent().getStringExtra(StringConstant.UPLOAD_SO_URL);
        this.f11424b = getIntent().getStringExtra(StringConstant.UPLOAD_SO_SIGNATURE);
        i();
    }

    public class a extends ViewModel {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ObservableField<Integer> f11429a = new ObservableField<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ObservableField<String> f11430b;

        public a() {
            this.f11430b = new ObservableField<>(UploadSoDialog.this.getString(R.string.update_so_text_tip));
            initMessenger();
        }

        private String c(long j) {
            String str;
            double dA = a(j);
            if (j < 1024) {
                str = String.valueOf(dA) + "B";
            } else if (j >= 1024 && j < 1048576) {
                str = String.valueOf(dA) + "K";
            } else if (j >= 1048576) {
                str = String.valueOf(dA) + "M";
            } else {
                str = "";
            }
            return String.valueOf(str);
        }

        private void initMessenger() {
            Messenger.getDefault().register(this, MessageToken.TOKEN_SO_DOWNLOAD_PROGRESS, DownloadProgress.class, new Action1() { // from class: com.disabngo.blockynexus.view.dialog.ia
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    this.f11608a.a((DownloadProgress) obj);
                }
            });
            Messenger messenger = Messenger.getDefault();
            final UploadSoDialog uploadSoDialog = UploadSoDialog.this;
            messenger.register(this, MessageToken.TOKEN_SO_DOWNLOAD_SUCCESS, new Action0() { // from class: com.disabngo.blockynexus.view.dialog.la
                @Override // rx.functions.Action0
                public final void call() {
                    uploadSoDialog.h();
                }
            });
            Messenger messenger2 = Messenger.getDefault();
            final UploadSoDialog uploadSoDialog2 = UploadSoDialog.this;
            messenger2.register(this, MessageToken.TOKEN_SO_DOWNLOAD_FAILED, new Action0() { // from class: com.disabngo.blockynexus.view.dialog.E
                @Override // rx.functions.Action0
                public final void call() {
                    uploadSoDialog2.g();
                }
            });
        }

        public /* synthetic */ void a(DownloadProgress downloadProgress) {
            final UploadSoDialog uploadSoDialog = UploadSoDialog.this;
            uploadSoDialog.runOnUiThread(new Runnable() { // from class: com.disabngo.blockynexus.view.dialog.ja
                @Override // java.lang.Runnable
                public final void run() {
                    uploadSoDialog.j();
                }
            });
            a(downloadProgress.getProgress(), downloadProgress.getTotalSize(), downloadProgress.getCurrentSize());
        }

        @Override // com.sandboxol.common.base.viewmodel.ViewModel
        public void onDestroy() {
            super.onDestroy();
            Messenger.getDefault().unregister(this);
        }

        private void a(int i, long j, long j2) {
            this.f11429a.set(Integer.valueOf(i));
            this.f11430b.set(UploadSoDialog.this.getString(R.string.upload_so_progress_text, new Object[]{c(j2), c(j)}));
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
}
