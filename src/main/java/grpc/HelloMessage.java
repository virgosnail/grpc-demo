// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hello.proto

package grpc;

public final class HelloMessage {
  private HelloMessage() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_hello_HelloRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_hello_HelloRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_hello_HelloResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_hello_HelloResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\013hello.proto\022\005hello\"\034\n\014HelloRequest\022\014\n\004" +
      "name\030\001 \001(\t\" \n\rHelloResponse\022\017\n\007message\030\001" +
      " \001(\t2\371\001\n\005Hello\0224\n\005hello\022\023.hello.HelloReq" +
      "uest\032\024.hello.HelloResponse\"\000\022=\n\014clientSt" +
      "ream\022\023.hello.HelloRequest\032\024.hello.HelloR" +
      "esponse\"\000(\001\022=\n\014serverStream\022\023.hello.Hell" +
      "oRequest\032\024.hello.HelloResponse\"\0000\001\022<\n\tal" +
      "lStream\022\023.hello.HelloRequest\032\024.hello.Hel" +
      "loResponse\"\000(\0010\001B\026\n\004grpcB\014HelloMessageP\001" +
      "b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_hello_HelloRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_hello_HelloRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_hello_HelloRequest_descriptor,
        new String[] { "Name", });
    internal_static_hello_HelloResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_hello_HelloResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_hello_HelloResponse_descriptor,
        new String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
