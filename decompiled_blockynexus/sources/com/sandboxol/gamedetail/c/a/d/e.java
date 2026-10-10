package com.sandboxol.gamedetail.c.a.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.IListLayout;
import com.sandboxol.gamedetail.R;

/* JADX INFO: compiled from: GameDetailShopDataListLayout.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return androidx.databinding.e.a(LayoutInflater.from(context), R.layout.game_detail_shop_list_view, viewGroup, z);
    }
}
