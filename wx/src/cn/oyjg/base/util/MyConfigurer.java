package cn.oyjg.base.util;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
/**
 * spring读取配置文件的时候解析
 *
 */
public class MyConfigurer extends PropertyPlaceholderConfigurer

{

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException {		
		try {
//			AES aes = new AES();
//			String url = props.getProperty("url");
//			if (url != null) {
//				props.setProperty("url", aes.decrypt(url));
//			}
//			
//			String dialect = props.getProperty("hibernate.dialect");
//			if (dialect != null) {
//				props.setProperty("hibernate.dialect", aes.decrypt(dialect));
//			}
//			
//			String driverClassName = props.getProperty("driverClassName");
//			if (driverClassName != null) {
//				props.setProperty("driverClassName", aes.decrypt(driverClassName));
//			}
//			
//			String usernames = props.getProperty("usernames");
//			if (usernames != null) {
//				props.setProperty("usernames", aes.decrypt(usernames));
//			}
//			
//			String password = props.getProperty("password");
//			if (password != null) {
//				props.setProperty("password", aes.decrypt(password));
//			}
//			
//			String packagePath = props.getProperty("packagePath");
//			if (password != null) {
//				props.setProperty("packagePath", aes.decrypt(packagePath));
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.processProperties(beanFactory, props);
	}
}
