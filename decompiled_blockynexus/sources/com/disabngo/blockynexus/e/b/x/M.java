package com.disabngo.blockynexus.e.b.x;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Ud;
import com.disabngo.blockynexus.entity.FriendRequests;
import com.disabngo.blockynexus.entity.FriendStatus;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.utils.AppSharedUtils;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.imchat.config.ChatMessageToken;
import java.util.Iterator;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: FriendViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class M extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10291a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Ud f10293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0936D f10294d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10292b = "999+";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C0935C f10295e = new C0935C();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<String> f10296f = new ObservableField<>();
    public ObservableField<Integer> g = new ObservableField<>(0);
    public ObservableArrayList<FriendRequests> h = new ObservableArrayList<>();
    public ObservableField<Boolean> i = new ObservableField<>(false);
    public ReplyCommand j = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.x.i
        @Override // rx.functions.Action0
        public final void call() {
            this.f10305a.f();
        }
    });
    public ReplyCommand k = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.x.k
        @Override // rx.functions.Action0
        public final void call() {
            this.f10307a.h();
        }
    });

    public M(Context context, Ud ud) {
        this.f10291a = context;
        this.f10293c = ud;
        this.f10294d = new C0936D(context, R.string.chat_friend_is_empty);
        this.f10296f.set(context.getString(R.string.chat_friend_list, "0", "0"));
        initData();
        initMessenger();
    }

    private void i() {
        this.h.clear();
        List list = (List) new com.google.gson.j().a(AppSharedUtils.newInstance().getFriendString(AccountCenter.newInstance().userId.get() + SharedConstant.FRIEND_MATCH_FRIEND_APPLY_LIST), new L(this).getType());
        if (list != null) {
            this.h.addAll(list);
        }
    }

    private void initData() {
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_FRIEND_TOTAL_SIZE, FriendStatus.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.x.m
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10309a.a((FriendStatus) obj);
            }
        });
        Messenger.getDefault().register(this, "token.chat.new.friend", Integer.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.x.j
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10306a.a((Integer) obj);
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_CHAT_NEW_FRIEND_LIST, String.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.x.l
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10308a.a((String) obj);
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_CHAT_NEW_FRIEND_REMOVE, Long.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.x.o
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10311a.a((Long) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_LOGIN_REGISTER_SUCCESS, Integer.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.x.n
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10310a.b((Integer) obj);
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_GET_GROUP_INVITE_APPLY_MESSAGE, Boolean.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.x.p
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10312a.a((Boolean) obj);
            }
        });
    }

    public /* synthetic */ void a(FriendStatus friendStatus) {
        this.f10296f.set(this.f10291a.getString(R.string.chat_friend_list, String.valueOf(friendStatus.getCurFriendCount()), String.valueOf(friendStatus.getMaxFriendCount())));
    }

    public /* synthetic */ void b(Integer num) {
        if (num.intValue() == 2 || num.intValue() == 1) {
            i();
            this.g.set(0);
        }
    }

    public /* synthetic */ void f() {
        Bundle bundle = new Bundle();
        bundle.putInt(SharedConstant.KEY_GROUP_NEW_STATUS, this.i.get().booleanValue() ? 1 : 0);
        Context context = this.f10291a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.va.c.class, context.getString(R.string.chat_new_friend), bundle);
    }

    public /* synthetic */ void h() {
        Context context = this.f10291a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.B.c.class, context.getString(R.string.my_group), R.mipmap.ic_add_new_member);
        ReportDataAdapter.onEvent(this.f10291a, EventConstant.CLICK_MY_GROUP_CHAT);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    public /* synthetic */ void a(Integer num) {
        this.g.set(num);
    }

    public /* synthetic */ void a(String str) {
        try {
            FriendRequests friendRequests = (FriendRequests) new com.google.gson.j().a(str, FriendRequests.class);
            if (this.h.size() >= 5) {
                this.h.remove(0);
            }
            this.h.add(friendRequests);
            AppSharedUtils.newInstance().putFriendString(AccountCenter.newInstance().userId.get() + SharedConstant.FRIEND_MATCH_FRIEND_APPLY_LIST, new com.google.gson.j().a(this.h));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void a(Long l) {
        try {
            Iterator<FriendRequests> it = this.h.iterator();
            while (it.hasNext()) {
                if (it.next().getUserId() == l.longValue()) {
                    it.remove();
                }
            }
            AppSharedUtils.newInstance().putFriendString(AccountCenter.newInstance().userId.get() + SharedConstant.FRIEND_MATCH_FRIEND_APPLY_LIST, new com.google.gson.j().a(this.h));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void a(Boolean bool) {
        this.i.set(bool);
    }
}
