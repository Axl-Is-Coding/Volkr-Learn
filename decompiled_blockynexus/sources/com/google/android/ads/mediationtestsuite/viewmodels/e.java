package com.google.android.ads.mediationtestsuite.viewmodels;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.ads.mediationtestsuite.R;

/* JADX INFO: compiled from: HeaderViewHolder.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends RecyclerView.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f12702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f12703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f12704c;

    public e(View view) {
        super(view);
        this.f12704c = view;
        this.f12702a = (TextView) view.findViewById(R.id.gmts_header_title);
        this.f12703b = (ImageView) view.findViewById(R.id.gmts_header_image);
    }

    public ImageView a() {
        return this.f12703b;
    }

    public TextView b() {
        return this.f12702a;
    }
}
