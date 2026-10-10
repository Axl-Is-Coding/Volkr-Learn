package com.sandboxol.gamedetail.view.dialog.a;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.router.manager.FriendManager;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.c.P;
import com.sandboxol.greendao.entity.AuthorInfo;
import rx.functions.Action0;

/* JADX INFO: compiled from: AuthorListItemViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends ListItemViewModel<AuthorInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<String> f18123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Boolean> f18124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f18125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f18126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f18127e;

    public f(Context context, AuthorInfo authorInfo, boolean z) {
        super(context, authorInfo);
        this.f18123a = new ObservableField<>("");
        this.f18124b = new ObservableField<>(false);
        this.f18125c = new ObservableField<>(true);
        this.f18126d = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.view.dialog.a.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f18116a.h();
            }
        });
        this.f18127e = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.view.dialog.a.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f18117a.f();
            }
        });
        try {
            P.newInstance().a(authorInfo.getUserId(), new e(this, context, z));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void h() {
        FriendManager.addFriend(this.context, ((AuthorInfo) this.item).getUserId(), this.f18124b, true, this.f18123a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void f() {
        if (this.f18125c.get().booleanValue()) {
            FriendManager.getFriendDataAndEnterFriendInfo(this.context, null, ((AuthorInfo) this.item).getUserId());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public AuthorInfo getItem() {
        return (AuthorInfo) super.getItem();
    }
}
