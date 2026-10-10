package com.disabngo.blockynexus.view.dialog.activity;

import android.content.Context;
import com.disabngo.blockynexus.entity.ActivityTaskAction;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action0;

/* JADX INFO: compiled from: ActivityTaskContentTopItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class t extends ListItemViewModel<ActivityTaskAction> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f11506a;

    public t(Context context, ActivityTaskAction activityTaskAction) {
        super(context, activityTaskAction);
        this.f11506a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.activity.g
            @Override // rx.functions.Action0
            public final void call() {
                this.f11485a.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public ActivityTaskAction getItem() {
        return (ActivityTaskAction) super.getItem();
    }
}
