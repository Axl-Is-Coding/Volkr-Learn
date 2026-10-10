package kotlin.c;

import com.facebook.internal.NativeProtocol;
import kotlin.TypeCastException;
import kotlin.jvm.internal.i;
import kotlin.text.o;

/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22806a;

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0145  */
    static {
        /*
            Method dump skipped, instruction units count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.c.b.<clinit>():void");
    }

    private static final int a() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
        }
        int iA = o.a((CharSequence) property, '.', 0, false, 6, (Object) null);
        if (iA < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
            }
        }
        int i = iA + 1;
        int iA2 = o.a((CharSequence) property, '.', i, false, 4, (Object) null);
        if (iA2 < 0) {
            iA2 = property.length();
        }
        if (property == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = property.substring(0, iA);
        i.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (property == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring2 = property.substring(i, iA2);
        i.a((Object) strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        try {
            return (Integer.parseInt(strSubstring) * 65536) + Integer.parseInt(strSubstring2);
        } catch (NumberFormatException unused2) {
            return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
        }
    }
}
