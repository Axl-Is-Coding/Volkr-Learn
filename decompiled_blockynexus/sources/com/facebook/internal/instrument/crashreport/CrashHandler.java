package com.facebook.internal.instrument.crashreport;

import android.os.Process;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final int MAX_CRASH_REPORT_NUM = 5;
    private static final String TAG = "com.facebook.internal.instrument.crashreport.CrashHandler";
    private static CrashHandler instance;
    private boolean mEndApplication = false;
    private final Thread.UncaughtExceptionHandler mPreviousHandler;

    private CrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.mPreviousHandler = uncaughtExceptionHandler;
    }

    public static synchronized void enable() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            sendCrashReports();
        }
        if (instance != null) {
            Log.w(TAG, "Already enabled!");
        } else {
            instance = new CrashHandler(Thread.getDefaultUncaughtExceptionHandler());
            Thread.setDefaultUncaughtExceptionHandler(instance);
        }
    }

    private static void killProcess() {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        try {
            Process.killProcess(Process.myPid());
            System.exit(10);
        } catch (Throwable unused) {
        }
    }

    private static void sendCrashReports() {
        File[] fileArrListCrashReportFiles = InstrumentUtility.listCrashReportFiles();
        final ArrayList arrayList = new ArrayList();
        for (File file : fileArrListCrashReportFiles) {
            InstrumentData instrumentData = new InstrumentData(file);
            if (instrumentData.isValid()) {
                arrayList.add(instrumentData);
            }
        }
        Collections.sort(arrayList, new Comparator<InstrumentData>() { // from class: com.facebook.internal.instrument.crashreport.CrashHandler.1
            @Override // java.util.Comparator
            public int compare(InstrumentData instrumentData2, InstrumentData instrumentData3) {
                return instrumentData2.compareTo(instrumentData3);
            }
        });
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size() && i < 5; i++) {
            jSONArray.put(arrayList.get(i));
        }
        InstrumentUtility.sendReports("crash_reports", jSONArray, new GraphRequest.Callback() { // from class: com.facebook.internal.instrument.crashreport.CrashHandler.2
            @Override // com.facebook.GraphRequest.Callback
            public void onCompleted(GraphResponse graphResponse) {
                try {
                    if (graphResponse.getError() == null && graphResponse.getJSONObject().getBoolean("success")) {
                        for (int i2 = 0; arrayList.size() > i2; i2++) {
                            ((InstrumentData) arrayList.get(i2)).clear();
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        });
    }

    public void endApplication() {
        this.mEndApplication = true;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (InstrumentUtility.isSDKRelatedException(th)) {
            new InstrumentData(th, InstrumentData.Type.CrashReport).save();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mPreviousHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
        if (this.mEndApplication) {
            killProcess();
        }
    }
}
