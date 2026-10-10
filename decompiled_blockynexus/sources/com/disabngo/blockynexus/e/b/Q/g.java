package com.disabngo.blockynexus.e.b.Q;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.x.J;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.entity.FriendRequests;
import com.disabngo.blockynexus.web.FriendApi;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.Friend;
import rx.functions.Action0;

/* JADX INFO: compiled from: NewFriendItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends ListItemViewModel<FriendRequests> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f9400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f9401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f9402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<String> f9403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Boolean> f9404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Boolean> f9405f;

    public g(Context context, FriendRequests friendRequests) {
        super(context, friendRequests);
        this.f9400a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.Q.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f9395a.k();
            }
        });
        this.f9401b = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.Q.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f9397a.j();
            }
        });
        this.f9402c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.Q.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f9396a.f();
            }
        });
        this.f9403d = new ObservableField<>(h());
        this.f9404e = new ObservableField<>(Boolean.valueOf(i()));
        this.f9405f = new ObservableField<>(true);
    }

    private String h() {
        int status = getItem().getStatus();
        return status != 0 ? status != 1 ? status != 2 ? "" : this.context.getString(R.string.refuse_add_friend) : this.context.getString(R.string.agree_add_friend) : "";
    }

    private boolean i() {
        int status = getItem().getStatus();
        if (status != 0) {
            return status == 1 || status == 2;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void j() {
        this.f9405f.set(false);
        FriendApi.friendAgreeAdd(this.context, ((FriendRequests) this.item).getUserId(), new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void k() {
        this.f9405f.set(false);
        FriendApi.friendRefuseAdd(this.context, ((FriendRequests) this.item).getUserId(), new e(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void f() {
        if (((FriendRequests) this.item).getStatus() != 2) {
            J.a(this.context, (Friend) null, new FriendActivityIntentInfo(((FriendRequests) this.item).getUserId(), 1));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public FriendRequests getItem() {
        return (FriendRequests) super.getItem();
    }
}
