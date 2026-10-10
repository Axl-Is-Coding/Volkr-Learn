package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.f;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.g;
import androidx.constraintlayout.solver.widgets.j;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    static final boolean ALLOWS_EMBEDDED = false;
    private static final boolean CACHE_MEASURED_DIMENSION = false;
    private static final boolean DEBUG = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-1.1.3";
    SparseArray<View> mChildrenByIds;
    private ArrayList<ConstraintHelper> mConstraintHelpers;
    private b mConstraintSet;
    private int mConstraintSetId;
    private HashMap<String, Integer> mDesignIds;
    private boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    g mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    private f mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private int mOptimizationLevel;
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets;

    public ConstraintLayout(Context context) {
        super(context);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mVariableDimensionsWidgets = new ArrayList<>(100);
        this.mLayoutWidget = new g();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 7;
        this.mConstraintSet = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        init(null);
    }

    private final ConstraintWidget getTargetWidget(int i) {
        if (i == 0) {
            return this.mLayoutWidget;
        }
        View viewFindViewById = this.mChildrenByIds.get(i);
        if (viewFindViewById == null && (viewFindViewById = findViewById(i)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.mLayoutWidget;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((LayoutParams) viewFindViewById.getLayoutParams()).la;
    }

    private void init(AttributeSet attributeSet) {
        this.mLayoutWidget.a(this);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = typedArrayObtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.mConstraintSet = new b();
                        this.mConstraintSet.a(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.u(this.mOptimizationLevel);
    }

    private void internalMeasureChildren(int i, int i2) {
        boolean z;
        boolean z2;
        int baseline;
        int childMeasureSpec;
        int childMeasureSpec2;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ConstraintWidget constraintWidget = layoutParams.la;
                if (!layoutParams.Y && !layoutParams.Z) {
                    constraintWidget.n(childAt.getVisibility());
                    int measuredWidth = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                    int measuredHeight = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    boolean z3 = layoutParams.V;
                    if (z3 || layoutParams.W || (!z3 && layoutParams.I == 1) || ((ViewGroup.MarginLayoutParams) layoutParams).width == -1 || (!layoutParams.W && (layoutParams.J == 1 || ((ViewGroup.MarginLayoutParams) layoutParams).height == -1))) {
                        if (measuredWidth == 0) {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i, paddingLeft, -2);
                            z = true;
                        } else if (measuredWidth == -1) {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i, paddingLeft, -1);
                            z = false;
                        } else {
                            z = measuredWidth == -2;
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i, paddingLeft, measuredWidth);
                        }
                        if (measuredHeight == 0) {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
                            z2 = true;
                        } else if (measuredHeight == -1) {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, paddingTop, -1);
                            z2 = false;
                        } else {
                            z2 = measuredHeight == -2;
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, paddingTop, measuredHeight);
                        }
                        childAt.measure(childMeasureSpec, childMeasureSpec2);
                        f fVar = this.mMetrics;
                        if (fVar != null) {
                            fVar.f827a++;
                        }
                        constraintWidget.b(measuredWidth == -2);
                        constraintWidget.a(measuredHeight == -2);
                        measuredWidth = childAt.getMeasuredWidth();
                        measuredHeight = childAt.getMeasuredHeight();
                    } else {
                        z = false;
                        z2 = false;
                    }
                    constraintWidget.o(measuredWidth);
                    constraintWidget.g(measuredHeight);
                    if (z) {
                        constraintWidget.q(measuredWidth);
                    }
                    if (z2) {
                        constraintWidget.p(measuredHeight);
                    }
                    if (layoutParams.X && (baseline = childAt.getBaseline()) != -1) {
                        constraintWidget.f(baseline);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void internalMeasureDimensions(int r24, int r25) {
        /*
            Method dump skipped, instruction units count: 739
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.internalMeasureDimensions(int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01dd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03b4  */
    /* JADX WARN: Type inference failed for: r26v0, types: [android.view.ViewGroup, androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setChildrenConstraints() {
        /*
            Method dump skipped, instruction units count: 998
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.setChildrenConstraints():void");
    }

    private void setSelfDimensionBehaviour(int i, int i2) {
        int iMin;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            } else if (mode != 1073741824) {
                dimensionBehaviour = dimensionBehaviour2;
            } else {
                iMin = Math.min(this.mMaxWidth, size) - paddingLeft;
                dimensionBehaviour = dimensionBehaviour2;
            }
            iMin = 0;
        } else {
            iMin = size;
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.mMaxHeight, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        this.mLayoutWidget.l(0);
        this.mLayoutWidget.k(0);
        this.mLayoutWidget.a(dimensionBehaviour);
        this.mLayoutWidget.o(iMin);
        this.mLayoutWidget.b(dimensionBehaviour2);
        this.mLayoutWidget.g(size2);
        this.mLayoutWidget.l((this.mMinWidth - getPaddingLeft()) - getPaddingRight());
        this.mLayoutWidget.k((this.mMinHeight - getPaddingTop()) - getPaddingBottom());
    }

    private void updateHierarchy() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            this.mVariableDimensionsWidgets.clear();
            setChildrenConstraints();
        }
    }

    private void updatePostMeasures() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof Placeholder) {
                ((Placeholder) childAt).updatePostMeasure(this);
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.mConstraintHelpers.get(i2).updatePostMeasure(this);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i2 = Integer.parseInt(strArrSplit[0]);
                        int i3 = Integer.parseInt(strArrSplit[1]);
                        int i4 = Integer.parseInt(strArrSplit[2]);
                        int i5 = (int) ((i2 / 1080.0f) * width);
                        int i6 = (int) ((i3 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f2 = i5;
                        float f3 = i6;
                        float f4 = i5 + ((int) ((i4 / 1080.0f) * width));
                        canvas.drawLine(f2, f3, f4, f3, paint);
                        float f5 = i6 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f4, f3, f4, f5, paint);
                        canvas.drawLine(f4, f5, f2, f5, paint);
                        canvas.drawLine(f2, f5, f2, f3, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f2, f3, f4, f5, paint);
                        canvas.drawLine(f2, f5, f4, f3, paint);
                    }
                }
            }
        }
    }

    public void fillMetrics(f fVar) {
        this.mMetrics = fVar;
        this.mLayoutWidget.a(fVar);
    }

    public Object getDesignInformation(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> map = this.mDesignIds;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.M();
    }

    public View getViewById(int i) {
        return this.mChildrenByIds.get(i);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).la;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.la;
            if ((childAt.getVisibility() != 8 || layoutParams.Y || layoutParams.Z || zIsInEditMode) && !layoutParams.aa) {
                int iG = constraintWidget.g();
                int iH = constraintWidget.h();
                int iS = constraintWidget.s() + iG;
                int i6 = constraintWidget.i() + iH;
                childAt.layout(iG, iH, iS, i6);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(iG, iH, iS, i6);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                this.mConstraintHelpers.get(i7).updatePostLayout(this);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x011d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r25, int r26) {
        /*
            Method dump skipped, instruction units count: 945
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof j)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.la = new j();
            layoutParams.Y = true;
            ((j) layoutParams.la).v(layoutParams.S);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.validateParams();
            ((LayoutParams) view.getLayoutParams()).Z = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.mChildrenByIds.remove(view.getId());
        ConstraintWidget viewWidget = getViewWidget(view);
        this.mLayoutWidget.c(viewWidget);
        this.mConstraintHelpers.remove(view);
        this.mVariableDimensionsWidgets.remove(viewWidget);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    public void setConstraintSet(b bVar) {
        this.mConstraintSet = bVar;
    }

    public void setDesignInformation(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            this.mDesignIds.put(strSubstring, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    @Override // android.view.View
    public void setId(int i) {
        this.mChildrenByIds.remove(getId());
        super.setId(i);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.mMinHeight) {
            return;
        }
        this.mMinHeight = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.mMinWidth) {
            return;
        }
        this.mMinWidth = i;
        requestLayout();
    }

    public void setOptimizationLevel(int i) {
        this.mLayoutWidget.u(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    protected void solveLinearSystem(String str) {
        this.mLayoutWidget.K();
        f fVar = this.mMetrics;
        if (fVar != null) {
            fVar.f829c++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mVariableDimensionsWidgets = new ArrayList<>(100);
        this.mLayoutWidget = new g();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 7;
        this.mConstraintSet = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        init(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mVariableDimensionsWidgets = new ArrayList<>(100);
        this.mLayoutWidget = new g();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 7;
        this.mConstraintSet = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        init(attributeSet);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public float A;
        public String B;
        float C;
        int D;
        public float E;
        public float F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public float O;
        public float P;
        public int Q;
        public int R;
        public int S;
        public boolean T;
        public boolean U;
        boolean V;
        boolean W;
        boolean X;
        boolean Y;
        boolean Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f881a;
        boolean aa;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f882b;
        int ba;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f883c;
        int ca;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f884d;
        int da;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f885e;
        int ea;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f886f;
        int fa;
        public int g;
        int ga;
        public int h;
        float ha;
        public int i;
        int ia;
        public int j;
        int ja;
        public int k;
        float ka;
        public int l;
        ConstraintWidget la;
        public int m;
        public boolean ma;
        public int n;
        public float o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public int y;
        public float z;

        private static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f887a = new SparseIntArray();

            static {
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                f887a.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                f887a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            int i;
            super(context, attributeSet);
            this.f881a = -1;
            this.f882b = -1;
            this.f883c = -1.0f;
            this.f884d = -1;
            this.f885e = -1;
            this.f886f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = WheelView.DividerConfig.FILL;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = WheelView.DividerConfig.FILL;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.aa = false;
            this.ba = -1;
            this.ca = -1;
            this.da = -1;
            this.ea = -1;
            this.fa = -1;
            this.ga = -1;
            this.ha = 0.5f;
            this.la = new ConstraintWidget();
            this.ma = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                switch (a.f887a.get(index)) {
                    case 1:
                        this.S = typedArrayObtainStyledAttributes.getInt(index, this.S);
                        break;
                    case 2:
                        this.m = typedArrayObtainStyledAttributes.getResourceId(index, this.m);
                        if (this.m == -1) {
                            this.m = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 3:
                        this.n = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.n);
                        break;
                    case 4:
                        this.o = typedArrayObtainStyledAttributes.getFloat(index, this.o) % 360.0f;
                        float f2 = this.o;
                        if (f2 < WheelView.DividerConfig.FILL) {
                            this.o = (360.0f - f2) % 360.0f;
                        }
                        break;
                    case 5:
                        this.f881a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f881a);
                        break;
                    case 6:
                        this.f882b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f882b);
                        break;
                    case 7:
                        this.f883c = typedArrayObtainStyledAttributes.getFloat(index, this.f883c);
                        break;
                    case 8:
                        this.f884d = typedArrayObtainStyledAttributes.getResourceId(index, this.f884d);
                        if (this.f884d == -1) {
                            this.f884d = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 9:
                        this.f885e = typedArrayObtainStyledAttributes.getResourceId(index, this.f885e);
                        if (this.f885e == -1) {
                            this.f885e = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 10:
                        this.f886f = typedArrayObtainStyledAttributes.getResourceId(index, this.f886f);
                        if (this.f886f == -1) {
                            this.f886f = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 11:
                        this.g = typedArrayObtainStyledAttributes.getResourceId(index, this.g);
                        if (this.g == -1) {
                            this.g = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 12:
                        this.h = typedArrayObtainStyledAttributes.getResourceId(index, this.h);
                        if (this.h == -1) {
                            this.h = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 13:
                        this.i = typedArrayObtainStyledAttributes.getResourceId(index, this.i);
                        if (this.i == -1) {
                            this.i = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 14:
                        this.j = typedArrayObtainStyledAttributes.getResourceId(index, this.j);
                        if (this.j == -1) {
                            this.j = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 15:
                        this.k = typedArrayObtainStyledAttributes.getResourceId(index, this.k);
                        if (this.k == -1) {
                            this.k = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 16:
                        this.l = typedArrayObtainStyledAttributes.getResourceId(index, this.l);
                        if (this.l == -1) {
                            this.l = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 17:
                        this.p = typedArrayObtainStyledAttributes.getResourceId(index, this.p);
                        if (this.p == -1) {
                            this.p = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 18:
                        this.q = typedArrayObtainStyledAttributes.getResourceId(index, this.q);
                        if (this.q == -1) {
                            this.q = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 19:
                        this.r = typedArrayObtainStyledAttributes.getResourceId(index, this.r);
                        if (this.r == -1) {
                            this.r = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 20:
                        this.s = typedArrayObtainStyledAttributes.getResourceId(index, this.s);
                        if (this.s == -1) {
                            this.s = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 21:
                        this.t = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.t);
                        break;
                    case 22:
                        this.u = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.u);
                        break;
                    case 23:
                        this.v = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        break;
                    case 24:
                        this.w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        break;
                    case 25:
                        this.x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        break;
                    case 26:
                        this.y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 27:
                        this.T = typedArrayObtainStyledAttributes.getBoolean(index, this.T);
                        break;
                    case 28:
                        this.U = typedArrayObtainStyledAttributes.getBoolean(index, this.U);
                        break;
                    case 29:
                        this.z = typedArrayObtainStyledAttributes.getFloat(index, this.z);
                        break;
                    case 30:
                        this.A = typedArrayObtainStyledAttributes.getFloat(index, this.A);
                        break;
                    case 31:
                        this.I = typedArrayObtainStyledAttributes.getInt(index, 0);
                        if (this.I == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        }
                        break;
                    case 32:
                        this.J = typedArrayObtainStyledAttributes.getInt(index, 0);
                        if (this.J == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        }
                        break;
                    case 33:
                        try {
                            this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.K) == -2) {
                                this.K = -2;
                            }
                        }
                        break;
                    case 34:
                        try {
                            this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                            }
                        }
                        break;
                    case 35:
                        this.O = Math.max(WheelView.DividerConfig.FILL, typedArrayObtainStyledAttributes.getFloat(index, this.O));
                        break;
                    case 36:
                        try {
                            this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.L) == -2) {
                                this.L = -2;
                            }
                        }
                        break;
                    case 37:
                        try {
                            this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.N) == -2) {
                                this.N = -2;
                            }
                        }
                        break;
                    case 38:
                        this.P = Math.max(WheelView.DividerConfig.FILL, typedArrayObtainStyledAttributes.getFloat(index, this.P));
                        break;
                    case 44:
                        this.B = typedArrayObtainStyledAttributes.getString(index);
                        this.C = Float.NaN;
                        this.D = -1;
                        String str = this.B;
                        if (str != null) {
                            int length = str.length();
                            int iIndexOf = this.B.indexOf(44);
                            if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                                i = 0;
                            } else {
                                String strSubstring = this.B.substring(0, iIndexOf);
                                if (strSubstring.equalsIgnoreCase("W")) {
                                    this.D = 0;
                                } else if (strSubstring.equalsIgnoreCase("H")) {
                                    this.D = 1;
                                }
                                i = iIndexOf + 1;
                            }
                            int iIndexOf2 = this.B.indexOf(58);
                            if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                                String strSubstring2 = this.B.substring(i);
                                if (strSubstring2.length() > 0) {
                                    this.C = Float.parseFloat(strSubstring2);
                                }
                            } else {
                                String strSubstring3 = this.B.substring(i, iIndexOf2);
                                String strSubstring4 = this.B.substring(iIndexOf2 + 1);
                                if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                                    try {
                                        float f3 = Float.parseFloat(strSubstring3);
                                        float f4 = Float.parseFloat(strSubstring4);
                                        if (f3 > WheelView.DividerConfig.FILL && f4 > WheelView.DividerConfig.FILL) {
                                            if (this.D == 1) {
                                                this.C = Math.abs(f4 / f3);
                                            } else {
                                                this.C = Math.abs(f3 / f4);
                                            }
                                        }
                                    } catch (NumberFormatException unused5) {
                                    }
                                }
                            }
                        }
                        break;
                    case 45:
                        this.E = typedArrayObtainStyledAttributes.getFloat(index, this.E);
                        break;
                    case 46:
                        this.F = typedArrayObtainStyledAttributes.getFloat(index, this.F);
                        break;
                    case 47:
                        this.G = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 48:
                        this.H = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 49:
                        this.Q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                        break;
                    case 50:
                        this.R = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.R);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.Y = false;
            this.V = true;
            this.W = true;
            if (((ViewGroup.MarginLayoutParams) this).width == -2 && this.T) {
                this.V = false;
                this.I = 1;
            }
            if (((ViewGroup.MarginLayoutParams) this).height == -2 && this.U) {
                this.W = false;
                this.J = 1;
            }
            if (((ViewGroup.MarginLayoutParams) this).width == 0 || ((ViewGroup.MarginLayoutParams) this).width == -1) {
                this.V = false;
                if (((ViewGroup.MarginLayoutParams) this).width == 0 && this.I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.T = true;
                }
            }
            if (((ViewGroup.MarginLayoutParams) this).height == 0 || ((ViewGroup.MarginLayoutParams) this).height == -1) {
                this.W = false;
                if (((ViewGroup.MarginLayoutParams) this).height == 0 && this.J == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.U = true;
                }
            }
            if (this.f883c == -1.0f && this.f881a == -1 && this.f882b == -1) {
                return;
            }
            this.Y = true;
            this.V = true;
            this.W = true;
            if (!(this.la instanceof j)) {
                this.la = new j();
            }
            ((j) this.la).v(this.S);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @android.annotation.TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resolveLayoutDirection(int r7) {
            /*
                Method dump skipped, instruction units count: 265
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f881a = -1;
            this.f882b = -1;
            this.f883c = -1.0f;
            this.f884d = -1;
            this.f885e = -1;
            this.f886f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = WheelView.DividerConfig.FILL;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = WheelView.DividerConfig.FILL;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.aa = false;
            this.ba = -1;
            this.ca = -1;
            this.da = -1;
            this.ea = -1;
            this.fa = -1;
            this.ga = -1;
            this.ha = 0.5f;
            this.la = new ConstraintWidget();
            this.ma = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f881a = -1;
            this.f882b = -1;
            this.f883c = -1.0f;
            this.f884d = -1;
            this.f885e = -1;
            this.f886f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = WheelView.DividerConfig.FILL;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = WheelView.DividerConfig.FILL;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.aa = false;
            this.ba = -1;
            this.ca = -1;
            this.da = -1;
            this.ea = -1;
            this.fa = -1;
            this.ga = -1;
            this.ha = 0.5f;
            this.la = new ConstraintWidget();
            this.ma = false;
        }
    }
}
