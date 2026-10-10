package freemarker.ext.beans;

import freemarker.core.BugException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: _BeansAPI.java */
/* JADX INFO: loaded from: classes5.dex */
public class ua {

    /* JADX INFO: compiled from: _BeansAPI.java */
    public interface a {
        C2867m a(AbstractC2868n abstractC2868n);
    }

    public static C2867m a(AbstractC2868n abstractC2868n, Map map, ReferenceQueue referenceQueue, a aVar) {
        Map map2;
        Reference reference;
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        synchronized (map) {
            map2 = (Map) map.get(contextClassLoader);
            if (map2 == null) {
                map2 = new HashMap();
                map.put(contextClassLoader, map2);
                reference = null;
            } else {
                reference = (Reference) map2.get(abstractC2868n);
            }
        }
        C2867m c2867m = reference != null ? (C2867m) reference.get() : null;
        if (c2867m != null) {
            return c2867m;
        }
        AbstractC2868n abstractC2868n2 = (AbstractC2868n) abstractC2868n.a(true);
        C2867m c2867mA = aVar.a(abstractC2868n2);
        if (!c2867mA.l()) {
            throw new BugException();
        }
        synchronized (map) {
            Reference reference2 = (Reference) map2.get(abstractC2868n2);
            C2867m c2867m2 = reference2 != null ? (C2867m) reference2.get() : null;
            if (c2867m2 == null) {
                map2.put(abstractC2868n2, new WeakReference(c2867mA, referenceQueue));
            } else {
                c2867mA = c2867m2;
            }
        }
        a(map, referenceQueue);
        return c2867mA;
    }

    private static void a(Map map, ReferenceQueue referenceQueue) {
        while (true) {
            Reference referencePoll = referenceQueue.poll();
            if (referencePoll == null) {
                return;
            }
            synchronized (map) {
                Iterator it = map.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Iterator it2 = ((Map) it.next()).values().iterator();
                    while (it2.hasNext()) {
                        if (it2.next() == referencePoll) {
                            it2.remove();
                            break;
                        }
                    }
                }
            }
        }
    }
}
