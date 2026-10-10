package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.C0319g;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.s;
import com.google.android.material.internal.v;
import com.google.android.material.l.n;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialButtonToggleGroup extends LinearLayout {
    private static final String LOG_TAG = "MaterialButtonToggleGroup";
    private int checkedId;
    private final a checkedStateTracker;
    private Integer[] childOrder;
    private final Comparator<MaterialButton> childOrderComparator;
    private final LinkedHashSet<c> onButtonCheckedListeners;
    private final List<b> originalCornerData;
    private final d pressedStateTracker;
    private boolean singleSelection;
    private boolean skipCheckedStateTracker;

    private class a implements MaterialButton.a {
        private a() {
        }

        @Override // com.google.android.material.button.MaterialButton.a
        public void a(MaterialButton materialButton, boolean z) {
            if (MaterialButtonToggleGroup.this.skipCheckedStateTracker) {
                return;
            }
            if (MaterialButtonToggleGroup.this.singleSelection) {
                MaterialButtonToggleGroup.this.checkedId = z ? materialButton.getId() : -1;
            }
            MaterialButtonToggleGroup.this.dispatchOnButtonChecked(materialButton.getId(), z);
            MaterialButtonToggleGroup.this.updateCheckedStates(materialButton.getId(), z);
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ a(MaterialButtonToggleGroup materialButtonToggleGroup, com.google.android.material.button.b bVar) {
            this();
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final com.google.android.material.l.c f13234a = new com.google.android.material.l.a(WheelView.DividerConfig.FILL);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        com.google.android.material.l.c f13235b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        com.google.android.material.l.c f13236c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        com.google.android.material.l.c f13237d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        com.google.android.material.l.c f13238e;

        b(com.google.android.material.l.c cVar, com.google.android.material.l.c cVar2, com.google.android.material.l.c cVar3, com.google.android.material.l.c cVar4) {
            this.f13235b = cVar;
            this.f13236c = cVar3;
            this.f13237d = cVar4;
            this.f13238e = cVar2;
        }

        public static b a(b bVar, View view) {
            return v.b(view) ? b(bVar) : c(bVar);
        }

        public static b b(b bVar, View view) {
            return v.b(view) ? c(bVar) : b(bVar);
        }

        public static b c(b bVar) {
            com.google.android.material.l.c cVar = f13234a;
            return new b(cVar, cVar, bVar.f13236c, bVar.f13237d);
        }

        public static b d(b bVar) {
            com.google.android.material.l.c cVar = bVar.f13235b;
            com.google.android.material.l.c cVar2 = f13234a;
            return new b(cVar, cVar2, bVar.f13236c, cVar2);
        }

        public static b a(b bVar) {
            com.google.android.material.l.c cVar = f13234a;
            return new b(cVar, bVar.f13238e, cVar, bVar.f13237d);
        }

        public static b b(b bVar) {
            com.google.android.material.l.c cVar = bVar.f13235b;
            com.google.android.material.l.c cVar2 = bVar.f13238e;
            com.google.android.material.l.c cVar3 = f13234a;
            return new b(cVar, cVar2, cVar3, cVar3);
        }
    }

    public interface c {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z);
    }

    private class d implements MaterialButton.b {
        private d() {
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(MaterialButton materialButton, boolean z) {
            MaterialButtonToggleGroup.this.updateCheckedStates(materialButton.getId(), materialButton.isChecked());
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ d(MaterialButtonToggleGroup materialButtonToggleGroup, com.google.android.material.button.b bVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(Context context) {
        this(context, null);
    }

    private void adjustChildMarginsAndUpdateLayout() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
            MaterialButton childButton = getChildButton(i);
            int iMin = Math.min(childButton.getStrokeWidth(), getChildButton(i - 1).getStrokeWidth());
            LinearLayout.LayoutParams layoutParamsBuildLayoutParams = buildLayoutParams(childButton);
            if (getOrientation() == 0) {
                C0319g.a(layoutParamsBuildLayoutParams, 0);
                C0319g.b(layoutParamsBuildLayoutParams, -iMin);
            } else {
                layoutParamsBuildLayoutParams.bottomMargin = 0;
                layoutParamsBuildLayoutParams.topMargin = -iMin;
            }
            childButton.setLayoutParams(layoutParamsBuildLayoutParams);
        }
        resetChildMargins(firstVisibleChildIndex);
    }

    private LinearLayout.LayoutParams buildLayoutParams(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void checkForced(int i) {
        setCheckedStateForView(i, true);
        updateCheckedStates(i, true);
        setCheckedId(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnButtonChecked(int i, boolean z) {
        Iterator<c> it = this.onButtonCheckedListeners.iterator();
        while (it.hasNext()) {
            it.next().a(this, i, z);
        }
    }

    private MaterialButton getChildButton(int i) {
        return (MaterialButton) getChildAt(i);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (isChildVisible(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (isChildVisible(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private b getNewCornerData(int i, int i2, int i3) {
        int childCount = getChildCount();
        b bVar = this.originalCornerData.get(i);
        if (childCount == 1) {
            return bVar;
        }
        boolean z = getOrientation() == 0;
        if (i == i2) {
            return z ? b.b(bVar, this) : b.d(bVar);
        }
        if (i == i3) {
            return z ? b.a(bVar, this) : b.a(bVar);
        }
        return null;
    }

    private boolean isChildVisible(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    private void resetChildMargins(int i) {
        if (getChildCount() == 0 || i == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildButton(i).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            C0319g.a(layoutParams, 0);
            C0319g.b(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void setCheckedId(int i) {
        this.checkedId = i;
        dispatchOnButtonChecked(i, true);
    }

    private void setCheckedStateForView(int i, boolean z) {
        View viewFindViewById = findViewById(i);
        if (viewFindViewById instanceof MaterialButton) {
            this.skipCheckedStateTracker = true;
            ((MaterialButton) viewFindViewById).setChecked(z);
            this.skipCheckedStateTracker = false;
        }
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.a());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.addOnCheckedChangeListener(this.checkedStateTracker);
        materialButton.setOnPressedChangeListenerInternal(this.pressedStateTracker);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    private static void updateBuilderWithCornerData(n.a aVar, b bVar) {
        if (bVar == null) {
            aVar.a(WheelView.DividerConfig.FILL);
            return;
        }
        aVar.c(bVar.f13235b);
        aVar.a(bVar.f13238e);
        aVar.d(bVar.f13236c);
        aVar.b(bVar.f13237d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCheckedStates(int i, boolean z) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton childButton = getChildButton(i2);
            if (childButton.isChecked() && this.singleSelection && z && childButton.getId() != i) {
                setCheckedStateForView(childButton.getId(), false);
                dispatchOnButtonChecked(childButton.getId(), false);
            }
        }
    }

    private void updateChildOrder() {
        TreeMap treeMap = new TreeMap(this.childOrderComparator);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put(getChildButton(i), Integer.valueOf(i));
        }
        this.childOrder = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    public void addOnButtonCheckedListener(c cVar) {
        this.onButtonCheckedListeners.add(cVar);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(LOG_TAG, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        if (materialButton.isChecked()) {
            updateCheckedStates(materialButton.getId(), true);
            setCheckedId(materialButton.getId());
        }
        n shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.originalCornerData.add(new b(shapeAppearanceModel.k(), shapeAppearanceModel.d(), shapeAppearanceModel.m(), shapeAppearanceModel.f()));
    }

    public void check(int i) {
        if (i == this.checkedId) {
            return;
        }
        checkForced(i);
    }

    public void clearChecked() {
        this.skipCheckedStateTracker = true;
        for (int i = 0; i < getChildCount(); i++) {
            MaterialButton childButton = getChildButton(i);
            childButton.setChecked(false);
            dispatchOnButtonChecked(childButton.getId(), false);
        }
        this.skipCheckedStateTracker = false;
        setCheckedId(-1);
    }

    public void clearOnButtonCheckedListeners() {
        this.onButtonCheckedListeners.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        updateChildOrder();
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    public int getCheckedButtonId() {
        if (this.singleSelection) {
            return this.checkedId;
        }
        return -1;
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            MaterialButton childButton = getChildButton(i);
            if (childButton.isChecked()) {
                arrayList.add(Integer.valueOf(childButton.getId()));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        Integer[] numArr = this.childOrder;
        if (numArr != null && i2 < numArr.length) {
            return numArr[i2].intValue();
        }
        Log.w(LOG_TAG, "Child order wasn't updated");
        return i2;
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i = this.checkedId;
        if (i != -1) {
            checkForced(i);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.removeOnCheckedChangeListener(this.checkedStateTracker);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.originalCornerData.remove(iIndexOfChild);
        }
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
    }

    public void removeOnButtonCheckedListener(c cVar) {
        this.onButtonCheckedListeners.remove(cVar);
    }

    public void setSingleSelection(boolean z) {
        if (this.singleSelection != z) {
            this.singleSelection = z;
            clearChecked();
        }
    }

    public void uncheck(int i) {
        setCheckedStateForView(i, false);
        updateCheckedStates(i, false);
        this.checkedId = -1;
        dispatchOnButtonChecked(i, false);
    }

    void updateChildShapes() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i = 0; i < childCount; i++) {
            MaterialButton childButton = getChildButton(i);
            if (childButton.getVisibility() != 8) {
                n.a aVarN = childButton.getShapeAppearanceModel().n();
                updateBuilderWithCornerData(aVarN, getNewCornerData(i, firstVisibleChildIndex, lastVisibleChildIndex));
                childButton.setShapeAppearanceModel(aVarN.a());
            }
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonToggleGroupStyle);
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.originalCornerData = new ArrayList();
        com.google.android.material.button.b bVar = null;
        this.checkedStateTracker = new a(this, bVar);
        this.pressedStateTracker = new d(this, bVar);
        this.onButtonCheckedListeners = new LinkedHashSet<>();
        this.childOrderComparator = new com.google.android.material.button.b(this);
        this.skipCheckedStateTracker = false;
        TypedArray typedArrayA = s.a(context, attributeSet, R.styleable.MaterialButtonToggleGroup, i, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup, new int[0]);
        setSingleSelection(typedArrayA.getBoolean(R.styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.checkedId = typedArrayA.getResourceId(R.styleable.MaterialButtonToggleGroup_checkedButton, -1);
        setChildrenDrawingOrderEnabled(true);
        typedArrayA.recycle();
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }
}
