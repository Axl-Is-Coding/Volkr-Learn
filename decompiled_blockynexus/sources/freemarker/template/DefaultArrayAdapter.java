package freemarker.template;

import java.io.Serializable;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DefaultArrayAdapter extends M implements freemarker.ext.util.f, L, InterfaceC2880a, Serializable {

    private static class BooleanArrayAdapter extends DefaultArrayAdapter {
        private final boolean[] array;

        @Override // freemarker.template.L
        public E get(int i) throws TemplateModelException {
            if (i >= 0) {
                boolean[] zArr = this.array;
                if (i < zArr.length) {
                    return wrap(new Boolean(zArr[i]));
                }
            }
            return null;
        }

        @Override // freemarker.ext.util.f
        public Object getWrappedObject() {
            return this.array;
        }

        @Override // freemarker.template.L
        public int size() throws TemplateModelException {
            return this.array.length;
        }

        private BooleanArrayAdapter(boolean[] zArr, InterfaceC2891l interfaceC2891l) {
            super(interfaceC2891l);
            this.array = zArr;
        }
    }

    private static class ByteArrayAdapter extends DefaultArrayAdapter {
        private final byte[] array;

        @Override // freemarker.template.L
        public E get(int i) throws TemplateModelException {
            if (i >= 0) {
                byte[] bArr = this.array;
                if (i < bArr.length) {
                    return wrap(new Byte(bArr[i]));
                }
            }
            return null;
        }

        @Override // freemarker.ext.util.f
        public Object getWrappedObject() {
            return this.array;
        }

        @Override // freemarker.template.L
        public int size() throws TemplateModelException {
            return this.array.length;
        }

        private ByteArrayAdapter(byte[] bArr, InterfaceC2891l interfaceC2891l) {
            super(interfaceC2891l);
            this.array = bArr;
        }
    }

    private static class CharArrayAdapter extends DefaultArrayAdapter {
        private final char[] array;

        @Override // freemarker.template.L
        public E get(int i) throws TemplateModelException {
            if (i >= 0) {
                char[] cArr = this.array;
                if (i < cArr.length) {
                    return wrap(new Character(cArr[i]));
                }
            }
            return null;
        }

        @Override // freemarker.ext.util.f
        public Object getWrappedObject() {
            return this.array;
        }

        @Override // freemarker.template.L
        public int size() throws TemplateModelException {
            return this.array.length;
        }

        private CharArrayAdapter(char[] cArr, InterfaceC2891l interfaceC2891l) {
            super(interfaceC2891l);
            this.array = cArr;
        }
    }

    private static class DoubleArrayAdapter extends DefaultArrayAdapter {
        private final double[] array;

        @Override // freemarker.template.L
        public E get(int i) throws TemplateModelException {
            if (i >= 0) {
                double[] dArr = this.array;
                if (i < dArr.length) {
                    return wrap(new Double(dArr[i]));
                }
            }
            return null;
        }

        @Override // freemarker.ext.util.f
        public Object getWrappedObject() {
            return this.array;
        }

        @Override // freemarker.template.L
        public int size() throws TemplateModelException {
            return this.array.length;
        }

        private DoubleArrayAdapter(double[] dArr, InterfaceC2891l interfaceC2891l) {
            super(interfaceC2891l);
            this.array = dArr;
        }
    }

    private static class FloatArrayAdapter extends DefaultArrayAdapter {
        private final float[] array;

        @Override // freemarker.template.L
        public E get(int i) throws TemplateModelException {
            if (i >= 0) {
                float[] fArr = this.array;
                if (i < fArr.length) {
                    return wrap(new Float(fArr[i]));
                }
            }
            return null;
        }

        @Override // freemarker.ext.util.f
        public Object getWrappedObject() {
            return this.array;
        }

        @Override // freemarker.template.L
        public int size() throws TemplateModelException {
            return this.array.length;
        }

        private FloatArrayAdapter(float[] fArr, InterfaceC2891l interfaceC2891l) {
            super(interfaceC2891l);
            this.array = fArr;
        }
    }

    private static class GenericPrimitiveArrayAdapter extends DefaultArrayAdapter {
        private final Object array;
        private final int length;

        @Override // freemarker.template.L
        public E get(int i) throws TemplateModelException {
            if (i < 0 || i >= this.length) {
                return null;
            }
            return wrap(Array.get(this.array, i));
        }

        @Override // freemarker.ext.util.f
        public Object getWrappedObject() {
            return this.array;
        }

        @Override // freemarker.template.L
        public int size() throws TemplateModelException {
            return this.length;
        }

        private GenericPrimitiveArrayAdapter(Object obj, InterfaceC2891l interfaceC2891l) {
            super(interfaceC2891l);
            this.array = obj;
            this.length = Array.getLength(obj);
        }
    }

    private static class IntArrayAdapter extends DefaultArrayAdapter {
        private final int[] array;

        @Override // freemarker.template.L
        public E get(int i) throws TemplateModelException {
            if (i >= 0) {
                int[] iArr = this.array;
                if (i < iArr.length) {
                    return wrap(new Integer(iArr[i]));
                }
            }
            return null;
        }

        @Override // freemarker.ext.util.f
        public Object getWrappedObject() {
            return this.array;
        }

        @Override // freemarker.template.L
        public int size() throws TemplateModelException {
            return this.array.length;
        }

        private IntArrayAdapter(int[] iArr, InterfaceC2891l interfaceC2891l) {
            super(interfaceC2891l);
            this.array = iArr;
        }
    }

    private static class LongArrayAdapter extends DefaultArrayAdapter {
        private final long[] array;

        @Override // freemarker.template.L
        public E get(int i) throws TemplateModelException {
            if (i >= 0) {
                long[] jArr = this.array;
                if (i < jArr.length) {
                    return wrap(new Long(jArr[i]));
                }
            }
            return null;
        }

        @Override // freemarker.ext.util.f
        public Object getWrappedObject() {
            return this.array;
        }

        @Override // freemarker.template.L
        public int size() throws TemplateModelException {
            return this.array.length;
        }

        private LongArrayAdapter(long[] jArr, InterfaceC2891l interfaceC2891l) {
            super(interfaceC2891l);
            this.array = jArr;
        }
    }

    private static class ObjectArrayAdapter extends DefaultArrayAdapter {
        private final Object[] array;

        @Override // freemarker.template.L
        public E get(int i) throws TemplateModelException {
            if (i >= 0) {
                Object[] objArr = this.array;
                if (i < objArr.length) {
                    return wrap(objArr[i]);
                }
            }
            return null;
        }

        @Override // freemarker.ext.util.f
        public Object getWrappedObject() {
            return this.array;
        }

        @Override // freemarker.template.L
        public int size() throws TemplateModelException {
            return this.array.length;
        }

        private ObjectArrayAdapter(Object[] objArr, InterfaceC2891l interfaceC2891l) {
            super(interfaceC2891l);
            this.array = objArr;
        }
    }

    private static class ShortArrayAdapter extends DefaultArrayAdapter {
        private final short[] array;

        @Override // freemarker.template.L
        public E get(int i) throws TemplateModelException {
            if (i >= 0) {
                short[] sArr = this.array;
                if (i < sArr.length) {
                    return wrap(new Short(sArr[i]));
                }
            }
            return null;
        }

        @Override // freemarker.ext.util.f
        public Object getWrappedObject() {
            return this.array;
        }

        @Override // freemarker.template.L
        public int size() throws TemplateModelException {
            return this.array.length;
        }

        private ShortArrayAdapter(short[] sArr, InterfaceC2891l interfaceC2891l) {
            super(interfaceC2891l);
            this.array = sArr;
        }
    }

    public static DefaultArrayAdapter adapt(Object obj, InterfaceC2892m interfaceC2892m) {
        Class<?> componentType = obj.getClass().getComponentType();
        if (componentType == null) {
            throw new IllegalArgumentException("Not an array");
        }
        return componentType.isPrimitive() ? componentType == Integer.TYPE ? new IntArrayAdapter((int[]) obj, interfaceC2892m) : componentType == Double.TYPE ? new DoubleArrayAdapter((double[]) obj, interfaceC2892m) : componentType == Long.TYPE ? new LongArrayAdapter((long[]) obj, interfaceC2892m) : componentType == Boolean.TYPE ? new BooleanArrayAdapter((boolean[]) obj, interfaceC2892m) : componentType == Float.TYPE ? new FloatArrayAdapter((float[]) obj, interfaceC2892m) : componentType == Character.TYPE ? new CharArrayAdapter((char[]) obj, interfaceC2892m) : componentType == Short.TYPE ? new ShortArrayAdapter((short[]) obj, interfaceC2892m) : componentType == Byte.TYPE ? new ByteArrayAdapter((byte[]) obj, interfaceC2892m) : new GenericPrimitiveArrayAdapter(obj, interfaceC2892m) : new ObjectArrayAdapter((Object[]) obj, interfaceC2892m);
    }

    @Override // freemarker.template.InterfaceC2880a
    public final Object getAdaptedObject(Class cls) {
        return getWrappedObject();
    }

    private DefaultArrayAdapter(InterfaceC2891l interfaceC2891l) {
        super(interfaceC2891l);
    }
}
