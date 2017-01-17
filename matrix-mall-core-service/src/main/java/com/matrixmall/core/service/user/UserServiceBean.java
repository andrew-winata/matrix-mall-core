package com.matrixmall.core.service.user;

import java.util.Date;

import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matrixmall.core.dao.user.UserDao;
import com.matrixmall.core.entity.User;
import com.matrixmall.core.service.validator.UserServiceValidator;

@Service
@Transactional(readOnly = true)
public class UserServiceBean implements UserService {

  @Autowired
  private UserDao userDao;

  @Autowired
  @Qualifier("basicPasswordEncryptor")
  private PasswordEncryptor passwordEncryptor;

  @Autowired
  private UserServiceValidator userServiceValidator;

  @Override
  public User findByUsername(String username) {
    return userDao.findByUsername(username);
  }

  @Override
  public Page<User> findAll(Pageable pageable) {
    return userDao.findAll(pageable);
  }

  @Override
  public User findById(String id) {
    return userDao.findOne(id);
  }

  @Transactional(readOnly = false, rollbackFor = Exception.class)
  @Override
  public User create(User user) throws Exception {
    userServiceValidator.validateSaveUser(user, true);
    User toBeSavedUser = new User();
    BeanUtils.copyProperties(user, toBeSavedUser);
    toBeSavedUser.setUsername(user.getUsername().toLowerCase());
    toBeSavedUser.setEmail(user.getEmail().toLowerCase());
    toBeSavedUser.setCreatedDate(new Date());
    toBeSavedUser.setPassword(passwordEncryptor.encryptPassword(user.getPassword()));
    return userDao.save(toBeSavedUser);
  }

  @Transactional(readOnly = false, rollbackFor = Exception.class)
  @Override
  public User update(User user) throws Exception {
    userServiceValidator.validateSaveUser(user, false);
    User savedUser = userDao.findOne(user.getId());
    BeanUtils.copyProperties(user, savedUser);
    savedUser.setUpdatedDate(new Date());
    return userDao.save(savedUser);
  }

  @Override
  public void delete(String id) throws Exception {
    User savedUser = userDao.findOne(id);
    savedUser.setDelete(true);
    userDao.save(savedUser);
  }
}
