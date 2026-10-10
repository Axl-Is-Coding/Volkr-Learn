package com.google.android.datatransport.runtime.backends;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: MetadataBackendRegistry.java */
/* JADX INFO: loaded from: classes.dex */
class k implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f12830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f12831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, m> f12832c;

    k(Context context, i iVar) {
        this(new a(context), iVar);
    }

    @Override // com.google.android.datatransport.runtime.backends.f
    public synchronized m get(String str) {
        if (this.f12832c.containsKey(str)) {
            return this.f12832c.get(str);
        }
        e eVarA = this.f12830a.a(str);
        if (eVarA == null) {
            return null;
        }
        m mVarCreate = eVarA.create(this.f12831b.a(str));
        this.f12832c.put(str, mVarCreate);
        return mVarCreate;
    }

    k(a aVar, i iVar) {
        this.f12832c = new HashMap();
        this.f12830a = aVar;
        this.f12831b = iVar;
    }

    /* JADX INFO: compiled from: MetadataBackendRegistry.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f12833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<String, String> f12834b = null;

        a(Context context) {
            this.f12833a = context;
        }

        private static Bundle b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        e a(String str) {
            String str2 = a().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (e) Class.forName(str2).asSubclass(e.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e2) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", str2), e2);
                return null;
            } catch (IllegalAccessException e3) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e3);
                return null;
            } catch (InstantiationException e4) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e4);
                return null;
            } catch (NoSuchMethodException e5) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e5);
                return null;
            } catch (InvocationTargetException e6) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e6);
                return null;
            }
        }

        private Map<String, String> a() {
            if (this.f12834b == null) {
                this.f12834b = a(this.f12833a);
            }
            return this.f12834b;
        }

        private Map<String, String> a(Context context) {
            Bundle bundleB = b(context);
            if (bundleB == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap map = new HashMap();
            for (String str : bundleB.keySet()) {
                Object obj = bundleB.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String str2 : ((String) obj).split(",", -1)) {
                        String strTrim = str2.trim();
                        if (!strTrim.isEmpty()) {
                            map.put(strTrim, str.substring(8));
                        }
                    }
                }
            }
            return map;
        }
    }
}
