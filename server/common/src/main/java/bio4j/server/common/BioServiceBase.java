package bio4j.server.common;

import bio4j.server.api.BioEnvironment;
import bio4j.server.api.services.BioService;



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
