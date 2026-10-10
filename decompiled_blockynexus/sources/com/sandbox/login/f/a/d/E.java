package com.sandbox.login.f.a.d;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;
import androidx.databinding.ObservableField;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.sandbox.login.R;
import com.sandbox.login.view.activity.login.LoginActivity;
import com.sandbox.login.view.dialog.ProtocolDialog;
import com.sandboxol.center.router.manager.DressManager;
import com.sandboxol.center.router.manager.NewSandboxReportManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.NewReportEventType;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.utils.IconUploadHelper;
import com.sandboxol.center.utils.NickNameRandomUtil;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.config.CommonMessageToken;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.greendao.entity.RegisterInfo;
import com.sandboxol.greendao.entity.User;
import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: MakeRoleViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class E extends ViewModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.sandbox.login.c.z f15805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Activity f15806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private s f15807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private User f15808f;
    private RegisterInfo g;
    private Subscription i;
    private ObjectAnimator j;
    private ObjectAnimator k;
    public ObservableField<Boolean> p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15803a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15804b = false;
    private boolean h = false;
    public ObservableField<Integer> l = new ObservableField<>(Integer.valueOf(R.mipmap.login_male_pic_0));
    public ObservableField<Integer> m = new ObservableField<>(Integer.valueOf(R.mipmap.login_male_pic_1));
    public ObservableField<Integer> n = new ObservableField<>(Integer.valueOf(R.mipmap.login_male_pic_2));
    public ObservableField<Integer> o = new ObservableField<>(Integer.valueOf(R.mipmap.login_male_pic_3));
    public ObservableField<Integer> q = new ObservableField<>(0);
    public ObservableField<Boolean> r = new ObservableField<>(true);
    public ObservableField<Boolean> s = new ObservableField<>(false);
    public ObservableField<Boolean> t = new ObservableField<>(false);
    public ObservableField<Boolean> u = new ObservableField<>(true);
    public ObservableField<Boolean> v = new ObservableField<>(false);
    public ReplyCommand w = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.d.h
        @Override // rx.functions.Action0
        public final void call() {
            this.f15819a.i();
        }
    });
    public ReplyCommand x = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.d.j
        @Override // rx.functions.Action0
        public final void call() {
            this.f15821a.j();
        }
    });
    public ReplyCommand y = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.d.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f15815a.p();
        }
    });
    public ReplyCommand z = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.d.l
        @Override // rx.functions.Action0
        public final void call() {
            this.f15823a.u();
        }
    });
    public ReplyCommand A = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.d.r
        @Override // rx.functions.Action0
        public final void call() {
            this.f15829a.D();
        }
    });
    public ReplyCommand B = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.d.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f15813a.E();
        }
    });
    public ReplyCommand C = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.d.g
        @Override // rx.functions.Action0
        public final void call() {
            this.f15818a.F();
        }
    });
    public ReplyCommand D = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.d.q
        @Override // rx.functions.Action0
        public final void call() {
            this.f15828a.G();
        }
    });
    public ReplyCommand E = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.d.p
        @Override // rx.functions.Action0
        public final void call() {
            this.f15827a.H();
        }
    });
    public ReplyCommand F = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.d.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f15816a.I();
        }
    });
    public ReplyCommand G = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.d.m
        @Override // rx.functions.Action0
        public final void call() {
            this.f15824a.k();
        }
    });
    public ReplyCommand H = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.d.n
        @Override // rx.functions.Action0
        public final void call() {
            this.f15825a.l();
        }
    });
    public ReplyCommand I = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.d.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f15814a.m();
        }
    });
    public ReplyCommand<String> J = new ReplyCommand<>(new Action1() { // from class: com.sandbox.login.f.a.d.i
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f15820a.a((String) obj);
        }
    });

    public E(Activity activity, com.sandbox.login.c.z zVar, s sVar, ObservableField<Boolean> observableField) {
        this.f15806d = activity;
        this.f15805c = zVar;
        this.f15807e = sVar;
        this.p = observableField;
        N();
        NewSandboxReportManager.onAppEvent(NewReportEventType.FUNNEL_NEW_APP_NUMBER, "new_loginpage_buildwin");
        SandboxReportManager.onEvent("new_loginpage_buildwin", ReportEventType.NEW_USER_BEHAVIOR, "app");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        UserApi.changeInfo(this.f15806d, this.f15808f, new B(this));
    }

    private void M() {
        this.j = ObjectAnimator.ofFloat(this.f15805c.u, "rotation", 180.0f);
        this.j.setDuration(500L);
        this.k = ObjectAnimator.ofFloat(this.f15805c.t, "rotation", WheelView.DividerConfig.FILL, -30.0f, WheelView.DividerConfig.FILL, 30.0f, WheelView.DividerConfig.FILL);
        this.k.setDuration(500L);
    }

    private void N() {
        this.g = new RegisterInfo();
        this.g.setSex(1);
        this.f15808f = new User();
        initView();
        M();
        initMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public void H() {
        c(4);
        if (this.p.get().booleanValue()) {
            this.f15805c.s.setImageBitmap(this.f15807e.j());
        }
        this.t.set(false);
        com.sandbox.login.e.d.b().b(this.f15806d, this.f15807e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public void i() {
        this.f15805c.r.setVisibility(8);
        this.s.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void F() {
        this.t.set(false);
        Intent intent = new Intent(this.f15806d, (Class<?>) LoginActivity.class);
        intent.putExtra("key.is.with.back.btn", true);
        intent.putExtra("key.is.with.register", false);
        this.f15806d.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public void G() {
        c(4);
        if (this.p.get().booleanValue()) {
            this.f15805c.s.setImageBitmap(this.f15807e.j());
        } else {
            this.t.set(false);
            com.sandbox.login.e.d.b().b(this.f15806d, this.f15807e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public void E() {
        this.s.set(Boolean.valueOf(!r0.get().booleanValue()));
        if (!this.s.get().booleanValue()) {
            this.f15805c.r.setVisibility(8);
            return;
        }
        if (this.f15803a == 4) {
            this.f15805c.r.setVisibility(0);
        } else if (this.p.get().booleanValue()) {
            this.f15805c.r.setVisibility(0);
        } else {
            this.f15805c.r.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public void D() {
        ObjectAnimator objectAnimator = this.k;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
        com.sandbox.login.c.z zVar = this.f15805c;
        if (zVar != null) {
            zVar.I.setText(NickNameRandomUtil.getNickName());
            TextInputEditText textInputEditText = this.f15805c.I;
            textInputEditText.setSelection(textInputEditText.getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public void u() {
        ObjectAnimator objectAnimator = this.j;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
        com.sandbox.login.c.z zVar = this.f15805c;
        if (zVar != null) {
            zVar.s.setImageDrawable(f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public void p() {
        if (!this.r.get().booleanValue()) {
            AppToastUtils.showLongPositiveTipToast(this.f15806d, R.string.login_agree_tips);
        } else {
            if (this.h) {
                return;
            }
            v.a(this.f15806d, this.f15807e, this.g, this.v, new z(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public void j() {
        new ProtocolDialog(this.f15806d).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        File fileI = this.f15807e.i();
        String strH = this.f15807e.h();
        if (this.f15807e.f15832c == null) {
            return;
        }
        IconUploadHelper.uploadIcon(this.f15806d, fileI, strH, new A(this));
    }

    private void initMessage() {
        Messenger.getDefault().register(this, CommonMessageToken.TOKEN_DECORATION_INIT_FINISH, new Action0() { // from class: com.sandbox.login.f.a.d.f
            @Override // rx.functions.Action0
            public final void call() {
                this.f15817a.h();
            }
        });
    }

    private void initView() {
        try {
            this.f15805c.s.setImageDrawable(f());
            String nickName = NickNameRandomUtil.getNickName();
            this.g.setNickName(nickName);
            this.f15805c.I.setText(nickName);
            this.f15805c.I.setSelection(this.f15805c.I.getText().length());
            this.f15805c.F.addOnTabSelectedListener((TabLayout.c) new w(this));
            this.f15805c.o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sandbox.login.f.a.d.k
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.f15822a.a(compoundButton, z);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void I() {
        c(0);
    }

    public /* synthetic */ void J() {
        if (this.f15804b) {
            new y(this, 500L, 1000L).start();
        }
    }

    public void K() {
        int i = this.f15803a;
        if (i == 4) {
            return;
        }
        if (i == -1) {
            c(0);
        } else {
            c(i);
        }
    }

    public /* synthetic */ void h() {
        new x(this, 500L, 1000L).start();
    }

    public /* synthetic */ void k() {
        c(1);
    }

    public /* synthetic */ void l() {
        c(2);
    }

    public /* synthetic */ void m() {
        c(3);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        ObjectAnimator objectAnimator = this.j;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.j = null;
        }
        ObjectAnimator objectAnimator2 = this.k;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
            this.k = null;
        }
        super.onDestroy();
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onPause() {
        super.onPause();
        DressManager.onPauseByGroupView(this.f15805c.q);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onResume() {
        super.onResume();
        DressManager.setShowUsingDress(false);
        DressManager.onResumeByViewGroup(this.f15805c.q, new Action0() { // from class: com.sandbox.login.f.a.d.o
            @Override // rx.functions.Action0
            public final void call() {
                this.f15826a.J();
            }
        });
        DressManager.changeBackground("decorate_blank_bg.png");
        DressManager.changeSex(this.g.getSex());
    }

    private void c(int i) {
        this.q.set(Integer.valueOf(i));
        if (i == 4) {
            return;
        }
        this.f15803a = i;
        try {
            this.f15805c.s.setImageDrawable(this.g.getSex() == 1 ? i != 1 ? i != 2 ? i != 3 ? androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.login_male_pic_0) : androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.login_male_pic_3) : androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.login_male_pic_2) : androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.login_male_pic_1) : i != 1 ? i != 2 ? i != 3 ? androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.login_female_pic_0) : androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.login_female_pic_3) : androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.login_female_pic_2) : androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.login_female_pic_1));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f15805c.G.setHelperTextColor(this.f15806d.getColorStateList(R.color.login_tips_color_1));
        }
        this.f15805c.G.setHelperText(str);
    }

    public Drawable f() {
        int iNextInt;
        if (this.f15803a == -1) {
            this.f15803a = new Random().nextInt(4);
        } else {
            do {
                iNextInt = new Random().nextInt(4);
            } while (iNextInt == this.f15803a);
            this.f15803a = iNextInt;
        }
        this.q.set(Integer.valueOf(this.f15803a));
        try {
            if (this.g.getSex() == 1) {
                int i = this.f15803a;
                return i != 1 ? i != 2 ? i != 3 ? androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.login_male_pic_0) : androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.login_male_pic_3) : androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.login_male_pic_2) : androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.login_male_pic_1);
            }
            int i2 = this.f15803a;
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.login_female_pic_0) : androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.login_female_pic_3) : androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.login_female_pic_2) : androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.login_female_pic_1);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        UserApi.checkNickNameTimely(this.f15806d, str, new C(this));
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        this.r.set(Boolean.valueOf(z));
    }

    public void b(int i) {
        this.f15803a = i;
    }

    public void a(boolean z) {
        this.u.set(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(String str) {
        this.g.setNickName(str);
        Subscription subscription = this.i;
        if (subscription != null) {
            subscription.unsubscribe();
            this.i = null;
        }
        this.i = Observable.timer(1000L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).onBackpressureDrop().subscribe(new D(this, str));
    }
}
