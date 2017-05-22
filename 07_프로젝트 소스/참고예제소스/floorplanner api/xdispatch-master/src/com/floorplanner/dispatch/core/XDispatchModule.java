package com.floorplanner.dispatch.core;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class XDispatchModule extends AbstractGinModule {

    @Override protected void configure() {
        bind(DispatchAsync.class).to(XDispatch.class).in(Singleton.class);
    }

}
