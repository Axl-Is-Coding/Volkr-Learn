package com.sandboxol.googlepay.c.a.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.IListLayout;
import com.sandboxol.googlepay.R;

/* JADX INFO: compiled from: RechargeHistoryListLayout.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return androidx.databinding.e.a(LayoutInflater.from(context), R.layout.recharge_history_data_list_view, viewGroup, z);
    }
}
