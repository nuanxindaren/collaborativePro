package com.core.dao;

import com.core.pojo.account.LoginAccountDTO;

/**
 * @author renyangze
 * @date 2018/3/21
 */
public interface LoginDAO {

    LoginAccountDTO getLoginMessage(String account);
}
