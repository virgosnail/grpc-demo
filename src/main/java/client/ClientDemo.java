package client;

import grpc.HelloGrpc;
import grpc.HelloRequest;
import grpc.HelloResponse;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 该类包含一个client端的简单逻辑
 *
 * @author zhongyuan zhao
 * @date 2020.10.08
 */
public class ClientDemo {

    //使用main方法来测试client端
    public static void main(String[] args) throws Exception {

        ClientDemo clientDemo = new ClientDemo();
//        clientDemo.hello();
//        clientDemo.clientStream();
//        clientDemo.serverStream();
        clientDemo.allStream();
    }

    /**
     * 基于gRPC框架的使用步骤，进行远程调用
     */
    public void hello() throws InterruptedException {

        // 基于访问地址 创建通道
        Channel channel = ManagedChannelBuilder.forAddress("localhost", 10011).usePlaintext().build();
        // 同步阻塞存根
        HelloGrpc.HelloBlockingStub helloBlockingStub = HelloGrpc.newBlockingStub(channel);

        HelloRequest helloRequest = HelloRequest.newBuilder().setName("zhang_san_end").build();

        // 同步阻塞存根
        HelloResponse helloResponse = helloBlockingStub.hello(helloRequest);
        System.out.println("hello receive resp:" + helloResponse);

    }

    public void clientStream() throws InterruptedException {

        // 基于访问地址 创建通道
        Channel channel = ManagedChannelBuilder.forAddress("localhost", 10011).usePlaintext().build();

        // 异步非阻塞存根
        HelloGrpc.HelloStub helloStub = HelloGrpc.newStub(channel);

        System.out.println("clientStream");

        // 客户端流式
        final CountDownLatch finishLatch = new CountDownLatch(1);
        StreamObserver<HelloRequest> helloRequestStreamObserver = helloStub.clientStream(new StreamObserver<HelloResponse>() {
            @Override
            public void onNext(HelloResponse helloResponse) {
                String message = helloResponse.getMessage();
                System.out.println("clientStream receive clientStream data:" + message);
                onCompleted();
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("clientStream receive onError");
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("clientStream receive onCompleted");
                finishLatch.countDown();
            }
        });

        // 客户端多次请求
        String[] split = "zhang_san_end".split("_");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            HelloRequest helloRequest = HelloRequest.newBuilder().setName(s).build();
            helloRequestStreamObserver.onNext(helloRequest);
        }
        helloRequestStreamObserver.onCompleted();
        // 等待直到收到响应或超时
        finishLatch.await(10, TimeUnit.SECONDS);

    }

    public void serverStream() throws InterruptedException {

        // 基于访问地址 创建通道
        Channel channel = ManagedChannelBuilder.forAddress("localhost", 10011).usePlaintext().build();
        // 同步阻塞存根
        HelloGrpc.HelloBlockingStub helloBlockingStub = HelloGrpc.newBlockingStub(channel);

        HelloRequest helloRequest = HelloRequest.newBuilder().setName("zhang_san_end").build();

        // 服务端流式
        Iterator<HelloResponse> helloResponseIterator = helloBlockingStub.serverStream(helloRequest);

        helloResponseIterator.forEachRemaining(resp -> {
            System.out.println("receive serverStream data:" + resp);
        });

    }

    public void allStream() throws InterruptedException {

        // 基于访问地址 创建通道
        Channel channel = ManagedChannelBuilder.forAddress("localhost", 10011).usePlaintext().build();
        // 异步非阻塞存根
        HelloGrpc.HelloStub helloStub = HelloGrpc.newStub(channel);

        final CountDownLatch finishLatch = new CountDownLatch(1);
        StreamObserver<HelloRequest> helloRequestStreamObserver = helloStub.allStream(new StreamObserver<HelloResponse>() {
            @Override
            public void onNext(HelloResponse helloResponse) {
                System.out.println("allStream onNext");
                String message = helloResponse.getMessage();
                System.out.println("receive clientStream data:" + message);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("allStream onError");
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("allStream onCompleted");
                finishLatch.countDown();
            }
        });

        // 客户端多次请求
        String[] split = "zhang_san_end".split("_");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            HelloRequest helloRequest = HelloRequest.newBuilder().setName(s).build();
            helloRequestStreamObserver.onNext(helloRequest);
        }
        helloRequestStreamObserver.onCompleted();
        // 等待直到收到响应或超时
        finishLatch.await(10, TimeUnit.SECONDS);

    }

}
