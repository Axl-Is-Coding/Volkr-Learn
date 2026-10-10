package me.iwf.photopicker;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: PhotoAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
public class b extends RecyclerView.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<String> f22915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LayoutInflater f22916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f22917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f22918d;

    /* JADX INFO: compiled from: PhotoAdapter.java */
    public static class a extends RecyclerView.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ImageView f22919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ImageView f22920b;

        public a(View view) {
            super(view);
            this.f22919a = (ImageView) view.findViewById(R.id.iv_photo);
            this.f22920b = (ImageView) view.findViewById(R.id.iv_cancel);
        }
    }

    public b(Context context, ArrayList<String> arrayList, int i) {
        this.f22915a = arrayList;
        this.f22917c = context;
        this.f22918d = i;
        this.f22916b = LayoutInflater.from(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        if (getItemViewType(i) == 2) {
            if (this.f22915a.get(i).contains("http")) {
                if (me.iwf.photopicker.utils.a.a(aVar.f22919a.getContext())) {
                    com.bumptech.glide.request.f fVar = new com.bumptech.glide.request.f();
                    fVar.centerCrop();
                    try {
                        com.bumptech.glide.c.c(this.f22917c).mo55load(this.f22915a.get(i)).apply((com.bumptech.glide.request.a<?>) fVar).thumbnail(0.1f).into(aVar.f22919a);
                        return;
                    } catch (IllegalArgumentException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                return;
            }
            Uri uriFromFile = Uri.fromFile(new File(this.f22915a.get(i)));
            if (me.iwf.photopicker.utils.a.a(aVar.f22919a.getContext())) {
                com.bumptech.glide.request.f fVar2 = new com.bumptech.glide.request.f();
                fVar2.centerCrop();
                try {
                    com.bumptech.glide.c.c(this.f22917c).mo51load(uriFromFile).apply((com.bumptech.glide.request.a<?>) fVar2).thumbnail(0.1f).into(aVar.f22919a);
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        int size = this.f22915a.size() + 1;
        int i = this.f22918d;
        return size > i ? i : size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemViewType(int i) {
        return (i != this.f22915a.size() || i == this.f22918d) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(i != 1 ? i != 2 ? null : this.f22916b.inflate(R.layout.item_choose_photo, viewGroup, false) : this.f22916b.inflate(R.layout.item_add, viewGroup, false));
    }
}
