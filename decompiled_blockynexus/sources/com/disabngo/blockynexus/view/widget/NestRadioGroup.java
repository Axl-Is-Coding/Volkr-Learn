package com.disabngo.blockynexus.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class NestRadioGroup extends LinearLayout {
    private int mCheckedId;
    private CompoundButton.OnCheckedChangeListener mChildOnCheckedChangeListener;
    private b mOnCheckedChangeListener;
    private c mPassThroughListener;
    private boolean mProtectFromCheckedChange;

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.view.ViewGroup.LayoutParams
        protected void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            if (typedArray.hasValue(i)) {
                ((LinearLayout.LayoutParams) this).width = typedArray.getLayoutDimension(i, "layout_width");
            } else {
                ((LinearLayout.LayoutParams) this).width = -2;
            }
            if (typedArray.hasValue(i2)) {
                ((LinearLayout.LayoutParams) this).height = typedArray.getLayoutDimension(i2, "layout_height");
            } else {
                ((LinearLayout.LayoutParams) this).height = -2;
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }
    }

    private class a implements CompoundButton.OnCheckedChangeListener {
        private a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (NestRadioGroup.this.mProtectFromCheckedChange) {
                return;
            }
            NestRadioGroup.this.mProtectFromCheckedChange = true;
            if (NestRadioGroup.this.mCheckedId != -1) {
                NestRadioGroup nestRadioGroup = NestRadioGroup.this;
                nestRadioGroup.setCheckedStateForView(nestRadioGroup.mCheckedId, false);
            }
            NestRadioGroup.this.mProtectFromCheckedChange = false;
            NestRadioGroup.this.setCheckedId(compoundButton.getId());
        }
    }

    public interface b {
        void a(NestRadioGroup nestRadioGroup, int i);
    }

    private class c implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ViewGroup.OnHierarchyChangeListener f12070a;

        private c() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        @TargetApi(17)
        public void onChildViewAdded(View view, View view2) {
            CompoundButton compoundButtonFindCheckedView;
            if (view == NestRadioGroup.this && (compoundButtonFindCheckedView = NestRadioGroup.findCheckedView(view2)) != null) {
                if (compoundButtonFindCheckedView.getId() == -1 && Build.VERSION.SDK_INT >= 17) {
                    compoundButtonFindCheckedView.setId(View.generateViewId());
                }
                compoundButtonFindCheckedView.setOnCheckedChangeListener(NestRadioGroup.this.mChildOnCheckedChangeListener);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f12070a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CompoundButton compoundButtonFindCheckedView;
            if (view == NestRadioGroup.this && (compoundButtonFindCheckedView = NestRadioGroup.findCheckedView(view2)) != null) {
                compoundButtonFindCheckedView.setOnCheckedChangeListener(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f12070a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public NestRadioGroup(Context context) {
        super(context);
        this.mCheckedId = -1;
        this.mProtectFromCheckedChange = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CompoundButton findCheckedView(View view) {
        if (view instanceof CompoundButton) {
            return (CompoundButton) view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            CompoundButton compoundButtonFindCheckedView = findCheckedView(viewGroup.getChildAt(i));
            if (compoundButtonFindCheckedView != null) {
                return compoundButtonFindCheckedView;
            }
        }
        return null;
    }

    private void init() {
        this.mCheckedId = -1;
        setOrientation(0);
        this.mChildOnCheckedChangeListener = new a();
        this.mPassThroughListener = new c();
        super.setOnHierarchyChangeListener(this.mPassThroughListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i) {
        this.mCheckedId = i;
        b bVar = this.mOnCheckedChangeListener;
        if (bVar != null) {
            bVar.a(this, this.mCheckedId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedStateForView(int i, boolean z) {
        View viewFindViewById = findViewById(i);
        if (viewFindViewById == null || !(viewFindViewById instanceof CompoundButton)) {
            return;
        }
        ((CompoundButton) viewFindViewById).setChecked(z);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        CompoundButton compoundButtonFindCheckedView = findCheckedView(view);
        if (compoundButtonFindCheckedView != null && compoundButtonFindCheckedView.isChecked()) {
            this.mProtectFromCheckedChange = true;
            int i2 = this.mCheckedId;
            if (i2 != -1) {
                setCheckedStateForView(i2, false);
            }
            this.mProtectFromCheckedChange = false;
            setCheckedId(compoundButtonFindCheckedView.getId());
        }
        super.addView(view, i, layoutParams);
    }

    public void check(int i) {
        if (i == -1 || i != this.mCheckedId) {
            int i2 = this.mCheckedId;
            if (i2 != -1) {
                setCheckedStateForView(i2, false);
            }
            if (i != -1) {
                setCheckedStateForView(i, true);
            }
            setCheckedId(i);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void clearCheck() {
        check(-1);
    }

    public int getCheckedRadioButtonId() {
        return this.mCheckedId;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i = this.mCheckedId;
        if (i != -1) {
            this.mProtectFromCheckedChange = true;
            setCheckedStateForView(i, true);
            this.mProtectFromCheckedChange = false;
            setCheckedId(this.mCheckedId);
        }
    }

    public void setOnCheckedChangeListener(b bVar) {
        this.mOnCheckedChangeListener = bVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mPassThroughListener.f12070a = onHierarchyChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public NestRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckedId = -1;
        this.mProtectFromCheckedChange = false;
        init();
    }
}
