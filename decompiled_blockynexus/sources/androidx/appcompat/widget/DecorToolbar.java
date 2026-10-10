package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;

/* JADX INFO: loaded from: classes.dex */
public interface DecorToolbar {
    androidx.core.view.F a(int i, long j);

    void a(int i);

    void a(SparseArray<Parcelable> sparseArray);

    void a(View view);

    void a(MenuPresenter.a aVar, MenuBuilder.a aVar2);

    void a(ScrollingTabContainerView scrollingTabContainerView);

    void a(boolean z);

    boolean a();

    Menu b();

    void b(int i);

    void b(SparseArray<Parcelable> sparseArray);

    void b(boolean z);

    int c();

    boolean canShowOverflowMenu();

    void collapseActionView();

    boolean d();

    ViewGroup e();

    void f();

    void g();

    Context getContext();

    CharSequence getTitle();

    View h();

    boolean hideOverflowMenu();

    boolean i();

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    int j();

    void k();

    void setIcon(int i);

    void setIcon(Drawable drawable);

    void setMenu(Menu menu, MenuPresenter.a aVar);

    void setMenuPrepared();

    void setTitle(CharSequence charSequence);

    void setVisibility(int i);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    boolean showOverflowMenu();
}
