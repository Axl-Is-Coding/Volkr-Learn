package com.sandboxol.common.widget.rv.helper;

import android.widget.AbsListView;
import android.widget.ListView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: classes3.dex */
public class ItemEnterOrExitVisibleHelper {
    private int lastEnd;
    private OnScrollStatusListener listener;
    private int lastStart = -1;
    private AbsListView.OnScrollListener listiewScrollListener = new AbsListView.OnScrollListener() { // from class: com.sandboxol.common.widget.rv.helper.ItemEnterOrExitVisibleHelper.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ItemEnterOrExitVisibleHelper.this.dealScrollEvent(absListView.getFirstVisiblePosition(), absListView.getLastVisiblePosition());
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    };
    private RecyclerView.m recyclerScrollListener = new RecyclerView.m() { // from class: com.sandboxol.common.widget.rv.helper.ItemEnterOrExitVisibleHelper.2
        @Override // androidx.recyclerview.widget.RecyclerView.m
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
            if (staggeredGridLayoutManager != null) {
                int[] iArr = new int[staggeredGridLayoutManager.g()];
                if (iArr.length > 1) {
                    int i3 = staggeredGridLayoutManager.a(iArr)[0];
                    int i4 = staggeredGridLayoutManager.b(iArr)[iArr.length - 1];
                    int i5 = i4 - i3;
                    if (i4 == 0) {
                        i5 = 0;
                    }
                    if (i5 != 0) {
                        ItemEnterOrExitVisibleHelper.this.dealScrollEvent(i3, i4);
                    }
                }
            }
        }
    };

    public interface OnScrollStatusListener {
        void onSelectEnterPosition(int i);

        void onSelectExitPosition(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealScrollEvent(int i, int i2) {
        if (i2 - i > 0) {
            int i3 = this.lastStart;
            if (i3 == -1) {
                this.lastStart = i;
                this.lastEnd = i2;
                for (int i4 = this.lastStart; i4 < this.lastEnd + 1; i4++) {
                    OnScrollStatusListener onScrollStatusListener = this.listener;
                    if (onScrollStatusListener != null) {
                        onScrollStatusListener.onSelectEnterPosition(i4);
                    }
                }
                return;
            }
            if (i != i3) {
                if (i > i3) {
                    while (i3 < i) {
                        OnScrollStatusListener onScrollStatusListener2 = this.listener;
                        if (onScrollStatusListener2 != null) {
                            onScrollStatusListener2.onSelectExitPosition(i3);
                        }
                        i3++;
                    }
                } else {
                    for (int i5 = i; i5 < this.lastStart; i5++) {
                        OnScrollStatusListener onScrollStatusListener3 = this.listener;
                        if (onScrollStatusListener3 != null) {
                            onScrollStatusListener3.onSelectEnterPosition(i5);
                        }
                    }
                }
                this.lastStart = i;
            }
            int i6 = this.lastEnd;
            if (i2 != i6) {
                if (i2 > i6) {
                    while (i6 < i2) {
                        OnScrollStatusListener onScrollStatusListener4 = this.listener;
                        if (onScrollStatusListener4 != null) {
                            onScrollStatusListener4.onSelectEnterPosition(i6 + 1);
                        }
                        i6++;
                    }
                } else {
                    for (int i7 = i2; i7 < this.lastEnd; i7++) {
                        OnScrollStatusListener onScrollStatusListener5 = this.listener;
                        if (onScrollStatusListener5 != null) {
                            onScrollStatusListener5.onSelectExitPosition(i7 + 1);
                        }
                    }
                }
                this.lastEnd = i2;
            }
        }
    }

    public AbsListView.OnScrollListener getListiewScrollListener() {
        return this.listiewScrollListener;
    }

    public RecyclerView.m getRecyclerScrollListener() {
        return this.recyclerScrollListener;
    }

    public void setListiewScrollListener(ListView listView) {
        listView.setOnScrollListener(this.listiewScrollListener);
    }

    public void setOnScrollStatusListener(OnScrollStatusListener onScrollStatusListener) {
        this.listener = onScrollStatusListener;
    }

    public void setRecyclerScrollListener(RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(this.recyclerScrollListener);
    }
}
