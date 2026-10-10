package com.sandboxol.recharge.dialog.rechargeshop;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import androidx.databinding.ObservableField;
import com.sandboxol.game.R;
import com.sandboxol.game.a.C;

/* JADX INFO: loaded from: classes4.dex */
public class StarCodeHelpPopupWindow extends PopupWindow {
    private C binding;
    public ObservableField<String> content;
    private Context context;
    public ObservableField<Boolean> isShow;
    private int popupHeight;
    private int popupWidth;
    private View view;

    public StarCodeHelpPopupWindow(Context context, String str) {
        super(context);
        this.isShow = new ObservableField<>(false);
        this.content = new ObservableField<>();
        this.context = context;
        this.content.set(str);
        initView();
    }

    private void initView() {
        this.binding = (C) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.game_popwindow_star_code_help, (ViewGroup) null, false);
        this.binding.a(this);
        setWidth(-2);
        setHeight(-2);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setContentView(this.binding.getRoot());
        this.binding.getRoot().measure(0, 0);
        this.popupHeight = this.binding.getRoot().getMeasuredHeight();
        this.popupWidth = this.binding.getRoot().getMeasuredWidth();
    }

    private void onAnimate(View view, int i) {
        if (i != 0) {
            try {
                view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), i));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        this.view.setVisibility(4);
        super.dismiss();
    }

    public void showLocation(View view) {
        this.view = view;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        showAtLocation(view, 0, iArr[0], iArr[1] - this.popupHeight);
        view.setVisibility(0);
    }

    public StarCodeHelpPopupWindow(Context context) {
        super(context);
        this.isShow = new ObservableField<>(false);
        this.content = new ObservableField<>();
        this.context = context;
        initView();
    }
}
