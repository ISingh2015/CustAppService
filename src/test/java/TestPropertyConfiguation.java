
import com.inderjit.controller.PropertiesCache;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Zed
 */
public class TestPropertyConfiguation {

    private PropertiesCache configProp = null;

    public static void main(String... args) throws ConfigurationException {
        TestPropertyConfiguation test = new TestPropertyConfiguation();
        test.configProp=PropertiesCache.getInstance();
        String value = test.configProp.getProperty("clientimgPath");
        test.configProp.setProperty("clientimgPath",value + value);
        test.configProp.saveSetting();
        System.out.println("Got image path " + test.configProp.getProperty("clientimgPath"));
    }
}
