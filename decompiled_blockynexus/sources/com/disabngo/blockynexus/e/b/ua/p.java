package com.disabngo.blockynexus.e.b.ua;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeTask;
import com.disabngo.blockynexus.entity.TribeTaskList;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TribeTaskPageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class p extends DataListModel<TribeTaskList> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObservableField<Integer> f10224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ObservableField<Boolean> f10225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ObservableField<Integer> f10226e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ObservableField<Integer> f10227f;
    private ObservableField<Long> g;

    public p(Context context, int i, int i2, ObservableField<Integer> observableField, ObservableField<Boolean> observableField2, ObservableField<Integer> observableField3, ObservableField<Integer> observableField4, ObservableField<Long> observableField5) {
        super(context, i);
        this.f10223b = 0;
        this.f10222a = i2;
        this.f10224c = observableField;
        this.f10225d = observableField2;
        this.f10226e = observableField3;
        this.f10227f = observableField4;
        this.g = observableField5;
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_TRIBE_TASK_REFRESH + this.f10222a;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<TribeTaskList> listItemViewModel) {
        gVar.a(2, R.layout.item_tribe_task);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<TribeTaskList>> onResponseListener) {
        int i = this.f10222a;
        if (i == 0) {
            b(this.f10223b, this.f10224c, onResponseListener);
            if (this.f10223b == 1) {
                ReportDataAdapter.onEvent(this.context, EventConstant.CLAN_TASK_GROUP_REFRESH);
                return;
            }
            return;
        }
        if (i != 1) {
            return;
        }
        a(this.f10223b, this.f10224c, onResponseListener);
        if (this.f10223b == 1) {
            ReportDataAdapter.onEvent(this.context, EventConstant.CLAN_TASK_PERSONAL_REFRESH);
        }
    }

    public void b(int i, ObservableField<Integer> observableField, OnResponseListener<List<TribeTaskList>> onResponseListener) {
        this.f10225d.set(true);
        TribeApi.getTribeTask(this.context, i, new n(this, onResponseListener, observableField, i));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<TribeTaskList> getItemViewModel(TribeTaskList tribeTaskList) {
        return new m(this.context, tribeTaskList, this.f10222a);
    }

    public void a(int i) {
        this.f10223b = i;
    }

    public void a(int i, ObservableField<Integer> observableField, OnResponseListener<List<TribeTaskList>> onResponseListener) {
        this.f10225d.set(true);
        TribeApi.getPersonTask(this.context, i, new o(this, onResponseListener, observableField, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TribeTaskList> a(TribeTask tribeTask) {
        Iterator<TribeTaskList> it = tribeTask.getTasks().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TribeTaskList next = it.next();
            if (next.getTaskId() == 0) {
                it.remove();
                tribeTask.getTasks().add(0, next);
                break;
            }
        }
        return tribeTask.getTasks();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TribeTask tribeTask, ObservableField<Integer> observableField) {
        observableField.set(Integer.valueOf(tribeTask.getNextFreeFlushTime()));
        this.f10226e.set(Integer.valueOf(tribeTask.getCurrencyType()));
        this.f10227f.set(Integer.valueOf(tribeTask.getCurrencyCost()));
        ObservableField<Long> observableField2 = this.g;
        if (observableField2 != null) {
            observableField2.set(Long.valueOf(tribeTask.getRemainTime()));
        }
    }
}
