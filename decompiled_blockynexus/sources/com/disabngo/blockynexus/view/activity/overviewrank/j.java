package com.disabngo.blockynexus.view.activity.overviewrank;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;

/* JADX INFO: compiled from: OverViewRankPageViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11051b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f11053d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<String> f11052c = new ObservableField<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f11054e = new g();

    public j(Context context, String str) {
        this.f11050a = context;
        this.f11051b = str;
        this.f11053d = new i(context, R.string.no_data, str, this.f11052c);
    }
}
