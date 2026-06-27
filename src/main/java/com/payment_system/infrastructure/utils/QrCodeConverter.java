package com.payment_system.infrastructure.utils;

import com.payment_system.service.interfaces.QrCodeOperations;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Component
public class QrCodeConverter implements QrCodeOperations {

    private static final String OUTPUT_DIR = "qrcodes/";

    public Path generateQrCodeImage(String encodedImage, String chargeId) {
        try {
            byte[] imageBytes = Base64.getDecoder().decode(encodedImage);

            Path directory = Paths.get(OUTPUT_DIR);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            Path filePath = directory.resolve(chargeId + ".png");
            Files.write(filePath, imageBytes);

            return filePath;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao gerar imagem do QR Code", e);
        }
    }
}
