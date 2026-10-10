package com.disabngo.blockynexus.e.b.O;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.D;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.utils.logic.N;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.imchat.config.ChatMessageToken;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: MakeFriendViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class t extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9384a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s f9386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.disabngo.blockynexus.e.b.ma.g f9387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.disabngo.blockynexus.e.b.X.a f9388e = new com.disabngo.blockynexus.e.b.X.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Boolean> f9389f = new ObservableField<>(false);
    public ObservableField<String> g = new ObservableField<>("");
    public ReplyCommand h = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.O.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f9366a.m();
        }
    });
    public ReplyCommand i = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.O.j
        @Override // rx.functions.Action0
        public final void call() {
            this.f9371a.j();
        }
    });
    public ReplyCommand j = new ReplyCommand(new f(this));
    public ReplyCommand k = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.O.g
        @Override // rx.functions.Action0
        public final void call() {
            this.f9368a.p();
        }
    });
    public ReplyCommand l = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.O.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f9365a.k();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f9385b = new q();

    public t(Context context) {
        this.f9384a = context;
        initData();
        initMessenger();
    }

    private void i() {
        N.a(TribeCenter.newInstance().tribeClanId.get());
        TribeCenter.newInstance().logout();
    }

    private void initData() {
        Context context;
        int i;
        this.f9386c = new s(this.f9384a, R.string.no_data);
        this.f9387d = new com.disabngo.blockynexus.e.b.ma.g(this.f9384a, R.string.no_data, 1);
        q qVar = this.f9385b;
        if (qVar != null) {
            qVar.a(this.f9384a);
        }
        ObservableField<String> observableField = this.g;
        if (AppInfoCenter.newInstance().getAppConfig() == null || !AppInfoCenter.newInstance().getAppConfig().isShowFriendMatch()) {
            context = this.f9384a;
            i = R.string.friend_map_online;
        } else {
            context = this.f9384a;
            i = R.string.friend_search_friend;
        }
        observableField.set(context.getString(i));
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_LOGIN_REGISTER_SUCCESS, Integer.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.O.k
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9372a.a((Integer) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_ACCOUNT, Integer.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.O.h
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9369a.b((Integer) obj);
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_TRIBE_JOIN_OR_EXIT, Boolean.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.O.m
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9374a.a((Boolean) obj);
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_TRIBE_EXIT_OR_KICK, new Action0() { // from class: com.disabngo.blockynexus.e.b.O.i
            @Override // rx.functions.Action0
            public final void call() {
                this.f9370a.f();
            }
        });
        Messenger.getDefault().register(this, "token.tribe.request.join", new Action0() { // from class: com.disabngo.blockynexus.e.b.O.l
            @Override // rx.functions.Action0
            public final void call() {
                this.f9373a.h();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_GO_FRIEND_MATCH, new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ReportDataAdapter.onEvent(this.f9384a, EventConstant.HOME_TRIBE_TAB);
        ReportDataAdapter.onEvent(this.f9384a, EventConstant.FIND_CLICK_ENTERCLAN);
        D.f(this.f9384a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Bundle bundle = new Bundle();
        bundle.putLong("tribe.clan.id", TribeCenter.newInstance().tribeClanId.get().longValue());
        Context context = this.f9384a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ma.e.class, context.getString(R.string.tribe_detail), bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if ((this.f9384a instanceof Activity) && AppInfoCenter.newInstance().getAppConfig().isShowFriendMatch()) {
            ReportDataAdapter.onEvent(this.f9384a, EventConstant.FIND_CLICK_FINDFRIEND);
            SandboxReportManager.onEvent(ReportEvent.NEW_FIND_CLICK_FRIEND, ReportEventType.NEW_USER_BEHAVIOR, "app");
            this.f9385b.a((Activity) this.f9384a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        ReportDataAdapter.onEvent(this.f9384a, EventConstant.HOME_TRIBE_TAB);
        ReportDataAdapter.onEvent(this.f9384a, EventConstant.FIND_CLICK_FINDCLAN);
        SandboxReportManager.onEvent(ReportEvent.NEW_FIND_CLICK_TRIBE, ReportEventType.NEW_USER_BEHAVIOR, "app");
        D.g(this.f9384a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.f9389f.set(false);
        Context context = this.f9384a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.pa.d.class, context.getString(R.string.tribe_message));
    }

    public /* synthetic */ void a(Integer num) {
        if ((num.intValue() == 2 || num.intValue() == 1) && this.f9385b != null) {
            i();
            this.f9385b.a(this.f9384a);
        }
    }

    public /* synthetic */ void b(Integer num) {
        if (num.intValue() == 3) {
            this.f9389f.set(false);
            i();
        }
    }

    public /* synthetic */ void f() {
        this.f9389f.set(true);
        i();
        y.b().b(false);
        Messenger.getDefault().send(true, MessageToken.TOKEN_CLAN_IS_SHOW_UNREAD_MESSAGE);
    }

    public /* synthetic */ void h() {
        this.f9389f.set(true);
        Messenger.getDefault().send(true, MessageToken.TOKEN_CLAN_IS_SHOW_UNREAD_MESSAGE);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    public /* synthetic */ void a(Boolean bool) {
        if (bool.booleanValue()) {
            q qVar = this.f9385b;
            if (qVar != null) {
                qVar.a(this.f9384a);
            }
            y.b().b(true);
            ReportDataAdapter.onEvent(this.f9384a, EventConstant.CLAN_ENTER_SUC);
            return;
        }
        this.f9389f.set(false);
        i();
        y.b().b(false);
        AppToastUtils.showShortNegativeTipToast(this.f9384a, R.string.tribe_already_exit);
    }
}
