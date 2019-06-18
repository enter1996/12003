package iducs.springboot.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iducs.springboot.board.domain.Answer;
import iducs.springboot.board.domain.User;
import iducs.springboot.board.entity.AnswerEntity;
import iducs.springboot.board.entity.QuestionEntity;
import iducs.springboot.board.entity.UserEntity;
import iducs.springboot.board.exception.ResourceNotFoundException;
import iducs.springboot.board.repository.AnswerRepository;

@Service("answerService")
public class AnswerServiceImpl implements AnswerService {
	@Autowired 
	private AnswerRepository repository;
	
	@Override
	public Answer getAnswerById(long id) {
		AnswerEntity answerEntity = null;
		try {
			answerEntity = repository.findById(id).orElseThrow(() 
					-> new ResourceNotFoundException("not found " + id ));
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answerEntity.buildDomain();
		// TODO Auto-generated method stub
	}

	@Override
	public List<Answer> getAnswers() {
		List<Answer> answers = new ArrayList<Answer>();
		List<AnswerEntity> entities = repository.findAll();
		for(AnswerEntity entity : entities) {
			Answer answer = entity.buildDomain();
			answers.add(answer);
		}
		return answers;
	}


	@Override
	public void saveAnswer(Answer answer) {
		AnswerEntity entity = new AnswerEntity();
		entity.buildEntity(answer);
		repository.save(entity);
	}

	@Override
	public void updateAnswer(Answer answer) {
		AnswerEntity entity = new AnswerEntity();
		entity.buildEntity(answer);
		repository.save(entity);
	}

	@Override
	public void deleteAnswer(Answer answer) {
		// TODO Auto-generated method stub
		AnswerEntity entity = new AnswerEntity();
		entity.buildEntity(answer);
		repository.delete(entity);
	}
	


}
