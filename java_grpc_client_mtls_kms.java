package com.google.cloud.kms.v1;

import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListCryptoKeyVersionsPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListCryptoKeysPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListImportJobsPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListKeyRingsPagedResponse;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.resourcenames.ResourceName;
import com.google.auth.Credentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.UserCredentials;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class sampleTest {
  static class MyCreds implements CredentialsProvider {

    @Override
    public Credentials getCredentials() throws IOException {
      InputStream stream = new FileInputStream(
          new File("/usr/local/google/home/sijunliu/wks/creds/mtls_user_cred.json"));
      UserCredentials creds = UserCredentials.fromStream(stream);
      return creds;
    }
  }

  @Test
  public void myTest() throws Exception {
    MyCreds provider = new MyCreds();
    KeyManagementServiceSettings settings = KeyManagementServiceSettings.newBuilder()
        .setEndpoint("cloudkms.mtls.googleapis.com:443").setCredentialsProvider(provider).build();
    KeyManagementServiceClient client = KeyManagementServiceClient.create(settings);
    String project = "projects/dcatest-281318/locations/global";
    // project = "projects/study-auth-265119/locations/global";

    ListKeyRingsPagedResponse resp = client.listKeyRings(project);
    List<KeyRing> resources = Lists.newArrayList(resp.iterateAll());
    System.out.println(resp);
  }
}
