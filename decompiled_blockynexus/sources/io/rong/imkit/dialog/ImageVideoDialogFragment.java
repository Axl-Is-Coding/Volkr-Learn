package io.rong.imkit.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.utilities.RongUtils;

/* JADX INFO: loaded from: classes5.dex */
public class ImageVideoDialogFragment extends DialogInterfaceOnCancelListenerC0327e implements View.OnClickListener {
    private static final String TAG = "ImageVideoDialogFragment";
    private boolean hasImage;
    private boolean hasSight;
    protected Dialog mDialog;
    private ImageVideoDialogListener mListener;
    protected View mRootView;

    public interface ImageVideoDialogListener {
        void onImageClick(View view);

        void onSightClick(View view);
    }

    protected int getGravity() {
        return 80;
    }

    protected float getHorizontalMovement() {
        return WheelView.DividerConfig.FILL;
    }

    protected float getScreenWidthProportion() {
        return 1.0f;
    }

    protected float getVerticalMovement() {
        return WheelView.DividerConfig.FILL;
    }

    public void hideDialog() {
        dismissAllowingStateLoss();
    }

    protected void initView() {
        TextView textView = (TextView) this.mRootView.findViewById(R.id.tv_sight);
        TextView textView2 = (TextView) this.mRootView.findViewById(R.id.tv_cancel);
        View viewFindViewById = this.mRootView.findViewById(R.id.view_horizontal);
        TextView textView3 = (TextView) this.mRootView.findViewById(R.id.tv_album);
        if (!this.hasSight) {
            textView.setVisibility(8);
            viewFindViewById.setVisibility(8);
        }
        if (!this.hasImage) {
            textView3.setVisibility(8);
            viewFindViewById.setVisibility(8);
        }
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
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
        ImageVideoDialogListener imageVideoDialogListener;
        int id = view.getId();
        if (id == R.id.tv_sight) {
            ImageVideoDialogListener imageVideoDialogListener2 = this.mListener;
            if (imageVideoDialogListener2 != null) {
                imageVideoDialogListener2.onSightClick(view);
            }
        } else if (id == R.id.tv_album && (imageVideoDialogListener = this.mListener) != null) {
            imageVideoDialogListener.onImageClick(view);
        }
        hideDialog();
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, android.R.style.Theme.Holo.Light.Dialog.MinWidth);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.rc_dialog_video_image, viewGroup, false);
        initView();
        return this.mRootView;
    }

    public void setHasImage(boolean z) {
        this.hasImage = z;
    }

    public void setHasSight(boolean z) {
        this.hasSight = z;
    }

    public void setImageVideoDialogListener(ImageVideoDialogListener imageVideoDialogListener) {
        this.mListener = imageVideoDialogListener;
    }

    public void show(AbstractC0336n abstractC0336n) {
        if (!this.hasSight && !this.hasImage) {
            if (getContext() != null) {
                Toast.makeText(getContext(), getContext().getResources().getString(R.string.rc_no_plugin), 0).show();
                return;
            }
            return;
        }
        try {
            show(abstractC0336n, "");
            setCancelable(true);
            if (this.mDialog != null) {
                this.mDialog.setCanceledOnTouchOutside(true);
            }
        } catch (IllegalStateException e2) {
            RLog.e(TAG, "show", e2);
        }
    }
}
