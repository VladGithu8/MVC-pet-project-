package IoC.models;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;

public class ServiceDetails<T> {

    private Class<T> serviceType;

    private Annotation annotation;

    private Constructor<T> targetConstructor;

    private T instance;

    private Method postConstruct;

    private Method preDestroy;

    private Method[] beanS;

    private List<ServiceDetails<?>> dependantServices;

    public ServiceDetails() {
        this.dependantServices = new LinkedList<>();
    }

    public ServiceDetails(Class<T> serviceType, Annotation annotation, Constructor<T> targetConstructor,
                          Method postConstruct, Method preDestroy, Method[] beanS) {
        this();
        this.setAnnotation(annotation);
        this.setBeanS(beanS);
        this.setTargetConstructor(targetConstructor);
        this.setPostConstruct(postConstruct);
        this.setPreDestroy(preDestroy);
    }

    public Class<T> getServiceType() {
        return serviceType;
    }

    public void setServiceType(Class<T> serviceType) {
        this.serviceType = serviceType;
    }

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation annotation) {
        this.annotation = annotation;
    }

    public Constructor<T> getTargetConstructor() {
        return targetConstructor;
    }

    public void setTargetConstructor(Constructor<T> targetConstructor) {
        this.targetConstructor = targetConstructor;
    }

    public T getInstance() {
        return instance;
    }

    public void setInstance(T instance) {
        this.instance = instance;
    }

    public Method getPostConstruct() {
        return postConstruct;
    }

    public void setPostConstruct(Method postConstruct) {
        this.postConstruct = postConstruct;
    }

    public Method getPreDestroy() {
        return preDestroy;
    }

    public void setPreDestroy(Method preDestroy) {
        this.preDestroy = preDestroy;
    }

    public Method[] getBeanS() {
        return beanS;
    }

    public void setBeanS(Method[] beanS) {
        this.beanS = beanS;
    }

    public List<ServiceDetails<?>> getDependantServices() {
        return Collections.unmodifiableList(this.dependantServices);
    }

    public void addDependantService(ServiceDetails<?> serviceDetails){
        this.dependantServices.add(serviceDetails);
    }

    @Override
    public int hashCode() {
        if(this.serviceType == null){
            return super.hashCode();
        }

        return this.serviceType.hashCode();
    }
}

