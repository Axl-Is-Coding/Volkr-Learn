package com.sandboxol.halloween.view.dialog.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.IListLayout;
import com.sandboxol.halloween.R;

/* JADX INFO: compiled from: HalloweenRewardListLayout.java */
/* JADX INFO: loaded from: classes4.dex */
public class d implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return androidx.databinding.e.a(LayoutInflater.from(context), R.layout.halloween_reward_list_layout, viewGroup, z);
    }
}
