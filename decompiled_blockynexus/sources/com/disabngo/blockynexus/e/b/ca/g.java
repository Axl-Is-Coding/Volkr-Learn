package com.disabngo.blockynexus.e.b.ca;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.e.C0834f;
import com.disabngo.blockynexus.e.b.s.C0916e;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.EmailBindForm;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.TemplateNewUtils;
import rx.functions.Action0;

/* JADX INFO: compiled from: SafeSettingViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f9689b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f9691d = new ObservableField<>(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<String> f9692e = new ObservableField<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f9693f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ca.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f9682a.f();
        }
    });
    public ReplyCommand g = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ca.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9683a.h();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private EmailBindForm f9690c = new EmailBindForm();

    public g(Context context) {
        this.f9688a = context;
        this.f9689b = new d(context);
        this.f9690c.setEmail(AccountCenter.newInstance().email.get());
    }

    private void b(int i) {
        this.f9689b.a(this.f9688a, i, new e(this, i));
    }

    private void i() {
        if (this.f9690c.getEmail() == null || "".equals(this.f9690c.getEmail())) {
            if (AccountCenter.newInstance().email.get() == null || "".equals(AccountCenter.newInstance().email.get())) {
                AppToastUtils.showShortPositiveTipToast(this.f9688a, R.string.account_email_is_empty);
                return;
            }
            this.f9690c.setEmail(AccountCenter.newInstance().email.get());
        }
        this.f9689b.a(this.f9688a, this.f9690c.getEmail(), new f(this));
    }

    public /* synthetic */ void f() {
        if (AccountCenter.newInstance().isFinishSecretQuestion.get().booleanValue()) {
            Context context = this.f9688a;
            TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ga.e.class, context.getString(R.string.item_view_secret_question_unbind));
        } else {
            if ("".equals(AccountCenter.newInstance().email.get()) || AccountCenter.newInstance().email.get() == null) {
                b(0);
                return;
            }
            i();
            Context context2 = this.f9688a;
            TemplateNewUtils.startTemplate(context2, com.disabngo.blockynexus.e.b.ea.e.class, context2.getString(R.string.safety_verification));
            ReportDataAdapter.onEvent(this.f9688a, EventConstant.MORE_SECRET_EMAIL_VERIFY_CLICK);
        }
    }

    public /* synthetic */ void h() {
        if (!"".equals(AccountCenter.newInstance().email.get()) && AccountCenter.newInstance().email.get() != null) {
            Context context = this.f9688a;
            TemplateUtils.startTemplate(context, C0916e.class, context.getString(R.string.item_view_unbind_email));
        } else {
            if (AccountCenter.newInstance().isFinishSecretQuestion.get().booleanValue()) {
                b(1);
                return;
            }
            Context context2 = this.f9688a;
            TemplateUtils.startTemplate(context2, C0834f.class, context2.getString(R.string.item_view_bind_email));
            ReportDataAdapter.onEvent(this.f9688a, EventConstant.MORE_EMAIL_CLICK);
        }
    }
}
