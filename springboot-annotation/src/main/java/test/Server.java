package test;

public interface Server {

    void start();
    void stop();

    enum Type{
        HTTP,FTP
    }
}
