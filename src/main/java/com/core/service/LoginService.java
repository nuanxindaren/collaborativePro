package com.core.service;

import com.core.pojo.account.LoginAccountDTO;

import java.util.Map;

/**
 * @author renyangze
 * @date 2018/3/21
 */
public interface LoginService {

    Map<String,Object> employeesLogin(LoginAccountDTO loginAccountDTO);

}
