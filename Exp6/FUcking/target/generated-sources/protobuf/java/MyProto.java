// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Network.proto

public final class MyProto {
  private MyProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Testgrpc_Request_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Testgrpc_Request_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Testgrpc_Reply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Testgrpc_Reply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rNetwork.proto\022\010Testgrpc\"\035\n\007Request\022\022\n\n" +
      "clientName\030\001 \001(\t\"\030\n\005Reply\022\017\n\007message\030\001 \001" +
      "(\t2;\n\007Network\0220\n\010CallBack\022\021.Testgrpc.Req" +
      "uest\032\017.Testgrpc.Reply\"\000B\022\n\000B\007MyProtoP\001\242\002" +
      "\002MYb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Testgrpc_Request_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Testgrpc_Request_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Testgrpc_Request_descriptor,
        new java.lang.String[] { "ClientName", });
    internal_static_Testgrpc_Reply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Testgrpc_Reply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Testgrpc_Reply_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
