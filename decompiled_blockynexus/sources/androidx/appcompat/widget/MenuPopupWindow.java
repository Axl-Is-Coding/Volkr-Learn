package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class MenuPopupWindow extends ListPopupWindow implements L {
    private static Method K;
    private L L;

    public static class MenuDropDownListView extends G {
        final int mAdvanceKey;
        private L mHoverListener;
        private MenuItem mHoveredMenuItem;
        final int mRetreatKey;

        public MenuDropDownListView(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.mAdvanceKey = 22;
                this.mRetreatKey = 21;
            } else {
                this.mAdvanceKey = 21;
                this.mRetreatKey = 22;
            }
        }

        public void clearSelection() {
            setSelection(-1);
        }

        @Override // androidx.appcompat.widget.G, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.G, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.G, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.G, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.G
        public /* bridge */ /* synthetic */ int lookForSelectablePosition(int i, boolean z) {
            return super.lookForSelectablePosition(i, z);
        }

        @Override // androidx.appcompat.widget.G
        public /* bridge */ /* synthetic */ int measureHeightOfChildrenCompat(int i, int i2, int i3, int i4, int i5) {
            return super.measureHeightOfChildrenCompat(i, i2, i3, i4, i5);
        }

        @Override // androidx.appcompat.widget.G
        public /* bridge */ /* synthetic */ boolean onForwardedEvent(MotionEvent motionEvent, int i) {
            return super.onForwardedEvent(motionEvent, i);
        }

        @Override // androidx.appcompat.widget.G, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int headersCount;
            MenuAdapter menuAdapter;
            int iPointToPosition;
            int i;
            if (this.mHoverListener != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    menuAdapter = (MenuAdapter) adapter;
                }
                MenuItemImpl item = null;
                if (motionEvent.getAction() != 10 && (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i = iPointToPosition - headersCount) >= 0 && i < menuAdapter.getCount()) {
                    item = menuAdapter.getItem(i);
                }
                MenuItem menuItem = this.mHoveredMenuItem;
                if (menuItem != item) {
                    MenuBuilder adapterMenu = menuAdapter.getAdapterMenu();
                    if (menuItem != null) {
                        this.mHoverListener.b(adapterMenu, menuItem);
                    }
                    this.mHoveredMenuItem = item;
                    if (item != null) {
                        this.mHoverListener.a(adapterMenu, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.mAdvanceKey) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i != this.mRetreatKey) {
                return super.onKeyDown(i, keyEvent);
            }
            setSelection(-1);
            ((MenuAdapter) getAdapter()).getAdapterMenu().a(false);
            return true;
        }

        @Override // androidx.appcompat.widget.G, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(L l) {
            this.mHoverListener = l;
        }

        @Override // androidx.appcompat.widget.G, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                K = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    G a(Context context, boolean z) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.J.setExitTransition((Transition) obj);
        }
    }

    public void c(boolean z) {
        if (Build.VERSION.SDK_INT > 28) {
            this.J.setTouchModal(z);
            return;
        }
        Method method = K;
        if (method != null) {
            try {
                method.invoke(this.J, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.J.setEnterTransition((Transition) obj);
        }
    }

    @Override // androidx.appcompat.widget.L
    public void b(MenuBuilder menuBuilder, MenuItem menuItem) {
        L l = this.L;
        if (l != null) {
            l.b(menuBuilder, menuItem);
        }
    }

    public void a(L l) {
        this.L = l;
    }

    @Override // androidx.appcompat.widget.L
    public void a(MenuBuilder menuBuilder, MenuItem menuItem) {
        L l = this.L;
        if (l != null) {
            l.a(menuBuilder, menuItem);
        }
    }
}
