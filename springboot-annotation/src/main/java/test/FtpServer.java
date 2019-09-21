package test;

public class FtpServer implements Server {
    @Override
    public void start() {
        System.out.println("ftp:启动");
    }

    @Override
    public void stop() {
        System.out.println("ftp:终止");

    }
}
