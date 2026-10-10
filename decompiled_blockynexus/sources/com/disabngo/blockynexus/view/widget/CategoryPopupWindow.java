package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.disabngo.blockynexus.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CategoryPopupWindow extends PopupWindow implements AdapterView.OnItemClickListener {
    private Context context;
    private List<String> listItemText;
    private OnMoreItemClickListener onMoreItemClickListener;

    public interface OnMoreItemClickListener {
        void a();

        void onClick(int i, long j);
    }

    public CategoryPopupWindow(Context context, List<String> list) {
        super(context);
        this.context = context;
        this.listItemText = list;
        initView();
    }

    private void initView() {
        View viewInflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.view_category_window, (ViewGroup) null);
        setContentView(viewInflate);
        setWidth(-1);
        setHeight(-2);
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(1711276032));
        ListView listView = (ListView) viewInflate.findViewById(R.id.lvCategory);
        listView.setAdapter((ListAdapter) new ArrayAdapter(this.context, R.layout.list_category_item, this.listItemText));
        listView.setOnItemClickListener(this);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.disabngo.blockynexus.view.widget.c
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                this.f12077a.a();
            }
        });
    }

    public /* synthetic */ void a() {
        this.onMoreItemClickListener.a();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        dismiss();
        OnMoreItemClickListener onMoreItemClickListener = this.onMoreItemClickListener;
        if (onMoreItemClickListener != null) {
            onMoreItemClickListener.onClick(i, j);
        }
    }

    public void setOnMoreItemClickListener(OnMoreItemClickListener onMoreItemClickListener) {
        this.onMoreItemClickListener = onMoreItemClickListener;
    }

    public void showLocation(View view) {
        showAsDropDown(view);
    }
}
