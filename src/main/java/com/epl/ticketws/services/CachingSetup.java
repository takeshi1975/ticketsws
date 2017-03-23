package com.epl.ticketws.services;


import javax.cache.CacheManager;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.EternalExpiryPolicy;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.stereotype.Component;

@Component
public class CachingSetup implements JCacheManagerCustomizer {
	
	private static final Logger log = Logger.getLogger(CachingSetup.class);
	
	@Override
	public void customize(CacheManager cacheManager) {
		log.info("Se configura la cache con JSR-107. En este caso con EHCache, pero puede funcionar con otros datos");
		if (cacheManager.getCache("oneboxCache")==null)
		cacheManager.createCache("oneboxCache",
				new MutableConfiguration<>()
						.setExpiryPolicyFactory(EternalExpiryPolicy.factoryOf())
						.setStoreByValue(false).setStatisticsEnabled(true));
						//.setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(0, 60*60*1000)))				
	}
}
