package com.jankin.usercenter.service;

import com.jankin.usercenter.model.domain.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jankin.usercenter.model.domain.User;
import com.jankin.usercenter.model.dto.TeamQuery;
import com.jankin.usercenter.model.request.TeamJoinRequest;
import com.jankin.usercenter.model.request.TeamUpdateRequest;
import com.jankin.usercenter.vo.TeamUserVO;

import java.util.List;

/**
 * @author Jankin
 * @description 针对表【team(队伍表)】的数据库操作Service
 * @createDate 2024-01-25 20:29:44
 */
public interface TeamService extends IService<Team> {

    /**
     * 创建队伍
     *
     * @param team
     * @param loginUser
     * @return
     */
    long addTeam(Team team, User loginUser);

    /**
     * 查询队伍
     *
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    /**
     * 修改队伍
     *
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     *
     * @param teamJoinRequest
     * @param loginUser
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);
}
