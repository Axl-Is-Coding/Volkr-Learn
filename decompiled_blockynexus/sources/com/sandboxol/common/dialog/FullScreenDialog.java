package com.sandboxol.common.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.common.R;
import com.sandboxol.common.utils.BlurUtil;
import com.sandboxol.common.utils.CommonHelper;

/* JADX INFO: loaded from: classes3.dex */
public class FullScreenDialog extends Dialog {
    protected Context context;
    private View[] innerViews;

    public FullScreenDialog(Context context) {
        super(context, R.style.FullScreenTheme);
        this.context = context;
        init(context);
    }

    private void initBackground(Context context) {
        if (getWindow() == null) {
            return;
        }
        if (!isBlurBackground()) {
            getWindow().setBackgroundDrawableResource(R.color.dialog_shadow);
            return;
        }
        if (!(context instanceof Activity)) {
            getWindow().setBackgroundDrawableResource(R.color.dialog_shadow);
            return;
        }
        Bitmap bitmapBlur = BlurUtil.blur(context, CommonHelper.getViewBitmap(((Activity) context).getWindow().getDecorView()), getBlurScale(), getBlurRadius());
        if (bitmapBlur == null) {
            getWindow().setBackgroundDrawableResource(R.color.dialog_shadow);
            return;
        }
        Window window = getWindow();
        Resources resources = context.getResources();
        makeShadowBitmap(bitmapBlur);
        window.setBackgroundDrawable(new BitmapDrawable(resources, bitmapBlur));
    }

    private boolean isTouchPointInView(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        return i2 >= i4 && i2 <= view.getMeasuredHeight() + i4 && i >= i3 && i <= view.getMeasuredWidth() + i3;
    }

    private Bitmap makeShadowBitmap(Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(1);
        paint.setColor(-16777216);
        paint.setAlpha(65);
        canvas.drawRect(new RectF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, bitmap.getWidth(), bitmap.getHeight()), paint);
        return bitmap;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Context context = this.context;
        if (context == null || ((Activity) context).isFinishing()) {
            return;
        }
        super.dismiss();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        View[] viewArr = this.innerViews;
        if (viewArr == null || viewArr.length == 0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        for (View view : viewArr) {
            if (isTouchPointInView(view, rawX, rawY)) {
                return super.dispatchTouchEvent(motionEvent);
            }
        }
        dismiss();
        return true;
    }

    protected int getBlurRadius() {
        return 8;
    }

    protected float getBlurScale() {
        return 8.0f;
    }

    protected void init(Context context) {
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        requestWindowFeature(1);
        initBackground(context);
        if (getWindow() != null) {
            getWindow().setWindowAnimations(R.style.cloudDialogWindowAnim);
        }
    }

    protected boolean isBlurBackground() {
        return false;
    }

    public void setInnerViews(View... viewArr) {
        this.innerViews = viewArr;
    }

    @Override // android.app.Dialog
    public void show() {
        Context context = this.context;
        if (context == null || !(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17) {
            super.show();
        } else {
            if (((Activity) this.context).isDestroyed()) {
                return;
            }
            super.show();
        }
    }

    protected void slideToUp(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, WheelView.DividerConfig.FILL, 1, WheelView.DividerConfig.FILL, 1, 1.0f, 1, WheelView.DividerConfig.FILL);
        translateAnimation.setDuration(200L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setFillEnabled(true);
        view.startAnimation(translateAnimation);
    }
}
