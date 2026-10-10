package io.rong.imkit.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.utilities.KitCommonDefine;
import io.rong.imkit.utilities.RongUtils;
import io.rong.imlib.common.SharedPreferencesUtils;

/* JADX INFO: loaded from: classes5.dex */
public class BurnHintDialog extends DialogInterfaceOnCancelListenerC0327e implements View.OnClickListener {
    private static final String TAG = "BurnHintDialog";
    private static boolean isFirstClick;
    protected Dialog mDialog;
    protected View mRootView;

    public static boolean isFirstClick(Context context) {
        if (!isFirstClick) {
            isFirstClick = SharedPreferencesUtils.get(context, KitCommonDefine.RONG_KIT_SP_CONFIG, 0).getBoolean(KitCommonDefine.IS_FIRST_USE_BURN, false);
        }
        return isFirstClick;
    }

    protected int getGravity() {
        return 17;
    }

    protected float getHorizontalMovement() {
        return WheelView.DividerConfig.FILL;
    }

    protected float getScreenWidthProportion() {
        return 0.75f;
    }

    protected float getVerticalMovement() {
        return WheelView.DividerConfig.FILL;
    }

    public void hideDialog() {
        dismissAllowingStateLoss();
    }

    protected void initView() {
        ((TextView) this.mRootView.findViewById(R.id.tv_confirm)).setOnClickListener(this);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Window window;
        super.onActivityCreated(bundle);
        this.mDialog = getDialog();
        Dialog dialog = this.mDialog;
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawableResource(android.R.color.transparent);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (getActivity() != null) {
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        window.setLayout((int) (displayMetrics.widthPixels * getScreenWidthProportion()), -2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = getGravity();
        attributes.x = -RongUtils.dip2px(getHorizontalMovement());
        attributes.y = RongUtils.dip2px(getVerticalMovement());
        window.setAttributes(attributes);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_confirm) {
            SharedPreferencesUtils.get(view.getContext(), KitCommonDefine.RONG_KIT_SP_CONFIG, 0).edit().putBoolean(KitCommonDefine.IS_FIRST_USE_BURN, true).apply();
            hideDialog();
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, android.R.style.Theme.Holo.Light.Dialog.MinWidth);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.rc_dialog_fire_hint, viewGroup, false);
        initView();
        return this.mRootView;
    }

    public void show(AbstractC0336n abstractC0336n) {
        try {
            show(abstractC0336n, "");
            setCancelable(false);
            if (this.mDialog != null) {
                this.mDialog.setCanceledOnTouchOutside(false);
            }
        } catch (IllegalStateException e2) {
            RLog.e(TAG, "show", e2);
        }
    }
}
