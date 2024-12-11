package org.nda.osp.dto;

import reactor.core.publisher.Mono;

public record ResponseDto (Mono<byte[]> content) {

}
