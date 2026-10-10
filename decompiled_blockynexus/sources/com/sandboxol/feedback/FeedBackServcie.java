package com.sandboxol.feedback;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sandboxol.center.router.moduleApi.IFeedbackService;
import com.sandboxol.center.router.path.RouterServicePath;

/* JADX INFO: loaded from: classes3.dex */
@Route(path = RouterServicePath.EventFeedBackPay.FEED_BACK_SERVICE)
public class FeedBackServcie implements IFeedbackService {
    @Override // com.sandboxol.center.router.moduleApi.IFeedbackService
    public void getUnReadCount() {
        FeedBackUtils.newInstant().getUnReadCount();
    }

    @Override // com.sandboxol.center.router.moduleApi.IFeedbackService
    public ObservableField<Integer> getUnReadCountFiled() {
        return FeedBackUtils.newInstant().unReadCount;
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.sandboxol.center.router.moduleApi.IFeedbackService
    public void openFeedbackActivity() {
        FeedBackUtils.newInstant().openFeedbackActivity();
    }

    @Override // com.sandboxol.center.router.moduleApi.IFeedbackService
    public void setUI(int i, String str, String str2) {
        FeedBackUtils.newInstant().setUI(i, str, str2);
    }
}
