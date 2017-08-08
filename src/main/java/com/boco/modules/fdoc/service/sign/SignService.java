package com.boco.modules.fdoc.service.sign;

import java.util.List;
import java.util.Map;

import com.boco.modules.fdoc.model.sign.SigServicepackEntity;
import com.boco.modules.fdoc.vo.SignFamilyTeamVo;

/**
 * 签约相关service层
 * @author q
 *
 */
public interface SignService {

	public List<SignFamilyTeamVo> getSignListByType(SignFamilyTeamVo signVo);

	public Integer getSignListByTypecCount(SignFamilyTeamVo signVo);
	
}
