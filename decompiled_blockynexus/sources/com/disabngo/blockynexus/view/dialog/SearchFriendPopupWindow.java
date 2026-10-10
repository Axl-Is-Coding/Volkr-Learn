package com.disabngo.blockynexus.view.dialog;

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
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SearchFriendPopupWindow extends PopupWindow implements AdapterView.OnItemClickListener {
    public static final int TYPE_SEARCH_FRIEND_WINDOW_GAME = 2;
    public static final int TYPE_SEARCH_FRIEND_WINDOW_LANGUAGE = 1;
    private Context context;
    private List<String> listItemText;
    private OnMoreItemClickListener onMoreItemClickListener;

    public interface OnMoreItemClickListener {
        void a();

        void onClick(int i, long j);
    }

    public SearchFriendPopupWindow(Context context, List<String> list, int i) {
        super(context);
        this.context = context;
        if (i == 1) {
            Collections.reverse(list);
        }
        this.listItemText = list;
        initView();
    }

    private void initView() {
        View viewInflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.view_search_friend_language_window, (ViewGroup) null);
        setContentView(viewInflate);
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        ListView listView = (ListView) viewInflate.findViewById(R.id.lvCategory);
        listView.setAdapter((ListAdapter) new ArrayAdapter(this.context, R.layout.list_category_item, this.listItemText));
        listView.setOnItemClickListener(this);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.disabngo.blockynexus.view.dialog.Y
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                this.f11441a.a();
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

    public void showLocation(View view, int i) {
        setWidth(i);
        setHeight((int) this.context.getResources().getDimension(R.dimen.dp_144));
        showAsDropDown(view);
    }
}
