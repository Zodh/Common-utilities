package io.github.zodh.http;

import java.util.Objects;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class BasicHttpWithResponseImpl implements HttpWithResponse {

  /**
   * @param requestData
   * @return an instance of {@link Object} based on requestData.expectedResponseType or
   * {@link reactor.core.Disposable} if async is true.
   */
  @Override
  public Object execute(RequestData requestData) {
    var webClient = retrieveWebClient(requestData);
    var requestBodyUriSpec = webClient.method(requestData.getHttpMethod());
    var requestBodySpec = requestBodyUriSpec.uri(requestData.getResource());
    var requestHeadersSpec = requestBodySpec.bodyValue(requestData.getBody());
    var response = requestHeadersSpec.retrieve().bodyToMono(requestData.getExpectedResponseType());
    return (requestData.getAsync()) ? response.subscribe() : response.block();
  }

  public WebClient retrieveWebClient(RequestData requestData) {
    return WebClient
        .builder()
        .baseUrl(requestData.getHost())
        .defaultHeaders(httpHeaders -> Objects.requireNonNull(requestData.getHeaders())
            .forEach(httpHeaders::set))
        .build();
  }
}
