package br.com.brunoedubems.movieflix.mapper;

import br.com.brunoedubems.movieflix.controller.request.CategoryRequest;
import br.com.brunoedubems.movieflix.controller.request.StreamingRequest;
import br.com.brunoedubems.movieflix.controller.response.CategoryResponse;
import br.com.brunoedubems.movieflix.controller.response.StreamingResponse;
import br.com.brunoedubems.movieflix.entity.Category;
import br.com.brunoedubems.movieflix.entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest streamingRequest) {
        return Streaming.builder()
                .name(streamingRequest.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming) {
        return StreamingResponse.builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}
