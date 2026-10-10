package com.sandbox.login.view.activity.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandbox.login.R;
import com.sandbox.login.c.AbstractC2441i;
import com.sandbox.login.entity.UserRecord;
import com.sandbox.login.view.fragment.register.RegisterActivity;
import com.sandbox.login.view.widget.account.AccountSelectWindow;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.LoginRegisterAccountForm;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: LoginViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class D extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f15924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AbstractC2441i f15925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LoginRegisterAccountForm f15926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f15927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, UserRecord> f15928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f15929f = false;
    public ObservableField<Boolean> g = new ObservableField<>(false);
    public ObservableField<Boolean> h = new ObservableField<>(false);
    public ObservableField<Boolean> i = new ObservableField<>(false);
    public ObservableField<Boolean> j = new ObservableField<>(false);
    public ObservableField<String> k = new ObservableField<>("");
    public ObservableField<String> l = new ObservableField<>("");
    public ObservableField<Drawable> m = new ObservableField<>();
    public ObservableField<Boolean> n = new ObservableField<>(false);
    public ReplyCommand o = new ReplyCommand(new Action0() { // from class: com.sandbox.login.view.activity.login.m
        @Override // rx.functions.Action0
        public final void call() {
            this.f15943a.l();
        }
    });
    public ReplyCommand p = new ReplyCommand(new Action0() { // from class: com.sandbox.login.view.activity.login.r
        @Override // rx.functions.Action0
        public final void call() {
            this.f15948a.k();
        }
    });
    public ReplyCommand q = new ReplyCommand(new Action0() { // from class: com.sandbox.login.view.activity.login.g
        @Override // rx.functions.Action0
        public final void call() {
            this.f15937a.u();
        }
    });
    public ReplyCommand r = new ReplyCommand(new Action0() { // from class: com.sandbox.login.view.activity.login.h
        @Override // rx.functions.Action0
        public final void call() {
            this.f15938a.G();
        }
    });
    public ReplyCommand s = new ReplyCommand(new Action0() { // from class: com.sandbox.login.view.activity.login.i
        @Override // rx.functions.Action0
        public final void call() {
            this.f15939a.D();
        }
    });
    public ReplyCommand t = new ReplyCommand(new Action0() { // from class: com.sandbox.login.view.activity.login.q
        @Override // rx.functions.Action0
        public final void call() {
            this.f15947a.onBack();
        }
    });
    public ReplyCommand u = new ReplyCommand(new Action0() { // from class: com.sandbox.login.view.activity.login.n
        @Override // rx.functions.Action0
        public final void call() {
            this.f15944a.F();
        }
    });
    public ReplyCommand v = new ReplyCommand(new Action0() { // from class: com.sandbox.login.view.activity.login.o
        @Override // rx.functions.Action0
        public final void call() {
            this.f15945a.p();
        }
    });
    public ReplyCommand<String> w = new ReplyCommand<>(new Action1() { // from class: com.sandbox.login.view.activity.login.p
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f15946a.c((String) obj);
        }
    });
    public ReplyCommand<String> x = new ReplyCommand<>(new Action1() { // from class: com.sandbox.login.view.activity.login.e
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f15935a.d((String) obj);
        }
    });

    public D(Activity activity, boolean z, AbstractC2441i abstractC2441i, boolean z2, boolean z3) {
        this.f15924a = activity;
        this.h.set(Boolean.valueOf(z));
        this.f15925b = abstractC2441i;
        this.i.set(Boolean.valueOf(z2));
        this.f15927d = z3;
        this.f15926c = new LoginRegisterAccountForm();
        this.f15928e = new HashMap();
        m();
        initMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_LOGIN_BY_GPLUS);
        ReportDataAdapter.onEvent(this.f15924a, EventConstant.THIRD_GOOGLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        this.m.set(this.f15924a.getResources().getDrawable(R.mipmap.login_ic_head_default));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        Activity activity = this.f15924a;
        activity.startActivity(new Intent(activity, (Class<?>) RegisterActivity.class));
        SandboxReportManager.onEvent(ReportEvent.NEW_LOGIN_PAGE_REG, ReportEventType.NEW_USER_BEHAVIOR, "app");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_LOGIN_BY_TWITTER);
        ReportDataAdapter.onEvent(this.f15924a, EventConstant.THIRD_TWITTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.f15925b.j.setEndIconMode(0);
        this.f15925b.f15654f.setText("");
        this.f15925b.j.setHelperText("");
        this.f15925b.f15653e.requestFocus();
        this.n.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        if (this.n.get().booleanValue()) {
            this.n.set(false);
            this.f15925b.j.setEndIconMode(1);
            this.f15925b.f15654f.setText("");
        }
    }

    private void initMessage() {
        Messenger.getDefault().register(this, "token.close.login", new Action0() { // from class: com.sandbox.login.view.activity.login.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f15933a.f();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_LOGIN_SUCCESS, new Action0() { // from class: com.sandbox.login.view.activity.login.j
            @Override // rx.functions.Action0
            public final void call() {
                this.f15940a.h();
            }
        });
        Messenger.getDefault().register(this, "token.delete.account", String.class, new Action1() { // from class: com.sandbox.login.view.activity.login.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f15934a.a((String) obj);
            }
        });
        Messenger.getDefault().register(this, "token.close.back.arrow", new Action0() { // from class: com.sandbox.login.view.activity.login.f
            @Override // rx.functions.Action0
            public final void call() {
                this.f15936a.i();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Messenger.getDefault().send(this.f15926c.getUid() == null ? "" : this.f15926c.getUid(), MessageToken.TOKEN_GO_TO_FORGET_FRAGMENT);
        ReportDataAdapter.onEvent(this.f15924a, EventConstant.ENTER_CLICK_EMAIL_QUESTION_RE);
    }

    private void m() {
        if (!AccountCenter.newInstance().login.get().booleanValue()) {
            ReportDataAdapter.onEvent(this.f15924a, EventConstant.LOGIN_DIALOG_NEED_LOGIN);
        }
        this.m.set(this.f15924a.getResources().getDrawable(R.mipmap.login_ic_head_default));
        com.sandbox.login.a.b.a().a(new Action1() { // from class: com.sandbox.login.view.activity.login.l
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f15942a.a((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBack() {
        Activity activity = this.f15924a;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.f15924a.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (com.sandbox.login.a.b.a().b() == null || com.sandbox.login.a.b.a().b().size() == 0) {
            this.j.set(false);
        } else {
            this.j.set(true);
            new AccountSelectWindow(this.f15924a, this, new Action0() { // from class: com.sandbox.login.view.activity.login.k
                @Override // rx.functions.Action0
                public final void call() {
                    this.f15941a.j();
                }
            }).showAsDropDown(this.f15925b.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_LOGIN_BY_FACEBOOK);
        ReportDataAdapter.onEvent(this.f15924a, EventConstant.THIRD_FACEBOOK);
    }

    public /* synthetic */ void h() {
        Activity activity = this.f15924a;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.f15924a.finish();
    }

    public /* synthetic */ void i() {
        this.h.set(false);
        ((LoginActivity) this.f15924a).a(false);
    }

    public /* synthetic */ void j() {
        this.j.set(false);
    }

    public void k() {
        a(this.f15924a, this.f15926c);
        ReportDataAdapter.onEvent(this.f15924a, EventConstant.ENTER_LOGIN);
        SandboxReportManager.onEvent(ReportEvent.NEW_CLICK_LOGIN, ReportEventType.NEW_USER_BEHAVIOR, "app");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        this.f15926c.setUid(str);
        y.a(this.f15924a, this.f15926c, this.f15928e, new B(this, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        this.f15929f = TextUtils.equals(this.f15926c.getPassword(), str);
        this.f15926c.setPassword(str);
        y.a(this.f15924a, this.f15926c, this.f15928e, new C(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        UserRecord userRecord = this.f15928e.get(str);
        if (userRecord != null) {
            a(userRecord);
        }
    }

    public /* synthetic */ void f() {
        Activity activity = this.f15924a;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.f15924a.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        return this.f15928e.containsKey(str);
    }

    public /* synthetic */ void a(List list) {
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                UserRecord userRecord = (UserRecord) it.next();
                this.f15928e.put(userRecord.getUid(), userRecord);
            }
            if (this.f15927d) {
                UserRecord userRecord2 = (UserRecord) list.get(0);
                this.k.set(userRecord2.getUid());
                this.f15926c.setUid(userRecord2.getUid());
                this.l.set(userRecord2.getPassword());
                this.f15926c.setPassword(userRecord2.getPassword());
                this.f15926c.setHasPassword(userRecord2.isHasPassword());
                com.sandbox.login.e.h.a(this.f15924a, userRecord2.getUserIcon(), this.m);
                if (TextUtils.isEmpty(userRecord2.getUid())) {
                    return;
                }
                this.f15925b.f15654f.requestFocus();
                this.f15925b.f15654f.setSelection(userRecord2.getPassword() != null ? userRecord2.getPassword().length() : 0);
            }
        }
    }

    public void a(UserRecord userRecord) {
        this.k.set("");
        this.l.set("");
        this.k.set(userRecord.getUid());
        this.l.set(userRecord.getPassword());
        com.sandbox.login.e.h.a(this.f15924a, userRecord.getUserIcon(), this.m);
        this.f15926c.setUid(userRecord.getUid());
        this.f15926c.setPassword(userRecord.getPassword());
        this.f15926c.setHasPassword(userRecord.isHasPassword());
        this.f15929f = true;
    }

    public void a(Context context, LoginRegisterAccountForm loginRegisterAccountForm) {
        this.g.set(true);
        if (this.n.get().booleanValue()) {
            com.sandbox.login.web.b.c(context, new z(this, context, loginRegisterAccountForm));
        } else {
            new y().a(context, loginRegisterAccountForm, new A(this, context, loginRegisterAccountForm));
        }
    }

    public /* synthetic */ void a(String str) {
        if (this.k.get().equals(str)) {
            this.k.set("");
            this.l.set("");
            this.f15925b.h.setHelperText("");
            this.f15925b.j.setHelperText("");
            this.m.set(this.f15924a.getResources().getDrawable(R.mipmap.login_ic_head_default));
        }
        UserRecord userRecord = new UserRecord();
        userRecord.setID(-1L);
        Messenger.getDefault().send(userRecord, "token.click.account.item");
    }
}
