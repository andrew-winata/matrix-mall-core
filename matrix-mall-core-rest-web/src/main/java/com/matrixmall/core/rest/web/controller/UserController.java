package com.matrixmall.core.rest.web.controller;

import io.swagger.annotations.Api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matrixmall.core.commons.constant.ErrorCategory;
import com.matrixmall.core.commons.exception.ApplicationException;
import com.matrixmall.core.entity.User;
import com.matrixmall.core.rest.web.converter.UserRequestConverter;
import com.matrixmall.core.rest.web.model.BaseResponse;
import com.matrixmall.core.rest.web.model.BaseSummaryResponse;
import com.matrixmall.core.rest.web.model.PagingResponse;
import com.matrixmall.core.rest.web.model.user.CreateUserRequest;
import com.matrixmall.core.rest.web.model.user.UpdateUserRequest;
import com.matrixmall.core.rest.web.model.user.UserResponse;
import com.matrixmall.core.rest.web.util.ControllerUtils;
import com.matrixmall.core.rest.web.validator.UserRequestValidator;
import com.matrixmall.core.service.user.UserService;

@RestController
@RequestMapping(value = UserController.BASE_PATH)
@Api(value = "MTXCORE User API")
public class UserController {
  public static final String BASE_PATH = "/users";

  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserRequestValidator userRequestValidator;

  @Autowired
  private UserRequestConverter userRequestConverter;

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public BaseSummaryResponse<UserResponse> findUsers(
      @RequestParam(required = true) String requestId,
      @RequestParam(defaultValue = "0") Integer page,
      @RequestParam(defaultValue = "10") Integer size) {
    try {
      List<UserResponse> userResponses = new ArrayList<>();
      Page<User> pageOfUsers = userService.findAll(new PageRequest(page, size));
      for (User user : pageOfUsers.getContent()) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);
        userResponses.add(userResponse);
      }
      return new BaseSummaryResponse<>(userResponses, new PagingResponse(pageOfUsers.getSize(),
          pageOfUsers.getNumber(), pageOfUsers.getTotalElements()), requestId);
    } catch (Exception e) {
      LOGGER.error(ControllerUtils.generateLoggerRequestId(requestId)
          + "Error when invoking findUsers", e);
      return new BaseSummaryResponse<>(ErrorCategory.UNSPECIFIED.getMessage(),
          ErrorCategory.UNSPECIFIED.getCode(), false, requestId);
    }
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public BaseResponse create(@RequestParam(required = true) String requestId, @RequestBody(
      required = true) CreateUserRequest createUserRequest) {
    try {
      userRequestValidator.validateCreateUserRequest(createUserRequest);
      User toBeSavedUser = userRequestConverter.convertCreateUserRequest(createUserRequest);
      userService.create(toBeSavedUser);
      return new BaseResponse(requestId);
    } catch (ApplicationException e) {
      LOGGER.error(ControllerUtils.generateLoggerRequestId(requestId)
          + "Error when invoking create", e);
      return new BaseResponse(e.getMessage(), e.getErrorCategory().getCode(), false, requestId);
    } catch (Exception e) {
      LOGGER.error(ControllerUtils.generateLoggerRequestId(requestId)
          + "Error when invoking create", e);
      return new BaseResponse(ErrorCategory.UNSPECIFIED.getMessage(),
          ErrorCategory.UNSPECIFIED.getCode(), false, requestId);
    }
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public BaseResponse update(@PathVariable("id") String id,
      @RequestParam(required = true) String requestId,
      @RequestBody(required = true) UpdateUserRequest updateUserRequest) {
    try {
      updateUserRequest.setId(id);
      userRequestValidator.validateUpdateUserRequest(updateUserRequest);
      User toBeSavedUser = userRequestConverter.convertUpdateUserRequest(updateUserRequest);
      userService.update(toBeSavedUser);
      return new BaseResponse(requestId);
    } catch (Exception e) {
      LOGGER.error(ControllerUtils.generateLoggerRequestId(requestId)
          + "Error when invoking update", e);
      return new BaseResponse(ErrorCategory.UNSPECIFIED.getMessage(),
          ErrorCategory.UNSPECIFIED.getCode(), false, requestId);
    }
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public BaseResponse delete(@PathVariable("id") String id,
      @RequestParam(required = true) String requestId) {
    try {
      userService.delete(id);
      return new BaseResponse(requestId);
    } catch (Exception e) {
      LOGGER.error(ControllerUtils.generateLoggerRequestId(requestId)
          + "Error when invoking delete", e);
      return new BaseResponse(ErrorCategory.UNSPECIFIED.getMessage(),
          ErrorCategory.UNSPECIFIED.getCode(), false, requestId);
    }
  }
}
