package com.sandboxol.blocky.dialog.scrapanim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.common.widget.rv.IListLayout;
import com.sandboxol.game.R;

/* JADX INFO: loaded from: classes.dex */
public class ScrapAnimListLayout implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return e.a(LayoutInflater.from(context), R.layout.dialog_scrap_anim_list_view, viewGroup, z);
    }
}
