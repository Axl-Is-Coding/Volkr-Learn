package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Rc;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.entity.StatusBean;
import com.sandboxol.center.router.manager.GameDetailManager;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.greendao.entity.FriendFollowResponse;
import com.sandboxol.messager.MessagerClient;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes2.dex */
public class FollowFriendBottomDialog extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinearLayout f11294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FriendFollowResponse f11295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f11296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f11297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f11298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Boolean> f11299f;

    public interface OnClickListener {
        void onClick(FollowFriendBottomDialog followFriendBottomDialog);
    }

    public FollowFriendBottomDialog(Context context, FriendFollowResponse friendFollowResponse) {
        super(context);
        this.f11296c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.r
            @Override // rx.functions.Action0
            public final void call() {
                this.f11675a.a();
            }
        });
        this.f11297d = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.l
            @Override // rx.functions.Action0
            public final void call() {
                this.f11639a.d();
            }
        });
        this.f11298e = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.p
            @Override // rx.functions.Action0
            public final void call() {
                this.f11649a.b();
            }
        });
        this.f11299f = new ObservableField<>(false);
        this.f11295b = friendFollowResponse;
        initView();
        e();
    }

    private void c() {
        a(this.context.getString(R.string.friend_follow_friend_dialog_friend_detail), new OnClickListener() { // from class: com.disabngo.blockynexus.view.dialog.m
            @Override // com.disabngo.blockynexus.view.dialog.FollowFriendBottomDialog.OnClickListener
            public final void onClick(FollowFriendBottomDialog followFriendBottomDialog) {
                this.f11641a.b(followFriendBottomDialog);
            }
        });
        a(this.context.getString(R.string.friend_follow_friend_dialog_chat), new OnClickListener() { // from class: com.disabngo.blockynexus.view.dialog.o
            @Override // com.disabngo.blockynexus.view.dialog.FollowFriendBottomDialog.OnClickListener
            public final void onClick(FollowFriendBottomDialog followFriendBottomDialog) {
                this.f11645a.c(followFriendBottomDialog);
            }
        });
        a(this.context.getString(R.string.cancel), new OnClickListener() { // from class: com.disabngo.blockynexus.view.dialog.k
            @Override // com.disabngo.blockynexus.view.dialog.FollowFriendBottomDialog.OnClickListener
            public final void onClick(FollowFriendBottomDialog followFriendBottomDialog) {
                this.f11637a.d(followFriendBottomDialog);
            }
        });
    }

    private void e() {
        c();
    }

    public /* synthetic */ void a() {
        cancel();
        com.disabngo.blockynexus.d.n.b(this.context);
    }

    public /* synthetic */ void b() {
        if (this.f11295b.getGameId() != null) {
            Context context = this.context;
            GameDetailManager.enterGameDetail(context, context.getString(R.string.main_game), this.f11295b.getGameId());
            com.disabngo.blockynexus.d.n.k(this.context);
        }
        cancel();
    }

    public /* synthetic */ void d(FollowFriendBottomDialog followFriendBottomDialog) {
        cancel();
        com.disabngo.blockynexus.d.n.b(this.context);
    }

    public void initView() {
        super.init(this.context);
        Rc rc = (Rc) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.follow_dialog_follow_friend_bottom, (ViewGroup) null, false);
        setContentView(rc.getRoot());
        rc.a(this);
        LinearLayout linearLayout = rc.f7827a;
        this.f11294a = linearLayout;
        slideToUp(linearLayout);
        FriendFollowResponse friendFollowResponse = this.f11295b;
        if (friendFollowResponse != null) {
            this.f11299f.set(Boolean.valueOf(friendFollowResponse.isShowGame()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.disabngo.blockynexus.d.n.d(this.context);
        com.disabngo.blockynexus.view.fragment.main.Q.a(this.context, this.f11295b.getFriendId(), true, (OnDataListener<StatusBean>) new OnDataListener() { // from class: com.disabngo.blockynexus.view.dialog.n
            @Override // com.sandboxol.common.interfaces.OnDataListener
            public final void onSuccess(Object obj) {
                this.f11643a.a((StatusBean) obj);
            }
        });
    }

    public void a(String str, final OnClickListener onClickListener) {
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_item_bottom_menu, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
        textView.setText(str);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.dialog.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11672a.a(onClickListener, view);
            }
        });
        this.f11294a.addView(viewInflate);
    }

    public /* synthetic */ void c(FollowFriendBottomDialog followFriendBottomDialog) {
        if (this.f11295b.getNickName() != null && this.f11295b.getFriendId() != 0) {
            com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
            fVar.b("friend.user.id", this.f11295b.getFriendId());
            fVar.b("friend.nickname", this.f11295b.getNickName());
            MessagerClient.getIns().sendMsg1(BroadcastType.BROADCAST_ENTER_FRIEND_CHAT, fVar);
            com.disabngo.blockynexus.d.n.f(this.context);
        }
        cancel();
    }

    public /* synthetic */ void b(FollowFriendBottomDialog followFriendBottomDialog) {
        if (this.f11295b.getFriendId() != 0) {
            com.disabngo.blockynexus.e.b.x.J.a(this.context, (Friend) null, new FriendActivityIntentInfo(this.f11295b.getFriendId(), 0));
            com.disabngo.blockynexus.d.n.g(this.context);
        }
        cancel();
    }

    public /* synthetic */ void a(OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public /* synthetic */ void a(StatusBean statusBean) {
        FriendFollowResponse friendFollowResponse;
        if (statusBean != null && (friendFollowResponse = this.f11295b) != null && friendFollowResponse.getFriendId() != 0) {
            dismiss();
        } else {
            this.f11299f.set(false);
        }
    }
}
