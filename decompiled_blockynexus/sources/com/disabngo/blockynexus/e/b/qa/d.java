package com.disabngo.blockynexus.e.b.qa;

import android.app.Activity;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.entity.TribeNoticePost;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.SharedUtils;
import rx.functions.Action1;

/* JADX INFO: compiled from: TribeNoticeViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f10097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<String> f10098b = new ObservableField<>("");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand<String> f10099c = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.qa.a
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f10094a.a((String) obj);
        }
    });

    public d(Activity activity) {
        this.f10097a = activity;
        String string = SharedUtils.getString(activity, "tribe.notice.content");
        if (string != null) {
            this.f10098b.set(string);
        }
    }

    public void f() {
        TribeApi.postTribeNotice(this.f10097a, new TribeNoticePost(this.f10098b.get()), new c(this));
    }

    public /* synthetic */ void a(String str) {
        this.f10098b.set(str);
    }
}
