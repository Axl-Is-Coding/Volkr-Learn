package com.disabngo.blockynexus.e.b.K;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.entity.HelpDetailInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action0;

/* JADX INFO: compiled from: HelpDetailItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends ListItemViewModel<HelpDetailInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Boolean> f9326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Boolean> f9327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f9328c;

    public e(Context context, HelpDetailInfo helpDetailInfo) {
        super(context, helpDetailInfo);
        this.f9326a = new ObservableField<>(true);
        this.f9327b = new ObservableField<>(false);
        this.f9328c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.K.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f9323a.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f9327b.set(this.f9326a.get());
        this.f9326a.set(Boolean.valueOf(!r0.get().booleanValue()));
    }
}
