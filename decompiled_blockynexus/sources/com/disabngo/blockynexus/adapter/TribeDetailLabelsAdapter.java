package com.disabngo.blockynexus.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.adapter.base.ListViewBaseAdapter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TribeDetailLabelsAdapter extends ListViewBaseAdapter<String> {

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f7155a;

        a(View view) {
            this.f7155a = (TextView) view.findViewById(R.id.tv_label);
        }
    }

    public TribeDetailLabelsAdapter(Context context, List<String> list) {
        super(context, list);
    }

    @Override // com.disabngo.blockynexus.adapter.base.ListViewBaseAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.layoutInflater.inflate(R.layout.item_tribe_detail_label, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.f7155a.setText((CharSequence) this.list.get(i));
        return view;
    }
}
