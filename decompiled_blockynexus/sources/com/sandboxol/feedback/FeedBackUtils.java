package com.sandboxol.feedback;

import android.app.Application;
import androidx.databinding.ObservableField;
import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.alibaba.sdk.android.feedback.util.IUnreadCountCallback;

/* JADX INFO: loaded from: classes3.dex */
public class FeedBackUtils {
    private static FeedBackUtils feedBackUtils;
    public ObservableField<Integer> unReadCount = new ObservableField<>(0);

    public static FeedBackUtils newInstant() {
        if (feedBackUtils == null) {
            feedBackUtils = new FeedBackUtils();
        }
        return feedBackUtils;
    }

    public void getUnReadCount() {
        FeedbackAPI.getFeedbackUnreadCount(new IUnreadCountCallback() { // from class: com.sandboxol.feedback.FeedBackUtils.1
            @Override // com.alibaba.sdk.android.feedback.util.IUnreadCountCallback
            public void onError(int i, String str) {
                FeedBackUtils.this.unReadCount.set(0);
            }

            @Override // com.alibaba.sdk.android.feedback.util.IUnreadCountCallback
            public void onSuccess(int i) {
                FeedBackUtils.this.unReadCount.set(Integer.valueOf(i));
            }
        });
    }

    public void init(Application application) {
        FeedbackAPI.init(application, application.getBaseContext().getString(R.string.feedback_key), application.getBaseContext().getString(R.string.feedback_password));
    }

    public void openFeedbackActivity() {
        FeedbackAPI.openFeedbackActivity();
    }

    public void setUI(int i, String str, String str2) {
        FeedbackAPI.setBackIcon(i);
        FeedbackAPI.setDefaultUserContactInfo(str);
        FeedbackAPI.setUserNick(str2);
    }
}
