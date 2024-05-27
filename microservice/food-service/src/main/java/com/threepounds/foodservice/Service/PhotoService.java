package com.threepounds.foodservice.Service;

import com.threepounds.foodservice.data.entity.Photo;
import com.threepounds.foodservice.data.repository.PhotoRepository;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Photo save(Photo photo){
        return photoRepository.save(photo);
    }




}