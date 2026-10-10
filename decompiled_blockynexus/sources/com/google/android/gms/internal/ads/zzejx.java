package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejm;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzejx<T extends zzejm> {
    private static final Logger logger = Logger.getLogger(zzejj.class.getName());
    private static String zziiz = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    zzejx() {
    }

    static <T extends zzejm> T zzc(Class<T> cls) {
        String str;
        ClassLoader classLoader = zzejx.class.getClassLoader();
        if (cls.equals(zzejm.class)) {
            str = zziiz;
        } else {
            if (!cls.getPackage().equals(zzejx.class.getPackage())) {
                throw new IllegalArgumentException(cls.getName());
            }
            str = String.format("%s.BlazeGenerated%sLoader", cls.getPackage().getName(), cls.getSimpleName());
        }
        try {
            try {
                try {
                    try {
                        return cls.cast(((zzejx) Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).zzbge());
                    } catch (InstantiationException e2) {
                        throw new IllegalStateException(e2);
                    }
                } catch (InvocationTargetException e3) {
                    throw new IllegalStateException(e3);
                }
            } catch (IllegalAccessException e4) {
                throw new IllegalStateException(e4);
            } catch (NoSuchMethodException e5) {
                throw new IllegalStateException(e5);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(zzejx.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add(cls.cast(((zzejx) it.next()).zzbge()));
                } catch (ServiceConfigurationError e6) {
                    Logger logger2 = logger;
                    Level level = Level.SEVERE;
                    String strValueOf = String.valueOf(cls.getSimpleName());
                    logger2.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", strValueOf.length() != 0 ? "Unable to load ".concat(strValueOf) : new String("Unable to load "), (Throwable) e6);
                }
            }
            if (arrayList.size() == 1) {
                return (T) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (T) cls.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e7) {
                throw new IllegalStateException(e7);
            } catch (NoSuchMethodException e8) {
                throw new IllegalStateException(e8);
            } catch (InvocationTargetException e9) {
                throw new IllegalStateException(e9);
            }
        }
    }

    protected abstract T zzbge();
}
