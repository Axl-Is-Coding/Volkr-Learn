package com.sandboxol.vip.d.a.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.IListLayout;
import com.sandboxol.vip.R;

/* JADX INFO: compiled from: SubscribeBottomListLayout.java */
/* JADX INFO: loaded from: classes4.dex */
public class l implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return androidx.databinding.e.a(LayoutInflater.from(context), R.layout.vip_list_layout_subscribe_bottom, viewGroup, z);
    }
}
