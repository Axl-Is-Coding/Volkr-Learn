package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.flexbox.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FlexboxLayout extends ViewGroup implements a {
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    private int mAlignContent;
    private int mAlignItems;
    private Drawable mDividerDrawableHorizontal;
    private Drawable mDividerDrawableVertical;
    private int mDividerHorizontalHeight;
    private int mDividerVerticalWidth;
    private int mFlexDirection;
    private List<c> mFlexLines;
    private e.a mFlexLinesResult;
    private int mFlexWrap;
    private e mFlexboxHelper;
    private int mJustifyContent;
    private int mMaxLine;
    private SparseIntArray mOrderCache;
    private int[] mReorderedIndices;
    private int mShowDividerHorizontal;
    private int mShowDividerVertical;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    private boolean allFlexLinesAreDummyBefore(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.mFlexLines.get(i2).c() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean allViewsAreGoneBefore(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View reorderedChildAt = getReorderedChildAt(i - i3);
            if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private void drawDividersHorizontal(Canvas canvas, boolean z, boolean z2) {
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.mFlexLines.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.mFlexLines.get(i);
            for (int i2 = 0; i2 < cVar.h; i2++) {
                int i3 = cVar.o + i2;
                View reorderedChildAt = getReorderedChildAt(i3);
                if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (hasDividerBeforeChildAtAlongMainAxis(i3, i2)) {
                        drawVerticalDivider(canvas, z ? reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : (reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.mDividerVerticalWidth, cVar.f13063b, cVar.g);
                    }
                    if (i2 == cVar.h - 1 && (this.mShowDividerVertical & 4) > 0) {
                        drawVerticalDivider(canvas, z ? (reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.mDividerVerticalWidth : reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, cVar.f13063b, cVar.g);
                    }
                }
            }
            if (hasDividerBeforeFlexLine(i)) {
                drawHorizontalDivider(canvas, paddingLeft, z2 ? cVar.f13065d : cVar.f13063b - this.mDividerHorizontalHeight, iMax);
            }
            if (hasEndDividerAfterFlexLine(i) && (this.mShowDividerHorizontal & 4) > 0) {
                drawHorizontalDivider(canvas, paddingLeft, z2 ? cVar.f13063b - this.mDividerHorizontalHeight : cVar.f13065d, iMax);
            }
        }
    }

    private void drawDividersVertical(Canvas canvas, boolean z, boolean z2) {
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.mFlexLines.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.mFlexLines.get(i);
            for (int i2 = 0; i2 < cVar.h; i2++) {
                int i3 = cVar.o + i2;
                View reorderedChildAt = getReorderedChildAt(i3);
                if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (hasDividerBeforeChildAtAlongMainAxis(i3, i2)) {
                        drawHorizontalDivider(canvas, cVar.f13062a, z2 ? reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : (reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.mDividerHorizontalHeight, cVar.g);
                    }
                    if (i2 == cVar.h - 1 && (this.mShowDividerHorizontal & 4) > 0) {
                        drawHorizontalDivider(canvas, cVar.f13062a, z2 ? (reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.mDividerHorizontalHeight : reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, cVar.g);
                    }
                }
            }
            if (hasDividerBeforeFlexLine(i)) {
                drawVerticalDivider(canvas, z ? cVar.f13064c : cVar.f13062a - this.mDividerVerticalWidth, paddingTop, iMax);
            }
            if (hasEndDividerAfterFlexLine(i) && (this.mShowDividerVertical & 4) > 0) {
                drawVerticalDivider(canvas, z ? cVar.f13062a - this.mDividerVerticalWidth : cVar.f13064c, paddingTop, iMax);
            }
        }
    }

    private void drawHorizontalDivider(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.mDividerDrawableHorizontal;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, i3 + i, this.mDividerHorizontalHeight + i2);
        this.mDividerDrawableHorizontal.draw(canvas);
    }

    private void drawVerticalDivider(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.mDividerDrawableVertical;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, this.mDividerVerticalWidth + i, i3 + i2);
        this.mDividerDrawableVertical.draw(canvas);
    }

    private boolean hasDividerBeforeChildAtAlongMainAxis(int i, int i2) {
        return allViewsAreGoneBefore(i, i2) ? isMainAxisDirectionHorizontal() ? (this.mShowDividerVertical & 1) != 0 : (this.mShowDividerHorizontal & 1) != 0 : isMainAxisDirectionHorizontal() ? (this.mShowDividerVertical & 2) != 0 : (this.mShowDividerHorizontal & 2) != 0;
    }

    private boolean hasDividerBeforeFlexLine(int i) {
        if (i < 0 || i >= this.mFlexLines.size()) {
            return false;
        }
        return allFlexLinesAreDummyBefore(i) ? isMainAxisDirectionHorizontal() ? (this.mShowDividerHorizontal & 1) != 0 : (this.mShowDividerVertical & 1) != 0 : isMainAxisDirectionHorizontal() ? (this.mShowDividerHorizontal & 2) != 0 : (this.mShowDividerVertical & 2) != 0;
    }

    private boolean hasEndDividerAfterFlexLine(int i) {
        if (i < 0 || i >= this.mFlexLines.size()) {
            return false;
        }
        for (int i2 = i + 1; i2 < this.mFlexLines.size(); i2++) {
            if (this.mFlexLines.get(i2).c() > 0) {
                return false;
            }
        }
        return isMainAxisDirectionHorizontal() ? (this.mShowDividerHorizontal & 4) != 0 : (this.mShowDividerVertical & 4) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void layoutHorizontal(boolean r29, int r30, int r31, int r32, int r33) {
        /*
            Method dump skipped, instruction units count: 553
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.layoutHorizontal(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void layoutVertical(boolean r30, boolean r31, int r32, int r33, int r34, int r35) {
        /*
            Method dump skipped, instruction units count: 541
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.layoutVertical(boolean, boolean, int, int, int, int):void");
    }

    private void measureHorizontal(int i, int i2) {
        this.mFlexLines.clear();
        this.mFlexLinesResult.a();
        this.mFlexboxHelper.a(this.mFlexLinesResult, i, i2);
        this.mFlexLines = this.mFlexLinesResult.f13073a;
        this.mFlexboxHelper.a(i, i2);
        if (this.mAlignItems == 3) {
            for (c cVar : this.mFlexLines) {
                int iMax = Integer.MIN_VALUE;
                for (int i3 = 0; i3 < cVar.h; i3++) {
                    View reorderedChildAt = getReorderedChildAt(cVar.o + i3);
                    if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                        LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                        iMax = this.mFlexWrap != 2 ? Math.max(iMax, reorderedChildAt.getMeasuredHeight() + Math.max(cVar.l - reorderedChildAt.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) : Math.max(iMax, reorderedChildAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + Math.max((cVar.l - reorderedChildAt.getMeasuredHeight()) + reorderedChildAt.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                    }
                }
                cVar.g = iMax;
            }
        }
        this.mFlexboxHelper.a(i, i2, getPaddingTop() + getPaddingBottom());
        this.mFlexboxHelper.a();
        setMeasuredDimensionForFlex(this.mFlexDirection, i, i2, this.mFlexLinesResult.f13074b);
    }

    private void measureVertical(int i, int i2) {
        this.mFlexLines.clear();
        this.mFlexLinesResult.a();
        this.mFlexboxHelper.b(this.mFlexLinesResult, i, i2);
        this.mFlexLines = this.mFlexLinesResult.f13073a;
        this.mFlexboxHelper.a(i, i2);
        this.mFlexboxHelper.a(i, i2, getPaddingLeft() + getPaddingRight());
        this.mFlexboxHelper.a();
        setMeasuredDimensionForFlex(this.mFlexDirection, i, i2, this.mFlexLinesResult.f13074b);
    }

    private void setMeasuredDimensionForFlex(int i, int i2, int i3, int i4) {
        int sumOfCrossSize;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (i == 0 || i == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else {
            if (i != 2 && i != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + i);
            }
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i2, i4);
        } else {
            if (mode != 1073741824) {
                throw new IllegalStateException("Unknown width mode is set: " + mode);
            }
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
                sumOfCrossSize = size2;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i3, i4);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i3, i4);
        } else {
            if (mode2 != 1073741824) {
                throw new IllegalStateException("Unknown height mode is set: " + mode2);
            }
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    private void setWillNotDrawFlag() {
        if (this.mDividerDrawableHorizontal == null && this.mDividerDrawableVertical == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(getChildCount());
        }
        this.mReorderedIndices = this.mFlexboxHelper.a(view, i, layoutParams, this.mOrderCache);
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.mAlignContent;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.mAlignItems;
    }

    @Override // com.google.android.flexbox.a
    public int getChildHeightMeasureSpec(int i, int i2, int i3) {
        return ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.a
    public int getChildWidthMeasureSpec(int i, int i2, int i3) {
        return ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.a
    public int getDecorationLengthCrossAxis(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public int getDecorationLengthMainAxis(View view, int i, int i2) {
        int i3;
        int i4;
        if (isMainAxisDirectionHorizontal()) {
            i3 = hasDividerBeforeChildAtAlongMainAxis(i, i2) ? 0 + this.mDividerVerticalWidth : 0;
            if ((this.mShowDividerVertical & 4) <= 0) {
                return i3;
            }
            i4 = this.mDividerVerticalWidth;
        } else {
            i3 = hasDividerBeforeChildAtAlongMainAxis(i, i2) ? 0 + this.mDividerHorizontalHeight : 0;
            if ((this.mShowDividerHorizontal & 4) <= 0) {
                return i3;
            }
            i4 = this.mDividerHorizontalHeight;
        }
        return i3 + i4;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.mDividerDrawableHorizontal;
    }

    public Drawable getDividerDrawableVertical() {
        return this.mDividerDrawableVertical;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.mFlexDirection;
    }

    @Override // com.google.android.flexbox.a
    public View getFlexItemAt(int i) {
        return getChildAt(i);
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<c> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.mFlexLines.size());
        for (c cVar : this.mFlexLines) {
            if (cVar.c() != 0) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public List<c> getFlexLinesInternal() {
        return this.mFlexLines;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.mFlexWrap;
    }

    public int getJustifyContent() {
        return this.mJustifyContent;
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        Iterator<c> it = this.mFlexLines.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().f13066e);
        }
        return iMax;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.mMaxLine;
    }

    public View getReorderedChildAt(int i) {
        if (i < 0) {
            return null;
        }
        int[] iArr = this.mReorderedIndices;
        if (i >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }

    @Override // com.google.android.flexbox.a
    public View getReorderedFlexItemAt(int i) {
        return getReorderedChildAt(i);
    }

    public int getShowDividerHorizontal() {
        return this.mShowDividerHorizontal;
    }

    public int getShowDividerVertical() {
        return this.mShowDividerVertical;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.mFlexLines.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = this.mFlexLines.get(i2);
            if (hasDividerBeforeFlexLine(i2)) {
                i += isMainAxisDirectionHorizontal() ? this.mDividerHorizontalHeight : this.mDividerVerticalWidth;
            }
            if (hasEndDividerAfterFlexLine(i2)) {
                i += isMainAxisDirectionHorizontal() ? this.mDividerHorizontalHeight : this.mDividerVerticalWidth;
            }
            i += cVar.g;
        }
        return i;
    }

    @Override // com.google.android.flexbox.a
    public boolean isMainAxisDirectionHorizontal() {
        int i = this.mFlexDirection;
        return i == 0 || i == 1;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mDividerDrawableVertical == null && this.mDividerDrawableHorizontal == null) {
            return;
        }
        if (this.mShowDividerHorizontal == 0 && this.mShowDividerVertical == 0) {
            return;
        }
        int iM = ViewCompat.m(this);
        int i = this.mFlexDirection;
        if (i == 0) {
            drawDividersHorizontal(canvas, iM == 1, this.mFlexWrap == 2);
            return;
        }
        if (i == 1) {
            drawDividersHorizontal(canvas, iM != 1, this.mFlexWrap == 2);
            return;
        }
        if (i == 2) {
            boolean z = iM == 1;
            if (this.mFlexWrap == 2) {
                z = !z;
            }
            drawDividersVertical(canvas, z, false);
            return;
        }
        if (i != 3) {
            return;
        }
        boolean z2 = iM == 1;
        if (this.mFlexWrap == 2) {
            z2 = !z2;
        }
        drawDividersVertical(canvas, z2, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        int iM = ViewCompat.m(this);
        int i5 = this.mFlexDirection;
        if (i5 == 0) {
            layoutHorizontal(iM == 1, i, i2, i3, i4);
            return;
        }
        if (i5 == 1) {
            layoutHorizontal(iM != 1, i, i2, i3, i4);
            return;
        }
        if (i5 == 2) {
            z2 = iM == 1;
            layoutVertical(this.mFlexWrap == 2 ? !z2 : z2, false, i, i2, i3, i4);
        } else if (i5 == 3) {
            z2 = iM == 1;
            layoutVertical(this.mFlexWrap == 2 ? !z2 : z2, true, i, i2, i3, i4);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.mFlexDirection);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(getChildCount());
        }
        if (this.mFlexboxHelper.b(this.mOrderCache)) {
            this.mReorderedIndices = this.mFlexboxHelper.a(this.mOrderCache);
        }
        int i3 = this.mFlexDirection;
        if (i3 == 0 || i3 == 1) {
            measureHorizontal(i, i2);
            return;
        }
        if (i3 == 2 || i3 == 3) {
            measureVertical(i, i2);
            return;
        }
        throw new IllegalStateException("Invalid value for the flex direction is set: " + this.mFlexDirection);
    }

    @Override // com.google.android.flexbox.a
    public void onNewFlexItemAdded(View view, int i, int i2, c cVar) {
        if (hasDividerBeforeChildAtAlongMainAxis(i, i2)) {
            if (isMainAxisDirectionHorizontal()) {
                int i3 = cVar.f13066e;
                int i4 = this.mDividerVerticalWidth;
                cVar.f13066e = i3 + i4;
                cVar.f13067f += i4;
                return;
            }
            int i5 = cVar.f13066e;
            int i6 = this.mDividerHorizontalHeight;
            cVar.f13066e = i5 + i6;
            cVar.f13067f += i6;
        }
    }

    @Override // com.google.android.flexbox.a
    public void onNewFlexLineAdded(c cVar) {
        if (isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerVertical & 4) > 0) {
                int i = cVar.f13066e;
                int i2 = this.mDividerVerticalWidth;
                cVar.f13066e = i + i2;
                cVar.f13067f += i2;
                return;
            }
            return;
        }
        if ((this.mShowDividerHorizontal & 4) > 0) {
            int i3 = cVar.f13066e;
            int i4 = this.mDividerHorizontalHeight;
            cVar.f13066e = i3 + i4;
            cVar.f13067f += i4;
        }
    }

    public void setAlignContent(int i) {
        if (this.mAlignContent != i) {
            this.mAlignContent = i;
            requestLayout();
        }
    }

    public void setAlignItems(int i) {
        if (this.mAlignItems != i) {
            this.mAlignItems = i;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.mDividerDrawableHorizontal) {
            return;
        }
        this.mDividerDrawableHorizontal = drawable;
        if (drawable != null) {
            this.mDividerHorizontalHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerHorizontalHeight = 0;
        }
        setWillNotDrawFlag();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.mDividerDrawableVertical) {
            return;
        }
        this.mDividerDrawableVertical = drawable;
        if (drawable != null) {
            this.mDividerVerticalWidth = drawable.getIntrinsicWidth();
        } else {
            this.mDividerVerticalWidth = 0;
        }
        setWillNotDrawFlag();
        requestLayout();
    }

    public void setFlexDirection(int i) {
        if (this.mFlexDirection != i) {
            this.mFlexDirection = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<c> list) {
        this.mFlexLines = list;
    }

    public void setFlexWrap(int i) {
        if (this.mFlexWrap != i) {
            this.mFlexWrap = i;
            requestLayout();
        }
    }

    public void setJustifyContent(int i) {
        if (this.mJustifyContent != i) {
            this.mJustifyContent = i;
            requestLayout();
        }
    }

    public void setMaxLine(int i) {
        if (this.mMaxLine != i) {
            this.mMaxLine = i;
            requestLayout();
        }
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.mShowDividerHorizontal) {
            this.mShowDividerHorizontal = i;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i) {
        if (i != this.mShowDividerVertical) {
            this.mShowDividerVertical = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public void updateViewCache(int i, View view) {
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxLine = -1;
        this.mFlexboxHelper = new e(this);
        this.mFlexLines = new ArrayList();
        this.mFlexLinesResult = new e.a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout, i, 0);
        this.mFlexDirection = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexDirection, 0);
        this.mFlexWrap = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexWrap, 0);
        this.mJustifyContent = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_justifyContent, 0);
        this.mAlignItems = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignItems, 0);
        this.mAlignContent = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignContent, 0);
        this.mMaxLine = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDivider, 0);
        if (i2 != 0) {
            this.mShowDividerVertical = i2;
            this.mShowDividerHorizontal = i2;
        }
        int i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.mShowDividerVertical = i3;
        }
        int i4 = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.mShowDividerHorizontal = i4;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements b {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new f();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f13034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f13035b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f13036c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f13037d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f13038e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f13039f;
        private int g;
        private int h;
        private int i;
        private boolean j;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f13034a = 1;
            this.f13035b = WheelView.DividerConfig.FILL;
            this.f13036c = 1.0f;
            this.f13037d = -1;
            this.f13038e = -1.0f;
            this.f13039f = -1;
            this.g = -1;
            this.h = 16777215;
            this.i = 16777215;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout_Layout);
            this.f13034a = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_order, 1);
            this.f13035b = typedArrayObtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexGrow, WheelView.DividerConfig.FILL);
            this.f13036c = typedArrayObtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.f13037d = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.f13038e = typedArrayObtainStyledAttributes.getFraction(R.styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.f13039f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minWidth, -1);
            this.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minHeight, -1);
            this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.j = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // com.google.android.flexbox.b
        public void a(int i) {
            this.g = i;
        }

        @Override // com.google.android.flexbox.b
        public int d() {
            return this.f13037d;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.b
        public float g() {
            return this.f13036c;
        }

        @Override // com.google.android.flexbox.b
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.b
        public int getOrder() {
            return this.f13034a;
        }

        @Override // com.google.android.flexbox.b
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.b
        public int n() {
            return this.f13039f;
        }

        @Override // com.google.android.flexbox.b
        public int o() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.b
        public float q() {
            return this.f13035b;
        }

        @Override // com.google.android.flexbox.b
        public float r() {
            return this.f13038e;
        }

        @Override // com.google.android.flexbox.b
        public boolean s() {
            return this.j;
        }

        @Override // com.google.android.flexbox.b
        public void setMinWidth(int i) {
            this.f13039f = i;
        }

        @Override // com.google.android.flexbox.b
        public int t() {
            return this.h;
        }

        @Override // com.google.android.flexbox.b
        public int v() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.b
        public int w() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f13034a);
            parcel.writeFloat(this.f13035b);
            parcel.writeFloat(this.f13036c);
            parcel.writeInt(this.f13037d);
            parcel.writeFloat(this.f13038e);
            parcel.writeInt(this.f13039f);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h);
            parcel.writeInt(this.i);
            parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.google.android.flexbox.b
        public int x() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.b
        public int y() {
            return this.g;
        }

        @Override // com.google.android.flexbox.b
        public int z() {
            return this.i;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f13034a = 1;
            this.f13035b = WheelView.DividerConfig.FILL;
            this.f13036c = 1.0f;
            this.f13037d = -1;
            this.f13038e = -1.0f;
            this.f13039f = -1;
            this.g = -1;
            this.h = 16777215;
            this.i = 16777215;
            this.f13034a = layoutParams.f13034a;
            this.f13035b = layoutParams.f13035b;
            this.f13036c = layoutParams.f13036c;
            this.f13037d = layoutParams.f13037d;
            this.f13038e = layoutParams.f13038e;
            this.f13039f = layoutParams.f13039f;
            this.g = layoutParams.g;
            this.h = layoutParams.h;
            this.i = layoutParams.i;
            this.j = layoutParams.j;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f13034a = 1;
            this.f13035b = WheelView.DividerConfig.FILL;
            this.f13036c = 1.0f;
            this.f13037d = -1;
            this.f13038e = -1.0f;
            this.f13039f = -1;
            this.g = -1;
            this.h = 16777215;
            this.i = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f13034a = 1;
            this.f13035b = WheelView.DividerConfig.FILL;
            this.f13036c = 1.0f;
            this.f13037d = -1;
            this.f13038e = -1.0f;
            this.f13039f = -1;
            this.g = -1;
            this.h = 16777215;
            this.i = 16777215;
        }

        protected LayoutParams(Parcel parcel) {
            super(0, 0);
            this.f13034a = 1;
            this.f13035b = WheelView.DividerConfig.FILL;
            this.f13036c = 1.0f;
            this.f13037d = -1;
            this.f13038e = -1.0f;
            this.f13039f = -1;
            this.g = -1;
            this.h = 16777215;
            this.i = 16777215;
            this.f13034a = parcel.readInt();
            this.f13035b = parcel.readFloat();
            this.f13036c = parcel.readFloat();
            this.f13037d = parcel.readInt();
            this.f13038e = parcel.readFloat();
            this.f13039f = parcel.readInt();
            this.g = parcel.readInt();
            this.h = parcel.readInt();
            this.i = parcel.readInt();
            this.j = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }
}
