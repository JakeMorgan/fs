package sef.module15.activity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

public class PermissionsTest extends TestCase {
	
	Log logger = LogFactory.getLog(this.getClass());
	
	public void testPermissions(){
		try{
		PermissionList temp = new PermissionList("1234");
		temp.setPermission(Permission.READ, Permission.WRITE, Permission.EXECUTE);
		temp.setPermission(Permission.READ);
		
		assertTrue(temp.isPermissible(Permission.READ));
		assertTrue(temp.isPermissible(Permission.WRITE));
		assertFalse(temp.isPermissible(Permission.CREATE));
		
		temp.removePermission(Permission.READ, Permission.WRITE);
		assertTrue(temp.isPermissible(Permission.EXECUTE));
		assertFalse(temp.isPermissible(Permission.READ));
		assertFalse(temp.isPermissible(Permission.WRITE));
		}
		catch(AssertionFailedError e){
			logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
			logger.error(sef.module.percentage.Percentage.setFailedCount(true,1));
		}	
	}
}
