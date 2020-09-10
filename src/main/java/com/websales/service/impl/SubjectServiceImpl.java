package com.websales.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websales.entity.Subject;
import com.websales.model.SubjectModel;
import com.websales.model.User;
import com.websales.repository.ISubjectRepository;
import com.websales.service.ISubjectService;

@Service
public class SubjectServiceImpl implements ISubjectService {

	@Autowired
	ISubjectRepository subjectRepo;

	public List<SubjectModel> getListSubject(User user) {

		SubjectModel model = null;
		List<SubjectModel> list = new ArrayList<SubjectModel>();
		List<Subject> subjectList = subjectRepo.findAll();
		for (Subject subject : subjectList) {
			model = new SubjectModel();
			model.setId(subject.getId());
			model.setName(subject.getName());
			list.add(model);
			
			if(!"vn".equals(user.getLocale().toString())) {
				model.setName(subject.getNameEn());
			}
		}
		return list;

	}
}
