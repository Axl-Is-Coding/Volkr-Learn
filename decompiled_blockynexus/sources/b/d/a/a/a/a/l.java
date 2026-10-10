package b.d.a.a.a.a;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: ObjectDescriptorFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static Logger f2516a = Logger.getLogger(l.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static Map<Integer, Map<Integer, Class<? extends b>>> f2517b = new HashMap();

    static {
        HashSet<Class<? extends b>> hashSet = new HashSet();
        hashSet.add(f.class);
        hashSet.add(n.class);
        hashSet.add(b.class);
        hashSet.add(i.class);
        hashSet.add(k.class);
        hashSet.add(m.class);
        hashSet.add(a.class);
        hashSet.add(j.class);
        hashSet.add(h.class);
        hashSet.add(e.class);
        for (Class<? extends b> cls : hashSet) {
            g gVar = (g) cls.getAnnotation(g.class);
            int[] iArrTags = gVar.tags();
            int iObjectTypeIndication = gVar.objectTypeIndication();
            Map<Integer, Class<? extends b>> map = f2517b.get(Integer.valueOf(iObjectTypeIndication));
            if (map == null) {
                map = new HashMap<>();
            }
            for (int i : iArrTags) {
                map.put(Integer.valueOf(i), cls);
            }
            f2517b.put(Integer.valueOf(iObjectTypeIndication), map);
        }
    }

    public static b a(int i, ByteBuffer byteBuffer) throws IOException {
        b oVar;
        int iJ = b.b.a.d.j(byteBuffer);
        Map<Integer, Class<? extends b>> map = f2517b.get(Integer.valueOf(i));
        if (map == null) {
            map = f2517b.get(-1);
        }
        Class<? extends b> cls = map.get(Integer.valueOf(iJ));
        if (cls == null || cls.isInterface() || Modifier.isAbstract(cls.getModifiers())) {
            f2516a.warning("No ObjectDescriptor found for objectTypeIndication " + Integer.toHexString(i) + " and tag " + Integer.toHexString(iJ) + " found: " + cls);
            oVar = new o();
        } else {
            try {
                oVar = cls.newInstance();
            } catch (Exception e2) {
                f2516a.log(Level.SEVERE, "Couldn't instantiate BaseDescriptor class " + cls + " for objectTypeIndication " + i + " and tag " + iJ, (Throwable) e2);
                throw new RuntimeException(e2);
            }
        }
        oVar.a(iJ, byteBuffer);
        return oVar;
    }
}
