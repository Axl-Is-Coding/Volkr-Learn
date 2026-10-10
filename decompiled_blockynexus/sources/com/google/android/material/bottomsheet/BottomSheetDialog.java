package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.x;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetDialog extends x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BottomSheetBehavior<FrameLayout> f13218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FrameLayout f13219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f13220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f13221f;
    private boolean g;
    private boolean h;
    private BottomSheetBehavior.a i;

    public BottomSheetDialog(Context context) {
        this(context, 0);
    }

    private View a(int i, View view, ViewGroup.LayoutParams layoutParams) {
        d();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f13219d.findViewById(R.id.coordinator);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, (ViewGroup) coordinatorLayout, false);
        }
        FrameLayout frameLayout = (FrameLayout) this.f13219d.findViewById(R.id.design_bottom_sheet);
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                if (bottomSheetDialog.f13221f && bottomSheetDialog.isShowing() && BottomSheetDialog.this.c()) {
                    BottomSheetDialog.this.cancel();
                }
            }
        });
        ViewCompat.a(frameLayout, new f(this));
        frameLayout.setOnTouchListener(new g(this));
        return this.f13219d;
    }

    private FrameLayout d() {
        if (this.f13219d == null) {
            this.f13219d = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
            this.f13218c = BottomSheetBehavior.b((FrameLayout) this.f13219d.findViewById(R.id.design_bottom_sheet));
            this.f13218c.addBottomSheetCallback(this.i);
            this.f13218c.b(this.f13221f);
        }
        return this.f13219d;
    }

    public BottomSheetBehavior<FrameLayout> b() {
        if (this.f13218c == null) {
            d();
        }
        return this.f13218c;
    }

    boolean c() {
        if (!this.h) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
            this.g = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
            this.h = true;
        }
        return this.g;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> bottomSheetBehaviorB = b();
        if (!this.f13220e || bottomSheetBehaviorB.b() == 5) {
            super.cancel();
        } else {
            bottomSheetBehaviorB.e(5);
        }
    }

    @Override // androidx.appcompat.app.x, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f13218c;
        if (bottomSheetBehavior == null || bottomSheetBehavior.b() != 5) {
            return;
        }
        this.f13218c.e(4);
    }

    void removeDefaultCallback() {
        this.f13218c.removeBottomSheetCallback(this.i);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.f13221f != z) {
            this.f13221f = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f13218c;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.b(z);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f13221f) {
            this.f13221f = true;
        }
        this.g = z;
        this.h = true;
    }

    @Override // androidx.appcompat.app.x, android.app.Dialog
    public void setContentView(int i) {
        super.setContentView(a(i, null, null));
    }

    public BottomSheetDialog(Context context, int i) {
        super(context, b(context, i));
        this.f13221f = true;
        this.g = true;
        this.i = new h(this);
        a(1);
    }

    @Override // androidx.appcompat.app.x, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(a(0, view, null));
    }

    @Override // androidx.appcompat.app.x, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(a(0, view, layoutParams));
    }

    private static int b(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true)) {
            return typedValue.resourceId;
        }
        return R.style.Theme_Design_Light_BottomSheetDialog;
    }
}
