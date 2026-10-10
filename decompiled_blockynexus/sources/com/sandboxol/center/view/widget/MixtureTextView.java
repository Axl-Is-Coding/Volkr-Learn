package com.sandboxol.center.view.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.imkit.utils.FileTypeUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MixtureTextView extends RelativeLayout {
    private static int[] ATTRS = {R.attr.textSize, R.attr.textColor, R.attr.text};
    private static final int INDEX_ATTR_TEXT = 2;
    private static final int INDEX_ATTR_TEXT_COLOR = 1;
    private static final int INDEX_ATTR_TEXT_SIZE = 0;
    private Layout layout;
    private HashSet<Integer> mCorYHashes;
    private List<Integer> mCorYs;
    private List<List<Rect>> mDestRects;
    private boolean mFirstInLayout;
    private int mHeightMeasureSpec;
    private int mHeightReMeasureSpec;
    private int mLineHeight;
    private int mLineSpace;
    private int mMaxHeight;
    private int mMinHeight;
    private boolean mNeedReMeasure;
    private boolean mNeedRenderText;
    private int mOriginHeightMeasureMode;
    private String mText;
    private int mTextColor;
    private TextPaint mTextPaint;
    private int mTextSize;
    private Map<Integer, Point> mViewBounds;

    public MixtureTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.layout = null;
        this.mTextColor = -16777216;
        this.mTextSize = sp2px(14);
        this.mDestRects = new ArrayList();
        this.mCorYs = null;
        this.mCorYHashes = new HashSet<>();
        this.mViewBounds = new HashMap();
        this.mFirstInLayout = true;
        readAttrs(context, attributeSet);
        if (this.mText == null) {
            this.mText = getResources().getString(com.sandboxol.center.R.string.app_name);
        }
        if (!TextUtils.isEmpty(this.mText)) {
            this.mNeedRenderText = true;
        }
        if (this.mNeedRenderText) {
            this.mTextPaint = new TextPaint();
            this.mTextPaint.setDither(true);
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setColor(this.mTextColor);
        }
    }

    private void cacuLineHeight() {
        this.layout = new StaticLayout("爱我中华", this.mTextPaint, 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, WheelView.DividerConfig.FILL, false);
        this.mLineHeight = this.layout.getLineBottom(0) - this.layout.getLineTop(0);
    }

    private List<Rect> caculateViewYBetween(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            Point point = this.mViewBounds.get(Integer.valueOf(i3));
            int i4 = point.x;
            int i5 = point.y;
            if (i4 <= i && i5 >= i2) {
                arrayList.add(new Rect(childAt.getLeft(), i, childAt.getRight(), i2));
            }
        }
        Collections.sort(arrayList, new Comparator<Rect>() { // from class: com.sandboxol.center.view.widget.MixtureTextView.1
            @Override // java.util.Comparator
            public int compare(Rect rect, Rect rect2) {
                return rect.left > rect2.left ? 1 : -1;
            }
        });
        if (arrayList.size() < 2) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        Rect rect = (Rect) arrayList.get(0);
        Rect rect2 = (Rect) arrayList.get(1);
        Rect rect3 = rect;
        for (int i6 = 1; i6 < arrayList.size(); i6++) {
            if (!Rect.intersects(rect3, rect2)) {
                if (arrayList2.size() - i6 < 2) {
                    break;
                }
                Rect rect4 = rect2;
                rect2 = (Rect) arrayList.get(i6 + 1);
                rect3 = rect4;
            } else {
                int iMin = Math.min(rect3.left, rect2.left);
                int iMax = Math.max(rect3.right, rect2.right);
                arrayList2.remove(rect3);
                arrayList2.remove(rect2);
                arrayList2.add(new Rect(iMin, i, iMax, i2));
                if (arrayList2.size() < 2) {
                    break;
                }
                rect3 = (Rect) arrayList.get(0);
                rect2 = (Rect) arrayList.get(1);
            }
        }
        return arrayList2;
    }

    private StaticLayout generateLayout(String str, int i) {
        return new StaticLayout(str, this.mTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0f, WheelView.DividerConfig.FILL, false);
    }

    private void getAllYCors() {
        int i = this.mLineHeight;
        HashSet<Integer> hashSet = this.mCorYHashes;
        hashSet.clear();
        this.mViewBounds.clear();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                childAt.getTop();
                int top = (((childAt.getTop() - getPaddingTop()) / i) * i) + getPaddingTop();
                hashSet.add(Integer.valueOf(top));
                int bottom = childAt.getBottom() - getPaddingTop();
                if (bottom % i != 0) {
                    bottom = ((bottom / i) + 1) * i;
                }
                int paddingTop = bottom + getPaddingTop();
                hashSet.add(Integer.valueOf(paddingTop));
                this.mViewBounds.put(Integer.valueOf(i2), new Point(top, paddingTop));
            }
        }
        hashSet.add(Integer.valueOf(getPaddingTop()));
        if (this.mOriginHeightMeasureMode == 1073741824) {
            hashSet.add(Integer.valueOf(getHeight()));
        } else {
            hashSet.add(Integer.MAX_VALUE);
        }
        ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        this.mCorYs = arrayList;
    }

    private void initAllNeedRenderRect() {
        int i;
        int i2;
        List<List<Rect>> list;
        ArrayList arrayList;
        int i3;
        int i4 = this.mLineHeight;
        List<List<Rect>> list2 = this.mDestRects;
        List<Integer> list3 = this.mCorYs;
        list2.clear();
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = 1;
            if (i6 >= list3.size() - 1) {
                break;
            }
            int iIntValue = list3.get(i6).intValue();
            int i7 = i6 + 1;
            int iIntValue2 = list3.get(i7).intValue();
            ArrayList arrayList2 = new ArrayList();
            List<Rect> listCaculateViewYBetween = caculateViewYBetween(iIntValue, iIntValue2);
            int size = listCaculateViewYBetween.size();
            if (size == 0) {
                arrayList = arrayList2;
                arrayList.add(new Rect(paddingLeft, iIntValue, width, iIntValue2));
            } else if (size != 1) {
                Rect rect = listCaculateViewYBetween.get(i5);
                List<Rect> list4 = listCaculateViewYBetween;
                arrayList = arrayList2;
                int i8 = iIntValue2;
                tryAddFirst(rect, arrayList2, iIntValue, iIntValue2, paddingLeft);
                int i9 = 0;
                while (i9 < list4.size() - 1) {
                    List<Rect> list5 = list4;
                    Rect rect2 = list5.get(i9);
                    i9++;
                    Rect rect3 = list5.get(i9);
                    int i10 = rect2.right;
                    int i11 = rect3.left;
                    if (i10 < i11) {
                        i3 = i8;
                        arrayList.add(new Rect(i10, iIntValue, i11, i3));
                    } else {
                        i3 = i8;
                    }
                    list4 = list5;
                    i8 = i3;
                }
                List<Rect> list6 = list4;
                tryAddLast(list6.get(list6.size() - 1), arrayList, iIntValue, i8, width);
            } else {
                arrayList = arrayList2;
                Rect rect4 = listCaculateViewYBetween.get(0);
                tryAddFirst(rect4, arrayList, iIntValue, iIntValue2, paddingLeft);
                tryAddLast(rect4, arrayList, iIntValue, iIntValue2, width);
            }
            list2.add(arrayList);
            i6 = i7;
            i5 = 0;
        }
        ArrayList arrayList3 = new ArrayList(list2);
        int size2 = list2.size();
        int i12 = 0;
        int i13 = 0;
        while (i12 < size2) {
            List<Rect> list7 = list2.get(i12);
            if (list7.size() > i) {
                arrayList3.remove(list7);
                Rect rect5 = list7.get(0);
                int iHeight = rect5.height() / i4;
                this.mMaxHeight -= ((list7.size() - i) * iHeight) * i4;
                int i14 = i13 + i12;
                int i15 = i13 - 1;
                int i16 = 0;
                while (i16 < iHeight) {
                    int i17 = i14;
                    int i18 = i15;
                    int i19 = 0;
                    while (i19 < list7.size()) {
                        i18++;
                        Rect[] rectArr = new Rect[i];
                        int i20 = i4 * i16;
                        rectArr[0] = new Rect(list7.get(i19).left, rect5.top + i20, list7.get(i19).right, rect5.top + i20 + i4);
                        arrayList3.add(i17, Arrays.asList(rectArr));
                        i19++;
                        i17++;
                        list2 = list2;
                        size2 = size2;
                        iHeight = iHeight;
                        list7 = list7;
                        i = 1;
                    }
                    i16++;
                    i15 = i18;
                    i14 = i17;
                    size2 = size2;
                    i = 1;
                }
                i2 = size2;
                list = list2;
                i13 = i15;
            } else {
                i2 = size2;
                list = list2;
            }
            i12++;
            list2 = list;
            size2 = i2;
            i = 1;
        }
        this.mDestRects = arrayList3;
    }

    private void readAttrs(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.mTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, this.mTextSize);
        this.mTextColor = typedArrayObtainStyledAttributes.getColor(1, this.mTextColor);
        this.mText = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void tryAddFirst(Rect rect, List<Rect> list, int i, int i2, int i3) {
        int i4 = rect.left;
        if (i4 > i3) {
            list.add(new Rect(i3, i, i4, i2));
        }
    }

    private void tryAddLast(Rect rect, List<Rect> list, int i, int i2, int i3) {
        int i4 = rect.right;
        if (i4 < i3) {
            list.add(new Rect(i4, i, i3, i2));
        }
    }

    private boolean tryDraw(Canvas canvas) {
        boolean z = canvas == null;
        int i = this.mLineHeight;
        List<List<Rect>> list = this.mDestRects;
        int length = this.mText.length();
        int lineEnd = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Rect rect = list.get(i3).get(0);
            int iWidth = rect.width();
            int iHeight = rect.height();
            this.layout = generateLayout(this.mText.substring(lineEnd), iWidth);
            int lineCount = iHeight / i;
            if (this.layout.getLineCount() < lineCount) {
                lineCount = this.layout.getLineCount();
            }
            if (!z) {
                canvas.save();
                canvas.translate(rect.left, rect.top);
                canvas.clipRect(0, 0, rect.width(), this.layout.getLineBottom(lineCount - 1) - this.layout.getLineTop(0));
                this.layout.draw(canvas);
                canvas.restore();
            }
            lineEnd += this.layout.getLineEnd(lineCount - 1);
            i2 += lineCount;
            if (lineEnd >= length) {
                break;
            }
        }
        if (z) {
            this.mMaxHeight += i2 * i;
            if (this.mMaxHeight > this.mMinHeight) {
                int height = getHeight();
                int i4 = this.mMaxHeight;
                if (height != i4 && this.mOriginHeightMeasureMode != 1073741824) {
                    this.mHeightReMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, FileTypeUtils.GIGABYTE);
                    this.mNeedReMeasure = true;
                    requestLayout();
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mMaxHeight = getPaddingBottom() + getPaddingTop();
        initAllNeedRenderRect();
        if (tryDraw(null)) {
            return;
        }
        tryDraw(canvas);
        super.dispatchDraw(canvas);
    }

    public int dp2px(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    public String getText() {
        return this.mText;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public int getTextSize() {
        return this.mTextSize;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mFirstInLayout) {
            this.mOriginHeightMeasureMode = View.MeasureSpec.getMode(this.mHeightMeasureSpec);
            this.mFirstInLayout = false;
            this.mMinHeight = getMeasuredHeight();
        }
        super.onLayout(z, i, i2, i3, i4);
        if (this.mNeedRenderText) {
            getAllYCors();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!this.mNeedRenderText) {
            super.onMeasure(i, i2);
            return;
        }
        this.mHeightMeasureSpec = i2;
        this.mTextPaint.setTextSize(this.mTextSize);
        cacuLineHeight();
        if (this.mNeedReMeasure) {
            super.onMeasure(i, this.mHeightReMeasureSpec);
        } else {
            super.onMeasure(i, i2);
        }
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNeedRenderText = false;
            requestLayout();
        } else {
            this.mNeedRenderText = true;
            this.mText = str;
            requestLayout();
            invalidate();
        }
    }

    public void setTextColor(int i) {
        this.mTextPaint.setColor(i);
        this.mTextColor = i;
        invalidate();
    }

    public void setTextSize(int i, int i2) {
        if (i == 0) {
            this.mTextSize = i2;
        } else if (i == 1) {
            this.mTextSize = dp2px(i2);
        } else if (i == 2) {
            this.mTextSize = sp2px(i2);
        }
        this.mTextPaint.setTextSize(this.mTextSize);
        requestLayout();
        invalidate();
    }

    public int sp2px(int i) {
        return (int) TypedValue.applyDimension(2, i, getResources().getDisplayMetrics());
    }

    public void setTextSize(int i) {
        setTextSize(0, i);
    }
}
