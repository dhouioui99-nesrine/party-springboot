package com.example.IntegrationAPI.Base3.auth;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AuthenticationResponse {

  private String accessToken;
  private String refreshToken;
  private boolean mfaEnabled;
  private String secretImageUri;
  private List<String> roles;

  public AuthenticationResponse() {
  }

  public AuthenticationResponse(String accessToken, String refreshToken, boolean mfaEnabled, String secretImageUri, List<String> roles) {
    this.accessToken = accessToken;
    this.refreshToken = refreshToken;
    this.mfaEnabled = mfaEnabled;
    this.secretImageUri = secretImageUri;
    this.roles=roles;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public boolean isMfaEnabled() {
    return mfaEnabled;
  }

  public void setMfaEnabled(boolean mfaEnabled) {
    this.mfaEnabled = mfaEnabled;
  }

  public String getSecretImageUri() {
    return secretImageUri;
  }

  public void setSecretImageUri(String secretImageUri) {
    this.secretImageUri = secretImageUri;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }
}
