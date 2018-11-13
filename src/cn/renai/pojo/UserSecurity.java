package cn.renai.pojo;

public class UserSecurity {
    private String uIId;

    private String question;

    private String answer;

    private String userId;

    public String getuIId() {
        return uIId;
    }

    public void setuIId(String uIId) {
        this.uIId = uIId == null ? null : uIId.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}