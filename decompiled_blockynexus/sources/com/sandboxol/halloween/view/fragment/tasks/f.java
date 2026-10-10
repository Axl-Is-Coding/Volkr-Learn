package com.sandboxol.halloween.view.fragment.tasks;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.halloween.R;
import com.sandboxol.halloween.entity.HalloweenInfoResponse;
import com.sandboxol.halloween.entity.HalloweenTask;
import java.util.List;

/* JADX INFO: compiled from: TasksListModel.java */
/* JADX INFO: loaded from: classes4.dex */
public class f extends DataListModel<HalloweenTask> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f18745a;

    public f(Context context, int i) {
        super(context, i);
        this.f18745a = false;
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return "token.refresh.task.list";
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<HalloweenTask> listItemViewModel) {
        gVar.a(com.sandboxol.halloween.a.f18578b, R.layout.halloween_item_task);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<HalloweenTask>> onResponseListener) {
        if (this.f18745a) {
            com.sandboxol.halloween.web.g.b(this.context, new e(this, onResponseListener));
            return;
        }
        HalloweenInfoResponse halloweenInfoResponseA = com.sandboxol.halloween.c.b.b().a();
        if (halloweenInfoResponseA != null) {
            onResponseListener.onSuccess(halloweenInfoResponseA.getTaskList());
        }
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<HalloweenTask> getItemViewModel(HalloweenTask halloweenTask) {
        return new TasksItemViewModel(this.context, halloweenTask);
    }

    public void a(boolean z) {
        this.f18745a = z;
    }
}
