package com.disabngo.blockynexus.view.activity.friends;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0628k;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.entity.StatusBean;
import com.disabngo.blockynexus.view.dialog.BottomDialog;
import com.disabngo.blockynexus.view.fragment.main.Q;
import com.disabngo.blockynexus.web.FriendApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.DressManager;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.greendao.entity.UserGameCareerInfo;
import com.sandboxol.messager.MessagerClient;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: FriendInfoViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class M extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f10653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AbstractC0628k f10654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public I f10655c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10658f;
    private FriendActivityIntentInfo g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.disabngo.blockynexus.e.b.X.a f10656d = new com.disabngo.blockynexus.e.b.X.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private F f10657e = new F();
    public Stack<FriendActivityIntentInfo> h = new Stack<>();
    public ObservableField<Friend> i = new ObservableField<>();
    public ObservableField<String> j = new ObservableField<>("");
    public ObservableField<String> k = new ObservableField<>("");
    public ObservableField<Boolean> l = new ObservableField<>(true);
    public ObservableField<Boolean> m = new ObservableField<>(false);
    public ObservableField<Boolean> n = new ObservableField<>(false);
    public ObservableField<Boolean> o = new ObservableField<>(false);
    public ObservableField<StatusBean> p = new ObservableField<>();
    public ObservableField<Boolean> q = new ObservableField<>(false);
    public ObservableField<Long> r = new ObservableField<>(0L);
    private ObservableMap<Long, String> s = new ObservableArrayMap();
    public ObservableMap<Long, String> t = new ObservableArrayMap();
    public ReplyCommand u = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.friends.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f10666a.onBack();
        }
    });
    public ReplyCommand v = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.friends.s
        @Override // rx.functions.Action0
        public final void call() {
            this.f10684a.G();
        }
    });
    public ReplyCommand w = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.friends.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f10670a.u();
        }
    });
    public ReplyCommand x = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.friends.o
        @Override // rx.functions.Action0
        public final void call() {
            this.f10680a.H();
        }
    });
    public ReplyCommand y = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.friends.m
        @Override // rx.functions.Action0
        public final void call() {
            this.f10678a.D();
        }
    });
    public ObservableField<Integer> z = new ObservableField<>(Integer.valueOf(R.id.rbMonth));
    public ObservableField<Integer> A = new ObservableField<>(0);
    public ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> B = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.view.activity.friends.u
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f10686a.a((RadioGroupBindingAdapters.CheckedDataWrapper) obj);
        }
    });
    public ObservableList<N> C = new ObservableArrayList();
    public me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<N>> D = me.tatarka.bindingcollectionadapter2.g.a(new me.tatarka.bindingcollectionadapter2.l() { // from class: com.disabngo.blockynexus.view.activity.friends.n
        @Override // me.tatarka.bindingcollectionadapter2.l
        public final void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, Object obj) {
            this.f10679a.bindView(gVar, i, (ListItemViewModel) obj);
        }
    });
    public ReplyCommand<Integer> E = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.view.activity.friends.r
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f10683a.b(((Integer) obj).intValue());
        }
    });

    public M(Activity activity, AbstractC0628k abstractC0628k, FriendActivityIntentInfo friendActivityIntentInfo, Friend friend, int i) {
        this.f10653a = activity;
        this.f10654b = abstractC0628k;
        this.g = friendActivityIntentInfo;
        this.i.set(friend);
        this.f10658f = i;
        this.f10655c = new I(activity, R.string.dress_me_no_dress, this.s, this.t, this.r);
        if (friendActivityIntentInfo != null) {
            this.h.push(friendActivityIntentInfo);
            this.r.set(Long.valueOf(friendActivityIntentInfo.getFriendId()));
            com.disabngo.blockynexus.d.K.a(this.s);
            initMessenger();
            K();
            new P().a(activity, this.r, this.o, friendActivityIntentInfo.getType(), this.k, this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        ObservableField<Long> observableField;
        if (this.p.get() != null && (observableField = this.r) != null && observableField.get().longValue() != 0) {
            Q.a((Context) this.f10653a, this.r.get().longValue(), this.p.get(), false);
        }
        com.disabngo.blockynexus.d.n.h(this.f10653a);
    }

    private void E() {
        if (this.i.get() == null) {
            this.i.set(new Friend());
            return;
        }
        if (TextUtils.isEmpty(this.i.get().getDetails())) {
            Friend friend = this.i.get();
            Activity activity = this.f10653a;
            friend.setDetails(activity.getString(R.string.more_fragment_details, new Object[]{activity.getString(R.string.more_fragment_no_details)}));
        } else {
            this.i.get().setDetails(this.f10653a.getString(R.string.more_fragment_details, new Object[]{this.i.get().getDetails()}));
        }
        I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        com.sandboxol.decorate.web.t.b(this.f10653a, this.g.getFriendId(), new L(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        if (AccountCenter.newInstance().userId.get().longValue() == this.i.get().getUserId()) {
            Activity activity = this.f10653a;
            TemplateUtils.startTemplate(activity, com.disabngo.blockynexus.view.fragment.updateuserinfo.i.class, activity.getString(R.string.item_view_personal_details));
            ReportDataAdapter.onEvent(this.f10653a, EventConstant.MORE_PERSINFO_SET);
        } else if (this.i.get().isFriend()) {
            new BottomDialog(this.f10653a).a(this.f10653a.getString(R.string.add_friend_alias), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.view.activity.friends.q
                @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
                public final void onClick(BottomDialog bottomDialog) {
                    this.f10682a.c(bottomDialog);
                }
            }).a(this.f10653a.getString(R.string.delete_friend), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.view.activity.friends.k
                @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
                public final void onClick(BottomDialog bottomDialog) {
                    this.f10676a.d(bottomDialog);
                }
            }).a(this.f10653a.getString(R.string.item_add_blacklist), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.view.activity.friends.p
                @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
                public final void onClick(BottomDialog bottomDialog) {
                    this.f10681a.e(bottomDialog);
                }
            }).a(this.f10653a.getString(R.string.report), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.view.activity.friends.i
                @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
                public final void onClick(BottomDialog bottomDialog) {
                    this.f10674a.f(bottomDialog);
                }
            }).a(this.f10653a.getString(R.string.cancel), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.view.activity.friends.w
                @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
                public final void onClick(BottomDialog bottomDialog) {
                    bottomDialog.cancel();
                }
            }).show();
        } else {
            new BottomDialog(this.f10653a).a(this.f10653a.getString(R.string.report), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.view.activity.friends.c
                @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
                public final void onClick(BottomDialog bottomDialog) {
                    this.f10668a.a(bottomDialog);
                }
            }).a(this.f10653a.getString(R.string.item_add_blacklist), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.view.activity.friends.b
                @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
                public final void onClick(BottomDialog bottomDialog) {
                    this.f10667a.b(bottomDialog);
                }
            }).a(this.f10653a.getString(R.string.cancel), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.view.activity.friends.w
                @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
                public final void onClick(BottomDialog bottomDialog) {
                    bottomDialog.cancel();
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        int type = this.g.getType();
        if (type != 0) {
            if (type == 1) {
                this.f10657e.c(this.f10653a, this.g.getFriendId());
                return;
            } else if (type == 2) {
                this.f10657e.a(this.f10653a, this.g, this.f10658f);
                m();
                return;
            } else if (type != 3) {
                return;
            }
        }
        this.f10657e.a(this.f10653a, this.g, this.i.get());
    }

    private void I() {
        this.n.set(Boolean.valueOf(this.i.get().getUserId() == AccountCenter.newInstance().userId.get().longValue() && !AccountCenter.newInstance().isPerfectUserInfo()));
    }

    private void J() {
        this.C.clear();
        if (this.i.get().getUserGameDataResponse() == null) {
            this.C.add(new N(this.f10653a, 0, new UserGameCareerInfo()));
            this.C.add(new N(this.f10653a, 1, new UserGameCareerInfo()));
        } else {
            UserGameCareerInfo userGameMonthInfo = this.i.get().getUserGameDataResponse().getUserGameMonthInfo();
            UserGameCareerInfo userGameCareerInfo = this.i.get().getUserGameDataResponse().getUserGameCareerInfo();
            this.C.add(new N(this.f10653a, 0, userGameMonthInfo));
            this.C.add(new N(this.f10653a, 1, userGameCareerInfo));
            if ((userGameMonthInfo == null && userGameCareerInfo != null && userGameCareerInfo.getTotalTime() > 0) || (userGameMonthInfo != null && userGameMonthInfo.getTotalTime() == 0 && userGameCareerInfo != null && userGameCareerInfo.getTotalTime() > 0)) {
                this.A.set(null);
                this.z.set(null);
                this.A.set(1);
                this.z.set(Integer.valueOf(R.id.rbWhole));
            }
        }
        int type = this.g.getType();
        if (type != 0) {
            if (type == 1) {
                this.m.set(true);
                this.j.set(this.f10653a.getString(R.string.pass_friend_verify));
                return;
            } else if (type == 2) {
                this.m.set(true);
                this.j.set(this.f10653a.getString(R.string.add_friend));
                return;
            } else if (type != 3) {
                return;
            }
        }
        this.m.set(true);
        this.j.set(this.f10653a.getString(R.string.send_message));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        E();
        J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindView(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<N> listItemViewModel) {
        gVar.a(482, R.layout.item_friend_match_career);
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_TRIBE_SEARCH, new Action0() { // from class: com.disabngo.blockynexus.view.activity.friends.l
            @Override // rx.functions.Action0
            public final void call() {
                this.f10677a.f();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_FRIEND_NO_DECORATION, new Action0() { // from class: com.disabngo.blockynexus.view.activity.friends.t
            @Override // rx.functions.Action0
            public final void call() {
                this.f10685a.h();
            }
        });
    }

    private void m() {
        int i = this.f10658f;
        if (i == 4) {
            ReportDataAdapter.onEvent(this.f10653a, EventConstant.CLICK_ADD_FRIEND, "Friend Detail Page");
            return;
        }
        if (i == 5) {
            ReportDataAdapter.onEvent(this.f10653a, EventConstant.ADD_FILTER_FRI, "Friend Detail Page");
        } else if (i != 6) {
            ReportDataAdapter.onEvent(this.f10653a, EventConstant.USERINFO_ADDFRI);
        } else {
            ReportDataAdapter.onEvent(this.f10653a, EventConstant.CHAT_SEARCH_ADD_FRIEND, "Friend Detail Page");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        DressManager.changeSex(this.i.get().getSex());
        DressManager.useClothes(this.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.i.get().getClanId() == 0) {
            return;
        }
        if (this.f10658f == 1) {
            onBack();
            return;
        }
        if (this.h.size() > 1) {
            onBack();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("tribe.clan.id", this.i.get().getClanId());
        bundle.putInt(StringConstant.FROM_PAGE, 3);
        Activity activity = this.f10653a;
        TemplateUtils.startTemplate(activity, com.disabngo.blockynexus.e.b.ma.e.class, activity.getString(R.string.tribe_detail), bundle);
    }

    public /* synthetic */ void h() {
        this.l.set(false);
    }

    public /* synthetic */ void i() {
        this.f10657e.a(this.f10653a, this.g.getFriendId());
    }

    public /* synthetic */ void j() {
        this.f10657e.b(this.f10653a, this.g.getFriendId());
    }

    public /* synthetic */ void k() {
        this.f10657e.a(this.f10653a, this.g.getFriendId());
    }

    public /* synthetic */ void l() {
        a(this.g.getFriendId());
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b(StringConstant.KEY_MAIN_LOCK, false);
        MessagerClient.getIns().sendMsg1(MessageToken.TOKEN_MAIN_CLICK_CLOCK, fVar);
    }

    public void onBack() {
        if (this.h.size() == 1) {
            if (this.f10653a.isFinishing()) {
                return;
            }
            this.f10653a.finish();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("tribe.clan.id", this.i.get().getClanId());
        bundle.putInt(StringConstant.FROM_PAGE, 3);
        Activity activity = this.f10653a;
        TemplateUtils.startTemplate(activity, com.disabngo.blockynexus.e.b.ma.e.class, activity.getString(R.string.tribe_detail), bundle);
        this.f10653a.overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        Observable.timer(400L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.disabngo.blockynexus.view.activity.friends.j
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10675a.a((Long) obj);
            }
        });
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        this.h.clear();
        Messenger.getDefault().unregister(this);
        Log.e("FriendInfoViewModel", "onDestroy ==============================");
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onPause() {
        super.onPause();
        this.q.set(false);
        DressManager.onPauseByGroupView(this.f10654b.f8502a);
        Log.e("FriendInfoViewModel", "onPause ==============================");
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onResume() {
        super.onResume();
        DressManager.setShowUsingDress(false);
        DressManager.onResumeByViewGroup(this.f10654b.f8502a, new Action0() { // from class: com.disabngo.blockynexus.view.activity.friends.g
            @Override // rx.functions.Action0
            public final void call() {
                this.f10672a.l();
            }
        });
    }

    public /* synthetic */ void a(RadioGroupBindingAdapters.CheckedDataWrapper checkedDataWrapper) {
        int checkedId = checkedDataWrapper.getCheckedId();
        if (checkedId == R.id.rbMonth) {
            this.A.set(0);
        } else {
            if (checkedId != R.id.rbWhole) {
                return;
            }
            this.A.set(1);
        }
    }

    public /* synthetic */ void b(BottomDialog bottomDialog) {
        new TwoButtonDialog(this.f10653a).setDetailText(R.string.item_add_blacklist).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.view.activity.friends.f
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f10671a.i();
            }
        }).show();
        bottomDialog.cancel();
    }

    public /* synthetic */ void c(BottomDialog bottomDialog) {
        this.f10657e.a((Context) this.f10653a, this.g, this.i.get());
        bottomDialog.cancel();
    }

    public /* synthetic */ void d(BottomDialog bottomDialog) {
        new TwoButtonDialog(this.f10653a).setDetailText(R.string.friend_delete_detail).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.view.activity.friends.d
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f10669a.j();
            }
        }).show();
        bottomDialog.cancel();
    }

    public /* synthetic */ void e(BottomDialog bottomDialog) {
        new TwoButtonDialog(this.f10653a).setDetailText(R.string.friend_add_blacklist_detail).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.view.activity.friends.h
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f10673a.k();
            }
        }).show();
        bottomDialog.cancel();
    }

    public /* synthetic */ void f() {
        this.l.set(false);
    }

    public /* synthetic */ void f(BottomDialog bottomDialog) {
        Bundle bundle = new Bundle();
        bundle.putLong(StringConstant.REPORT_USER_ID, this.i.get().getUserId());
        Activity activity = this.f10653a;
        TemplateUtils.startTemplate(activity, com.disabngo.blockynexus.e.b.Z.e.class, activity.getString(R.string.report), bundle);
        bottomDialog.cancel();
    }

    public void a(Activity activity, int i, FriendActivityIntentInfo friendActivityIntentInfo, Friend friend) {
        this.f10653a = activity;
        this.g = friendActivityIntentInfo;
        this.i.set(friend);
        this.f10658f = i;
        this.f10655c = new I(activity, R.string.dress_me_no_dress, this.s, this.t, this.r);
        if (friendActivityIntentInfo != null) {
            this.r.set(Long.valueOf(friendActivityIntentInfo.getFriendId()));
            com.disabngo.blockynexus.d.K.a(this.s);
            K();
            Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_FRIEND_DETAIL_LIST);
            a(friendActivityIntentInfo.getFriendId());
            new P().a(activity, this.r, this.o, friendActivityIntentInfo.getType(), this.k, this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (i == 0) {
            this.z.set(Integer.valueOf(R.id.rbMonth));
        } else {
            if (i != 1) {
                return;
            }
            this.z.set(Integer.valueOf(R.id.rbWhole));
        }
    }

    private void a(long j) {
        FriendApi.friendDetails(this.f10653a, j, new K(this));
    }

    public /* synthetic */ void a(Long l) {
        if (!this.h.empty()) {
            this.h.pop();
        }
        if (this.h.empty()) {
            return;
        }
        a(this.f10653a, this.f10658f, this.h.peek(), (Friend) null);
    }

    public /* synthetic */ void a(BottomDialog bottomDialog) {
        Bundle bundle = new Bundle();
        bundle.putLong(StringConstant.REPORT_USER_ID, this.i.get().getUserId());
        Activity activity = this.f10653a;
        TemplateUtils.startTemplate(activity, com.disabngo.blockynexus.e.b.Z.e.class, activity.getString(R.string.report), bundle);
        bottomDialog.cancel();
    }
}
