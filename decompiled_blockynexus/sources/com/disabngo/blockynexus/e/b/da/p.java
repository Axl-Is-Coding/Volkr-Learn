package com.disabngo.blockynexus.e.b.da;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import java.util.Map;

/* JADX INFO: compiled from: ScrapPageViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class p extends ListItemViewModel<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f9721a;

    public p(Context context, ObservableField<Boolean> observableField, Integer num, Map<Integer, Boolean> map, int i) {
        super(context, num);
        this.f9721a = new l(context, observableField, num.intValue(), map, i, R.string.no_data);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public Integer getItem() {
        return (Integer) super.getItem();
    }
}
