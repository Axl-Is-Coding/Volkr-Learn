package com.alibaba.sdk.android.feedback.xblink.f.a;

import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.alibaba.sdk.android.feedback.util.ErrorCode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends com.alibaba.sdk.android.feedback.xblink.f.a {
    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        int code;
        if (!"presentError".equals(str)) {
            return false;
        }
        com.alibaba.sdk.android.feedback.xblink.i.g.a("WXErrorPage", "FeedbackAPI presentError" + str2);
        String string = "";
        try {
            JSONObject jSONObject = new JSONObject(str2);
            string = jSONObject.getString("errorMsg");
            code = jSONObject.getInt("errorCode");
        } catch (Exception unused) {
            code = ErrorCode.UNKNOWN_ERROR.getCode();
        }
        FeedbackAPI.mErrorManager.a(this.f3803b.context, string, ErrorCode.getErrorCode(code));
        return true;
    }
}
