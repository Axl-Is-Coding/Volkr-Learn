package com.sandboxol.halloween.view.activity;

import android.graphics.drawable.Drawable;
import androidx.databinding.ObservableField;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.F;
import androidx.fragment.app.Fragment;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.DressManager;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.config.CommonMessageToken;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.halloween.R;
import com.sandboxol.halloween.entity.HalloweenInfoResponse;
import com.sandboxol.halloween.entity.HalloweenReward;
import com.sandboxol.halloween.entity.HalloweenTask;
import com.sandboxol.halloween.view.activity.n;
import com.sandboxol.halloween.view.dialog.m;
import com.sandboxol.halloween.view.fragment.exchange.o;
import java.util.Iterator;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: HalloweenHomeViewModel.java */
/* JADX INFO: loaded from: classes4.dex */
public class l extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HalloweenHomeActivity f18660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.sandboxol.halloween.b.k f18661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Fragment f18662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private o f18663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.sandboxol.halloween.view.fragment.tasks.d f18664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f18665f = false;
    private boolean g = false;
    private int h = 0;
    private int i = 0;
    public ObservableField<Integer> j = new ObservableField<>(0);
    public ObservableField<Boolean> k = new ObservableField<>(false);
    public ObservableField<Boolean> l = new ObservableField<>(false);
    public ObservableField<Boolean> m = new ObservableField<>(false);
    public ObservableField<Integer> n = new ObservableField<>(Integer.valueOf(R.id.rb_exchange));
    public ObservableField<Boolean> o = new ObservableField<>(false);
    public ObservableField<Drawable> p = new ObservableField<>();
    public ObservableField<Drawable> q = new ObservableField<>();
    public ReplyCommand r = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.activity.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f18652a.m();
        }
    });
    public ReplyCommand s = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.activity.h
        @Override // rx.functions.Action0
        public final void call() {
            this.f18656a.u();
        }
    });
    public ReplyCommand t = new ReplyCommand(new g(this));
    public ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> u = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.halloween.view.activity.b
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f18650a.a((RadioGroupBindingAdapters.CheckedDataWrapper) obj);
        }
    });

    public l(HalloweenHomeActivity halloweenHomeActivity, com.sandboxol.halloween.b.k kVar) {
        this.f18660a = halloweenHomeActivity;
        this.f18661b = kVar;
        j();
        initData();
        initMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        n.a(this.f18660a, new n.a() { // from class: com.sandboxol.halloween.view.activity.f
            @Override // com.sandboxol.halloween.view.activity.n.a
            public final void a(HalloweenInfoResponse halloweenInfoResponse) {
                this.f18654a.a(halloweenInfoResponse);
            }
        });
    }

    private void c(int i) {
        if (this.g) {
            this.n.set(Integer.valueOf(i));
            if (i == R.id.rb_exchange) {
                j();
                a(this.f18663d);
                this.k.set(false);
                ReportDataAdapter.onEvent(this.f18660a, EventConstant.EXCHANGE_TIME);
                return;
            }
            if (i == R.id.rb_tasks) {
                k();
                a(this.f18664e);
                this.k.set(true);
                ReportDataAdapter.onEvent(this.f18660a, EventConstant.TASKS_TIME);
            }
        }
    }

    private boolean i() {
        return (com.sandboxol.halloween.c.b.b().a() == null || com.sandboxol.halloween.c.b.b().a().getRewardList() == null || com.sandboxol.halloween.c.b.b().a().getRewardList().size() <= 0) ? false : true;
    }

    private void initData() {
        if (com.sandboxol.halloween.c.b.b().a() != null) {
            l();
            c(this.n.get().intValue());
            this.j.set(Integer.valueOf(com.sandboxol.halloween.c.b.b().a().getCandy()));
            this.h = n.a(com.sandboxol.halloween.c.b.b().a().getSurplusTime());
            this.i = n.b(com.sandboxol.halloween.c.b.b().a().getSurplusTime());
            this.p.set(com.sandboxol.halloween.c.c.a(this.h));
            this.q.set(com.sandboxol.halloween.c.c.a(this.i));
            b(com.sandboxol.halloween.c.b.b().a());
        }
    }

    private void initMessage() {
        Messenger.getDefault().register(this, CommonMessageToken.TOKEN_DECORATION_INIT_FINISH, new Action0() { // from class: com.sandboxol.halloween.view.activity.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f18651a.f();
            }
        });
        Messenger.getDefault().register(this, "token.refresh.data", new Action0() { // from class: com.sandboxol.halloween.view.activity.e
            @Override // rx.functions.Action0
            public final void call() {
                this.f18653a.D();
            }
        });
        Messenger.getDefault().register(this, "token.open.exchange.candy", new g(this));
    }

    private void j() {
        this.f18661b.m.setTextColor(androidx.core.content.b.a(this.f18660a, R.color.halloween_tab_text_color_1));
        this.f18661b.n.setTextColor(androidx.core.content.b.a(this.f18660a, R.color.halloween_tab_text_color_2));
    }

    private void k() {
        this.f18661b.m.setTextColor(androidx.core.content.b.a(this.f18660a, R.color.halloween_tab_text_color_2));
        this.f18661b.n.setTextColor(androidx.core.content.b.a(this.f18660a, R.color.halloween_tab_text_color_1));
    }

    private void l() {
        AbstractC0336n supportFragmentManager = this.f18660a.getSupportFragmentManager();
        F fA = supportFragmentManager.a();
        if (this.f18663d == null) {
            this.f18663d = new o();
            this.f18663d.a(this.j);
            if (supportFragmentManager.a("exchangeFragment") == null) {
                fA.a(R.id.fl_fragment, this.f18663d, "exchangeFragment");
                fA.e(this.f18663d);
            }
        }
        if (this.f18664e == null) {
            this.f18664e = new com.sandboxol.halloween.view.fragment.tasks.d();
            if (supportFragmentManager.a("tasksFragment") == null) {
                fA.a(R.id.fl_fragment, this.f18664e, "tasksFragment");
                fA.c(this.f18664e);
            }
        }
        fA.b();
        this.g = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        HalloweenHomeActivity halloweenHomeActivity = this.f18660a;
        if (halloweenHomeActivity == null || halloweenHomeActivity.isFinishing()) {
            return;
        }
        this.f18660a.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (!i() || com.sandboxol.halloween.c.b.b().a().getCandyRate() == 0) {
            return;
        }
        new com.sandboxol.halloween.view.dialog.m(this.f18660a, com.sandboxol.halloween.c.b.b().a().getSurplusGCube() / com.sandboxol.halloween.c.b.b().a().getCandyRate(), com.sandboxol.halloween.c.b.b().a().getCandyRate(), new m.a() { // from class: com.sandboxol.halloween.view.activity.i
            @Override // com.sandboxol.halloween.view.dialog.m.a
            public final void a(int i) {
                this.f18657a.b(i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (i()) {
            new com.sandboxol.halloween.view.dialog.n(this.f18660a, com.sandboxol.halloween.c.b.b().a().getActivityDesc()).show();
        }
    }

    public /* synthetic */ void b(int i) {
        D();
    }

    public /* synthetic */ void f() {
        new k(this, 500L, 1000L).start();
    }

    public /* synthetic */ void h() {
        if (this.f18665f) {
            new j(this, 500L, 1000L).start();
        }
        Messenger.getDefault().sendNoMsg("token.begin.clothe");
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onPause() {
        super.onPause();
        DressManager.onPauseByGroupView(this.f18661b.h);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onResume() {
        super.onResume();
        DressManager.setShowUsingDress(false);
        DressManager.onResumeByViewGroup(this.f18661b.h, new Action0() { // from class: com.sandboxol.halloween.view.activity.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f18649a.h();
            }
        });
        DressManager.changeBackground("halloween_banner_top.png");
        DressManager.changeSex(AccountCenter.newInstance().sex.get().intValue());
    }

    private void b(HalloweenInfoResponse halloweenInfoResponse) {
        if (i()) {
            this.l.set(false);
            this.m.set(false);
            Iterator<HalloweenReward> it = halloweenInfoResponse.getRewardList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                HalloweenReward next = it.next();
                if (next != null && next.getCandy() <= this.j.get().intValue()) {
                    this.l.set(true);
                    break;
                }
            }
            for (HalloweenTask halloweenTask : halloweenInfoResponse.getTaskList()) {
                if (halloweenTask != null && halloweenTask.getStatus() == 1) {
                    this.m.set(true);
                    return;
                }
            }
        }
    }

    public /* synthetic */ void a(RadioGroupBindingAdapters.CheckedDataWrapper checkedDataWrapper) {
        c(checkedDataWrapper.getCheckedId());
    }

    private void a(Fragment fragment) {
        F fA = this.f18660a.getSupportFragmentManager().a();
        fA.a(0);
        Fragment fragment2 = this.f18662c;
        if (fragment2 != null) {
            fA.c(fragment2);
        }
        fA.e(fragment);
        fA.b();
        this.f18662c = fragment;
    }

    public /* synthetic */ void a(HalloweenInfoResponse halloweenInfoResponse) {
        com.sandboxol.halloween.c.b.b().a(halloweenInfoResponse);
        this.j.set(Integer.valueOf(halloweenInfoResponse.getCandy()));
        b(halloweenInfoResponse);
        Messenger.getDefault().sendNoMsg("token.refresh.status");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.task.list");
        int iA = n.a(halloweenInfoResponse.getSurplusTime());
        int iB = n.b(halloweenInfoResponse.getSurplusTime());
        if (iA != this.h) {
            this.h = iA;
            this.p.set(com.sandboxol.halloween.c.c.a(this.h));
        }
        if (iB != this.i) {
            this.i = iB;
            this.q.set(com.sandboxol.halloween.c.c.a(this.i));
        }
    }
}
