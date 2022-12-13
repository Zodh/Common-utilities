package io.github.zodh.http;

import java.util.Map;
import org.springframework.http.HttpMethod;

public class RequestData {

  private String host;

  private String resource;

  private String query;

  private Object body;

  private Map<String, String> headers;

  private Boolean async;

  private HttpMethod httpMethod;

  private Class<?> expectedResponseType;

  public RequestData(String host, String resource, String query, Object body,
      Map<String, String> headers, Boolean async, HttpMethod httpMethod,
      Class<?> expectedResponseType) {
    this.host = host;
    this.resource = resource;
    this.query = query;
    this.body = body;
    this.headers = headers;
    this.async = async;
    this.httpMethod = httpMethod;
    this.expectedResponseType = expectedResponseType;
  }

  public RequestData() {

  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public Object getBody() {
    return body;
  }

  public void setBody(Object body) {
    this.body = body;
  }

  public Map<String, String> getHeaders() {
    return headers;
  }

  public void setHeaders(Map<String, String> headers) {
    this.headers = headers;
  }

  public Boolean getAsync() {
    return async;
  }

  public void setAsync(Boolean async) {
    this.async = async;
  }

  public HttpMethod getHttpMethod() {
    return httpMethod;
  }

  public void setHttpMethod(HttpMethod httpMethod) {
    this.httpMethod = httpMethod;
  }

  public Class<?> getExpectedResponseType() {
    return expectedResponseType;
  }

  public void setExpectedResponseType(Class<?> expectedResponseType) {
    this.expectedResponseType = expectedResponseType;
  }

}
