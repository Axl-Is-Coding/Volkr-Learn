package com.disabngo.blockynexus.view.dialog.partyfriend;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.activity.friends.I;
import com.disabngo.blockynexus.view.activity.friends.N;
import com.disabngo.blockynexus.view.dialog.DialogC1114ra;
import com.disabngo.blockynexus.web.FriendApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.greendao.entity.UserGameCareerInfo;
import me.tatarka.bindingcollectionadapter2.l;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: PartyFriendInfoViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PartyFriendInfoDialog f11667b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public I f11669d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.disabngo.blockynexus.e.b.X.a f11668c = new com.disabngo.blockynexus.e.b.X.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Friend> f11670e = new ObservableField<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Long> f11671f = new ObservableField<>();
    public ObservableField<Boolean> g = new ObservableField<>();
    private ObservableMap<Long, String> h = new ObservableArrayMap();
    public ObservableMap<Long, String> i = new ObservableArrayMap();
    public ObservableField<Boolean> j = new ObservableField<>(false);
    public ObservableField<Boolean> k = new ObservableField<>(false);
    public ObservableField<Integer> l = new ObservableField<>(Integer.valueOf(R.id.rbMonth));
    public ObservableField<Integer> m = new ObservableField<>(0);
    public ReplyCommand n = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.partyfriend.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f11658a.j();
        }
    });
    public ReplyCommand o = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.partyfriend.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f11661a.i();
        }
    });
    public ReplyCommand p = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.partyfriend.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f11657a.f();
        }
    });
    public ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> q = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.view.dialog.partyfriend.g
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f11663a.a((RadioGroupBindingAdapters.CheckedDataWrapper) obj);
        }
    });
    public ObservableList<N> r = new ObservableArrayList();
    public me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<N>> s = me.tatarka.bindingcollectionadapter2.g.a(new l() { // from class: com.disabngo.blockynexus.view.dialog.partyfriend.f
        @Override // me.tatarka.bindingcollectionadapter2.l
        public final void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, Object obj) {
            this.f11662a.bindView(gVar, i, (ListItemViewModel) obj);
        }
    });
    public ReplyCommand<Integer> t = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.view.dialog.partyfriend.c
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f11659a.b(((Integer) obj).intValue());
        }
    });

    public j(PartyFriendInfoDialog partyFriendInfoDialog, long j, Friend friend) {
        this.f11666a = partyFriendInfoDialog;
        this.f11667b = partyFriendInfoDialog;
        this.f11671f.set(Long.valueOf(j));
        this.f11670e.set(friend);
        l();
        a(j);
        initMessenger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindView(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<N> listItemViewModel) {
        gVar.a(482, R.layout.item_friend_match_career);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f11670e.get().getClanId() == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("tribe.clan.id", this.f11670e.get().getClanId());
        bundle.putInt(StringConstant.FROM_PAGE, 3);
        Context context = this.f11666a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ma.e.class, context.getString(R.string.tribe_detail), bundle);
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_FRIEND_NO_DECORATION, new Action0() { // from class: com.disabngo.blockynexus.view.dialog.partyfriend.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f11660a.h();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.f11670e.get() == null || this.f11670e.get().getUserId() == 0) {
            return;
        }
        new DialogC1114ra(this.f11666a, this.f11670e.get().getUserId(), "").show();
        ReportDataAdapter.onEvent(this.f11666a, EventConstant.FIND_CLICK_ADDFIREND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        UserGameCareerInfo userGameMonthInfo = this.f11670e.get().getUserGameDataResponse().getUserGameMonthInfo();
        UserGameCareerInfo userGameCareerInfo = this.f11670e.get().getUserGameDataResponse().getUserGameCareerInfo();
        this.r.add(new N(this.f11666a, 0, userGameMonthInfo));
        this.r.add(new N(this.f11666a, 1, userGameCareerInfo));
    }

    private void l() {
        if (this.f11669d == null) {
            this.f11669d = new I(this.f11666a, R.string.dress_me_no_dress, this.h, this.i, this.f11671f, this.j);
        }
    }

    public void f() {
        CommonHelper.hideSoftInputFromWindow(this.f11666a);
        this.f11667b.finish();
    }

    public /* synthetic */ void h() {
        this.g.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (i == 0) {
            this.l.set(Integer.valueOf(R.id.rbMonth));
        } else {
            if (i != 1) {
                return;
            }
            this.l.set(Integer.valueOf(R.id.rbWhole));
        }
    }

    public /* synthetic */ void a(RadioGroupBindingAdapters.CheckedDataWrapper checkedDataWrapper) {
        int checkedId = checkedDataWrapper.getCheckedId();
        if (checkedId == R.id.rbMonth) {
            this.m.set(0);
        } else {
            if (checkedId != R.id.rbWhole) {
                return;
            }
            this.m.set(1);
        }
    }

    private void a(long j) {
        FriendApi.friendDetails(this.f11666a, j, new i(this));
    }
}
