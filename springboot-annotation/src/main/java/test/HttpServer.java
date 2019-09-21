package test;

public class HttpServer implements Server {
    @Override
    public void start() {
        System.out.println("http启动");
    }

    @Override
    public void stop() {
        System.out.println("http终止");

    }
}
