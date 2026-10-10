package com.disabngo.blockynexus.view.fragment.main;

import android.app.Activity;
import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.web.FriendApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.greendao.entity.FriendFollowResponse;
import com.sandboxol.greendao.entity.Game;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: PageFollowFriendsItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class U extends ListItemViewModel<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public S f11798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<FriendFollowResponse> f11799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f11800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f11801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f11802e;

    public U(Context context, Game game) {
        super(context, game);
        this.f11799b = new ArrayList();
        this.f11800c = new ObservableField<>(false);
        this.f11801d = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.main.t
            @Override // rx.functions.Action0
            public final void call() {
                this.f11830a.onEnterDiscover();
            }
        });
        this.f11802e = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.main.v
            @Override // rx.functions.Action0
            public final void call() {
                this.f11832a.f();
            }
        });
        this.f11798a = new S(context, this.f11799b);
        h();
        initMessenger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_SELECT_CHAT);
        com.disabngo.blockynexus.d.n.l(this.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        FriendApi.followFriendsList(this.context, new T(this));
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_FOLLOW_FRIENDS_LIST, new Action0() { // from class: com.disabngo.blockynexus.view.fragment.main.u
            @Override // rx.functions.Action0
            public final void call() {
                this.f11831a.h();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEnterDiscover() {
        ReportDataAdapter.onEvent(this.context, EventConstant.HOME_ALL_CLICK);
        com.disabngo.blockynexus.d.D.a((Activity) this.context);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }
}
