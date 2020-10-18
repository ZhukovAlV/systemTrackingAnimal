package exception;

public enum ErrorCode {

    SERVER_IS_START("{\"error\" : \"Сервер уже запущен.\"}"),
    SERVER_NOT_START("{\"error\" : \"Сервер не запущен.\"}"),
    SERVER_FILE_NOT_EXIST("{\"error\" : \"Файл не найден.\"}");

    private String message;

    ErrorCode(String message){
        this.message = message;
    }

    public String getErrorString(){
        return message;
    }
}
