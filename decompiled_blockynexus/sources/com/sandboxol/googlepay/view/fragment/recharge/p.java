package com.sandboxol.googlepay.view.fragment.recharge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.IListLayout;
import com.sandboxol.googlepay.R;

/* JADX INFO: compiled from: RechargeListLayout.java */
/* JADX INFO: loaded from: classes3.dex */
public class p implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return androidx.databinding.e.a(LayoutInflater.from(context), R.layout.recharge_data_list_view, viewGroup, z);
    }
}
