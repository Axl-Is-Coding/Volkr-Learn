package com.ironsource.mediationsdk.b;

import com.ironsource.mediationsdk.logger.IronSourceLogger;

/* JADX INFO: compiled from: EventsFormatterFactory.java */
/* JADX INFO: loaded from: classes2.dex */
class g {
    static a a(String str, int i) {
        if ("ironbeast".equals(str)) {
            return new i(i);
        }
        if ("outcome".equals(str)) {
            return new j(i);
        }
        if (i == 2) {
            return new i(i);
        }
        if (i == 3) {
            return new j(i);
        }
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.NATIVE, "EventsFormatterFactory failed to instantiate a formatter (type: " + str + ", adUnit: " + i + ")", 2);
        return null;
    }
}
