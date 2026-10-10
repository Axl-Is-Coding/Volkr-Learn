package com.google.android.ads.mediationtestsuite.viewmodels;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.ads.mediationtestsuite.R;
import com.google.android.flexbox.FlexboxLayout;

/* JADX INFO: compiled from: ItemViewHolder.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends RecyclerView.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f12714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f12715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CheckBox f12716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FlexboxLayout f12717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final View f12718e;

    public i(View view) {
        super(view);
        this.f12718e = view;
        this.f12714a = (TextView) view.findViewById(R.id.gmts_title_text);
        this.f12715b = (TextView) view.findViewById(R.id.gmts_detail_text);
        this.f12716c = (CheckBox) view.findViewById(R.id.gmts_checkbox);
        this.f12717d = (FlexboxLayout) view.findViewById(R.id.gmts_captions_container);
    }

    public FlexboxLayout a() {
        return this.f12717d;
    }

    public CheckBox b() {
        return this.f12716c;
    }

    public TextView c() {
        return this.f12715b;
    }

    public TextView d() {
        return this.f12714a;
    }

    public View e() {
        return this.f12718e;
    }
}
