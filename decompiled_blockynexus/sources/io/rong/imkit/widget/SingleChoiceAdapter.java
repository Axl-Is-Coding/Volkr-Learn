package io.rong.imkit.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import io.rong.imkit.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SingleChoiceAdapter<T> extends BaseAdapter {
    private int mCheckBoxResourceID;
    private LayoutInflater mInflater;
    private List<T> mObjects;
    private int mSelectItem;

    public static class ViewHolder {
        public CheckBox mCheckBox;
        public TextView mTextView;
    }

    public SingleChoiceAdapter(Context context, int i) {
        this.mObjects = new ArrayList();
        this.mCheckBoxResourceID = 0;
        this.mSelectItem = -1;
        init(context, i);
    }

    private void init(Context context, int i) {
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mCheckBoxResourceID = i;
    }

    public void clear() {
        this.mObjects.clear();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mObjects.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        return this.mObjects.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public int getPosition(T t) {
        return this.mObjects.indexOf(t);
    }

    public int getSelectItem() {
        return this.mSelectItem;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.mInflater.inflate(R.layout.rc_cs_item_single_choice, (ViewGroup) null);
            viewHolder = new ViewHolder();
            viewHolder.mTextView = (TextView) view.findViewById(R.id.rc_cs_tv_group_name);
            viewHolder.mCheckBox = (CheckBox) view.findViewById(R.id.rc_cs_group_checkBox);
            view.setTag(viewHolder);
            int i2 = this.mCheckBoxResourceID;
            if (i2 != 0) {
                viewHolder.mCheckBox.setButtonDrawable(i2);
            }
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mCheckBox.setChecked(this.mSelectItem == i);
        T item = getItem(i);
        if (item instanceof CharSequence) {
            viewHolder.mTextView.setText((CharSequence) item);
        } else {
            viewHolder.mTextView.setText(item.toString());
        }
        return view;
    }

    public void refreshData(List<T> list) {
        if (list != null) {
            this.mObjects = list;
            setSelectItem(0);
        }
    }

    public void setSelectItem(int i) {
        if (i < 0 || i >= this.mObjects.size()) {
            return;
        }
        this.mSelectItem = i;
        notifyDataSetChanged();
    }

    public SingleChoiceAdapter(Context context, List<T> list, int i) {
        this.mObjects = new ArrayList();
        this.mCheckBoxResourceID = 0;
        this.mSelectItem = -1;
        init(context, i);
        if (list != null) {
            this.mObjects = list;
        }
    }
}
