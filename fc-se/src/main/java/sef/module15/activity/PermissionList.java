package sef.module15.activity;

import java.util.HashSet;
import java.util.Set;

public class PermissionList implements Permissible {
	
	private String permissionID;
	private Set<Permission> permission;
	
	/**
	 * Creates a permission object and provides an identifier for it
	 * 
	 * @param permissionID
	 */
	public PermissionList(String permissionID){
		this.permissionID = permissionID;
		this.permission = new HashSet<>();
	}

	/** (non-Javadoc)
	 * @see Permissible#getPermission()
	 */
	@Override
	public Set<Permission> getPermission() {
		return this.permission;
	}


	/** (non-Javadoc)
	 * @see Permissible#removePermission(sef.module15.activity.Permission[])
	 */
	@Override
	public void removePermission(Permission... permissions) {
		//todo: add implementation
	}


	/** (non-Javadoc)
	 * @see Permissible#setPermission(sef.module15.activity.Permission[])
	 */
	@Override
	public void setPermission(Permission... permissions) {
		//todo: add implementation
	}


	/** (non-Javadoc)
	 * @see Permissible#isPermissible(sef.module15.activity.Permission)
	 */
	@Override
	public boolean isPermissible(Permission permission) {
		return false; //todo: add implementation
	}

	public String getPermissionID() {
		return permissionID;
	}

	public void setPermissionID(String permissionID) {
		this.permissionID = permissionID;
	}
}
