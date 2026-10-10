package com.google.protobuf;

import com.google.protobuf.C2308n.a;
import com.google.protobuf.WireFormat;
import com.google.protobuf.t;
import com.google.protobuf.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.google.protobuf.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FieldSet.java */
/* JADX INFO: loaded from: classes2.dex */
final class C2308n<FieldDescriptorType extends a<FieldDescriptorType>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C2308n f14364a = new C2308n(true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14367d = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final H<FieldDescriptorType, Object> f14365b = H.b(16);

    /* JADX INFO: renamed from: com.google.protobuf.n$a */
    /* JADX INFO: compiled from: FieldSet.java */
    public interface a<T extends a<T>> extends Comparable<T> {
        x.a a(x.a aVar, x xVar);

        boolean j();

        WireFormat.FieldType k();

        WireFormat.JavaType l();
    }

    private C2308n() {
    }

    public static <T extends a<T>> C2308n<T> d() {
        return new C2308n<>();
    }

    public boolean a() {
        return this.f14366c;
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> b() {
        return this.f14367d ? new t.b(this.f14365b.entrySet().iterator()) : this.f14365b.entrySet().iterator();
    }

    public void c() {
        if (this.f14366c) {
            return;
        }
        this.f14365b.e();
        this.f14366c = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2308n) {
            return this.f14365b.equals(((C2308n) obj).f14365b);
        }
        return false;
    }

    public int hashCode() {
        return this.f14365b.hashCode();
    }

    public Object a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f14365b.get(fielddescriptortype);
        return obj instanceof t ? ((t) obj).a() : obj;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public C2308n<FieldDescriptorType> m78clone() {
        C2308n<FieldDescriptorType> c2308nD = d();
        for (int i = 0; i < this.f14365b.a(); i++) {
            Map.Entry<K, Object> entryA = this.f14365b.a(i);
            c2308nD.a((a) entryA.getKey(), entryA.getValue());
        }
        Iterator it = this.f14365b.c().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            c2308nD.a((a) entry.getKey(), entry.getValue());
        }
        c2308nD.f14367d = this.f14367d;
        return c2308nD;
    }

    private C2308n(boolean z) {
        c();
    }

    public void a(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.j()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    a(fielddescriptortype.k(), it.next());
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            a(fielddescriptortype.k(), obj);
        }
        if (obj instanceof t) {
            this.f14367d = true;
        }
        this.f14365b.put(fielddescriptortype, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.google.protobuf.WireFormat.FieldType r2, java.lang.Object r3) {
        /*
            if (r3 == 0) goto L4c
            int[] r0 = com.google.protobuf.C2307m.f14362a
            com.google.protobuf.WireFormat$JavaType r2 = r2.getJavaType()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L3f;
                case 2: goto L3c;
                case 3: goto L39;
                case 4: goto L36;
                case 5: goto L33;
                case 6: goto L30;
                case 7: goto L27;
                case 8: goto L1e;
                case 9: goto L14;
                default: goto L13;
            }
        L13:
            goto L41
        L14:
            boolean r2 = r3 instanceof com.google.protobuf.x
            if (r2 != 0) goto L1c
            boolean r2 = r3 instanceof com.google.protobuf.t
            if (r2 == 0) goto L41
        L1c:
            r1 = 1
            goto L41
        L1e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L1c
            boolean r2 = r3 instanceof com.google.protobuf.r.c
            if (r2 == 0) goto L41
            goto L1c
        L27:
            boolean r2 = r3 instanceof com.google.protobuf.ByteString
            if (r2 != 0) goto L1c
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L41
            goto L1c
        L30:
            boolean r1 = r3 instanceof java.lang.String
            goto L41
        L33:
            boolean r1 = r3 instanceof java.lang.Boolean
            goto L41
        L36:
            boolean r1 = r3 instanceof java.lang.Double
            goto L41
        L39:
            boolean r1 = r3 instanceof java.lang.Float
            goto L41
        L3c:
            boolean r1 = r3 instanceof java.lang.Long
            goto L41
        L3f:
            boolean r1 = r3 instanceof java.lang.Integer
        L41:
            if (r1 == 0) goto L44
            return
        L44:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        L4c:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            r2.<init>()
            goto L53
        L52:
            throw r2
        L53:
            goto L52
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C2308n.a(com.google.protobuf.WireFormat$FieldType, java.lang.Object):void");
    }

    public void a(C2308n<FieldDescriptorType> c2308n) {
        for (int i = 0; i < c2308n.f14365b.a(); i++) {
            a((Map.Entry) c2308n.f14365b.a(i));
        }
        Iterator it = c2308n.f14365b.c().iterator();
        while (it.hasNext()) {
            a((Map.Entry) it.next());
        }
    }

    private Object a(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private void a(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof t) {
            value = ((t) value).a();
        }
        if (key.j()) {
            Object objA = a((a) key);
            if (objA == null) {
                objA = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objA).add(a(it.next()));
            }
            this.f14365b.put(key, objA);
            return;
        }
        if (key.l() == WireFormat.JavaType.MESSAGE) {
            Object objA2 = a((a) key);
            if (objA2 == null) {
                this.f14365b.put(key, a(value));
                return;
            } else {
                this.f14365b.put(key, key.a(((x) objA2).toBuilder(), (x) value).build());
                return;
            }
        }
        this.f14365b.put(key, a(value));
    }
}
