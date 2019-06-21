package cl.hakalab.projectBaseWeb.dataProvider;

import java.io.IOException;

public class ConfigFileReader {

	
	public String getReportConfigPath() throws IOException{
		return System.getProperty("user.dir")+"/src/test/java/cl/hakalab/projectBaseWeb/dataProvider/extent-config.xml";
	}
	
    private static ConfigFileReader instance = null;
    private ConfigFileReader() {
    }

    public static ConfigFileReader getInstance() {
        if (instance == null) {
            instance = new ConfigFileReader();
        }
        return instance;
    }

}
