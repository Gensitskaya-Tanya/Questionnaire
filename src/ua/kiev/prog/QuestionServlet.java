package ua.kiev.prog;

import javax.servlet.http.*;
import java.io.IOException;


public class QuestionServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		String age = req.getParameter("age");
		String questionOne = req.getParameter("question-one");
		String questionTwo = req.getParameter("question-two");

		String correctAnswer1 = "1";
		String correctAnswer2 = "4";
		String title = surname + " " + name + ", ваш результат:";
		String msg ="";
		if(questionOne!=null && questionTwo!=null) {
			if (questionOne.equals(correctAnswer1) && questionTwo.equals(correctAnswer2)) {
				msg = title + "<br> " + "вы ответили правильно на все вопросы";
			} else if (questionOne.equals(correctAnswer1) || questionTwo.equals(correctAnswer2)) {
				msg = title + "<br> " + "вы ответили правильно на один вопрос";
			} else {
				msg = title + " <br>" + "нет правильных ответов";
			}
		}

		resp.getWriter().println(msg);
	}
}
