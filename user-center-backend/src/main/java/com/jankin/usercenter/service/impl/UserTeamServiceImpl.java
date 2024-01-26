package com.jankin.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jankin.usercenter.model.domain.UserTeam;
import com.jankin.usercenter.service.UserTeamService;
import com.jankin.usercenter.mapper.UserTeamMapper;
import org.springframework.stereotype.Service;

/**
* @author Jankin
* @description 针对表【user_team(用户队伍关系表)】的数据库操作Service实现
* @createDate 2024-01-25 20:32:18
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService{

}




