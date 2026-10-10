package io.grpc;

import com.google.common.base.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes5.dex */
public final class ServiceDescriptor {
    private final Collection<MethodDescriptor<?, ?>> methods;
    private final String name;

    public ServiceDescriptor(String str, MethodDescriptor<?, ?>... methodDescriptorArr) {
        this(str, Arrays.asList(methodDescriptorArr));
    }

    public Collection<MethodDescriptor<?, ?>> getMethods() {
        return this.methods;
    }

    public String getName() {
        return this.name;
    }

    public ServiceDescriptor(String str, Collection<MethodDescriptor<?, ?>> collection) {
        m.a(str);
        this.name = str;
        this.methods = Collections.unmodifiableList(new ArrayList(collection));
    }
}
