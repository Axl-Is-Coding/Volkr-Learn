package io.grpc;

/* JADX INFO: loaded from: classes5.dex */
public abstract class HandlerRegistry {
    public final ServerMethodDefinition<?, ?> lookupMethod(String str) {
        return lookupMethod(str, null);
    }

    public abstract ServerMethodDefinition<?, ?> lookupMethod(String str, String str2);
}
