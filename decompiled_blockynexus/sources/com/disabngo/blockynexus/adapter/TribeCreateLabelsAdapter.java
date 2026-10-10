package com.disabngo.blockynexus.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.adapter.base.ListViewBaseAdapter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TribeCreateLabelsAdapter extends ListViewBaseAdapter<String> {

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f7152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ImageView f7153b;

        a(View view) {
            this.f7152a = (TextView) view.findViewById(R.id.tv_label);
            this.f7153b = (ImageView) view.findViewById(R.id.iv_cancel);
        }
    }

    public TribeCreateLabelsAdapter(Context context, List<String> list) {
        super(context, list);
    }

    public /* synthetic */ void a(int i, View view) {
        this.list.remove(i);
        notifyDataSetChanged();
    }

    @Override // com.disabngo.blockynexus.adapter.base.ListViewBaseAdapter, android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.layoutInflater.inflate(R.layout.item_tribe_create_label, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.f7152a.setText((CharSequence) this.list.get(i));
        aVar.f7153b.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f7158a.a(i, view2);
            }
        });
        return view;
    }
}
