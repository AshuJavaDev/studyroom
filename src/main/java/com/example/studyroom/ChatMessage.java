package com.example.studyroom;

public class ChatMessage {

    private String studentName;
    private String content;
    private String roomId;

    public ChatMessage()    {

    }

    public String getStudentName()  {
            return studentName;
    }

    public void setStudentName(String studentName)  {
        this.studentName = studentName;
    }

    public String getContent()  {
        return content;
    }

    public void setContent(String content)  {
        this.content = content;
    }

    public String getRoomId()   {
        return roomId;
    }

    public void setRoomId(String roomId)    {
        this.roomId = roomId;
    }
}
