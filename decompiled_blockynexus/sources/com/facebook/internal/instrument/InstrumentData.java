package com.facebook.internal.instrument;

import android.os.Build;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.Utility;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class InstrumentData {
    private static final String PARAM_APP_VERSION = "app_version";
    private static final String PARAM_CALLSTACK = "callstack";
    private static final String PARAM_DEVICE_MODEL = "device_model";
    private static final String PARAM_DEVICE_OS = "device_os_version";
    private static final String PARAM_REASON = "reason";
    private static final String PARAM_TIMESTAMP = "timestamp";
    private static final String PARAM_TYPE = "type";
    private String appVersion;
    private String cause;
    private String filename;
    private String stackTrace;
    private Long timestamp;
    private String type;

    /* JADX INFO: renamed from: com.facebook.internal.instrument.InstrumentData$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$internal$instrument$InstrumentData$Type = new int[Type.values().length];

        static {
            try {
                $SwitchMap$com$facebook$internal$instrument$InstrumentData$Type[Type.CrashReport.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$internal$instrument$InstrumentData$Type[Type.CrashShield.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$internal$instrument$InstrumentData$Type[Type.ThreadCheck.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum Type {
        CrashReport,
        CrashShield,
        ThreadCheck;

        @Override // java.lang.Enum
        public String toString() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$internal$instrument$InstrumentData$Type[ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : "ThreadCheck" : "CrashShield" : "CrashReport";
        }
    }

    public InstrumentData(Throwable th, Type type) {
        this.appVersion = Utility.getAppVersion();
        this.cause = InstrumentUtility.getCause(th);
        this.stackTrace = InstrumentUtility.getStackTrace(th);
        this.timestamp = Long.valueOf(System.currentTimeMillis() / 1000);
        this.type = type.toString();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(InstrumentUtility.CRASH_REPORT_PREFIX);
        stringBuffer.append(this.timestamp.toString());
        stringBuffer.append(".json");
        this.filename = stringBuffer.toString();
    }

    public void clear() {
        InstrumentUtility.deleteFile(this.filename);
    }

    public int compareTo(InstrumentData instrumentData) {
        Long l = this.timestamp;
        if (l == null) {
            return -1;
        }
        Long l2 = instrumentData.timestamp;
        if (l2 == null) {
            return 1;
        }
        return l2.compareTo(l);
    }

    public JSONObject getParameters() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PARAM_DEVICE_OS, Build.VERSION.RELEASE);
            jSONObject.put("device_model", Build.MODEL);
            if (this.appVersion != null) {
                jSONObject.put("app_version", this.appVersion);
            }
            if (this.timestamp != null) {
                jSONObject.put(PARAM_TIMESTAMP, this.timestamp);
            }
            if (this.cause != null) {
                jSONObject.put(PARAM_REASON, this.cause);
            }
            if (this.stackTrace != null) {
                jSONObject.put(PARAM_CALLSTACK, this.stackTrace);
            }
            if (this.type != null) {
                jSONObject.put("type", this.type);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean isValid() {
        return (this.stackTrace == null || this.timestamp == null) ? false : true;
    }

    public void save() {
        if (isValid()) {
            InstrumentUtility.writeFile(this.filename, toString());
        }
    }

    public String toString() {
        JSONObject parameters = getParameters();
        if (parameters == null) {
            return null;
        }
        return parameters.toString();
    }

    public InstrumentData(File file) {
        this.filename = file.getName();
        JSONObject file2 = InstrumentUtility.readFile(this.filename, true);
        if (file2 != null) {
            this.appVersion = file2.optString("app_version", null);
            this.cause = file2.optString(PARAM_REASON, null);
            this.stackTrace = file2.optString(PARAM_CALLSTACK, null);
            this.timestamp = Long.valueOf(file2.optLong(PARAM_TIMESTAMP, 0L));
            this.type = file2.optString("type", null);
        }
    }
}
