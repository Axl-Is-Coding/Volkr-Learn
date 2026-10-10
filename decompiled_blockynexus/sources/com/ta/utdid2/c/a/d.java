package com.ta.utdid2.c.a;

import com.ta.utdid2.c.a.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: TransactionXMLFile.java */
/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f19362c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f19363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f19364b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private HashMap<File, a> f113a = new HashMap<>();

    /* JADX INFO: compiled from: TransactionXMLFile.java */
    private static final class a implements b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Object f19365d = new Object();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakHashMap<b.InterfaceC0169b, Object> f19366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final File f19367b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f19368c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private final File f114c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private Map f115c;
        private boolean k = false;

        a(File file, int i, Map map) {
            this.f19367b = file;
            this.f114c = d.a(file);
            this.f19368c = i;
            this.f115c = map == null ? new HashMap() : map;
            this.f19366a = new WeakHashMap<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d() {
            if (this.f19367b.exists()) {
                if (this.f114c.exists()) {
                    this.f19367b.delete();
                } else if (!this.f19367b.renameTo(this.f114c)) {
                    return false;
                }
            }
            try {
                FileOutputStream fileOutputStreamA = a(this.f19367b);
                if (fileOutputStreamA == null) {
                    return false;
                }
                e.a(this.f115c, fileOutputStreamA);
                fileOutputStreamA.close();
                this.f114c.delete();
                return true;
            } catch (IOException | XmlPullParserException unused) {
                if (this.f19367b.exists()) {
                    this.f19367b.delete();
                }
                return false;
            }
        }

        public boolean c() {
            boolean z;
            synchronized (this) {
                z = this.k;
            }
            return z;
        }

        @Override // com.ta.utdid2.c.a.b
        public Map<String, ?> getAll() {
            HashMap map;
            synchronized (this) {
                map = new HashMap(this.f115c);
            }
            return map;
        }

        @Override // com.ta.utdid2.c.a.b
        public long getLong(String str, long j) {
            synchronized (this) {
                Long l = (Long) this.f115c.get(str);
                if (l != null) {
                    j = l.longValue();
                }
            }
            return j;
        }

        @Override // com.ta.utdid2.c.a.b
        public String getString(String str, String str2) {
            String str3;
            synchronized (this) {
                str3 = (String) this.f115c.get(str);
                if (str3 == null) {
                    str3 = str2;
                }
            }
            return str3;
        }

        @Override // com.ta.utdid2.c.a.b
        /* JADX INFO: renamed from: a */
        public boolean mo96a() {
            File file = this.f19367b;
            return file != null && new File(file.getAbsolutePath()).exists();
        }

        /* JADX INFO: renamed from: com.ta.utdid2.c.a.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TransactionXMLFile.java */
        public final class C0170a implements b.a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final Map<String, Object> f19370d = new HashMap();
            private boolean l = false;

            public C0170a() {
            }

            @Override // com.ta.utdid2.c.a.b.a
            public b.a a(String str, String str2) {
                synchronized (this) {
                    this.f19370d.put(str, str2);
                }
                return this;
            }

            @Override // com.ta.utdid2.c.a.b.a
            public b.a b() {
                synchronized (this) {
                    this.l = true;
                }
                return this;
            }

            @Override // com.ta.utdid2.c.a.b.a
            public boolean commit() {
                boolean z;
                ArrayList arrayList;
                HashSet<b.InterfaceC0169b> hashSet;
                boolean zD;
                synchronized (d.f19362c) {
                    z = a.this.f19366a.size() > 0;
                    arrayList = null;
                    if (z) {
                        arrayList = new ArrayList();
                        hashSet = new HashSet(a.this.f19366a.keySet());
                    } else {
                        hashSet = null;
                    }
                    synchronized (this) {
                        if (this.l) {
                            a.this.f115c.clear();
                            this.l = false;
                        }
                        for (Map.Entry<String, Object> entry : this.f19370d.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            if (value == this) {
                                a.this.f115c.remove(key);
                            } else {
                                a.this.f115c.put(key, value);
                            }
                            if (z) {
                                arrayList.add(key);
                            }
                        }
                        this.f19370d.clear();
                    }
                    zD = a.this.d();
                    if (zD) {
                        a.this.a(true);
                    }
                }
                if (z) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        String str = (String) arrayList.get(size);
                        for (b.InterfaceC0169b interfaceC0169b : hashSet) {
                            if (interfaceC0169b != null) {
                                interfaceC0169b.a(a.this, str);
                            }
                        }
                    }
                }
                return zD;
            }

            @Override // com.ta.utdid2.c.a.b.a
            public b.a a(String str, int i) {
                synchronized (this) {
                    this.f19370d.put(str, Integer.valueOf(i));
                }
                return this;
            }

            @Override // com.ta.utdid2.c.a.b.a
            public b.a a(String str, long j) {
                synchronized (this) {
                    this.f19370d.put(str, Long.valueOf(j));
                }
                return this;
            }

            @Override // com.ta.utdid2.c.a.b.a
            public b.a a(String str, float f2) {
                synchronized (this) {
                    this.f19370d.put(str, Float.valueOf(f2));
                }
                return this;
            }

            @Override // com.ta.utdid2.c.a.b.a
            public b.a a(String str, boolean z) {
                synchronized (this) {
                    this.f19370d.put(str, Boolean.valueOf(z));
                }
                return this;
            }

            @Override // com.ta.utdid2.c.a.b.a
            public b.a a(String str) {
                synchronized (this) {
                    this.f19370d.put(str, this);
                }
                return this;
            }
        }

        public void a(boolean z) {
            synchronized (this) {
                this.k = z;
            }
        }

        public void a(Map map) {
            if (map != null) {
                synchronized (this) {
                    this.f115c = map;
                }
            }
        }

        @Override // com.ta.utdid2.c.a.b
        public b.a a() {
            return new C0170a();
        }

        private FileOutputStream a(File file) {
            try {
                return new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    return new FileOutputStream(file);
                } catch (FileNotFoundException unused2) {
                    return null;
                }
            }
        }
    }

    public d(String str) {
        if (str == null || str.length() <= 0) {
            throw new RuntimeException("Directory can not be empty");
        }
        this.f19363a = new File(str);
    }

    private File b(String str) {
        return a(a(), String.valueOf(str) + ".xml");
    }

    private File a(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    private File a() {
        File file;
        synchronized (this.f19364b) {
            file = this.f19363a;
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x006e A[EXC_TOP_SPLITTER, PHI: r0 r2
      0x006e: PHI (r0v22 java.util.HashMap) = (r0v11 java.util.HashMap), (r0v21 java.util.HashMap), (r0v23 java.util.HashMap) binds: [B:38:0x006c, B:45:0x007a, B:49:0x0080] A[DONT_GENERATE, DONT_INLINE]
      0x006e: PHI (r2v13 java.io.FileInputStream) = (r2v6 java.io.FileInputStream), (r2v12 java.io.FileInputStream), (r2v14 java.io.FileInputStream) binds: [B:38:0x006c, B:45:0x007a, B:49:0x0080] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c1 A[Catch: Throwable -> 0x00d3, TRY_ENTER, TRY_LEAVE, TryCatch #16 {Throwable -> 0x00d3, blocks: (B:23:0x004c, B:76:0x00c1), top: B:109:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00d3 A[PHI: r2
      0x00d3: PHI (r2v2 java.util.HashMap) = 
      (r2v28 java.util.HashMap)
      (r2v4 java.util.HashMap)
      (r2v1 java.util.HashMap)
      (r2v7 java.util.HashMap)
      (r2v15 java.util.HashMap)
     binds: [B:18:0x0038, B:108:0x00d3, B:20:0x003e, B:75:0x00bf, B:117:0x00d3] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.ta.utdid2.c.a.b a(java.lang.String r10, int r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.c.a.d.a(java.lang.String, int):com.ta.utdid2.c.a.b");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File a(File file) {
        return new File(String.valueOf(file.getPath()) + ".bak");
    }
}
