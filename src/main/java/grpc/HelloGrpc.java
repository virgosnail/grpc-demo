package grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.*;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.*;

/**
 * <pre>
 * 定义服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.31.1)",
    comments = "Source: hello.proto")
public final class HelloGrpc {

  private HelloGrpc() {}

  public static final String SERVICE_NAME = "hello.Hello";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<HelloRequest,
      HelloResponse> getHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "hello",
      requestType = HelloRequest.class,
      responseType = HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<HelloRequest,
      HelloResponse> getHelloMethod() {
    io.grpc.MethodDescriptor<HelloRequest, HelloResponse> getHelloMethod;
    if ((getHelloMethod = HelloGrpc.getHelloMethod) == null) {
      synchronized (HelloGrpc.class) {
        if ((getHelloMethod = HelloGrpc.getHelloMethod) == null) {
          HelloGrpc.getHelloMethod = getHelloMethod =
              io.grpc.MethodDescriptor.<HelloRequest, HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "hello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloMethodDescriptorSupplier("hello"))
              .build();
        }
      }
    }
    return getHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<HelloRequest,
      HelloResponse> getClientStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "clientStream",
      requestType = HelloRequest.class,
      responseType = HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<HelloRequest,
      HelloResponse> getClientStreamMethod() {
    io.grpc.MethodDescriptor<HelloRequest, HelloResponse> getClientStreamMethod;
    if ((getClientStreamMethod = HelloGrpc.getClientStreamMethod) == null) {
      synchronized (HelloGrpc.class) {
        if ((getClientStreamMethod = HelloGrpc.getClientStreamMethod) == null) {
          HelloGrpc.getClientStreamMethod = getClientStreamMethod =
              io.grpc.MethodDescriptor.<HelloRequest, HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "clientStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloMethodDescriptorSupplier("clientStream"))
              .build();
        }
      }
    }
    return getClientStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<HelloRequest,
      HelloResponse> getServerStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "serverStream",
      requestType = HelloRequest.class,
      responseType = HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<HelloRequest,
      HelloResponse> getServerStreamMethod() {
    io.grpc.MethodDescriptor<HelloRequest, HelloResponse> getServerStreamMethod;
    if ((getServerStreamMethod = HelloGrpc.getServerStreamMethod) == null) {
      synchronized (HelloGrpc.class) {
        if ((getServerStreamMethod = HelloGrpc.getServerStreamMethod) == null) {
          HelloGrpc.getServerStreamMethod = getServerStreamMethod =
              io.grpc.MethodDescriptor.<HelloRequest, HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "serverStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloMethodDescriptorSupplier("serverStream"))
              .build();
        }
      }
    }
    return getServerStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<HelloRequest,
      HelloResponse> getAllStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "allStream",
      requestType = HelloRequest.class,
      responseType = HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<HelloRequest,
      HelloResponse> getAllStreamMethod() {
    io.grpc.MethodDescriptor<HelloRequest, HelloResponse> getAllStreamMethod;
    if ((getAllStreamMethod = HelloGrpc.getAllStreamMethod) == null) {
      synchronized (HelloGrpc.class) {
        if ((getAllStreamMethod = HelloGrpc.getAllStreamMethod) == null) {
          HelloGrpc.getAllStreamMethod = getAllStreamMethod =
              io.grpc.MethodDescriptor.<HelloRequest, HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "allStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloMethodDescriptorSupplier("allStream"))
              .build();
        }
      }
    }
    return getAllStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HelloStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloStub>() {
        @Override
        public HelloStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloStub(channel, callOptions);
        }
      };
    return HelloStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HelloBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloBlockingStub>() {
        @Override
        public HelloBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloBlockingStub(channel, callOptions);
        }
      };
    return HelloBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HelloFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloFutureStub>() {
        @Override
        public HelloFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloFutureStub(channel, callOptions);
        }
      };
    return HelloFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 定义服务
   * </pre>
   */
  public static abstract class HelloImplBase implements io.grpc.BindableService {

    /**
     */
    public void hello(HelloRequest request,
                      io.grpc.stub.StreamObserver<HelloResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getHelloMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<HelloRequest> clientStream(
        io.grpc.stub.StreamObserver<HelloResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getClientStreamMethod(), responseObserver);
    }

    /**
     */
    public void serverStream(HelloRequest request,
                             io.grpc.stub.StreamObserver<HelloResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getServerStreamMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<HelloRequest> allStream(
        io.grpc.stub.StreamObserver<HelloResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAllStreamMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                HelloRequest,
                HelloResponse>(
                  this, METHODID_HELLO)))
          .addMethod(
            getClientStreamMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                HelloRequest,
                HelloResponse>(
                  this, METHODID_CLIENT_STREAM)))
          .addMethod(
            getServerStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                HelloRequest,
                HelloResponse>(
                  this, METHODID_SERVER_STREAM)))
          .addMethod(
            getAllStreamMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                HelloRequest,
                HelloResponse>(
                  this, METHODID_ALL_STREAM)))
          .build();
    }
  }

  /**
   * <pre>
   * 定义服务
   * </pre>
   */
  public static final class HelloStub extends io.grpc.stub.AbstractAsyncStub<HelloStub> {
    private HelloStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected HelloStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloStub(channel, callOptions);
    }

    /**
     */
    public void hello(HelloRequest request,
                      io.grpc.stub.StreamObserver<HelloResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<HelloRequest> clientStream(
        io.grpc.stub.StreamObserver<HelloResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getClientStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void serverStream(HelloRequest request,
                             io.grpc.stub.StreamObserver<HelloResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getServerStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<HelloRequest> allStream(
        io.grpc.stub.StreamObserver<HelloResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getAllStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * 定义服务
   * </pre>
   */
  public static final class HelloBlockingStub extends io.grpc.stub.AbstractBlockingStub<HelloBlockingStub> {
    private HelloBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected HelloBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloBlockingStub(channel, callOptions);
    }

    /**
     */
    public HelloResponse hello(HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<HelloResponse> serverStream(
        HelloRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getServerStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 定义服务
   * </pre>
   */
  public static final class HelloFutureStub extends io.grpc.stub.AbstractFutureStub<HelloFutureStub> {
    private HelloFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected HelloFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<HelloResponse> hello(
        HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HELLO = 0;
  private static final int METHODID_SERVER_STREAM = 1;
  private static final int METHODID_CLIENT_STREAM = 2;
  private static final int METHODID_ALL_STREAM = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HelloImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HelloImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HELLO:
          serviceImpl.hello((HelloRequest) request,
              (io.grpc.stub.StreamObserver<HelloResponse>) responseObserver);
          break;
        case METHODID_SERVER_STREAM:
          serviceImpl.serverStream((HelloRequest) request,
              (io.grpc.stub.StreamObserver<HelloResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CLIENT_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.clientStream(
              (io.grpc.stub.StreamObserver<HelloResponse>) responseObserver);
        case METHODID_ALL_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.allStream(
              (io.grpc.stub.StreamObserver<HelloResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HelloBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HelloBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return HelloMessage.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Hello");
    }
  }

  private static final class HelloFileDescriptorSupplier
      extends HelloBaseDescriptorSupplier {
    HelloFileDescriptorSupplier() {}
  }

  private static final class HelloMethodDescriptorSupplier
      extends HelloBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HelloMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HelloGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HelloFileDescriptorSupplier())
              .addMethod(getHelloMethod())
              .addMethod(getClientStreamMethod())
              .addMethod(getServerStreamMethod())
              .addMethod(getAllStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
