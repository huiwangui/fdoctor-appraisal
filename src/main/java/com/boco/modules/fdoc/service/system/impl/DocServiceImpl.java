package com.boco.modules.fdoc.service.system.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boco.common.persistence.Page;
import com.boco.modules.fdoc.dao.system.DoctorDao;
import com.boco.modules.fdoc.service.system.DocService;
import com.boco.modules.fdoc.vo.DoctorDetailVo;

@Service

public class DocServiceImpl implements DocService {
	
	@Resource
	DoctorDao doctorDao;

	@Override
	public DoctorDetailVo getDoctorInfo(String id) {
		return doctorDao.getDoctorInfo(id);
	}

	@Override
	public List<DoctorDetailVo> getDoctorTeamMemberByTeamId(String teamId) {
		return doctorDao.getDoctorTeamMemberByTeamId(teamId);
	}

	@Override
	public List<DoctorDetailVo> getDoctorTeamMemberByDocId(String docId) {
		return doctorDao.getDoctorTeamMemberByDocId(docId);
	}

	@Override
	public DoctorDetailVo getTeamLeaderInfo(String teamId) {
		return doctorDao.getTeamLeaderInfo(teamId);
	}

	@Override
	public List<DoctorDetailVo> getDoctorList(String docName,
			Integer pageSize, Integer pageNo) {
		// 设置查询参数
		DoctorDetailVo vo = new DoctorDetailVo();
		vo.setDocName(docName);
		// 设置分页对象
		Page<DoctorDetailVo> page = new Page<DoctorDetailVo>(pageNo,pageSize);
		vo.setPage(page);
		return doctorDao.getDoctorList(vo);
	}

	@Override
	public Integer getDoctorCount(DoctorDetailVo docVo) {
		// 设置查询参数
		return doctorDao.getDoctorCount(docVo);
	}

	@Override
	public Integer getTeamCount() {
		return doctorDao.getTeamCount();
	}

	@Override
	public List<String> getTeamIdsByHospital(String orgId) {
		return doctorDao.getTeamIdsByHospital(orgId);
	}

	@Override
	public List<DoctorDetailVo> getDocList(DoctorDetailVo docVo) {
		return doctorDao.getDocList(docVo);
	}

	@Override
	public List<DoctorDetailVo> getLeaderList(DoctorDetailVo docVo) {
		return doctorDao.getLeaderList(docVo);
	}

	@Override
	public int getLeaderCount(DoctorDetailVo countVo) {
		return doctorDao.getLeaderCount(countVo);
	}

	@Override
	public List<DoctorDetailVo> getDocByType(DoctorDetailVo docVo) {
		return doctorDao.getDocByType(docVo);
	}


}
