package IoC.config.configurations;

import IoC.config.MyConfig;
import IoC.config.SubConfig;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CustomAnnotationsConfig extends SubConfig {

    private final Set<Class<? extends Annotation>> customServiceAnnotation;
    private final Set<Class<? extends Annotation>> customBeanAnnotation;


    public CustomAnnotationsConfig(MyConfig parentConfig) {
        super(parentConfig);
        this.customBeanAnnotation = new HashSet<>();
        this.customServiceAnnotation = new HashSet<>();
    }

    public CustomAnnotationsConfig addCustomServiceAnnotation(Class<? extends Annotation> annotation) {
        this.customServiceAnnotation.add(annotation);
        return this;
    }

    public CustomAnnotationsConfig addCustomServiceAnnotation(Class<? extends Annotation>... annotation) {
        this.customServiceAnnotation.addAll(Arrays.asList(annotation));
        return this;
    }

    public CustomAnnotationsConfig addCustomBeanAnnotation(Class<? extends Annotation> annotation) {
        this.customBeanAnnotation.add(annotation);
        return this;
    }

    public CustomAnnotationsConfig addCustomBeanAnnotation(Class<? extends Annotation>... annotation) {
        this.customBeanAnnotation.addAll(Arrays.asList(annotation));
        return this;
    }

    public Set<Class<? extends Annotation>> getCustomServiceAnnotation() {
        return customServiceAnnotation;
    }

    public Set<Class<? extends Annotation>> getCustomBeanAnnotation() {
        return customBeanAnnotation;
    }
}

