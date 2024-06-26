package server;

import grpc.HelloGrpc;
import grpc.HelloRequest;
import grpc.HelloResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 该类包含一个server端的简单逻辑
 * @author zhongyuan zhao
 * @date 2020.10.08
 */
public class ServerDemo {

    // 定义一个Server对象，监听端口来获取rpc请求，以进行下面的处理
    private Server server;

    //使用main方法来测试server端
    public static void main(String[] args) throws IOException, InterruptedException {

        final ServerDemo serverDemo = new ServerDemo();

        //启动server
        serverDemo.start();

        //block 一直到退出程序
        serverDemo.blockUntilShutdown();
    }

    /**
     * 启动一个Server实例，监听client端的请求并处理
     * @throws IOException
     */
    private void start() throws IOException {

        //server运行在的端口号
        int port = 10011;

        // 给server添加监听端口号，添加 包含业务处理逻辑的类，然后启动
        server = ServerBuilder.forPort(port)
                .addService(new HelloImpl())
                .build()
                .start();

    }

    /**
     * 阻塞server直到关闭程序
     * @throws InterruptedException
     */
    private void blockUntilShutdown() throws InterruptedException {

        if (server != null) {
            server.awaitTermination();
        }

    }


    /**
     * proto文件被编译后，在生成的HelloGrpc的抽象内部类HelloImplBase中包含了 proto中定义的服务接口的简单实现
     * 该HelloImpl类需要重写这些方法，添加需要的处理逻辑
     */
    static class HelloImpl extends HelloGrpc.HelloImplBase {

        // proto文件中的sayHello服务接口被编译后，在生成的HelloGrpc的抽象内部类HelloImplBase中有一个简单的实现
        // 因此，在server端需要重写这个方法，添加上相应的逻辑

        /**
         * @param request
         * @param responseObserver
         */
        @Override
        public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
            String name = request.getName();
            System.out.println("hello server receive:" + name);
            HelloResponse helloResponse = HelloResponse.newBuilder().setMessage("hello " + name).build();
            responseObserver.onNext(helloResponse);
            responseObserver.onCompleted();
        }

        /**
         * @param responseObserver
         */
        @Override
        public StreamObserver<HelloRequest> clientStream(StreamObserver<HelloResponse> responseObserver) {

            System.out.println("clientStream");
            return new StreamObserver<HelloRequest>() {

                private List<String> list = new ArrayList<>();

                @Override
                public void onNext(HelloRequest helloRequest) {
                    System.out.println("clientStream onNext");
                    list.add(helloRequest.getName());
                    if (list.get(list.size() - 1) == "end"){
                        onCompleted();
                    }
                }

                @Override
                public void onError(Throwable throwable) {
                    System.out.println("clientStream onError");
                }

                @Override
                public void onCompleted() {
                    System.out.println("clientStream onCompleted");
                    String collect = list.stream().collect(Collectors.joining("_"));
                    HelloResponse response = HelloResponse.newBuilder().setMessage(collect).build();
                    responseObserver.onNext(response);
                }
            };
        }

        /**
         * @param request
         * @param responseObserver
         */
        @Override
        public void serverStream(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
            System.out.println("serverStream");
            String name = request.getName();
            System.out.println("serverStream receive:" + name);
            String[] split = name.split("_");
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
                HelloResponse helloResponse = HelloResponse.newBuilder().setMessage(s).build();
                System.out.println("serverStream onNext:" + s);
                responseObserver.onNext(helloResponse);
            }
            responseObserver.onCompleted();
            System.out.println("serverStream onCompleted:");
        }

        /**
         * @param responseObserver
         */
        @Override
        public StreamObserver<HelloRequest> allStream(StreamObserver<HelloResponse> responseObserver) {

            return new StreamObserver<HelloRequest>() {
                private List list = new ArrayList();
                @Override
                public void onNext(HelloRequest helloRequest) {
                    String name = helloRequest.getName();
                    System.out.println("allStream onNext " + name);

                    HelloResponse build = HelloResponse.newBuilder().setMessage("allStream " + name).build();
                    responseObserver.onNext(build);
                    if (name.equals("end")){
                        onCompleted();
                        responseObserver.onCompleted();
                    }
                }

                @Override
                public void onError(Throwable throwable) {
                    System.out.println("allStream onError");
                }

                @Override
                public void onCompleted() {
                    System.out.println("allStream onCompleted");
                }
            };
        }
    }

}
