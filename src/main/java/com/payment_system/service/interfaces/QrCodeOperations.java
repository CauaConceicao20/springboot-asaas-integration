package com.payment_system.service.interfaces;

import java.nio.file.Path;

public interface QrCodeOperations {

    Path generateQrCodeImage(String encoder, String id);
}
