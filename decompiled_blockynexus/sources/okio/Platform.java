package okio;

import kotlin.jvm.a.a;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;
import kotlin.text.c;

/* JADX INFO: renamed from: okio.-Platform, reason: invalid class name */
/* JADX INFO: compiled from: -Platform.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class Platform {
    public static final byte[] asUtf8ToByteArray(String str) {
        i.b(str, "$this$asUtf8ToByteArray");
        byte[] bytes = str.getBytes(c.f22856a);
        i.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    public static final <R> R m124synchronized(Object obj, a<? extends R> aVar) {
        R rInvoke;
        i.b(obj, "lock");
        i.b(aVar, "block");
        synchronized (obj) {
            try {
                rInvoke = aVar.invoke();
                h.b(1);
            } catch (Throwable th) {
                h.b(1);
                h.a(1);
                throw th;
            }
        }
        h.a(1);
        return rInvoke;
    }

    public static final String toUtf8String(byte[] bArr) {
        i.b(bArr, "$this$toUtf8String");
        return new String(bArr, c.f22856a);
    }
}
