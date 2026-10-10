package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R;
import androidx.appcompat.app.j;
import androidx.appcompat.view.menu.MenuPresenter;
import com.sandboxol.center.config.IntConstant;

/* JADX INFO: loaded from: classes.dex */
class MenuDialogHelper implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, MenuPresenter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MenuBuilder f427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private androidx.appcompat.app.j f428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ListMenuPresenter f429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MenuPresenter.a f430d;

    public MenuDialogHelper(MenuBuilder menuBuilder) {
        this.f427a = menuBuilder;
    }

    public void a(IBinder iBinder) {
        MenuBuilder menuBuilder = this.f427a;
        j.a aVar = new j.a(menuBuilder.e());
        this.f429c = new ListMenuPresenter(aVar.b(), R.layout.abc_list_menu_item_layout);
        this.f429c.setCallback(this);
        this.f427a.a(this.f429c);
        aVar.a(this.f429c.c(), this);
        View viewI = menuBuilder.i();
        if (viewI != null) {
            aVar.a(viewI);
        } else {
            aVar.a(menuBuilder.g());
            aVar.b(menuBuilder.h());
        }
        aVar.a(this);
        this.f428b = aVar.a();
        this.f428b.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f428b.getWindow().getAttributes();
        attributes.type = IntConstant.PERMISSION_STORAGE_DOWNLOAD;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f428b.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f427a.a((MenuItemImpl) this.f429c.c().getItem(i), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f429c.a(this.f427a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f428b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f428b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f427a.a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f427a.performShortcut(i, keyEvent, 0);
    }

    public void setPresenterCallback(MenuPresenter.a aVar) {
        this.f430d = aVar;
    }

    public void a() {
        androidx.appcompat.app.j jVar = this.f428b;
        if (jVar != null) {
            jVar.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.a
    public void a(MenuBuilder menuBuilder, boolean z) {
        if (z || menuBuilder == this.f427a) {
            a();
        }
        MenuPresenter.a aVar = this.f430d;
        if (aVar != null) {
            aVar.a(menuBuilder, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.a
    public boolean a(MenuBuilder menuBuilder) {
        MenuPresenter.a aVar = this.f430d;
        if (aVar != null) {
            return aVar.a(menuBuilder);
        }
        return false;
    }
}
