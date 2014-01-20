package cn.oyjg.base.util;



import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class SystemConfig
{

    private static Properties systemConfig = null;
    static Logger log;
 //   static Class class$0; /* synthetic field */

    public SystemConfig()
    {
    }

    public static synchronized void readSystemConfig()
    {
        try
        {
            InputStream is = SystemConfig.class.getClassLoader().getResourceAsStream("config.properties");
            if(systemConfig == null)
                systemConfig = new Properties();
            else
                systemConfig.clear();
            systemConfig.load(is);
        }
        catch(Exception e)
        {
            log.error("systemconfig.properties ", e);
        }
    }

    public static String getProperty(String name)
    {
        return getProperty(name, "");
    }

    public static String getProperty(String name, String defaultValue)
    {
        if(systemConfig == null)
            readSystemConfig();
        String ret = systemConfig.getProperty(name);
        if(ret == null)
        {
            ret = defaultValue;
            log.info(name );
        }
        return ret.trim();
    }

    public static int getIntProperty(String name, int defaultValue)
    {
        int ret = 0;
        try
        {
            ret = Integer.parseInt(getProperty(name));
        }
        catch(Exception e)
        {
            ret = defaultValue;
            log.info(name);
        }
        return ret;
    }

    public static void main(String args[])
    {
        String test = getProperty("table_prefix");
        System.out.println(test);
    }

    static 
    {
        log = Logger.getLogger(SystemConfig.class);
    }
} 

