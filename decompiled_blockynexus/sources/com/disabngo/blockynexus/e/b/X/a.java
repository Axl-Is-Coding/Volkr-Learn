package com.disabngo.blockynexus.e.b.X;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.widget.rv.IListLayout;

/* JADX INFO: compiled from: GameListLayout.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return e.a(LayoutInflater.from(context), R.layout.recommend_game_list_view, viewGroup, z);
    }
}
