package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import io.rong.imkit.utils.FileTypeUtils;

/* JADX INFO: loaded from: classes2.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] w = {R.attr.snackbarButtonStyle};
    private final AccessibilityManager x;
    private boolean y;
    private BaseTransientBottomBar.a<Snackbar> z;

    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, FileTypeUtils.GIGABYTE), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), FileTypeUtils.GIGABYTE));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class a extends BaseTransientBottomBar.a<Snackbar> {
    }

    private Snackbar(ViewGroup viewGroup, View view, t tVar) {
        super(viewGroup, view, tVar);
        this.x = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    public static Snackbar a(View view, CharSequence charSequence, int i) {
        ViewGroup viewGroupA = a(view);
        if (viewGroupA == null) {
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(viewGroupA.getContext()).inflate(a(viewGroupA.getContext()) ? R.layout.mtrl_layout_snackbar_include : R.layout.design_layout_snackbar_include, viewGroupA, false);
        Snackbar snackbar = new Snackbar(viewGroupA, snackbarContentLayout, snackbarContentLayout);
        snackbar.a(charSequence);
        snackbar.d(i);
        return snackbar;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void d() {
        super.d();
    }

    public Snackbar e(int i) {
        ((SnackbarContentLayout) this.g.getChildAt(0)).getActionView().setTextColor(i);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int f() {
        int iF = super.f();
        if (iF == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.x.getRecommendedTimeoutMillis(iF, (this.y ? 4 : 0) | 1 | 2);
        }
        if (this.y && this.x.isTouchExplorationEnabled()) {
            return -2;
        }
        return iF;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void n() {
        super.n();
    }

    @Deprecated
    public Snackbar setCallback(a aVar) {
        BaseTransientBottomBar.a<Snackbar> aVar2 = this.z;
        if (aVar2 != null) {
            removeCallback(aVar2);
        }
        if (aVar != null) {
            addCallback(aVar);
        }
        this.z = aVar;
        return this;
    }

    protected static boolean a(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(w);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    public static Snackbar a(View view, int i, int i2) {
        return a(view, view.getResources().getText(i), i2);
    }

    private static ViewGroup a(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    public Snackbar a(CharSequence charSequence) {
        ((SnackbarContentLayout) this.g.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    public Snackbar a(int i, View.OnClickListener onClickListener) {
        return a(e().getText(i), onClickListener);
    }

    public Snackbar a(CharSequence charSequence, final View.OnClickListener onClickListener) {
        Button actionView = ((SnackbarContentLayout) this.g.getChildAt(0)).getActionView();
        if (!TextUtils.isEmpty(charSequence) && onClickListener != null) {
            this.y = true;
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.snackbar.Snackbar.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    onClickListener.onClick(view);
                    Snackbar.this.a(1);
                }
            });
        } else {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            this.y = false;
        }
        return this;
    }
}
