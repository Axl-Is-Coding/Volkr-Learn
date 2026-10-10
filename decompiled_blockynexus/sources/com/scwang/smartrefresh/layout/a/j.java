package com.scwang.smartrefresh.layout.a;

import android.view.ViewGroup;

/* JADX INFO: compiled from: RefreshLayout.java */
/* JADX INFO: loaded from: classes.dex */
public interface j {
    ViewGroup getLayout();

    j setDragRate(float f2);

    j setEnableAutoLoadMore(boolean z);

    j setEnableFooterTranslationContent(boolean z);

    j setEnableNestedScroll(boolean z);

    j setFooterMaxDragRate(float f2);

    j setHeaderMaxDragRate(float f2);
}
