package com.disabngo.blockynexus.e.b.x;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.widget.rv.IListLayout;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.x.C, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FriendListLayout.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0935C implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return androidx.databinding.e.a(LayoutInflater.from(context), R.layout.friend_list_view, viewGroup, z);
    }
}
