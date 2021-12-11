package com.artglorin.articles.keepgenericinfo.naive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class DeserializerImpl implements Deserializer {
  
  @Override
  public <T> T deserialize(
      String source,
      Class<T> type
  ) {
    Objects.requireNonNull(source, "source");
    Objects.requireNonNull(type, "type");
    if (List.class == type) {
      return type.cast(new ArrayList<T>());
    }
    throw new IllegalArgumentException("Unsupported type: " + type);
  }
  
  @Override
  public <T> List<T> deserializeList(
      String source,
      Class<T> type
  ) {
    Objects.requireNonNull(source, "source");
    Objects.requireNonNull(type, "type");
    if (Long.class == type) {
      return ((List<T>) Arrays.stream(source.split(","))
                              .map(Long::valueOf)
                              .collect(Collectors.toList()));
    }
    throw new IllegalArgumentException("Unsupported type: " + type);
  }
  
  @Override
  public <T, U> T deserializeContainer(
      String source,
      Class<T> container,
      Class<U> value
  ) {
    throw new UnsupportedOperationException(
        "Method com.artglorin.articles.keepgenericinfo.naive.DeserializerImpl.deserializeContainer is not implemented" +
            " yet.");
  }
  
}
