package com.sandboxol.center.utils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.sandboxol.center.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.RxPermissions2;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class PermissionsManager {
    private io.reactivex.b.a action;
    private FragmentActivity activity;
    private TwoButtonDialog cancelDialog;
    private TwoButtonDialog denyDialog;
    private boolean isShow;
    private boolean isShowCancel;
    private TwoButtonDialog tipDialog;

    public PermissionsManager(io.reactivex.b.a aVar) {
        this.action = aVar;
        Messenger.getDefault().register(this, MessageToken.TOKEN_REQUEST_PERMISSION, new Action0() { // from class: com.sandboxol.center.utils.l
            @Override // rx.functions.Action0
            public final void call() {
                this.f16363a.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        if (this.activity != null) {
            Messenger.getDefault().unregister(this);
            this.activity.finish();
        }
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: gotoSettings, reason: merged with bridge method [inline-methods] */
    public void b(FragmentActivity fragmentActivity) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", fragmentActivity.getPackageName(), null));
        if (intent.resolveActivity(fragmentActivity.getPackageManager()) != null) {
            fragmentActivity.startActivityForResult(intent, 2002);
        }
    }

    public /* synthetic */ void a() {
        FragmentActivity fragmentActivity = this.activity;
        if (fragmentActivity != null) {
            a(fragmentActivity);
        }
    }

    public /* synthetic */ void b() {
        this.cancelDialog.show();
        this.isShow = true;
    }

    public /* synthetic */ void c() {
        if (this.isShow) {
            finishActivity();
        } else {
            this.tipDialog.show();
        }
    }

    @SuppressLint({"CheckResult"})
    /* JADX INFO: renamed from: requestPermission, reason: merged with bridge method [inline-methods] */
    public void a(final FragmentActivity fragmentActivity) {
        this.activity = fragmentActivity;
        new RxPermissions2(fragmentActivity).requestEachCombined("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE").subscribe(new io.reactivex.b.g() { // from class: com.sandboxol.center.utils.g
            @Override // io.reactivex.b.g
            public final void accept(Object obj) throws Exception {
                this.f16356a.a(fragmentActivity, (com.tbruyelle.rxpermissions2.e) obj);
            }
        });
    }

    public /* synthetic */ void a(final FragmentActivity fragmentActivity, com.tbruyelle.rxpermissions2.e eVar) throws Exception {
        MultiProcessSharedUtils.putBoolean(BaseApplication.getContext(), SharedConstant.READ_WRITE_PERMISSION, eVar.f19384b);
        if (eVar.f19384b) {
            io.reactivex.b.a aVar = this.action;
            if (aVar != null) {
                aVar.run();
                return;
            }
            return;
        }
        if (eVar.f19385c) {
            ReportDataAdapter.onEvent(fragmentActivity, EventConstant.STORAGE_WIN_REFUSE);
            if (this.denyDialog == null) {
                this.denyDialog = new TwoButtonDialog(fragmentActivity).setDetailText(R.string.base_read_write_permission_tip).setLeftListener(new TwoButtonDialog.OnTwoButtonDialogLeftClickListener() { // from class: com.sandboxol.center.utils.i
                    @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogLeftClickListener
                    public final void onLeftClick() {
                        this.f16359a.finishActivity();
                    }
                }).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.center.utils.k
                    @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                    public final void onClick() {
                        this.f16361a.a(fragmentActivity);
                    }
                });
                this.denyDialog.show();
                return;
            } else {
                finishActivity();
                return;
            }
        }
        ReportDataAdapter.onEvent(fragmentActivity, EventConstant.STORAGE_WIN_REFUSE_NO_ASK);
        if (this.cancelDialog == null && this.tipDialog == null) {
            this.tipDialog = new TwoButtonDialog(fragmentActivity).setDetailText(R.string.base_read_write_permission_tip).setLeftListener(new TwoButtonDialog.OnTwoButtonDialogLeftClickListener() { // from class: com.sandboxol.center.utils.i
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogLeftClickListener
                public final void onLeftClick() {
                    this.f16359a.finishActivity();
                }
            }).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.center.utils.j
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f16360a.b();
                }
            });
            this.cancelDialog = new TwoButtonDialog(fragmentActivity).setRightButtonText(R.string.base_go).setDetailText(R.string.base_read_write_permission_go_setting_tip).setLeftListener(new TwoButtonDialog.OnTwoButtonDialogLeftClickListener() { // from class: com.sandboxol.center.utils.h
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogLeftClickListener
                public final void onLeftClick() {
                    this.f16358a.c();
                }
            }).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.center.utils.m
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f16364a.b(fragmentActivity);
                }
            });
        }
        if (this.isShowCancel) {
            if (this.isShow) {
                finishActivity();
                return;
            } else {
                this.tipDialog.show();
                return;
            }
        }
        this.cancelDialog.show();
        this.isShowCancel = true;
    }
}
