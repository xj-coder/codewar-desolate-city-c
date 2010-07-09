package registry.dom;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Registry {
	private Config config;
	private Map<String, Set<Extend>> extendMap = new TreeMap<String, Set<Extend>>();

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public Map<String, Set<Extend>> getExtendMap() {
		return extendMap;
	}

	public void setExtendMap(Map<String, Set<Extend>> extendMap) {
		this.extendMap = extendMap;
	}

}
