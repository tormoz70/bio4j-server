package bio4j.server.service.inverter;

import bio4j.server.service.api.Inverter;

public class InverterImpl implements Inverter {
	public String login(String name, String password) {
		return name + "/" + password;
	}

	public String register(String name, String password) {
		return null;
	}
}
