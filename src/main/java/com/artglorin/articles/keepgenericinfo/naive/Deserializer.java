package com.artglorin.articles.keepgenericinfo.naive;

import java.util.List;

public interface Deserializer {
  
  <T> T deserialize(
      String source,
      Class<T> type
  );
  
  <T> List<T> deserializeList(
      String source,
      Class<T> type
  );
  
  <T, U> T deserializeContainer(
      String source,
      Class<T> container,
      Class<U> value
  );
  
}
