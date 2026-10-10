package com.disabngo.blockynexus.e.b.ba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.AppToastUtils;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: ResetPasswordViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bundle f9665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f9666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f9670f;
    private String g;
    public ObservableField<Boolean> i = new ObservableField<>(true);
    public ReplyCommand<String> j = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.ba.c
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9661a.a((String) obj);
        }
    });
    public ReplyCommand<String> k = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.ba.b
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9660a.b((String) obj);
        }
    });
    public ReplyCommand l = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ba.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f9659a.onSubmit();
        }
    });
    private f h = new f();

    public h(Context context, Bundle bundle) {
        this.f9666b = context;
        this.f9665a = bundle;
        initData();
    }

    private void initData() {
        Bundle bundle = this.f9665a;
        if (bundle != null) {
            this.f9667c = bundle.getString(StringConstant.AUTHCODE);
            this.f9668d = this.f9665a.getString("user_id");
            this.f9669e = this.f9665a.getString(StringConstant.UID);
            String str = this.f9668d;
            if (str == null || str.equals("")) {
                this.f9668d = String.valueOf(AccountCenter.newInstance().userId.get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSubmit() {
        String str = this.f9670f;
        if (str == null || str.equals("")) {
            AppToastUtils.showShortNegativeTipToast(this.f9666b, R.string.account_password_empty);
            return;
        }
        String str2 = this.g;
        if (str2 == null || str2.equals("")) {
            AppToastUtils.showShortNegativeTipToast(this.f9666b, R.string.account_password_empty);
            return;
        }
        if (this.f9670f.length() < 6 || this.g.length() < 6) {
            AppToastUtils.showShortNegativeTipToast(this.f9666b, R.string.account_password_less_6);
            return;
        }
        if (!this.g.equals(this.f9670f)) {
            AppToastUtils.showShortNegativeTipToast(this.f9666b, R.string.inconsistent_password);
        } else {
            if (this.f9667c == null) {
                return;
            }
            this.i.set(false);
            this.h.a(this.f9666b, Long.valueOf(Long.parseLong(this.f9668d)), this.f9670f, this.f9667c, new g(this));
        }
    }

    void onBack() {
        final TwoButtonDialog twoButtonDialog = new TwoButtonDialog(this.f9666b);
        twoButtonDialog.setTitleText(this.f9666b.getResources().getString(R.string.tip));
        twoButtonDialog.setLeftButtonText(R.string.cancel);
        twoButtonDialog.setRightButtonText(R.string.confirm);
        twoButtonDialog.setDetailText(R.string.not_reset_password_tips);
        twoButtonDialog.setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.ba.d
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f9662a.a(twoButtonDialog);
            }
        });
        twoButtonDialog.show();
    }

    public /* synthetic */ void a(String str) {
        this.f9670f = str;
    }

    public /* synthetic */ void b(String str) {
        this.g = str;
    }

    public /* synthetic */ void a(TwoButtonDialog twoButtonDialog) {
        twoButtonDialog.dismiss();
        ((Activity) this.f9666b).finish();
    }
}
