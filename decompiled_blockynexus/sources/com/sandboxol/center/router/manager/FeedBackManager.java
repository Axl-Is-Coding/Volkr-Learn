package com.sandboxol.center.router.manager;

import androidx.databinding.ObservableField;
import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.IFeedbackService;
import com.sandboxol.center.router.path.RouterServicePath;

/* JADX INFO: loaded from: classes3.dex */
public class FeedBackManager {
    private static IFeedbackService feedbackService = (IFeedbackService) RouteServiceManager.provide(RouterServicePath.EventFeedBackPay.FEED_BACK_SERVICE);

    public static void getUnReadCount() {
        IFeedbackService iFeedbackService = feedbackService;
        if (iFeedbackService != null) {
            iFeedbackService.getUnReadCount();
        }
    }

    public static ObservableField<Integer> getUnReadCountFiled() {
        IFeedbackService iFeedbackService = feedbackService;
        return iFeedbackService != null ? iFeedbackService.getUnReadCountFiled() : new ObservableField<>();
    }

    public static void openFeedbackActivity() {
        IFeedbackService iFeedbackService = feedbackService;
        if (iFeedbackService != null) {
            iFeedbackService.openFeedbackActivity();
        }
    }

    public static void setUI(int i, String str, String str2) {
        IFeedbackService iFeedbackService = feedbackService;
        if (iFeedbackService != null) {
            iFeedbackService.setUI(i, str, str2);
        }
    }
}
