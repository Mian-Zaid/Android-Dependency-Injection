package com.techyourchance.dagger2course.screens.common.viewMvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailViewMvc
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListViewMvc

class ViewMvcFactory(private val layoutInflater: LayoutInflater) {

    fun newQuestionListViewMvc(parent: ViewGroup?): QuestionsListViewMvc {
        return QuestionsListViewMvc(layoutInflater, parent)
    }

    fun newQuestionDetailsMvc(parent: ViewGroup?): QuestionDetailViewMvc {
        return QuestionDetailViewMvc(layoutInflater, parent)
    }
}