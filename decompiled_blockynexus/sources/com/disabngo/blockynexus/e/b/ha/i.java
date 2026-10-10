package com.disabngo.blockynexus.e.b.ha;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0700qf;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.SecretQuestionInfo;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.AppToastUtils;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: SecretQuestionVerifyViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9809a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bundle f9812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<SecretQuestionInfo> f9813e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SecretQuestionInfo f9814f;
    private SecretQuestionInfo g;
    private String h;
    private String i;
    private AbstractC0700qf j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9811c = false;
    public ObservableField<Boolean> k = new ObservableField<>(true);
    public ObservableField<Boolean> l = new ObservableField<>(false);
    public ObservableField<String> m = new ObservableField<>();
    public ObservableField<String> n = new ObservableField<>();
    public ObservableField<String> o = new ObservableField<>("");
    public ObservableField<String> p = new ObservableField<>("");
    public ReplyCommand q = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ha.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f9806a.h();
        }
    });
    public ReplyCommand r = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ha.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9802a.f();
        }
    });
    public ReplyCommand<String> s = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.ha.d
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9805a.a((String) obj);
        }
    });
    public ReplyCommand<String> t = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.ha.a
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9801a.b((String) obj);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f9810b = new g();

    public i(Context context, Bundle bundle) {
        this.f9809a = context;
        this.f9812d = bundle;
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if ("".equals(this.p.get()) || this.p.get().trim().length() < 1) {
            AppToastUtils.showShortPositiveTipToast(this.f9809a, R.string.input_answer);
        } else {
            this.g.setAnswer(this.p.get());
            a(this.g, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if ("".equals(this.o.get()) || this.o.get().trim().length() < 1) {
            AppToastUtils.showShortPositiveTipToast(this.f9809a, R.string.input_answer);
        } else {
            this.f9814f.setAnswer(this.o.get());
            a(this.f9814f, 0);
        }
    }

    private void initData() {
        Bundle bundle = this.f9812d;
        if (bundle != null) {
            this.h = bundle.getString("user_id");
            this.i = this.f9812d.getString(StringConstant.UID);
            this.f9813e = this.f9812d.getParcelableArrayList(StringConstant.SECRET_QUESTION);
            this.f9811c = this.f9812d.getString(StringConstant.TYPE_FROM_FRAGMENT) != null && this.f9809a.getResources().getString(R.string.item_view_forget_password).equals(this.f9812d.getString(StringConstant.TYPE_FROM_FRAGMENT));
            List<SecretQuestionInfo> list = this.f9813e;
            if (list == null || list.size() < 2) {
                return;
            }
            this.f9814f = this.f9813e.get(0);
            this.g = this.f9813e.get(1);
            this.m.set(this.f9813e.get(0).getQuestion());
            this.n.set(this.f9813e.get(1).getQuestion());
        }
    }

    void onBack() {
        final TwoButtonDialog twoButtonDialog = new TwoButtonDialog(this.f9809a);
        twoButtonDialog.setTitleText(this.f9809a.getResources().getString(R.string.tip));
        twoButtonDialog.setLeftButtonText(R.string.cancel);
        twoButtonDialog.setRightButtonText(R.string.confirm);
        if (this.f9811c) {
            twoButtonDialog.setDetailText(R.string.not_reset_password_tips);
        } else {
            twoButtonDialog.setDetailText(R.string.not_verify_secret_question_tips);
        }
        twoButtonDialog.setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.ha.c
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f9803a.a(twoButtonDialog);
            }
        });
        twoButtonDialog.show();
    }

    public /* synthetic */ void a(String str) {
        this.o.set(str);
    }

    public /* synthetic */ void b(String str) {
        this.p.set(str);
    }

    void a(AbstractC0700qf abstractC0700qf) {
        this.j = abstractC0700qf;
    }

    private void a(SecretQuestionInfo secretQuestionInfo, int i) {
        this.k.set(false);
        Long lValueOf = AccountCenter.newInstance().userId.get();
        if (this.f9811c) {
            lValueOf = Long.valueOf(Long.parseLong(this.h));
        }
        this.f9810b.a(this.f9809a, lValueOf, secretQuestionInfo, i, new h(this, i));
    }

    public /* synthetic */ void a(TwoButtonDialog twoButtonDialog) {
        twoButtonDialog.dismiss();
        ((Activity) this.f9809a).finish();
    }
}
