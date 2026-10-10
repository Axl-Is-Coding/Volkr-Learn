package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CallbackRegistry<C, T, A> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<C> f1327a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1328b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long[] f1329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final NotifierCallback<C, T, A> f1331e;

    public static abstract class NotifierCallback<C, T, A> {
        public abstract void onNotifyCallback(C c2, T t, int i, A a2);
    }

    public CallbackRegistry(NotifierCallback<C, T, A> notifierCallback) {
        this.f1331e = notifierCallback;
    }

    private void b(T t, int i, A a2) {
        a(t, i, a2, 0, Math.min(64, this.f1327a.size()), this.f1328b);
    }

    private void c(T t, int i, A a2) {
        int size = this.f1327a.size();
        int length = this.f1329c == null ? -1 : r0.length - 1;
        a(t, i, a2, length);
        a(t, i, a2, (length + 2) * 64, size, 0L);
    }

    public synchronized void a(T t, int i, A a2) {
        this.f1330d++;
        c(t, i, a2);
        this.f1330d--;
        if (this.f1330d == 0) {
            if (this.f1329c != null) {
                for (int length = this.f1329c.length - 1; length >= 0; length--) {
                    long j = this.f1329c[length];
                    if (j != 0) {
                        a((length + 1) * 64, j);
                        this.f1329c[length] = 0;
                    }
                }
            }
            if (this.f1328b != 0) {
                a(0, this.f1328b);
                this.f1328b = 0L;
            }
        }
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public synchronized CallbackRegistry<C, T, A> m3clone() {
        CallbackRegistry<C, T, A> callbackRegistry;
        CloneNotSupportedException e2;
        try {
            callbackRegistry = (CallbackRegistry) super.clone();
            try {
                callbackRegistry.f1328b = 0L;
                callbackRegistry.f1329c = null;
                callbackRegistry.f1330d = 0;
                callbackRegistry.f1327a = new ArrayList();
                int size = this.f1327a.size();
                for (int i = 0; i < size; i++) {
                    if (!a(i)) {
                        callbackRegistry.f1327a.add(this.f1327a.get(i));
                    }
                }
            } catch (CloneNotSupportedException e3) {
                e2 = e3;
                e2.printStackTrace();
            }
        } catch (CloneNotSupportedException e4) {
            callbackRegistry = null;
            e2 = e4;
        }
        return callbackRegistry;
    }

    public synchronized void b(C c2) {
        if (this.f1330d == 0) {
            this.f1327a.remove(c2);
        } else {
            int iLastIndexOf = this.f1327a.lastIndexOf(c2);
            if (iLastIndexOf >= 0) {
                b(iLastIndexOf);
            }
        }
    }

    private void b(int i) {
        if (i < 64) {
            this.f1328b = (1 << i) | this.f1328b;
            return;
        }
        int i2 = (i / 64) - 1;
        long[] jArr = this.f1329c;
        if (jArr == null) {
            this.f1329c = new long[this.f1327a.size() / 64];
        } else if (jArr.length <= i2) {
            long[] jArr2 = new long[this.f1327a.size() / 64];
            long[] jArr3 = this.f1329c;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.f1329c = jArr2;
        }
        long j = 1 << (i % 64);
        long[] jArr4 = this.f1329c;
        jArr4[i2] = j | jArr4[i2];
    }

    private void a(T t, int i, A a2, int i2) {
        if (i2 < 0) {
            b(t, i, a2);
            return;
        }
        long j = this.f1329c[i2];
        int i3 = (i2 + 1) * 64;
        int iMin = Math.min(this.f1327a.size(), i3 + 64);
        a(t, i, a2, i2 - 1);
        a(t, i, a2, i3, iMin, j);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void a(T t, int i, A a2, int i2, int i3, long j) {
        long j2 = 1;
        while (i2 < i3) {
            if ((j & j2) == 0) {
                this.f1331e.onNotifyCallback(this.f1327a.get(i2), t, i, a2);
            }
            j2 <<= 1;
            i2++;
        }
    }

    public synchronized void a(C c2) {
        if (c2 != null) {
            int iLastIndexOf = this.f1327a.lastIndexOf(c2);
            if (iLastIndexOf < 0 || a(iLastIndexOf)) {
                this.f1327a.add(c2);
            }
        } else {
            throw new IllegalArgumentException("callback cannot be null");
        }
    }

    private boolean a(int i) {
        int i2;
        if (i < 64) {
            return ((1 << i) & this.f1328b) != 0;
        }
        long[] jArr = this.f1329c;
        if (jArr != null && (i2 = (i / 64) - 1) < jArr.length) {
            return ((1 << (i % 64)) & jArr[i2]) != 0;
        }
        return false;
    }

    private void a(int i, long j) {
        long j2 = Long.MIN_VALUE;
        for (int i2 = (i + 64) - 1; i2 >= i; i2--) {
            if ((j & j2) != 0) {
                this.f1327a.remove(i2);
            }
            j2 >>>= 1;
        }
    }
}
