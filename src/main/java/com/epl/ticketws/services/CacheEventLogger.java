package com.epl.ticketws.services;

import org.apache.log4j.Logger;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

public class CacheEventLogger implements CacheEventListener<Object, Object> {

	private static final Logger logger = Logger.getLogger(CacheEventLogger.class);

	@Override
	public void onEvent(CacheEvent<Object, Object> event) {
		logger.info("Event: " + event.getType() + " Key: " + event.getKey() + " old value: " + event.getOldValue()
				+ " new value: " + event.getNewValue());
	}

}
