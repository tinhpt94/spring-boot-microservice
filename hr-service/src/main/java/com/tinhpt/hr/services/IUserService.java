package com.tinhpt.hr.services;

import com.tinhpt.hr.controllers.UserCreateRequest;
import com.tinhpt.hr.controllers.UserDetailResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IUserService {
    Long create(UserCreateRequest createRequest, MultipartFile file);
    UserDetailResponse getCurrentUser();
}
