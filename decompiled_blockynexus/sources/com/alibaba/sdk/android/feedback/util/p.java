package com.alibaba.sdk.android.feedback.util;

import android.text.TextUtils;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f3730a = "^https?:\\/\\/(([^/\\?#]+\\.)*((taobao|tmall|juhuasuan|xiami|amap|taobaocdn|alipay|etao|alibaba|aliyun|alimama|weibo|tanx|laiwang|alicdn|mmstat|yunos|alibaba-inc|alitrip|aliloan|kanbox|wirlesshare|dingtalk|alimei|cnzz|kuaidadi|autonavi|m\\.yintai|polyinno|spdyidea|h5util|h5tool|5945i|miaostreet|1688)\\.com|(tb|tbcdn|weibo|mashort|mybank|ba\\.ugame\\.uc|game\\.uc)\\.cn|(fastidea|juzone)\\.(me|cc)|lwurl\\.to|taobao\\.net|tdd\\.la|yao\\.95095\\.com|tmall\\.hk|ahd\\.so|atb\\.so|mshare\\.cc|juhs\\.me|xianyu\\.mobi)([\\?|#|/].*)?|go(/.*)?)$";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Pattern f3731b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f3732c = "p";

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (f3731b == null) {
            try {
                f3731b = Pattern.compile(f3730a, 2);
                com.alibaba.sdk.android.feedback.xblink.i.g.a(f3732c, "WVServerConfig compile pattern domainPat rule, " + f3730a);
            } catch (PatternSyntaxException e2) {
                com.alibaba.sdk.android.feedback.xblink.i.g.b(f3732c, "WVServerConfig PatternSyntaxException pattern:" + e2.getMessage());
            }
        }
        try {
            if (f3731b != null) {
                return f3731b.matcher(str).matches();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
