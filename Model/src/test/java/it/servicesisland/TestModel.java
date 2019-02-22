package it.servicesisland;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import it.servicesisland.Connection.handlers.TestConnectionInfo;
import it.servicesisland.Persistence.TestDataSource;
import it.servicesisland.Persistence.TestServizioDaoJDBC;
import it.servicesisland.Persistence.TestStandardDataSource;
import it.servicesisland.Persistence.TestUtenteDaoJDBC;

@RunWith(Suite.class)
@SuiteClasses({
	TestConnectionInfo.class,
	TestDataSource.class,
	//TestStandardDataSource.class (THE REMOTE DATABASE DOESN'T SUPPORT MORE THAN ONE CONNECTIONS)
	TestUtenteDaoJDBC.class,
	TestServizioDaoJDBC.class
})
public class TestModel {}
