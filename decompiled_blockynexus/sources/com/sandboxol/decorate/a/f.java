package com.sandboxol.decorate.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.decorate.R;
import java.util.List;

/* JADX INFO: compiled from: DressPopupWindowAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends RecyclerView.a<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f16963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f16964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f16966d;

    /* JADX INFO: compiled from: DressPopupWindowAdapter.java */
    public interface a {
        void a(String str);
    }

    /* JADX INFO: compiled from: DressPopupWindowAdapter.java */
    public static class b extends RecyclerView.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f16967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ImageView f16968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        View f16969c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ConstraintLayout f16970d;

        public b(View view) {
            super(view);
            this.f16967a = (TextView) view.findViewById(R.id.tvItem);
            this.f16968b = (ImageView) view.findViewById(R.id.ivCheck);
            this.f16969c = view.findViewById(R.id.vBottomLine);
            this.f16970d = (ConstraintLayout) view.findViewById(R.id.viewGroup);
        }
    }

    public f(Context context, List<String> list) {
        this.f16963a = context;
        this.f16964b = list;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f16965c = list.get(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, final int i) {
        Context context;
        int i2;
        List<String> list = this.f16964b;
        if (list == null || list.size() <= 0) {
            return;
        }
        bVar.f16967a.setText(this.f16964b.get(i));
        TextView textView = bVar.f16967a;
        if (textView.getText().toString().equals(this.f16965c)) {
            context = this.f16963a;
            i2 = R.color.NewDressPopupTextChooseTextColor;
        } else {
            context = this.f16963a;
            i2 = R.color.NewDressDialogItemBottomBgColor;
        }
        textView.setTextColor(androidx.core.content.b.a(context, i2));
        bVar.f16968b.setVisibility(bVar.f16967a.getText().toString().equals(this.f16965c) ? 0 : 4);
        bVar.f16969c.setVisibility(i == this.f16964b.size() + (-1) ? 8 : 0);
        bVar.f16970d.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.decorate.a.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f16958a.a(i, view);
            }
        });
    }

    public void b() {
        List<String> list = this.f16964b;
        if (list != null && list.size() > 0) {
            this.f16965c = this.f16964b.get(0);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        return this.f16964b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(this.f16963a).inflate(R.layout.item_dress_window, (ViewGroup) null));
    }

    public /* synthetic */ void a(int i, View view) {
        this.f16965c = this.f16964b.get(i);
        notifyDataSetChanged();
        this.f16966d.a(this.f16964b.get(i));
    }

    public void a(List<String> list) {
        this.f16964b.addAll(list);
        this.f16965c = list.get(0);
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.f16966d = aVar;
    }
}
