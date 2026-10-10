package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ironsource.sdk.controller.WebController;

/* JADX INFO: loaded from: classes2.dex */
public class ControllerView extends FrameLayout implements b.f.d.g.g {
    private Context mContext;
    private WebController mWebViewController;

    public ControllerView(Context context) {
        super(context);
        this.mContext = context;
        setClickable(true);
    }

    private void addViewToWindow() {
        ((Activity) this.mContext).runOnUiThread(new C(this));
    }

    private int getNavigationBarPadding() {
        Activity activity = (Activity) this.mContext;
        try {
            if (Build.VERSION.SDK_INT <= 9) {
                return 0;
            }
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getDrawingRect(rect);
            Rect rect2 = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (com.ironsource.environment.b.f(activity) == 1) {
                if (rect.bottom - rect2.bottom > 0) {
                    return rect.bottom - rect2.bottom;
                }
                return 0;
            }
            if (rect.right - rect2.right > 0) {
                return rect.right - rect2.right;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    private int getStatusBarHeight() {
        int identifier;
        try {
            if (this.mContext == null || (identifier = this.mContext.getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
                return 0;
            }
            return this.mContext.getResources().getDimensionPixelSize(identifier);
        } catch (Exception unused) {
            return 0;
        }
    }

    private int getStatusBarPadding() {
        int statusBarHeight;
        if (!((((Activity) this.mContext).getWindow().getAttributes().flags & 1024) != 0) && (statusBarHeight = getStatusBarHeight()) > 0) {
            return statusBarHeight;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup getWindowDecorViewGroup() {
        Activity activity = (Activity) this.mContext;
        if (activity != null) {
            return (ViewGroup) activity.getWindow().getDecorView();
        }
        return null;
    }

    private void removeViewFromWindow() {
        ((Activity) this.mContext).runOnUiThread(new D(this));
    }

    private void setPaddingByOrientation(int i, int i2) {
        try {
            if (this.mContext != null) {
                int iF = com.ironsource.environment.b.f(this.mContext);
                if (iF == 1) {
                    setPadding(0, i, 0, i2);
                } else if (iF == 2) {
                    setPadding(0, i, i2, 0);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mWebViewController.resume();
        this.mWebViewController.viewableChange(true, "main");
    }

    @Override // b.f.d.g.g
    public boolean onBackButtonPressed() {
        return b.f.d.f.b.a().a((Activity) this.mContext);
    }

    @Override // b.f.d.g.g
    public void onCloseRequested() {
        removeViewFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mWebViewController.pause();
        this.mWebViewController.viewableChange(false, "main");
        WebController webController = this.mWebViewController;
        if (webController != null) {
            webController.setState(WebController.State.Gone);
            this.mWebViewController.removeVideoEventsListener();
        }
        removeAllViews();
    }

    @Override // b.f.d.g.g
    public void onOrientationChanged(String str, int i) {
    }

    public void showInterstitial(WebController webController) {
        this.mWebViewController = webController;
        this.mWebViewController.setOnWebViewControllerChangeListener(this);
        this.mWebViewController.requestFocus();
        this.mContext = this.mWebViewController.getCurrentActivityContext();
        setPaddingByOrientation(getStatusBarPadding(), getNavigationBarPadding());
        addViewToWindow();
    }
}
