package com.disabngo.blockynexus.e.b.G;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.GroupInfoParam;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.common.base.viewmodel.ViewModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GroupNoticeViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends ViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f9290b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f9289a = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<String> f9291c = new ObservableField<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<String> f9292d = new ObservableField<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<String> f9293e = new ObservableField<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<String> f9294f = new ObservableField<>();
    public ObservableField<Boolean> g = new ObservableField<>(false);

    public f(Context context, GroupInfoParam groupInfoParam, List<String> list) {
        if (list == null || groupInfoParam == null) {
            GroupOnError.showErrorTip(context, 1);
            return;
        }
        a(list);
        this.f9294f.set(groupInfoParam.getGroupNotice() != null ? groupInfoParam.getGroupNotice() : "");
        this.g.set(Boolean.valueOf(groupInfoParam.getNoticePic() != null && groupInfoParam.getNoticePic().size() > 0));
        this.f9290b = new e(context, R.string.no_data, (ArrayList) groupInfoParam.getNoticePic());
    }

    private void a(List<String> list) {
        int size = list.size();
        if (size == 0) {
            this.f9291c.set("");
            this.f9292d.set("");
            this.f9293e.set("");
            return;
        }
        if (size == 1) {
            this.f9291c.set(list.get(0));
            this.f9292d.set("");
            this.f9293e.set("");
        } else if (size == 2) {
            this.f9291c.set(list.get(0));
            this.f9292d.set(list.get(1));
            this.f9293e.set("");
        } else {
            if (size != 3) {
                return;
            }
            this.f9291c.set(list.get(0));
            this.f9292d.set(list.get(1));
            this.f9293e.set(list.get(2));
        }
    }
}
