package bio4j.server.service.base;

import bio4j.server.service.api.BioEnvironment;
import bio4j.server.service.api.BioService;



public class BioServiceBase implements BioService {

	private BioEnvironment environment;
	
	@Override
	public void init(BioEnvironment environment) {
		this.environment = environment; 
	}

	@Override
	public BioEnvironment getEnvironment() {
		return environment;
	}


}
