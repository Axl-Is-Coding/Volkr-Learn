package com.disabngo.blockynexus.e.b.ua;

import android.content.Context;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import rx.functions.Action1;

/* JADX INFO: compiled from: TribeTaskViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class s extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Integer> f10239b = new ObservableField<>(Integer.valueOf(R.id.tbTribe));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Integer> f10240c = new ObservableField<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<String> f10241d = new ObservableField<>("");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> f10242e = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.ua.e
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f10207a.a((RadioGroupBindingAdapters.CheckedDataWrapper) obj);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableList<r> f10243f = new ObservableArrayList();
    public me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<r>> g = me.tatarka.bindingcollectionadapter2.g.a(new me.tatarka.bindingcollectionadapter2.l() { // from class: com.disabngo.blockynexus.e.b.ua.c
        @Override // me.tatarka.bindingcollectionadapter2.l
        public final void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, Object obj) {
            this.f10205a.bindView(gVar, i, (ListItemViewModel) obj);
        }
    });
    public ReplyCommand<Integer> h = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.ua.d
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f10206a.b(((Integer) obj).intValue());
        }
    });

    public s(Context context) {
        this.f10238a = context;
        this.f10243f.add(new r(context, 0, this.f10241d));
        this.f10243f.add(new r(context, 1, null));
        b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (i == 0) {
            this.f10239b.set(Integer.valueOf(R.id.tbTribe));
            ReportDataAdapter.onEvent(this.f10238a, EventConstant.CLAN_TASK_GROUP);
        } else if (i == 1) {
            this.f10239b.set(Integer.valueOf(R.id.tbPersonal));
            ReportDataAdapter.onEvent(this.f10238a, EventConstant.CLAN_TASK_PERSONAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindView(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<r> listItemViewModel) {
        gVar.a(332, R.layout.content_tribe_task_page);
    }

    public /* synthetic */ void a(RadioGroupBindingAdapters.CheckedDataWrapper checkedDataWrapper) {
        this.f10239b.set(Integer.valueOf(checkedDataWrapper.getCheckedId()));
        if (checkedDataWrapper.getCheckedId() == R.id.tbTribe) {
            this.f10240c.set(0);
        } else if (checkedDataWrapper.getCheckedId() == R.id.tbPersonal) {
            this.f10240c.set(1);
        }
    }
}
