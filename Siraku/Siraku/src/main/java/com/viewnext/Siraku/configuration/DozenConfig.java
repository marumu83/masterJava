package com.viewnext.Siraku.configuration;

import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozenConfig {

	@Bean
	public DozerBeanMapper getMapper() {
		DozerBeanMapper dbm = new DozerBeanMapper();
		List<String> mappingFiles = Arrays.asList("dozer-configuration-mapping.xml");
		
		dbm.setMappingFiles(mappingFiles);
		
		return dbm;
	}
}
