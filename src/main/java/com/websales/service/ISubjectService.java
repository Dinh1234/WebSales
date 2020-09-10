package com.websales.service;

import java.util.List;

import com.websales.model.SubjectModel;
import com.websales.model.User;

public interface ISubjectService {

	List<SubjectModel> getListSubject(User user);
}
