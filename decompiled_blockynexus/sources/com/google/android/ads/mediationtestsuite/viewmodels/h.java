package com.google.android.ads.mediationtestsuite.viewmodels;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.ads.mediationtestsuite.R;

/* JADX INFO: compiled from: InfoViewHolder.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends RecyclerView.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f12710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f12711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImageView f12712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final View f12713d;

    public h(View view) {
        super(view);
        this.f12713d = view;
        this.f12710a = (TextView) view.findViewById(R.id.gmts_title_text);
        this.f12711b = (TextView) view.findViewById(R.id.gmts_detail_text);
        this.f12712c = (ImageView) view.findViewById(R.id.gmts_check_image);
    }

    public TextView a() {
        return this.f12711b;
    }

    public ImageView b() {
        return this.f12712c;
    }

    public TextView c() {
        return this.f12710a;
    }

    public View d() {
        return this.f12713d;
    }
}
