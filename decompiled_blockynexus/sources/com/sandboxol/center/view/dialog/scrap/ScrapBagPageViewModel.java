package com.sandboxol.center.view.dialog.scrap;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapBagPageViewModel extends ListItemViewModel<Integer> {
    public ObservableField<Boolean> isNoData;
    public ScrapBagListModel listModel;

    public ScrapBagPageViewModel(Context context, Integer num, ObservableField<Boolean> observableField, long j, boolean z) {
        super(context, num);
        this.isNoData = new ObservableField<>(false);
        this.listModel = new ScrapBagListModel(context, num.intValue(), observableField, j, z, this.isNoData);
    }
}
