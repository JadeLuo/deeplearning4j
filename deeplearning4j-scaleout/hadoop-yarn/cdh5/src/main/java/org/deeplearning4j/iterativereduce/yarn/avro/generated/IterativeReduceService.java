/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package org.deeplearning4j.iterativereduce.yarn.avro.generated;

@SuppressWarnings("all")
public interface IterativeReduceService {
  public static final org.apache.avro.Protocol PROTOCOL = org.apache.avro.Protocol.parse("{\"protocol\":\"IterativeReduceService\",\"namespace\":\"com.cloudera.org.deeplearning4j.iterativereduce.yarn.avro.generated\",\"types\":[{\"type\":\"fixed\",\"name\":\"WorkerId\",\"size\":32},{\"type\":\"record\",\"name\":\"FileSplit\",\"fields\":[{\"name\":\"path\",\"type\":\"string\"},{\"name\":\"offset\",\"type\":\"long\"},{\"name\":\"length\",\"type\":\"long\"}]},{\"type\":\"record\",\"name\":\"StartupConfiguration\",\"fields\":[{\"name\":\"split\",\"type\":\"FileSplit\"},{\"name\":\"iterations\",\"type\":\"int\"},{\"name\":\"batchSize\",\"type\":\"int\"},{\"name\":\"other\",\"type\":[{\"type\":\"map\",\"values\":\"string\"},\"null\"]}]},{\"type\":\"record\",\"name\":\"ProgressReport\",\"fields\":[{\"name\":\"workerId\",\"type\":\"WorkerId\"},{\"name\":\"report\",\"type\":{\"type\":\"map\",\"values\":\"string\"}}]},{\"type\":\"error\",\"name\":\"ServiceError\",\"fields\":[{\"name\":\"description\",\"type\":[\"null\",\"string\"]}]}],\"messages\":{\"startup\":{\"request\":[{\"name\":\"workerId\",\"type\":\"WorkerId\"}],\"response\":\"StartupConfiguration\",\"errors\":[\"ServiceError\"]},\"progress\":{\"request\":[{\"name\":\"workerId\",\"type\":\"WorkerId\"},{\"name\":\"report\",\"type\":[\"ProgressReport\",\"null\"]}],\"response\":\"boolean\"},\"update\":{\"request\":[{\"name\":\"workerId\",\"type\":\"WorkerId\"},{\"name\":\"data\",\"type\":\"bytes\"}],\"response\":\"boolean\"},\"waiting\":{\"request\":[{\"name\":\"workerId\",\"type\":\"WorkerId\"},{\"name\":\"lastUpdate\",\"type\":\"int\"},{\"name\":\"waiting\",\"type\":\"long\"}],\"response\":\"int\"},\"fetch\":{\"request\":[{\"name\":\"workerId\",\"type\":\"WorkerId\"},{\"name\":\"updateId\",\"type\":\"int\"}],\"response\":\"bytes\"},\"complete\":{\"request\":[{\"name\":\"workerId\",\"type\":\"WorkerId\"},{\"name\":\"finalReport\",\"type\":\"ProgressReport\"}],\"response\":\"null\",\"one-way\":true},\"error\":{\"request\":[{\"name\":\"workerId\",\"type\":\"WorkerId\"},{\"name\":\"message\",\"type\":\"string\"}],\"response\":\"null\",\"one-way\":true},\"metricsReport\":{\"request\":[{\"name\":\"workerId\",\"type\":\"WorkerId\"},{\"name\":\"metrics\",\"type\":{\"type\":\"map\",\"values\":\"long\"}}],\"response\":\"null\",\"one-way\":true}}}");
  StartupConfiguration startup(WorkerId workerId) throws org.apache.avro.AvroRemoteException, ServiceError;
  boolean progress(WorkerId workerId, ProgressReport report) throws org.apache.avro.AvroRemoteException;
  boolean update(WorkerId workerId, java.nio.ByteBuffer data) throws org.apache.avro.AvroRemoteException;
  int waiting(WorkerId workerId, int lastUpdate, long waiting) throws org.apache.avro.AvroRemoteException;
  java.nio.ByteBuffer fetch(WorkerId workerId, int updateId) throws org.apache.avro.AvroRemoteException;
  void complete(WorkerId workerId, ProgressReport finalReport);
  void error(WorkerId workerId, CharSequence message);
  void metricsReport(WorkerId workerId, java.util.Map<CharSequence, Long> metrics);

  @SuppressWarnings("all")
  public interface Callback extends IterativeReduceService {
    public static final org.apache.avro.Protocol PROTOCOL = IterativeReduceService.PROTOCOL;
    void startup(WorkerId workerId, org.apache.avro.ipc.Callback<StartupConfiguration> callback) throws java.io.IOException;
    void progress(WorkerId workerId, ProgressReport report, org.apache.avro.ipc.Callback<Boolean> callback) throws java.io.IOException;
    void update(WorkerId workerId, java.nio.ByteBuffer data, org.apache.avro.ipc.Callback<Boolean> callback) throws java.io.IOException;
    void waiting(WorkerId workerId, int lastUpdate, long waiting, org.apache.avro.ipc.Callback<Integer> callback) throws java.io.IOException;
    void fetch(WorkerId workerId, int updateId, org.apache.avro.ipc.Callback<java.nio.ByteBuffer> callback) throws java.io.IOException;
  }
}