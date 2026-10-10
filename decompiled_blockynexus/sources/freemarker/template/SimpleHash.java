package freemarker.template;

import com.umeng.umcrash.UMCustomLogInfoBuilder;
import freemarker.ext.beans.C2867m;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes5.dex */
public class SimpleHash extends M implements B, Serializable {
    private final Map map;
    private boolean putFailed;
    private Map unwrappedMap;

    private class SynchronizedHash extends SimpleHash {
        private SynchronizedHash() {
        }

        @Override // freemarker.template.SimpleHash, freemarker.template.A
        public E get(String str) throws TemplateModelException {
            E e2;
            synchronized (SimpleHash.this) {
                e2 = SimpleHash.this.get(str);
            }
            return e2;
        }

        @Override // freemarker.template.SimpleHash, freemarker.template.A
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (SimpleHash.this) {
                zIsEmpty = SimpleHash.this.isEmpty();
            }
            return zIsEmpty;
        }

        @Override // freemarker.template.SimpleHash, freemarker.template.B
        public s keys() {
            s sVarKeys;
            synchronized (SimpleHash.this) {
                sVarKeys = SimpleHash.this.keys();
            }
            return sVarKeys;
        }

        @Override // freemarker.template.SimpleHash
        public void put(String str, Object obj) {
            synchronized (SimpleHash.this) {
                SimpleHash.this.put(str, obj);
            }
        }

        @Override // freemarker.template.SimpleHash
        public void remove(String str) {
            synchronized (SimpleHash.this) {
                SimpleHash.this.remove(str);
            }
        }

        @Override // freemarker.template.SimpleHash, freemarker.template.B
        public int size() {
            int size;
            synchronized (SimpleHash.this) {
                size = SimpleHash.this.size();
            }
            return size;
        }

        @Override // freemarker.template.SimpleHash
        public Map toMap() throws TemplateModelException {
            Map map;
            synchronized (SimpleHash.this) {
                map = SimpleHash.this.toMap();
            }
            return map;
        }

