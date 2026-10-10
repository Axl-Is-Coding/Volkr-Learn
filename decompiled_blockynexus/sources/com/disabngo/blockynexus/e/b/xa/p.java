package com.disabngo.blockynexus.e.b.xa;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import java.util.List;

/* JADX INFO: compiled from: VideoRecommendPageViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public class p extends ListItemViewModel<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f10343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f10344b;

    public p(Context context, String str, List<String> list) {
        super(context, str);
        this.f10344b = new h();
        this.f10343a = new n(context, R.string.no_data, str, list);
    }

    public void a(ObservableField<Boolean> observableField) {
        this.f10343a.a(observableField);
    }
}
