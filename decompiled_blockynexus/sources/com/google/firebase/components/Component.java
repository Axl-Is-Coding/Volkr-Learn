package com.google.firebase.components;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class Component<T> {
    private final Set<Dependency> dependencies;
    private final ComponentFactory<T> factory;
    private final int instantiation;
    private final Set<Class<? super T>> providedInterfaces;
    private final Set<Class<?>> publishedEvents;
    private final int type;

    public static class Builder<T> {
        private final Set<Dependency> dependencies;
        private ComponentFactory<T> factory;
        private int instantiation;
        private final Set<Class<? super T>> providedInterfaces;
        private Set<Class<?>> publishedEvents;
        private int type;

        static /* synthetic */ Builder access$100(Builder builder) {
            builder.intoSet();
            return builder;
        }

        private Builder<T> intoSet() {
            this.type = 1;
            return this;
        }

        private Builder<T> setInstantiation(int i) {
            Preconditions.checkState(this.instantiation == 0, "Instantiation type has already been set.");
            this.instantiation = i;
            return this;
        }

        private void validateInterface(Class<?> cls) {
            Preconditions.checkArgument(!this.providedInterfaces.contains(cls), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public Builder<T> add(Dependency dependency) {
            Preconditions.checkNotNull(dependency, "Null dependency");
            validateInterface(dependency.getInterface());
            this.dependencies.add(dependency);
            return this;
        }

        public Builder<T> alwaysEager() {
            setInstantiation(1);
            return this;
        }

        public Component<T> build() {
            Preconditions.checkState(this.factory != null, "Missing required property: factory.");
            return new Component<>(new HashSet(this.providedInterfaces), new HashSet(this.dependencies), this.instantiation, this.type, this.factory, this.publishedEvents);
        }

        public Builder<T> eagerInDefaultApp() {
            setInstantiation(2);
            return this;
        }

        public Builder<T> factory(ComponentFactory<T> componentFactory) {
            Preconditions.checkNotNull(componentFactory, "Null factory");
            this.factory = componentFactory;
            return this;
        }

        public Builder<T> publishes(Class<?> cls) {
            this.publishedEvents.add(cls);
            return this;
        }

        @SafeVarargs
        private Builder(Class<T> cls, Class<? super T>... clsArr) {
            this.providedInterfaces = new HashSet();
            this.dependencies = new HashSet();
            this.instantiation = 0;
            this.type = 0;
            this.publishedEvents = new HashSet();
            Preconditions.checkNotNull(cls, "Null interface");
            this.providedInterfaces.add(cls);
            for (Class<? super T> cls2 : clsArr) {
                Preconditions.checkNotNull(cls2, "Null interface");
            }
            Collections.addAll(this.providedInterfaces, clsArr);
        }
    }

    public static <T> Builder<T> builder(Class<T> cls) {
        return new Builder<>(cls, new Class[0]);
    }

    public static <T> Component<T> intoSet(T t, Class<T> cls) {
        return intoSetBuilder(cls).factory(Component$$Lambda$3.lambdaFactory$(t)).build();
    }

    public static <T> Builder<T> intoSetBuilder(Class<T> cls) {
        Builder<T> builder = builder(cls);
        Builder.access$100(builder);
        return builder;
    }

    static /* synthetic */ Object lambda$intoSet$2(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    static /* synthetic */ Object lambda$of$0(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    static /* synthetic */ Object lambda$of$1(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    @Deprecated
    public static <T> Component<T> of(Class<T> cls, T t) {
        return builder(cls).factory(Component$$Lambda$1.lambdaFactory$(t)).build();
    }

    public Set<Dependency> getDependencies() {
        return this.dependencies;
    }

    public ComponentFactory<T> getFactory() {
        return this.factory;
    }

    public Set<Class<? super T>> getProvidedInterfaces() {
        return this.providedInterfaces;
    }

    public Set<Class<?>> getPublishedEvents() {
        return this.publishedEvents;
    }

    public boolean isAlwaysEager() {
        return this.instantiation == 1;
    }

    public boolean isEagerInDefaultApp() {
        return this.instantiation == 2;
    }

    public boolean isLazy() {
        return this.instantiation == 0;
    }

    public boolean isValue() {
        return this.type == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.providedInterfaces.toArray()) + ">{" + this.instantiation + ", type=" + this.type + ", deps=" + Arrays.toString(this.dependencies.toArray()) + "}";
    }

    private Component(Set<Class<? super T>> set, Set<Dependency> set2, int i, int i2, ComponentFactory<T> componentFactory, Set<Class<?>> set3) {
        this.providedInterfaces = Collections.unmodifiableSet(set);
        this.dependencies = Collections.unmodifiableSet(set2);
        this.instantiation = i;
        this.type = i2;
        this.factory = componentFactory;
        this.publishedEvents = Collections.unmodifiableSet(set3);
    }

    @SafeVarargs
    public static <T> Builder<T> builder(Class<T> cls, Class<? super T>... clsArr) {
        return new Builder<>(cls, clsArr);
    }

    @SafeVarargs
    public static <T> Component<T> of(T t, Class<T> cls, Class<? super T>... clsArr) {
        return builder(cls, clsArr).factory(Component$$Lambda$2.lambdaFactory$(t)).build();
    }
}
