package com.sandboxol.common.dialog;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class HideNavigationBarDialog extends FullScreenDialog {
    public HideNavigationBarDialog(Context context) {
        super(context);
    }

    private void initWindow() {
        try {
            toggleHideBar();
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.sandboxol.common.dialog.a
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public final void onSystemUiVisibilityChange(int i) {
                    this.f16901a.a(i);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void toggleHideBar() {
        if (getWindow() == null || getWindow().getDecorView() == null || Build.VERSION.SDK_INT <= 18) {
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public /* synthetic */ void a(int i) {
        if ((i & 4) == 0) {
            toggleHideBar();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initWindow();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            toggleHideBar();
        }
    }
}
