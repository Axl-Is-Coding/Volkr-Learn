package com.disabngo.blockynexus.e.b.c;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.entity.ActivityTaskTitle;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action0;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.c.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0823c extends ListItemViewModel<ActivityTaskTitle> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Long> f9675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f9676e;

    public C0823c(Context context, ActivityTaskTitle activityTaskTitle) {
        super(context, activityTaskTitle);
        this.f9672a = 100;
        this.f9673b = 101;
        this.f9674c = 0;
        this.f9675d = new ObservableField<>(-1L);
        this.f9676e = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.c.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f9671a.f();
            }
        });
        if (activityTaskTitle.getEndTime() != -1) {
            this.f9675d.set(Long.valueOf((activityTaskTitle.getEndTime() * 1000) - System.currentTimeMillis() > 0 ? (activityTaskTitle.getEndTime() * 1000) - System.currentTimeMillis() : 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f() {
        /*
            Method dump skipped, instruction units count: 522
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.e.b.c.C0823c.f():void");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public ActivityTaskTitle getItem() {
        return (ActivityTaskTitle) super.getItem();
    }
}
