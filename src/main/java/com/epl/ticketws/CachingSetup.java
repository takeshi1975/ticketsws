package com.epl.ticketws;

import java.util.concurrent.TimeUnit;

import javax.cache.CacheManager;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.stereotype.Component;

@Component
public class CachingSetup implements JCacheManagerCustomizer{

	private static final Logger logger = Logger.getLogger(CachingSetup.class); 
	
	@Override
	public void customize(CacheManager cacheManager) {
		 logger.info("Se va a configurar la gestion de la cache");
		 cacheManager.createCache("people", new MutableConfiguration<>()  
			        .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(TimeUnit.MINUTES,10))) 
			        .setStoreByValue(false)
			        
			        .setStatisticsEnabled(true));
		
	}

}
