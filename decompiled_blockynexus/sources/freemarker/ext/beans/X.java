package freemarker.ext.beans;

import freemarker.core.ec;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: OverloadedMethods.java */
/* JADX INFO: loaded from: classes5.dex */
class X extends ec {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ aa f21558d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    X(aa aaVar, Object obj) {
        super(obj);
        this.f21558d = aaVar;
    }

    @Override // freemarker.core.ec
    protected String a(Object obj) {
        Iterator itA = this.f21558d.f21561a.a();
        Iterator itA2 = this.f21558d.f21562b != null ? this.f21558d.f21562b.a() : null;
        if (!(itA.hasNext() || (itA2 != null && itA2.hasNext()))) {
            return "No members";
        }
        StringBuffer stringBuffer = new StringBuffer();
        HashSet hashSet = new HashSet();
        while (itA.hasNext()) {
            if (stringBuffer.length() != 0) {
                stringBuffer.append(",\n");
            }
            stringBuffer.append("    ");
            AbstractC2871q abstractC2871q = (AbstractC2871q) itA.next();
            hashSet.add(abstractC2871q);
            stringBuffer.append(abstractC2871q.a());
        }
        if (itA2 != null) {
            while (itA2.hasNext()) {
                AbstractC2871q abstractC2871q2 = (AbstractC2871q) itA2.next();
                if (!hashSet.contains(abstractC2871q2)) {
                    if (stringBuffer.length() != 0) {
                        stringBuffer.append(",\n");
                    }
                    stringBuffer.append("    ");
                    stringBuffer.append(abstractC2871q2.a());
                }
            }
        }
        return stringBuffer.toString();
    }
}
