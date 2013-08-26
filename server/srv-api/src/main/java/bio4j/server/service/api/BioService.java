package bio4j.server.service.api;


public interface BioService
{
    void init(BioEnvironment environment);
    BioEnvironment getEnvironment();
}
