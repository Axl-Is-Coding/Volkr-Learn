package com.sandboxol.gamedetail.c.a.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.IListLayout;
import com.sandboxol.gamedetail.R;

/* JADX INFO: compiled from: GameDetailRankPageListLayout.java */
/* JADX INFO: loaded from: classes3.dex */
public class j implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return androidx.databinding.e.a(LayoutInflater.from(context), R.layout.game_detail_rank_page_list_view, viewGroup, z);
    }
}
