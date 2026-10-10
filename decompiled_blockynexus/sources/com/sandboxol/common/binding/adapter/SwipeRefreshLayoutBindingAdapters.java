package com.sandboxol.common.binding.adapter;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class SwipeRefreshLayoutBindingAdapters {
    static /* synthetic */ void a(ReplyCommand replyCommand) {
        if (replyCommand != null) {
            replyCommand.execute();
        }
    }

    public static void onRefreshCommand(SwipeRefreshLayout swipeRefreshLayout, final ReplyCommand replyCommand) {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.b() { // from class: com.sandboxol.common.binding.adapter.l
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.b
            public final void onRefresh() {
                SwipeRefreshLayoutBindingAdapters.a(replyCommand);
            }
        });
    }

    public static void setRefreshing(SwipeRefreshLayout swipeRefreshLayout, boolean z) {
        swipeRefreshLayout.setRefreshing(z);
    }

    public static void setenable(SwipeRefreshLayout swipeRefreshLayout, boolean z) {
        swipeRefreshLayout.setEnabled(z);
    }
}
