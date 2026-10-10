package com.disabngo.blockynexus.e.b.na;

import android.content.Context;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.Friend;
import rx.functions.Action1;

/* JADX INFO: compiled from: TribeInviteFriendItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends ListItemViewModel<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableArrayList<String> f9972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ObservableField<Boolean> f9973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand<Boolean> f9974c;

    public d(Context context, Friend friend, ObservableArrayList<String> observableArrayList, ObservableField<Boolean> observableField) {
        super(context, friend);
        this.f9974c = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.na.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9970a.a((Boolean) obj);
            }
        });
        this.f9972a = observableArrayList;
        this.f9973b = observableField;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void a(Boolean bool) {
        if (!bool.booleanValue()) {
            this.f9972a.remove(String.valueOf(((Friend) this.item).getUserId()));
        } else if (!this.f9972a.contains(String.valueOf(((Friend) this.item).getUserId()))) {
            this.f9972a.add(String.valueOf(((Friend) this.item).getUserId()));
        }
        if (this.f9972a.size() > 0) {
            this.f9973b.set(true);
        } else {
            this.f9973b.set(false);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public Friend getItem() {
        return (Friend) super.getItem();
    }
}
