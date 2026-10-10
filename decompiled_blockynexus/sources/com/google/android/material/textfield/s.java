package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.R;
import com.google.android.material.l.n;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class s extends t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f13680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextWatcher f13681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextInputLayout.a f13682f;
    private final TextInputLayout.b g;
    private boolean h;
    private boolean i;
    private long j;
    private StateListDrawable k;
    private com.google.android.material.l.i l;
    private AccessibilityManager m;
    private ValueAnimator n;
    private ValueAnimator o;

    static {
        f13680d = Build.VERSION.SDK_INT >= 21;
    }

    s(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f13681e = new k(this);
        this.f13682f = new l(this, this.f13683a);
        this.g = new m(this);
        this.h = false;
        this.i = false;
        this.j = Long.MAX_VALUE;
    }

    @Override // com.google.android.material.textfield.t
    boolean a(int i) {
        return i != 0;
    }

    @Override // com.google.android.material.textfield.t
    boolean b() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new n(this, autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(new o(this));
        if (f13680d) {
            autoCompleteTextView.setOnDismissListener(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (d()) {
            this.h = false;
        }
        if (!this.h) {
            if (f13680d) {
                a(!this.i);
            } else {
                this.i = !this.i;
                this.f13685c.toggle();
            }
            if (this.i) {
                autoCompleteTextView.requestFocus();
                autoCompleteTextView.showDropDown();
                return;
            } else {
                autoCompleteTextView.dismissDropDown();
                return;
            }
        }
        this.h = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AutoCompleteTextView autoCompleteTextView) {
        if (f13680d) {
            int boxBackgroundMode = this.f13683a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.l);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.k);
            }
        }
    }

    @Override // com.google.android.material.textfield.t
    void a() {
        float dimensionPixelOffset = this.f13684b.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.f13684b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f13684b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        com.google.android.material.l.i iVarA = a(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        com.google.android.material.l.i iVarA2 = a(WheelView.DividerConfig.FILL, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.l = iVarA;
        this.k = new StateListDrawable();
        this.k.addState(new int[]{android.R.attr.state_above_anchor}, iVarA);
        this.k.addState(new int[0], iVarA2);
        this.f13683a.setEndIconDrawable(androidx.appcompat.a.a.a.b(this.f13684b, f13680d ? R.drawable.mtrl_dropdown_arrow : R.drawable.mtrl_ic_arrow_drop_down));
        TextInputLayout textInputLayout = this.f13683a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.f13683a.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate$4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f13654a.d((AutoCompleteTextView) this.f13654a.f13683a.getEditText());
            }
        });
        this.f13683a.addOnEditTextAttachedListener(this.g);
        c();
        ViewCompat.f(this.f13685c, 2);
        this.m = (AccessibilityManager) this.f13684b.getSystemService("accessibility");
    }

    private void c() {
        this.o = a(67, WheelView.DividerConfig.FILL, 1.0f);
        this.n = a(50, 1.0f, WheelView.DividerConfig.FILL);
        this.n.addListener(new q(this));
    }

    private void b(AutoCompleteTextView autoCompleteTextView, int i, int[][] iArr, com.google.android.material.l.i iVar) {
        LayerDrawable layerDrawable;
        int iA = com.google.android.material.d.a.a(autoCompleteTextView, R.attr.colorSurface);
        com.google.android.material.l.i iVar2 = new com.google.android.material.l.i(iVar.l());
        int iA2 = com.google.android.material.d.a.a(i, iA, 0.1f);
        iVar2.a(new ColorStateList(iArr, new int[]{iA2, 0}));
        if (f13680d) {
            iVar2.setTint(iA);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iA2, iA});
            com.google.android.material.l.i iVar3 = new com.google.android.material.l.i(iVar.l());
            iVar3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, iVar2, iVar3), iVar});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{iVar2, iVar});
        }
        ViewCompat.a(autoCompleteTextView, layerDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.j;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView.getKeyListener() != null) {
            return;
        }
        int boxBackgroundMode = this.f13683a.getBoxBackgroundMode();
        com.google.android.material.l.i boxBackground = this.f13683a.getBoxBackground();
        int iA = com.google.android.material.d.a.a(autoCompleteTextView, R.attr.colorControlHighlight);
        int[][] iArr = {new int[]{android.R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode == 2) {
            b(autoCompleteTextView, iA, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            a(autoCompleteTextView, iA, iArr, boxBackground);
        }
    }

    private void a(AutoCompleteTextView autoCompleteTextView, int i, int[][] iArr, com.google.android.material.l.i iVar) {
        int boxBackgroundColor = this.f13683a.getBoxBackgroundColor();
        int[] iArr2 = {com.google.android.material.d.a.a(i, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (f13680d) {
            ViewCompat.a(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), iVar, iVar));
            return;
        }
        com.google.android.material.l.i iVar2 = new com.google.android.material.l.i(iVar.l());
        iVar2.a(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{iVar, iVar2});
        int iR = ViewCompat.r(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int iQ = ViewCompat.q(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        ViewCompat.a(autoCompleteTextView, layerDrawable);
        ViewCompat.b(autoCompleteTextView, iR, paddingTop, iQ, paddingBottom);
    }

    private com.google.android.material.l.i a(float f2, float f3, float f4, int i) {
        n.a aVarA = com.google.android.material.l.n.a();
        aVarA.d(f2);
        aVarA.e(f2);
        aVarA.b(f3);
        aVarA.c(f3);
        com.google.android.material.l.n nVarA = aVarA.a();
        com.google.android.material.l.i iVarA = com.google.android.material.l.i.a(this.f13684b, f4);
        iVarA.setShapeAppearanceModel(nVarA);
        iVarA.a(0, i, 0, i);
        return iVarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AutoCompleteTextView a(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.i != z) {
            this.i = z;
            this.o.cancel();
            this.n.start();
        }
    }

    private ValueAnimator a(int i, float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.a.a.f13081a);
        valueAnimatorOfFloat.setDuration(i);
        valueAnimatorOfFloat.addUpdateListener(new r(this));
        return valueAnimatorOfFloat;
    }
}
