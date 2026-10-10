package com.disabngo.blockynexus.e.b.ua;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.entity.TribeTaskList;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import rx.functions.Action0;

/* JADX INFO: compiled from: TribeTaskPageItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class m extends ListItemViewModel<TribeTaskList> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Integer> f10212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f10213c;

    /* JADX WARN: Multi-variable type inference failed */
    public m(Context context, TribeTaskList tribeTaskList, int i) {
        super(context, tribeTaskList);
        this.f10212b = new ObservableField<>(Integer.valueOf(((TribeTaskList) this.item).getStatus()));
        this.f10213c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ua.f
            @Override // rx.functions.Action0
            public final void call() {
                this.f10208a.h();
            }
        });
        this.f10211a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i() {
        TribeApi.acceptTask(this.context, ((TribeTaskList) this.item).getId(), this.f10211a, new k(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        TribeApi.getTaskReward(this.context, ((TribeTaskList) this.item).getId(), this.f10211a, new l(this));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public TribeTaskList getItem() {
        TribeTaskList tribeTaskList = (TribeTaskList) super.getItem();
        this.f10212b.set(Integer.valueOf(tribeTaskList.getStatus()));
        return tribeTaskList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void h() {
        int status = ((TribeTaskList) this.item).getStatus();
        if (status == 0) {
            i();
            if (this.f10211a == 0) {
                ReportDataAdapter.onEvent(this.context, EventConstant.CLAN_TASK_GROUP_ACCEPT);
            }
            if (this.f10211a == 1) {
                ReportDataAdapter.onEvent(this.context, EventConstant.CLAN_TASK_PERSONAL_ACCEPT);
                return;
            }
            return;
        }
        if (status != 2) {
            return;
        }
        f();
        if (this.f10211a == 0) {
            ReportDataAdapter.onEvent(this.context, EventConstant.CLAN_TASK_GROUP_AWARD);
        }
        if (this.f10211a == 1) {
            ReportDataAdapter.onEvent(this.context, EventConstant.CLAN_TASK_PERSONAL_AWARD);
        }
    }
}
