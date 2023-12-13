package com.youcode.aftas.core.service.app_service;

import com.youcode.aftas.core.dao.model.entity.Competition;
import com.youcode.aftas.core.utils.pipe.vm.CompetitionVm;

import java.util.UUID;

public interface CompetitionService extends CrudVmService<Competition,CompetitionVm, UUID>{

}
