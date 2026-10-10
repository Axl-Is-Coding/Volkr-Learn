package cn.qqtheme.framework.popup;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import cn.qqtheme.framework.util.LogUtils;
import cn.qqtheme.framework.util.ScreenUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasicPopup<V extends View> implements DialogInterface.OnKeyListener, DialogInterface.OnDismissListener {
    public static final int MATCH_PARENT = -1;
    public static final int WRAP_CONTENT = -2;
    protected Activity activity;
    private FrameLayout contentLayout;
    private Dialog dialog;
    private boolean isPrepared = false;
    protected int screenHeightPixels;
    protected int screenWidthPixels;

    public BasicPopup(Activity activity) {
        this.activity = activity;
        DisplayMetrics displayMetrics = ScreenUtils.displayMetrics(activity);
        this.screenWidthPixels = displayMetrics.widthPixels;
        this.screenHeightPixels = displayMetrics.heightPixels;
        initDialog();
    }

    private void initDialog() {
        this.contentLayout = new FrameLayout(this.activity);
        this.contentLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.contentLayout.setFocusable(true);
        this.contentLayout.setFocusableInTouchMode(true);
        this.dialog = new Dialog(this.activity);
        this.dialog.setCanceledOnTouchOutside(true);
        this.dialog.setCancelable(true);
        this.dialog.setOnKeyListener(this);
        this.dialog.setOnDismissListener(this);
        Window window = this.dialog.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.requestFeature(1);
            window.setContentView(this.contentLayout);
        }
        setSize(this.screenWidthPixels, -2);
    }

    public void dismiss() {
        dismissImmediately();
    }

    protected final void dismissImmediately() {
        this.dialog.dismiss();
        LogUtils.verbose(this, "popup dismiss");
    }

    public View getContentView() {
        return this.contentLayout.getChildAt(0);
    }

    public Context getContext() {
        return this.dialog.getContext();
    }

    public ViewGroup getRootView() {
        return this.contentLayout;
    }

    public int getScreenHeightPixels() {
        return this.screenHeightPixels;
    }

    public int getScreenWidthPixels() {
        return this.screenWidthPixels;
    }

    public Window getWindow() {
        return this.dialog.getWindow();
    }

    public boolean isShowing() {
        return this.dialog.isShowing();
    }

    protected abstract V makeContentView();

    public boolean onBackPress() {
        dismiss();
        return false;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        dismiss();
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 4) {
            return false;
        }
        onBackPress();
        return false;
    }

    public void setAnimationStyle(int i) {
        Window window = this.dialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(i);
        }
    }

    public void setCancelable(boolean z) {
        this.dialog.setCancelable(z);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.dialog.setCanceledOnTouchOutside(z);
    }

    public void setContentView(View view) {
        this.contentLayout.removeAllViews();
        this.contentLayout.addView(view);
    }

    protected void setContentViewAfter(V v) {
    }

    protected void setContentViewBefore() {
    }

    public void setFillScreen(boolean z) {
        if (z) {
            setSize(this.screenWidthPixels, (int) (this.screenHeightPixels * 0.85f));
        }
    }

    public void setFitsSystemWindows(boolean z) {
        this.contentLayout.setFitsSystemWindows(z);
    }

    public void setGravity(int i) {
        Window window = this.dialog.getWindow();
        if (window != null) {
            window.setGravity(i);
        }
        if (i == 17) {
            setWidth((int) (this.screenWidthPixels * 0.7f));
        }
    }

    public void setHalfScreen(boolean z) {
        if (z) {
            setSize(this.screenWidthPixels, this.screenHeightPixels / 2);
        }
    }

    public void setHeight(int i) {
        setSize(0, i);
    }

    public void setOnDismissListener(final DialogInterface.OnDismissListener onDismissListener) {
        this.dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: cn.qqtheme.framework.popup.BasicPopup.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                BasicPopup.this.onDismiss(dialogInterface);
                onDismissListener.onDismiss(dialogInterface);
            }
        });
        LogUtils.verbose(this, "popup setOnDismissListener");
    }

    public void setOnKeyListener(final DialogInterface.OnKeyListener onKeyListener) {
        this.dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: cn.qqtheme.framework.popup.BasicPopup.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                BasicPopup.this.onKey(dialogInterface, i, keyEvent);
                return onKeyListener.onKey(dialogInterface, i, keyEvent);
            }
        });
        LogUtils.verbose(this, "popup setOnKeyListener");
    }

    public void setPrepared(boolean z) {
        this.isPrepared = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setSize(int r4, int r5) {
        /*
            r3 = this;
            r0 = -1
            if (r4 != r0) goto L5
            int r4 = r3.screenWidthPixels
        L5:
            r0 = -2
            if (r4 != 0) goto Le
            if (r5 != 0) goto Le
            int r4 = r3.screenWidthPixels
        Lc:
            r5 = -2
            goto L16
        Le:
            if (r4 != 0) goto L13
            int r4 = r3.screenWidthPixels
            goto L16
        L13:
            if (r5 != 0) goto L16
            goto Lc
        L16:
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r0[r1] = r2
            r1 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            r0[r1] = r2
            java.lang.String r1 = "will set popup width/height to: %s/%s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            cn.qqtheme.framework.util.LogUtils.verbose(r3, r0)
            android.widget.FrameLayout r0 = r3.contentLayout
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            if (r0 != 0) goto L3e
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r0.<init>(r4, r5)
            goto L42
        L3e:
            r0.width = r4
            r0.height = r5
        L42:
            android.widget.FrameLayout r4 = r3.contentLayout
            r4.setLayoutParams(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.qqtheme.framework.popup.BasicPopup.setSize(int, int):void");
    }

    public void setWidth(int i) {
        setSize(i, 0);
    }

    public final void show() {
        if (this.isPrepared) {
            this.dialog.show();
            showAfter();
            return;
        }
        LogUtils.verbose(this, "do something before popup show");
        setContentViewBefore();
        View viewMakeContentView = makeContentView();
        setContentView(viewMakeContentView);
        setContentViewAfter(viewMakeContentView);
        this.isPrepared = true;
        this.dialog.show();
        showAfter();
    }

    protected void showAfter() {
        LogUtils.verbose(this, "popup show");
    }
}
