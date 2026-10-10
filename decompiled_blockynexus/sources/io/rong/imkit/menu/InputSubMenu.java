package io.rong.imkit.menu;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import io.rong.imkit.R;
import io.rong.imkit.utilities.RongUtils;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class InputSubMenu {
    private ViewGroup container;
    private LayoutInflater mInflater;
    private ISubMenuItemClickListener mOnClickListener;
    private PopupWindow mPopupWindow;

    public InputSubMenu(Context context, List<String> list) {
        this.mInflater = LayoutInflater.from(context);
        this.container = (ViewGroup) this.mInflater.inflate(R.layout.rc_ext_sub_menu_container, (ViewGroup) null);
        this.mPopupWindow = new PopupWindow(this.container, -2, -2);
        setupSubMenus(this.container, list);
    }

    private void setupSubMenus(ViewGroup viewGroup, List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            View viewInflate = this.mInflater.inflate(R.layout.rc_ext_sub_menu_item, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.rc_sub_menu_title);
            View viewFindViewById = viewInflate.findViewById(R.id.rc_sub_menu_divider_line);
            textView.setText(list.get(i));
            if (i < list.size() - 1) {
                viewFindViewById.setVisibility(0);
            }
            viewInflate.setTag(Integer.valueOf(i));
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.menu.InputSubMenu.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    InputSubMenu.this.mOnClickListener.onClick(((Integer) view.getTag()).intValue());
                    InputSubMenu.this.mPopupWindow.dismiss();
                }
            });
            viewGroup.addView(viewInflate);
        }
    }

    public void setOnItemClickListener(ISubMenuItemClickListener iSubMenuItemClickListener) {
        this.mOnClickListener = iSubMenuItemClickListener;
    }

    public void showAtLocation(View view) {
        this.mPopupWindow.setBackgroundDrawable(new ColorDrawable());
        this.container.measure(0, 0);
        int[] iArr = new int[2];
        int measuredWidth = this.container.getMeasuredWidth();
        int measuredHeight = this.container.getMeasuredHeight();
        view.getLocationOnScreen(iArr);
        int width = iArr[0] + ((view.getWidth() - measuredWidth) / 2);
        int screenWidth = RongUtils.getScreenWidth() - RongUtils.dip2px(10.0f);
        if (width + measuredWidth > screenWidth) {
            width = screenWidth - measuredWidth;
        }
        this.mPopupWindow.showAtLocation(view, 8388659, width, (iArr[1] - measuredHeight) - RongUtils.dip2px(3.0f));
        this.mPopupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setFocusable(true);
        this.mPopupWindow.update();
    }
}
