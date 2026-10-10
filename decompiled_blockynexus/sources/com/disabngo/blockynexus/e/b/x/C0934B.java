package com.disabngo.blockynexus.e.b.x;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.entity.StatusBean;
import com.disabngo.blockynexus.view.dialog.BottomDialog;
import com.disabngo.blockynexus.view.dialog.EditTextDialog;
import com.disabngo.blockynexus.view.fragment.main.Q;
import com.disabngo.blockynexus.web.FriendApi;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.manager.FeedBackManager;
import com.sandboxol.center.utils.GameIdRemarkUtils;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.greendao.entity.Friend;
import rx.functions.Action0;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.x.B, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FriendItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0934B extends ListItemViewModel<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f10275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f10276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f10277c;

    public C0934B(Context context, Friend friend) {
        super(context, friend);
        this.f10275a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.x.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f10300a.f();
            }
        });
        this.f10276b = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.x.g
            @Override // rx.functions.Action0
            public final void call() {
                this.f10303a.h();
            }
        });
        this.f10277c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.x.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f10298a.m();
            }
        });
        if (friend.getUserId() == 32) {
            friend.setStatus(10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        FriendApi.addToBlacklist(this.context, ((Friend) this.item).getUserId(), new C0933A(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void j() {
        FriendApi.friendDelete(this.context, ((Friend) this.item).getUserId(), new z(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void k() {
        FriendApi.friendDeleteAlias(this.context, ((Friend) this.item).getUserId(), new y(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void l() {
        EditTextDialog editTextDialogC = new EditTextDialog(this.context).c(this.context.getString(R.string.add_friend_alias));
        if (TextUtils.isEmpty(((Friend) this.item).getAlias())) {
            editTextDialogC.b(this.context.getString(R.string.input_friend_alias));
        } else {
            editTextDialogC.a(((Friend) this.item).getAlias());
        }
        editTextDialogC.a(new w(this)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"CheckResult"})
    public void m() {
        T t = this.item;
        if (t != 0 && ((Friend) t).getFriendPartyStatus() != null && ((Friend) this.item).getFriendPartyStatus().getGameId() != null) {
            ((Friend) this.item).getFriendPartyStatus().setGameId(GameIdRemarkUtils.singleGameToHallGame(((Friend) this.item).getFriendPartyStatus().getGameId()));
        }
        T t2 = this.item;
        if (t2 != 0 && ((Friend) t2).getUserId() != 0) {
            Q.a(this.context, ((Friend) this.item).getUserId(), false, (OnDataListener<StatusBean>) null);
        }
        com.disabngo.blockynexus.d.n.j(this.context);
    }

    private void p() {
        new BottomDialog(this.context).a(this.context.getString(R.string.add_friend_alias), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.e.b.x.h
            @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
            public final void onClick(BottomDialog bottomDialog) {
                this.f10304a.a(bottomDialog);
            }
        }).a(this.context.getString(R.string.delete_friend), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.e.b.x.a
            @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
            public final void onClick(BottomDialog bottomDialog) {
                this.f10297a.b(bottomDialog);
            }
        }).a(this.context.getString(R.string.item_add_blacklist), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.e.b.x.f
            @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
            public final void onClick(BottomDialog bottomDialog) {
                this.f10302a.c(bottomDialog);
            }
        }).a(this.context.getString(R.string.cancel), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.e.b.x.q
            @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
            public final void onClick(BottomDialog bottomDialog) {
                bottomDialog.cancel();
            }
        }).show();
    }

    public /* synthetic */ void b(BottomDialog bottomDialog) {
        new TwoButtonDialog(this.context).setDetailText(R.string.friend_delete_detail).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.x.c
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f10299a.j();
            }
        }).show();
        bottomDialog.cancel();
    }

    public /* synthetic */ void c(BottomDialog bottomDialog) {
        new TwoButtonDialog(this.context).setDetailText(R.string.friend_add_blacklist_detail).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.x.e
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f10301a.i();
            }
        }).show();
        bottomDialog.cancel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void f() {
        if (((Friend) this.item).getUserId() == 32) {
            FeedBackManager.openFeedbackActivity();
            return;
        }
        Messenger.getDefault().sendNoMsg(MessageToken.FRIEND_LIST_STORE_POSITION);
        Context context = this.context;
        T t = this.item;
        J.a(context, (Friend) t, new FriendActivityIntentInfo(((Friend) t).getUserId(), 2));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public Friend getItem() {
        return (Friend) super.getItem();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void h() {
        if (((Friend) this.item).getUserId() != 32) {
            p();
        }
    }

    public /* synthetic */ void a(BottomDialog bottomDialog) {
        l();
        bottomDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(String str) {
        FriendApi.friendAddAlias(this.context, ((Friend) this.item).getUserId(), str, new x(this, str));
    }
}
