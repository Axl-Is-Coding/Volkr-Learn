package com.alibaba.sdk.android.feedback.util.a;

import android.text.TextUtils;
import cn.qqtheme.framework.widget.WheelView;
import com.alibaba.sdk.android.feedback.util.IWxCallback;
import com.alibaba.sdk.android.feedback.xblink.f.a.e;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ByteArrayOutputStream f3706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f3707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3708e;

    public b(String str) {
        super(null, str);
        this.f3706c = new ByteArrayOutputStream();
        this.f3707d = WheelView.DividerConfig.FILL;
    }

    public b(Map map, IWxCallback iWxCallback, String str) {
        super(iWxCallback, a(str, map));
        this.f3706c = new ByteArrayOutputStream();
        this.f3707d = WheelView.DividerConfig.FILL;
    }

    private static String a(String str, Map map) {
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (map != null) {
            boolean z = true;
            for (Map.Entry entry : map.entrySet()) {
                String str3 = (String) entry.getValue();
                if (!TextUtils.isEmpty(str3)) {
                    if ("deviceId".equals(entry.getKey())) {
                        str2 = (String) entry.getValue();
                    } else {
                        if (!z) {
                            sb.append("&");
                        }
                        z = false;
                        sb.append((String) entry.getKey());
                        sb.append("=");
                        sb.append(str3);
                    }
                }
            }
        }
        StringBuilder sb2 = new StringBuilder(str);
        try {
            StringBuilder sb3 = new StringBuilder(sb);
            sb3.append("&");
            sb3.append("deviceId");
            sb3.append("=");
            sb3.append(URLEncoder.encode(str2, "UTF-8"));
            String strA = e.a(sb + "&deviceId=" + str2);
            if (!TextUtils.isEmpty(sb3.toString())) {
                sb2.append("?");
                sb2.append((CharSequence) sb3);
                if (!TextUtils.isEmpty(strA)) {
                    sb2.append("&");
                    sb2.append("sign");
                    sb2.append("=");
                    sb2.append(strA);
                }
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return sb2.toString();
    }

    @Override // com.alibaba.sdk.android.feedback.util.a.a
    public byte[] a() {
        return b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010b  */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] b() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.util.a.b.b():byte[]");
    }
}
