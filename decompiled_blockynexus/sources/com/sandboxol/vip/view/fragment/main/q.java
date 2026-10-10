package com.sandboxol.vip.view.fragment.main;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import rx.functions.Action0;

/* JADX INFO: compiled from: PrivilegeCenterPageViewModel.java */
/* JADX INFO: loaded from: classes4.dex */
public class q extends ListItemViewModel<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Boolean> f19104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<String> f19105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f19106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f19107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f19108e;

    public q(Context context, Integer num, ObservableField<Boolean> observableField, ObservableField<String> observableField2, ObservableField<Boolean> observableField3, ObservableField<Boolean> observableField4) {
        super(context, num);
        this.f19108e = new ReplyCommand(new Action0() { // from class: com.sandboxol.vip.view.fragment.main.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f19089a.f();
            }
        });
        this.f19104a = observableField;
        this.f19105b = observableField2;
        this.f19106c = observableField3;
        this.f19107d = observableField4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        new com.sandboxol.vip.d.a.a.j(this.context, this.f19104a.get().booleanValue(), ((Integer) this.item).intValue(), false).show();
        ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_VIP, String.valueOf(this.item));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public Integer getItem() {
        return (Integer) super.getItem();
    }
}
