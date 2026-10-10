package com.disabngo.blockynexus.view.widget.gameRank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.widget.rv.IListLayout;

/* JADX INFO: compiled from: GameTypeRankingListLayout.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return e.a(LayoutInflater.from(context), R.layout.game_ranking_data_list_view, viewGroup, z);
    }
}
