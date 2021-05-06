package com.resource.energy;

import com.resource.energy.constants.AppConstant;
import com.resource.energy.domain.*;
import com.resource.energy.domain.xtras.Genre;
import com.resource.energy.domain.xtras.VideoType;
import com.resource.energy.factory.CalculatePriceFactory;
import com.resource.energy.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public abstract class ResourceApiApplicationTests {

    @Autowired
    protected AppUserService appUserService;

    @Autowired
    protected AppUserRolesService appUserRolesService;

    @Autowired
    protected AppRoleService appRoleService;

    @Autowired
    protected VideoService videoService;

    @Autowired
    protected RentVideoService rentVideoService;

    @Autowired
    protected GetVideosService getVideosService;

    @Autowired
    protected RentingRateService rentingRateService;

    @Autowired
    protected CalculatePriceFactory calculatePriceFactory;

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
    }



}
