package org.my.hobby.service;

import org.my.hobby.repository.ImageConvertRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.image.BufferedImage;

@Singleton
public class ImageConvertServiceImpl implements ImageConvertService {

    @Inject
    ImageConvertRepository imageConvertRepository;

    @Override
    public String convert(BufferedImage image, String pathname) {
        return imageConvertRepository.convert(image, pathname);
    }
}
