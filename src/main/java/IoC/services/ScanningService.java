package IoC.services;

import IoC.models.ServiceDetails;

import java.util.Set;

public interface ScanningService {

    Set<ServiceDetails<?>> mapService(Set<Class<?>> locatedClasses);

}
