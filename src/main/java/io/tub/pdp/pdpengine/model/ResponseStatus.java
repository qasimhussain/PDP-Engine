package io.tub.pdp.pdpengine.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseStatus<T> {
  private String code;
  private String message;
  private T body;

  public ResponseStatus() {
  }

  public ResponseStatus(String code) {
    this.code = code;
  }

  public ResponseStatus(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public ResponseStatus(String code, T body) {
    this.code = code;
    this.body = body;
  }

  public ResponseStatus(String code, String message, T body) {
    this.code = code;
    this.message = message;
    this.body = body;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getBody() {
    return body;
  }

  public void setBody(T body) {
    this.body = body;
  }

  public static <T> ResponseStatus<T> all(String code, String message, T body) {
    ResponseStatus<T> r = new ResponseStatus<T>();

    r.setBody(body);
    r.setCode(code);
    r.setMessage(message);

    return r;
  }

  public static <T> ResponseStatus<T> all(String code, T body) {
    return all(code, null, body);
  }

  public static <T> ResponseStatus<T> body(T body) {
    ResponseStatus<T> r = new ResponseStatus<T>();
    r.setBody(body);
    return r;
  }

  public static <T> ResponseStatus<T> code(String code) {
    ResponseStatus<T> r = new ResponseStatus<T>();
    r.setCode(code);
    return r;
  }

  public static <T> ResponseStatus<T> code(String code, String message) {
    ResponseStatus<T> r = new ResponseStatus<T>();
    r.setCode(code);
    r.setMessage(message);
    return r;
  }
}
