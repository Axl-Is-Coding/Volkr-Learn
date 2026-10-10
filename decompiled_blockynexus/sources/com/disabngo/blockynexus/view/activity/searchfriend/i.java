package com.disabngo.blockynexus.view.activity.searchfriend;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.e.b.x.J;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.greendao.entity.Friend;
import rx.functions.Action0;

/* JADX INFO: compiled from: SearchFriendItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends ListItemViewModel<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f11071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f11072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f11073d;

    /* JADX WARN: Multi-variable type inference failed */
    public i(Context context, Friend friend, boolean z) {
        super(context, friend);
        this.f11071b = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.searchfriend.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f11063a.h();
            }
        });
        this.f11072c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.searchfriend.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f11062a.f();
            }
        });
        this.f11073d = new ObservableField<>(Boolean.valueOf(((Friend) this.item).getFriend()));
        this.f11070a = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void h() {
        new l().a(this.context, ((Friend) this.item).getUserId(), this.f11073d, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void f() {
        if (this.f11070a) {
            J.a(this.context, (Friend) null, new FriendActivityIntentInfo(((Friend) this.item).getUserId(), 2));
            ReportDataAdapter.onEvent(this.context, EventConstant.CHAT_SEARCH_USER_INFO);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public Friend getItem() {
        this.f11073d.set(Boolean.valueOf(((Friend) this.item).getFriend()));
        return (Friend) super.getItem();
    }
}
