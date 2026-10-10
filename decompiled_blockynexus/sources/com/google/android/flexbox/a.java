package com.google.android.flexbox;

import android.view.View;
import java.util.List;

/* JADX INFO: compiled from: FlexContainer.java */
/* JADX INFO: loaded from: classes.dex */
interface a {
    int getAlignContent();

    int getAlignItems();

    int getChildHeightMeasureSpec(int i, int i2, int i3);

    int getChildWidthMeasureSpec(int i, int i2, int i3);

    int getDecorationLengthCrossAxis(View view);

    int getDecorationLengthMainAxis(View view, int i, int i2);

    int getFlexDirection();

    View getFlexItemAt(int i);

    int getFlexItemCount();

    List<c> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    View getReorderedFlexItemAt(int i);

    int getSumOfCrossSize();

    boolean isMainAxisDirectionHorizontal();

    void onNewFlexItemAdded(View view, int i, int i2, c cVar);

    void onNewFlexLineAdded(c cVar);

    void setFlexLines(List<c> list);

    void updateViewCache(int i, View view);
}
