package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.j;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements androidx.core.view.v {
    private static final int[] ATTRS_ANDROID_SPINNERMODE = {R.attr.spinnerMode};
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "AppCompatSpinner";
    private final C0303p mBackgroundTintHelper;
    int mDropDownWidth;
    private I mForwardingListener;
    private d mPopup;
    private final Context mPopupContext;
    private final boolean mPopupSet;
    private SpinnerAdapter mTempAdapter;
    final Rect mTempRect;

    class DialogPopup implements DialogInterface.OnClickListener, d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        androidx.appcompat.app.j f498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ListAdapter f499b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f500c;

        DialogPopup() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public int a() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(ListAdapter listAdapter) {
            this.f499b = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public CharSequence b() {
            return this.f500c;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public boolean c() {
            androidx.appcompat.app.j jVar = this.f498a;
            if (jVar != null) {
                return jVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public Drawable d() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void dismiss() {
            androidx.appcompat.app.j jVar = this.f498a;
            if (jVar != null) {
                jVar.dismiss();
                this.f498a = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public int e() {
            return 0;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            AppCompatSpinner.this.setSelection(i);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, i, this.f499b.getItemId(i));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(CharSequence charSequence) {
            this.f500c = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void b(int i) {
            Log.e(AppCompatSpinner.TAG, "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void c(int i) {
            Log.e(AppCompatSpinner.TAG, "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(int i, int i2) {
            if (this.f499b == null) {
                return;
            }
            j.a aVar = new j.a(AppCompatSpinner.this.getPopupContext());
            CharSequence charSequence = this.f500c;
            if (charSequence != null) {
                aVar.b(charSequence);
            }
            aVar.a(this.f499b, AppCompatSpinner.this.getSelectedItemPosition(), this);
            this.f498a = aVar.a();
            ListView listViewB = this.f498a.b();
            if (Build.VERSION.SDK_INT >= 17) {
                listViewB.setTextDirection(i);
                listViewB.setTextAlignment(i2);
            }
            this.f498a.show();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(Drawable drawable) {
            Log.e(AppCompatSpinner.TAG, "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(int i) {
            Log.e(AppCompatSpinner.TAG, "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }
    }

    private static class a implements ListAdapter, SpinnerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SpinnerAdapter f502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ListAdapter f503b;

        public a(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f502a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f503b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof ea) {
                    ea eaVar = (ea) spinnerAdapter;
                    if (eaVar.getDropDownViewTheme() == null) {
                        eaVar.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f503b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f502a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f502a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.f502a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.f502a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f502a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f503b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f502a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f502a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    class b extends ListPopupWindow implements d {
        private CharSequence K;
        ListAdapter L;
        private final Rect M;
        private int N;

        public b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.M = new Rect();
            a(AppCompatSpinner.this);
            a(true);
            i(0);
            a(new C0312z(this, AppCompatSpinner.this));
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public CharSequence b() {
            return this.K;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void c(int i) {
            this.N = i;
        }

        void l() {
            Drawable drawableD = d();
            int i = 0;
            if (drawableD != null) {
                drawableD.getPadding(AppCompatSpinner.this.mTempRect);
                i = ta.a(AppCompatSpinner.this) ? AppCompatSpinner.this.mTempRect.right : -AppCompatSpinner.this.mTempRect.left;
            } else {
                Rect rect = AppCompatSpinner.this.mTempRect;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i2 = appCompatSpinner.mDropDownWidth;
            if (i2 == -2) {
                int iCompatMeasureContentWidth = appCompatSpinner.compatMeasureContentWidth((SpinnerAdapter) this.L, d());
                int i3 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.mTempRect;
                int i4 = (i3 - rect2.left) - rect2.right;
                if (iCompatMeasureContentWidth > i4) {
                    iCompatMeasureContentWidth = i4;
                }
                e(Math.max(iCompatMeasureContentWidth, (width - paddingLeft) - paddingRight));
            } else if (i2 == -1) {
                e((width - paddingLeft) - paddingRight);
            } else {
                e(i2);
            }
            a(ta.a(AppCompatSpinner.this) ? i + (((width - paddingRight) - i()) - m()) : i + paddingLeft + m());
        }

        public int m() {
            return this.N;
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.d
        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.L = listAdapter;
        }

        boolean b(View view) {
            return ViewCompat.B(view) && view.getGlobalVisibleRect(this.M);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(CharSequence charSequence) {
            this.K = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean zC = c();
            l();
            h(2);
            super.show();
            ListView listViewF = f();
            listViewF.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                listViewF.setTextDirection(i);
                listViewF.setTextAlignment(i2);
            }
            j(AppCompatSpinner.this.getSelectedItemPosition());
            if (zC || (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            A a2 = new A(this);
            viewTreeObserver.addOnGlobalLayoutListener(a2);
            a(new B(this, a2));
        }
    }

    static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new C();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f504a;

        c(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f504a ? (byte) 1 : (byte) 0);
        }

        c(Parcel parcel) {
            super(parcel);
            this.f504a = parcel.readByte() != 0;
        }
    }

    interface d {
        int a();

        void a(int i);

        void a(int i, int i2);

        void a(Drawable drawable);

        void a(ListAdapter listAdapter);

        void a(CharSequence charSequence);

        CharSequence b();

        void b(int i);

        void c(int i);

        boolean c();

        Drawable d();

        void dismiss();

        int e();
    }

    public AppCompatSpinner(Context context) {
        this(context, (AttributeSet) null);
    }

    int compatMeasureContentWidth(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.mTempRect);
        Rect rect = this.mTempRect;
        return iMax2 + rect.left + rect.right;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        d dVar = this.mPopup;
        if (dVar != null) {
            return dVar.a();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        d dVar = this.mPopup;
        if (dVar != null) {
            return dVar.e();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.mPopup != null) {
            return this.mDropDownWidth;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    final d getInternalPopup() {
        return this.mPopup;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        d dVar = this.mPopup;
        if (dVar != null) {
            return dVar.d();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.mPopupContext;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        d dVar = this.mPopup;
        return dVar != null ? dVar.b() : super.getPrompt();
    }

    @Override // androidx.core.view.v
    public ColorStateList getSupportBackgroundTintList() {
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            return c0303p.b();
        }
        return null;
    }

    @Override // androidx.core.view.v
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            return c0303p.c();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.mPopup;
        if (dVar == null || !dVar.c()) {
            return;
        }
        this.mPopup.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mPopup == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        if (!cVar.f504a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0311y(this));
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        d dVar = this.mPopup;
        cVar.f504a = dVar != null && dVar.c();
        return cVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        I i = this.mForwardingListener;
        if (i == null || !i.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        d dVar = this.mPopup;
        if (dVar == null) {
            return super.performClick();
        }
        if (dVar.c()) {
            return true;
        }
        showPopup();
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.a(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        d dVar = this.mPopup;
        if (dVar != null) {
            dVar.c(i);
            this.mPopup.a(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        d dVar = this.mPopup;
        if (dVar != null) {
            dVar.b(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.mPopup != null) {
            this.mDropDownWidth = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        d dVar = this.mPopup;
        if (dVar != null) {
            dVar.a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(androidx.appcompat.a.a.a.b(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        d dVar = this.mPopup;
        if (dVar != null) {
            dVar.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // androidx.core.view.v
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.b(colorStateList);
        }
    }

    @Override // androidx.core.view.v
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.a(mode);
        }
    }

    void showPopup() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.mPopup.a(getTextDirection(), getTextAlignment());
        } else {
            this.mPopup.a(-1, -1);
        }
    }

    public AppCompatSpinner(Context context, int i) {
        this(context, null, androidx.appcompat.R.attr.spinnerStyle, i);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.mPopupSet) {
            this.mTempAdapter = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.mPopup != null) {
            Context context = this.mPopupContext;
            if (context == null) {
                context = getContext();
            }
            this.mPopup.a(new a(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004a A[PHI: r10 r11
      0x004a: PHI (r10v2 int) = (r10v0 int), (r10v4 int) binds: [B:24:0x005c, B:15:0x0048] A[DONT_GENERATE, DONT_INLINE]
      0x004a: PHI (r11v9 android.content.res.TypedArray) = (r11v8 android.content.res.TypedArray), (r11v11 android.content.res.TypedArray) binds: [B:24:0x005c, B:15:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AppCompatSpinner(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
