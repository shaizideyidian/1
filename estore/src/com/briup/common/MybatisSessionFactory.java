package com.briup.common;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Configures and provides access to Hibernate sessions, tied to the
 * current thread of execution.  Follows the Thread Local Session
 * pattern, see {@link http://hibernate.org/42.html }.
 */
//用于获取MyBatis的sqlsession实例的工具类
public class MybatisSessionFactory {
    /** 
     * Location of hibernate.cfg.xml file.
     * Location should be on the classpath as Hibernate uses  
     * #resourceAsStream style lookup for its configuration file. 
     * The default classpath location of the hibernate config file is 
     * in the default package. Use #setConfigFile() to update 
     * the location of the configuration file for the current session.   
     */
    private static String CONFIG_FILE_LOCATION = "mybatis-config.xml";
//    使用了线程本地变量threadLocal来存储每个线程中的sqlsession对象，确保在不同线程中可以独立使用自己的sqlsession对象
	private static final ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	//	定义了一个私有的SqlSessionFactory对象sessionFactory和一个SqlSessionFactoryBuilder对象builder，用于创建sqlsessionfactory实例
	private static SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

	private static SqlSessionFactory sessionFactory;
	private static String configFile = CONFIG_FILE_LOCATION;

    private MybatisSessionFactory() {
    }
	
	/**
     * Returns the ThreadLocal Session instance.  Lazy initialize
     * the <code>SessionFactory</code> if needed.
     *
     *  @return Session
     *  @throws HibernateException
     */
//	getsession方法主要用于获取当前线程中的sqlsession对象
    public static SqlSession getSession(){
//    	他先尝试从当前线程的threadLocal中获取sqlsession对象
    	SqlSession session = (SqlSession) threadLocal.get();
//		如果threadLocal中不存在sqlsession对象，那么它会检查sessionfactory是否为null，如果是null，则调用rebuildSessionFactory方法重构sqlsessionfactory
		if (session == null) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
//			通过sessionfactory.opensession方法构建一个新的sqlsession对象，并将其设置到threadlocal中，以便后续的线程内使用
			session = (sessionFactory != null) ? sessionFactory.openSession()
					: null;
			threadLocal.set(session);
		}

        return session;
    }

	/**
     *  Rebuild hibernate session factory
     *
     */
//	用于重构sqlsessionfactory实例，首先尝试通过Resources.getResourceAsStream方法获取配置文件的输入流，然后使用builder.build方法基于输入流构建sqlsessionfactory对象
	public static void rebuildSessionFactory() {
		try {
			InputStream is = Resources.getResourceAsStream(configFile);
			sessionFactory = builder.build(is);
		} catch (Exception e) {
			System.err
					.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}

	/**
     *  Close the single hibernate session instance.
     *
     *  @throws HibernateException
     */
//	该方法用于关闭当前线程中的sqlsession实例，他首先从threadlocal中获取sqlsession实例，然后将threadlocal设置为null，最后，如果获取到的sqlsession非null，则调用其close方法关闭会话
    public static void closeSession() throws Exception {
    	SqlSession session = (SqlSession) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

	/**
     *  return session factory
     *
     */
//	方法用于获取当前的sqlsessionfactory实例
	public static SqlSessionFactory getSqlSessionFactory() {
		return sessionFactory;
	}

	/**
     *  return session factory
     *
     *	session factory will be rebuilded in the next call
     */
//	方法用于设置配置文件的路径，他接受一个字符串参数configfile，用于指定配置文件的新路径，设置路径后，会将sessionfactory置为null
	public static void setConfigFile(String configFile) {
		MybatisSessionFactory.configFile = configFile;
		sessionFactory = null;
	}

	/**
     *  return hibernate configuration
     *
     */
}