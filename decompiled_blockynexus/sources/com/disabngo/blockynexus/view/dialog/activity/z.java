package com.disabngo.blockynexus.view.dialog.activity;

import android.content.Context;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableMap;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.ActivityTaskTitle;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: ActivityTaskTitleListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class z extends DataListModel<ActivityTaskTitle> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObservableField<Integer> f11519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<ActivityTaskTitle> f11520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObservableMap<String, Integer> f11521c;

    public z(Context context, int i, List<ActivityTaskTitle> list, ObservableField<Integer> observableField, ObservableMap<String, Integer> observableMap) {
        super(context, i);
        this.f11520b = list;
        this.f11519a = observableField;
        this.f11521c = observableMap;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<ActivityTaskTitle> getItemViewModel(ActivityTaskTitle activityTaskTitle) {
        return new y(this.context, activityTaskTitle, this.f11519a, this.f11521c);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<ActivityTaskTitle> listItemViewModel) {
        gVar.a(2, R.layout.item_activity_task_title);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<ActivityTaskTitle>> onResponseListener) {
        int i = 0;
        while (i < this.f11520b.size()) {
            ActivityTaskTitle activityTaskTitle = this.f11520b.get(i);
            if (i == 0) {
                activityTaskTitle.setEnable(false);
            }
            int i2 = i + 1;
            if (i2 == this.f11520b.size()) {
                activityTaskTitle.setLast(true);
            }
            activityTaskTitle.setPosition(i);
            i = i2;
        }
        onResponseListener.onSuccess(this.f11520b);
    }

    public void a(int i) {
        if (getData() == null || getData().isEmpty()) {
            return;
        }
        int i2 = 0;
        while (i2 < getData().size()) {
            getData().get(i2).setEnable(i2 != i);
            i2++;
        }
    }
}
