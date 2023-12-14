package com.youcode.aftas.core.service.app_service;

import com.youcode.aftas.core.database.model.dto.response.MemberResponse;
import com.youcode.aftas.core.database.model.entity.Competition;
import com.youcode.aftas.core.database.model.entity.Member;

import java.util.UUID;

public interface MemberService extends CrudVmService<Member, MemberResponse, UUID> {
}
