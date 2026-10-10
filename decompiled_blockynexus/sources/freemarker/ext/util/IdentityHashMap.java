package freemarker.ext.util;

import cn.qqtheme.framework.widget.WheelView;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class IdentityHashMap extends AbstractMap implements Serializable, Cloneable, Map {
    private static final int ENTRIES = 2;
    private static final int KEYS = 0;
    private static final int VALUES = 1;
    private static a emptyHashIterator = new a();
    public static final long serialVersionUID = 362498820763181265L;
    private transient int count;
    private transient Set entrySet;
    private transient Set keySet;
    private float loadFactor;
    private transient int modCount;
    private transient b[] table;
    private int threshold;
    private transient Collection values;

    private static class a implements Iterator {
        a() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21691c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        b f21692d;

        b(int i, Object obj, Object obj2, b bVar) {
            this.f21689a = i;
            this.f21690b = obj;
            this.f21691c = obj2;
            this.f21692d = bVar;
        }

        protected Object clone() {
            int i = this.f21689a;
            Object obj = this.f21690b;
            Object obj2 = this.f21691c;
            b bVar = this.f21692d;
            return new b(i, obj, obj2, bVar == null ? null : (b) bVar.clone());
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (this.f21690b != entry.getKey()) {
                return false;
            }
            Object obj2 = this.f21691c;
            if (obj2 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!obj2.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f21690b;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f21691c;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int i = this.f21689a;
            Object obj = this.f21691c;
            return i ^ (obj == null ? 0 : obj.hashCode());
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.f21691c;
            this.f21691c = obj;
            return obj2;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f21690b);
            stringBuffer.append("=");
            stringBuffer.append(this.f21691c);
            return stringBuffer.toString();
        }
    }

    private class c implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        b[] f21693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f21694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        b f21695c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        b f21696d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f21697e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f21698f;

        c(int i) {
            this.f21693a = IdentityHashMap.this.table;
            this.f21694b = this.f21693a.length;
            this.f21698f = IdentityHashMap.this.modCount;
            this.f21697e = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            b bVar = this.f21695c;
            int i = this.f21694b;
            b[] bVarArr = this.f21693a;
            while (bVar == null && i > 0) {
                i--;
                bVar = bVarArr[i];
            }
            this.f21695c = bVar;
            this.f21694b = i;
            return bVar != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (IdentityHashMap.this.modCount != this.f21698f) {
                throw new ConcurrentModificationException();
            }
            b bVar = this.f21695c;
            int i = this.f21694b;
            b[] bVarArr = this.f21693a;
            while (bVar == null && i > 0) {
                i--;
                bVar = bVarArr[i];
            }
            this.f21695c = bVar;
            this.f21694b = i;
            if (bVar == null) {
                throw new NoSuchElementException();
            }
            b bVar2 = this.f21695c;
            this.f21696d = bVar2;
            this.f21695c = bVar2.f21692d;
            int i2 = this.f21697e;
            return i2 == 0 ? bVar2.f21690b : i2 == 1 ? bVar2.f21691c : bVar2;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f21696d == null) {
                throw new IllegalStateException();
            }
            if (IdentityHashMap.this.modCount != this.f21698f) {
                throw new ConcurrentModificationException();
            }
            b[] bVarArr = IdentityHashMap.this.table;
            int length = (this.f21696d.f21689a & Integer.MAX_VALUE) % bVarArr.length;
            b bVar = null;
            for (b bVar2 = bVarArr[length]; bVar2 != null; bVar2 = bVar2.f21692d) {
                if (bVar2 == this.f21696d) {
                    IdentityHashMap.access$308(IdentityHashMap.this);
                    this.f21698f++;
                    if (bVar == null) {
                        bVarArr[length] = bVar2.f21692d;
                    } else {
                        bVar.f21692d = bVar2.f21692d;
                    }
                    IdentityHashMap.access$110(IdentityHashMap.this);
                    this.f21696d = null;
                    return;
                }
                bVar = bVar2;
            }
            throw new ConcurrentModificationException();
        }
    }

    public IdentityHashMap(int i, float f2) {
        this.modCount = 0;
        this.keySet = null;
        this.entrySet = null;
        this.values = null;
        if (i < 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Illegal Initial Capacity: ");
            stringBuffer.append(i);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        if (f2 <= WheelView.DividerConfig.FILL || Float.isNaN(f2)) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Illegal Load factor: ");
            stringBuffer2.append(f2);
            throw new IllegalArgumentException(stringBuffer2.toString());
        }
        i = i == 0 ? 1 : i;
        this.loadFactor = f2;
        this.table = new b[i];
        this.threshold = (int) (i * f2);
    }

    static /* synthetic */ int access$110(IdentityHashMap identityHashMap) {
        int i = identityHashMap.count;
        identityHashMap.count = i - 1;
        return i;
    }

    static /* synthetic */ int access$308(IdentityHashMap identityHashMap) {
        int i = identityHashMap.modCount;
        identityHashMap.modCount = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Iterator getHashIterator(int i) {
        return this.count == 0 ? emptyHashIterator : new c(i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.table = new b[objectInputStream.readInt()];
        int i = objectInputStream.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void rehash() {
        b[] bVarArr = this.table;
        int length = bVarArr.length;
        int i = (length * 2) + 1;
        b[] bVarArr2 = new b[i];
        this.modCount++;
        this.threshold = (int) (i * this.loadFactor);
        this.table = bVarArr2;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            b bVar = bVarArr[i2];
            while (bVar != null) {
                b bVar2 = bVar.f21692d;
                int i3 = (bVar.f21689a & Integer.MAX_VALUE) % i;
                bVar.f21692d = bVarArr2[i3];
                bVarArr2[i3] = bVar;
                bVar = bVar2;
            }
            length = i2;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.table.length);
        objectOutputStream.writeInt(this.count);
        for (int length = this.table.length - 1; length >= 0; length--) {
            for (b bVar = this.table[length]; bVar != null; bVar = bVar.f21692d) {
                objectOutputStream.writeObject(bVar.f21690b);
                objectOutputStream.writeObject(bVar.f21691c);
            }
        }
    }

    int capacity() {
        return this.table.length;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        b[] bVarArr = this.table;
        this.modCount++;
        int length = bVarArr.length;
        while (true) {
            length--;
            if (length < 0) {
                this.count = 0;
                return;
            }
            bVarArr[length] = null;
        }
    }

    @Override // java.util.AbstractMap
    public Object clone() {
        try {
            IdentityHashMap identityHashMap = (IdentityHashMap) super.clone();
            identityHashMap.table = new b[this.table.length];
            int length = this.table.length;
            while (true) {
                int i = length - 1;
                b bVar = null;
                if (length <= 0) {
                    identityHashMap.keySet = null;
                    identityHashMap.entrySet = null;
                    identityHashMap.values = null;
                    identityHashMap.modCount = 0;
                    return identityHashMap;
                }
                b[] bVarArr = identityHashMap.table;
                if (this.table[i] != null) {
                    bVar = (b) this.table[i].clone();
                }
                bVarArr[i] = bVar;
                length = i;
            }
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        b[] bVarArr = this.table;
        if (obj != null) {
            int iIdentityHashCode = System.identityHashCode(obj);
            for (b bVar = bVarArr[(Integer.MAX_VALUE & iIdentityHashCode) % bVarArr.length]; bVar != null; bVar = bVar.f21692d) {
                if (bVar.f21689a == iIdentityHashCode && obj == bVar.f21690b) {
                    return true;
                }
            }
        } else {
            for (b bVar2 = bVarArr[0]; bVar2 != null; bVar2 = bVar2.f21692d) {
                if (bVar2.f21690b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        b[] bVarArr = this.table;
        if (obj == null) {
            int length = bVarArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                for (b bVar = bVarArr[i]; bVar != null; bVar = bVar.f21692d) {
                    if (bVar.f21691c == null) {
                        return true;
                    }
                }
                length = i;
            }
        } else {
            int length2 = bVarArr.length;
            while (true) {
                int i2 = length2 - 1;
                if (length2 <= 0) {
                    return false;
                }
                for (b bVar2 = bVarArr[i2]; bVar2 != null; bVar2 = bVar2.f21692d) {
                    if (obj.equals(bVar2.f21691c)) {
                        return true;
                    }
                }
                length2 = i2;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new freemarker.ext.util.c(this);
        }
        return this.entrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        b[] bVarArr = this.table;
        if (obj == null) {
            for (b bVar = bVarArr[0]; bVar != null; bVar = bVar.f21692d) {
                if (bVar.f21690b == null) {
                    return bVar.f21691c;
                }
            }
            return null;
        }
        int iIdentityHashCode = System.identityHashCode(obj);
        for (b bVar2 = bVarArr[(Integer.MAX_VALUE & iIdentityHashCode) % bVarArr.length]; bVar2 != null; bVar2 = bVar2.f21692d) {
            if (bVar2.f21689a == iIdentityHashCode && obj == bVar2.f21690b) {
                return bVar2.f21691c;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new freemarker.ext.util.a(this);
        }
        return this.keySet;
    }

    float loadFactor() {
        return this.loadFactor;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        int length;
        b[] bVarArr = this.table;
        int iIdentityHashCode = 0;
        if (obj != null) {
            iIdentityHashCode = System.identityHashCode(obj);
            length = (iIdentityHashCode & Integer.MAX_VALUE) % bVarArr.length;
            for (b bVar = bVarArr[length]; bVar != null; bVar = bVar.f21692d) {
                if (bVar.f21689a == iIdentityHashCode && obj == bVar.f21690b) {
                    Object obj3 = bVar.f21691c;
                    bVar.f21691c = obj2;
                    return obj3;
                }
            }
        } else {
            for (b bVar2 = bVarArr[0]; bVar2 != null; bVar2 = bVar2.f21692d) {
                if (bVar2.f21690b == null) {
                    Object obj4 = bVar2.f21691c;
                    bVar2.f21691c = obj2;
                    return obj4;
                }
            }
            length = 0;
        }
        this.modCount++;
        if (this.count >= this.threshold) {
            rehash();
            bVarArr = this.table;
            length = (Integer.MAX_VALUE & iIdentityHashCode) % bVarArr.length;
        }
        bVarArr[length] = new b(iIdentityHashCode, obj, obj2, bVarArr[length]);
        this.count++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        b[] bVarArr = this.table;
        if (obj != null) {
            int iIdentityHashCode = System.identityHashCode(obj);
            int length = (Integer.MAX_VALUE & iIdentityHashCode) % bVarArr.length;
            b bVar = null;
            for (b bVar2 = bVarArr[length]; bVar2 != null; bVar2 = bVar2.f21692d) {
                if (bVar2.f21689a == iIdentityHashCode && obj == bVar2.f21690b) {
                    this.modCount++;
                    if (bVar != null) {
                        bVar.f21692d = bVar2.f21692d;
                    } else {
                        bVarArr[length] = bVar2.f21692d;
                    }
                    this.count--;
                    Object obj2 = bVar2.f21691c;
                    bVar2.f21691c = null;
                    return obj2;
                }
                bVar = bVar2;
            }
        } else {
            b bVar3 = null;
            for (b bVar4 = bVarArr[0]; bVar4 != null; bVar4 = bVar4.f21692d) {
                if (bVar4.f21690b == null) {
                    this.modCount++;
                    if (bVar3 != null) {
                        bVar3.f21692d = bVar4.f21692d;
                    } else {
                        bVarArr[0] = bVar4.f21692d;
                    }
                    this.count--;
                    Object obj3 = bVar4.f21691c;
                    bVar4.f21691c = null;
                    return obj3;
                }
                bVar3 = bVar4;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.count;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        if (this.values == null) {
            this.values = new freemarker.ext.util.b(this);
        }
        return this.values;
    }

    public IdentityHashMap(int i) {
        this(i, 0.75f);
    }

    public IdentityHashMap() {
        this(11, 0.75f);
    }

    public IdentityHashMap(Map map) {
        this(Math.max(map.size() * 2, 11), 0.75f);
        putAll(map);
    }
}
