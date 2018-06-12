package com.bfs.service;

import org.springframework.web.multipart.MultipartFile;

public interface WaterService {
    void addWaterList(MultipartFile file) throws Exception;
}
