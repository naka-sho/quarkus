package org.my.hobby.repository;

import java.awt.image.BufferedImage;

public interface ImageConvertRepository {

    String convert(BufferedImage image, String pathname);
}
