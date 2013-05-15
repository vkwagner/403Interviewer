package com.huskysoft.interviewannihilator.util;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import android.annotation.SuppressLint;
import com.huskysoft.interviewannihilator.model.Category;
import com.huskysoft.interviewannihilator.model.Difficulty;
import com.huskysoft.interviewannihilator.model.Question;
import com.huskysoft.interviewannihilator.model.Solution;
import com.huskysoft.interviewannihilator.model.UserInfo;

@SuppressLint("UseSparseArrays")
public class TestHelpers {
	
	public static Question createDummyQuestion(int i) {
		Question q = new Question();
		q.setAuthorId(i+1);
		q.setCategory(Category.BRAINTEASER);
		q.setDateCreated(new Date());
		q.setDifficulty(Difficulty.MEDIUM);
		q.setQuestionId(i);
		q.setTitle("Question no. " + i);
		q.setText("Hello world" + i);
		return q;
	}
	
	public static Solution createDummySolution(int i) {
		Solution s = new Solution();
		s.setAuthorId(i+1);
		s.setDateCreated(new Date());
		s.setId(i);
		s.setQuestionId(i);
		s.setText("Some solution" + i);
		return s;
	}
	
	public static UserInfo createDummyUserInfo() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserEmail("johndoe@email.com");
		userInfo.setUserId("1234");
		userInfo.setFavoriteQuestions(createIntegerSet(10, 0));
		userInfo.setViewedQuestions(createIntegerSet(20, 1024));
		userInfo.setVotedQuestions(createIntegerBooleanMap(10, 0));
		userInfo.setVotedSolutions(createIntegerBooleanMap(10, 50));
		return userInfo;
	}

	private static Map<Integer, Boolean> createIntegerBooleanMap(
			int size, int initial) {
		Map<Integer, Boolean> m = new HashMap<Integer, Boolean>();
		for (int i = 0; i < size; i++) {
			m.put(i + initial, i % 2 == 1);
		}
		return m;
	}

	private static Set<Integer> createIntegerSet(int size, int initial) {
		Set<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < size; i++) {
			s.add(initial + i);
		}
		return s;
	}
}
