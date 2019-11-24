package com.tinhpt.hr.services;

import com.tinhpt.hr.controllers.UserCreateRequest;
import com.tinhpt.hr.controllers.UserDetailResponse;
import com.tinhpt.hr.entities.RoleEntity;
import com.tinhpt.hr.entities.UserDetailEntity;
import com.tinhpt.hr.entities.UserEntity;
import com.tinhpt.hr.repositories.RoleDao;
import com.tinhpt.hr.repositories.UserDao;
import com.tinhpt.hr.repositories.UserDetailDao;
import com.tinhpt.hr.utils.AuditHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDetailDao userDetailDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private IFileUpload fileUpload;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public Long create(UserCreateRequest createRequest, MultipartFile file) {
        String uploadedUrl = fileUpload.uploadFile(createRequest.getName(), file);
        UserEntity userEntity = userDao.save(mapModelToUserEntity(createRequest));
        userDetailDao.save(mapModelToUserDetailEntity(createRequest, userEntity, uploadedUrl));
        return userEntity.getId();
    }

    @Override
    public UserDetailResponse getCurrentUser() {
        String username = AuditHelper.getCurrentAuditor();
        UserEntity userEntity = userDao.findByUsernameIgnoreCase(username).orElseThrow(() -> new RuntimeException("Cannot find username: " + username));
        UserDetailEntity userDetailEntity = userDetailDao.findByUser(userEntity).orElseThrow(() -> new RuntimeException("Cannot find username: " + username));
        return convertEntityToDetailResponse(userEntity, userDetailEntity);
    }


    private UserEntity mapModelToUserEntity(UserCreateRequest createRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(createRequest.getUsername());
        RoleEntity roleEntity = roleDao.findByNameIgnoreCase(createRequest.getRole()).orElseThrow(() -> new RuntimeException("Invalid Role"));
        userEntity.setRole(roleEntity);
        userEntity.setEncryptedPassword(encoder.encode("12345"));
        return userEntity;
    }

    private UserDetailEntity mapModelToUserDetailEntity(UserCreateRequest createRequest, UserEntity userEntity, String imageUrl) {
        UserDetailEntity userDetailEntity = new UserDetailEntity();
        userDetailEntity.setUser(userEntity);
        userDetailEntity.setAddress(createRequest.getAddress());
        userDetailEntity.setName(createRequest.getName());
        userDetailEntity.setImageUrl(imageUrl);
        userDetailEntity.setDob(createRequest.getDob());
        return userDetailEntity;
    }

    private UserDetailResponse convertEntityToDetailResponse(UserEntity user, UserDetailEntity userDetail) {
        UserDetailResponse response = new UserDetailResponse();
        response.setAddress(userDetail.getAddress());
        response.setImageUrl(userDetail.getImageUrl());
        response.setName(userDetail.getName());
        response.setUsername(user.getUsername());
        response.setRole(user.getRole().getName());
        return response;
    }
}
