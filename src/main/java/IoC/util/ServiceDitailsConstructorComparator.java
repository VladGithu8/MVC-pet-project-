package IoC.util;

import IoC.models.ServiceDetails;

import java.util.Comparator;

public class ServiceDitailsConstructorComparator implements Comparator<ServiceDetails> {

    @Override
    public int compare(ServiceDetails serviceDetailsT1, ServiceDetails serviceDetailsT2) {
        return Integer.compare(
                serviceDetailsT1.getTargetConstructor().getParameterCount(),
                serviceDetailsT2.getTargetConstructor().getParameterCount()
        );
    }
}
