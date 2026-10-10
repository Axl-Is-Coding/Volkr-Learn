package freemarker.ext.beans;

import java.util.Map;

/* JADX INFO: compiled from: HashAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
class F implements Map.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Object f21540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ G f21541b;

    F(G g, Object obj) {
        this.f21541b = g;
        this.f21540a = obj;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = getKey();
        Object key2 = entry.getKey();
        if (key == key2 || (key != null && key.equals(key2))) {
            Object value = getValue();
            Object value2 = entry.getValue();
            if (value == value2) {
                return true;
            }
            if (value != null && value.equals(value2)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public Object getKey() {
        return this.f21540a;
    }

    @Override // java.util.Map.Entry
    public Object getValue() {
        return this.f21541b.f21543b.f21544a.get(this.f21540a);
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        Object value = getValue();
        Object obj = this.f21540a;
        return (obj == null ? 0 : obj.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
