package io.grpc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ManagedChannelProvider {
    private static final ManagedChannelProvider provider = load(getCorrectClassLoader());

    public static final class ProviderNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public ProviderNotFoundException(String str) {
            super(str);
        }
    }

    static ManagedChannelProvider create(Class<?> cls) {
        try {
            return (ManagedChannelProvider) cls.asSubclass(ManagedChannelProvider.class).newInstance();
        } catch (Throwable th) {
            throw new ServiceConfigurationError("Provider " + cls.getName() + " could not be instantiated: " + th, th);
        }
    }

    public static Iterable<ManagedChannelProvider> getCandidatesViaHardCoded(ClassLoader classLoader) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(create(Class.forName("io.grpc.okhttp.OkHttpChannelProvider", true, classLoader)));
        } catch (ClassNotFoundException unused) {
        }
        try {
            arrayList.add(create(Class.forName("io.grpc.netty.NettyChannelProvider", true, classLoader)));
        } catch (ClassNotFoundException unused2) {
        }
        return arrayList;
    }

    public static Iterable<ManagedChannelProvider> getCandidatesViaServiceLoader(ClassLoader classLoader) {
        return ServiceLoader.load(ManagedChannelProvider.class, classLoader);
    }

    private static ClassLoader getCorrectClassLoader() {
        return isAndroid() ? ManagedChannelProvider.class.getClassLoader() : Thread.currentThread().getContextClassLoader();
    }

    protected static boolean isAndroid() {
        try {
            Class.forName("android.app.Application", false, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    static ManagedChannelProvider load(ClassLoader classLoader) {
        Iterable<ManagedChannelProvider> candidatesViaHardCoded = isAndroid() ? getCandidatesViaHardCoded(classLoader) : getCandidatesViaServiceLoader(classLoader);
        ArrayList arrayList = new ArrayList();
        for (ManagedChannelProvider managedChannelProvider : candidatesViaHardCoded) {
            if (managedChannelProvider.isAvailable()) {
                arrayList.add(managedChannelProvider);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (ManagedChannelProvider) Collections.max(arrayList, new Comparator<ManagedChannelProvider>() { // from class: io.grpc.ManagedChannelProvider.1
            @Override // java.util.Comparator
            public int compare(ManagedChannelProvider managedChannelProvider2, ManagedChannelProvider managedChannelProvider3) {
                return managedChannelProvider2.priority() - managedChannelProvider3.priority();
            }
        });
    }

    public static ManagedChannelProvider provider() {
        ManagedChannelProvider managedChannelProvider = provider;
        if (managedChannelProvider != null) {
            return managedChannelProvider;
        }
        throw new ProviderNotFoundException("No functional channel service provider found. Try adding a dependency on the grpc-okhttp or grpc-netty artifact");
    }

    protected abstract ManagedChannelBuilder<?> builderForAddress(String str, int i);

    protected abstract ManagedChannelBuilder<?> builderForTarget(String str);

    protected abstract boolean isAvailable();

    protected abstract int priority();
}
