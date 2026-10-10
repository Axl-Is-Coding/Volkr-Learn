package com.alibaba.sdk.android.utils;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class AMSDevReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f3938a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ExecutorService f78a = Executors.newSingleThreadExecutor(new a());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ConcurrentHashMap<AMSSdkTypeEnum, AMSReportStatusEnum> f77a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f79a = false;
    private static String TAG = "AMSDevReporter";

    public enum AMSReportStatusEnum {
        UNREPORTED,
        REPORTED
    }

    public enum AMSSdkExtInfoKeyEnum {
        AMS_EXTINFO_KEY_VERSION("SdkVersion"),
        AMS_EXTINFO_KEY_PACKAGE("PackageName");

        private String description;

        AMSSdkExtInfoKeyEnum(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    public enum AMSSdkTypeEnum {
        AMS_MAN("MAN"),
        AMS_HTTPDNS("HTTPDNS"),
        AMS_MPUSH("MPUSH"),
        AMS_MAC("MAC"),
        AMS_API("API"),
        AMS_HOTFIX("HOTFIX"),
        AMS_FEEDBACK("FEEDBACK"),
        AMS_IM("IM");

        private String description;

        AMSSdkTypeEnum(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    static {
        for (AMSSdkTypeEnum aMSSdkTypeEnum : AMSSdkTypeEnum.values()) {
            f77a.put(aMSSdkTypeEnum, AMSReportStatusEnum.UNREPORTED);
        }
    }

    public static void asyncReport(Context context, AMSSdkTypeEnum aMSSdkTypeEnum) {
        asyncReport(context, aMSSdkTypeEnum, null);
    }

    public static AMSReportStatusEnum getReportStatus(AMSSdkTypeEnum aMSSdkTypeEnum) {
        return f77a.get(aMSSdkTypeEnum);
    }

    public static void setLogEnabled(boolean z) {
        d.setLogEnabled(z);
    }

    public static void asyncReport(Context context, final AMSSdkTypeEnum aMSSdkTypeEnum, final Map<String, Object> map) {
        if (context == null) {
            d.c(TAG, "Context is null, return.");
            return;
        }
        f3938a = context;
        d.b(TAG, "Add [" + aMSSdkTypeEnum.toString() + "] to report queue.");
        f79a = false;
        f78a.execute(new Runnable() { // from class: com.alibaba.sdk.android.utils.AMSDevReporter.1
            @Override // java.lang.Runnable
            public void run() {
                if (AMSDevReporter.f79a) {
                    d.c(AMSDevReporter.TAG, "Unable to execute remain task in queue, return.");
                    return;
                }
                d.b(AMSDevReporter.TAG, "Get [" + aMSSdkTypeEnum.toString() + "] from report queue.");
                AMSDevReporter.a(aMSSdkTypeEnum, (Map<String, Object>) map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AMSSdkTypeEnum aMSSdkTypeEnum, Map<String, Object> map) {
        String string = aMSSdkTypeEnum.toString();
        if (f77a.get(aMSSdkTypeEnum) != AMSReportStatusEnum.UNREPORTED) {
            d.b(TAG, "[" + string + "] already reported, return.");
            return;
        }
        int i = 0;
        int i2 = 5;
        while (true) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Report [");
            sb.append(string);
            sb.append("], times: [");
            i++;
            sb.append(i);
            sb.append("].");
            d.b(str, sb.toString());
            if (!m31a(aMSSdkTypeEnum, map)) {
                if (i <= 10) {
                    d.b(TAG, "Report [" + string + "] failed, wait for [" + i2 + "] seconds.");
                    e.a((double) i2);
                    i2 *= 2;
                    if (i2 >= 60) {
                        i2 = 60;
                    }
                } else {
                    d.c(TAG, "Report [" + string + "] stat failed, exceed max retry times, return.");
                    f77a.put(aMSSdkTypeEnum, AMSReportStatusEnum.UNREPORTED);
                    f79a = true;
                    break;
                }
            } else {
                d.b(TAG, "Report [" + string + "] stat success.");
                f77a.put(aMSSdkTypeEnum, AMSReportStatusEnum.REPORTED);
                break;
            }
        }
        if (f79a) {
            d.c(TAG, "Report [" + string + "] failed, clear remain report in queue.");
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:11|(2:94|12)|(3:13|(1:15)(1:100)|68)|16|85|17|(4:(1:20)|(2:87|22)|25|28)) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0162, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0163, code lost:
    
        com.alibaba.sdk.android.utils.d.a(com.alibaba.sdk.android.utils.AMSDevReporter.TAG, r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01e4 A[Catch: IOException -> 0x01e0, TRY_LEAVE, TryCatch #11 {IOException -> 0x01e0, blocks: (B:75:0x01dc, B:79:0x01e4), top: B:92:0x01dc }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m31a(com.alibaba.sdk.android.utils.AMSDevReporter.AMSSdkTypeEnum r10, java.util.Map<java.lang.String, java.lang.Object> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.utils.AMSDevReporter.m31a(com.alibaba.sdk.android.utils.AMSDevReporter$AMSSdkTypeEnum, java.util.Map):boolean");
    }

    private static String a(AMSSdkTypeEnum aMSSdkTypeEnum, String str, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(aMSSdkTypeEnum);
        sb.append("-");
        sb.append(str);
        if (map != null) {
            String str2 = (String) map.get(AMSSdkExtInfoKeyEnum.AMS_EXTINFO_KEY_VERSION.toString());
            if (!e.m38a(str2)) {
                sb.append("-");
                sb.append(str2);
            }
            String str3 = (String) map.get(AMSSdkExtInfoKeyEnum.AMS_EXTINFO_KEY_PACKAGE.toString());
            if (!e.m38a(str3)) {
                sb.append("-");
                sb.append(str3);
            }
        }
        return sb.toString();
    }
}
