package com.sandboxol.common.binding.adapter;

import com.sandboxol.common.command.ReplyCommand;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: classes3.dex */
public class SmartRefreshLayoutBindingAdapters {
    static /* synthetic */ void a(ReplyCommand replyCommand, SmartRefreshLayout smartRefreshLayout, com.scwang.smartrefresh.layout.a.j jVar) {
        if (replyCommand != null) {
            replyCommand.execute();
            smartRefreshLayout.finishRefresh(500, true, false);
        }
    }

    public static void onEnableRefresh(SmartRefreshLayout smartRefreshLayout, boolean z) {
        smartRefreshLayout.setEnableRefresh(z);
    }

    public static void onLoadMore(SmartRefreshLayout smartRefreshLayout, boolean z) {
        smartRefreshLayout.setEnableLoadMore(z);
    }

    public static void onLoadMoreCommand(final SmartRefreshLayout smartRefreshLayout, final ReplyCommand<Integer> replyCommand, final boolean z) {
        smartRefreshLayout.setNoMoreData(!z);
        smartRefreshLayout.setOnLoadMoreListener(new com.scwang.smartrefresh.layout.b.b() { // from class: com.sandboxol.common.binding.adapter.k
            @Override // com.scwang.smartrefresh.layout.b.b
            public final void a(com.scwang.smartrefresh.layout.a.j jVar) {
                SmartRefreshLayoutBindingAdapters.a(replyCommand, smartRefreshLayout, z, jVar);
            }
        });
    }

    public static void onRefreshCommand(final SmartRefreshLayout smartRefreshLayout, final ReplyCommand replyCommand, boolean z) {
        smartRefreshLayout.setOnRefreshListener(new com.scwang.smartrefresh.layout.b.d() { // from class: com.sandboxol.common.binding.adapter.j
            @Override // com.scwang.smartrefresh.layout.b.d
            public final void b(com.scwang.smartrefresh.layout.a.j jVar) {
                SmartRefreshLayoutBindingAdapters.a(replyCommand, smartRefreshLayout, jVar);
            }
        });
    }

    static /* synthetic */ void a(ReplyCommand replyCommand, SmartRefreshLayout smartRefreshLayout, boolean z, com.scwang.smartrefresh.layout.a.j jVar) {
        if (replyCommand != null) {
            replyCommand.execute(0);
            smartRefreshLayout.finishLoadMore(500, true, !z);
        }
    }
}
