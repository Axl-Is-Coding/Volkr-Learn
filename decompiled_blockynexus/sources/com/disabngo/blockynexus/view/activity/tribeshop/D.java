package com.disabngo.blockynexus.view.activity.tribeshop;

import android.content.Context;
import androidx.databinding.ObservableMap;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeShopPageList;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;

/* JADX INFO: compiled from: TribeShopPageViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class D extends ListItemViewModel<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C f11158a;
    private Context context;

    public D(Context context, int i, ObservableMap<Long, String> observableMap, ObservableMap<Long, String> observableMap2, ObservableMap<Long, TribeShopPageList> observableMap3) {
        super(context, Integer.valueOf(i));
        this.context = context;
        this.f11158a = new C(context, R.string.tribe_not_goods, i, observableMap, observableMap2, observableMap3);
    }
}
