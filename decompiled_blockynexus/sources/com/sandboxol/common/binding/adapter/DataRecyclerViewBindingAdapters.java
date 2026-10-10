package com.sandboxol.common.binding.adapter;

import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.IListLayout;
import com.sandboxol.common.widget.rv.datarv.DataListLayout;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import me.tatarka.bindingcollectionadapter2.k;

/* JADX INFO: loaded from: classes3.dex */
public class DataRecyclerViewBindingAdapters {
    public static void setDataRecyclerView(DataRecyclerView dataRecyclerView, IListLayout iListLayout, DataListModel dataListModel, k.a aVar, boolean z, ReplyCommand<Integer> replyCommand, boolean z2, int i, boolean z3) {
        if (iListLayout == null) {
            dataRecyclerView.setListLayout(new DataListLayout());
        } else {
            dataRecyclerView.setListLayout(iListLayout);
        }
        dataRecyclerView.setModel(dataListModel, z);
        if (aVar == null) {
            dataRecyclerView.setLayoutFactory(me.tatarka.bindingcollectionadapter2.k.a());
        } else {
            dataRecyclerView.setLayoutFactory(aVar);
        }
        if (replyCommand != null) {
            dataRecyclerView.lastVisibleListener(replyCommand);
        }
        dataRecyclerView.setNestedScrollingEnabled(z2);
        if (i != 0) {
            dataRecyclerView.setItemViewCacheSize(i);
        }
        dataRecyclerView.disableSetItem(z3);
    }
}
