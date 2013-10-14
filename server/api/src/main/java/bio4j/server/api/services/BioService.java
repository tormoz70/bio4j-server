package bio4j.server.api.services;

import bio4j.server.api.BioEnvironment;


public interface BioService
{
    void init(BioEnvironment environment);
    BioEnvironment getEnvironment();
}
