package com.core.pojo.account;

public class OfficeRolePerMissionDOKey {
    private String userRoleId;

    private String permissionsMenuId;

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId == null ? null : userRoleId.trim();
    }

    public String getPermissionsMenuId() {
        return permissionsMenuId;
    }

    public void setPermissionsMenuId(String permissionsMenuId) {
        this.permissionsMenuId = permissionsMenuId == null ? null : permissionsMenuId.trim();
    }
}