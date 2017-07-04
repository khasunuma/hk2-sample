/*
 * Copyright (c) 2014-2017 HASUNUMA Kenji
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */

package jp.coppermine.samples.hk2.named;

import org.glassfish.hk2.api.DynamicConfiguration;
import org.glassfish.hk2.api.DynamicConfigurationService;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;
import org.glassfish.hk2.utilities.BuilderHelper;

public class ManualAppMain {

    public static void main(String[] args) {
        // Obtain a ServiceLocator object
        ServiceLocatorFactory factory = ServiceLocatorFactory.getInstance();
        ServiceLocator locator = factory.create("default");
        
        // Obtain the DynamicConfiguration object for binding a service to a contract.
        DynamicConfigurationService dcs = locator.getService(DynamicConfigurationService.class);
        DynamicConfiguration config = dcs.createDynamicConfiguration();
        
        // binding a service to a contract.
        config.bind(BuilderHelper.link(Greeter.class).build());
        config.bind(BuilderHelper.link(HelloImpl.class).to(Hello.class).build());
        config.bind(BuilderHelper.link(HelloJaImpl.class).to(Hello.class).named("Japanese").build());
        config.bind(BuilderHelper.link(HelloDeImpl.class).to(Hello.class).named("German").build());
        config.bind(BuilderHelper.link(HelloFrImpl.class).to(Hello.class).named("France").build());
        config.bind(BuilderHelper.link(HelloItImpl.class).to(Hello.class).named("Italian").build());
        config.bind(BuilderHelper.link(HelloEsImpl.class).to(Hello.class).named("Spanish").build());
        config.bind(BuilderHelper.link(HelloBrPtImpl.class).to(Hello.class).named("Portuguese").build());
        config.bind(BuilderHelper.link(HelloZhChImpl.class).to(Hello.class).named("Chinese").build());
        config.bind(BuilderHelper.link(HelloZhTwImpl.class).to(Hello.class).named("TraditionalChinese").build());
        config.bind(BuilderHelper.link(HelloKoImpl.class).to(Hello.class).named("Korean").build());
        config.commit();
        
        // Obtain the value from a Message object and output it
        Greeter greeter = locator.getService(Greeter.class);
        
        System.out.println("All greetings:");
        greeter.getAll().forEach(System.out::println);
        
        System.out.println();
        
        System.out.println("Say: " + greeter.greet());
    }

}
