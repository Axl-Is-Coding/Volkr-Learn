package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.LinearLayoutCompat;
import io.rong.imkit.utils.FileTypeUtils;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.b, androidx.appcompat.view.menu.k {
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private MenuPresenter.a mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    MenuBuilder.a mMenuBuilderCallback;
    private int mMinCellSize;
    d mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private C0294g mPresenter;
    private boolean mReserveOverflow;

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f484c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f485d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f486e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f487f;

        @ViewDebug.ExportedProperty
        public boolean g;
        boolean h;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f484c = layoutParams.f484c;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f484c = false;
        }
    }

    public interface a {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    private static class b implements MenuPresenter.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.a
        public void a(MenuBuilder menuBuilder, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.a
        public boolean a(MenuBuilder menuBuilder) {
            return false;
        }
    }

    public interface d {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    static int measureChildForCells(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = actionMenuItemView != null && actionMenuItemView.hasText();
        int i5 = 2;
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), iMakeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z || i6 >= 2) {
                i5 = i6;
            }
        }
        layoutParams.f487f = !layoutParams.f484c && z;
        layoutParams.f485d = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, FileTypeUtils.GIGABYTE), iMakeMeasureSpec);
        return i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x023b A[ADDED_TO_REGION, LOOP:5: B:138:0x023b->B:143:0x025a, LOOP_START, PHI: r13
      0x023b: PHI (r13v4 int) = (r13v3 int), (r13v5 int) binds: [B:137:0x0239, B:143:0x025a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0262  */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void onMeasureExactFormat(int r30, int r31) {
        /*
            Method dump skipped, instruction units count: 618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.onMeasureExactFormat(int, int):void");
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dismissPopupMenus() {
        C0294g c0294g = this.mPresenter;
        if (c0294g != null) {
            c0294g.c();
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.f484c = true;
        return layoutParamsGenerateDefaultLayoutParams;
    }

    public Menu getMenu() {
        if (this.mMenu == null) {
            Context context = getContext();
            this.mMenu = new MenuBuilder(context);
            this.mMenu.setCallback(new c());
            this.mPresenter = new C0294g(context);
            this.mPresenter.d(true);
            C0294g c0294g = this.mPresenter;
            MenuPresenter.a bVar = this.mActionMenuPresenterCallback;
            if (bVar == null) {
                bVar = new b();
            }
            c0294g.setCallback(bVar);
            this.mMenu.a(this.mPresenter, this.mPopupContext);
            this.mPresenter.a(this);
        }
        return this.mMenu;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.mPresenter.d();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public int getWindowAnimations() {
        return 0;
    }

    protected boolean hasSupportDividerBeforeChildAt(int i) {
        boolean zNeedsDividerAfter = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            zNeedsDividerAfter = false | ((a) childAt).needsDividerAfter();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? zNeedsDividerAfter : zNeedsDividerAfter | ((a) childAt2).needsDividerBefore();
    }

    public boolean hideOverflowMenu() {
        C0294g c0294g = this.mPresenter;
        return c0294g != null && c0294g.e();
    }

    @Override // androidx.appcompat.view.menu.k
    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.b
    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.a(menuItemImpl, 0);
    }

    public boolean isOverflowMenuShowPending() {
        C0294g c0294g = this.mPresenter;
        return c0294g != null && c0294g.g();
    }

    public boolean isOverflowMenuShowing() {
        C0294g c0294g = this.mPresenter;
        return c0294g != null && c0294g.h();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0294g c0294g = this.mPresenter;
        if (c0294g != null) {
            c0294g.a(false);
            if (this.mPresenter.h()) {
                this.mPresenter.e();
                this.mPresenter.j();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int width;
        int paddingLeft;
        if (!this.mFormatItems) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i8 = i3 - i;
        int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
        boolean zA = ta.a(this);
        int measuredWidth = paddingRight;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f484c) {
                    int measuredWidth2 = childAt.getMeasuredWidth();
                    if (hasSupportDividerBeforeChildAt(i11)) {
                        measuredWidth2 += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zA) {
                        paddingLeft = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                        width = paddingLeft + measuredWidth2;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        paddingLeft = width - measuredWidth2;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i12, width, measuredHeight + i12);
                    measuredWidth -= measuredWidth2;
                    i9 = 1;
                } else {
                    measuredWidth -= (childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    hasSupportDividerBeforeChildAt(i11);
                    i10++;
                }
            }
        }
        if (childCount == 1 && i9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth3 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth3 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth3 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i10 - (i9 ^ 1);
        if (i15 > 0) {
            i6 = measuredWidth / i15;
            i5 = 0;
        } else {
            i5 = 0;
            i6 = 0;
        }
        int iMax = Math.max(i5, i6);
        if (zA) {
            int width2 = getWidth() - getPaddingRight();
            while (i5 < childCount) {
                View childAt3 = getChildAt(i5);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f484c) {
                    int i16 = width2 - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                    int measuredWidth4 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i17 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i16 - measuredWidth4, i17, i16, measuredHeight3 + i17);
                    width2 = i16 - ((measuredWidth4 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin) + iMax);
                }
                i5++;
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        while (i5 < childCount) {
            View childAt4 = getChildAt(i5);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f484c) {
                int i18 = paddingLeft2 + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin;
                int measuredWidth5 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i19 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i18, i19, i18 + measuredWidth5, measuredHeight4 + i19);
                paddingLeft2 = i18 + measuredWidth5 + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin + iMax;
            }
            i5++;
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i, int i2) {
        MenuBuilder menuBuilder;
        boolean z = this.mFormatItems;
        this.mFormatItems = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.mFormatItems) {
            this.mFormatItemsWidth = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.mFormatItems && (menuBuilder = this.mMenu) != null && size != this.mFormatItemsWidth) {
            this.mFormatItemsWidth = size;
            menuBuilder.b(true);
        }
        int childCount = getChildCount();
        if (this.mFormatItems && childCount > 0) {
            onMeasureExactFormat(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.mPresenter.c(z);
    }

    public void setMenuCallbacks(MenuPresenter.a aVar, MenuBuilder.a aVar2) {
        this.mActionMenuPresenterCallback = aVar;
        this.mMenuBuilderCallback = aVar2;
    }

    public void setOnMenuItemClickListener(d dVar) {
        this.mOnMenuItemClickListener = dVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.mPresenter.a(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.mReserveOverflow = z;
    }

    public void setPopupTheme(int i) {
        if (this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(C0294g c0294g) {
        this.mPresenter = c0294g;
        this.mPresenter.a(this);
    }

    public boolean showOverflowMenu() {
        C0294g c0294g = this.mPresenter;
        return c0294g != null && c0294g.j();
    }

    private class c implements MenuBuilder.a {
        c() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.a
        public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
            d dVar = ActionMenuView.this.mOnMenuItemClickListener;
            return dVar != null && dVar.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.a
        public void a(MenuBuilder menuBuilder) {
            MenuBuilder.a aVar = ActionMenuView.this.mMenuBuilderCallback;
            if (aVar != null) {
                aVar.a(menuBuilder);
            }
        }
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * f2);
        this.mGeneratedItemPadding = (int) (f2 * 4.0f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.f544b = 16;
        return layoutParams;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
            if (layoutParams2.f544b <= 0) {
                layoutParams2.f544b = 16;
            }
            return layoutParams2;
        }
        return generateDefaultLayoutParams();
    }
}
