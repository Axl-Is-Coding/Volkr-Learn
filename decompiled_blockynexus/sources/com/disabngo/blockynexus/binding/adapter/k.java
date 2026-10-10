package com.disabngo.blockynexus.binding.adapter;

import android.widget.BaseAdapter;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.adapter.TribeCreateLabelsAdapter;
import com.disabngo.blockynexus.view.widget.LabelsView;
import java.util.ArrayList;

/* JADX INFO: compiled from: LabelsViewBindingAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    public static void a(LabelsView labelsView, BaseAdapter baseAdapter, LabelsView.a aVar, int i, int i2, int i3) {
        if (baseAdapter == null) {
            baseAdapter = new TribeCreateLabelsAdapter(labelsView.getContext(), new ArrayList());
        }
        labelsView.setData(baseAdapter, aVar, i == 0 ? R.mipmap.ic_tribe_label_add : i, i2, i3);
    }

    public static void a(LabelsView labelsView, Boolean bool) {
        labelsView.setAddViewShow(bool.booleanValue());
    }
}
