package io.grpc;

import com.google.common.base.m;
import io.grpc.Attributes;
import io.grpc.NameResolver;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NameResolverProvider extends NameResolver.Factory {
    public static final Attributes.Key<Integer> PARAMS_DEFAULT_PORT = NameResolver.Factory.PARAMS_DEFAULT_PORT;
    private static final List<NameResolverProvider> providers = load(getCorrectClassLoader());
    private static final NameResolver.Factory factory = new NameResolverFactory(providers);

    private static class NameResolverFactory extends NameResolver.Factory {
        private final List<NameResolverProvider> providers;

        public NameResolverFactory(List<NameResolverProvider> list) {
            this.providers = list;
        }

        private void checkForProviders() {
            m.b(!this.providers.isEmpty(), "No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
        }

        @Override // io.grpc.NameResolver.Factory
        public String getDefaultScheme() {
            checkForProviders();
            return this.providers.get(0).getDefaultScheme();
        }

        @Override // io.grpc.NameResolver.Factory
        public NameResolver newNameResolver(URI uri, Attributes attributes) {
            checkForProviders();
            Iterator<NameResolverProvider> it = this.providers.iterator();
            while (it.hasNext()) {
                NameResolver nameResolverNewNameResolver = it.next().newNameResolver(uri, attributes);
                if (nameResolverNewNameResolver != null) {
                    return nameResolverNewNameResolver;
                }
            }
            return null;
        }
    }

    public static NameResolver.Factory asFactory() {
        return factory;
    }

    static NameResolverProvider create(Class<?> cls) {
        try {
            return (NameResolverProvider) cls.asSubclass(NameResolverProvider.class).newInstance();
        } catch (Throwable th) {
            throw new ServiceConfigurationError("Provider " + cls.getName() + " could not be instantiated: " + th, th);
        }
    }

    public static Iterable<NameResolverProvider> getCandidatesViaHardCoded(ClassLoader classLoader) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(create(Class.forName("io.grpc.internal.DnsNameResolverProvider", true, classLoader)));
        } catch (ClassNotFoundException unused) {
        }
        return arrayList;
    }

    public static Iterable<NameResolverProvider> getCandidatesViaServiceLoader(ClassLoader classLoader) {
        return ServiceLoader.load(NameResolverProvider.class, classLoader);
    }

    private static ClassLoader getCorrectClassLoader() {
        return isAndroid() ? NameResolverProvider.class.getClassLoader() : Thread.currentThread().getContextClassLoader();
    }

    private static boolean isAndroid() {
        try {
            Class.forName("android.app.Application", false, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    static List<NameResolverProvider> load(ClassLoader classLoader) {
        Iterable<NameResolverProvider> candidatesViaHardCoded = isAndroid() ? getCandidatesViaHardCoded(classLoader) : getCandidatesViaServiceLoader(classLoader);
        ArrayList arrayList = new ArrayList();
        for (NameResolverProvider nameResolverProvider : candidatesViaHardCoded) {
            if (nameResolverProvider.isAvailable()) {
                arrayList.add(nameResolverProvider);
            }
        }
        Collections.sort(arrayList, Collections.reverseOrder(new Comparator<NameResolverProvider>() { // from class: io.grpc.NameResolverProvider.1
            @Override // java.util.Comparator
            public int compare(NameResolverProvider nameResolverProvider2, NameResolverProvider nameResolverProvider3) {
                return nameResolverProvider2.priority() - nameResolverProvider3.priority();
            }
        }));
        return Collections.unmodifiableList(arrayList);
    }

    public static List<NameResolverProvider> providers() {
        return providers;
    }

    protected abstract boolean isAvailable();

    protected abstract int priority();

    static NameResolver.Factory asFactory(List<NameResolverProvider> list) {
        return new NameResolverFactory(list);
    }
}
