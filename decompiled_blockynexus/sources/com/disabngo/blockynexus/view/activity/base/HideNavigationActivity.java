package com.disabngo.blockynexus.view.activity.base;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.base.app.BaseActivity;
import com.sandboxol.common.base.viewmodel.ViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class HideNavigationActivity<VM extends ViewModel, D extends ViewDataBinding> extends BaseActivity<VM, D> {
    private void g() {
        try {
            toggleHideBar();
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.disabngo.blockynexus.view.activity.base.a
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public final void onSystemUiVisibilityChange(int i) {
                    this.f10563a.b(i);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void b(int i) {
        if ((i & 4) == 0) {
            toggleHideBar();
        }
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            toggleHideBar();
        }
    }

    public void toggleHideBar() {
        if (getWindow() == null || getWindow().getDecorView() == null || Build.VERSION.SDK_INT <= 18) {
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }
}
