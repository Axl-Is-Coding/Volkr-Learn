package com.sandboxol.decorate.view.fragment.dress;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.fragment.app.FragmentActivity;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.DressShopGuideConfig;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.router.manager.DressManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.center.router.moduleInfo.game.GameMessageToken;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.LoadingDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.utils.SizeUtil;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.a.f;
import com.sandboxol.decorate.c.AbstractC2597w;
import com.sandboxol.decorate.manager.a.c;
import com.sandboxol.decorate.manager.v;
import com.sandboxol.decorate.widget.DressMenuButton;
import com.sandboxol.decorate.widget.DressRadioGroup;
import com.sandboxol.messager.MessagerClient;
import com.trello.rxlifecycle.ActivityEvent;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: DressViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class va extends ViewModel {
    private com.sandboxol.decorate.view.activity.dress.K B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f17464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AbstractC2597w f17465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f17466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f17467d;
    private Map<String, List<DressShopGuideConfig>> g;
    private com.sandboxol.decorate.manager.a.c h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f17468e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f17469f = false;
    private DressMenuButton.MenuItem i = DressMenuButton.MenuItem.CLOTH;
    public ObservableField<Boolean> j = new ObservableField<>(true);
    public ObservableField<Boolean> k = new ObservableField<>(false);
    public ObservableField<Boolean> l = new ObservableField<>(false);
    public ObservableField<Boolean> m = new ObservableField<>(false);
    public ObservableField<DressRadioGroup.Tab> n = new ObservableField<>();
    public ObservableField<Integer> o = new ObservableField<>(0);
    public ObservableField<Boolean> p = new ObservableField<>(true);
    public ReplyCommand q = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.z
        @Override // rx.functions.Action0
        public final void call() {
            this.f17473a.J();
        }
    });
    public ReplyCommand r = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.V
        @Override // rx.functions.Action0
        public final void call() {
            this.f17401a.O();
        }
    });
    public ReplyCommand<Integer> s = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.decorate.view.fragment.dress.s
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f17457a.c(((Integer) obj).intValue());
        }
    });
    public ReplyCommand<DressRadioGroup.Tab> t = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.decorate.view.fragment.dress.y
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f17472a.a((DressRadioGroup.Tab) obj);
        }
    });
    public ReplyCommand<DressMenuButton.MenuItem> u = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.decorate.view.fragment.dress.O
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f17395a.a((DressMenuButton.MenuItem) obj);
        }
    });
    public ReplyCommand<Boolean> v = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.decorate.view.fragment.dress.I
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f17389a.a(((Boolean) obj).booleanValue());
        }
    });
    public ReplyCommand w = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.t
        @Override // rx.functions.Action0
        public final void call() {
            this.f17459a.showGuideDialog();
        }
    });
    public final ObservableList<ViewModel> x = new ObservableArrayList();
    public me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<ViewModel>> y = me.tatarka.bindingcollectionadapter2.g.a(new me.tatarka.bindingcollectionadapter2.l() { // from class: com.sandboxol.decorate.view.fragment.dress.H
        @Override // me.tatarka.bindingcollectionadapter2.l
        public final void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, Object obj) {
            this.f17388a.bindView(gVar, i, (ListItemViewModel) obj);
        }
    });
    private ObservableField<Boolean> z = new ObservableField<>(true);
    public ObservableField<Boolean> A = new ObservableField<>(false);
    public ObservableField<Long> C = new ObservableField<>(0L);
    public ObservableField<Long> D = new ObservableField<>(0L);
    public ReplyCommand E = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.u
        @Override // rx.functions.Action0
        public final void call() {
            this.f17461a.T();
        }
    });

    public va(FragmentActivity fragmentActivity, AbstractC2597w abstractC2597w, boolean z) {
        this.f17464a = fragmentActivity;
        this.f17465b = abstractC2597w;
        this.f17467d = z;
        if (z) {
            this.z.set(false);
            W();
            com.sandboxol.decorate.manager.g.b();
        }
        c.a aVar = new c.a();
        aVar.a(abstractC2597w);
        aVar.b(this.p);
        aVar.a(this.x);
        aVar.a(this.z);
        this.h = aVar.a();
        this.B = new com.sandboxol.decorate.view.activity.dress.K();
        b(0);
        initMessenger();
        R();
        Q();
        V();
    }

    static /* synthetic */ void K() {
    }

    static /* synthetic */ void N() {
        com.sandboxol.decorate.manager.g.b();
        com.sandboxol.decorate.manager.j.d().g();
    }

    private void P() {
        com.sandboxol.decorate.view.activity.dress.K k = this.B;
        if (k != null) {
            k.a(this.C, this.D);
        }
    }

    private void Q() {
        this.j.set(Boolean.valueOf(SharedUtils.getBoolean(this.f17464a, AccountCenter.newInstance().userId.get() + StringConstant.KEY_IS_SHOW_DRESS_GUIDE_RED_POINT, false)));
    }

    private void R() {
        if (!this.f17467d) {
            com.sandboxol.decorate.manager.q.a().f17201a = this.z;
        } else if (com.sandboxol.decorate.manager.q.a().f17201a != null) {
            com.sandboxol.decorate.manager.q.a().f17201a.set(false);
        } else {
            com.sandboxol.decorate.manager.q.a().f17201a = this.z;
        }
    }

    private void S() {
        Messenger.getDefault().register(this, GameMessageToken.TOKEN_SHOP_CHANGE_CLOTHES, String.class, new Action1() { // from class: com.sandboxol.decorate.view.fragment.dress.w
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f17470a.d((String) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_CLEAR_DRESS_SHOP_CAR, new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.W
            @Override // rx.functions.Action0
            public final void call() {
                this.f17402a.f();
            }
        });
        MessagerClient.getIns().registerMsg0(va.class, GameBroadcastType.BROADCAST_RRESH_MONEY, new com.sandboxol.messager.a.a() { // from class: com.sandboxol.decorate.view.fragment.dress.P
            @Override // com.sandboxol.messager.a.a
            public final void onCall() {
                this.f17396a.I();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        com.sandboxol.decorate.view.activity.dress.K k = this.B;
        if (k != null) {
            k.a(this.f17464a, com.sandboxol.decorate.manager.v.b().f17217f);
        }
    }

    private void U() {
        if (com.sandboxol.decorate.manager.s.c().h()) {
            return;
        }
        com.sandboxol.decorate.manager.s.c().i();
        this.f17465b.o.setLeftText(com.sandboxol.decorate.manager.s.c().d());
        this.f17465b.o.setRightText(com.sandboxol.decorate.manager.s.c().e());
        this.f17465b.o.resetData();
        com.sandboxol.decorate.manager.j.d().f();
        com.sandboxol.decorate.manager.j.d().j();
    }

    private void V() {
        if (this.z.get().booleanValue() || this.n.get() == DressRadioGroup.Tab.RECOMMEND) {
            this.A.set(false);
        } else {
            this.A.set(true);
        }
    }

    private void W() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f17465b.g, "translationX", WheelView.DividerConfig.FILL, -SizeUtil.dp2px(this.f17464a, 96.0f));
        objectAnimatorOfFloat.setDuration(150L);
        objectAnimatorOfFloat.start();
    }

    private void X() {
        if (this.z.get().booleanValue()) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f17465b.f17128e, "translationX", WheelView.DividerConfig.FILL, SizeUtil.dp2px(this.f17464a, 70.0f));
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f17465b.f17128e, "translationX", SizeUtil.dp2px(this.f17464a, 70.0f), WheelView.DividerConfig.FILL);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f17465b.g, "translationX", WheelView.DividerConfig.FILL, -SizeUtil.dp2px(this.f17464a, 96.0f));
            objectAnimatorOfFloat.addListener(new sa(this));
            objectAnimatorOfFloat.setDuration(150L);
            objectAnimatorOfFloat2.setDuration(150L);
            objectAnimatorOfFloat3.setDuration(300L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(objectAnimatorOfFloat3).with(objectAnimatorOfFloat).before(objectAnimatorOfFloat2);
            animatorSet.start();
            return;
        }
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.f17465b.f17128e, "translationX", WheelView.DividerConfig.FILL, SizeUtil.dp2px(this.f17464a, 70.0f));
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.f17465b.f17128e, "translationX", SizeUtil.dp2px(this.f17464a, 70.0f), WheelView.DividerConfig.FILL);
        objectAnimatorOfFloat4.addListener(new ta(this));
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.f17465b.g, "translationX", -SizeUtil.dp2px(this.f17464a, 96.0f), WheelView.DividerConfig.FILL);
        objectAnimatorOfFloat4.setDuration(150L);
        objectAnimatorOfFloat5.setDuration(150L);
        objectAnimatorOfFloat6.setDuration(300L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(objectAnimatorOfFloat6).with(objectAnimatorOfFloat4).before(objectAnimatorOfFloat5);
        animatorSet2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        this.f17469f = true;
        X();
        ObservableField<Boolean> observableField = this.z;
        observableField.set(Boolean.valueOf(true ^ observableField.get().booleanValue()));
        if (this.z.get().booleanValue()) {
            com.sandboxol.decorate.manager.j.c().f();
            com.sandboxol.decorate.manager.v.f();
        } else {
            if (com.sandboxol.decorate.manager.v.a().d()) {
                com.sandboxol.decorate.manager.v.a(this.f17464a, new v.a() { // from class: com.sandboxol.decorate.view.fragment.dress.C
                    @Override // com.sandboxol.decorate.manager.v.a
                    public final void a() {
                        va.N();
                    }
                });
            } else {
                com.sandboxol.decorate.manager.g.b();
                com.sandboxol.decorate.manager.j.d().g();
            }
            ReportDataAdapter.onEvent(this.f17464a, EventConstant.DRESS_SHOP);
            SandboxReportManager.onEvent(ReportEvent.NEW_DRESS_SHOP, ReportEventType.NEW_USER_BEHAVIOR, "app");
        }
        U();
        b(this.o.get().intValue());
        this.f17469f = false;
        V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindView(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<ViewModel> listItemViewModel) {
        if (this.z.get().booleanValue()) {
            if (this.i == DressMenuButton.MenuItem.CLOTH && i == 1) {
                gVar.a(com.sandboxol.decorate.c.A, R.layout.content_dress_suit_page);
                return;
            } else {
                gVar.a(com.sandboxol.decorate.c.r, R.layout.content_dress_page);
                return;
            }
        }
        if (this.i != DressMenuButton.MenuItem.CLOTH) {
            gVar.a(com.sandboxol.decorate.c.F, R.layout.content_dress_shop_page);
            return;
        }
        if (!this.p.get().booleanValue()) {
            if (i == 0) {
                gVar.a(com.sandboxol.decorate.c.u, R.layout.content_dress_shop_suit_page);
                return;
            } else {
                gVar.a(com.sandboxol.decorate.c.F, R.layout.content_dress_shop_page);
                return;
            }
        }
        if (i == 0) {
            gVar.a(com.sandboxol.decorate.c.z, R.layout.content_dress_shop_recommend_page);
        } else if (i == 1) {
            gVar.a(com.sandboxol.decorate.c.u, R.layout.content_dress_shop_suit_page);
        } else {
            gVar.a(com.sandboxol.decorate.c.F, R.layout.content_dress_shop_page);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        if (this.z.get().booleanValue()) {
            com.sandboxol.decorate.manager.j.c().a(DressRadioGroup.Tab.getTabByPosition(i, this.i, 2), MessageToken.TOKEN_REFRESH_DECORATION_TYPE);
            this.o.set(Integer.valueOf(i));
            this.n.set(DressRadioGroup.Tab.getTabByPosition(i, this.i, 2));
            com.sandboxol.decorate.manager.j.c().a(DressRadioGroup.Tab.getTabByPosition(i, this.i, 2));
        } else {
            DressRadioGroup.Tab tabByPosition = DressRadioGroup.Tab.getTabByPosition(i, this.i, 1);
            com.sandboxol.decorate.manager.j.d().a(tabByPosition, MessageToken.TOKEN_REFRESH_SHOP_LIST);
            this.o.set(Integer.valueOf(i));
            this.n.set(tabByPosition);
        }
        V();
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_DECORATION_LOADING_FINISH_TYPE, Integer.class, new Action1() { // from class: com.sandboxol.decorate.view.fragment.dress.M
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f17393a.a((Integer) obj);
            }
        });
        Messenger.getDefault().register(this, GameMessageToken.TOKEN_CHANGE_CLOTHES, String.class, new Action1() { // from class: com.sandboxol.decorate.view.fragment.dress.B
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f17377a.c((String) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_DECORATION_TYPE, new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.F
            @Override // rx.functions.Action0
            public final void call() {
                this.f17386a.p();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_SWITCH_TO_SHOP, new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.v
            @Override // rx.functions.Action0
            public final void call() {
                this.f17463a.Y();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_BUY_ACTION_FINISH, new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.A
            @Override // rx.functions.Action0
            public final void call() {
                this.f17376a.u();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_ROLLBACK_TO_DRESS, new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.x
            @Override // rx.functions.Action0
            public final void call() {
                this.f17471a.D();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_DRESS_OR_SHOP_LIST_DATA, new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.U
            @Override // rx.functions.Action0
            public final void call() {
                this.f17400a.E();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_SYNC_GUIDE_RED_POINT, new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.D
            @Override // rx.functions.Action0
            public final void call() {
                this.f17379a.F();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_TRANS_TO_DRESS, new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.N
            @Override // rx.functions.Action0
            public final void call() {
                this.f17394a.G();
            }
        });
        Messenger.getDefault().register(this, MessageToken.RE_LOGIN_CLOSE_SINGLE_SHOP, new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.L
            @Override // rx.functions.Action0
            public final void call() {
                this.f17392a.H();
            }
        });
        S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGuideDialog() {
        Map<String, List<DressShopGuideConfig>> map = this.g;
        if (map == null) {
            new LoadingDialog(this.f17464a).show();
            com.sandboxol.decorate.web.t.g(this.f17464a, new ua(this));
        } else {
            new com.sandboxol.decorate.view.dialog.d(this.f17464a, map).show();
        }
        this.j.set(true);
        if (this.f17467d) {
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_SYNC_GUIDE_RED_POINT);
        }
        SharedUtils.putBoolean(this.f17464a, AccountCenter.newInstance().userId.get() + StringConstant.KEY_IS_SHOW_DRESS_GUIDE_RED_POINT, true);
        ReportDataAdapter.onEvent(this.f17464a, EventConstant.DRESS_DETAIL_CLICK);
    }

    public /* synthetic */ void D() {
        if (this.z.get().booleanValue() && com.sandboxol.decorate.manager.v.a().d()) {
            com.sandboxol.decorate.manager.v.a(this.f17464a, new v.a() { // from class: com.sandboxol.decorate.view.fragment.dress.Q
                @Override // com.sandboxol.decorate.manager.v.a
                public final void a() {
                    va.K();
                }
            });
        }
    }

    public /* synthetic */ void E() {
        if (this.z.get().booleanValue()) {
            com.sandboxol.decorate.manager.j.c().i();
        } else {
            com.sandboxol.decorate.manager.j.d().k();
        }
    }

    public /* synthetic */ void F() {
        if (this.f17467d) {
            return;
        }
        this.j.set(true);
    }

    public /* synthetic */ void G() {
        if (this.z.get().booleanValue()) {
            return;
        }
        Y();
    }

    public /* synthetic */ void H() {
        if (this.f17467d) {
            Messenger.getDefault().unregister(this);
            Context context = this.f17464a;
            if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
                return;
            }
            ((Activity) this.f17464a).finish();
        }
    }

    public /* synthetic */ void I() {
        BillingManager.getInstance().updateUserMoney(this.f17464a);
    }

    public /* synthetic */ void J() {
        if (this.f17469f) {
            return;
        }
        Y();
    }

    public /* synthetic */ void L() {
        new qa(this, 300L, 1000L).start();
    }

    public /* synthetic */ void M() {
        new ra(this, 300L, 1000L).start();
    }

    public void O() {
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_OPEN_RECHARGE);
    }

    public /* synthetic */ void d(String str) {
        DressManager.clothTypes(str);
        P();
        if (this.f17468e) {
            a(false);
        }
    }

    public void f() {
        com.sandboxol.decorate.manager.v.b().f17217f.clear();
        this.C.set(0L);
        this.D.set(0L);
        com.sandboxol.decorate.manager.j.d().j();
    }

    public List<String> h() {
        return com.sandboxol.decorate.manager.s.c().f();
    }

    public String i() {
        return com.sandboxol.decorate.manager.s.c().d();
    }

    public f.a j() {
        return new f.a() { // from class: com.sandboxol.decorate.view.fragment.dress.S
            @Override // com.sandboxol.decorate.a.f.a
            public final void a(String str) {
                va.a(str);
            }
        };
    }

    public List<String> k() {
        return com.sandboxol.decorate.manager.s.c().a();
    }

    public String l() {
        return com.sandboxol.decorate.manager.s.c().e();
    }

    public f.a m() {
        return new f.a() { // from class: com.sandboxol.decorate.view.fragment.dress.T
            @Override // com.sandboxol.decorate.a.f.a
            public final void a(String str) {
                va.b(str);
            }
        };
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        Messenger.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onPause() {
        this.l.set(false);
        DressManager.onPauseByGroupView(this.f17465b.f17127d);
        this.f17466c = false;
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onResume() {
        if (this.z.get().booleanValue()) {
            DressManager.setShowUsingDress(true);
            DressManager.onResumeByViewGroup(this.f17465b.f17127d, new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.K
                @Override // rx.functions.Action0
                public final void call() {
                    this.f17391a.L();
                }
            });
        } else {
            if (com.sandboxol.decorate.manager.v.a().c()) {
                DressManager.setShowUsingDress(false);
            } else {
                DressManager.setShowUsingDress(true);
            }
            DressManager.onResumeByViewGroup(this.f17465b.f17127d, new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.J
                @Override // rx.functions.Action0
                public final void call() {
                    this.f17390a.M();
                }
            });
        }
        this.f17466c = true;
    }

    public /* synthetic */ void p() {
        if (this.f17466c) {
            Observable.just(true).delay(500L, TimeUnit.MILLISECONDS).compose(((com.trello.rxlifecycle.a) this.f17464a).bindUntilEvent(ActivityEvent.DESTROY)).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.sandboxol.decorate.view.fragment.dress.E
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    this.f17385a.b((Boolean) obj);
                }
            }, new Action1() { // from class: com.sandboxol.decorate.view.fragment.dress.X
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    ((Throwable) obj).printStackTrace();
                }
            });
        } else {
            Observable.just(true).delay(500L, TimeUnit.MILLISECONDS).compose(((com.trello.rxlifecycle.a) this.f17464a).bindUntilEvent(ActivityEvent.DESTROY)).subscribe(new Action1() { // from class: com.sandboxol.decorate.view.fragment.dress.G
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_DECORATION_TYPE);
                }
            }, new Action1() { // from class: com.sandboxol.decorate.view.fragment.dress.X
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    ((Throwable) obj).printStackTrace();
                }
            });
        }
    }

    public /* synthetic */ void u() {
        if (this.f17467d) {
            Messenger.getDefault().sendNoMsg("token.open.dress.fragment");
            Context context = this.f17464a;
            if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
                return;
            }
            ((Activity) this.f17464a).finish();
            return;
        }
        com.sandboxol.decorate.manager.v.a(this.f17464a);
        if (!this.z.get().booleanValue()) {
            Y();
        } else {
            com.sandboxol.decorate.manager.j.c().f();
            com.sandboxol.decorate.manager.j.c().h();
        }
    }

    private void b(DressMenuButton.MenuItem menuItem) {
        if (this.z.get().booleanValue()) {
            int i = menuItem.position;
            if (i == 0) {
                ReportDataAdapter.onEvent(this.f17464a, EventConstant.DRESS_ROOM_MENU);
                return;
            }
            if (i == 1) {
                ReportDataAdapter.onEvent(this.f17464a, EventConstant.DRESS_ROOM_CLOTH);
                return;
            } else if (i == 2) {
                ReportDataAdapter.onEvent(this.f17464a, EventConstant.DRESS_ROOM_DECORATION);
                return;
            } else {
                if (i != 3) {
                    return;
                }
                ReportDataAdapter.onEvent(this.f17464a, EventConstant.DRESS_ROOM_MOVEMENT);
                return;
            }
        }
        int i2 = menuItem.position;
        if (i2 == 0) {
            ReportDataAdapter.onEvent(this.f17464a, EventConstant.DRESS_SHOP_MENU);
            return;
        }
        if (i2 == 1) {
            ReportDataAdapter.onEvent(this.f17464a, EventConstant.DRESS_SHOP_CLOTH);
        } else if (i2 == 2) {
            ReportDataAdapter.onEvent(this.f17464a, EventConstant.DRESS_SHOP_DECORATION);
        } else {
            if (i2 != 3) {
                return;
            }
            ReportDataAdapter.onEvent(this.f17464a, EventConstant.DRESS_SHOP_MOVEMENT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DressRadioGroup.Tab tab) {
        if (this.z.get().booleanValue()) {
            com.sandboxol.decorate.manager.j.c().a(tab, MessageToken.TOKEN_REFRESH_DECORATION_TYPE);
            com.sandboxol.decorate.manager.j.c().a(tab);
        } else {
            com.sandboxol.decorate.manager.j.d().a(tab, MessageToken.TOKEN_REFRESH_SHOP_LIST);
            com.sandboxol.decorate.manager.j.d().a(tab);
        }
        this.o.set(Integer.valueOf(tab.position));
        this.n.set(tab);
        V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DressMenuButton.MenuItem menuItem) {
        if (menuItem != DressMenuButton.MenuItem.CLOSE) {
            com.sandboxol.decorate.manager.j.c().a(this.i);
            this.i = menuItem;
            if (this.z.get().booleanValue()) {
                com.sandboxol.decorate.manager.j.c().a(this.f17464a, this.h, menuItem);
                com.sandboxol.decorate.manager.j.c().b(menuItem);
                a(com.sandboxol.decorate.manager.j.c().a(menuItem, 2));
            } else {
                com.sandboxol.decorate.manager.j.c().a(this.f17464a, this.h, menuItem);
                a(com.sandboxol.decorate.manager.j.d().a(menuItem, 1));
            }
        }
        b(menuItem);
        V();
    }

    public /* synthetic */ void c(String str) {
        if (!this.z.get().booleanValue()) {
            P();
        }
        if (this.f17468e) {
            a(false);
        }
        DressManager.clothTypes(str);
        if (this.f17468e) {
            a(false);
        }
    }

    private void b(int i) {
        com.sandboxol.decorate.manager.j.c().a(this.f17464a, this.h, this.i);
        if (this.z.get().booleanValue()) {
            a(DressRadioGroup.Tab.getTabByPosition(i, this.i, 2));
        } else {
            a(DressRadioGroup.Tab.getTabByPosition(i, this.i, 1));
            com.sandboxol.decorate.manager.j.c().b(false);
        }
    }

    static /* synthetic */ void b(String str) {
        com.sandboxol.decorate.manager.s.c().a(str);
        com.sandboxol.decorate.manager.j.d().j();
    }

    public /* synthetic */ void b(Boolean bool) {
        if (!this.z.get().booleanValue()) {
            Y();
        }
        com.sandboxol.decorate.manager.v.a().a(false);
        com.sandboxol.decorate.manager.l.c().a();
        com.sandboxol.decorate.manager.j.c().h();
        DressManager.changeSex(AccountCenter.newInstance().sex.get().intValue());
        DressManager.getUsingList(this.f17464a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.f17468e = z;
        this.m.set(Boolean.valueOf(z));
        DressRadioGroup dressRadioGroup = this.f17465b.f17126c;
        dressRadioGroup.startAnimation(new com.sandboxol.decorate.b.a(dressRadioGroup, z ? com.sandboxol.decorate.b.a.f16974b : com.sandboxol.decorate.b.a.f16973a));
    }

    static /* synthetic */ void a(String str) {
        com.sandboxol.decorate.manager.s.c().b(str);
        com.sandboxol.decorate.manager.j.d().j();
    }

    public /* synthetic */ void a(Integer num) {
        if (num.intValue() == 1) {
            this.k.set(true);
        } else if (num.intValue() == 2) {
            this.k.set(false);
        }
    }
}