        @Override // freemarker.template.SimpleHash
        public s values() {
            s sVarValues;
            synchronized (SimpleHash.this) {
                sVarValues = SimpleHash.this.values();
            }
            return sVarValues;
        }
    }

    public SimpleHash() {
        this((InterfaceC2891l) null);
    }

    public boolean containsKey(String str) {
        return this.map.containsKey(str);
    }

    protected Map copyMap(Map map) {
        return map instanceof HashMap ? (Map) ((HashMap) map).clone() : map instanceof SortedMap ? map instanceof TreeMap ? (Map) ((TreeMap) map).clone() : new TreeMap((SortedMap) map) : new HashMap(map);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
    @Override // freemarker.template.A
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public freemarker.template.E get(java.lang.String r8) throws freemarker.template.TemplateModelException {
        /*
            r7 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            java.util.Map r3 = r7.map     // Catch: java.lang.NullPointerException -> L82 java.lang.ClassCastException -> L96
            java.lang.Object r3 = r3.get(r8)     // Catch: java.lang.NullPointerException -> L82 java.lang.ClassCastException -> L96
            if (r3 != 0) goto L69
            int r4 = r8.length()
            r5 = 0
            if (r4 != r2) goto L5a
            java.util.Map r4 = r7.map
            boolean r4 = r4 instanceof java.util.SortedMap
            if (r4 != 0) goto L5a
            java.lang.Character r3 = new java.lang.Character
            char r4 = r8.charAt(r1)
            r3.<init>(r4)
            java.util.Map r4 = r7.map     // Catch: java.lang.NullPointerException -> L32 java.lang.ClassCastException -> L46
            java.lang.Object r4 = r4.get(r3)     // Catch: java.lang.NullPointerException -> L32 java.lang.ClassCastException -> L46
            if (r4 != 0) goto L5c
            java.util.Map r6 = r7.map     // Catch: java.lang.NullPointerException -> L32 java.lang.ClassCastException -> L46
            boolean r0 = r6.containsKey(r3)     // Catch: java.lang.NullPointerException -> L32 java.lang.ClassCastException -> L46
            if (r0 == 0) goto L5b
            goto L5c
        L32:
            r3 = move-exception
            freemarker.core._TemplateModelException r4 = new freemarker.core._TemplateModelException
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r5 = "NullPointerException while getting Map entry with Character key "
            r0[r1] = r5
            freemarker.core.gc r1 = new freemarker.core.gc
            r1.<init>(r8)
            r0[r2] = r1
            r4.<init>(r3, r0)
            throw r4
        L46:
            r3 = move-exception
            freemarker.core._TemplateModelException r4 = new freemarker.core._TemplateModelException
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r5 = "ClassCastException while getting Map entry with Character key "
            r0[r1] = r5
            freemarker.core.gc r1 = new freemarker.core.gc
            r1.<init>(r8)
            r0[r2] = r1
            r4.<init>(r3, r0)
            throw r4
        L5a:
            r4 = r3
        L5b:
            r3 = r5
        L5c:
            if (r3 != 0) goto L67
            java.util.Map r0 = r7.map
            boolean r0 = r0.containsKey(r8)
            if (r0 != 0) goto L6a
            return r5
        L67:
            r8 = r3
            goto L6a
        L69:
            r4 = r3
        L6a:
            boolean r0 = r4 instanceof freemarker.template.E
            if (r0 == 0) goto L71
            freemarker.template.E r4 = (freemarker.template.E) r4
            return r4
        L71:
            freemarker.template.E r0 = r7.wrap(r4)
            boolean r1 = r7.putFailed
            if (r1 != 0) goto L81
            java.util.Map r1 = r7.map     // Catch: java.lang.Exception -> L7f
            r1.put(r8, r0)     // Catch: java.lang.Exception -> L7f
            goto L81
        L7f:
            r7.putFailed = r2
        L81:
            return r0
        L82:
            r3 = move-exception
            freemarker.core._TemplateModelException r4 = new freemarker.core._TemplateModelException
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r5 = "NullPointerException while getting Map entry with String key "
            r0[r1] = r5
            freemarker.core.gc r1 = new freemarker.core.gc
            r1.<init>(r8)
            r0[r2] = r1
            r4.<init>(r3, r0)
            throw r4
        L96:
            r3 = move-exception
            freemarker.core._TemplateModelException r4 = new freemarker.core._TemplateModelException
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r5 = "ClassCastException while getting Map entry with String key "
            r0[r1] = r5
            freemarker.core.gc r1 = new freemarker.core.gc
            r1.<init>(r8)
            r0[r2] = r1
            r4.<init>(r3, r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: freemarker.template.SimpleHash.get(java.lang.String):freemarker.template.E");
    }

    @Override // freemarker.template.A
    public boolean isEmpty() {
        Map map = this.map;
        return map == null || map.isEmpty();
    }

    @Override // freemarker.template.B
    public s keys() {
        return new SimpleCollection(this.map.keySet(), getObjectWrapper());
    }

    public void put(String str, Object obj) {
        this.map.put(str, obj);
        this.unwrappedMap = null;
    }

    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put((String) entry.getKey(), entry.getValue());
        }
    }

    public void remove(String str) {
        this.map.remove(str);
    }

    @Override // freemarker.template.B
    public int size() {
        return this.map.size();
    }

    public SimpleHash synchronizedWrapper() {
        return new SynchronizedHash();
    }

    public Map toMap() throws Throwable {
        if (this.unwrappedMap == null) {
            Class<?> cls = this.map.getClass();
            try {
                Map map = (Map) cls.newInstance();
                C2867m c2867mD = C2867m.d();
                for (Map.Entry entry : this.map.entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof E) {
                        value = c2867mD.a((E) value);
                    }
                    map.put(key, value);
                }
                this.unwrappedMap = map;
            } catch (Exception e2) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Error instantiating map of type ");
                stringBuffer.append(cls.getName());
                stringBuffer.append(UMCustomLogInfoBuilder.LINE_SEP);
                stringBuffer.append(e2.getMessage());
                throw new TemplateModelException(stringBuffer.toString());
            }
        }
        return this.unwrappedMap;
    }

    public String toString() {
        return this.map.toString();
    }

    public s values() {
        return new SimpleCollection(this.map.values(), getObjectWrapper());
    }

    public SimpleHash(Map map) {
        this(map, null);
    }

    public SimpleHash(InterfaceC2891l interfaceC2891l) {
        super(interfaceC2891l);
        this.map = new HashMap();
    }

    public void put(String str, boolean z) {
        put(str, z ? r.f21735d : r.f21734c);
    }

    public SimpleHash(Map map, InterfaceC2891l interfaceC2891l) {
        Map mapCopyMap;
        super(interfaceC2891l);
        try {
            mapCopyMap = copyMap(map);
        } catch (ConcurrentModificationException unused) {
            try {
                Thread.sleep(5L);
            } catch (InterruptedException unused2) {
            }
            synchronized (map) {
                mapCopyMap = copyMap(map);
            }
        }
        this.map = mapCopyMap;
    }
}
