package com.google.protobuf;

import com.google.protobuf.AbstractC2295a;
import com.google.protobuf.C2308n;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.a;
import com.google.protobuf.WireFormat;
import com.google.protobuf.r;
import com.google.protobuf.x;
import com.sandboxol.center.router.moduleInfo.game.team.connector.TeamQueueGoing;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends AbstractC2295a<MessageType, BuilderType> {
    protected K unknownFields = K.b();
    protected int memoizedSerializedSize = -1;

    static class EqualsVisitor implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final EqualsVisitor f14283a = new EqualsVisitor();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final NotEqualsException f14284b = new NotEqualsException();

        static final class NotEqualsException extends RuntimeException {
            NotEqualsException() {
            }
        }

        private EqualsVisitor() {
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public boolean a(boolean z, boolean z2, boolean z3, boolean z4) {
            if (z == z3 && z2 == z4) {
                return z2;
            }
            throw f14284b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public Object b(boolean z, Object obj, Object obj2) {
            if (z && ((GeneratedMessageLite) obj).equals(this, (x) obj2)) {
                return obj;
            }
            throw f14284b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public int a(boolean z, int i, boolean z2, int i2) {
            if (z == z2 && i == i2) {
                return i;
            }
            throw f14284b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public long a(boolean z, long j, boolean z2, long j2) {
            if (z == z2 && j == j2) {
                return j;
            }
            throw f14284b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public String a(boolean z, String str, boolean z2, String str2) {
            if (z == z2 && str.equals(str2)) {
                return str;
            }
            throw f14284b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public Object a(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw f14284b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public void a(boolean z) {
            if (z) {
                throw f14284b;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public <T extends x> T a(T t, T t2) {
            if (t == null && t2 == null) {
                return null;
            }
            if (t != null && t2 != null) {
                ((GeneratedMessageLite) t).equals(this, t2);
                return t;
            }
            throw f14284b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public <T> r.h<T> a(r.h<T> hVar, r.h<T> hVar2) {
            if (hVar.equals(hVar2)) {
                return hVar;
            }
            throw f14284b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public r.f a(r.f fVar, r.f fVar2) {
            if (fVar.equals(fVar2)) {
                return fVar;
            }
            throw f14284b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public C2308n<e> a(C2308n<e> c2308n, C2308n<e> c2308n2) {
            if (c2308n.equals(c2308n2)) {
                return c2308n;
            }
            throw f14284b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public K a(K k, K k2) {
            if (k.equals(k2)) {
                return k;
            }
            throw f14284b;
        }
    }

    public enum MethodToInvoke {
        IS_INITIALIZED,
        VISIT,
        MERGE_FROM_STREAM,
        MAKE_IMMUTABLE,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static abstract class a<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends AbstractC2295a.AbstractC0138a<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        protected MessageType instance;
        protected boolean isBuilt = false;

        protected a(MessageType messagetype) {
            this.defaultInstance = messagetype;
            this.instance = (MessageType) messagetype.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        protected void copyOnWrite() {
            if (this.isBuilt) {
                MessageType messagetype = (MessageType) this.instance.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
                messagetype.visit(h.f14297a, this.instance);
                this.instance = messagetype;
                this.isBuilt = false;
            }
        }

        @Override // com.google.protobuf.y
        public final boolean isInitialized() {
            return GeneratedMessageLite.isInitialized(this.instance, false);
        }

        @Override // com.google.protobuf.x.a
        public final MessageType build() {
            MessageType messagetype = (MessageType) m64buildPartial();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw AbstractC2295a.AbstractC0138a.newUninitializedMessageException(messagetype);
        }

        /* JADX INFO: renamed from: buildPartial, reason: merged with bridge method [inline-methods] */
        public MessageType m64buildPartial() {
            if (this.isBuilt) {
                return this.instance;
            }
            this.instance.makeImmutable();
            this.isBuilt = true;
            return this.instance;
        }

        /* JADX INFO: renamed from: clear, reason: merged with bridge method [inline-methods] */
        public final BuilderType m65clear() {
            this.instance = (MessageType) this.instance.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            return this;
        }

        @Override // com.google.protobuf.y
        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.AbstractC2295a.AbstractC0138a
        public BuilderType internalMergeFrom(MessageType messagetype) {
            return (BuilderType) mergeFrom((GeneratedMessageLite) messagetype);
        }

        public BuilderType mergeFrom(MessageType messagetype) {
            copyOnWrite();
            this.instance.visit(h.f14297a, messagetype);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.AbstractC2295a.AbstractC0138a
        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public BuilderType mo67clone() {
            TeamQueueGoing.Builder builder = (BuilderType) getDefaultInstanceForType().mo63newBuilderForType();
            builder.mergeFrom(m64buildPartial());
            return builder;
        }

        @Override // com.google.protobuf.AbstractC2295a.AbstractC0138a
        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType mo68mergeFrom(C2301g c2301g, C2306l c2306l) throws IOException {
            copyOnWrite();
            try {
                this.instance.dynamicMethod(MethodToInvoke.MERGE_FROM_STREAM, c2301g, c2306l);
                return this;
            } catch (RuntimeException e2) {
                if (e2.getCause() instanceof IOException) {
                    throw ((IOException) e2.getCause());
                }
                throw e2;
            }
        }
    }

    protected static class b<T extends GeneratedMessageLite<T, ?>> extends AbstractC2296b<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private T f14285b;

        public b(T t) {
            this.f14285b = t;
        }

        @Override // com.google.protobuf.A
        public T b(C2301g c2301g, C2306l c2306l) throws InvalidProtocolBufferException {
            return (T) GeneratedMessageLite.parsePartialFrom(this.f14285b, c2301g, c2306l);
        }
    }

    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements d<MessageType, BuilderType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected C2308n<e> f14286a = C2308n.d();

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.protobuf.GeneratedMessageLite
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void visit(i iVar, MessageType messagetype) {
            super.visit(iVar, messagetype);
            this.f14286a = iVar.a(this.f14286a, messagetype.f14286a);
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.y
        public /* bridge */ /* synthetic */ x getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final void makeImmutable() {
            super.makeImmutable();
            this.f14286a.c();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        /* JADX INFO: renamed from: newBuilderForType */
        public /* bridge */ /* synthetic */ x.a mo63newBuilderForType() {
            return super.mo63newBuilderForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.x
        public /* bridge */ /* synthetic */ x.a toBuilder() {
            return super.toBuilder();
        }
    }

    public interface d<MessageType extends c<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends y {
    }

    static final class e implements C2308n.a<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final r.d<?> f14287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f14288b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final WireFormat.FieldType f14289c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f14290d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final boolean f14291e;

        e(r.d<?> dVar, int i, WireFormat.FieldType fieldType, boolean z, boolean z2) {
            this.f14287a = dVar;
            this.f14288b = i;
            this.f14289c = fieldType;
            this.f14290d = z;
            this.f14291e = z2;
        }

        public int a() {
            return this.f14288b;
        }

        @Override // com.google.protobuf.C2308n.a
        public boolean j() {
            return this.f14290d;
        }

        @Override // com.google.protobuf.C2308n.a
        public WireFormat.FieldType k() {
            return this.f14289c;
        }

        @Override // com.google.protobuf.C2308n.a
        public WireFormat.JavaType l() {
            return this.f14289c.getJavaType();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.C2308n.a
        public x.a a(x.a aVar, x xVar) {
            return ((a) aVar).mergeFrom((GeneratedMessageLite) xVar);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return this.f14288b - eVar.f14288b;
        }
    }

    public static class f<ContainingType extends x, Type> extends AbstractC2304j<ContainingType, Type> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ContainingType f14292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Type f14293b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final x f14294c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final e f14295d;

        f(ContainingType containingtype, Type type, x xVar, e eVar, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (eVar.k() == WireFormat.FieldType.MESSAGE && xVar == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.f14292a = containingtype;
            this.f14293b = type;
            this.f14294c = xVar;
            this.f14295d = eVar;
        }
    }

    private static class g implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f14296a;

        private g() {
            this.f14296a = 0;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public Object b(boolean z, Object obj, Object obj2) {
            x xVar = (x) obj;
            a(xVar, (x) obj2);
            return xVar;
        }

        /* synthetic */ g(p pVar) {
            this();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public boolean a(boolean z, boolean z2, boolean z3, boolean z4) {
            this.f14296a = (this.f14296a * 53) + r.a(z2);
            return z2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public int a(boolean z, int i, boolean z2, int i2) {
            this.f14296a = (this.f14296a * 53) + i;
            return i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public long a(boolean z, long j, boolean z2, long j2) {
            this.f14296a = (this.f14296a * 53) + r.a(j);
            return j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public String a(boolean z, String str, boolean z2, String str2) {
            this.f14296a = (this.f14296a * 53) + str.hashCode();
            return str;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public Object a(boolean z, Object obj, Object obj2) {
            this.f14296a = (this.f14296a * 53) + r.a(((Boolean) obj).booleanValue());
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public void a(boolean z) {
            if (z) {
                throw new IllegalStateException();
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public <T extends x> T a(T t, T t2) {
            int iHashCode;
            if (t == null) {
                iHashCode = 37;
            } else if (t instanceof GeneratedMessageLite) {
                iHashCode = ((GeneratedMessageLite) t).hashCode(this);
            } else {
                iHashCode = t.hashCode();
            }
            this.f14296a = (this.f14296a * 53) + iHashCode;
            return t;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public <T> r.h<T> a(r.h<T> hVar, r.h<T> hVar2) {
            this.f14296a = (this.f14296a * 53) + hVar.hashCode();
            return hVar;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public r.f a(r.f fVar, r.f fVar2) {
            this.f14296a = (this.f14296a * 53) + fVar.hashCode();
            return fVar;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public C2308n<e> a(C2308n<e> c2308n, C2308n<e> c2308n2) {
            this.f14296a = (this.f14296a * 53) + c2308n.hashCode();
            return c2308n;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public K a(K k, K k2) {
            this.f14296a = (this.f14296a * 53) + k.hashCode();
            return k;
        }
    }

    protected static class h implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f14297a = new h();

        private h() {
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public int a(boolean z, int i, boolean z2, int i2) {
            return z2 ? i2 : i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public long a(boolean z, long j, boolean z2, long j2) {
            return z2 ? j2 : j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public <T extends x> T a(T t, T t2) {
            return (t == null || t2 == null) ? t != null ? t : t2 : (T) t.toBuilder().mergeFrom(t2).build();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public Object a(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public String a(boolean z, String str, boolean z2, String str2) {
            return z2 ? str2 : str;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public void a(boolean z) {
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public boolean a(boolean z, boolean z2, boolean z3, boolean z4) {
            return z3 ? z4 : z2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public Object b(boolean z, Object obj, Object obj2) {
            return z ? a((x) obj, (x) obj2) : obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public <T> r.h<T> a(r.h<T> hVar, r.h<T> hVar2) {
            int size = hVar.size();
            int size2 = hVar2.size();
            if (size > 0 && size2 > 0) {
                if (!hVar.d()) {
                    hVar = hVar.a2(size2 + size);
                }
                hVar.addAll(hVar2);
            }
            return size > 0 ? hVar : hVar2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public r.f a(r.f fVar, r.f fVar2) {
            int size = fVar.size();
            int size2 = fVar2.size();
            r.f fVar3 = fVar;
            fVar3 = fVar;
            if (size > 0 && size2 > 0) {
                boolean zD = fVar.d();
                r.f fVarA = fVar;
                if (!zD) {
                    fVarA = fVar.a2(size2 + size);
                }
                fVarA.addAll(fVar2);
                fVar3 = fVarA;
            }
            return size > 0 ? fVar3 : fVar2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public C2308n<e> a(C2308n<e> c2308n, C2308n<e> c2308n2) {
            if (c2308n.a()) {
                c2308n = c2308n.m78clone();
            }
            c2308n.a((C2308n) c2308n2);
            return c2308n;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.i
        public K a(K k, K k2) {
            return k2 == K.b() ? k : K.a(k, k2);
        }
    }

    protected interface i {
        int a(boolean z, int i, boolean z2, int i2);

        long a(boolean z, long j, boolean z2, long j2);

        K a(K k, K k2);

        C2308n<e> a(C2308n<e> c2308n, C2308n<e> c2308n2);

        r.f a(r.f fVar, r.f fVar2);

        <T> r.h<T> a(r.h<T> hVar, r.h<T> hVar2);

        <T extends x> T a(T t, T t2);

        Object a(boolean z, Object obj, Object obj2);

        String a(boolean z, String str, boolean z2, String str2);

        void a(boolean z);

        boolean a(boolean z, boolean z2, boolean z3, boolean z4);

        Object b(boolean z, Object obj, Object obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends c<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>, T> f<MessageType, T> checkIsLite(AbstractC2304j<MessageType, T> abstractC2304j) {
        if (abstractC2304j.a()) {
            return (f) abstractC2304j;
        }
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T t) throws InvalidProtocolBufferException {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw t.newUninitializedMessageException().asInvalidProtocolBufferException().setUnfinishedMessage(t);
    }

    protected static r.a emptyBooleanList() {
        return C2298d.c();
    }

    protected static r.b emptyDoubleList() {
        return C2303i.c();
    }

    protected static r.e emptyFloatList() {
        return o.c();
    }

    protected static r.f emptyIntList() {
        return q.c();
    }

    protected static r.g emptyLongList() {
        return w.c();
    }

    protected static <E> r.h<E> emptyProtobufList() {
        return B.c();
    }

    private final void ensureUnknownFieldsInitialized() {
        if (this.unknownFields == K.b()) {
            this.unknownFields = K.d();
        }
    }

    static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e2);
        }
    }

    static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.r$f] */
    protected static r.f mutableCopy(r.f fVar) {
        int size = fVar.size();
        return fVar.a2(size == 0 ? 10 : size * 2);
    }

    public static <ContainingType extends x, Type> f<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, x xVar, r.d<?> dVar, int i2, WireFormat.FieldType fieldType, boolean z, Class cls) {
        return new f<>(containingtype, Collections.emptyList(), xVar, new e(dVar, i2, fieldType, true, z), cls);
    }

    public static <ContainingType extends x, Type> f<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, x xVar, r.d<?> dVar, int i2, WireFormat.FieldType fieldType, Class cls) {
        return new f<>(containingtype, type, xVar, new e(dVar, i2, fieldType, false, false), cls);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        T t2 = (T) parsePartialDelimitedFrom(t, inputStream, C2306l.a());
        checkMessageInitialized(t2);
        return t2;
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteString byteString) throws InvalidProtocolBufferException {
        T t2 = (T) parseFrom(t, byteString, C2306l.a());
        checkMessageInitialized(t2);
        return t2;
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T t, InputStream inputStream, C2306l c2306l) throws InvalidProtocolBufferException {
        try {
            int i2 = inputStream.read();
            if (i2 == -1) {
                return null;
            }
            C2301g c2301gA = C2301g.a(new AbstractC2295a.AbstractC0138a.C0139a(inputStream, C2301g.a(i2, inputStream)));
            T t2 = (T) parsePartialFrom(t, c2301gA, c2306l);
            try {
                c2301gA.a(0);
                return t2;
            } catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(t2);
            }
        } catch (IOException e3) {
            throw new InvalidProtocolBufferException(e3.getMessage());
        }
    }

    static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, C2301g c2301g, C2306l c2306l) throws InvalidProtocolBufferException {
        T t2 = (T) t.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            t2.dynamicMethod(MethodToInvoke.MERGE_FROM_STREAM, c2301g, c2306l);
            t2.makeImmutable();
            return t2;
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e2.getCause());
            }
            throw e2;
        }
    }

    protected Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj) {
        return dynamicMethod(methodToInvoke, obj, null);
    }

    protected abstract Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(obj)) {
            return false;
        }
        try {
            visit(EqualsVisitor.f14283a, (GeneratedMessageLite) obj);
            return true;
        } catch (EqualsVisitor.NotEqualsException unused) {
            return false;
        }
    }

    @Override // com.google.protobuf.x
    public final A<MessageType> getParserForType() {
        return (A) dynamicMethod(MethodToInvoke.GET_PARSER);
    }

    public int hashCode() {
        if (this.memoizedHashCode == 0) {
            g gVar = new g(null);
            visit(gVar, this);
            this.memoizedHashCode = gVar.f14296a;
        }
        return this.memoizedHashCode;
    }

    @Override // com.google.protobuf.y
    public final boolean isInitialized() {
        return dynamicMethod(MethodToInvoke.IS_INITIALIZED, Boolean.TRUE) != null;
    }

    protected void makeImmutable() {
        dynamicMethod(MethodToInvoke.MAKE_IMMUTABLE);
        this.unknownFields.c();
    }

    protected void mergeLengthDelimitedField(int i2, ByteString byteString) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.a(i2, byteString);
    }

    protected final void mergeUnknownFields(K k) {
        this.unknownFields = K.a(this.unknownFields, k);
    }

    protected void mergeVarintField(int i2, int i3) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.a(i2, i3);
    }

    protected boolean parseUnknownField(int i2, C2301g c2301g) throws IOException {
        if (WireFormat.b(i2) == 4) {
            return false;
        }
        ensureUnknownFieldsInitialized();
        return this.unknownFields.a(i2, c2301g);
    }

    public String toString() {
        return z.a(this, super.toString());
    }

    void visit(i iVar, MessageType messagetype) {
        dynamicMethod(MethodToInvoke.VISIT, iVar, messagetype);
        this.unknownFields = iVar.a(this.unknownFields, messagetype.unknownFields);
    }

    protected static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T t, boolean z) {
        return t.dynamicMethod(MethodToInvoke.IS_INITIALIZED, Boolean.valueOf(z)) != null;
    }

    protected Object dynamicMethod(MethodToInvoke methodToInvoke) {
        return dynamicMethod(methodToInvoke, null, null);
    }

    @Override // com.google.protobuf.y
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    @Override // 
    /* JADX INFO: renamed from: newBuilderForType, reason: merged with bridge method [inline-methods] */
    public final BuilderType mo63newBuilderForType() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    @Override // com.google.protobuf.x
    public final BuilderType toBuilder() {
        BuilderType buildertype = (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
        buildertype.mergeFrom(this);
        return buildertype;
    }

    protected static final <T extends GeneratedMessageLite<T, ?>> void makeImmutable(T t) {
        t.dynamicMethod(MethodToInvoke.MAKE_IMMUTABLE);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.r$g] */
    protected static r.g mutableCopy(r.g gVar) {
        int size = gVar.size();
        return gVar.a2(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        T t2 = (T) parsePartialFrom(t, byteString, c2306l);
        checkMessageInitialized(t2);
        return t2;
    }

    boolean equals(EqualsVisitor equalsVisitor, x xVar) {
        if (this == xVar) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(xVar)) {
            return false;
        }
        visit(equalsVisitor, (GeneratedMessageLite) xVar);
        return true;
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream, C2306l c2306l) throws InvalidProtocolBufferException {
        T t2 = (T) parsePartialDelimitedFrom(t, inputStream, c2306l);
        checkMessageInitialized(t2);
        return t2;
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, byte[] bArr) throws InvalidProtocolBufferException {
        T t2 = (T) parsePartialFrom(t, bArr, C2306l.a());
        checkMessageInitialized(t2);
        return t2;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.r$e] */
    protected static r.e mutableCopy(r.e eVar) {
        int size = eVar.size();
        return eVar.a2(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        T t2 = (T) parsePartialFrom(t, bArr, c2306l);
        checkMessageInitialized(t2);
        return t2;
    }

    int hashCode(g gVar) {
        if (this.memoizedHashCode == 0) {
            int i2 = gVar.f14296a;
            gVar.f14296a = 0;
            visit(gVar, this);
            this.memoizedHashCode = gVar.f14296a;
            gVar.f14296a = i2;
        }
        return this.memoizedHashCode;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.r$b] */
    protected static r.b mutableCopy(r.b bVar) {
        int size = bVar.size();
        return bVar.a2(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        T t2 = (T) parsePartialFrom(t, C2301g.a(inputStream), C2306l.a());
        checkMessageInitialized(t2);
        return t2;
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, C2301g c2301g) throws InvalidProtocolBufferException {
        return (T) parsePartialFrom(t, c2301g, C2306l.a());
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, ByteString byteString, C2306l c2306l) throws InvalidProtocolBufferException {
        try {
            C2301g c2301gNewCodedInput = byteString.newCodedInput();
            T t2 = (T) parsePartialFrom(t, c2301gNewCodedInput, c2306l);
            try {
                c2301gNewCodedInput.a(0);
                return t2;
            } catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(t2);
            }
        } catch (InvalidProtocolBufferException e3) {
            throw e3;
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.r$a] */
    protected static r.a mutableCopy(r.a aVar) {
        int size = aVar.size();
        return aVar.a2(size == 0 ? 10 : size * 2);
    }

    protected static <E> r.h<E> mutableCopy(r.h<E> hVar) {
        int size = hVar.size();
        return hVar.a2(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, InputStream inputStream, C2306l c2306l) throws InvalidProtocolBufferException {
        T t2 = (T) parsePartialFrom(t, C2301g.a(inputStream), c2306l);
        checkMessageInitialized(t2);
        return t2;
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, C2301g c2301g) throws InvalidProtocolBufferException {
        return (T) parseFrom(t, c2301g, C2306l.a());
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, byte[] bArr, C2306l c2306l) throws InvalidProtocolBufferException {
        try {
            C2301g c2301gA = C2301g.a(bArr);
            T t2 = (T) parsePartialFrom(t, c2301gA, c2306l);
            try {
                c2301gA.a(0);
                return t2;
            } catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(t2);
            }
        } catch (InvalidProtocolBufferException e3) {
            throw e3;
        }
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, C2301g c2301g, C2306l c2306l) throws InvalidProtocolBufferException {
        T t2 = (T) parsePartialFrom(t, c2301g, c2306l);
        checkMessageInitialized(t2);
        return t2;
    }
}
