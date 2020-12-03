package IoC.config;

import IoC.config.configurations.CustomAnnotationsConfig;

public abstract class SubConfig {

    private final MyConfig parentConfig;

    protected SubConfig(MyConfig parentConfig) {
        this.parentConfig = parentConfig;
    }

    public MyConfig and(){
        return this.parentConfig;
    }

    public CustomAnnotationsConfig annotationsConfig() {
        return this.annotationsConfig();
    }

}
