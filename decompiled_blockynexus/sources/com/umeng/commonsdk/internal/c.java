package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.ax;
import com.umeng.analytics.pro.ay;
import com.umeng.analytics.pro.m;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.debug.SelfChecker;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.vchannel.Sender;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: compiled from: UMInternalDataProtocol.java */
/* JADX INFO: loaded from: classes5.dex */
public class c implements UMLogDataProtocol {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f21095a = "umeng_sp_zdata";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f21096b = "umeng_zdata";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f21097c = "umeng_zdata_req_ts";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f21098f = "info";
    private static final String g = "stat";
    private static Class<?> h = null;
    private static Method i = null;
    private static Method j = null;
    private static final String k = "com.umeng.umzid.Spy";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f21099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f21100e = 1;

    static {
        b();
    }

    public c(Context context) {
        if (context != null) {
            this.f21099d = context.getApplicationContext();
        }
    }

    public static String a() {
        Method method;
        Class<?> cls = h;
        if (cls != null && (method = j) != null) {
            try {
                return (String) method.invoke(cls, new Object[0]);
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    private static void b() {
        try {
            Class<?> cls = Class.forName(k);
            if (cls != null) {
                h = cls;
                Method declaredMethod = h.getDeclaredMethod("getID", new Class[0]);
                if (declaredMethod != null) {
                    i = declaredMethod;
                }
                Method declaredMethod2 = h.getDeclaredMethod("getVersion", new Class[0]);
                if (declaredMethod2 != null) {
                    j = declaredMethod2;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static String c() {
        Method method;
        Class<?> cls = h;
        if (cls != null && (method = i) != null) {
            try {
                return (String) method.invoke(cls, new Object[0]);
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    private void d() throws Throwable {
        aw awVarA = aw.a(this.f21099d);
        ax axVarA = awVarA.a(ay.f20687c);
        if (axVarA != null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建成真正信封。");
            try {
                String str = axVarA.f20682a;
                JSONObject jSONObjectA = new com.umeng.commonsdk.statistics.b().a(this.f21099d.getApplicationContext(), new JSONObject(axVarA.f20683b), new JSONObject(axVarA.f20684c));
                if (jSONObjectA == null || !jSONObjectA.has("exception")) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 成功! 删除二级缓存记录。");
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 失败。删除二级缓存记录");
                }
                awVarA.a(ay.f20687c, str);
                awVarA.b();
            } catch (Throwable unused) {
            }
        }
    }

    private void e() {
        if (this.f21100e <= 0) {
            f();
        }
    }

    private void f() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 真实构建条件满足，开始构建业务信封。");
        b(this.f21099d);
        com.umeng.commonsdk.a.a(this.f21099d);
        Context context = this.f21099d;
        UMWorkDispatch.sendEvent(context, m.a.w, CoreProtocol.getInstance(context), null);
        Context context2 = this.f21099d;
        UMWorkDispatch.sendEvent(context2, a.t, b.a(context2).a(), null);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j2) {
        return null;
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i2) throws Throwable {
        ULog.i("walle", "[internal] workEvent");
        try {
            if (i2 == 32801) {
                SelfChecker.doCheck(this.f21099d);
                return;
            }
            switch (i2) {
                case a.f21090e /* 32769 */:
                    ULog.i("walle", "[internal] workEvent send envelope");
                    Class<?> cls = Class.forName("com.umeng.commonsdk.internal.UMInternalManagerAgent");
                    if (cls != null) {
                        cls.getMethod("sendInternalEnvelopeByStateful2", Context.class).invoke(cls, this.f21099d);
                    }
                    break;
                case a.f21091f /* 32770 */:
                    break;
                case a.g /* 32771 */:
                    ULog.i("walle", "[internal] workEvent cache battery, event is " + obj.toString());
                    Class<?> cls2 = Class.forName("com.umeng.commonsdk.internal.utils.UMInternalUtilsAgent");
                    if (cls2 != null) {
                        cls2.getMethod("saveBattery", Context.class, String.class).invoke(cls2, this.f21099d, (String) obj);
                    }
                    break;
                case a.h /* 32772 */:
                    ULog.i("walle", "[internal] workEvent cache station, event is " + obj.toString());
                    Class<?> cls3 = Class.forName("com.umeng.commonsdk.internal.utils.UMInternalUtilsAgent");
                    if (cls3 != null) {
                        cls3.getMethod("saveBaseStationStrength", Context.class, String.class).invoke(cls3, this.f21099d, (String) obj);
                    }
                    break;
                default:
                    switch (i2) {
                        case a.j /* 32774 */:
                            Class<?> cls4 = Class.forName("com.umeng.commonsdk.internal.utils.ApplicationLayerUtilAgent");
                            if (cls4 != null) {
                                cls4.getMethod("wifiChange", Context.class).invoke(cls4, this.f21099d);
                            }
                            break;
                        case a.k /* 32775 */:
                            Class<?> cls5 = Class.forName("com.umeng.commonsdk.internal.utils.InfoPreferenceAgent");
                            if (cls5 != null) {
                                cls5.getMethod("saveUA", Context.class, String.class).invoke(cls5, this.f21099d, (String) obj);
                            }
                            break;
                        case a.l /* 32776 */:
                            SharedPreferences sharedPreferences = this.f21099d.getApplicationContext().getSharedPreferences(f21098f, 0);
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().putString(g, (String) obj).commit();
                            }
                            break;
                        case a.m /* 32777 */:
                            ULog.i("walle", "[internal] workEvent send envelope");
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(au.aE, a.f21089d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(au.as, new JSONObject());
                            JSONObject jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(this.f21099d, jSONObject, jSONObject2);
                            if (jSONObjectBuildEnvelopeWithExtHeader != null && !jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                                ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
                                break;
                            }
                            break;
                        case a.n /* 32778 */:
                            Context context = this.f21099d;
                            if (context != null) {
                                SharedPreferences sharedPreferences2 = context.getSharedPreferences(f21095a, 0);
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                String strC = c();
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                if (!TextUtils.isEmpty(strC) && sharedPreferences2 != null) {
                                    SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
                                    editorEdit.putString(f21096b, strC);
                                    editorEdit.putLong(f21097c, jCurrentTimeMillis2 - jCurrentTimeMillis);
                                    editorEdit.commit();
                                }
                                if (UMConfigure.sShouldCollectZData) {
                                    UMConfigureImpl.removeInterruptFlag();
                                }
                                break;
                            }
                            break;
                        case a.o /* 32779 */:
                            Sender.handleEvent(this.f21099d, (com.umeng.commonsdk.vchannel.b) obj);
                            break;
                        default:
                            switch (i2) {
                                case a.p /* 32781 */:
                                    if (!UMFrUtils.hasEnvelopeFile(this.f21099d, UMLogDataProtocol.UMBusinessType.U_ZeroEnv)) {
                                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文");
                                        a(this.f21099d);
                                    } else {
                                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文信封文件已存在，尝试发送之!");
                                    }
                                    break;
                                case a.q /* 32782 */:
                                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 成功接收到ID(oaid/zid)读取结束通知。");
                                    this.f21100e--;
                                    e();
                                    break;
                                case a.r /* 32783 */:
                                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 需要额外等待ID(oaid/zid)读取任务结束通知。");
                                    this.f21100e = 2;
                                    break;
                                case a.s /* 32784 */:
                                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 成功接收到零号报文应答数据.");
                                    this.f21100e--;
                                    e();
                                    break;
                                case a.t /* 32785 */:
                                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]接收到消费二级缓存数据通知.");
                                    if (!aw.a(this.f21099d).c()) {
                                        d();
                                        if (!UMWorkDispatch.eventHasExist(a.t)) {
                                            Context context2 = this.f21099d;
                                            UMWorkDispatch.sendEvent(context2, a.t, b.a(context2).a(), null);
                                        }
                                    } else {
                                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]已消费完毕,二级缓存数据库为空.");
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } catch (Throwable unused) {
        }
    }

    private void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put("app_version", UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put(au.w, "Android");
            JSONObject jSONObjectBuildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null);
            if (jSONObjectBuildZeroEnvelopeWithExtHeader != null && jSONObjectBuildZeroEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文失败.");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文 成功!!!");
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + ay.l);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }
}
