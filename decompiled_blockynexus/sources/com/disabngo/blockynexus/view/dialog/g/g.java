package com.disabngo.blockynexus.view.dialog.g;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.entity.ScrapRequestTargetInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: ScrapRequestItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends ListItemViewModel<ScrapRequestTargetInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<String> f11576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Long> f11577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f11578c;

    public g(Context context, ScrapRequestTargetInfo scrapRequestTargetInfo, ObservableField<Long> observableField, ObservableField<String> observableField2) {
        super(context, scrapRequestTargetInfo);
        this.f11578c = new ReplyCommand(new f(this));
        this.f11577b = observableField;
        this.f11576a = observableField2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public ScrapRequestTargetInfo getItem() {
        return (ScrapRequestTargetInfo) super.getItem();
    }
}
