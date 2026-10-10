package kotlin.coroutines.jvm.internal;

import com.google.android.gms.plus.PlusShare;
import java.lang.reflect.Field;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: DebugMetadata.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d {
    public static final StackTraceElement a(BaseContinuationImpl baseContinuationImpl) {
        String strC;
        i.b(baseContinuationImpl, "$this$getStackTraceElementImpl");
        c cVarB = b(baseContinuationImpl);
        if (cVarB == null) {
            return null;
        }
        a(1, cVarB.v());
        int iC = c(baseContinuationImpl);
        int i = iC < 0 ? -1 : cVarB.l()[iC];
        String strA = f.f22820c.a(baseContinuationImpl);
        if (strA == null) {
            strC = cVarB.c();
        } else {
            strC = strA + '/' + cVarB.c();
        }
        return new StackTraceElement(strC, cVarB.m(), cVarB.f(), i);
    }

    private static final c b(BaseContinuationImpl baseContinuationImpl) {
        return (c) baseContinuationImpl.getClass().getAnnotation(c.class);
    }

    private static final int c(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField(PlusShare.KEY_CALL_TO_ACTION_LABEL);
            i.a((Object) declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    private static final void a(int i, int i2) {
        if (i2 <= i) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
    }
}
