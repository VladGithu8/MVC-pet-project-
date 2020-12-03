package IoC.tests;

import IoC.annotations.*;

@ServiceCustom
public class TestServiceTwo {

    private final TestServiceOne testServiceOne;

    public TestServiceTwo(TestServiceOne testServiceOne){
        this.testServiceOne = testServiceOne;
    }

    @AutoWired
    public TestServiceTwo() {
        this.testServiceOne = null;
    }


    @PostConstruct
    private void onInit(int myInt){
     }

     @PreDestroy
     public String onDestroy(){
        return null;
     }

     @Bean
    public TestServiceOther testServiceOther(){
        return new TestServiceOther();
     }
}
