package com.disabngo.blockynexus.e.b.b;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.e.C0834f;
import com.disabngo.blockynexus.e.b.f.C0844e;
import com.disabngo.blockynexus.e.b.s.C0916e;
import com.disabngo.blockynexus.view.dialog.Ea;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import rx.functions.Action0;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.b.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AccountSafeViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0820g extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<String> f9654b = new ObservableField<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Integer> f9655c = new ObservableField<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f9656d = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.b.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f9652a.f();
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f9657e = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.b.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9649a.h();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f9658f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.b.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f9648a.i();
        }
    });
    public ReplyCommand g = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.b.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f9651a.j();
        }
    });
    public ReplyCommand h = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.b.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f9650a.k();
        }
    });

    public C0820g(Context context) {
        this.f9653a = context;
    }

    public /* synthetic */ void f() {
        Context context = this.f9653a;
        LoginManager.onConfirmPassword(context, context.getString(R.string.item_view_change_password));
        ReportDataAdapter.onEvent(this.f9653a, EventConstant.MORE_CHPASS_CLICK);
    }

    public /* synthetic */ void h() {
        Context context = this.f9653a;
        LoginManager.onSetPassword(context, context.getString(R.string.account_safe_set_password));
        ReportDataAdapter.onEvent(this.f9653a, EventConstant.MORE_CHPASS_CLICK);
    }

    public /* synthetic */ void i() {
        if (!"".equals(AccountCenter.newInstance().email.get()) && AccountCenter.newInstance().email.get() != null) {
            Context context = this.f9653a;
            TemplateUtils.startTemplate(context, C0916e.class, context.getString(R.string.item_view_bind_email));
        } else {
            Context context2 = this.f9653a;
            TemplateUtils.startTemplate(context2, C0834f.class, context2.getString(R.string.item_view_bind_email));
            ReportDataAdapter.onEvent(this.f9653a, EventConstant.MORE_EMAIL_CLICK);
        }
    }

    public /* synthetic */ void j() {
        if (AccountCenter.newInstance().hasPassword.get() == null || !AccountCenter.newInstance().hasPassword.get().booleanValue()) {
            AppToastUtils.showShortNegativeTipToast(this.f9653a, R.string.setting_password);
            return;
        }
        Context context = this.f9653a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ca.c.class, context.getString(R.string.item_view_safe_setting));
        ReportDataAdapter.onEvent(this.f9653a, EventConstant.MORE_SAFE_SETTING_CLICK);
    }

    public /* synthetic */ void k() {
        if (!"".equals(AccountCenter.newInstance().telephone.get())) {
            Context context = this.f9653a;
            TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.T.e.class, context.getString(R.string.item_view_bind_phone));
        } else {
            Context context2 = this.f9653a;
            TemplateUtils.startTemplate(context2, C0844e.class, context2.getString(R.string.item_view_bind_phone));
            ReportDataAdapter.onEvent(this.f9653a, EventConstant.MORE_MOI_CLICK);
        }
    }

    void l() {
        boolean z = AccountCenter.newInstance().email.get() == null || AccountCenter.newInstance().email.get().equals("");
        boolean z2 = AccountCenter.newInstance().isFinishSecretQuestion.get() == null || !AccountCenter.newInstance().isFinishSecretQuestion.get().booleanValue();
        boolean z3 = AccountCenter.newInstance().hasPassword.get() != null && AccountCenter.newInstance().hasPassword.get().booleanValue();
        if (AccountCenter.newInstance().login.get().booleanValue() && z && z2 && z3 && SharedUtils.getBoolean(this.f9653a, StringConstant.IS_SAFE_SETTING_GUIDE, true)) {
            new Ea(this.f9653a).show();
            SharedUtils.putBoolean(this.f9653a, StringConstant.IS_SAFE_SETTING_GUIDE, false);
        }
    }

    void m() {
        AccountCenter accountCenterNewInstance = AccountCenter.newInstance();
        boolean zBooleanValue = accountCenterNewInstance.isFinishSecretQuestion.get().booleanValue();
        Integer numValueOf = Integer.valueOf(R.color.text_hint_content_color);
        if (zBooleanValue && accountCenterNewInstance.email.get() != null && !"".equals(accountCenterNewInstance.email.get())) {
            this.f9654b.set(this.f9653a.getResources().getString(R.string.question_finish));
            this.f9655c.set(numValueOf);
        } else if (accountCenterNewInstance.isFinishSecretQuestion.get().booleanValue() || !("".equals(accountCenterNewInstance.email.get()) || accountCenterNewInstance.email.get() == null)) {
            this.f9654b.set(this.f9653a.getResources().getString(R.string.improve_secret));
            this.f9655c.set(numValueOf);
        } else {
            this.f9654b.set(this.f9653a.getResources().getString(R.string.question_unfinished));
            this.f9655c.set(Integer.valueOf(R.color.itemRechargePriceColor));
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onResume() {
        super.onResume();
        try {
            m();
            l();
        } catch (Exception unused) {
            ReportDataAdapter.onEvent(this.f9653a, EventConstant.ON_RESUME_EXCEPTION, "AccountSafeViewModel");
        }
    }
}
