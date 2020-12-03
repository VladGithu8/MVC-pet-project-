package IoC.services;

import IoC.annotations.AutoWired;
import IoC.annotations.Bean;
import IoC.annotations.PostConstruct;
import IoC.annotations.PreDestroy;
import IoC.annotations.ServiceCustom;
import IoC.config.configurations.CustomAnnotationsConfig;
import IoC.models.ServiceDetails;
import IoC.util.ServiceDitailsConstructorComparator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ScanningServiceImpl implements ScanningService {

    private final CustomAnnotationsConfig customAnnotationsConfig;

    public ScanningServiceImpl(CustomAnnotationsConfig customAnnotationsConfig) {
        this.customAnnotationsConfig = customAnnotationsConfig;
    }

    @Override
    public Set<ServiceDetails<?>> mapService(Set<Class<?>> locatedClasses) {
        final Set<ServiceDetails<?>> serviceDetailsStorage = new HashSet<>();
        final Set<Class<? extends Annotation>> customServiceAnnotations = customAnnotationsConfig.getCustomServiceAnnotation();
        customServiceAnnotations.add(ServiceCustom.class);

        for (Class<?> located : locatedClasses) {
            if (located.isInstance(this)) {
                continue;
            }

            for (Annotation annotation : located.getAnnotations()) {
                if (customServiceAnnotations.contains(annotation.annotationType())) {
                    ServiceDetails<?> serviceDetails = new ServiceDetails(
                            located, annotation,
                            this.findSuitTableConstructor(located),
                            this.findVoidMethodWithNoParamsAnnos(PostConstruct.class, located),
                            this.findVoidMethodWithNoParamsAnnos(PreDestroy.class, located),
                            this.findBeans(located)
                            );
                    serviceDetailsStorage.add(serviceDetails);

                    break;
                }
            }
        }

        return serviceDetailsStorage
                .stream()
                .sorted(new ServiceDitailsConstructorComparator())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private Constructor<?> findSuitTableConstructor(Class<?> located) {
        for (Constructor<?> loc : located.getDeclaredConstructors()) {
            if (located.isAnnotationPresent(AutoWired.class)) {
                loc.setAccessible(true);
                return loc;
            }
        }

        return located.getConstructors()[0];
    }

    private Method findVoidMethodWithNoParamsAnnos(Class<? extends Annotation> annotation, Class<?> located) {
        for (Method method : located.getDeclaredMethods()) {

            if (method.getParameterCount() != 0
                    || (method.getReturnType() != void.class && method.getReturnType() != Void.class)
                    || !method.isAnnotationPresent(annotation)) {
                continue;
            }

            method.setAccessible(true);
            return method;
        }
        return null;
    }

    private Method[] findBeans(Class<?> located){
        final Set<Class<? extends Annotation>> beanAnnotations = this.customAnnotationsConfig.getCustomBeanAnnotation();
        final Set<Method> beanMethods = new HashSet<>();

        for (Method declaredMethod : located.getDeclaredMethods()) {
            if(declaredMethod.getParameterCount() != 0 || declaredMethod.getReturnType() == void.class || declaredMethod.getReturnType() == Void.class){
                continue;
            }

            for (Class<? extends Annotation> beanAnnotation : beanAnnotations){
                if (declaredMethod.isAnnotationPresent(beanAnnotation)){
                    declaredMethod.setAccessible(true);
                    beanMethods.add(declaredMethod);

                    break;
                }
            }
        }
        return beanMethods.toArray(new Method[0]);

    }

    private void init() {
        this.customAnnotationsConfig.getCustomBeanAnnotation().add(Bean.class);
        this.customAnnotationsConfig.getCustomServiceAnnotation().add(ServiceCustom.class);

    }
}

