package com.disabngo.blockynexus.view.dialog.activity;

import android.content.Context;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableMap;
import com.disabngo.blockynexus.entity.ActivityTaskTitle;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import rx.functions.Action0;

/* JADX INFO: compiled from: ActivityTaskTitleItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class y extends ListItemViewModel<ActivityTaskTitle> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObservableField<Integer> f11516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableMap<String, Integer> f11517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f11518c;

    public y(Context context, ActivityTaskTitle activityTaskTitle, ObservableField<Integer> observableField, ObservableMap<String, Integer> observableMap) {
        super(context, activityTaskTitle);
        this.f11518c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.activity.h
            @Override // rx.functions.Action0
            public final void call() {
                this.f11486a.f();
            }
        });
        this.f11516a = observableField;
        this.f11517b = observableMap;
        if (activityTaskTitle.getStatus() == 1) {
            Messenger.getDefault().send(true, MessageToken.TOKEN_ACTIVITY_RED_POINT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        this.f11516a.set(Integer.valueOf(((ActivityTaskTitle) this.item).getPosition()));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public ActivityTaskTitle getItem() {
        return (ActivityTaskTitle) super.getItem();
    }
}
