package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.utils.CommonHelper;

/* JADX INFO: loaded from: classes.dex */
public class ShopPopupWindow extends PopupWindow {
    private Context context;
    private OnMoreItemClickListener onMoreItemClickListener;

    public interface OnMoreItemClickListener {
        void a();

        void onClick(View view, int i);
    }

    public ShopPopupWindow(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    private void initView() {
        final View viewInflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.view_shop_window, (ViewGroup) null);
        setContentView(viewInflate);
        setWidth(CommonHelper.dip2px(this.context, 50.0f));
        setHeight(-2);
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(1711276032));
        ((RadioGroup) viewInflate.findViewById(R.id.rgType)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.disabngo.blockynexus.view.widget.i
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f12100a.a(viewInflate, radioGroup, i);
            }
        });
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.disabngo.blockynexus.view.widget.h
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                this.f12099a.a();
            }
        });
    }

    public /* synthetic */ void a(View view, RadioGroup radioGroup, int i) {
        this.onMoreItemClickListener.onClick(view, i);
        dismiss();
    }

    public void setOnMoreItemClickListener(OnMoreItemClickListener onMoreItemClickListener) {
        this.onMoreItemClickListener = onMoreItemClickListener;
    }

    public void showLocation(View view) {
        showAsDropDown(view);
    }

    public /* synthetic */ void a() {
        this.onMoreItemClickListener.a();
    }
}
