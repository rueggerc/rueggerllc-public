package com.rueggerllc.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;



@RunWith(Suite.class)
// @Suite.SuiteClasses({AopTest.class})
// @Suite.SuiteClasses({JDBCTest.class})
@Suite.SuiteClasses({HibernateTest.class})
public class AllTests {
}
