package com.artglorin.articles.keepgenericinfo.naive;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("unchecked")
class DeserializerImplTest {
  
  private final Deserializer deserializer = new DeserializerImpl();
  
  @Test
  void deserializeList() {
    // ARRANGE
    var source = "1,2,3";
    
    // ACT
    List<Long> result = deserializer.deserialize(source, List.class);
    
    assertThat(result).isInstanceOf(List.class)
                      .hasSize(0);
  }
  
  @Test
  void deserializeLisOfLong() {
    // ARRANGE
    var source = "1,2,3";
    var expected = List.of(1L, 2L, 3L);
    
    // ACT
    
    List<Long> result = deserializer.deserializeList(source, Long.class);
    
    // ASSERTS
    
    assertThat(result).containsExactlyElementsOf(expected);
  }
  
}
