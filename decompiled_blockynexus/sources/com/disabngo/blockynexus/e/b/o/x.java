package com.disabngo.blockynexus.e.b.o;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.databinding.ObservableField;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.F;
import androidx.fragment.app.Fragment;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.C;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.entity.ConversationClickStateHolder;
import com.disabngo.blockynexus.utils.logic.N;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.ui.fragment.conversationlist.BMConversationListFragment;
import io.rong.imkit.RongExtension;
import io.rong.imlib.model.Conversation;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: ChatViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class x extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C0891o f10022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Fragment f10023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.disabngo.blockynexus.e.b.x.v f10024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BMConversationListFragment f10025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f10026f = "999+";
    private int g = 0;
    private int h = 0;
    private int i = 0;
    public ObservableField<Integer> j = new ObservableField<>(Integer.valueOf(R.id.rbChat));
    public ObservableField<Integer> k = new ObservableField<>(0);
    public ObservableField<Integer> l = new ObservableField<>(0);
    public ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> m = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.o.i
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9995a.a((RadioGroupBindingAdapters.CheckedDataWrapper) obj);
        }
    });
    private boolean n = false;

    @SuppressLint({"CheckResult"})
    public x(Context context, C0891o c0891o) {
        this.f10021a = context;
        this.f10022b = c0891o;
        initMessenger();
        if (AccountCenter.newInstance().login.get().booleanValue()) {
            new v().b(this.f10021a);
            N.p();
            new v().c(this.f10021a);
            N.k();
            N.l();
            N.i();
            ConversationClickStateHolder.getInstance().setState(1);
        }
        b(context);
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_RELOAD_FRIEND_LIST, new Action0() { // from class: com.disabngo.blockynexus.e.b.o.k
            @Override // rx.functions.Action0
            public final void call() {
                this.f9997a.f();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_LOGIN_REGISTER_SUCCESS, Integer.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.o.n
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10000a.a((Integer) obj);
            }
        });
        Messenger.getDefault().register(this, "token.init.rong.cloud", new Action0() { // from class: com.disabngo.blockynexus.e.b.o.m
            @Override // rx.functions.Action0
            public final void call() {
                this.f9999a.j();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_CHAT_UNREAD_MESSAGE_COUNT, Integer.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.o.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9990a.b((Integer) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_GROUP_CHAT_RED_POINT, Integer.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.o.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9992a.c((Integer) obj);
            }
        });
        Messenger.getDefault().register(this, "token.chat.new.friend", Integer.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.o.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9989a.d((Integer) obj);
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_RESET_NEW_NUM, new Action0() { // from class: com.disabngo.blockynexus.e.b.o.h
            @Override // rx.functions.Action0
            public final void call() {
                this.f9994a.k();
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_GET_GROUP_INVITE_APPLY_MESSAGE, Boolean.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.o.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9987a.a((Boolean) obj);
            }
        });
        Messenger.getDefault().register(this, "token.init.rong.cloud", new Action0() { // from class: com.disabngo.blockynexus.e.b.o.j
            @Override // rx.functions.Action0
            public final void call() {
                this.f9996a.l();
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_START_GROUP_INFO, String.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.o.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9988a.a((String) obj);
            }
        });
        Messenger.getDefault().register(this, "token.refresh.group.info", String.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.o.g
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                x.b((String) obj);
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_REFRESH_CONVERSATION_STATE, new Action0() { // from class: com.disabngo.blockynexus.e.b.o.l
            @Override // rx.functions.Action0
            public final void call() {
                ConversationClickStateHolder.getInstance().setState(1);
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_SEND_GROUP_CARD, RongExtension.class, new w(this));
        Messenger.getDefault().register(this, MessageToken.TOKEN_SELECT_CHAT, new Action0() { // from class: com.disabngo.blockynexus.e.b.o.e
            @Override // rx.functions.Action0
            public final void call() {
                this.f9991a.i();
            }
        });
    }

    private void m() {
        AbstractC0336n childFragmentManager = this.f10022b.getChildFragmentManager();
        F fA = childFragmentManager.a();
        a(childFragmentManager, fA);
        if (this.f10024d == null) {
            this.f10024d = new com.disabngo.blockynexus.e.b.x.v();
            if (childFragmentManager.a("friendFragment") == null) {
                fA.a(R.id.flChat, this.f10024d, "friendFragment");
                fA.c(this.f10024d);
            }
        }
        fA.b();
    }

    private void p() {
        this.k.set(Integer.valueOf(this.g + this.h));
        SharedUtils.putInt(this.f10021a, SharedConstant.KEY_ALL_UNREAD_COUNT, this.g + this.h);
        if (this.g + this.h <= 0 || !SharedUtils.getBoolean(this.f10021a, "first.send.message.and.receiver", true) || SharedUtils.getBoolean(this.f10021a, "first.send.message", true)) {
            return;
        }
        SharedUtils.putBoolean(this.f10021a, "first.send.message.and.receiver", false);
        ReportDataAdapter.onEvent(this.f10021a, EventConstant.CHAT_MESS_MUTUAL);
    }

    public /* synthetic */ void c(Integer num) {
        this.h = num.intValue();
        p();
    }

    public /* synthetic */ void d(Integer num) {
        this.l.set(Integer.valueOf(num.intValue() + this.i));
    }

    public /* synthetic */ void f() {
        new v().a(this.f10021a, 0, 50);
    }

    public /* synthetic */ void i() {
        this.j.set(Integer.valueOf(R.id.rbFriend));
    }

    public /* synthetic */ void j() {
        if (this.f10025e != null) {
            this.f10025e.setUri(Uri.parse("rong://" + this.f10021a.getApplicationInfo().packageName).buildUpon().appendPath("conversationlist").appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false").appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "false").appendQueryParameter(Conversation.ConversationType.DISCUSSION.getName(), "false").build());
            this.f10025e.onRestoreUI();
        }
    }

    public /* synthetic */ void k() {
        this.l.set(0);
        this.i = 0;
    }

    public /* synthetic */ void l() {
        b(this.f10021a);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onCreate() {
        super.onResume();
        m();
        this.n = true;
        b(this.j.get().intValue());
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
        N.g();
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onResume() {
        super.onResume();
        N.b(this.f10021a);
        N.n();
    }

    private void b(Context context) {
        N.m();
        N.n();
        N.b(context);
        C.a();
    }

    public /* synthetic */ void a(RadioGroupBindingAdapters.CheckedDataWrapper checkedDataWrapper) {
        b(checkedDataWrapper.getCheckedId());
    }

    public /* synthetic */ void a(Integer num) {
        if (num.intValue() == 2 || num.intValue() == 1) {
            b(R.id.rbChat);
            N.a((Activity) this.f10022b.getActivity());
            new v().b(this.f10021a);
            new v().a(this.f10021a, 0, 50);
            if (this.f10025e != null) {
                this.f10025e.setUri(Uri.parse("rong://" + this.f10021a.getApplicationInfo().packageName).buildUpon().appendPath("conversationlist").appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false").appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "false").appendQueryParameter(Conversation.ConversationType.DISCUSSION.getName(), "false").build());
                this.f10025e.onRestoreUI();
            }
            this.l.set(0);
            this.i = 0;
        }
    }

    public /* synthetic */ void b(Integer num) {
        this.g = num.intValue();
        p();
    }

    static /* synthetic */ void b(String str) {
        if (y.b().a(str) == 1) {
            y.b().m(Long.valueOf(str).longValue());
        } else if (y.b().a(str) == 0) {
            Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_TRIBE_MEMBER);
        }
    }

    private void b(int i) {
        if (this.n) {
            this.j.set(Integer.valueOf(i));
            if (i == R.id.rbChat) {
                a(this.f10025e);
                ReportDataAdapter.onEvent(this.f10021a, EventConstant.CHAT_CHAT_CLICK);
            } else {
                if (i != R.id.rbFriend) {
                    return;
                }
                a(this.f10024d);
                ReportDataAdapter.onEvent(this.f10021a, EventConstant.CHAT_FRIENDS_CLICK);
            }
        }
    }

    public /* synthetic */ void a(Boolean bool) {
        if (bool.booleanValue()) {
            this.i++;
            ObservableField<Integer> observableField = this.l;
            observableField.set(Integer.valueOf(observableField.get().intValue() + 1));
        }
    }

    public /* synthetic */ void a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("key.group.id", str);
        Context context = this.f10021a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.D.v.class, context.getString(R.string.group_info), bundle);
    }

    private void a(AbstractC0336n abstractC0336n, F f2) {
        if (this.f10025e == null) {
            this.f10025e = new BMConversationListFragment();
            if (abstractC0336n.a("conversationListFragment") == null) {
                this.f10025e.setUri(Uri.parse("rong://" + this.f10021a.getApplicationInfo().packageName).buildUpon().appendPath("conversationlist").appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false").appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "false").appendQueryParameter(Conversation.ConversationType.DISCUSSION.getName(), "false").build());
                f2.a(R.id.flChat, this.f10025e, "conversationListFragment");
            }
            N.q();
        }
    }

    private void a(Fragment fragment) {
        F fA = this.f10022b.getChildFragmentManager().a();
        fA.a(0);
        Fragment fragment2 = this.f10023c;
        if (fragment2 != null) {
            fA.c(fragment2);
        }
        fA.e(fragment);
        fA.b();
        this.f10023c = fragment;
    }
}
