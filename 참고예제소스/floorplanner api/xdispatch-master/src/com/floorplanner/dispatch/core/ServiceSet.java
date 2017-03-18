package com.floorplanner.dispatch.core;

import java.util.Arrays;
import java.util.HashSet;

public class ServiceSet extends HashSet<Service> {

    public ServiceSet(Service... services) {
        super(Arrays.asList(services));
    }

    private static final long serialVersionUID = 1L;
}
