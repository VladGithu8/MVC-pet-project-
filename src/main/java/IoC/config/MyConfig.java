package IoC.config;

import IoC.config.configurations.CustomAnnotationsConfig;

public class MyConfig {

    private final CustomAnnotationsConfig annotationsConfig;

    public MyConfig () {
        this.annotationsConfig = new CustomAnnotationsConfig(this);
    }

    public CustomAnnotationsConfig annotations() {
        return this.annotationsConfig();
    }

    private CustomAnnotationsConfig annotationsConfig() {
        return this.annotationsConfig;
    }

    public MyConfig myBuild(){
        return this;
    }

}
