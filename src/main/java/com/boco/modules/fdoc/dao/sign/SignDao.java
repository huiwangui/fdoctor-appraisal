package com.boco.modules.fdoc.dao.sign;

import java.util.List;

import com.boco.common.annotation.MyBatisDao;
import com.boco.modules.fdoc.vo.SignFamilyTeamVo;
/**
 * 
 * ClassName: SignDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: 签约相关Dao. <br/>
 * date: 2017年2月8日 上午10:47:00 <br/>
 *
 * @author q
 * @version 
 * @since JDK 1.7+
 */
@MyBatisDao
public interface SignDao {

	public List<SignFamilyTeamVo> getSignListByType(SignFamilyTeamVo signVo);

	public Integer getSignListByTypeCount(SignFamilyTeamVo signVo);
	
	
}
